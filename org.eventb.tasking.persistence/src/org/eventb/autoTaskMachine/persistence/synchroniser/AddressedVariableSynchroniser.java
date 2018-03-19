package org.eventb.autoTaskMachine.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.IAddressedVariable;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.AddressedVariable;
import tasking.TaskingFactory;

public class AddressedVariableSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IAddressedVariable.ELEMENT_TYPE;
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
		return TaskingFactory.eINSTANCE.createAddressedVariable();
	}

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		AddressedVariable eventBElement = (AddressedVariable) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof IAddressedVariable)
		{
			//	Load the implementation type
			IAddressedVariable imp = (IAddressedVariable)rodinElement;
			eventBElement.setBase(imp.getBase());
			eventBElement.setAddress(imp.getAddress());
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IAddressedVariable && emfElement instanceof AddressedVariable) 
		{
			//	Save the implementation type
			IAddressedVariable imp = (IAddressedVariable)rodinElement;
			AddressedVariable eventBElement = (AddressedVariable)emfElement;
			imp.setBase(eventBElement.getBase());
			imp.setAddress(eventBElement.getAddress());
		}

		return rodinElement;
	}
}
