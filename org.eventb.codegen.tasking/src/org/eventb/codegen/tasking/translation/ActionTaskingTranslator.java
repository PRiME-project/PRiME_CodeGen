package org.eventb.codegen.tasking.translation;

import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.impl.EventImpl;

public class ActionTaskingTranslator extends AbstractTaskingTranslator {

	
	//	Actions should just give an Action
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
		throws TaskingTranslationUnhandledTypeException
	{
		Action actualSource = (Action)source;
		org.eventb.codegen.il1.Action actualTarget = Il1Factory.eINSTANCE.createAction();
		
		actualTarget.setAction(actualSource.getAction());
		EObject obj = actualSource.eContainer();
		if(obj instanceof EventImpl){
			EventImpl parentEvent = (EventImpl) obj;
			actualTarget.setParentEventName(parentEvent.getName());
		}
		
		return actualTarget;
	}
}
