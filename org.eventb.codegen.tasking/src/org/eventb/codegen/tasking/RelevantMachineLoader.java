package org.eventb.codegen.tasking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEventBProject;
import org.eventb.core.IExtendsContext;
import org.eventb.core.IMachineRoot;
import org.eventb.core.ISeesContext;
import org.eventb.core.basis.ContextRoot;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.context.impl.ContextImpl;
import org.rodinp.core.IRodinDB;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.CompositionPlugin;
import ac.soton.composition.core.basis.ComposedMachineRoot;
import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

public class RelevantMachineLoader {

	public static RMLDataStruct getAllRelevantMachines(Object[] selected)
			throws TaskingTranslationUnhandledTypeException, RodinDBException {
		// Work out what projects are being used and load in all
		// ComposedMachines from them
		// This assumes only the Machines are selected for translation
		// Other machines can be added, though will be ignored here
		RMLDataStruct output = new RMLDataStruct();
		output.contextContainerMap = new HashMap<String, String>();

		ArrayList<IRodinProject> projects = new ArrayList<IRodinProject>();
		ArrayList<String> selectedMachines = new ArrayList<String>();
		for (Object obj : selected) {
			if (obj instanceof MachineRoot) {
				MachineRoot m = (MachineRoot) obj;
				IRodinProject p = m.getRodinProject();
				if (!projects.contains(p))
					projects.add(p);

				selectedMachines.add(p.getElementName() + "/"
						+ m.getElementName());
			} else if (obj instanceof ComposedMachineRoot) {
				ComposedMachineRoot cm = (ComposedMachineRoot) obj;
				IRodinProject p = cm.getRodinProject();

				if (!projects.contains(p))
					projects.add(p);
			}
		}

		// Now find all ComposedMachines in those projects
		// Want things ending with .bcp file extension
		ArrayList<ComposedMachine> composedMachines = new ArrayList<ComposedMachine>();
		for (IRodinProject p : projects) {
			String cmName = "";
			try {
				IRodinElement[] members = p.getChildren();

				for (IRodinElement m : members) {
					ComposedMachineRoot cmRoot = null;
					if (m.getElementName().endsWith(".bcp")) {
						// Load the RodinDatabase composed machine
						cmRoot = (ComposedMachineRoot) CompositionPlugin
								.asComposedMachineFile(m);
						// Convert to EMF
						ComposedMachine cm = RodinToEMFConverter
								.loadComposedMachine(cmRoot);
						if(cm != null){composedMachines.add(cm);}
					}
				}
			} catch (Exception e) {
				Status s = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
						"Exception: Failed to load ComposedMachine " + cmName
								+ ": " + e.getMessage(), e);
				StatusManager.getManager().handle(s, StatusManager.SHOW);
			}
		}

		// ****************************************
		// ****************************************
		// For debug - previous composed machine load failures should be fixed

		// Output all composed machines that have been successfully loaded
		// System.out.println("Number composed machines loaded: " +
		// composedMachines.size());
		// for (ComposedMachine cm : composedMachines)
		// {
		// System.out.println("ComposedMachine loaded: " + cm.getName());
		// }

		// ****************************************

		// Place in arraylist so it can be resized if more machines need to be
		// loaded
		ArrayList<Object> listArrList = new ArrayList<Object>();
		ArrayList<ComposedMachine> mustLoadComposedMachines = new ArrayList<ComposedMachine>();
		// ArrayList<String> mustLoadComposedMachineNames = new
		// ArrayList<String>();
		for (Object o : selected) {
			// As composed machines are handled separately
			if (o instanceof ComposedMachineRoot) {
				ComposedMachine cm = RodinToEMFConverter
						.loadComposedMachine((ComposedMachineRoot) o);
				mustLoadComposedMachines.add(cm);
			} else {
				listArrList.add(o);
			}
		}

		// Load all of the ComposedEvents and store them
		// Map Project/Machine/Event_name to ComposedMachine name
		Map<String, String> composedEvents = new HashMap<String, String>();
		ArrayList<String> composedMachineNames = new ArrayList<String>();

		// Load the selected CMs
		ArrayList<String> loadedCMs = new ArrayList<String>();
		for (ComposedMachine cm : mustLoadComposedMachines) {
			loadComposedMachineIncludedMachines(cm, selectedMachines,
					composedEvents, composedMachineNames, listArrList, true);
			// Should include project name here
			loadedCMs.add(cm.getName());
		}

		// Load any other relevant CMs
		for (ComposedMachine cm : composedMachines) {
			if (!loadedCMs.contains(cm.getName())) {
				loadComposedMachineIncludedMachines(cm, selectedMachines,
						composedEvents, composedMachineNames, listArrList,
						false);
			}
		}

		// Removed condition as list can shrink due to ComposedMachines being
		// removed
		// Can also stay the same size but with different elements if
		// ComposedMachines are removed and
		// other machines added
		// if (listArrList.size() > list.length)

