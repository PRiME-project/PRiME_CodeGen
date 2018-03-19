package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IImplementation;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

import tasking.ImplementationTypeEnum;

public class Implementation extends InternalElement implements IImplementation{

	
	public Implementation(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ELEMENT_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(IMPLEMENTATION_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(IMPLEMENTATION_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(IMPLEMENTATION_ATTRIBUTE, string, monitor);
	}

	
	
	
	
	@Override
	public ImplementationTypeEnum getImplementationType() throws RodinDBException {
		int iType = getAttributeValue(TaskingAttributes.IMPLEMENTATION_TYPE_ATTRIBUTE);
		
		return ImplementationTypeEnum.get(iType);	
	}

	@Override
	public void setImplementationType(ImplementationTypeEnum type) throws RodinDBException {
		int iType = type.getValue();
		setAttributeValue(TaskingAttributes.IMPLEMENTATION_TYPE_ATTRIBUTE, iType,null);
	}
}
