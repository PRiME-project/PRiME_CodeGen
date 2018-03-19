package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CCallTranslator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Call actualSource = (Call)source;
		
		String machineName = "";
		Task t = translationManager.getParentTask(actualSource);
		if (t != null)
		{
			machineName = t.getName();
		}
		else
		{
			Protected p = translationManager.getParentProtected(actualSource);
			machineName = p.getName();
		}
		
		Subroutine s = actualSource.getSubroutine();
		
		String functionCall = s.getName() + "(";
		//outCode.add(s.getName() + "(");
		
		boolean first = true;
		for (Parameter p : actualSource.getActualParameters())
		{
			if (!first)
				functionCall = functionCall + ", ";
			
			if (p instanceof InParameter)
			{
				//	Must send a pointer to the call, as the call will return a value on this parameter
				functionCall = functionCall + "&" + p.getIdentifier() + "_" + machineName;
			}
			else if (p instanceof OutParameter)
			{
				functionCall = functionCall + p.getIdentifier() + "_" + machineName;
			}
			
			first = false;
		}
		
		functionCall = functionCall + ");";
		
		outCode.add(functionCall);
		
		return outCode;		
	}
}
