package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.TASK_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.impl.TaskType.PERIODIC_TASK_TYPE;
import static org.eventb.tasking.persistence.impl.TaskType.SIMPLE_TASK_TYPE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.PeriodicTaskType;
import org.eventb.tasking.persistence.impl.SimpleTaskType;
import org.eventb.tasking.persistence.impl.TaskType;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.TaskTypeEnum;

public class TaskTypeAttribute implements IAttributeManipulation {

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
			((TaskType) element).setAttributeValue(TASK_TYPE_ATTRIBUTE, PERIODIC_TASK_TYPE, monitor);
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{			
			//	needs to handle backwards compatability here too - it arrives here before getValue
			if (((TaskType) element).hasAttribute(TASK_TYPE_ATTRIBUTE))
			{
				return true;
			}
			else if (element instanceof PeriodicTaskType)
			{
				((TaskType) element).setAttributeValue(TASK_TYPE_ATTRIBUTE, PERIODIC_TASK_TYPE, monitor);
				return true;
			}
			else if (element instanceof SimpleTaskType)
			{
				((TaskType) element).setAttributeValue(TASK_TYPE_ATTRIBUTE, SIMPLE_TASK_TYPE, monitor);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
			//	Check for old style file format compatibility
			
//			Check for old versions - maybe move this somewhere else
			if (((TaskType)element).hasAttribute(OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE))
			{
				int period = ((TaskType)element).getAttributeValue(OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE);				
				((TaskType)element).setAttributeValue(PERIODIC_TASK_TYPE_ATTRIBUTE, period, monitor);
				((TaskType)element).removeAttribute(OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE, monitor);						
			}
			if (((TaskType)element).hasAttribute(OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE))
			{
				//	Old format was a number, new one is a string.
				//	Use the Tasking.TaskTypeEnum to make the conversion
				int oldTaskType = ((TaskType)element).getAttributeValue(OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE);
				((TaskType)element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, TaskTypeEnum.get(oldTaskType).getLiteral(), monitor);
				((TaskType)element).removeAttribute(OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE, monitor);
			}	
					
					
			
			if (((TaskType) element).hasAttribute(TASK_TYPE_ATTRIBUTE))
			{
				return ((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE);
			}

					
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
				
		if (element instanceof TaskType)
		{
			//	Get the current attribute - if there is one
			String current = "null";
			
			//	Important test for backwards compatibility of file types
			if (((TaskType) element).hasAttribute(TASK_TYPE_ATTRIBUTE))
			{
				current = ((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE);			
			}					
			
			
			((TaskType) element).setAttributeValue(TASK_TYPE_ATTRIBUTE, value, monitor);
			
			//	If the task type has been changed, update the non-required cells
			if (!current.equals(value))
			{			
				//	Change the values in the other cells
				if (value.equals(PERIODIC_TASK_TYPE))
				{
					((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE,"NotRequired", monitor);					
				}
				else if (value.equals(SIMPLE_TASK_TYPE))
				{
					((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE,"--undef--", monitor);
				}
			}
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{
			((TaskType) element).removeAttribute(TASK_TYPE_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {

		String [] values = {PERIODIC_TASK_TYPE, SIMPLE_TASK_TYPE};
		
		return values;
	}

}
