package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IAddressedVariable;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

public class AddressedVariable extends InternalElement implements IAddressedVariable {
	
	public AddressedVariable(String name, IRodinElement parent) {
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
		return hasAttribute(ADDRESSEDVARIABLE_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(ADDRESSEDVARIABLE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(ADDRESSEDVARIABLE_ATTRIBUTE, string, monitor);
	}

	@Override
	public int getBase() throws RodinDBException { 
		return getAttributeValue(TaskingAttributes.ADDRESSEDVARIABLE_BASE_ATTRIBUTE);
	}

	@Override
	public void setBase(int base) throws RodinDBException {
		setAttributeValue(TaskingAttributes.ADDRESSEDVARIABLE_BASE_ATTRIBUTE, base, null);		
	}

	@Override
	public String getAddress() throws RodinDBException {
		return getAttributeValue(TaskingAttributes.ADDRESSEDVARIABLE_ADDRESS_ATTRIBUTE);
	}

	@Override
	public void setAddress(String address) throws RodinDBException {
		if (address == null)
			address = "";
		setAttributeValue(TaskingAttributes.ADDRESSEDVARIABLE_ADDRESS_ATTRIBUTE, address, null);		
	}

}
