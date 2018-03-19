package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractEnumerationIL1Translator;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;

public class JavaEnumerationIL1Translator extends
		AbstractEnumerationIL1Translator {

	@Override
	protected ArrayList<String> declareEnumeration(String enumerationName,
			ArrayList<String> literals, Enumeration actualSource,
			IL1TranslationManager translationManager) {

		ArrayList<String> outCode = new ArrayList<String>();

		String fullEnumName = enumerationName + "Enum"; 
		outCode.add("public enum " + fullEnumName);
		outCode.add("{");

		for (String l : literals) {
			outCode.add(l + ",");
		}

		outCode.add("}"); // apparently "};" is also fine for ending
							// enumerations

		// forces the loading of all enumeration elements
		// there are also import statics for each enumeration separately in
		// JavaProgramIL1Translator
		// this just does the elements in the enumeration

		PackagePath path = new PackagePath(translationManager);
		
		AbstractProgramIL1Translator.updatePackageNames(translationManager);

		translationManager.addIncludeStatement("import static "
				+ AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_"
				+ path.getPackageName() + ".MainEntry."
				+ fullEnumName + ".*;");

		translationManager.addIncludeStatement("import "
				+ AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_"
				+ path.getPackageName() + ".MainEntry."
				+ fullEnumName + ";");
		return outCode;
	}


	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new JavaIL1TranslatorUtils();
	}
}
