package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.SimpleTaskType;
import org.eventb.codegen.il1.TaskTypeEnum;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

public class SimpleTaskTypeTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement element, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		tasking.SimpleTaskType actualElement = (tasking.SimpleTaskType)element;
		SimpleTaskType out = translationManager.getIL1Factory().createSimpleTaskType();
		out.setType(TaskTypeEnum.get(actualElement.getType().getValue()));		
				
		return out;
	}
}
