package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Invariant;

import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

public class ComposedMachineTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		ComposedMachine actualSource = (ComposedMachine)source;
		Protected actualTarget = translationManager.getIL1Factory().createProtected();
		
		actualTarget.setName(actualSource.getName());
		
		//	Load the IncludedMachines
		for (IncludedMachine iMachine : actualSource.getIncludes())
		{
			translationManager.translate(iMachine);					
		}
		
		//	Translate the Invariants
		for (Invariant invariant : actualSource.getInvariants())
		{
			translationManager.translate(invariant);
		}
		
		//	Translate the ComposedEvents
		for (ComposedEvent cEvent : actualSource.getComposesEvents())
		{
			translationManager.translate(cEvent);
		}

		return actualTarget;
	}

}
