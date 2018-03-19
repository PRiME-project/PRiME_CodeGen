package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaPreconditionLoopIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		PreconditionLoop actualSource = (PreconditionLoop) source;

		EList<String> conditions = actualSource.getCondition();
		String conditionString = Utils.buildGuardConditionString(conditions,
				translationManager, actualSource, targetLanguage);
		if (conditionString.trim().length() > 0) {
			outCode.add("while " + conditionString + " loop");
		} else {
			outCode.add("loop ");
		}

		if (actualSource.getBody() != null) {
			ArrayList<String> bodyStr = translationManager.translateIL1ElementToCode(
					actualSource.getBody(), targetLanguage);
			outCode.addAll(bodyStr);
		}

		outCode.add("end loop; ");
		return outCode;
	}

}
