package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractOutputIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		Output actualSource = (Output)source;
		
		return getOutput(actualSource.getElement(), actualSource.getText(), actualSource, translationManager, targetLanguage);
	}

	/**
	 * Translate the output.
	 * @param actualSource
	 * @param translationManager
	 * @param targetLanguage
	 * @return
	 */
	protected abstract ArrayList<String> getOutput(String variableName, String text, Output actualSource, IL1TranslationManager translationManager, TargetLanguage targetLanguage);
}
