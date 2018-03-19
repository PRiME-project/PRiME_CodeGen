package org.eventb.codegen.tasking.flattening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.core.IEvent;
import org.eventb.core.IInvariant;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IRefinesEvent;
import org.eventb.core.IVariable;
import org.eventb.core.basis.EventBElement;
import org.eventb.core.basis.MachineRoot;
import org.osgi.service.prefs.BackingStoreException;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IAttributeValue;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class Flattener {

	private static List<String> typedVariableNames = new ArrayList<String>();

	public void flatten(MachineRoot machineRoot) throws TaskingTranslationException, BackingStoreException, CoreException {
		// check the preferences, get the CG preference store
		IPreferenceStore prefererenceStore = CodeGenTasking.getDefault()
				.getPreferenceStore();

		boolean shouldFlatten = prefererenceStore
				.getBoolean(TaskingTranslationManager.getPrefFlatten());

		if (shouldFlatten) {
			// First we flatten the events by turning them from extended to not
			// extended
			List<IEvent> events = Arrays.asList(machineRoot
					.getChildrenOfType(IEvent.ELEMENT_TYPE));
			for (IEvent event : events) {
				flattenEvent(event);
				if(event instanceof EventBElement){
					EventBElement eventAsEventBElement = (EventBElement) event;
					eventAsEventBElement.setGenerated(false, null);
				}
				typedVariableNames.clear();
			}
			// We should delete existing flattened invariants....
			// ... and get invariants from the ancestors to add them to the flattened machine.
			List<IInvariant> existingInvariants = Arrays.asList(machineRoot
					.getChildrenOfType(IInvariant.ELEMENT_TYPE));

			for (IInvariant invariant : existingInvariants) {
				List<IAttributeValue> attributeValueList = Arrays
						.asList(invariant.getAttributeValues());
				// if we have a flattened attribute in the list of applicable
				// types ....
				// and if it's value is 'true' (i.e. flattened) ....
				// then delete the invariant.
				if (attributeValueList
						.contains(CodeGenTasking.FLATTENED_ATTRIBUTE)) {
					boolean flattened = invariant
							.getAttributeValue(CodeGenTasking.FLATTENED_ATTRIBUTE);
					if (flattened) {
						invariant.delete(true, null);
					}
				}
			}
			
			// ... and the same for variables
			List<IVariable> existingVariables = Arrays.asList(machineRoot
					.getChildrenOfType(IVariable.ELEMENT_TYPE));

			for (IVariable variable : existingVariables) {
				List<IAttributeValue> attributeValueList = Arrays
						.asList(variable.getAttributeValues());
				// if we have a flattened attribute in the list of applicable
				// types ....
				// and if it's value is 'true' (i.e. flattened) ....
				// then delete the invariant.
				if (attributeValueList
						.contains(CodeGenTasking.FLATTENED_ATTRIBUTE)) {
					boolean flattened = variable
							.getAttributeValue(CodeGenTasking.FLATTENED_ATTRIBUTE);
					if (flattened) {
						variable.delete(true, null);
					}
				}
			}
			
			// this code gets the invariants and inserts them into the
			// implementation machine
			flattenInvariants(machineRoot);
			
			List<IVariable> variableList = Arrays.asList(machineRoot.getVariables());
			for(IVariable variable: variableList){
				if(variable instanceof EventBElement){
					EventBElement variableAsEventBElement = (EventBElement) variable;
					variableAsEventBElement.setGenerated(false, null);
					variableAsEventBElement.setAttributeValue(CodeGenTasking.FLATTENED_ATTRIBUTE, true, null);
				}
			}

			IRodinFile rf = machineRoot.getRodinFile();
			rf.save(null, true);
			machineRoot.getResource().refreshLocal(IResource.DEPTH_INFINITE, null);
	
			// Set the <statemachine name>_STATES typing axiom
			new ContextHandler().handle(machineRoot);
		}
	}

	private void flattenInvariants(MachineRoot machineRoot)
			throws CoreException {
		// first we need to type the invariants of the current machine
		List<IInvariant> currentInvariants = Arrays.asList(machineRoot.getInvariants());
		for(IInvariant invariant: currentInvariants){
			if(invariant instanceof EventBElement){
				EventBElement invariantAsEventBElement = (EventBElement) invariant;
				applyTypingAttribute(invariantAsEventBElement);
				invariantAsEventBElement.setGenerated(false, null);
			}
		}
		
		
		final IInternalElement[] implicitChildren = InvariantFlattenerUtils
				.getImplicitChildren(machineRoot);
		if (implicitChildren.length == 0) {
			return;
		}
		insertImplicitChildren(implicitChildren, machineRoot);
	}

	public void flattenEvent(IEvent event) throws RodinDBException {

		final IInternalElement[] implicitChildren = EventFlattenerUtils
				.getImplicitChildren(event);
		event.setExtended(false, null);
		if (implicitChildren.length == 0) {
			// TODO IF there are no implicit children, then most likely, the event
			// has been manually set to not extended. In this case we still need to type and
			// set the parameter direction if no already done so
			
			List<IRodinElement> result = new ArrayList<IRodinElement>();
			EventFlattenerUtils.setAttributes(result , event);
			
			
			
			return;
		}
		insertImplicitChildren(implicitChildren, event);
	}

	// insert invariants into the machine
	private void insertImplicitChildren(IInternalElement[] implicitChildren,
			MachineRoot machineRoot) throws CoreException {
		for (IInternalElement implicit : implicitChildren) {
			if (implicit instanceof IInvariant) {
				IInvariant inv = (IInvariant) implicit;
				if (implicit instanceof EventBElement) {
					EventBElement invariantAsEventBElement = (EventBElement) implicit;
					// we must check to see if the invariant is already in the machine
					List<IInvariant> invariantList = Arrays.asList(machineRoot.getInvariants());
					List<String> invariantStrings = new ArrayList<String>();
					//trim strings
					for(IInvariant i : invariantList){
						invariantStrings.add(i.getPredicateString().trim());
					}
					if(invariantStrings.contains(invariantAsEventBElement.getPredicateString().trim())){
						// if the invariant is already in the machine then quit
						break;
					}
					// set the generated attribute so that it can be used in
					// code generation
					invariantAsEventBElement.setGenerated(false, null);
					// set the flattened attribute so that we can delete it
					// later
				
					invariantAsEventBElement.setAttributeValue(
							CodeGenTasking.FLATTENED_ATTRIBUTE, true, null);
					// add any typing predicates
					applyTypingAttribute(invariantAsEventBElement);
					
//					// If we do not have an ElementOf in the predicate then it
//					// is non typing.
//					// Else set the typing attribute if the LHS has not already
//					// been set.
//					// But first we can get the attribute info
//					IAttributeType.String typingAttribute = RodinCore
//							.getStringAttrType(CodeGenTasking.TYPING_ATTRIBUTE_IDENT);
//					// if the invariant has no typing attribute then we must add one
//					boolean hasTypingAttribute = invariantAsEventBElement.hasAttribute(CodeGenTasking.TYPING_ATTRIBUTE);
//					if(!hasTypingAttribute){
//						invariantAsEventBElement.setAttributeValue(typingAttribute, "undef", null);
//					}
//					
//					String predicateString = invariantAsEventBElement
//							.getPredicateString();
//					String typedVariableName = CodeGenTaskingUtils
//							.getTypedVariable(predicateString);
//					// Is there a typing attribute?
//					// Now, if there is no ElementOf, then it cannot be a typing
//					// invariant
//					if (!predicateString
//							.contains(CodeGenTaskingUtils.ELEMENT_OF)) {
//						invariantAsEventBElement.setAttributeValue(typingAttribute, "NonTyping", null);
//					}
//					// and where there is a typing invariant
//					else {
//						// has this already been typed? (i.e. in the list we are keeping).
//						// If so we do not set it as typing again.
//						if(typedVariableNames.contains(typedVariableName)){
//							//break;
//						}
//						else {
//							typedVariableNames.add(typedVariableName);
//							invariantAsEventBElement.setAttributeValue(typingAttribute, "Typing", null);
//						}
//					}

					final String name = getFreshName(inv, machineRoot);
					invariantAsEventBElement.copy(machineRoot, null, name, false, null);	
					invariantAsEventBElement.getResource().refreshLocal(IResource.DEPTH_INFINITE, null);
				}
			}
		}
	}

	
	public static void applyTypingAttribute(EventBElement eventBElement) throws RodinDBException{
		// If we do not have an ElementOf in the predicate then it
		// is non typing.
		// Else set the typing attribute if the LHS has not already
		// been set.
		// But first we can get the attribute info
		IAttributeType.String typingAttribute = RodinCore
				.getStringAttrType(CodeGenTasking.TYPING_ATTRIBUTE_IDENT);
		// if the invariant has no typing attribute then we must add one
		boolean hasTypingAttribute = eventBElement.hasAttribute(CodeGenTasking.TYPING_ATTRIBUTE);
		if(!hasTypingAttribute){
			eventBElement.setAttributeValue(typingAttribute, "undef", null);
		}
		
		String predicateString = eventBElement.getPredicateString();
		String typedVariableName = CodeGenTaskingUtils
				.getTypedVariable(predicateString);
		// Is there a typing attribute?
		// Now, if there is no ElementOf, then it cannot be a typing
		// invariant
		if (!predicateString
				.contains(CodeGenTaskingUtils.ELEMENT_OF)) {
			eventBElement.setAttributeValue(typingAttribute, "NonTyping", null);
		}
		// and where there is a typing invariant
		else {
			// has this already been typed? (i.e. in the list we are keeping).
			// If so we do not set it as typing again.
			if(typedVariableNames.contains(typedVariableName)){
				eventBElement.setAttributeValue(typingAttribute, "NonTyping", null);
			}
			else {
				typedVariableNames.add(typedVariableName);
				eventBElement.setAttributeValue(typingAttribute, "Typing", null);
			}
		}
	}
	
	
	// insert children into the event
	private void insertImplicitChildren(
			final IInternalElement[] implicitChildren, IEvent event)
			throws RodinDBException {
		final IRodinElement firstChild = getFirstChild(event);
		for (IInternalElement implicit : implicitChildren) {
			final String name = getFreshName(implicit, event);
			implicit.copy(event, firstChild, name, false, null);
		}
	}

	private IRodinElement getFirstChild(IEvent event) throws RodinDBException {
		for (IRodinElement child : event.getChildren()) {
			if (child.getElementType() != IRefinesEvent.ELEMENT_TYPE) {
				return child;
			}
		}
		return null;
	}

	// Get fresh name for an invariant.
	// Borrow the existing Event Flattener getFreeChildName method
	private String getFreshName(IInvariant implicit, IMachineRoot machineRoot)
			throws RodinDBException {
		final IInternalElementType<?> type = implicit.getElementType();
		final String name = implicit.getLabel();
		if (machineRoot.getInternalElement(type, name).exists()) {
			String newName = implicit.getParent().getElementName() + "_" + name;
			implicit.setLabel(newName, null);
			return newName;
		}
		return name;
	}

	// get fresh name for an event
	private String getFreshName(IInternalElement implicit, IEvent event)
			throws RodinDBException {
		final IInternalElementType<?> type = implicit.getElementType();
		final String name = implicit.getElementName();
		if (event.getInternalElement(type, name).exists()) {
			return getFreeChildName(event, type, "internal"); //$NON-NLS-1$
		}
		return name;
	}

	/**
	 * Get a free child name (internal name) for a new child element, given the
	 * parent element, the type of the child element and a proposed prefix for
	 * the name. A new unique name will be the prefix with a index appended to
	 * the end.
	 * 
	 * @param <T>
	 *            an internal element class (i.e. extends
	 *            {@link IInternalElement}.
	 * @param parent
	 *            the internal parent ({@link IInternalElement}).
	 * @param type
	 *            the type of the child ({@link IInternalElementType}).
	 * @param prefix
	 *            the proposed prefix for the child internal name.
	 * @return the new unique name for the child of the input parent which has
	 *         the input type.
	 * @throws RodinDBException
	 *             if some problems occur.
	 */
	public static <T extends IInternalElement> String getFreeChildName(
			IInternalElement parent, IInternalElementType<T> type, String prefix)
			throws RodinDBException {
		return prefix + getFreeChildNameIndex(parent, type, prefix);
	}

	/**
	 * Get a free index for a new child element, given the parent element, the
	 * type of the child element and a proposed prefix for the name. A new free
	 * index will be the index appended to so that the name by appending the
	 * index to the input prefix is also new. The index will be the smallest
	 * available index starting from the input beginIndex.
	 * 
	 * @param <T>
	 *            an internal element class (i.e. extends
	 *            {@link IInternalElement}.
	 * @param parent
	 *            the internal parent ({@link IInternalElement}).
	 * @param type
	 *            the type of the child ({@link IInternalElementType}).
	 * @param prefix
	 *            the proposed prefix for the child internal name.
	 * @return the new free index for the child of the input parent which has
	 *         the input type.
	 * @throws RodinDBException
	 *             if some problems occur.
	 */
	public static <T extends IInternalElement> String getFreeChildNameIndex(
			IInternalElement parent, IInternalElementType<T> type, String prefix)
			throws RodinDBException {
		return EventFlattenerUtils.getFreePrefixIndex(parent, type, null,
				prefix);
	}

}
