package org.eventb.autoTaskMachine.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.IShared_Machine;
import org.eventb.tasking.persistence.synchroniser.MachineTypeSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Shared_Machine;
import tasking.Tasking_Machine;

public class Shared_MachineSynchroniser extends MachineTypeSynchroniser  {
	//private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	
	public Shared_MachineSynchroniser()
	{
		super();
	}
	
	//	Handled by MachineTypeSynchroniser
//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return IShared_Machine.ELEMENT_TYPE;
//	}
//
//	@Override
//	protected EStructuralFeature getFeature() {
//		return CorePackage.eINSTANCE.getEventBElement_Extensions();
//	}
//
//	@Override
//	protected Set<IAttributeType> getHandledAttributeTypes() {
//		return handledAttributes;
//	}
//
//	@Override
//	protected EventBElement createEventBElement() {
//		return TaskingFactory.eINSTANCE.createShared_Machine();
//	}

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		Shared_Machine eventBElement = (Shared_Machine) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof IShared_Machine)
		{
			//	nothing special to set here - probably
			
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IShared_Machine && emfElement instanceof Tasking_Machine) 
		{
			//	nothing special to do here
			
		}

		return rodinElement;
	}
}
