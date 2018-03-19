package org.eventb.codegen.tasking.translation.eventb;

import org.eventb.codegen.tasking.AbstractEventBTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

import compositeControl.Branch;

public class BranchEventBTranslator extends AbstractEventBTranslator {

	@Override
	public String translate(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName, TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		Branch actualSource = (Branch)source;
				
		if (actualSource.getEventWrapper() != null)
		{			
			String guardName = "Branch" + actualSource.getEventWrapper().getEventName();
			
			//	All branches are at the same level, so take the same waitGuard
			translationManager.translateToEventB(actualSource.getEventWrapper(), machine, waitGuard,guardName);
			translationManager.translateToEventB(actualSource.getSubBranch(), machine, waitGuard,guardName);
			translationManager.translateToEventB(actualSource.getAlt(), machine, waitGuard,guardName);
			
			EventBTranslatorHelpers.addNewProgramCounter(guardName, machine);
			
			return guardName;	
		}
		else
		{
			System.out.println("Error: Branch does not have EventWrapper. " + actualSource);
			return waitGuard;
		}
			
	}

}
