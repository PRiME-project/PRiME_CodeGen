
//
// REMOVED LISTING FROM PLUGIN.xml AS WELL
//
//package org.eventb.compositecontrol.persistence.synchroniser;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eventb.emf.core.EventBElement;
//import org.eventb.emf.core.machine.impl.MachineImpl;
//import org.eventb.emf.persistence.synchroniser.EventSynchroniser;
//import org.rodinp.core.IRodinElement;
//import org.rodinp.core.RodinDBException;
//
//import compositeControl.CompositeControlPackage;
//
//
//public class CompositeControlEventSynchroniser extends EventSynchroniser {
//		
//	final private int FEATURES_MACHINE = 0;
//	final private int FEATURES_SYNCHEVENTS = 1;
//	protected int featureType = FEATURES_SYNCHEVENTS;
//
//	/**
//	 * Overloaded version of getFeature.
//	 * It will return the feature ID based on what class was observed when it was loaded.
//	 */
//	@Override
//	protected EStructuralFeature getFeature() {		
//		switch (featureType)
//		{
//			case FEATURES_SYNCHEVENTS:
//				return CompositeControlPackage.eINSTANCE.getEventWrapper_Events();				
//			case FEATURES_MACHINE:
//			default:
//				return super.getFeature();
//		
//		}
//	}
//	
//	
//	
//	/**
//	 * Overloaded version of load. 
//	 * It will determine the parent class, set the internal feature ID representation, then continue 
//	 * with a normal load.
//	 */
//	@Override
//	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws RodinDBException {
//		
//		if (emfParent instanceof MachineImpl)
//			featureType = FEATURES_MACHINE;
//		else
//			featureType = FEATURES_SYNCHEVENTS;
//		
//		return super.load(rodinElement, emfParent, monitor);
//	}
//}
