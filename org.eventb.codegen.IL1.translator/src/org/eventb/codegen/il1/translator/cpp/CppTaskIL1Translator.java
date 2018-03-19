package org.eventb.codegen.il1.translator.cpp;
//
//import java.util.ArrayList;
//
//import org.eventb.codegen.il1.Declaration;
//import org.eventb.codegen.il1.IL1Element;
//import org.eventb.codegen.il1.PeriodicTaskType;
//import org.eventb.codegen.il1.SimpleTaskType;
//import org.eventb.codegen.il1.Subroutine;
//import org.eventb.codegen.il1.Task;
//import org.eventb.codegen.il1.TaskTypeEnum;
//import org.eventb.codegen.il1.translator.AbstractIL1Translator;
//import org.eventb.codegen.il1.translator.ClassHeaderInformation;
//import org.eventb.codegen.il1.translator.IL1TranslationManager;
//import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
//import org.eventb.codegen.il1.translator.TargetLanguage;
//
//public class CppTaskIL1Translator extends AbstractIL1Translator {
//
//	@Override
//	public ArrayList<String> translate(IL1Element source,
//			IL1TranslationManager translationManager,
//			TargetLanguage targetLanguage)
//			throws IL1TranslationUnhandledTypeException {
//		
//		ArrayList<String> outCode = new ArrayList<String>();
//		Task actualSource = (Task)source;
//		
//		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
//		headerInfo.className = actualSource.getName();
//		
//		outCode.add("// Task: " + actualSource.getName());		
//		outCode.add("");
//		outCode.add("class " + actualSource.getName());
//		outCode.add("{");
//		outCode.add("// Variables");
//		outCode.add("");
//		
//		for (Declaration decl : actualSource.getDecls())
//		{
//			ArrayList<String> declStr = translationManager.translateIL1ElementToCode(decl, targetLanguage);
//			outCode.addAll(declStr);
//		}
//		
//		outCode.add("");
//		outCode.add("// Subroutines");
//		
//		for (Subroutine subroutine : actualSource.getSubroutines())
//		{
//			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(subroutine, targetLanguage);
//			
//			if (subStr != null)
//			{
//				//	The first line will contain the information to be placed in the header file for this protected object
//				String firstLine = subStr.get(0);
//				headerInfo.functionDeclarations.add(firstLine + ";");
//				
//				outCode.addAll(subStr);
//			}
//			outCode.add("");
//		}
//				
//		outCode.add("// Task body");
//		String functionDecl = actualSource.getName().replaceAll(" ", "") + "()";
//		outCode.add(functionDecl);
//		outCode.add("{");
//		
//		headerInfo.functionDeclarations.add(functionDecl + ";"); 
//		
//		//	See if periodic
//		boolean periodic = false;
//		boolean repeating = false;	//	additional flag on periodic
//		
//		if (actualSource.getTaskType() != null)
//		{
//			if (actualSource.getTaskType() instanceof PeriodicTaskType)
//			{
//				periodic = true;
//			}
//			if (actualSource.getTaskType() instanceof SimpleTaskType && ((SimpleTaskType)actualSource.getTaskType()).getType() == TaskTypeEnum.REPEATING)
//			{
//				repeating = true;
//			}
//		}
//		
//		
//		int period = 0;
//		if (periodic || repeating)
//		{			
//			if (periodic)
//			{
//				period = ((PeriodicTaskType)actualSource.getTaskType()).getPeriod();
//			}
//			else
//			{
//				period = 0;
//			}
//			
//			translationManager.addIncludeStatement("#define TRUE 1");
//			outCode.add("while(TRUE)");
//			outCode.add("{");
//			
//			if (periodic)
//			{
//				//	Add the timer information
//				outCode.add("double internalPeriodicStartTime = omp_get_wtime();");
//				outCode.add("double internalTimeDifference;");
//			}
//			outCode.add("");
//			outCode.add("//    Task body code");
//		}
//		
//		//	Add the task body
//		if (actualSource.getBody() != null)
//		{
//			ArrayList<String> bodyStr = translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage);
//			outCode.addAll(bodyStr);
//		}
//				
//		//	End periodic code
//		if (periodic || repeating)
//		{
//			outCode.add("");
//			
//			if (periodic)
//			{
//				outCode.add("");
//				outCode.add("//    Code to monitor time between periodic tasks");
//				outCode.add("internalTimeDifference = omp_get_wtime() - internalPeriodicStartTime;");
//				outCode.add("// Periodic task");
//				outCode.add("__SLEEP(" + period + " - (internalTimeDifference * 1000));");
//			}
//			else
//			{
//				outCode.add("//	Single task repeating - no sleep");
//			}
//			
//			outCode.add("}");	
//			addSleepFunction(translationManager);
//		}
//		
//		outCode.add("}");
//		outCode.add("};");	//	Close class
//		
//		translationManager.addClassHeaderInformation(headerInfo);
//		
//		return outCode;		
//	}
//	
//	/**
//	 * Will add the different sleep functions, for different architectures
//	 */
//	public static void addSleepFunction(IL1TranslationManager translationManager)
//	{
//		ArrayList<String> sleepFunctionStr = new ArrayList<String>();
//		
//		sleepFunctionStr.add("// Platform specific function: sleep");
//		sleepFunctionStr.add("// Supported platforms: Win32, UNIX");
//		//	Unix
//		sleepFunctionStr.add("#ifdef __unix__");
//		sleepFunctionStr.add("#include<unistd.h>");
//		sleepFunctionStr.add("void __SLEEP(int period)");
//		sleepFunctionStr.add("{");
//		sleepFunctionStr.add("if (period > 0)");
//		sleepFunctionStr.add("{");
//		sleepFunctionStr.add("usleep(period*1000);");
//		sleepFunctionStr.add("}");
//		sleepFunctionStr.add("}");
//		//	Win32
//		sleepFunctionStr.add("#elif defined _WIN32");
//		sleepFunctionStr.add("#include<windows.h>");
//		sleepFunctionStr.add("void __SLEEP(int period)");
//		sleepFunctionStr.add("{");
//		sleepFunctionStr.add("if (period > 0)");
//		sleepFunctionStr.add("{");
//		sleepFunctionStr.add("Sleep(period);");
//		sleepFunctionStr.add("}");
//		sleepFunctionStr.add("}");
//		sleepFunctionStr.add("#endif");		
//		sleepFunctionStr.add("");
//		
//		translationManager.addCompilerDependentExecutableCodeBlock("sleep", sleepFunctionStr);
//		translationManager.addIncludeStatement("void __SLEEP(int period);");
//	}
//
//}
