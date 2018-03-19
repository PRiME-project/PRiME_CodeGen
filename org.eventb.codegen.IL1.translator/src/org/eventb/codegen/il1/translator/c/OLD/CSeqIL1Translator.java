package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

@Deprecated
public class CSeqIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		ArrayList<String> outCode = new ArrayList<String>();
		Seq actualSource = (Seq)source;
		
		//	Left then right		
		if (actualSource.getLeftBranch() != null)
		{			
			ArrayList<String> leftCode = translationManager.translateIL1ElementToCode(actualSource.getLeftBranch(), targetLanguage);
			outCode.addAll(leftCode);
		}
		
		if (actualSource.getRightBranch() != null)
		{
			ArrayList<String> rightCode = translationManager.translateIL1ElementToCode(actualSource.getRightBranch(), targetLanguage);
			outCode.addAll(rightCode);
		}
		
		return outCode;
	}

}
