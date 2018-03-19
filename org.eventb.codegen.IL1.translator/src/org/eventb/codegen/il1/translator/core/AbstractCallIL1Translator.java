package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractCallIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Call actualSource = (Call) source;

		String machineName = "";
		Task t = translationManager.getParentTask(actualSource);
		if (t != null) {
			machineName = t.getName();
		} else {
			Protected p = translationManager.getParentProtected(actualSource);
			machineName = p.getName();
		}

		Subroutine s = actualSource.getSubroutine();

		// ArrayList<String> functionCall = generateFunctionCall(s.getName(),
		// actualSource.getActualParameters(), s.getMachineName(), machineName,
		// actualSource, translationManager, targetLanguage);
		ArrayList<String> functionCall = generateFunctionCall(s.getName(),
				actualSource.getActualParameters(), s.getMachineName(),
				machineName, actualSource, translationManager, targetLanguage);

		outCode.addAll(functionCall);

		return outCode;
	}

	/**
	 * Lists the parameters in order, separated by commas. Returns the empty
	 * string if no parameters.
	 * 
	 * @param parameters
	 *            The parameters
	 * @return String of parameters. Eg. "p1,p2,p3" or "" if empty.
	 */
	protected String separateParametersByComma(EList<Parameter> parameters) {
		String pOut = "";
		boolean first = true;

		for (Parameter p : parameters) {
			if (first)
				pOut += p.getIdentifier();
			else
				pOut += ", " + p.getIdentifier();

			first = false;
		}

		return pOut;
	}

	/**
	 * Generate the correct format for a function call using the given function
	 * name and parameter list. Can use separateParametersByComma helper method.
	 * 
	 * @param functionName
	 *            The name of the function to call.
	 * @param parameterNames
	 *            The list of parameters to use.
	 * @param remoteMachineName
	 *            The name of the remote machine being called.
	 * @param localMachineName
	 *            The name of the local machine doing the calling if needed.
	 * @param actualSource
	 *            The actual source object being translated.
	 * @param translationManager
	 *            The translation manager
	 * @param targetLanguage
	 *            The target language.
	 * @return The correct string for the function call in your language.
	 */
	protected abstract ArrayList<String> generateFunctionCall(
			String functionName, EList<Parameter> parameters,
			String remoteMachineName, String localMachineName,
			Call actualSource, IL1TranslationManager translationManager,
			TargetLanguage targetLanguage);

}
