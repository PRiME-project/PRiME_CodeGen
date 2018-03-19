package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.TASK_BODY_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.TaskBody;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class TaskBodyAttribute implements IAttributeManipulation {

	
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof TaskBody)
		{
			((TaskBody) element).setAttributeValue(TASK_BODY_ATTRIBUTE, "", monitor);
		}

	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskBody)
		{
			return ((TaskBody) element).hasAttribute(TASK_BODY_ATTRIBUTE);
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskBody && ((TaskBody) element).hasAttribute(TASK_BODY_ATTRIBUTE))			
		{
			return ((TaskBody)element).getAttributeValue(TASK_BODY_ATTRIBUTE);
		}
		
		return null;		
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {

		if (element instanceof TaskBody)
		{
			((TaskBody) element).setAttributeValue(TASK_BODY_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof TaskBody)
		{
			((TaskBody) element).removeAttribute(TASK_BODY_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		return null;
	}

}
