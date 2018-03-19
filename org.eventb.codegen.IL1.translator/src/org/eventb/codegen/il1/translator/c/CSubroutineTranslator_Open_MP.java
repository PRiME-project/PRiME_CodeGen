package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;

import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractSubroutineIL1Translator;

public class CSubroutineTranslator_Open_MP extends
		AbstractSubroutineIL1Translator {

	@Override
	protected ArrayList<String> generateFunction(String name,
			ArrayList<String> parameterDefinitions,
			ArrayList<ArrayList<String>> localVariables, String guardList,
			ArrayList<String> body, boolean isProtected, boolean isEnviron,
			String machineName, Subroutine actualSource,
			IL1TranslationManager translationManager) {

		ArrayList<String> outCode = new ArrayList<String>();

		// Format the parameters
		String parameters = "";
		boolean first = true;
		for (String p : parameterDefinitions) {
			if (!first)
				parameters = parameters + ", ";

			parameters = parameters + p;
			first = false;
		}

		// Uniquely identify each event name using the machine name
		outCode.add("void " + machineName + "_" + name + "(" + parameters + ")");
		outCode.add("{"); // open function

		if (isProtected || isEnviron) {
			// Output OpenMP blocking
			translationManager.addIncludeStatement("typedef int BOOL;");
			translationManager.addIncludeStatement("#define TRUE 1");
			translationManager.addIncludeStatement("#define FALSE 0");
		}

		// Guards
		if (!guardList.equals("")) {
			outCode.add("// Check to see if guard is met");
			outCode.add("if (" + guardList + ")");
			outCode.add("{"); // open guarded
		}

		// Local variables
		for (ArrayList<String> lVars : localVariables) {
			outCode.addAll(lVars);
		}

		// Body code
		outCode.add("// Translated code");
		outCode.addAll(body);

		if(isProtected && body.size() == 0) {
			outCode.add("// In the case of a controller - polling model,");
			outCode.add("// where an autotask machine polls a shared machine,");
			outCode.add("// simulations can be coded in this stub.");
		}

		
		if (!guardList.equals("")) {
			outCode.add("}"); // close guarded
		} 
		
	
		// outCode.add("}"); // close critical
		outCode.add("}"); // close function

		return outCode;

	}

	@Override
	protected String generateParameterDefinition(String type,
			String identifier, ParameterType parameterType) {
		String paramDefn = "";

		// Out parameters (to the calling subroutine) will be using the Pointer
		// class.
		switch (parameterType) {
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
