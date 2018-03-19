package org.eventb.tasking.persistence.impl;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IParameterType;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

import tasking.ParameterTypeEnum;


public class ParameterType extends InternalElement implements IParameterType {
	
	private ParameterTypeEnum type = ParameterTypeEnum.IN;
	
	public ParameterType(String name, IRodinElement parent) {
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
		return hasAttribute(PARAMETERTYPE_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(PARAMETERTYPE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(PARAMETERTYPE_ATTRIBUTE, string, monitor);
	}

	@Override
	public ParameterTypeEnum getParameterType() throws RodinDBException {
		int iType = getAttributeValue(TaskingAttributes.PARAMETERTYPE_ATTRIBUTE);
		
		return ParameterTypeEnum.get(iType);	
	}

	@Override
	public void setParameterType(ParameterTypeEnum type) throws RodinDBException {
		int iType = type.getValue();
		setAttributeValue(TaskingAttributes.PARAMETERTYPE_ATTRIBUTE, iType,null);
	}
}
