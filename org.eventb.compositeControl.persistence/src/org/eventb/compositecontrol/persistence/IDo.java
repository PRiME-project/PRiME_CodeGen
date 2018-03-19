package org.eventb.compositecontrol.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface IDo extends ICompositeControlCommon {
	public static IInternalElementType<IDo> ELEMENT_TYPE = RodinCore.getInternalElementType(CompositeControlPersistencePlugin.PLUGIN_ID + ".do");
	public static IAttributeType.String DO_ATTRIBUTE = RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".compositecontrol");

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
	
	
	
	
	String getLabel() throws RodinDBException;	
	void setLabel(String label) throws RodinDBException;	
}
