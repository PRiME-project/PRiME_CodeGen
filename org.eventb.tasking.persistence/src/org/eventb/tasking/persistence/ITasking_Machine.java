package org.eventb.tasking.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface ITasking_Machine extends IInternalElement, ITask {
	public static IInternalElementType<ITasking_Machine> ELEMENT_TYPE = RodinCore.getInternalElementType(TaskingPersistencePlugin.PLUGIN_ID + ".taskingMachine");
	public static IAttributeType.String TASKING_MACHINE_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".tasking");
		
	
	/**
	 * Tests whether a serialised string of AutoTask_Machine is set.
	 * 
	 * @return true if set, otherwise false
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	boolean hasSerialisedString() throws RodinDBException;
	
	/**
	 * Returns a serialised string.
	 * 
	 * @return a string representation of a serialised AutoTask_Machine object
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	String getSerialisedString() throws RodinDBException;
	
	/**
	 * Sets the serialised string.
	 * 
	 * @param string a serialised AutoTask_Machine string
	 * @param monitor progress monitor
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	void setSerialisedString(String string, IProgressMonitor monitor) throws RodinDBException;
}