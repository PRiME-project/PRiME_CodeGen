package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.ClassHeaderInformation;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CEnvironTaskIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		EnvironTask actualSource = (EnvironTask)source;
		ArrayList<String> outCode = new ArrayList<String>();
		
		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
		headerInfo.setClassName(actualSource.getName());
		
		outCode.add("// Task: " + actualSource.getName());
		outCode.add("");
		outCode.add("// Variables");
		outCode.add("");
		
		
		for (Declaration decl : actualSource.getDecls())
		{
			ArrayList<String> declStr = translationManager.translateIL1ElementToCode(decl, targetLanguage);
			outCode.addAll(declStr);
		}
		
		outCode.add("");
		outCode.add("// Subroutines");
		
		for (Subroutine subroutine : actualSource.getSubroutines())
		{
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(subroutine, targetLanguage);
			
			if (subStr != null)
			{
				//	The first line will contain the information to be placed in the header file for this protected object
				String firstLine = subStr.get(0);
				headerInfo.getHeaderEntries().add(firstLine + ";");
				
				outCode.addAll(subStr);
			}
			outCode.add("");
		}
				
		outCode.add("// Task body");
		outCode.add("void " + actualSource.getName().replaceAll(" ", "") + "()");
		outCode.add("{");
		
		//	See if periodic
		boolean periodic = false;
		int period = 0;
		if (actualSource.getTaskType() != null && actualSource.getTaskType() instanceof PeriodicTaskType)
		{
			periodic = true;
			period = ((PeriodicTaskType)actualSource.getTaskType()).getPeriod();
			translationManager.addIncludeStatement("#define TRUE 1");
			outCode.add("while(TRUE)");
			outCode.add("{");
		}
		
		//	Add the task body
		if (actualSource.getBody() != null)
		{
			ArrayList<String> bodyStr = translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage);
			outCode.addAll(bodyStr);
		}
				
		//	End periodic code
		if (periodic)
		{
			outCode.add("");
			outCode.add("// Periodic task");
			outCode.add("__SLEEP(" + period + ");");
			outCode.add("}");	
			CTaskIL1Translator.addSleepFunction(translationManager);
		}
		
		outCode.add("}");
		
		translationManager.addClassHeaderInformation(headerInfo);
		
		return outCode;		
	}

}
