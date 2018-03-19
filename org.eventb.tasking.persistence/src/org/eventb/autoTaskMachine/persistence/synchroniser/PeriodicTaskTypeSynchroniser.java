package org.eventb.autoTaskMachine.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.IPeriodicTaskType;
import org.eventb.tasking.persistence.synchroniser.TaskTypeSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.PeriodicTaskType;

public class PeriodicTaskTypeSynchroniser extends TaskTypeSynchroniser {

//	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
//
////	static {
////		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
////	}
//
//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return IPeriodicTaskType.ELEMENT_TYPE;
//	}
//
//	@Override
//	protected EStructuralFeature getFeature() {
//		return TaskingPackage.eINSTANCE.getTask_TaskType();
//	}
//
//	@Override
//	protected Set<IAttributeType> getHandledAttributeTypes() {
//		return handledAttributes;
//	}
//
//	@Override
//	protected EventBElement createEventBElement() {
//		return TaskingFactory.eINSTANCE.createPeriodicTaskType();
//	}
	
	

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		PeriodicTaskType eventBElement = (PeriodicTaskType) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof IPeriodicTaskType)
		{
			//	Load the task period
			IPeriodicTaskType imp = (IPeriodicTaskType)rodinElement;
			eventBElement.setPeriod(imp.getPeriod());	
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IPeriodicTaskType && emfElement instanceof PeriodicTaskType) 
		{
			//	Save the task period
			IPeriodicTaskType imp = (IPeriodicTaskType)rodinElement;
			PeriodicTaskType eventBElement = (PeriodicTaskType)emfElement;
			imp.setPeriod(eventBElement.getPeriod());
		}

		return rodinElement;
	}


}
