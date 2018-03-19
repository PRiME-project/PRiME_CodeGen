package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaIfIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		If actualSource = (If) source;

		String guardCode = Utils.buildGuardConditionString(
				actualSource.getCondition(), translationManager, actualSource, targetLanguage);
		outCode.add("if " + guardCode + " then ");
		outCode.addAll(translationManager.translateIL1ElementToCode(
				actualSource.getBody(), targetLanguage));

		if (actualSource.getBranch() != null) {
			doSubBranch(translationManager, outCode, actualSource.getBranch(), targetLanguage);
		}

		if (actualSource.getElse() != null) {
			doElse(translationManager, outCode, actualSource, targetLanguage);
		}

		outCode.add("end if;");
		return outCode;
	}

	/**
	 * Adds a sub-branch to the output statement
	 * 
	 * @param translationManager
	 * @param outCode
	 * @param parentGuard
	 * @param elseIf
	 * @throws IL1TranslationUnhandledTypeException 
	 */
	private void doSubBranch(IL1TranslationManager translationManager,
			ArrayList<String> outCode, ElseIf elsIf, TargetLanguage targetLanguage) throws IL1TranslationUnhandledTypeException {
		outCode.addAll(translationManager.translateIL1ElementToCode(elsIf,
				targetLanguage));

	}

	/**
	 * Adds an else statement to the branch statement
	 * 
	 * @param translationManager
	 * @param outCode
	 * @param actualSource
	 * @throws IL1TranslationUnhandledTypeException 
	 */
	private void doElse(IL1TranslationManager translationManager,
			ArrayList<String> outCode, If actualSource, TargetLanguage targetLanguage) throws IL1TranslationUnhandledTypeException {
		outCode.add("else ");
		outCode.addAll(translationManager.translateIL1ElementToCode(
				actualSource.getElse(), targetLanguage));
	}
}
