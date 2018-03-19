package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.TASK_TYPE_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.TaskType;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
public class SimpleTaskTypeAttribute implements IAttributeManipulation {

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
			//((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, "--not set--", monitor);
			
			try {
				if (((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE).equals("Simple"))
				{
					((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, "Repeating", monitor);
				}
				else if (((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE).equals("Periodic"))
				{
					((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, "NotRequired", monitor);
				}
				else
				{
					((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, "--undef--", monitor);
				}
			} catch (RodinDBException e) {	
				
			}	
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{						
			return ((TaskType) element).hasAttribute(SIMPLE_TASK_TYPE_ATTRIBUTE);			
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
			return ((TaskType) element).getAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE);
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		
		// 	this line seems to have a side effect of forcing the simple task type to revert to nothing when
		//	the task type is changed. I have no idea why, it doesn't seem to have anything to do with that 
		//	bit of code. Oh well. But then doesn't allow the thing to be saved.
//		if (element instanceof TaskType && isInteger(value))
		if (element instanceof TaskType)
		{
			((TaskType) element).setAttributeValue(SIMPLE_TASK_TYPE_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{
			((TaskType) element).removeAttribute(SIMPLE_TASK_TYPE_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		
		String[] valuesRequired = {"Repeating","Triggered","OneShot"};
		String[] valuesNotRequired = {"NotRequired"};					//	Used when the task type is periodic
		String[] notSet = {"--undef--"};
		
		if (element instanceof TaskType)
		{
			//	Only return values here if they can be used
			try {
				if (((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE).equals("Simple"))
				{
					return valuesRequired;
				}
				else if (((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE).equals("Periodic"))
				{
					return valuesNotRequired;
				}
			} catch (RodinDBException e) {				
			}			
		}
		
		return notSet;
	}
	
	public boolean isInteger(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
}
