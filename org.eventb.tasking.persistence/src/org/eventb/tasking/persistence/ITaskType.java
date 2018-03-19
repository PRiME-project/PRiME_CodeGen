package org.eventb.tasking.persistence;

import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface ITaskType extends IInternalElement {	
	IInternalElementType<ITaskType> ELEMENT_TYPE = RodinCore.getInternalElementType(TaskingPersistencePlugin.PLUGIN_ID + ".TaskType");
		
	public String getTaskType() throws RodinDBException;
	public void setTaskType(String p) throws RodinDBException;

}
