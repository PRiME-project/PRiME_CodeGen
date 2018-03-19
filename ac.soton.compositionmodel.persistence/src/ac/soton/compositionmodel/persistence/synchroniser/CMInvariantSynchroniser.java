package ac.soton.compositionmodel.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.eventb.emf.persistence.synchroniser.InvariantSynchroniser;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;



/**
 * 
 * @author Chris
 *
 * Separate InvariantSynchroniser needed to give correct feature ID.
 * 
 * This works fine on saving without modification but needs the modification provided here for loading.
 * 
 * As Invariants are components of Machine and ComposedMachine the InvariantSynchroniser will not work
 * with ComposedMachine, as the synchroniser will return a Machine.Invariant feature, rather than 
 * ComposedMachine.feature.
 * 
 * Cannot just provide its own synchroniser either as this will overload the Invariant synchroniser in all cases.
 * 
 * So when loading need to identify what the parent class is (either Machine or ComposedMachine). Can then 
 * have the synchroniser return the correct feature type as appropriate.
 *
 */



public class CMInvariantSynchroniser extends InvariantSynchroniser {

	final private int FEATURES_COMPOSEDMACHINE = 0;
	final private int FEATURES_MACHINE = 1;
	protected int featureType = FEATURES_COMPOSEDMACHINE;

	/**
	 * Overloaded version of getFeature.
	 * It will return the feature ID based on what class was observed when it was loaded.
	 */
	@Override
	protected EStructuralFeature getFeature() {		
		switch (featureType)
		{
			case FEATURES_COMPOSEDMACHINE:
				return CompositionmodelPackage.eINSTANCE.getComposedMachine_Invariants();				
			case FEATURES_MACHINE:
			default:
				return super.getFeature();
		
		}
	}
	
	
	
	/**
	 * Overloaded version of load. 
	 * It will determine the parent class, set the internal feature ID representation, then continue 
	 * with a normal load.
	 * @throws CoreException 
	 */
	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws CoreException {
		
		if (emfParent instanceof MachineImpl)
			featureType = FEATURES_MACHINE;
		else
			featureType = FEATURES_COMPOSEDMACHINE;
		
		return super.load(rodinElement, emfParent, monitor);
	}
}
