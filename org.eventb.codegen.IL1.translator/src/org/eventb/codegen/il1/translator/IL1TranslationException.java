package org.eventb.codegen.il1.translator;


public class IL1TranslationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -399206082947927193L;

	
	public IL1TranslationException(Object errorObject, String message)
	{
		super("\nError Translating: " + errorObject.toString() + " :" + message);
	}


	public IL1TranslationException(String string) {
		super(string);
	}
	
}
