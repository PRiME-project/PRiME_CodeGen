package org.eventb.codegen.il1.translator;

public abstract class AbstractPredicateExpressionTranslator {

	/**
	 * The entry point for the translator.
	 * 
	 * Will provide the command and the source string to be translated. 
	 * Eg.  a mod b would provide, command: mod, sourceString: a mod b.
	 * The IL1TranslationManager will need to be updated to do this though.
	 * 
	 * The IL1TranslationManager given can be used to contain any other objects that need 
	 * to be passed to the translator.
	 * 
	 * Input parameters can be changed if needed, as the IL1Translator has not been coded fully yet
	 * anyway.
	 * 
	 * @param command
	 * @param sourceString
	 * @param translationManager
	 * @return
	 * @throws IL1TranslationUnhandledTypeException
	 */
	public abstract String translate(String command, String sourceString, IL1TranslationManager translationManager) throws IL1TranslationUnhandledTypeException;
	
}
