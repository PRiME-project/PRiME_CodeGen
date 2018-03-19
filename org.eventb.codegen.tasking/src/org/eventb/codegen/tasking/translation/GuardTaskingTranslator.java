package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.ConditionSet;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Guard;

public class GuardTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		ConditionSet actualTarget = Il1Factory.eINSTANCE.createConditionSet();
		Guard actualSource = (Guard)source;
		
		System.out.println("GuardTaskingTranslator: " + actualSource.getName());
		
		String e = actualSource.getPredicate();		
		
		actualTarget.getConditions().add(e);
		
		
		return actualTarget;
	}
}
