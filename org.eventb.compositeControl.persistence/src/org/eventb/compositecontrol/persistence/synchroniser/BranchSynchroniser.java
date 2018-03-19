package org.eventb.compositecontrol.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.compositecontrol.persistence.IBranch;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Task;
import tasking.TaskingPackage;
import compositeControl.Branch;
import compositeControl.CompositeControlFactory;
import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.Seq;

public class BranchSynchroniser  extends EMFToTaskBodySynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();

	EStructuralFeature feature = CorePackage.eINSTANCE.getEventBElement_Extensions();	//	default 
	
//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return IBranch.ELEMENT_TYPE;
//	}

	@Override
	protected EStructuralFeature getFeature() {
		return feature;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return CompositeControlFactory.eINSTANCE.createBranch();
	}
	
//	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		
		if (canLoad(emfParent))
		{
			//	Reset feature type to default
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
			
			//	Load the feature type
			if (rodinElement instanceof IBranch)
			{
				//	Will cause everything to crash if feature id isn't set
				int feature = ((IBranch)rodinElement).getFeatureID();
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
			
			
			Branch eventBElement = (Branch) super.load(rodinElement, emfParent, monitor);
			
			if (rodinElement instanceof IBranch)
			{
				IBranch rElement = (IBranch)rodinElement;
				eventBElement.setLabel(rElement.getLabel());
			}
			
			
			//	Reset feature type to default
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
//		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
//		
//		if (rodinElement instanceof IBranch && emfElement instanceof Branch) 
//		{
//			IBranch rElement = (IBranch) rodinElement;
//			Branch eventBElement = (Branch)emfElement;
//			
//			rElement.setLabel(eventBElement.getLabel());
//			
//		
//			//	Set feature ID
//			if (emfElement.eContainer() instanceof Seq)
//			{
//				if (((Seq)emfElement.eContainer()).getLeftBranch() == emfElement)
//				{
//					((IBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID());
//				}
//				else if (((Seq)emfElement.eContainer()).getRightBranch() == emfElement)
//				{
//					((IBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Do)
//			{
//				if (((Do)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Task)
//			{
//				if (((Task)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IBranch)rodinElement).setFeatureID(TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID());
//				}
//			}
//			else
//			{
//				//	Set default feature id
//				((IBranch)rodinElement).setFeatureID(-1);
//			}
//		}
//		
//
//		return rodinElement;
//	}
}
