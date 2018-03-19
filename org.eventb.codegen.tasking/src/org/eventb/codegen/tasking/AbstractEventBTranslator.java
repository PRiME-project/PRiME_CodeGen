package org.eventb.codegen.tasking;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.impl.MachineImpl;

public abstract class AbstractEventBTranslator {

	/**
	 * 
	 * @param source The element to translate
	 * @param machine The machine this element belongs to.
	 * @param waitGuard The program counter guard the next action must wait for to be true
	 * @param forceGuardName Set if the translation should use a particular guard name. If set then the guard (program counter) should have been added to the Invariants bythe caller.
	 * @param translationManager The translation manager being used
	 * @return The next wait guard
	 * @throws TaskingTranslationUnhandledTypeException
	 */
	public abstract String translate(EventBElement source, MachineImpl machine, String waitGuard, String forceGuardName, TaskingTranslationManager translationManager) throws TaskingTranslationUnhandledTypeException;
}
