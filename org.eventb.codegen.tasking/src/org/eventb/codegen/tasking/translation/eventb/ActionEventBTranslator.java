package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

public class ActionEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source,
			MachineImpl machine, String waitGuard, String forceGuardName, TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
	
		return waitGuard;
	}

}
