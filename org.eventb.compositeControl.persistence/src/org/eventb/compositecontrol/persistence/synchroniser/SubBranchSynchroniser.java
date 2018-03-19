package org.eventb.compositecontrol.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.compositecontrol.persistence.ISubBranch;
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
import compositeControl.SubBranch;

public class SubBranchSynchroniser extends EMFToTaskBodySynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	EStructuralFeature feature = CorePackage.eINSTANCE.getEventBElement_Extensions();	//	default

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return ISubBranch.ELEMENT_TYPE;
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
		return CompositeControlFactory.eINSTANCE.createSubBranch();
	}
	
	
	
	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		if (canLoad(emfParent))
		{
			//	Reset feature type to default
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
			
			//	Load the feature type
			if (rodinElement instanceof ISubBranch)
			{
				//	Will cause everything to crash if feature id isn't set
				int feature = ((ISubBranch)rodinElement).getFeatureID();
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
				else if (emfParent instanceof Branch)
				{
					if (feature == CompositeControlPackage.eINSTANCE.getBranch_SubBranch().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getBranch_SubBranch();
					}
				}
				else if (emfParent instanceof SubBranch)
				{
					if (feature == CompositeControlPackage.eINSTANCE.getSubBranch_SubBranch().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getSubBranch_SubBranch();
					}
				}
			}
			
			
			SubBranch eventBElement = (SubBranch) super.load(rodinElement, emfParent, monitor);
					
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
//		if (rodinElement instanceof ISubBranch && emfElement instanceof SubBranch) 
//		{
//						//	Set feature ID
//			if (emfElement.eContainer() instanceof Seq)
//			{
//				if (((Seq)emfElement.eContainer()).getLeftBranch() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID());
//				}
//				else if (((Seq)emfElement.eContainer()).getRightBranch() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Do)
//			{
//				if (((Do)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Task)
//			{
//				if (((Task)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Branch)
//			{
//				if (((Branch)emfElement.eContainer()).getSubBranch() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getBranch_SubBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof SubBranch)
//			{
//				if (((SubBranch)emfElement.eContainer()).getSubBranch() == emfElement)
//				{
//					((ISubBranch)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSubBranch_SubBranch().getFeatureID());
//				}
//			}
//			else
//			{
//				//	Set default feature id
//				((ISubBranch)rodinElement).setFeatureID(-1);
//			}
//		}
//		
//
//		return rodinElement;
//	}
}
