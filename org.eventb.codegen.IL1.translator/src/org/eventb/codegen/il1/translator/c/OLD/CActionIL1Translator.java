package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

@Deprecated
public class CActionIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		ArrayList<String> outCode = new ArrayList<String>();
		Action actualSource = (Action)source;
		//	If the action contains one of the parameters, and it is an OutParameter, map to (*parameter)
		EList<Parameter> parameters = translationManager.getParameters(actualSource);
		String actionLine = translationManager.translatePredicateExpression(actualSource.getAction(), actualSource, targetLanguage);
		//	Search for anything that isn't a number or a letter and add a space in front of it, 
		//  so long as the character immediately before it is a number, letter or space
		String newActionLine = translationManager.tokenizeVariablesOperators(actionLine);
		
		//	Now there are spaces between all variables, values and operators
		//	See if any of OutParameters are in it
		//	Replace with (*parameter) if there are
		if (parameters != null)
		{
			for (Parameter p : parameters)
			{
				if (p instanceof OutParameter)
				{
					newActionLine = newActionLine.replace(" " + p.getIdentifier().trim() + " ", " (*" + p.getIdentifier().trim() + ") ");
				}
			}
		}
		//	Remove double blank spaces introduced by this translation
		while(newActionLine.contains("  "))
		{
			newActionLine = newActionLine.replace("  ", " ");
		}
		//	Change variable names to they become machine name underscore variable name
		//	This will allow variables to have the same name in different machines, which would otherwise break C
		newActionLine = updateVariableName(newActionLine, actualSource, translationManager);
		//	End change variable names
		newActionLine = newActionLine.trim();
		outCode.add(newActionLine + ";");
		return outCode;
	}
	
	public static String updateVariableName(String actionLine, IL1Element actualSource, IL1TranslationManager translationManager)
	{
		EList<Declaration> decls = null;
		String machineName = "";
		
		Task t = translationManager.getParentTask(actualSource);		
		if (t != null)
		{
			decls = t.getDecls();
			machineName = t.getName();
		}
		else
		{
			Protected p = translationManager.getParentProtected(actualSource);			
			if (p != null)
			{
				machineName = p.getName();
				decls = p.getDecls();
			}
		}
		if (decls != null)
		{
			//	Update the variable names
			actionLine = updateVariableName(actionLine, machineName, decls);
		}
		return actionLine;
	}
	
	private static String updateVariableName(String action, String machineName, EList<Declaration> d)
	{
		String [] actions = action.split(" ");
		String newAction = "";
		ArrayList<String> dNames = getNames(d);		
		for (String a : actions)
		{
			if (dNames.contains(a))
			{
				newAction += a + "_" + machineName + " ";
			}
			else
			{
				newAction += a + " ";
			}
		}
		return newAction;
	}
	
	private static ArrayList<String> getNames(EList<Declaration> decls)
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Declaration d : decls)
		{
			names.add(d.getIdentifier());
		}
		return names;
	}
}
