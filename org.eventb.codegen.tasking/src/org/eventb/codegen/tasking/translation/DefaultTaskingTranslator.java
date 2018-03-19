package org.eventb.codegen.tasking.translation;

import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

public class DefaultTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement element, IL1Element target, TaskingTranslationManager translationManager) throws TaskingTranslationUnhandledTypeException {
		System.out.println("DefaultTaskingTranslator: " + element);
		
		
		for (EObject obj : element.eContents())
		{
	//		translationManager.translate(obj);
		}
		
		return null;
	}

}
