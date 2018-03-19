package org.eventb.tasking.persistence.impl;

import org.eventb.tasking.persistence.ITask;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public abstract class Task extends MachineType implements ITask{

	public Task(String name, IRodinElement parent) {
		super(name, parent);
	}
	
	protected int priority = 5;
	
	//	getPriority won't be called under the new file format
	public int getPriority() throws RodinDBException
	{		
		return getAttributeValue(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE);
	}

	public void setPriority(int p) throws RodinDBException
	{
		setAttributeValue(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE, p, null);
	}
}
