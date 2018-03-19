package ac.soton.compositionmodel.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.IEvent;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinDBStatusConstants;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.ICombinedEventInfo;
import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;

public class CombinedEventMachineSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	@Override
	protected EventBElement createEventBElement() {
		return CompositionmodelFactory.eINSTANCE.createCombinedEventMachine();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CompositionmodelPackage.eINSTANCE.getComposedEvent_CombinesEvents();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return ICombinedEventInfo.ELEMENT_TYPE;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}
	
	
	
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws CoreException {
		// create EMF node
		CombinedEventMachine eventBElement = (CombinedEventMachine) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof ICombinedEventInfo) {
			ICombinedEventInfo combinedEventMachine = (ICombinedEventInfo) rodinElement;
			
			IMachineRoot machine;
			IEvent event;
			
			try
			{
				machine = combinedEventMachine.getMachineRoot();
			}
			catch (RodinDBException e)
			{			
				if (e.getStatus().getCode() == IRodinDBStatusConstants.ATTRIBUTE_DOES_NOT_EXIST)
				{
					//	This means that someone pressed save when they didn't set a name for the machine
					return eventBElement;
				}	
				else
				{
					throw e;
				}
			}
			
			//	should be the project
			eventBElement.setProjectName(machine.getParent().getPath().segment(0));
			eventBElement.setMachineName(machine.getElementName());
			
			
			try
			{			
				event = combinedEventMachine.getCombinedEvent();
			}
			catch (RodinDBException e)
			{			
				if (e.getStatus().getCode() == IRodinDBStatusConstants.ATTRIBUTE_DOES_NOT_EXIST)
				{
					//	This means that someone pressed save when they didn't set a name for the event
					return eventBElement;
				}	
				else
				{
					throw e;
				}
			}
						
			eventBElement.setEventName(event.getElementName());		
		}
		return eventBElement;
	}
	
	
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws CoreException {

		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof ICombinedEventInfo && emfElement instanceof CombinedEventMachine) {
			ICombinedEventInfo rodinCombinedEventMachine = (ICombinedEventInfo) rodinElement;
			CombinedEventMachine eventBElement = (CombinedEventMachine) emfElement;
			

			String machineName = eventBElement.getMachineName();
			String eventName = eventBElement.getEventName();
			String projectName = eventBElement.getProjectName();
			
			if (machineName == null || eventName == null || projectName == null)
				return rodinElement;
					
			rodinCombinedEventMachine.setMachinePath("[" + projectName +  "]" +machineName, monitor);			
			rodinCombinedEventMachine.setCombinedEventName(eventName, monitor);	
		}
		return rodinElement;
	}

}
