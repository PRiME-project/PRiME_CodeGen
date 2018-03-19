package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CIfIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		ArrayList<String> outCode = new ArrayList<String>();
		If actualSource = (If)source;
		
		String guardCode = buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);
		outCode.add("if" + guardCode);
		outCode.add("{");		
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage));
		outCode.add("}");
		
		//	if branch
		if (actualSource.getBranch() != null)
		{
			outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBranch(), targetLanguage));
		}
		
		//	else
		outCode.add("else");
		outCode.add("{");
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getElse(), targetLanguage));
		outCode.add("}");
		
		return outCode;		
	}
	
	
	/**
	 * Returns the (condition1 && condition2 && ...) string
	 * @param actualSource
	 * @param translationManager
	 * @return
	 */
	public static String buildGuardConditionString(EList<String> conditions, IL1Element source, IL1TranslationManager translationManager, TargetLanguage targetLanguage)
	{
		String guardCode = "(";
		for (int i = 0; i < conditions.size(); i++)
		{
			String g = conditions.get(i);
			String gLine = "";
			
			if (g.equals("TRUE"))
			{
				gLine = "TRUE";
				translationManager.addIncludeStatement("#define TRUE 1");	
			}
			else if (g.equals("FALSE"))
			{
				gLine = "FALSE";
				translationManager.addIncludeStatement("#define FALSE 0");
			}
			else
			{
				gLine = translationManager.translatePredicateExpression(g, source, targetLanguage);
			}
			
			//	Tokenize gLine to find the variables
			gLine = translationManager.tokenizeVariablesOperators(gLine);
			//	Append machine name to the variables
			gLine = CActionIL1Translator.updateVariableName(gLine, source, translationManager);
			
			
			guardCode = guardCode + gLine;	
			if (i + 1 < conditions.size() && !gLine.trim().equals(""))
			{
				guardCode = guardCode + " && ";
			}
		}	
		
		return guardCode + ")";
	}

}
