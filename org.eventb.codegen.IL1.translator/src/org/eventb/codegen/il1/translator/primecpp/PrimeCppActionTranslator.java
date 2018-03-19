package org.eventb.codegen.il1.translator.primecpp;

import java.util.ArrayList;

import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractActionIL1Translator;

public class PrimeCppActionTranslator extends AbstractActionIL1Translator {

	@Override
	protected String finishTranslation(String translatedActionLine,
			Action actualSource, ArrayList<String> inParameters,
			ArrayList<String> outParameters,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {
		//	Make out parameters pointers
		for (String p : outParameters)
		{			
			translatedActionLine = this.replaceVariableString(p, "(*" + p + ")", translatedActionLine,translationManager);
		}

		//	Change variable names to they become machine name underscore variable name
		//	This will allow variables to have the same name in different machines, which would otherwise break C
		PrimeCppTranslatorUtils util = new PrimeCppTranslatorUtils();
		translatedActionLine = util.updateVariableName(translatedActionLine, actualSource, translationManager);
		//	End change variable names
		
		return translatedActionLine + ";";
		
	}
}
