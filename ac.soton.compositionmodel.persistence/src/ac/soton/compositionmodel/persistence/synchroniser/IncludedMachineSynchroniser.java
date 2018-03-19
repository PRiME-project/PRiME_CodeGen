package ac.soton.compositionmodel.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinDBStatusConstants;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.IIncludeMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

public class IncludedMachineSynchroniser extends AbstractSynchroniser {
	
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	

	@Override
	protected EventBElement createEventBElement() {
		return CompositionmodelFactory.eINSTANCE.createIncludedMachine();
	}

	@Override
	protected EStructuralFeature getFeature() {		
		return CompositionmodelPackage.eINSTANCE.getComposedMachine_Includes();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IIncludeMachine.ELEMENT_TYPE;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}
	
	

	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws CoreException {
		// create EMF node
		IncludedMachine eventBElement = (IncludedMachine) super.load(rodinElement, emfParent, monitor);
		if (rodinElement instanceof IIncludeMachine) {
			IIncludeMachine includeMachine = (IIncludeMachine) rodinElement;
			
			try {
				includeMachine.getIncludedMachine();
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
			
			
			//	Breaks if there is no included machine
			IMachineRoot machine = includeMachine.getIncludedMachine();
						
			//	should be the project
			eventBElement.setProjectName(includeMachine.getIncludedProject().getElementName());
			
			eventBElement.setMachineName(machine.getElementName());
			
		}
		return eventBElement;
	}
	
	
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws CoreException {

		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		if (rodinElement instanceof IIncludeMachine && emfElement instanceof IncludedMachine) {
			IIncludeMachine rodinIncludedMachine = (IIncludeMachine) rodinElement;
			IncludedMachine eventBElement = (IncludedMachine) emfElement;
			

			String machineName = eventBElement.getMachineName();			
			String projectName = eventBElement.getProjectName();
								
			rodinIncludedMachine.setIncludedMachinePath(machineName, monitor);
			rodinIncludedMachine.setIncludedProjectName(projectName, monitor);			
		}
		return rodinElement;
	}
	
	
	
	
}
