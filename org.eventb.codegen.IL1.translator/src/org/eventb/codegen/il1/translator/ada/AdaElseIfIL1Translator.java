package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaElseIfIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		ElseIf actualSource = (ElseIf) source;

		if (actualSource != null) {
			String guardCode = Utils.buildGuardConditionString(
					actualSource.getCondition(), translationManager,
					actualSource, targetLanguage);
			outCode.add("elsif " + guardCode + " then ");
			outCode.addAll(translationManager.translateIL1ElementToCode(
					actualSource.getAction(), targetLanguage));
		}

		if (actualSource.getBranch() != null) {
			doSubBranch(translationManager, outCode, actualSource.getBranch(), targetLanguage);
		}

		return outCode;
	}

	/**
	 * Adds a sub-branch to the output statement
	 * 
	 * @param translationManager
	 * @param outCode
	 * @param elseIf
	 * @throws IL1TranslationUnhandledTypeException 
	 */
	private void doSubBranch(IL1TranslationManager translationManager,
			ArrayList<String> outCode, ElseIf elsIf, TargetLanguage targetLanguage) throws IL1TranslationUnhandledTypeException {
		// translate elsif
		outCode.addAll(translationManager.translateIL1ElementToCode(elsIf,
				targetLanguage));

	}

}
