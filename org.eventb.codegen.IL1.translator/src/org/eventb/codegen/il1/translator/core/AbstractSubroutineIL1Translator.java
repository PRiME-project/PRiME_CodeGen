package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationException;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.tasking.TaskingTranslationException;

public abstract class AbstractSubroutineIL1Translator extends
		AbstractIL1Translator {

	protected enum ParameterType {
		IN, OUT
	};

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException,
			IL1TranslationException {

		ArrayList<String> outCode = new ArrayList<String>();
		Subroutine actualSource = (Subroutine) source;

		boolean isProtected = false;
		boolean isEnviron = false;

		if (actualSource.eContainer() instanceof Protected)
			isProtected = true;
		else if (actualSource.eContainer() instanceof EnvironTask)
			isEnviron = true;

		if (!actualSource.getName().startsWith("INITIALISATION")) {
			// Translate the parameters
			ArrayList<LocalVariable> localVariables = new ArrayList<LocalVariable>();
			ArrayList<String> parameterDefns = new ArrayList<String>();
			for (Parameter p : actualSource.getFormalParameters()) {
				if (p instanceof LocalVariable) {
					localVariables.add((LocalVariable) p);
				} else {
					String pType = translationManager.resolveType(p.getType(),
							p.getIdentifier(), actualSource.getProjectName(),
							actualSource.getMachineName(), targetLanguage);
					ParameterType parameterType = ParameterType.IN;

					if (p instanceof OutParameter) {
						parameterType = ParameterType.OUT;
					}

					String parameterDefinition = generateParameterDefinition(
							pType, p.getIdentifier(), parameterType);
					parameterDefns.add(parameterDefinition);
				}
			}

			// Build the guard string
			AbstractIL1TranslatorUtils utils = getTranslatorUtils();
			String guardString = utils.buildGuardConditionString(
					actualSource.getGuards(), actualSource, translationManager,
					targetLanguage);

			// Local variables
			ArrayList<ArrayList<String>> localVariablesList = new ArrayList<ArrayList<String>>();
			for (LocalVariable l : localVariables) {
				localVariablesList.add(translationManager
						.translateIL1ElementToCode(l, targetLanguage));
			}

			// Body code
			ArrayList<String> bodyCode = translationManager
					.translateIL1ElementToCode(actualSource.getBody(),
							targetLanguage);

			ArrayList<String> generatedFunction = generateFunction(actualSource.getName(),
					parameterDefns, localVariablesList, guardString, bodyCode,
					isProtected, isEnviron, actualSource.getMachineName(),
					actualSource, translationManager);
			
			// In FMU generation we return null. The method body is not used. So we have to handle this.
			if(generatedFunction != null){
				outCode.addAll(generatedFunction);
			}

		}

		return outCode;
	}

	/**
	 * Generate the function string putting any parameters, local variables and
	 * body code in the correct places. Eg. function name (parameters)
	 * 
	 * @param name
	 *            The name of the subroutine
	 * @param parameterDefinitions
	 *            The translated parameter definitions
	 * @param localVariables
	 *            The translated local variables. Each ArrayList(String) is a
	 *            separate local variable that has been translated.
	 * @param guardList
	 *            The list of guards for the subroutine.
	 * @param body
	 *            The translated body code.
	 * @param isProtected
	 *            Whether the subroutine belongs to a protected or not.
	 * @param isEnviron
	 *            Whether the subroutine belongs to an environ or not.
	 * @param machineName
	 *            The name of the machine the subroutine has come from.
	 * @param actualSource
	 *            The actual subroutine being translated.
	 * @param translationManager
	 *            The translation manager being used.
	 * @return The full function code in the correct form for the language.
	 * @throws TaskingTranslationException
	 */
	protected abstract ArrayList<String> generateFunction(String name,
			ArrayList<String> parameterDefinitions,
			ArrayList<ArrayList<String>> localVariables, String guardList,
			ArrayList<String> body, boolean isProtected, boolean isEnviron,
			String machineName, Subroutine actualSource,
			IL1TranslationManager translationManager)
			throws IL1TranslationException;

	/**
	 * Generate the definition for the given parameter in the correct form for
	 * the langauge. Eg. int a Eg. int *a
	 * 
	 * @param type
	 *            The programming language type.
	 * @param identifier
	 *            The identifier
	 * @param parameterType
	 *            Whether the parameter is IN or OUT.
	 * @return Translated parameter definition
	 */
	protected abstract String generateParameterDefinition(String type,
			String identifier, ParameterType parameterType);

	/**
	 * Return the AbstractIL1TranslatorUtils object for the language you are
	 * translating.
	 * 
	 * @return
	 */
	protected abstract AbstractIL1TranslatorUtils getTranslatorUtils();

}
