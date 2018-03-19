package org.eventb.autoTaskMachine.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.synchroniser.MachineTypeSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.FMU_Machine;

public class FMU_MachineSynchroniser extends MachineTypeSynchroniser{

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement,
			EventBElement emfParent, IProgressMonitor monitor) throws CoreException {
		FMU_Machine eventBElement = (FMU_Machine) super.load(rodinElement, emfParent, monitor);
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent,
			IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		return rodinElement;
	}
}
