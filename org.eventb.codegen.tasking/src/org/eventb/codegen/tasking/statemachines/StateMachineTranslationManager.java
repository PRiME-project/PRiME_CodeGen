package org.eventb.codegen.tasking.statemachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.translation.StatemachineTranslator;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.statemachines.impl.StatemachineImpl;

public class StateMachineTranslationManager {

	// This method is the entry point for conversion from a
	// Task's statemachine to IL1
	public List<Call> translate(Machine actualSource, IL1Element actualTarget,
			TaskingTranslationManager translationManager) {
		// if we have reached here, the statemachine translation is installed
		// so we need to obtain any statemachines and process them

		// The enums associated with the Task will reside in the top level of
		// the program
		// for translation to globals.

		EList<AbstractExtension> exts = actualSource.getExtensions();
		List<Call> callList = new ArrayList<Call>();

		for (AbstractExtension ext : exts) {
			if (ext instanceof StatemachineImpl) {
				StatemachineImpl s = (StatemachineImpl) ext;
				StatemachineTranslator statemachineTranslator = new StatemachineTranslator();
				try {
					// add to a list of calls
					callList.add(statemachineTranslator.translate(s,
							actualTarget, translationManager));
				} catch (TaskingTranslationException e) {
					Status status = new Status(IStatus.ERROR,
							CodeGenTasking.PLUGIN_ID,
							"Failed Translation: TaskingTranslationException:"
									+ e.getMessage(), e);
					StatusManager.getManager().handle(status,
							StatusManager.SHOW);
				}
			}
		}
		return callList;
	}
}
