package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

public class PeriodicTaskTypeTranslator extends AbstractTaskingTranslator{

	@Override
	public IL1Element translate(EventBElement element, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		tasking.PeriodicTaskType actualElement = (tasking.PeriodicTaskType)element;
		PeriodicTaskType out = translationManager.getIL1Factory().createPeriodicTaskType();
		
		out.setPeriod(actualElement.getPeriod());
				
		return out;
	}

}
