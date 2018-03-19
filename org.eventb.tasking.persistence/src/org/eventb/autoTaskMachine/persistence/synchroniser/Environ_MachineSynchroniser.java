package org.eventb.autoTaskMachine.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.emf.core.EventBElement;
import org.eventb.tasking.persistence.IEnviron_Machine;
import org.eventb.tasking.persistence.synchroniser.MachineTypeSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Environ_Machine;

public class Environ_MachineSynchroniser extends MachineTypeSynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}
	
//	putting this back in breaks things	
//	static {
//		handledAttributes.add(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return IEnviron_Machine.ELEMENT_TYPE;
//	}
//
//	@Override
//	protected EStructuralFeature getFeature() {
//		return CorePackage.eINSTANCE.getEventBElement_Extensions();
//	}
//
//	@Override
//	protected Set<IAttributeType> getHandledAttributeTypes() {
//		return handledAttributes;
//	}
//
//	@Override
//	protected EventBElement createEventBElement() { 
//		return TaskingFactory.eINSTANCE.createEnviron_Machine();
//	}

	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		Environ_Machine eventBElement = (Environ_Machine) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof IEnviron_Machine)
		{
			//	Load the priority
			IEnviron_Machine tMachine = (IEnviron_Machine)rodinElement;
			eventBElement.setPriority(tMachine.getPriority());
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IEnviron_Machine && emfElement instanceof Environ_Machine) 
		{
			//	Save the priority
			IEnviron_Machine tMachine = (IEnviron_Machine) rodinElement;
			Environ_Machine eventBElement = (Environ_Machine)emfElement;
			
			tMachine.setPriority(eventBElement.getPriority());
		}

		return rodinElement;
	}
}
