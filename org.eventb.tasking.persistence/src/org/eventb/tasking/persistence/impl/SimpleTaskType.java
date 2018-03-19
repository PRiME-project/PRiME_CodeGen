package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.ISimpleTaskType;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.TaskTypeEnum;

public class SimpleTaskType extends TaskType implements ISimpleTaskType {
	
	public SimpleTaskType(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
//	@Override
//	public IInternalElementType<? extends IInternalElement> getElementType() {
//		return ISimpleTaskType.ELEMENT_TYPE;
//	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(SIMPLETASKTYPE_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(SIMPLETASKTYPE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(SIMPLETASKTYPE_ATTRIBUTE, string, monitor);
	}

	@Override
	public TaskTypeEnum getTaskTypeEnumeration() throws RodinDBException {
		String iType = getAttributeValue(TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE);
		return TaskTypeEnum.get(iType);	
	}

	@Override
	public void setTaskTypeEnumeration(TaskTypeEnum type) throws RodinDBException {
		String iType = type.getLiteral();
		setAttributeValue(TaskingAttributes.SIMPLE_TASK_TYPE_ATTRIBUTE, iType,null);		
	}
}
