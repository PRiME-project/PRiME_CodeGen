package org.eventb.tasking.persistence.synchroniser;

import static org.eventb.tasking.persistence.TaskingAttributes.MACHINE_TYPE_ATTRIBUTE;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.IAutoTask_Machine;
import org.eventb.tasking.persistence.IEnviron_Machine;
import org.eventb.tasking.persistence.IFMU_Machine;
import org.eventb.tasking.persistence.IMachineType;
import org.eventb.tasking.persistence.IShared_Machine;
import org.eventb.tasking.persistence.TaskingAttributes;
import org.eventb.tasking.persistence.impl.AutoTask_Machine;
import org.eventb.tasking.persistence.impl.Environ_Machine;
import org.eventb.tasking.persistence.impl.MachineType;
import org.eventb.tasking.persistence.impl.Shared_Machine;
import org.eventb.tasking.persistence.impl.Tasking_Machine;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.FMU_Machine;
import tasking.TaskingFactory;
import tasking.impl.AutoTask_MachineImpl;
import tasking.impl.Environ_MachineImpl;
import tasking.impl.Shared_MachineImpl;
import tasking.impl.TaskImpl;
//	this isn't abstract - as we want it to load
public class MachineTypeSynchroniser extends AbstractSynchroniser {
	
	
	public static final String AUTO_TASK = "AutoTask";
	public static final String ENVIRON = "Environ";
	public static final String SHARED = "Shared";
	public static final String FMU = "FMU";
	
	
	private Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	private String machineType = "";
	private IInternalElementType<?> rodinType = IMachineType.ELEMENT_TYPE;	//	default, shouldn't actually ever be given out

	public MachineTypeSynchroniser() {
		handledAttributes.add(MACHINE_TYPE_ATTRIBUTE);
	}

	@Override
	protected EventBElement createEventBElement() {

		if (machineType.equals("AutoTask"))
		{
			return TaskingFactory.eINSTANCE.createAutoTask_Machine();
		}
		else if (machineType.equals("Environ"))
		{
			return TaskingFactory.eINSTANCE.createEnviron_Machine();
		}
		else if (machineType.equals("Shared"))
		{
			return TaskingFactory.eINSTANCE.createShared_Machine();
		}
		else if (machineType.equals("FMU"))
		{
			return TaskingFactory.eINSTANCE.createFMU_Machine();
		}
		return null;
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.eINSTANCE.getEventBElement_Extensions();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return rodinType;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {			
		return handledAttributes;
	}
	
	
	
	@Override
	/**
	 * This will be called whenever any new style tasking annotation is found.
	 * It will not call the load of the associated synchronisers, instead it
	 * must do all the loading synchronisation itself.
	 */
	public <T extends EventBElement> EventBElement load(
			IRodinElement rodinElement, EventBElement emfParent,
			IProgressMonitor monitor) throws CoreException {
	
		if (rodinElement instanceof IMachineType )
		{
			//	Sets the flag to create the correct machine type in createEventBElement()
			if (isOldStyle(rodinElement))
			{
				machineType = getMachineTypeFromOldStyle(rodinElement);
			}
			else
			{				
				machineType = ((IMachineType)rodinElement).getMachineType();
			}
			
			EventBElement eventBElement = super.load(rodinElement, emfParent, monitor);
			
			if (eventBElement instanceof TaskImpl)
			{
				//	Load the priority
				if (((IMachineType) rodinElement).hasAttribute(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE))
				{
					int priority = ((IMachineType) rodinElement).getAttributeValue(TaskingAttributes.TASK_PRIORITY_ATTRIBUTE);
					((TaskImpl)eventBElement).setPriority(priority);
				}
			}
			else if (rodinElement instanceof Shared_Machine)
			{
				//	Nothing extra needs to be done here
			}
			
			return eventBElement;
		}
		return null;
	}

	@Override
	/**
	 * This will be called by the AutoTask, Protected or Environ synchroniser save call.
	 */
	public IRodinElement save(EventBElement emfElement,
			IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException{
		
		if (emfElement instanceof AutoTask_MachineImpl)
		{
			rodinType = IAutoTask_Machine.ELEMENT_TYPE;
		}
		else if (emfElement instanceof Shared_MachineImpl)
		{
			rodinType = IShared_Machine.ELEMENT_TYPE;
		}
		else if (emfElement instanceof Environ_MachineImpl)
		{
			rodinType = IEnviron_Machine.ELEMENT_TYPE;
		}
		else if(emfElement instanceof FMU_Machine){
			rodinType = IFMU_Machine.ELEMENT_TYPE;
		}

		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);

		//	Set the type in the RodinDatabase element so we know what it is when we load it
		if (rodinElement instanceof IMachineType)
		{
			MachineType tMachine = (MachineType) rodinElement;
			
			if (emfElement instanceof AutoTask_MachineImpl)
			{					
				tMachine.setMachineType(AUTO_TASK);
			}
			else if (emfElement instanceof Shared_MachineImpl)
			{
				tMachine.setMachineType(SHARED);
			}
			else if (emfElement instanceof Environ_MachineImpl)
			{
				tMachine.setMachineType(ENVIRON);
			}
			else if(emfElement instanceof FMU_Machine){
				tMachine.setMachineType(FMU);
			}
		}
		
		return rodinElement;		
	}
	
	
	
	private boolean isOldStyle(IRodinElement rodinElement)
	{
		//	New style will be of type IMachineType only.
		//	Old style will be of the specific class type.
		if (rodinElement instanceof AutoTask_Machine || rodinElement instanceof Shared_Machine || rodinElement instanceof Tasking_Machine || rodinElement instanceof Environ_Machine)
		{
			return true;
		}
		
		return false;
	}
	
	private String getMachineTypeFromOldStyle(IRodinElement rodinElement)
	{
		if (rodinElement instanceof AutoTask_Machine)
		{
			return AUTO_TASK;			
		}
		else if (rodinElement instanceof Environ_Machine)
		{
			return ENVIRON;
		}
		else if (rodinElement instanceof Shared_Machine)
		{
			return SHARED;
		}
		else if (rodinElement instanceof FMU_Machine)
		{
			return FMU;
		}
		else if (rodinElement instanceof Tasking_Machine){
			return AUTO_TASK;	
		}
		
		return null;	//	 something unsupported.
	}

}
