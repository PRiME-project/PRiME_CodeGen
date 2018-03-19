package org.eventb.tasking.persistence;

import org.eventb.core.IExpressionElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface ITaskBody extends IExpressionElement  {
	IInternalElementType<IMachineType> ELEMENT_TYPE = RodinCore.getInternalElementType(TaskingPersistencePlugin.PLUGIN_ID + ".TaskBody");
	
	public String getTaskBody() throws RodinDBException;
	public void setTaskBody(String p) throws RodinDBException;
}
