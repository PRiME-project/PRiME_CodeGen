package org.eventb.tasking.persistence.impl;

import static org.eventb.tasking.persistence.TaskingAttributes.TASK_TYPE_ATTRIBUTE;

import org.eventb.core.basis.EventBElement;
import org.eventb.tasking.persistence.ITaskType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class TaskType extends EventBElement implements ITaskType {
	
	public static final String PERIODIC_TASK_TYPE = "Periodic";
	public static final String SIMPLE_TASK_TYPE = "Simple";

	public TaskType(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public String getTaskType() throws RodinDBException {
		return getAttributeValue(TASK_TYPE_ATTRIBUTE);
	}

	@Override
	public void setTaskType(String p) throws RodinDBException {
		setAttributeValue(TASK_TYPE_ATTRIBUTE, p, null);
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ITaskType.ELEMENT_TYPE;
	}

}
