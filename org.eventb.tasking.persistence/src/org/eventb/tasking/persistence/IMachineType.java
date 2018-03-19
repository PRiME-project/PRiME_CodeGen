package org.eventb.tasking.persistence;

import org.eventb.core.ICommentedElement;
import org.eventb.core.IExpressionElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface IMachineType extends ICommentedElement, IExpressionElement {
	IInternalElementType<IMachineType> ELEMENT_TYPE = RodinCore.getInternalElementType(TaskingPersistencePlugin.PLUGIN_ID + ".MachineType");
	
	
	public String getMachineType() throws RodinDBException;
	public void setMachineType(String p) throws RodinDBException;
}
