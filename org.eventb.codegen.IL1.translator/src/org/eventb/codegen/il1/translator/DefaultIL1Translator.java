package org.eventb.codegen.il1.translator;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;

public class DefaultIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		ArrayList<String> defaultOut = new ArrayList<String>();
		
		return defaultOut;
	}

}
