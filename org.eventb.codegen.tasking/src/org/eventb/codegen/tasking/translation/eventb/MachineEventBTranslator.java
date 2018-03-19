package org.eventb.codegen.tasking.translation.eventb;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.RodinToEMFConverter;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.impl.MachineImpl;

import tasking.AbstractExtensionTaskingElement;
import tasking.Task;

public class MachineEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		MachineImpl actualSource = TaskingTranslationManager
				.clearAllGeneratedElements((MachineImpl) source);

		// Store all of the events so can get back to them from the proxy
		// elements
		for (Event e : actualSource.getEvents()) {
			translationManager.storeEventBElement(e, machine.getName(), e.getName());

		}

		for (EObject eObj : actualSource.eContents()) {
			if (eObj instanceof Task)
			// || eObj instanceof Shared_Machine) -- should do nothing with
			// Shared_Machines
			{
				// Task will be any AutoTaskMachine, TaskingMachine or
				// EnvironMachine
				// Shared_Machine will be a SharedMachine

				// First add init invariant
				waitGuard = "init";
				EventBTranslatorHelpers.addNewProgramCounter(waitGuard,
						actualSource, "TRUE");

				translationManager.translateToEventB(
						(AbstractExtensionTaskingElement) eObj, actualSource,
						waitGuard);
			}
		}

		// Save the machine

		String projectName = translationManager.getProjectName(actualSource);

		saveMachine(actualSource, projectName);

		return null;
	}

	public static void saveMachine(MachineImpl machine, String projectName) {
		try {

			RodinToEMFConverter.saveMachine(machine, projectName);

		} catch (Exception e) {

			Status s = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: Exception: "  + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
			

		}
	}
}
