package org.eventb.autoTaskMachine.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.ISimpleTaskType;
import org.eventb.tasking.persistence.synchroniser.TaskTypeSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.SimpleTaskType;

public class SimpleTaskTypeSynchroniser extends TaskTypeSynchroniser {

//	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
//
////	static {
////		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
////	}
//
//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return ISimpleTaskType.ELEMENT_TYPE;
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
//		return TaskingFactory.eINSTANCE.createSimpleTaskType();
//	}

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		SimpleTaskType eventBElement = (SimpleTaskType) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof ISimpleTaskType)
		{
			//	Load the task type
			ISimpleTaskType imp = (ISimpleTaskType)rodinElement;
			eventBElement.setType(imp.getTaskTypeEnumeration());	
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof ISimpleTaskType && emfElement instanceof SimpleTaskType) 
		{
			//	Save the task type
			ISimpleTaskType imp = (ISimpleTaskType)rodinElement;
			SimpleTaskType eventBElement = (SimpleTaskType)emfElement;
			imp.setTaskTypeEnumeration(eventBElement.getType());
		}

		return rodinElement;
	}

}
