package org.eventb.codegen.tasking;

import org.eclipse.emf.ecore.EObject;

public class TaskingTranslationUnhandledTypeException extends TaskingTranslationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690604670071802424L;

	public TaskingTranslationUnhandledTypeException(EObject unhandledObject)
	{
		super(unhandledObject.toString());
	}
}
