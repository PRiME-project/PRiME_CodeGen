package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

import compositeControl.SubBranch;

public class SubBranchEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName, TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		SubBranch actualSource = (SubBranch) source;
		
		translationManager.translateToEventB(actualSource.getEventWrapper(), machine, waitGuard, forceGuardName);
		translationManager.translateToEventB(actualSource.getSubBranch(), machine, waitGuard, forceGuardName);
				
		return forceGuardName;
	}

}
