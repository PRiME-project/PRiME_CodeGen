/*******************************************************************************
 * Copyright (c) 2010 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.autoTaskMachine.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.IAutoTask_Machine;
import org.eventb.tasking.persistence.synchroniser.MachineTypeSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.AutoTask_Machine;


/**
 * AutoTask_Machine synchroniser.
 * Serialises AutoTask_Machine to a string attribute and deserialises it back to EMF object.
 * 
 * @author Andy Edmunds
 *
 */
public class AutoTask_MachineSynchroniser extends MachineTypeSynchroniser {

	public AutoTask_MachineSynchroniser()
	{
		super();

	}
	
	@Override
	/**	This will only be called when the .autoTaskMachine rodin entry is given.
	 *  (non-Javadoc)
	 * @see org.eventb.tasking.persistence.synchroniser.MachineTypeSynchroniser#load(org.rodinp.core.IRodinElement, org.eventb.emf.core.EventBElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		AutoTask_Machine eventBElement = (AutoTask_Machine) super.load(rodinElement, emfParent, monitor);

		if (rodinElement instanceof IAutoTask_Machine)
		{
			//	Load the priority
			IAutoTask_Machine tMachine = (IAutoTask_Machine)rodinElement;
			eventBElement.setPriority(tMachine.getPriority());
		}
			
		return eventBElement;
	}

	@Override
	/**
	 * This will be called when an AutoTask EMF object is saved. 
	 */
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IAutoTask_Machine && emfElement instanceof AutoTask_Machine) 
		{
			//	Save the priority
			IAutoTask_Machine tMachine = (IAutoTask_Machine) rodinElement;
			AutoTask_Machine eventBElement = (AutoTask_Machine)emfElement;
			
			tMachine.setPriority(eventBElement.getPriority());
		}

		return rodinElement;
	}
}
