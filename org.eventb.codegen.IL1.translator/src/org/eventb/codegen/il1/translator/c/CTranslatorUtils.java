package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;

public class CTranslatorUtils extends AbstractIL1TranslatorUtils {

	// Keep a list of array names for post processing. The removal of
	// duplicate identifiers which are translated due to difference 
	// between Event-B and C array semantics.

	// In Event-B, only identifiers may be assigned to on the LHS
	// of an assignment. In C we have expressions on the LHS so,

	// Event-B: array := array <+ {x|->y}
	// semantics are, lhs 'after' array is assigned the old 'before' array
	// with the elements x,y added / or y updated
	
	// or using an array theory, an Event-B assignment
	// where update(array,x,y) == array <+ {x|->y} 
	// a := update(array,x,y)
	//     // rule: t(a) == a
	// ~> a = t(update(array,x,y))
	//     // rule: update(array,x,y) == a[x] = y
	// ~>     a = a[x] = y
	// and this is wrong
	
	// C: array[x] = y
	// The array element x is updated with the value y.
	// In event-B the updated array is assigned to the LHS array,
	// but in C only the indexed item is assigned.
	
	private static List<String> arrayIDs = new ArrayList<String>();
	private static Map<String, List<String>> arrayDimensionMap = new HashMap<String, List<String>>();
	private static Map<String, String> arrayInitValueMap = new HashMap<String, String>();
	
	public static List<String> getArrayIDs() {
		return arrayIDs;
	}

	public static Map<String, List<String>> getArrayDimensions(){
		return arrayDimensionMap ;
	}
	
	public static Map<String, String> getArrayInitValue(){
		return arrayInitValueMap  ;
	}
	
	@Override
	protected String getTrue() { 
		return "TRUE";
	}

	@Override
	protected String getFalse() {
		return "FALSE";
	}

	@Override
	protected String getAnd() {
		return "&&";
	}

	@Override
	public String updateVariableName(String actionLine,
			IL1Element actualSource, IL1TranslationManager translationManager) {
	
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
	
	private static boolean isTokenCharacter(char c)
	{
		return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') ||  c == '_');
		// || c == ' ' ??? whitespace shouldn't be a token, but it is listed in IL1TranslationManager::tokenizeVariablesOperators
	}
	
	/**
	 * Works out where the token exists. Assumes the first character is a token character also. (eg. not whitespace).
	 * @param startIdx
	 * @param action
	 * @return
	 */
	private static int getNextTokenEndIdx(int startIdx, String action)
	{
		while (startIdx < action.length() && isTokenCharacter(action.charAt(startIdx)))
			startIdx++;
		
		return startIdx;
	}
	
	private static String updateVariableName(String action, String machineName, EList<Declaration> d)
	{					
		ArrayList<String> dNames = getNames(d);	
		String newAction = "";
		
		for (int idx = 0; idx < action.length(); idx++)
		{
			//	Skip to the start of the next token
			while(idx < action.length() && !isTokenCharacter(action.charAt(idx)))
			{	
				newAction += action.charAt(idx);
				idx++;
			}
			
			int start = idx;
			int end = getNextTokenEndIdx(start, action);
			
			String token = action.substring(start, end);
			
			if (dNames.contains(token))
			{
				//	update the token name
				newAction += token + "_" + machineName;
			}
			else
			{
				//	just use the token
				newAction += token;
			}
			
			idx = end-1;	//correct subtract 1
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
