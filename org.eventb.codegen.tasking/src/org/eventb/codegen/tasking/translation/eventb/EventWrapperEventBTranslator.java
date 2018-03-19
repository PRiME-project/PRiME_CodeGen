package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.impl.MachineImpl;

import compositeControl.EventWrapper;

public class EventWrapperEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		EventWrapper actualSource = (EventWrapper) source;

		MachineImpl parentMch = TaskingTranslationManager
				.getParentMachine(actualSource);

		// BEGIN NEW CODE
		// Event e = actualSource.getEvent();
		// END NEW CODE

		Event e = (Event) translationManager.getEventBElementFromStore(
				parentMch.getName(), actualSource.getEvent().getName());

		if (!e.getName().equals("INITIALISATION")) {

			// Create guard waitGuard=true
			EventBTranslatorHelpers.addNewGuard(e, waitGuard);

			String newWaitGuard = e.getName();

			// Use the required wait guard name if required
			if (forceGuardName != null)
				newWaitGuard = forceGuardName;

			// Create actions

			// Disable waitGuard
			EventBTranslatorHelpers.disableProgramCounter(e, waitGuard);

			// Only if creating a new program counter (ie haven't been
			// pre-assigned one)
			if (forceGuardName == null) {
				// Add new waitGuard program counter flag thingy
				EventBTranslatorHelpers.addNewProgramCounter(newWaitGuard,
						machine);
			}

			// Enable new wait guard
			EventBTranslatorHelpers.enableProgramCounter(e, newWaitGuard);

			return newWaitGuard;
		}

		return waitGuard;
	}

}
