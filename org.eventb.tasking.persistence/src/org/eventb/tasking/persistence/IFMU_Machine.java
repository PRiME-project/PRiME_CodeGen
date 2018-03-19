/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.tasking.persistence;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * Interface for Rodin internal type corresponding to EMF FMU_Machine.
 * 
 * @author Andy Edmunds
 *
 */
public interface IFMU_Machine extends IInternalElement, ITask {
	
	
public static IInternalElementType<IFMU_Machine> ELEMENT_TYPE = RodinCore.getInternalElementType(TaskingPersistencePlugin.PLUGIN_ID + ".fmuMachine");
public static IAttributeType.String FMU_MACHINE_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".fmuMch");
	
	/**
	 * Tests whether a serialised string of FMU_Machine is set.
	 * 
	 * @return true if set, otherwise false
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	boolean hasSerialisedString() throws RodinDBException;
	
	/**
	 * Returns a serialised string.
	 * 
	 * @return a string representation of a serialised FMU_Machine object
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	String getSerialisedString() throws RodinDBException;
	
	/**
	 * Sets the serialised string.
	 * 
	 * @param string a serialised FMU_Machine string
	 * @param monitor progress monitor
	 * @throws RodinDBException if there was a problem accessing the database
	 */
	void setSerialisedString(String string, IProgressMonitor monitor) throws RodinDBException;

}