package org.eventb.codegen.il1.translator;

import org.eclipse.emf.ecore.EObject;

public class IL1TranslationUnhandledTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3535743665651787546L;

	
	IL1TranslationUnhandledTypeException(EObject unhandledObject, TargetLanguage language)
	{
		super("\nType: " + unhandledObject.toString() + "\nLanguage Core: " + language.getCoreLanguage() + " \nLanguage Specific: " + language.getSpecificLanguage());
	}
	
}
