package org.eventb.codegen.tasking.flattening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eventb.core.EventBAttributes;
import org.eventb.core.IInvariant;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IRefinesMachine;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;

public class InvariantFlattenerUtils {
	
	private static final IInternalElement[] NO_ELEMENTS = new IInternalElement[0];
	
	// THIS IS SIMILAR TO THE org.eventb.ui EventFlattenerUtils and EventbUtils class
	// But we flatten Invariants instead of events
	
	/**
	 * Returns the child invariants of the abstractions of the given machine that are
	 * implicitly inherited through refinement.
	 * <p>
	 * The children returned, are sorted, with the children of the most abstract
	 * machine first. The order of invariants in each machine is preserved.
	 * </p>
	 * 
	 * @param machine
	 *            a machine
	 * @return an array of all children that are implicitly inherited by the
	 *         given machine through refinement
	 * @throws RodinDBException
	 *             if some problems occurs
	 */
	public static IInternalElement[] getImplicitChildren(IMachineRoot machine)
			throws RodinDBException {
		if (!machine.exists()) {
			return NO_ELEMENTS;
		}
		if (machine.getRefinesClauses().length == 0) {
			// No abstraction!
			return NO_ELEMENTS;
		}
		//populate a list of refined machines
		List<IMachineRoot> refinedMachines = new ArrayList<IMachineRoot>();
		getAbstractMachines(machine, refinedMachines);

		// populate a list of refined machine's invariants
		List<IInvariant> invariantList = new ArrayList<IInvariant>();
		getInvariants(refinedMachines, invariantList);
		
		final int size = invariantList.size();
		if (size == 0) {
			return NO_ELEMENTS;
		}
		return invariantList.toArray(new IInternalElement[size]);
	}

	private static void getInvariants(List<IMachineRoot> refinedMachines,
			List<IInvariant> invariantList) throws RodinDBException {
		String label = IMachineRoot.ELEMENT_TYPE.getName();
		for(IMachineRoot machineRoot: refinedMachines){
			IInvariant[] childInvariants = machineRoot.getChildrenOfType(IInvariant.ELEMENT_TYPE);
			for (IInvariant i: childInvariants) {
				if (i.hasAttribute(EventBAttributes.LABEL_ATTRIBUTE)
						&& label.equals(i.getLabel()));
				invariantList.add(i);
			}
		}
	}

	private static List<IMachineRoot> getAbstractMachines(IMachineRoot machine, List<IMachineRoot> refinedMachines) throws RodinDBException {
		// get a list of machines that this machine refines
		List<IRefinesMachine> refinesList = Arrays.asList(machine.getRefinesClauses());
		// for each refined machine add it to the list of refined machines, then call 
		// getAbstractMmachines on the refined machine
		for(IRefinesMachine refMch: refinesList){
			IMachineRoot abstractMachineRoot = refMch.getAbstractMachineRoot();
			refinedMachines.add(0,abstractMachineRoot);
			getAbstractMachines(abstractMachineRoot, refinedMachines);
		}
		return refinedMachines;
	}
}
