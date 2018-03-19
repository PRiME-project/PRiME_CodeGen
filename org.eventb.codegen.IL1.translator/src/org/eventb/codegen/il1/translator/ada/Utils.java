package org.eventb.codegen.il1.translator.ada;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Signature;
import org.eventb.codegen.il1.impl.EnvironTaskImpl;
import org.eventb.codegen.il1.impl.ProtectedImpl;
import org.eventb.codegen.il1.impl.TaskImpl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class Utils {

	/**
	 * return the name of the task or protected object in which the source
	 * element resides or null
	 * 
	 * @param actualSource
	 * @return
	 */
	public static String getParentName(IL1Element actualSource) {
		EObject parent = actualSource;
		while (!(parent instanceof TaskImpl || parent instanceof ProtectedImpl || parent instanceof EnvironTaskImpl)) {
			parent = parent.eContainer();
		}

		if (parent instanceof Signature)
			return ((Signature) parent).getName();
		else
			return null;
	}

	/**
	 * return the name of the task or protected object in which the source
	 * element resides or null
	 * 
	 * @param actualSource
	 * @param translationManager
	 * @return
	 */
	public static boolean isEnvironMachineName(String name,
			IL1TranslationManager translationManager) {
		
		if(translationManager.getEnvironMachineNames().contains(name)){
			return true;
		}
		return false;
	}

	/**
	 * Returns the (condition1 and condition2 and ...) string
	 * 
	 * @param actualSource
	 * @param translationManager
	 * @return
	 */
	public static String buildGuardConditionString(EList<String> conditions,
			IL1TranslationManager translationManager, IL1Element source, TargetLanguage targetLanguage) {
		String guardCode = "(";
		for (int i = 0; i < conditions.size(); i++) {
			String g = conditions.get(i);
			String gLine = "";
			
			if (g.equals("TRUE"))
			{
				gLine = "TRUE";
			}
			else if (g.equals("FALSE"))
			{
				gLine = "FALSE";
			}
			else
			{
				gLine = translationManager.translatePredicateExpression(
						g, source,
						targetLanguage);
			}
			guardCode = guardCode + gLine;
			if (i + 1 < conditions.size() && !gLine.trim().equals("")) {
				guardCode = guardCode + " and ";
			}
		}

		return guardCode + ")";
	}

}
