package org.eventb.codegen.tasking.flattening;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IAction;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.core.IExtendsContext;
import org.eventb.core.IGuard;
import org.eventb.core.ILabeledElement;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IParameter;
import org.eventb.core.IRefinesEvent;
import org.eventb.core.IRefinesMachine;
import org.eventb.core.basis.EventBElement;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IElementType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class EventFlattenerUtils {

	private static final IInternalElement[] NO_ELEMENTS = new IInternalElement[0];

	// THIS IS A COPY OF THE org.eventb.ui Eventb utils class
	// But the ui EventBUtils class would need to be packaged as public for us
	// to use it !!

	/**
	 * Returns the children of the abstractions of the given event that are
	 * implicitly inherited through extension.
	 * <p>
	 * The children returned are sorted with the children of the most abstract
	 * event first. The order of children in each event is preserved.
	 * </p>
	 * 
	 * @param event
	 *            an event
	 * @return an array of all children that are implicitly inherited by the
	 *         given event through extension
	 * @throws RodinDBException
	 *             if some problems occurs
	 */
	public static IInternalElement[] getImplicitChildren(IEvent event)
			throws RodinDBException {
		if (!event.exists()) {
			return NO_ELEMENTS;
		}
		final LinkedList<IRodinElement> result = new LinkedList<IRodinElement>();
		while (event.hasExtended() && event.isExtended()) {
			event = getAbstractEvent(event);
			if (event == null) {
				// No abstraction!
				break;
			}
			setAttributes(result, event);
		}
		final int size = result.size();
		if (size == 0) {
			return NO_ELEMENTS;
		}
		return result.toArray(new IInternalElement[size]);
	}

	// up until this point we have copied the code from the EventBUtils class
	// in RodinCore. I document my changes.
	// Set attributes of the event
	// and return the result in the provided linked list
	public static void setAttributes(List<IRodinElement> result,
			IEvent event) throws RodinDBException {
		final IRodinElement[] children = event.getChildren();
		final int length = children.length;
		for (int i = length - 1; 0 <= i; --i) {
			final IRodinElement child = children[i];
			if (isInherited(child)) {
				// if the child is a parameter
				if (child instanceof IParameter) {
					applyDirectionAttribute(event, child);
				}
				else if(child instanceof IGuard){
					if(child instanceof EventBElement){
						EventBElement ch = (EventBElement) child;
						applyTypingAttribute(ch);
					}
				}
				result.add(0, child);
			}
		}
	}

	private static void applyTypingAttribute(EventBElement child) throws RodinDBException {
		Flattener.applyTypingAttribute(child);
	}

	private static void applyDirectionAttribute(IEvent event,
			final IRodinElement child) throws RodinDBException {
		IParameter p = (IParameter) child;
		// the parameter may be outgoing, in a guard's predicate
		String outPredicateFirst = p.getIdentifierString() + " =";
		String outPredicateAfter = "= " + p.getIdentifierString();
		// ... or incoming, in an action's assignment
		String parameterAssignment = CodeGenTaskingUtils.ASSIGNMENT_SYMBOL + " " + p.getIdentifierString();
		// retrieve the direction attribute
		IAttributeType.String directionAttribute = RodinCore
				.getStringAttrType(CodeGenTasking.PARAM_DIR_IDENT);
		// check to see if it has a direction attribute
		boolean hasDirectionAttribute = p.hasAttribute(CodeGenTasking.PARAM_DIR_ATTRIBUTE);
		// if not, add one
		if(!hasDirectionAttribute){
			p.setAttributeValue(directionAttribute, "undef", null);
		}
		
		// list the guards
		List<IGuard> guardList = Arrays.asList(event.getGuards());
		for (IGuard guard : guardList) {
			// get the predicate string of the guard
			String predicate = guard.getPredicateString();
			
			predicate = CodeGenTaskingUtils.makeSingleSpaceBetweenElements(predicate);
			// if it is a predicate starting or ending with the equality it is outgoing
			if (predicate.trim().startsWith(outPredicateFirst) || predicate.trim().endsWith(outPredicateAfter)) {
				p.setAttributeValue(directionAttribute, "Out", null);
				break;
			}
		}
		
		// list the actions
		List<IAction> actionList = Arrays.asList(event.getActions());
		for(IAction action: actionList){
			String assignment = action.getAssignmentString();
			// if the action ends with a parameter assignment it is incoming
			if(assignment.trim().endsWith(parameterAssignment)) {
				p.setAttributeValue(directionAttribute, "In", null);
				break;
			}		
		}
	}

	private static boolean isInherited(IRodinElement child) {
		IElementType<?> type = child.getElementType();
		return type == IParameter.ELEMENT_TYPE || type == IGuard.ELEMENT_TYPE
				|| type == IAction.ELEMENT_TYPE;
	}

	/**
	 * Gets the abstract event of an event. This is done by getting the abstract
	 * component and reading the refines event clause.
	 * 
	 * @param event
	 *            an input event
	 * @return the abstract event corresponding to the input event or
	 *         <code>null</code>. Returns <code>null</code> in the following
	 *         cases:
	 *         <ul>
	 *         <li>If the abstract machine does not exist.
	 *         <li>If there is no abstract machine corresponding to the file
	 *         contains the machine containing the input event.
	 *         <li>If there is no refines event child (except for
	 *         INITIALISATION).
	 *         <li>If there are more than one refines event child.
	 *         <li>if there is no abstract event corresponding to the refines
	 *         event clause.
	 *         </ul>
	 * @see #getAbstractMachine(IMachineRoot)
	 * @throws RodinDBException
	 *             if some problems occur in getting the abstract file or
	 *             reading the refines event child.
	 */
	public static IEvent getAbstractEvent(IEvent event) throws RodinDBException {
		final IRodinElement parent = event.getParent();
		assert parent instanceof IMachineRoot;

		final IMachineRoot abs = getAbstractMachine((IMachineRoot) parent);
		if (abs == null || !abs.exists()) {
			return null;
		}

		final IInternalElementType<IEvent> type = IEvent.ELEMENT_TYPE;
		final String label = getAbstractEventLabel(event);
		if (label == null) {
			return null;
		}
		return getFirstChildOfTypeWithLabel(abs, type, label);
	}

	private static String getAbstractEventLabel(IEvent event)
			throws RodinDBException {
		if (event.getLabel().equals(IEvent.INITIALISATION)) {
			return IEvent.INITIALISATION;
		}
		final IRefinesEvent[] refinesClauses = event.getRefinesClauses();
		if (refinesClauses.length == 1) {
			return refinesClauses[0].getAbstractEventLabel();
		}
		return null;
	}

	/**
	 * Gets the abstract machine of an event-B machine. This is done by checking
	 * the lists of refines machine clause of the input file. The input is
	 * assumed to be not <code>null</code>.
	 * 
	 * @param concrete
	 *            a Rodin File
	 * @return the abstract file corresponding to the input file. If there are
	 *         no refines machine or there are more than 1 refine machines then
	 *         <code>null</code> is returned. Otherwise, the handle to the file
	 *         corresponding the refine machine will be returned.
	 * @throws RodinDBException
	 *             if there are some problems in reading the refines machine
	 *             clause or in getting the abstract machine.
	 */
	public static IMachineRoot getAbstractMachine(IMachineRoot concrete)
			throws RodinDBException {
		final IRodinElement[] refines = concrete.getRefinesClauses();
		if (refines.length == 1) {
			final IRefinesMachine refine = (IRefinesMachine) refines[0];
			if (!refine.hasAbstractMachineName())
				return null;
			final String name = refine.getAbstractMachineName();
			return concrete.getEventBProject().getMachineRoot(name);
		}
		return null;
	}

	/**
	 * Returns the contexts which are extended by a given context. This is done
	 * by checking the lists of extends context clause of the context root
	 * element.
	 * 
	 * @param concrete
	 *            a context root element
	 * @return the root elements of the contexts that are extended
	 * @throws RodinDBException
	 *             if there is any problem in reading the extends context clause
	 *             or in getting the abstract context.
	 */
	public static IContextRoot[] getAbstractContexts(IContextRoot concrete)
			throws RodinDBException {
		final List<IContextRoot> result = new ArrayList<IContextRoot>();
		final IEventBProject prj = concrete.getEventBProject();
		for (final IExtendsContext clause : concrete.getExtendsClauses()) {
			if (clause.hasAbstractContextName()) {
				final String name = clause.getAbstractContextName();
				result.add(prj.getContextRoot(name));
			}
		}
		return result.toArray(new IContextRoot[result.size()]);
	}

	/**
	 * Get the first child of an input parent having the specified type and
	 * label.
	 * 
	 * @param <T>
	 *            an internal element class (i.e. extends
	 *            {@link IInternalElement}.
	 * @param parent
	 *            the internal parent ({@link IInternalElement}).
	 * @param type
	 *            the type of the child ({@link IInternalElementType}).
	 * @param label
	 *            the label of the child that we are looking for.
	 * @return the child of the input parent with the input type and having the
	 *         label as the input label.
	 * @throws RodinDBException
	 *             if some problems occur in getting the list of child elements
	 *             or the label attributes of child elements.
	 */
	private static <T extends ILabeledElement> T getFirstChildOfTypeWithLabel(
			IInternalElement parent, IInternalElementType<T> type, String label)
			throws RodinDBException {
		for (T child : parent.getChildrenOfType(type)) {
			if (child.hasAttribute(EventBAttributes.LABEL_ATTRIBUTE)
					&& label.equals(child.getLabel()))
				return child;
		}
		return null;
	}

	/**
	 * Returns a non already used String index intended to be concatenated to
	 * the name or the attribute of an element.
	 * 
	 * @param parent
	 *            the parent node to be looked for
	 * @param type
	 *            the type of the element to be looked for
	 * @param attributeType
	 *            the type of the attribute to be looked for. Set to
	 *            <code>null</code> if the element name should be considered
	 *            rather than, an attribute value
	 * @param prefix
	 *            the prefix of the element to be looked for
	 * @return a non already used integer index intended to be concatenated to
	 *         the name or the attribute of an element (if no element of that
	 *         type already exists, returns beginIndex)
	 * @throws RodinDBException
	 */
	public static String getFreePrefixIndex(IInternalElement parent,
			IInternalElementType<?> type, IAttributeType.String attributeType,
			String prefix) throws RodinDBException {

		return getFreePrefixIndex(getVisibleChildrenOfType(parent, type),
				attributeType, prefix);
	}

	/**
	 * Returns a non already used String index intended to be concatenated to
	 * the name or the attribute of an element.
	 * 
	 * @param elements
	 *            the elements to be looked for
	 * @param attributeType
	 *            the type of the attribute to be looked for. Set to
	 *            <code>null</code> if the element name should be considered
	 *            rather than, an attribute value
	 * @param prefix
	 *            the prefix of the element to be looked for
	 * @return a non already used integer index intended to be concatenated to
	 *         the name or the attribute of an element (if no element of that
	 *         type already exists, returns beginIndex)
	 * @throws RodinDBException
	 */
	public static String getFreePrefixIndex(
			List<? extends IInternalElement> elements,
			IAttributeType.String attributeType, String prefix)
			throws RodinDBException {

		final String regex = Pattern.quote(prefix) + "(\\d+)"; //$NON-NLS-1$
		final Pattern prefixDigits = Pattern.compile(regex);
		final MaxFinder maxFinder = new BigMaxFinder();
		for (IInternalElement element : elements) {
			final String elementString;
			if (attributeType == null) {
				// name research
				elementString = element.getElementName();
			} else if (element.hasAttribute(attributeType)) {
				// attribute research
				elementString = element.getAttributeValue(attributeType);
			} else {
				elementString = null;
			}

			if (elementString != null) {
				final Matcher matcher = prefixDigits.matcher(elementString);
				if (matcher.matches()) {
					maxFinder.insert(matcher.group(1));
				}
			}
		}
		return maxFinder.getAvailable();
	}

	public static <T extends IInternalElement> List<T> getVisibleChildrenOfType(
			IInternalElement parent, IInternalElementType<T> type)
			throws RodinDBException {
		final List<T> result = new ArrayList<T>();
		addImplicitChildrenOfType(result, parent, type);
		result.addAll(Arrays.asList(parent.getChildrenOfType(type)));
		return result;
	}

	public static <T extends IInternalElement> void addImplicitChildrenOfType(
			List<T> result, IInternalElement parent,
			IInternalElementType<T> type) throws RodinDBException {
		if (parent instanceof IEvent) {
			final IInternalElement[] implicitChildren = getImplicitChildren((IEvent) parent);
			for (IInternalElement child : implicitChildren) {
				final T typedChild = asOfType(child, type);
				if (typedChild != null) {
					result.add(typedChild);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends IInternalElement> T asOfType(
			IInternalElement element, IInternalElementType<T> type) {
		if (element.getElementType() == type) {
			return (T) element;
		}
		return null;
	}

	public static abstract class MaxFinder {

		/**
		 * Inserts a number given in string format.
		 * 
		 * @param number
		 *            a string of decimal digits.
		 */
		public abstract void insert(String number);

		/**
		 * Returns a number which was not inserted previously as a string of
		 * decimal digits. Currently, returns the maximum of the inserted
		 * numbers plus one (or one if no number was inserted).
		 * 
		 * @return an available number
		 */
		public abstract String getAvailable();
	}

	public static class BigMaxFinder extends MaxFinder {

		BigInteger max = BigInteger.ZERO;

		@Override
		public void insert(String number) {
			final BigInteger n = new BigInteger(number);
			if (max.compareTo(n) < 0) {
				max = n;
			}
		}

		@Override
		public String getAvailable() {
			return max.add(BigInteger.ONE).toString();
		}

	}

}
