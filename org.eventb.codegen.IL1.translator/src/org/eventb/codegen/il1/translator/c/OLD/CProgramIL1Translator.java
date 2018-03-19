package org.eventb.codegen.il1.translator.c.OLD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CProgramIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		
		ArrayList<String> codeArray = new ArrayList<String>();		//	contains code from Tasks
		ArrayList<String> fullCodeArray = new ArrayList<String>();	//	contains the full code including include statements and body code
				
		//	Ensure there are no include statements from previous translations
		translationManager.clearIncludeStatements();
		translationManager.clearCompilerDependentExecutableCodeBlock();
		
		//	Adds boolean information by default, so it can be used elsewhere by actions, variables and the theories
		translationManager.addIncludeStatement("typedef int BOOL;");
		translationManager.addIncludeStatement("#define TRUE 1");
		translationManager.addIncludeStatement("#define FALSE 0");
		
		//	Add code for threads
//		translationManager.addIncludeStatement("#include<omp.h>");
//		translationManager.addIncludeStatement("#include<process.h>");
		
		Program actualSource = (Program)source;
		
//		fullCodeArray.add("// DEPLOY code generation version... 0");
		fullCodeArray.add("// Code generated: " + getCurrentTimeDate());
		fullCodeArray.add("");
		
		//	Any protected objects first
		for(Protected p : actualSource.getProtected())
		{
			codeArray.addAll(translationManager.translateIL1ElementToCode(p, targetLanguage));
		}
		
		//	Then any main entry tasks 
		if (actualSource.getEntryPoint() != null)
		{
			for (Task task : actualSource.getEntryPoint().getAutoTasks())
			{
				ArrayList<String> taskCode = translationManager.translateIL1ElementToCode(task, targetLanguage);
				
				if (taskCode != null)
				{
					codeArray.addAll(taskCode);
				}
			}			
		}
		
		//	Get any standard tasks
		for (Task task : actualSource.getTaskTypeTasks())
		{
			ArrayList<String> taskCode = translationManager.translateIL1ElementToCode(task, targetLanguage);
			
			if (taskCode != null)
			{
				codeArray.addAll(taskCode);
			}
		}
		
		//	Environ tasks
		for (EnvironTask task : actualSource.getEnvironMachines())
		{
			ArrayList<String> taskCode = translationManager.translateIL1ElementToCode(task, targetLanguage);
			
			if (taskCode != null)
			{
				codeArray.addAll(taskCode);
			}
		}
		
		
		//	Get the headers/includes
		fullCodeArray.addAll(translationManager.getIncludeStatements());
		fullCodeArray.add("");
		
		//	Get any platform dependent code definitions
		fullCodeArray.addAll(translationManager.getCompilerDependentExecutableCodeBlock());
		fullCodeArray.add("");
		
		//	Add the code
		fullCodeArray.addAll(codeArray);
		
		
		
		
		
//		MainEntry mainEntry = actualSource.getEntryPoint();
//		if (mainEntry != null)
//		{
//			ArrayList<String> mainCode = translationManager.translateIL1Element(mainEntry, TargetLanguage.C);
//			codeArray.addAll(mainCode);
//		}
		
		fullCodeArray.add(""); 
	//	fullCodeArray.add("// Tmp test code");
		//	non-threaded version
		
//		fullCodeArray.add("");
//		fullCodeArray.add("int main(int argc, char *argv[])");
//		fullCodeArray.add("{");
//		if (actualSource.getTaskTypeTasks().get(0) != null)
//		{				
//				fullCodeArray.add(actualSource.getTaskTypeTasks().get(0).getName() + "();");
//		}
		
		//	Windows threaded version
		ArrayList<String> mainCode = new ArrayList<String>();
//		for (Task task : actualSource.getTaskTypeTasks())
		
		//	if there is anything in the entry point
		if (actualSource.getEntryPoint() != null || actualSource.getEnvironMachines() != null)
		{			
			//	OpenMP declare parallel regions
//			mainCode.add("#pragma omp parallel sections");
//			mainCode.add("{");						//	open OpenMP parallel region
			
			if (actualSource.getEntryPoint() != null)
			{
				for (Task task : actualSource.getEntryPoint().getAutoTasks())
				{
					fullCodeArray.add("void " + task.getName().trim() + "Thread()");
					fullCodeArray.add("{");
					fullCodeArray.add(task.getName().trim() + "();");
	//				fullCodeArray.add("_endthread();");	
					fullCodeArray.add("}");
	//				mainCode.add("_beginthread(" + task.getName().trim() + "Thread, 0, 0);");		
					
					//	Add each call as a parallel section
//					mainCode.add("#pragma omp section");
//					mainCode.add("{");
					mainCode.add(task.getName().trim() + "Thread();");		//	Doesn't actually need the 0, that's legacy from old version of threading
//					mainCode.add("}");
				}
			}
			
			//	And the environ machines
			if (actualSource.getEnvironMachines() != null)
			{
				for (Task task : actualSource.getEnvironMachines())
				{
					fullCodeArray.add("void " + task.getName().trim() + "Thread()");
					fullCodeArray.add("{");
					fullCodeArray.add(task.getName().trim() + "();");
	//				fullCodeArray.add("_endthread();");	
					fullCodeArray.add("}");
	//				mainCode.add("_beginthread(" + task.getName().trim() + "Thread, 0, 0);");		
					
					//	Add each call as a parallel section
//					mainCode.add("#pragma omp section");
//					mainCode.add("{");
					mainCode.add(task.getName().trim() + "Thread();");		//	Doesn't actually need the 0, that's legacy from old version of threading
//					mainCode.add("}");
				}
			}
			

		}
		
		
		fullCodeArray.add("");
		fullCodeArray.add("int main(int argc, char *argv[])");
		fullCodeArray.add("{");
		
		//	Windows threaded version
		fullCodeArray.addAll(mainCode);
//		fullCodeArray.add("while(true)");	//	to keep the program running
//		fullCodeArray.add("{");
//		fullCodeArray.add("//	Blank to force program to keep running the threads");
//		fullCodeArray.add("}");
		
	//	CJL: Updated 03/01/2012 - OpenMP parallel region is opened regardless of whether there is an entry point
	//		 so it needs to be closed
	//	if (actualSource.getEntryPoint() != null)
	//	{
//			fullCodeArray.add("}");					//	close OpenMP parallel region
	//	}
		
		fullCodeArray.add("}");
		fullCodeArray.add("");	//	blank line to stop ANSI C moaning
			
		return fullCodeArray;		
	}
	
	
	private String getCurrentTimeDate()
	{
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    return sdf.format(cal.getTime());
	}

}
