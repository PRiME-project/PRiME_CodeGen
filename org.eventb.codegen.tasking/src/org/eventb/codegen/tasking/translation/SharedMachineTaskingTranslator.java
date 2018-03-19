package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

import tasking.impl.Shared_MachineImpl;

public class SharedMachineTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement element, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		Shared_MachineImpl actualElement = (Shared_MachineImpl)element;
		
		Protected out = translationManager.getIL1Factory().createProtected();
		
		
		//	Nothing much more to do here, as the SharedMachine label doesn't contain anything else!
		
		return out;	
	}

}