		// Load all contexts
		ArrayList<String> contextNamesLoaded = new ArrayList<String>();
		ArrayList<ContextImpl> contexts = new ArrayList<ContextImpl>();
		for (Object o : listArrList) {
			if (o instanceof IMachineRoot) {
				IMachineRoot root = (IMachineRoot) o;
				ISeesContext[] sees = root.getSeesClauses();
				// iterate through the machines' seen contexts
				for (ISeesContext s : sees) {
					IContextRoot cr = s.getSeenContextRoot();
					processContextRoot(output, contextNamesLoaded, contexts, cr);
				}

			} else {
				System.out
						.println("org.eventb.codegen.tasking::RelevantMachineLoader - o is not an "
								+ "IMachineRoot - needs to be looked at");

			}
		}

		// return listArrList.toArray();

		output.machineArray = listArrList.toArray();
		output.composedEventMap = composedEvents;
		output.composedMachineNameList = composedMachineNames;
		output.composedMachineList = composedMachines;
		output.contextList = contexts;

		return output;
	}

	/**
	 * @param output
	 * @param contextNamesLoaded
	 * @param contexts
	 * @param sees
	 * @throws RodinDBException
	 */
	private static void processContextRoot(RMLDataStruct output,
			ArrayList<String> contextNamesLoaded,
			ArrayList<ContextImpl> contexts, IContextRoot cr)
			throws RodinDBException {

		// iterate through the contexts extended contexts
		IExtendsContext[] extendsClauses = cr.getExtendsClauses();
		for (IExtendsContext extCtx : extendsClauses) {
			IContextRoot seenCR = extCtx.getAbstractContextRoot();
			// recurse through the extended contexts, adding the relevant info
			// as #1 below
			processContextRoot(output, contextNamesLoaded, contexts, seenCR);
		}

		// #1
		// add the context containment info
		output.contextContainerMap.put(cr.getElementName(), cr.getRodinProject()
				.getElementName());

		String cName = cr.getEventBProject() + "/" + cr.getElementName();
		if (!contextNamesLoaded.contains(cName)) {
			ContextImpl context = (ContextImpl) RodinToEMFConverter
					.loadContext((ContextRoot) cr);
			contextNamesLoaded.add(cName);
			contexts.add(context);
		}

	}

	/**
	 * 
	 * @param cm
	 *            ComposedMachine to load the included machines for
	 * @param selectedMachines
	 *            List of Machine names that have been selected by the user
	 * @param composedEvents
	 *            Mapping for ComposedEvents to write to
	 * @param composedMachineNames
	 *            List of ComposedMachine names to write to
	 * @param listArrList
	 *            List to put loaded machines in
	 * @param mustLoad
	 *            Whether to force the loading of the included machines (ie.
	 *            this CM was selected by the user)
	 */
	private static void loadComposedMachineIncludedMachines(ComposedMachine cm,
			ArrayList<String> selectedMachines,
			Map<String, String> composedEvents,
			ArrayList<String> composedMachineNames,
			ArrayList<Object> listArrList, boolean mustLoad) {
		// Check to see if any of those machines are also selected
		boolean isOneMachineSelected = false;
		for (IncludedMachine im : cm.getIncludes()) {
			if (selectedMachines.contains(im.getProjectName() + "/"
					+ im.getMachineName()))
				isOneMachineSelected = true;
		}

		// Only load in Included machines if the CM has been selected
		// OR one of the Included machines has been selected
		if (isOneMachineSelected || mustLoad) {

			// Identify all the machines that are composed
			for (IncludedMachine im : cm.getIncludes()) {
				composedMachineNames.add(im.getProjectName() + "/"
						+ im.getMachineName());
			}

			for (ComposedEvent ce : cm.getComposesEvents()) {
				for (CombinedEventMachine cem : ce.getCombinesEvents()) {
					composedEvents.put(
							cem.getProjectName() + "/" + cem.getMachineName()
									+ "/" + cem.getEventName(), cm.getName());

					// Check if the machine has been loaded
					String machineName = cem.getProjectName() + "/"
							+ cem.getMachineName();
					if (!selectedMachines.contains(machineName)) {

						// Get the project
						IRodinDB rodinDB = RodinCore.getRodinDB();
						IRodinProject rodinProject = rodinDB
								.getRodinProject(cem.getProjectName());
						IEventBProject eventBProject = (IEventBProject) rodinProject
								.getAdapter(IEventBProject.class);
						IMachineRoot machineRoot = eventBProject
								.getMachineRoot(cem.getMachineName());

						// Pass the MachineRoot as the translator will load
						// whatever is required
						listArrList.add(machineRoot);

						// Add machine to selected machine names so it isn't
						// loaded again
						selectedMachines.add(machineName);
					}
				}
			}
		}
	}

}
