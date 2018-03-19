package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;

import tasking.Shared_Machine;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

public class IncludedMachineTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		IncludedMachine actualSource = (IncludedMachine)source;
		
		for (AbstractExtension ext : actualSource.getExtensions())
		{
			if (ext instanceof Shared_Machine)
			{
				translationManager.addSharedMachineName(actualSource.getMachineName());
			}
		}
		
		return null;
	}

}
