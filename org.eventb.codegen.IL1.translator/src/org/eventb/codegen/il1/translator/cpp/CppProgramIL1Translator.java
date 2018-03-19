
package org.eventb.codegen.il1.translator.cpp;

import static org.eventb.codegen.il1.translator.TranslateFromEventBToC_OpenMP_C.COMMON_HEADER_FULL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;



public class CppProgramIL1Translator extends AbstractProgramIL1Translator
{

	@Override
	protected ArrayList<String> generateProgramCode(
			ArrayList<ArrayList<String>> protectedList,
			ArrayList<ArrayList<String>> mainEntryTasksList,
			ArrayList<ArrayList<String>> standardTasksList,
			ArrayList<ArrayList<String>> environTasksList,
			ArrayList<ArrayList<String>> globalDeclList,
			ArrayList<String> globalDeclarationIdentifiers,
			ArrayList<String> includeStatements,
			ArrayList<String> compilerDependentCode, Program actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {
		ArrayList<String> outCode = new ArrayList<String>();	//	contains the full code including include statements and body code
		ArrayList<String> mainCode = new ArrayList<String>();	//	code for the main function			
		
		//	Adds boolean information by default, so it can be used elsewhere by actions, variables and the theories
		translationManager.addIncludeStatement("typedef int BOOL;");
		translationManager.addIncludeStatement("#define TRUE 1");
		translationManager.addIncludeStatement("#define FALSE 0");
		//	Required header used by all code - generated in TranslateFromEventBToC
		//translationManager.addIncludeStatement("#include \"CommonHeader.h\"");
		
		//	Add code for threads
//		translationManager.addIncludeStatement("#include<omp.h>");
		
		outCode.add("// Code generated: " + getCurrentTimeDate());
		outCode.add("");
		
		if (globalDeclList.size() > 0)
		{
			outCode.add("// GlobalDeclarations");
			//	Output global declarations first														
			for (ArrayList<String> declaration : globalDeclList)
			{					
				//	Just want to output the extern definition, so no initialisation.
				//	Can't just put these in the header files without extern, as we 
				//	would get multiple definition errors.
				//	So the header has extern declarations, MainEntry has the actual global variables,
				//	which are added below.
				
				if (declaration.size() == 1 && declaration.get(0).contains("="))
				{
					String d = "extern " + declaration.get(0).split("=")[0] + ";";
					outCode.add(d);
				}
				else
				{
					outCode.addAll(declaration);					
				}
				
				outCode.add("");
					
			}
			outCode.add("// EndGlobalDeclarations");
		}
		
		//	Protected objects
		if (protectedList.size() > 0)
		{
			
			for (ArrayList<String> p : protectedList)
			{
				outCode.add("// Protected");	//	state we are in the protected part of the code
								
				//	Required header used by all code - generated in TranslateFromEventBToC
				outCode.add("#include \""+ COMMON_HEADER_FULL +"\"");
				
				outCode.addAll(p);
				
				outCode.add("// EndProtected");
			}	
		}
		
		//	Then any main entry tasks
		if (mainEntryTasksList.size() > 0 || environTasksList.size() > 0)
		{
			ArrayList<String> mainMethodTaskNames = new ArrayList<String>();
			
			for (ArrayList<String> m : mainEntryTasksList)
			{
				outCode.add("// Task");
								
				//	Required header used by all code - generated in TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				
				//	First line will be the task name
				String taskName = m.get(0).split(":")[1].trim();
				mainMethodTaskNames.add(taskName);						
				
				outCode.addAll(m);
				outCode.add("// EndTask");
			}
			
			//	Add the environ machine names to the task names			
			for (ArrayList<String> m : environTasksList)
			{
				String taskName = m.get(0).split(":")[1].trim();
				mainMethodTaskNames.add(taskName);
			}
			
			mainCode.add("// MainEntry");			//	notify start of main entry
			mainCode.add("// MainEntry: MainEntry");	//	the name
			//	Required header used by all code - generated in TranslateFromEventBToC
			mainCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
			
			
			//	Add the definitions for global variables here, put the externs in the header file
			if (globalDeclList.size() > 0)
			{
				mainCode.add("// Global defns");
																		
				for (ArrayList<String> declaration : globalDeclList)
				{	
					//	only add single line partial declarations that should have a = in them
					if (declaration.size() == 1)
					{	
						mainCode.addAll(declaration);
						mainCode.add("");
					}
						
				}
			}
			
			mainCode.add("int main (int argc, char *argv[])");
			mainCode.add("{");	//	start main
			
			//	OpenMP declare parallel regions
			mainCode.add("#pragma omp parallel sections");
			mainCode.add("{");						//	start OpenMP parallel region
			
			//	Add the tasks
			for (String m : mainMethodTaskNames)
			{	
				//	Add each call as a parallel section
//				mainCode.add("#pragma omp section");
//				mainCode.add("{");
				mainCode.add(m.trim() + "();");		//	Doesn't actually need the 0, that's legacy from old version of threading
//				mainCode.add("}");
			}			
			
			mainCode.add("}");	//	end OpenMP parallel region
			mainCode.add("}");	//	end main				
		}
		
		//	Standard tasks
		if (standardTasksList.size() > 0)
		{			
			for (ArrayList<String> s : standardTasksList)
			{
				outCode.add("// Task");
				//	Required header used by all code - generated in TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				outCode.addAll(s);
				outCode.add("// EndTask");
			}			
		}
		
		//	Environ tasks 
		//	These are added to the main entry in the code above
		if (environTasksList.size() > 0)
		{
			for (ArrayList<String> e : environTasksList)
			{
				outCode.add("// EnvironTask");
	
				//	Required header used by all code - generated in TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				outCode.addAll(e);
				outCode.add("// EndEnvironTask");							
			}
		}
				
		outCode.add("");
		outCode.addAll(mainCode);		
		
		outCode.add("");	//	blank line to stop ANSI C moaning		
		return outCode;		
	}
	
	
	private String getCurrentTimeDate()
	{
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    return sdf.format(cal.getTime());
	}


	@Override
	protected void addImportStatement(boolean importGlobalConstants,
			IL1TranslationManager translationManager) {
		// Implement this if c++ requires import statements
	}
}
