package org.eventb.autoTaskMachine.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.ITasking_Machine;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.TaskingFactory;
import tasking.Tasking_Machine;

public class Tasking_MachineSynchroniser extends AbstractSynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	//	putting this back in breaks things
//	static {
//		handledAttributes.add(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE);
//	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return ITasking_Machine.ELEMENT_TYPE;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.eINSTANCE.getEventBElement_Extensions();
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return TaskingFactory.eINSTANCE.createTasking_Machine();
	}

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		Tasking_Machine eventBElement = (Tasking_Machine) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof ITasking_Machine)
		{
			//	Load the priority
			ITasking_Machine tMachine = (ITasking_Machine)rodinElement;
			eventBElement.setPriority(tMachine.getPriority());
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof ITasking_Machine && emfElement instanceof Tasking_Machine) 
		{
			//	Save the priority
			ITasking_Machine tMachine = (ITasking_Machine) rodinElement;
			Tasking_Machine eventBElement = (Tasking_Machine)emfElement;
			
			tMachine.setPriority(eventBElement.getPriority());
		}

		return rodinElement;
	}
}
