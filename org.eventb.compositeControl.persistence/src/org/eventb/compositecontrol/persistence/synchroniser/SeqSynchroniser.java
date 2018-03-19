package org.eventb.compositecontrol.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.compositecontrol.persistence.ISeq;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Task;
import tasking.TaskingPackage;
import compositeControl.CompositeControlFactory;
import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.Seq;

public class SeqSynchroniser extends EMFToTaskBodySynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	
	EStructuralFeature feature = CorePackage.eINSTANCE.getEventBElement_Extensions();	//	default - shouldn't be used really

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return ISeq.ELEMENT_TYPE;
//	}

	@Override
	protected EStructuralFeature getFeature() {
//		return CorePackage.eINSTANCE.getEventBElement_Extensions();
		return feature;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return CompositeControlFactory.eINSTANCE.createSeq();
	}

	
	
	
	
	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {				
//		Reset feature type to default
		
		
		if (super.canLoad(emfParent))
		{
			
			
			
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
			
			
			//	Only load if the Task parent has not got a generatedFromTaskBody element attached to it
			
	//		Load the feature type
			if (rodinElement instanceof ISeq)
			{
				//	Will cause everything to crash if feature id isn't set
				int feature = ((ISeq)rodinElement).getFeatureID();
				//	Determine feature type
				if (emfParent instanceof Seq)
				{							
					if (feature == CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getSeq_LeftBranch();
					}
					else if (feature == CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getSeq_RightBranch();
					}
				}
				else if (emfParent instanceof Do)
				{
					if (feature == CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getDo_TaskBody();
					}
				}
				else if (emfParent instanceof Task)
				{
					if (feature == TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID())
					{
						this.feature = TaskingPackage.eINSTANCE.getTask_TaskBody();
					}
				}			
			}		
			
			Seq eventBElement = (Seq) super.load(rodinElement, emfParent, monitor);
			
	//		Reset feature type to default
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
				
			return eventBElement;
		}
		else
		{
			//	Just dump it somewhere else
			feature = CorePackage.eINSTANCE.getAnnotation_EventBObject();
			return super.load(rodinElement, emfParent, monitor);
		}
	}
//	
//	@Override
//	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws RodinDBException {
//		
//		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
//		
//		if (rodinElement instanceof ISeq && emfElement instanceof Seq) 
//		{						
//			if (emfElement.eContainer() instanceof Seq)
//			{
//				if (((Seq)emfElement.eContainer()).getLeftBranch() == emfElement)
//				{
//					((ISeq)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID());
//				}
//				else if (((Seq)emfElement.eContainer()).getRightBranch() == emfElement)
//				{
//					((ISeq)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Do)
//			{
//				if (((Do)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((ISeq)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Task)
//			{
//				if (((Task)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((ISeq)rodinElement).setFeatureID(TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID());
//				}
//			}
//			else
//			{
//				//	Set default feature id
//				((ISeq)rodinElement).setFeatureID(-1);
//			}
//		}
//
//		return rodinElement;
//	}
	
	
}
