package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;

import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.translator.ClassHeaderInformation;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractEnvironIL1Translator;

public class CEnvironTranslator extends AbstractEnvironIL1Translator {

	@Override
	protected ArrayList<String> generateEnvironCode(String taskName,
			TaskType taskType, boolean isPeriodic, boolean isRepeating,
			int priority, int period, ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subroutineList,
			ArrayList<String> taskBody, Task actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
		headerInfo.setClassName(actualSource.getName());

		ArrayList<String> outCode = new ArrayList<String>();
		outCode.add("// EnvironTask: " + taskName);
		outCode.add("");
			
		//	Add the variables and constants
		outCode.add("// Variables and constants");
		for (ArrayList<String> decl : declList)
			outCode.addAll(decl);
		
		//	Add priority variable
		outCode.add("const int priority_" + taskName + " = " + priority + ";");
		
		outCode.add("");
		
		//	Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");
		for (ArrayList<String> sub : subroutineList)
		{			
			//	The first line will contain the information to be placed in the 
			//	header file for this environ machine object
			String firstLine = sub.get(0);
			headerInfo.getHeaderEntries().add(firstLine + ";");
			
			outCode.addAll(sub);			
			outCode.add("");
		}
		
		//	Task body
		headerInfo.getHeaderEntries().add("void " + taskName + "();");
		outCode.add("void " + taskName + "()");
		outCode.add("{");	//	Start TaskBody
		
		
		
		
		//	Handle periodic or repeating tasks
		if (isPeriodic || isRepeating)
		{
			translationManager.addIncludeStatement("#define TRUE 1");
			
			outCode.add("while(TRUE)");
			outCode.add("{");	//	start while loop
			
			//	Get timer information
			if (isPeriodic)
			{				
				//	Add the timer information
				outCode.add("// [Internal] Timer information for repeating or periodic tasks");
				outCode.add("double internalPeriodicStartTime = omp_get_wtime();");
				outCode.add("double internalTimeDifference;");
			}
			
			outCode.addAll(taskBody);
			
			if (isPeriodic)
			{			
				outCode.add("");
				outCode.add("// [Internal] Code to monitor time between periodic tasks");
				outCode.add("internalTimeDifference = omp_get_wtime() - internalPeriodicStartTime;");				
				outCode.add("__SLEEP(" + period + " - (internalTimeDifference * 1000));");				
			}
			
			outCode.add("}");	//	end while loop
		}
		else
		{		
			outCode.addAll(taskBody);
		}
				
		
		outCode.add("}");	//	End TaskBody
		addSleepFunction(translationManager);
		
		translationManager.addClassHeaderInformation(headerInfo);
		
		return outCode;
	}
	
	
	
	/**
	 * Will add the different sleep functions, for different architectures
	 */
	public static void addSleepFunction(IL1TranslationManager translationManager)
	{
		ArrayList<String> sleepFunctionStr = new ArrayList<String>();
		
		sleepFunctionStr.add("// Platform specific function: sleep");
		sleepFunctionStr.add("// Supported platforms: Win32, UNIX");
		//	Unix
		sleepFunctionStr.add("#ifdef __unix__");
		sleepFunctionStr.add("#include<unistd.h>");
		sleepFunctionStr.add("void __SLEEP(int period)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("if (period > 0)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("usleep(period*1000);");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("}");
		//	Win32
		sleepFunctionStr.add("#elif defined _WIN32");
		sleepFunctionStr.add("#include<windows.h>");
		sleepFunctionStr.add("void __SLEEP(int period)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("if (period > 0)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("Sleep(period);");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("#endif");		
		sleepFunctionStr.add("");
		
		translationManager.addCompilerDependentExecutableCodeBlock("sleep", sleepFunctionStr);
		translationManager.addIncludeStatement("void __SLEEP(int period);");
	}

}
