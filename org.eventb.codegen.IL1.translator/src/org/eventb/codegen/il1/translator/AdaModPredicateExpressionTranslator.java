
package org.eventb.codegen.il1.translator;


@Deprecated
public class AdaModPredicateExpressionTranslator extends
		AbstractPredicateExpressionTranslator {

	@Override
	public String translate(String command, String sourceString,
			IL1TranslationManager translationManager)
			throws IL1TranslationUnhandledTypeException {
		
		String result = "";
		
		//	Command will be mod
		//	Source string will be [A] mod [B], though [A] and [B] could be expressions.
		//	Eg. a mod (b + c)
		
		// 	So would need to resolve A, resolve B, then do mod operator.
		//	I'm guessing the pattern matcher would be able to work out whether A or B contain 
		//	something else to be resolved.
		
		//	So output would be:
		//	String resolvedA = translationManager.translatePredicateExpression(Command, A, "Ada");  - to be created, using pattern matcher that is held in the translation manager?
		//	String resolvedB = translationManager.translatePredicateExpression(Command, B, "Ada");
		
		//	Tmp:
		String resolvedA = sourceString.split("mod")[0].trim(); 
		String resolvedB = sourceString.split("mod")[1].trim();
		
		//	Then do translation for Ada.
		result = resolvedA + "%" + resolvedB;
		
		return result;
	}

	//	You then need to add the translator to the extension points in the plugin.xml	
}
