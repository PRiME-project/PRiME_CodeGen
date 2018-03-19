package org.eventb.compositecontrol.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.compositecontrol.persistence.IEventWrapper;
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
import compositeControl.EventWrapper;
import compositeControl.Seq;
import compositeControl.SubBranch;

public class EventWrapperSynchroniser extends EMFToTaskBodySynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	
	EStructuralFeature feature = CorePackage.eINSTANCE.getEventBElement_Extensions();	//	default - shouldn't be used really

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return IEventWrapper.ELEMENT_TYPE;
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
		return CompositeControlFactory.eINSTANCE.createEventWrapper();
	}
	
	@Override
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		if (canLoad(emfParent))
		{
	//		Reset feature type to default
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
			
	//		Load the feature type
			if (rodinElement instanceof IEventWrapper)
			{
				//	Will cause everything to crash if feature id isn't set
				int feature = ((IEventWrapper)rodinElement).getFeatureID();
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
					else if (feature == CompositeControlPackage.eINSTANCE.getDo_Finally().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getDo_Finally();
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
					if (feature == CompositeControlPackage.eINSTANCE.getBranch_EventWrapper().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getBranch_EventWrapper();
					}
					else if (feature == CompositeControlPackage.eINSTANCE.getBranch_Alt().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getBranch_Alt();
					}
				}
				else if (emfParent instanceof SubBranch)
				{
					if (feature == CompositeControlPackage.eINSTANCE.getSubBranch_EventWrapper().getFeatureID())
					{
						this.feature = CompositeControlPackage.eINSTANCE.getSubBranch_EventWrapper();
					}
				}			
			}
			
			EventWrapper eventBElement = (EventWrapper) super.load(rodinElement, emfParent, monitor);
			
			if (rodinElement instanceof IEventWrapper)
			{
				IEventWrapper rElement = (IEventWrapper)rodinElement;
				eventBElement.setLabel(rElement.getLabel());
				eventBElement.setEventName(rElement.getEventName());
			}			
			
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
//		if (rodinElement instanceof IEventWrapper && emfElement instanceof EventWrapper) 
//		{
//			IEventWrapper rElement = (IEventWrapper) rodinElement;
//			EventWrapper eventBElement = (EventWrapper)emfElement;
//			
//			rElement.setLabel(eventBElement.getLabel());
//			rElement.setEventName(eventBElement.getEventName());
//			
//			if (emfElement.eContainer() instanceof Seq)
//			{
//				if (((Seq)emfElement.eContainer()).getLeftBranch() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID());
//				}
//				else if (((Seq)emfElement.eContainer()).getRightBranch() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Do)
//			{
//				if (((Do)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID());
//				}
//				else if (((Do)emfElement.eContainer()).getFinally() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_Finally().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Task)
//			{
//				if (((Task)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Branch)
//			{
//				if (((Branch)emfElement.eContainer()).getEventWrapper() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getBranch_EventWrapper().getFeatureID());
//				}
//				else if (((Branch)emfElement.eContainer()).getAlt() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getBranch_Alt().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof SubBranch)
//			{
//				if (((SubBranch)emfElement.eContainer()).getEventWrapper() == emfElement)
//				{
//					((IEventWrapper)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSubBranch_EventWrapper().getFeatureID());
//				}
//			}
//			else
//			{
//				//	Set default feature id
//				((IEventWrapper)rodinElement).setFeatureID(-1);
//			}
//		}
//
//		return rodinElement;
//	}
}
