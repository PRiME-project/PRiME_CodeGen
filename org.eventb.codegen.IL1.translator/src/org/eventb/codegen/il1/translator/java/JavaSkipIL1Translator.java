package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class JavaSkipIL1Translator extends AbstractIL1Translator {

	public JavaSkipIL1Translator() {
	}

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		String s = makeNull();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(s);
		return arrayList;

	}

	
	private String makeNull() {
		return ";";
	}

}
