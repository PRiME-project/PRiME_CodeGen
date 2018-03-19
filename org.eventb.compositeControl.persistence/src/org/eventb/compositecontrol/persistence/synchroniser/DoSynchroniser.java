package org.eventb.compositecontrol.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.compositecontrol.persistence.IDo;
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


public class DoSynchroniser extends EMFToTaskBodySynchroniser  {
	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	
	EStructuralFeature feature = CorePackage.eINSTANCE.getEventBElement_Extensions();	//	default - shouldn't be used really

//	static {
//		handledAttributes.add(IAutoTask_Machine.AUTOTASK_MACHINE_ATTRIBUTE);
//	}

//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		
//		return ITaskBody.ELEMENT_TYPE;
//		
//		//	CHANGED Feb2012 release		
//		//return IDo.ELEMENT_TYPE;
//	}
	
	protected void setFeature(EStructuralFeature f)
	{
		this.feature = f;
	}

	@Override
	protected EStructuralFeature getFeature() {
//		EStructuralFeature f = CompositeControlPackage.eINSTANCE.
//		return CorePackage.eINSTANCE.getEventBElement_Extensions();
		
		return feature;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}

	@Override
	protected EventBElement createEventBElement() {
		return CompositeControlFactory.eINSTANCE.createDo();
	}
	
//	@Override
//	/**
//	 * Takes the EMF Do and produces a TaskBody rodin element with the proper contents.
//	 */
//	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws RodinDBException 
//	{
//		//	Get the TaskBody element
//		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
//		
//		//	Convert the EMF to a string
//		convertEMFToRodin(emfElement, (ITaskBody)rodinElement);
//		
//		return rodinElement;
//	}
//	
	

	
	
//	OLD LOAD AND SAVE - NOT USED FROM Feb2012 release	
//	@Override
	/**
	 * This will not be called by new method of translation.
	 * As all CompositeControl elements are handled as a TaskBody string.
	 * @throws CoreException 
	 * 
	 */
	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws CoreException {
		
		if (canLoad(emfParent))
		{
			//	Reset feature type to default
			feature = CorePackage.eINSTANCE.getEventBElement_Extensions();
			
	//		Load the feature type
			if (rodinElement instanceof IDo)
			{
				//	Will cause everything to crash if feature id isn't set
				int feature = ((IDo)rodinElement).getFeatureID();
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
			
			
		
			
	
			Do eventBElement = (Do) super.load(rodinElement, emfParent, monitor);
			
			if (rodinElement instanceof IDo)
			{
				IDo rElement = (IDo)rodinElement;
				eventBElement.setLabel(rElement.getLabel());
			}
			
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
	
	
//	OLD VERSION - PRE-Feb 2012 release
//	No longer persists to rodin version of Do, instead persists to a TaskBody element with a string containing
//	the entire TaskBody.
//	@Override
//	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws RodinDBException {
//			
//		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
//		
//		if (rodinElement instanceof IDo && emfElement instanceof Do) 
//		{
//			IDo rElement = (IDo) rodinElement;
//			Do eventBElement = (Do)emfElement;
//			
//			rElement.setLabel(eventBElement.getLabel());
//			
//			
//			
//			
//			if (emfElement.eContainer() instanceof Seq)
//			{
//				if (((Seq)emfElement.eContainer()).getLeftBranch() == emfElement)
//				{
//					((IDo)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_LeftBranch().getFeatureID());
//				}
//				else if (((Seq)emfElement.eContainer()).getRightBranch() == emfElement)
//				{
//					((IDo)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getSeq_RightBranch().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Do)
//			{
//				if (((Do)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IDo)rodinElement).setFeatureID(CompositeControlPackage.eINSTANCE.getDo_TaskBody().getFeatureID());
//				}
//			}
//			else if (emfElement.eContainer() instanceof Task)
//			{
//				if (((Task)emfElement.eContainer()).getTaskBody() == emfElement)
//				{
//					((IDo)rodinElement).setFeatureID(TaskingPackage.eINSTANCE.getTask_TaskBody().getFeatureID());
//				}
//			}
//			else
//			{
//				//	Set default feature id
//				((IDo)rodinElement).setFeatureID(-1);
//			}
//	//		Can't have a Do here (or anything else)
//	//		else if (emfElement.eContainer() instanceof Branch)
//	//		{
//	//			
//	//		}
//	//		else if (emfElement.eContainer() instanceof SubBranch)
//	//		{
//	//			
//	//		}
//	//		else if (emfElement.eContainer() instanceof EventWrapper)
//	//		{
//	//			
//	//		}
//			
//			
//		}
//
//		return rodinElement;
//	}
}
