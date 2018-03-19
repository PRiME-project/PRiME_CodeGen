package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractVariableIL1Translator;


public class JavaVariableIL1Translator extends AbstractVariableIL1Translator {

	@Override
	protected String generateVariableDeclaration(String type,
			String identifier, String initialisation, String machineName, boolean isProtected) {
		
		if (initialisation == null || initialisation.equals(""))
		{
			if (isProtected)
				return "protected static " + type + " " + identifier + ";";
			else
				return "protected " + type + " " + identifier + ";";
		}
		else
		{
			if (isProtected)
				return "protected static " + type + " " + identifier + " = " + initialisation + ";";
			else
				return "protected " + type + " " + identifier + " = " + initialisation + ";";
		}
	}

	@Override
	protected ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, VariableDecl actualSource,
			String machineName, IL1TranslationManager translationManager) {

		ArrayList<String> outCode = new ArrayList<String>();
		outCode.addAll(decl.getFullInitialisationExpression());
		
		return outCode;
	}


}
