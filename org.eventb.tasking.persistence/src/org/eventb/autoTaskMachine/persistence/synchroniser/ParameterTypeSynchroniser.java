package org.eventb.autoTaskMachine.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.IParameterType;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.ParameterType;
import tasking.TaskingFactory;

public class ParameterTypeSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IParameterType.ELEMENT_TYPE;
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
		return TaskingFactory.eINSTANCE.createParameterType();
	}

	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		ParameterType eventBElement = (ParameterType) super.load(rodinElement, emfParent, monitor);
		
		if (rodinElement instanceof IParameterType)
		{
			//	Load the parameter type
			IParameterType imp = (IParameterType)rodinElement;
			eventBElement.setParameterType(imp.getParameterType());	
					
		}
			
		return eventBElement;
	}

	@Override
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException {
		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
		
		if (rodinElement instanceof IParameterType && emfElement instanceof ParameterType) 
		{
			//	Save the parameter type
			IParameterType imp = (IParameterType)rodinElement;
			ParameterType eventBElement = (ParameterType)emfElement;
			imp.setParameterType(eventBElement.getParameterType());
		}

		return rodinElement;
	}

}
