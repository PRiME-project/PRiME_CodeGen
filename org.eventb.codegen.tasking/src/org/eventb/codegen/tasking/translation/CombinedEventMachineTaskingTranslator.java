package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;

public class CombinedEventMachineTaskingTranslator extends
		AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		CombinedEventMachine actualSource = (CombinedEventMachine) source;

		// Returns the previously translated task or protected

		Protected p = translationManager.getSharedMachineTranslation(
				actualSource.getProjectName(), actualSource.getMachineName());
		if (p != null) {
			return p;
		} else {
			EnvironTask et = translationManager.getEnvironMachineTranslation(
					actualSource.getProjectName(),
					actualSource.getMachineName());
			if (et != null) {
				return et;
			} else {
				Protected fmu = translationManager.getFMUMachineTranslation(
						actualSource.getProjectName(),
						actualSource.getMachineName());
				if (fmu != null) {
					return fmu;
				} else {
					Task t = translationManager.getLocalMachineTranslation(
							actualSource.getProjectName(),
							actualSource.getMachineName());
					return t;
				}
			}
		}
	}
}
