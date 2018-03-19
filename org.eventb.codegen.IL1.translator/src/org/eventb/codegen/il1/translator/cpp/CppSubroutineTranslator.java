package org.eventb.codegen.il1.translator.cpp;

import java.util.ArrayList;

import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.c.CTranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractSubroutineIL1Translator;

public class CppSubroutineTranslator extends AbstractSubroutineIL1Translator {

	@Override
	protected ArrayList<String> generateFunction(String name,
			ArrayList<String> parameterDefinitions,
			ArrayList<ArrayList<String>> localVariables, String guardList,
			ArrayList<String> body, boolean isProtected, boolean isEnviron,
			String machineName, Subroutine actualSource,
			IL1TranslationManager translationManager) {

		ArrayList<String> outCode = new ArrayList<String>();		
		
		//	Format the parameters
		String parameters = "";
		boolean first = true;
		for (String p : parameterDefinitions)
		{
			if (!first)
				parameters = parameters + ", ";
			
			parameters = parameters + p;
			first = false;
		}
		
		
		//	Uniquely identify each event name using the machine name
		outCode.add("void " + machineName + "_" + name + "(" + parameters + ")");
		outCode.add("{");	//	open function
		
		
		if (isProtected || isEnviron)
		{
			//	Output OpenMP blocking
			outCode.add("// [Internal] This will block until the guard has been met (no nice way of doing this in OpenMP 2.5)");
			outCode.add("BOOL completed = FALSE; \t // [Internal] Private to the thread by default");
			outCode.add("// [Internal] Try and get lock");			
			
			translationManager.addIncludeStatement("typedef int BOOL;");
			translationManager.addIncludeStatement("#define TRUE 1");
			translationManager.addIncludeStatement("#define FALSE 0");
		}

//		outCode.add("#pragma omp critical (" + machineName.toUpperCase() + ")");
//		outCode.add("{");		//	OPEN critical region	
		
		//	Guards
		if (!guardList.equals(""))
		{
				outCode.add("// Check to see if guard is met");	
				outCode.add("if (" + guardList + ")");
				outCode.add("{");		//	open guarded
		}
		
		//	Local variables
		for (ArrayList<String> lVars : localVariables)
		{
			outCode.addAll(lVars);
		}
				
		//	Body code
		outCode.add("// Translated code");
		outCode.addAll(body);				
		
		if (!guardList.equals(""))
		{				
				if (isProtected || isEnviron)
				{
					outCode.add("");
					outCode.add("// [Internal] Set completed flag");
					outCode.add("completed = TRUE;");
				}
				outCode.add("}");		// 	close guarded			
		}
		else
		{
			if (isProtected || isEnviron)
			{
				outCode.add("// [Internal] Set completed flag");
				outCode.add("completed = TRUE;");
			}
		}
		
//		outCode.add("}");			//	close critical
		
		outCode.add("}");	//	close function
		
		return outCode;	
		
	}

	@Override
	protected String generateParameterDefinition(String type,
			String identifier, ParameterType parameterType) {
		String paramDefn = "";
		
		//	Out parameters (to the calling subroutine) will be using the Pointer class. 
		switch (parameterType)
		{
			case OUT:
				paramDefn = type + " *" + identifier;
				break;
			case IN:
			default:
				paramDefn = type + " " + identifier;
				break;		
		}
		
		return paramDefn;
	}

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new CTranslatorUtils();
	}

}
