package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE;
import static org.eventb.tasking.persistence.TaskingAttributes.TASK_TYPE_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.TaskType;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class PeriodAttribute implements IAttributeManipulation {
	public static IAttributeType.Integer PERIOD_ATTRIBUTE = PERIODIC_TASK_TYPE_ATTRIBUTE;

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
			((TaskType) element).setAttributeValue(PERIOD_ATTRIBUTE, 0, monitor);
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{						
			return ((TaskType) element).hasAttribute(PERIOD_ATTRIBUTE);			
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskType)
		{
		//	if (((TaskType) element).hasAttribute(PERIOD_ATTRIBUTE))
		//	{
				return Integer.toString(((TaskType) element).getAttributeValue(PERIOD_ATTRIBUTE));
		//	}
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		
		if (element instanceof TaskType && isInteger(value))
		{
			int oldValue = ((TaskType)element).getAttributeValue(PERIOD_ATTRIBUTE);
			//	Only update if it is a periodic task			
			if (((TaskType) element).getAttributeValue(TASK_TYPE_ATTRIBUTE).equals("Periodic"))
			{
				((TaskType) element).setAttributeValue(PERIOD_ATTRIBUTE, new Integer(value), monitor);
			}
			else
			{
				//	Don't allow updates if not the correct type
				((TaskType) element).setAttributeValue(PERIOD_ATTRIBUTE, oldValue, monitor);
			}
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskType)
		{
			((TaskType) element).removeAttribute(PERIOD_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
				
		return null;
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
