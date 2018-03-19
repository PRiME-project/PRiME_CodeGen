package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;


@Deprecated
public class CSubroutineIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Subroutine actualSource = (Subroutine)source;		
		
		boolean isProtected = false;
		
		if (actualSource.eContainer() instanceof Protected)
			isProtected = true;
		
		if (!actualSource.getName().startsWith("INITIALISATION"))
		{
			String declaration = "void " + actualSource.getName() + "(";
			
			ArrayList<LocalVariable> localVariables = new ArrayList<LocalVariable>();
			boolean first = true;			
			for (Parameter p : actualSource.getFormalParameters())
			{		
				if (p instanceof LocalVariable)
				{
					localVariables.add((LocalVariable) p);
				}
				else
				{
					String pType = translationManager.resolveType(p.getType(), p.getIdentifier(), actualSource.getProjectName(), actualSource.getMachineName(), targetLanguage);
				
					if (!first)
						declaration = declaration + ", ";
					
					declaration = declaration + pType + " ";
					
					if (p instanceof OutParameter)
					{
						declaration = declaration + "*";
					}
					
					declaration = declaration + p.getIdentifier();
					
					first = false;
				}
			}
			
			outCode.add(declaration + ")");
			
			outCode.add("{");
						
			//	Guards
			if (actualSource.getGuards().size() > 0)
			{				
				if (isProtected)
				{
					//	Output OpenMP blocking
					outCode.add("// This will block until the guard has been met (no nice way of doing this in OpenMP 2.5)");
					outCode.add("BOOL completed = FALSE; \t // private to the thread by default");
					outCode.add("// Try and get lock");
//					outCode.add("#pragma omp critical (" + actualSource.getMachineName().toUpperCase() + ")");
//					outCode.add("{");
					outCode.add("// Check to see if guard is met");	
					
					
					translationManager.addIncludeStatement("typedef int BOOL;");
					translationManager.addIncludeStatement("#define TRUE 1");
					translationManager.addIncludeStatement("#define FALSE 0");
				}
				
				
				String guardCode = "if (";
				
				for (int i = 0; i < actualSource.getGuards().size(); i++)
				{
					
					String gLine = translationManager.translatePredicateExpression(actualSource.getGuards().get(i), actualSource, targetLanguage);
					
					//	Tokenize gLine to find the variables
					gLine = translationManager.tokenizeVariablesOperators(gLine);
					//	Append machine name to the variables
					gLine = CActionIL1Translator.updateVariableName(gLine, source, translationManager);

					
					guardCode = guardCode + gLine;
					
					if (i + 1 < actualSource.getGuards().size() && !gLine.trim().equals(""))
					{
						guardCode = guardCode + "&&";
					}												
				}	
				
				guardCode = guardCode + ")";
				outCode.add(guardCode);
				outCode.add("{");
				
				if (isProtected)
				{
					outCode.add("// Shared event actions");
				}
			}
			else
			{
//				outCode.add("#pragma omp critical (" + actualSource.getMachineName().toUpperCase() + ")");
//				outCode.add("{");
			}
			
			if (localVariables.size() > 0)
			{
				outCode.add("// Local variables");
				//	Local variables
				for (LocalVariable l : localVariables)
				{
					ArrayList<String> lvCode = translationManager.translateIL1ElementToCode(l, targetLanguage);
					if (lvCode != null)
						outCode.addAll(lvCode);
				}
				
				outCode.add("");
			}
			
			
			//	Body code
			ArrayList<String> bodyCode = translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage);
			if (bodyCode != null)
			{
				outCode.addAll(bodyCode);
			}
			
			if (actualSource.getGuards().size() > 0)
			{
				
				if (isProtected)
				{
					outCode.add("");
					outCode.add("// Set completed flag");
					outCode.add("completed = TRUE;");
				}
				outCode.add("}");
				
				if (isProtected)
				{
					outCode.add("else");
					outCode.add("{");
					outCode.add("// Go back and try again");
					outCode.add("}");
	//				outCode.add("}");		//	close parallel section
				}
			}
			else
			{
				//	Close critical region
//				outCode.add("}");
			}
			
			outCode.add("}");
		}	
		
		return outCode;
	}

}
