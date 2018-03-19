package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class COutputIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Output actualSource = (Output)source;
		
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
			outCode.add("printf(\"" + sourceText + "\\n\", " + actualSource.getElement() + "_" + machineName + ");");
		}
		else
		{
			outCode.add("printf(\"" + actualSource.getText() + "\\n\");");
		}
		
		
		return outCode;		
	}

}
