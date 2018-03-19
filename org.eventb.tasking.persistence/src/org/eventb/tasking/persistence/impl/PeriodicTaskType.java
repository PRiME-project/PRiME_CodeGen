package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IPeriodicTaskType;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class PeriodicTaskType extends TaskType implements IPeriodicTaskType {
	
	public PeriodicTaskType(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
//	@Override
//	public IInternalElementType<? extends IInternalElement> getElementType() {
//		return IPeriodicTaskType.ELEMENT_TYPE;
//	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(PERIODICTASKTYPE_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(PERIODICTASKTYPE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(PERIODICTASKTYPE_ATTRIBUTE, string, monitor);
	}

	//	getAttribute will only be called if using old style file format
	@Override
	public int getPeriod() throws RodinDBException {
		return getAttributeValue(TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE);
	}

	@Override
	public void setPeriod(int type) throws RodinDBException {
		setAttributeValue(TaskingAttributes.PERIODIC_TASK_TYPE_ATTRIBUTE, type, null);
	}
}
