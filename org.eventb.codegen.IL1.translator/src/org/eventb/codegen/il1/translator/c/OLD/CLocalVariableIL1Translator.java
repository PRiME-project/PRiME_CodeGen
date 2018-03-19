package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CLocalVariableIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		LocalVariable actualSource = (LocalVariable)source;
		ArrayList<String> outCode = new ArrayList<String>();
				
	//	outCode = translationManager.translateDeclaration(actualSource, targetLanguage);
		
		return outCode;
	}

}
