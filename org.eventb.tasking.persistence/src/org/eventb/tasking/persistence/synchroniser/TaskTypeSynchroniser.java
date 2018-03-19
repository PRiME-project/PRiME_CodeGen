package org.eventb.tasking.persistence.synchroniser;

import static org.eventb.tasking.persistence.impl.TaskType.PERIODIC_TASK_TYPE;
import static org.eventb.tasking.persistence.impl.TaskType.SIMPLE_TASK_TYPE;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.IPeriodicTaskType;
import org.eventb.tasking.persistence.ISimpleTaskType;
import org.eventb.tasking.persistence.ITaskType;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.eventb.tasking.persistence.impl.TaskType;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.PeriodicTaskType;
import tasking.SimpleTaskType;
import tasking.Task;
import tasking.TaskTypeEnum;
import tasking.TaskingFactory;
import tasking.TaskingPackage;
import tasking.impl.PeriodicTaskTypeImpl;
import tasking.impl.SimpleTaskTypeImpl;

public class TaskTypeSynchroniser extends AbstractSynchroniser {
	
	private Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	
	private String taskType = "";	//	either periodic or simple
	private IInternalElementType<?> rodinType = ITaskType.ELEMENT_TYPE;

	@Override
	protected EventBElement createEventBElement() {

		if (taskType.equals(PERIODIC_TASK_TYPE))
		{
			return TaskingFactory.eINSTANCE.createPeriodicTaskType();
		}
		else if (taskType.equals(SIMPLE_TASK_TYPE))
		{
			return TaskingFactory.eINSTANCE.createSimpleTaskType();
		}
		
		return null;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return TaskingPackage.eINSTANCE.getTask_TaskType();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return rodinType;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}
	
	@Override
	public <T extends EventBElement> EventBElement load(
			IRodinElement rodinElement, EventBElement emfParent,
			IProgressMonitor monitor) throws CoreException {
		
		//	Only load this element if the parent is a Task
		//	Otherwise if a change is made by accident from AutoTask to Shared
		//	and a TaskType has been set, it will crash.		
		if (emfParent instanceof Task)
		{
		
			if (rodinElement instanceof ITaskType)
			{
				//	Set the correct task type
				boolean oldStyle = false;
				if (isOldStyle(rodinElement))
				{				
					taskType = getTaskTypeFromOldStyle(rodinElement);
					oldStyle = true;
				}
				else
				{
					taskType = ((ITaskType)rodinElement).getTaskType();
				}
	
							
				//	Load the element - this will not call SimpleTaskTypeSync or PeriodicTaskTypeSync load.
				EventBElement  eventBElement = super.load(rodinElement, emfParent, monitor);
				
				//	Perform the Simple and Periodic task type loading routines
				if (eventBElement instanceof SimpleTaskType)
				{
					
					//	Attribute names were made clearer in newer version
					if (oldStyle && ((ITaskType)rodinElement).hasAttribute(TaskingAttributes.OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE))
					{
						int iType = ((ITaskType)rodinElement).getAttributeValue(TaskingAttributes.OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE);
						((SimpleTaskType)eventBElement).setType(TaskTypeEnum.get(iType));
					}
					else if (((ITaskType)rodinElement).hasAttribute(TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE))
					{
						String iType = ((ITaskType)rodinElement).getAttributeValue(TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE);
						((SimpleTaskType)eventBElement).setType(TaskTypeEnum.get(iType));
					}				
					
				}
				else if (eventBElement instanceof PeriodicTaskType)
				{
					int period ;
					
					//	Attribute names were made clearer in newer version
					if (oldStyle && ((ITaskType)rodinElement).hasAttribute(TaskingAttributes.OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE))
					{
						period = ((ITaskType)rodinElement).getAttributeValue(TaskingAttributes.OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE);
						((PeriodicTaskType)eventBElement).setPeriod(period);
					}
					else if (((ITaskType)rodinElement).hasAttribute(TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE))
					{
						period = ((ITaskType)rodinElement).getAttributeValue(TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE);
						((PeriodicTaskType)eventBElement).setPeriod(period);
					}
					
					
				}
				
				return eventBElement;
			}
		}
		
		return null;
	}
	
	
	@Override
	public IRodinElement save(EventBElement emfElement,
			IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException{
		
			//	Set the rodin type to the real type
			if (emfElement instanceof SimpleTaskTypeImpl)
			{
				rodinType = ISimpleTaskType.ELEMENT_TYPE;
			}
			else if (emfElement instanceof PeriodicTaskTypeImpl)
			{
				rodinType = IPeriodicTaskType.ELEMENT_TYPE;
			}
			
			//	Do the conversion			
			IRodinElement rodinElement = super.save(emfElement,rodinParent,monitor);

			//	Set the type of TaskType in the RodinDatabase element
			if (rodinElement instanceof ITaskType)
			{
				TaskType taskType = (TaskType)rodinElement;
				
				if (emfElement instanceof SimpleTaskTypeImpl)
				{
					taskType.setTaskType(SIMPLE_TASK_TYPE);
				}
				else if (emfElement instanceof PeriodicTaskTypeImpl)
				{
					taskType.setTaskType(PERIODIC_TASK_TYPE);
				}
			}
			
			return rodinElement;
	}
	
	/**
	 * Old file format (v0.1(or .2) - Dec 2011) will provide the specific rodin type here.
	 * New version will return a more general type.
	 * @param rodinElement
	 * @return
	 */
	private boolean isOldStyle(IRodinElement rodinElement)
	{
		if (rodinElement instanceof org.eventb.tasking.persistence.impl.PeriodicTaskType || rodinElement instanceof org.eventb.tasking.persistence.impl.SimpleTaskType)
		{
			return true;
		}
		
		return false;
	}
	
	private String getTaskTypeFromOldStyle(IRodinElement rodinElement)
	{
		if (rodinElement instanceof org.eventb.tasking.persistence.impl.PeriodicTaskType)
		{
			return PERIODIC_TASK_TYPE;
		}
		else if (rodinElement instanceof org.eventb.tasking.persistence.impl.SimpleTaskType)
		{
			return SIMPLE_TASK_TYPE;
		}
		
		return null;	//	unsupported or something went wrong
	}
	
}
