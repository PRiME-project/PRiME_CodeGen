package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractProtectedIL1Translator;

public class JavaProtectedIL1Translator extends AbstractProtectedIL1Translator {

	@Override
	protected ArrayList<String> generateProtectedCode(
			ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subList, String name,
			Protected actualSource, IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ArrayList<String> outCode = new ArrayList<String>();
		
		//	Generate a class for a protected
		outCode.add("// Protected: " + name);		//	Flag for converting to files in the entry point of the translator.
		outCode.add("");
		
		//	Add the class definition
		outCode.add("public class " + name);
		// At the time of writing I don't think we need interfaces for protected objects
		// But here's the code in case we find out that it's useful.
		// ******
		
		outCode.add("{");							//	start class
		outCode.add("");
		
		//	Add any declarations as instance variables or constants
		outCode.add("// Instance variables and constants");
		for (ArrayList<String> decl : declList)
			outCode.addAll(decl);
		
		//	Add the lock object
		outCode.add("private static Object lock = new Object();");
		
		outCode.add("");
		
		//	Add the constructor
		outCode.add("public " + name + "()");
		outCode.add("{");							//	start constructor
		
		outCode.add("");
		outCode.add("}");							//	end constructor
		
		//	Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");
		for (ArrayList<String> sub : subList)
		{
			outCode.addAll(sub);
			outCode.add("");
		}
		
		outCode.add("}");							//	end class		
		
		return outCode;
	}

}
