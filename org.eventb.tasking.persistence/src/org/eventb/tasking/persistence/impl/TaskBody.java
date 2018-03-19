package org.eventb.tasking.persistence.impl;

import static org.eventb.tasking.persistence.TaskingAttributes.TASK_BODY_ATTRIBUTE;

import org.eventb.core.basis.EventBElement;
import org.eventb.tasking.persistence.ITaskBody;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class TaskBody extends EventBElement implements ITaskBody {

	public TaskBody(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ITaskBody.ELEMENT_TYPE;
	}

	@Override
	public String getTaskBody() throws RodinDBException {
		return getAttributeValue(TASK_BODY_ATTRIBUTE);
	}

	@Override
	public void setTaskBody(String p) throws RodinDBException {
		setAttributeValue(TASK_BODY_ATTRIBUTE, p, null);		
	}

}
