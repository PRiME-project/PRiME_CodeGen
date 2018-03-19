package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CElseIfIL1Translator extends AbstractIL1Translator{

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		ElseIf actualSource = (ElseIf)source;
		
		String guardString = CIfIL1Translator.buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);
		
		outCode.add("else if" + guardString);
		outCode.add("{");
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getAction(), targetLanguage));
		outCode.add("}");
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBranch(), targetLanguage));
		
		
		
		return outCode;		
	}

	
	
}
