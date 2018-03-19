package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractConstantIL1Translator;

public class JavaConstantIL1Translator extends AbstractConstantIL1Translator {

	@Override
	protected String generateConstantDeclaration(String type,
			String identifier, String initialisation, String machineName, IL1TranslationManager translationManager) {
		
		if(translationManager.getEnumTypeNameList().contains(type) || type.equals("")){
			// do not return a declaration if it is of enum type (el : Enum_states)
			// or the enumerated type itself (Enum_states).
			return "";
		}
		
		return "protected static final " + type + " " + identifier + " = " + initialisation + ";";
	}

	@Override
	protected ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, ConstantDecl actualSource,
			String machineName, IL1TranslationManager translationManager) {
		
		System.out.println("Java constant IL1 translator does not correctly handle fully translated declarations");
		ArrayList<String> outCode = new ArrayList<String>();
		outCode.addAll(decl.getFullInitialisationExpression());
		
		return outCode;
	}



}
