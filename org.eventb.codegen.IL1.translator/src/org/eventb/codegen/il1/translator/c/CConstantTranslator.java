package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;

import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractConstantIL1Translator;

public class CConstantTranslator extends AbstractConstantIL1Translator {

	@Override
	protected String generateConstantDeclaration(String type,
			String identifier, String initialisation, String machineName, IL1TranslationManager translationManager) {

		if(translationManager.getEnumTypeNameList().contains(type) || type.equals("")){
			// do not return a declaration if it is of enum type (el : Enum_states)
			// or the enumerated type itself (Enum_states).
			return "";
		}
		
		//	Don't add the context (machine) name, as it is not unique to just one place for global constants
		if (initialisation != null && !initialisation.equals(""))
		{
			return "const " + type + " " + identifier + " = " + initialisation + ";";			
		}
		else
		{
			return "const " + type + " " + identifier + ";";
		}
	}

	@Override
	protected ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, ConstantDecl actualSource,
			String machineName, IL1TranslationManager translationManager) {
	
		ArrayList<String> outCode = new ArrayList<String>();
		boolean first = true;
		for (String s : decl.getFullInitialisationExpression())
		{
			//	Tokenize gLine to find the variables
			s = translationManager.tokenizeVariablesOperators(s);
			//	Append machine name to the variables
			// s = CActionIL1Translator.updateVariableName(s, actualSource, translationManager);
			CTranslatorUtils utils = new CTranslatorUtils();
			s = utils.updateVariableName(s, actualSource, translationManager);
			
			if (first)
			{
				outCode.add("const " + s + ";");
				first = false;
			}
			else
			{
				outCode.add(s + ";");	//	not in original version, looks like it should be
			}
			
		}
		
		return outCode;
	}

}
