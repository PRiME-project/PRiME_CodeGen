package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

import tasking.AutoTask_Machine;
import tasking.PeriodicTaskType;

public class AutoTaskingMachineEventBTranslator extends
		AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName, TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		AutoTask_Machine actualSource = (AutoTask_Machine)source;
		
		
		String updatedGuard = translationManager.translateToEventB(actualSource.getTaskBody(), machine, waitGuard);
		
		if (actualSource.getTaskType() instanceof PeriodicTaskType)
		{
			//	Set the last event called to set init to true
			EventBTranslatorHelpers.replaceWithInitTrue(updatedGuard, "init", machine);
		}
				
		return updatedGuard;
	}

}
