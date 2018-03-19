package org.eventb.codegen.tasking;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.emf.core.EventBElement;

//	Does some kind of abstract translation stuff

public abstract class AbstractTaskingTranslator {

	public abstract IL1Element translate(EventBElement source, IL1Element target, TaskingTranslationManager translationManager) throws TaskingTranslationException;
	
	/**
	 * Set this to true if you want the translation manager to keep 
	 * a reference of the translated object in the translation manager for it to be 
	 * easily obtainable later by another part of the translation.
	 * Normally this will be false.
	 * 
	 * Eg. Used in Event (EventTaskingTranslator), as other elements will reference the event elsewhere.
	 * 
	 * This is called directly after the translation. So overloaded methods can dynamically select result based on translation.
	 * Eg. Store and Event when it is translated, but do not store a proxy of an Event.
	 * @return
	 */
	public boolean canStoreTranslationInTranslationManager()
	{
		return false;
	}
}
