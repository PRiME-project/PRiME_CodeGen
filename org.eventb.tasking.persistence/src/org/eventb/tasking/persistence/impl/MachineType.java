package org.eventb.tasking.persistence.impl;

import static org.eventb.tasking.persistence.TaskingAttributes.MACHINE_TYPE_ATTRIBUTE;

import org.eventb.core.basis.EventBElement;
import org.eventb.tasking.persistence.IMachineType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * Used as the element entry for the UI
 * @author Chris
 *
 */
public class MachineType extends EventBElement implements IMachineType {

	public MachineType(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return IMachineType.ELEMENT_TYPE;
	}
	
	//	SET MACHINE TYPE LABEL
	public String getMachineType() throws RodinDBException
	{		
		return getAttributeValue(MACHINE_TYPE_ATTRIBUTE);
	}

	public void setMachineType(String p) throws RodinDBException
	{
		setAttributeValue(MACHINE_TYPE_ATTRIBUTE, p, null);
	}

}
