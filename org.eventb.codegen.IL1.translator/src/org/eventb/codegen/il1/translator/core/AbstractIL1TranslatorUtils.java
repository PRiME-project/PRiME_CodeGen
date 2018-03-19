package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;

/**
 * Class of Utils that are needed by some translators.
 * 
 * If you do not need to do something, just return the argument you are given in cases where a string needs to be updated.
 * Do not return null when a String or ArrayList<String> or EList<String> is requested.
 * @author Chris
 *
 */
public abstract class AbstractIL1TranslatorUtils {
	
	
	/**
	 * Builds the guard condition string without surrounding brackets.
	 * @param conditions
	 * @param source
	 * @param translationManager
	 * @param targetLanguage
	 * @return
	 */
	public String buildGuardConditionString(ArrayList<String> conditions, IL1Element source, IL1TranslationManager translationManager, TargetLanguage targetLanguage)
	{
		String guardCode = "";
		
		for (int i = 0; i < conditions.size(); i++) {
			String g = conditions.get(i);
			String gLine = "";
			
			if (g.equals("TRUE"))
			{
				gLine = getTrue();
			}
			else if (g.equals("FALSE"))
			{
				gLine = getFalse();
			}
			else
			{
				gLine = translationManager.translatePredicateExpression(g, source, targetLanguage);
			}
			
			//	Optional
			gLine = updateVariableName(gLine, source, translationManager);			
			
			guardCode = guardCode + gLine;
			if (i + 1 < conditions.size() && !gLine.trim().equals("")) {
				guardCode = guardCode + " " + getAnd() + " ";
			}
		}
				
		return guardCode;		
	}
	
	/**
	 * Builds the guard condition string without surrounding brackets.
	 * @param conditions
	 * @param source
	 * @param translationManager
	 * @param targetLanguage
	 * @return
	 */
	public String buildGuardConditionString(EList<String> conditions, IL1Element source, IL1TranslationManager translationManager, TargetLanguage targetLanguage)
	{
		return buildGuardConditionString(convertToArrayList(conditions), source, translationManager, targetLanguage);
	}
	
	/**
	 * Converts an EList to an ArrayList
	 * @param list The EList to convert from.
	 * @return The ArrayList converted to.
	 */
	public <T> ArrayList<T> convertToArrayList(EList<T> list)
	{
		ArrayList<T> arrayOut = new ArrayList<T>();
		
		for (T t : list)
			arrayOut.add(t);
		
		return arrayOut;
	}
	
	
	
	/**
	 * Return the string for TRUE in your programming language.
	 * Tip: If you need to define something or call a library to use TRUE, notify the translation manager.
	 * Eg. For C TRUE must be defined so you would call: translationManager.addIncludeStatement("#define TRUE 1");
	 * @return
	 */
	protected abstract String getTrue();
	
	/**
	 * Return the string for FALSE in your programming language.
	 * Tip: If you need to define something or call a library to use FALSE, notify the translation manager.
	 * Eg. For C FALSE must be defined so you would call: translationManager.addIncludeStatement("#define FALSE 0");
	 * @return
	 */
	protected abstract String getFalse();
	
	/**
	 * Return the string for AND in your programming language.
	 * @return
	 */
	protected abstract String getAnd();
	
	
	/**
	 * Optional method to allow variable names to be updated to contain machine name or any other requirements.
	 * Will not be needed in all languages. Is used in C to allow machine names to be placed before variable names
	 * to allow them to be uniquely identified.
	 * 
	 * If not needed, return actionLine.
	 * 
	 * @param actionLine The line to be updated.
	 * @param actualSource The actual source.
	 * @param translationManager The translation manager.
	 * @return
	 */
	protected abstract String updateVariableName(String actionLine, IL1Element actualSource, IL1TranslationManager translationManager);
}
