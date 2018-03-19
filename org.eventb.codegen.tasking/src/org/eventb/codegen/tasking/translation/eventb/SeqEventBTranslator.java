package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

import compositeControl.Seq;

public class SeqEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName, TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		Seq actualSource = (Seq) source;		
		String updatedGuard1 = translationManager.translateToEventB(actualSource.getLeftBranch(), machine, waitGuard);
		String updatedGuard2 = translationManager.translateToEventB(actualSource.getRightBranch(), machine, updatedGuard1);
		
		return updatedGuard2;
	}

}
