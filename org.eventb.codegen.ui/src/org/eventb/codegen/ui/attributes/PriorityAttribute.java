package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.TASK_PRIORITY_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.MachineType;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class PriorityAttribute implements IAttributeManipulation {

	public static IAttributeType.Integer PRIORITY_ATTRIBUTE = TASK_PRIORITY_ATTRIBUTE;
	

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			((MachineType) element).setAttributeValue(PRIORITY_ATTRIBUTE, 5, monitor);
		}

	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			return ((MachineType) element).hasAttribute(PRIORITY_ATTRIBUTE);
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			return Integer.toString(((MachineType)element).getAttributeValue(PRIORITY_ATTRIBUTE));
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {

		if (element instanceof MachineType && isInteger(value))	
		{
			((MachineType)element).setAttributeValue(PRIORITY_ATTRIBUTE, new Integer(value), monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			((MachineType)element).removeAttribute(PRIORITY_ATTRIBUTE, monitor);
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
