package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractActionIL1Translator extends AbstractIL1Translator {
	
	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Action actualSource = (Action) source;

		String actionLine = translationManager.translatePredicateExpression(
				actualSource.getAction(), actualSource, targetLanguage);
		
		//	Identify the parameters
		EList<Parameter> parameters = translationManager.getParameters(actualSource);
		String tokenisedLine = translationManager.tokenizeVariablesOperators(actionLine);
		ArrayList<String> inParams = new ArrayList<String>();
		ArrayList<String> outParams = new ArrayList<String>();
		if (parameters != null)
		{
			for (Parameter p : parameters)
			{
				String pName = " " + p.getIdentifier() + " ";		//	added space to identify in tokenised version
				
				if (tokenisedLine.contains(pName))
				{
					if (p instanceof InParameter)
					{
						inParams.add(pName.trim());
					}
					else if (p instanceof OutParameter)
					{
						outParams.add(pName.trim());
					}
				}
			}
		}
		
 
		actionLine = actionLine.trim();
		actionLine = finishTranslation(actionLine, actualSource, inParams, outParams, translationManager, targetLanguage);

		outCode.add(actionLine);
		
		return outCode;
		
	}
	
	/**
	 * Used to replace a variable name in an action string with another.
	 * Useful in cases such as C, where an out parameter will be a pointer, so requires (*param_name) to be used rather than param_name.
	 * Action line string can be the one given in finishTranslation. 
	 * The code will automatically tokenise the string to separate variable names and parameters from operators and functions.
	 * @param oldVariableString The old variable or parameter name. This string will be trimmed before use.
	 * @param newVariableString The new variable or parameter name. 
	 * @param actionLine The action to perform the replacement.
	 * @param translationManager The translation manager.
	 * @return The updated action string.
	 */
	protected String replaceVariableString(String oldVariableString, String newVariableString, String actionLine, IL1TranslationManager translationManager)
	{
		String tokeniseLine = translationManager.tokenizeVariablesOperators(actionLine);
		tokeniseLine = tokeniseLine.replace(" " + oldVariableString.trim() + " ", newVariableString);
		return tokeniseLine;
	}
	
	
	
	/**
	 * Complete the translation by adding any line ending etc. that is not covered by the theory plug in.
	 * Formatting does not need to be done here, it can be done at the end by extending AbstractTranslateEventBToTarget. 
	 * @param translatedActionLine The translated line.
	 * @param actualSource The actual source object.
	 * @param inParameters The identifiers for any in parameters in the given action.
	 * @param outParameters The identifiers for any out parameters in the given action.
	 * @param translationManager The translation manager.
	 * @param targetLanguage The target language.
	 * @return
	 */
	protected abstract String finishTranslation(String translatedActionLine, Action actualSource, ArrayList<String> inParameters, ArrayList<String> outParameters, IL1TranslationManager translationManager, TargetLanguage targetLanguage);	
}
