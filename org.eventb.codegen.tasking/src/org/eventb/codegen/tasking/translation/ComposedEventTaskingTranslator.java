package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;

public class ComposedEventTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {
	
		ComposedEvent actualSource = (ComposedEvent)source;
		Subroutine actualTarget = null;
		
		System.out.println("ComposedEventTaskingTranslator: " + actualSource.getName());
				
		Protected p = null;
		Task t = null;
		
		String pEventName = "";
		String tEventName = "";
		
		//	Only translate when the number of combined events is greater than one
		if (actualSource.getCombinesEvents().size() > 1)
		{		
			for (CombinedEventMachine cEvent : actualSource.getCombinesEvents())
			{			
				//	Translate the combined events
				IL1Element iEvent = translationManager.translate(cEvent);
				
				if (iEvent instanceof Protected)
				{
					p = (Protected)iEvent;
					pEventName = cEvent.getEventName();
				}
				else if (iEvent instanceof Task)
				{
					t = (Task) iEvent;
					tEventName = cEvent.getEventName();
				}
			}
		}
		
		if (t == null || p == null)
		{
			System.err.println("ComposedEventTranslator: Missing local or remote event in " + actualSource.getName());
		}
		
		return actualTarget;
	}

}
