/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/





package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IAutoTask_Machine;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * Implementation of a Rodin internal element for AutoTask_Machine.
 * 
 * @author Andy Edmunds
 *
 */
public class AutoTask_Machine extends Task implements IAutoTask_Machine {

	public AutoTask_Machine(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
//	@Override
//	public IInternalElementType<? extends IInternalElement> getElementType() {
//		return ELEMENT_TYPE;
//	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(AUTOTASK_MACHINE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(AUTOTASK_MACHINE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(AUTOTASK_MACHINE_ATTRIBUTE, string, monitor);
	}

}
