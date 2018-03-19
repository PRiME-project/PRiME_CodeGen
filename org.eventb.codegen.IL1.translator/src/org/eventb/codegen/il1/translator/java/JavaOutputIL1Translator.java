package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractOutputIL1Translator;

public class JavaOutputIL1Translator extends AbstractOutputIL1Translator {

	@Override
	protected ArrayList<String> getOutput(String variableName, String text,
			Output actualSource, IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {
	
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("System.out.println(\"" + text + "\" + " + variableName + ");");
		
		return output;
	}



}
