package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;

import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractOutputIL1Translator;

public class COutputTranslator extends AbstractOutputIL1Translator {

	@Override
	protected ArrayList<String> getOutput(String variableName, String text,
			Output actualSource, IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ArrayList<String> output = new ArrayList<String>();
			
		String machineName = "";		
		Task t = translationManager.getParentTask(actualSource);		
		if (t != null)
		{			
			machineName = t.getName();
		}
		else
		{
			Protected p = translationManager.getParentProtected(actualSource);			
			
			if (p != null)
			{
				machineName = p.getName();				
			}
		}
		
		translationManager.addIncludeStatement("#include <stdio.h>");
			
		if (actualSource.getElement() != null && !actualSource.getElement().trim().equals(""))
		{			
			String sourceText = actualSource.getText();
			//	To force output of value, when a value is given
			if (!sourceText.contains("%"))
			{
				sourceText += " %i";
			}
			output.add("printf(\"" + sourceText + "\\n\", " + actualSource.getElement() + "_" + machineName + ");");
		}
		else
		{
			output.add("printf(\"" + actualSource.getText() + "\\n\");");
		}
		
		return output;
	}

}
