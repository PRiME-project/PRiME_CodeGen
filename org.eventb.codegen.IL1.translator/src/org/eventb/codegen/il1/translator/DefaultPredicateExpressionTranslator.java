package org.eventb.codegen.il1.translator;

public class DefaultPredicateExpressionTranslator extends
		AbstractPredicateExpressionTranslator {

	@Override
	public String translate(String command, String sourceString,
			IL1TranslationManager translationManager)
			throws IL1TranslationUnhandledTypeException {
		//	As no other information is given about how to translate the command, 
		//	just return the source string.
		return sourceString;
	}

}
