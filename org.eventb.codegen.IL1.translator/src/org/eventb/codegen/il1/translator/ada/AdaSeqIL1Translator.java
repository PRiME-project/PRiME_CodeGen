package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaSeqIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Seq actualSource = (Seq)source;
		
		ArrayList<String> leftList = translationManager.translateIL1ElementToCode(actualSource.getLeftBranch(), targetLanguage);
		ArrayList<String> rightList = translationManager.translateIL1ElementToCode(actualSource.getRightBranch(), targetLanguage);
		outCode.addAll(leftList);
		outCode.addAll(rightList);
		
		return outCode;
	}

}
