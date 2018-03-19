package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractActionIL1Translator;

public class JavaActionIL1Translator extends AbstractActionIL1Translator {

	@Override
	protected String finishTranslation(String translatedActionLine,
			Action actualSource, ArrayList<String> inParameters,
			ArrayList<String> outParameters,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		//	OutParameters should be updated so they use the Pointer class
		for (String p : outParameters)
		{
			translatedActionLine = this.replaceVariableString(p, p + ".value ", translatedActionLine, translationManager);
		}
		
		return translatedActionLine + ";";
	}

	

}
