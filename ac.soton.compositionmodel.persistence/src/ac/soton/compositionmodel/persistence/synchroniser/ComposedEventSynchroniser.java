package ac.soton.compositionmodel.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IConvergenceElement.Convergence;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.IComposesEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;

public class ComposedEventSynchroniser extends AbstractSynchroniser {

	public static final String INITIALISATION = "INITIALISATION";

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	static {
		handledAttributes.add(EventBAttributes.CONVERGENCE_ATTRIBUTE);
		handledAttributes.add(EventBAttributes.TARGET_ATTRIBUTE);		
	}
	
	@Override
	protected EventBElement createEventBElement() {
		return CompositionmodelFactory.eINSTANCE.createComposedEvent();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CompositionmodelPackage.eINSTANCE.getComposedMachine_ComposesEvents();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IComposesEvent.ELEMENT_TYPE;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws CoreException {
		// create EMF node
		ComposedEvent eventBElement = (ComposedEvent) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof IComposesEvent) {
			IComposesEvent event = (IComposesEvent) rodinElement;

			if (event.getConvergence() == Convergence.ORDINARY) {
				eventBElement.setConvergence(org.eventb.emf.core.machine.Convergence.ORDINARY);
			} else if (event.getConvergence() == Convergence.CONVERGENT) {
				eventBElement.setConvergence(org.eventb.emf.core.machine.Convergence.CONVERGENT);
			} else if (event.getConvergence() == Convergence.ANTICIPATED) {
				eventBElement.setConvergence(org.eventb.emf.core.machine.Convergence.ANTICIPATED);
			}

			// extends flag
			//	ComposesEvent does not extend anything
//			final boolean extended = event.isExtended();
//			eventBElement.setExtended(extended);

			// refines attribute
			EList<String> refinesNames = eventBElement.getRefinesNames();
//			if (extended && INITIALISATION.equals(event.getLabel())) {
				/*
				 * Grumble grumble, special cases...
				 * Workaround for bug / design decision
				 * http://sourceforge.net/tracker/?func=detail&atid=651669&aid=2810797&group_id=108850
				 */
//				refinesNames.add(INITIALISATION);
//			} else {
				for (ac.soton.composition.core.IRefinesEvent refinesEvent : event.getRefinesClauses()) {
					refinesNames.add(refinesEvent.getAbstractEventLabel());
				}
//			}
		}
		return eventBElement;
	}
	
	
	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws CoreException {

		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof IComposesEvent && emfElement instanceof ComposedEvent) {
			IComposesEvent rodinEvent = (IComposesEvent) rodinElement;
			ComposedEvent emfEvent = (ComposedEvent) emfElement;
			if (emfEvent.getConvergence() == org.eventb.emf.core.machine.Convergence.ORDINARY) {
				rodinEvent.setConvergence(Convergence.ORDINARY, monitor);
			} else if (emfEvent.getConvergence() == org.eventb.emf.core.machine.Convergence.CONVERGENT) {
				rodinEvent.setConvergence(Convergence.CONVERGENT, monitor);
			} else if (emfEvent.getConvergence() == org.eventb.emf.core.machine.Convergence.ANTICIPATED) {
				rodinEvent.setConvergence(Convergence.ANTICIPATED, monitor);
			}

// no extensions in ComposesEvent			
//			boolean extended = emfEvent.isExtended();
//			rodinEvent.setExtended(extended, monitor);

			EList<String> refinesNames = emfEvent.getRefinesNames();
//			if (extended && INITIALISATION.equals(emfEvent.getName())) {
//				if (refinesNames.size() > 0) {
					/*
					 * Grumble grumble, special cases...
					 * Workaround for bug / design decision
					 * http://sourceforge.net/tracker/?func=detail&atid=651669&aid=2810797&group_id=108850
					 * 
					 * Need to filter extended event name if it is INITIALISATION,
					 * otherwise we leave it to Rodin to complain about it.
					 */
//					final String extendsName = refinesNames.get(0);
//					if (!INITIALISATION.equals(extendsName)) {
//						IRefinesEvent refinesEvent = rodinEvent.getRefinesClause(getNewName());
//						refinesEvent.create(null, monitor);
//						refinesEvent.setAbstractEventLabel(extendsName, monitor);
//					}
//				}
//			} else {
				for (String refinesName : refinesNames) {
					ac.soton.composition.core.IRefinesEvent refinesEvent = rodinEvent.getRefinesClause(getNewName());
					refinesEvent.create(null, monitor);
					refinesEvent.setAbstractEventLabel(refinesName, monitor);
				}
//			}
		}
		return rodinElement;
	}
	
}
