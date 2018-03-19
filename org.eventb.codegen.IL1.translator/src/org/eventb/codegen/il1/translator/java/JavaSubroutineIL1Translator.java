package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractSubroutineIL1Translator;

public class JavaSubroutineIL1Translator extends
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

		outCode.add("public void " + name + "(" + parameters + ")");

		outCode.add("{"); // open method

		if (isProtected || isEnviron) {
			outCode.add("// [Internal] This will block until the guard has been met");
			outCode.add("boolean completed = false; \t // private to the thread by default");
			outCode.add("// [Internal] Try and get lock");
			outCode.add("synchronized(lock)"); // there will be an object called
												// lock that can be used for
												// this
			outCode.add("{"); // open protected
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

		if (!guardList.equals("")) {
			if (isProtected || isEnviron) {
				outCode.add("");
				outCode.add("// [Internal] Set completed flag");
				outCode.add("completed = true;");
			}
			outCode.add("}"); // close guarded
		} else {
			if (isProtected || isEnviron) {
				outCode.add("// [Internal] Set completed flag");
				outCode.add("completed = true;");
			}
		}

		if (isProtected || isEnviron) {
			outCode.add("}"); // close protected
		}

		outCode.add("}"); // close method

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
			// pType gets modified to be an int - whereas it should really be an
			// Integer class,
			// and this goes for Booleans as well. We must change int to Integer
			// and boolean to Boolean
			if (type.equals("int")) {
				type = "Integer";
			} else if (type.equals("boolean")) {
				type = "Boolean";
			}
			paramDefn = "Pointer<" + type + "> " + identifier;
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
		return new JavaIL1TranslatorUtils();
	}

}
