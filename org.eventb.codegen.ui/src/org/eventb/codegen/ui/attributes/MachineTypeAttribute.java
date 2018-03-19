package org.eventb.codegen.ui.attributes;

import static org.eventb.tasking.persistence.TaskingAttributes.MACHINE_TYPE_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.impl.AutoTask_Machine;
import org.eventb.tasking.persistence.impl.Environ_Machine;
import org.eventb.tasking.persistence.impl.MachineType;
import org.eventb.tasking.persistence.impl.Shared_Machine;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.FMU_Machine;

public class MachineTypeAttribute implements IAttributeManipulation {
	

	

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof MachineType)
		{
			((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, "AutoTask", monitor);
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			//	Need check for old type
			if (((MachineType) element).hasAttribute(MACHINE_TYPE_ATTRIBUTE))
			{
				return true;
			}
			else
			{
				//	Could be old type
				//	This will update the file, but cause the editor to hang
				//	requiring the editor to be saved, closed and then re-opened
				if (element instanceof AutoTask_Machine)
				{
					((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, "AutoTask", monitor);
					return true;
				}
				else if (element instanceof Environ_Machine)
				{
					((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, "Environ", monitor);
					return true;
				}
				else if (element instanceof Shared_Machine)
				{
					((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, "Shared", monitor);
					return true;
				}
				else if( element instanceof FMU_Machine){
					((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, "FMU", monitor);
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof MachineType)
		{
			return ((MachineType) element).getAttributeValue(MACHINE_TYPE_ATTRIBUTE);
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			((MachineType) element).setAttributeValue(MACHINE_TYPE_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof MachineType)
		{
			((MachineType) element).removeAttribute(MACHINE_TYPE_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {

		String [] values = {"AutoTask", "Environ", "Shared"}; //Sadegh: removed FMU from UI
		
		return values;
	}
	
	
	public void updateFileVersion()
	{
		//	Check task type - swap to new version if required
		
	}

}
