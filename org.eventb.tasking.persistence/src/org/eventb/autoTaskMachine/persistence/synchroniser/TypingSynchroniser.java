//package org.eventb.autoTaskMachine.persistence.synchroniser;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eventb.emf.core.CorePackage;
//import org.eventb.emf.core.EventBElement;
//import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
//import org.eventb.tasking.persistence.ITyping;
//import org.rodinp.core.IAttributeType;
//import org.rodinp.core.IInternalElementType;
//import org.rodinp.core.IRodinElement;
//import org.rodinp.core.RodinDBException;
//
//import tasking.TaskingFactory;
//import tasking.Typing;
//
//public class TypingSynchroniser extends AbstractSynchroniser {
//	
//	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
//
//	@Override
//	protected IInternalElementType<?> getRodinType() {
//		return ITyping.ELEMENT_TYPE;
//	}
//
//	@Override
//	protected EStructuralFeature getFeature() {
//		return CorePackage.eINSTANCE.getEventBElement_Extensions();
//	}
//
//	@Override
//	protected Set<IAttributeType> getHandledAttributeTypes() {
//		return handledAttributes;
//	}
//
//	@Override
//	protected EventBElement createEventBElement() {
//		return TaskingFactory.eINSTANCE.createTyping();
//	}
//
//	@Override
//	public <T extends EventBElement> EventBElement load(IRodinElement rodinElement, EventBElement emfParent,IProgressMonitor monitor) throws RodinDBException {
//		Typing eventBElement = (Typing) super.load(rodinElement, emfParent, monitor);
//		//	No attributes to load		
////		if (rodinElement instanceof IParameterType)
////		{
////			//	No attributes to load
////					
////		}
//			
//		return eventBElement;
//	}
//
//	@Override
//	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws RodinDBException {
//		IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
////	No attributes to save		
////		if (rodinElement instanceof ITyping && emfElement instanceof Typing) 
////		{
////			//	Save the parameter type
////			ITyping imp = (ITyping)rodinElement;
////			Typing eventBElement = (Typing)emfElement;
////			imp.setParameterType(eventBElement.getParameterType());
////		}
//
//		return rodinElement;
//	}
//
//}
