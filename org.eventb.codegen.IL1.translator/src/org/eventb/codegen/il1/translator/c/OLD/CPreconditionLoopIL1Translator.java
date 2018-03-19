package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CPreconditionLoopIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		PreconditionLoop actualSource = (PreconditionLoop)source;
		
		
		String guardCode = CIfIL1Translator.buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);
		
		outCode.add("while" + guardCode);
		outCode.add("{");
		
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage));
		
		outCode.add("}");
		
		return outCode;		
	}

}
