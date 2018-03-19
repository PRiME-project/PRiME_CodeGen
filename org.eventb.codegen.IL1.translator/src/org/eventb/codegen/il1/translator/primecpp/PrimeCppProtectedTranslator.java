package org.eventb.codegen.il1.translator.primecpp;

import java.util.ArrayList;

import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.translator.ClassHeaderInformation;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractProtectedIL1Translator;

public class PrimeCppProtectedTranslator extends AbstractProtectedIL1Translator {

	@Override
	public ArrayList<String> generateProtectedCode(
			ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subList, String name,
			Protected actualSource, IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
		headerInfo.setClassName(actualSource.getName());

		ArrayList<String> outCode = new ArrayList<String>();
		outCode.add("// Protected: " + name);
		outCode.add("");
			
		//	Add the instance variables
		outCode.add("// Variables and constants");
		for (ArrayList<String> decl : declList)
			outCode.addAll(decl);
				
		outCode.add("");
		
		//	Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");
		for (ArrayList<String> sub : subList)
		{			
			//	The first line will contain the information to be placed in the 
			//	header file for this environ machine object
			String firstLine = sub.get(0);
			headerInfo.getHeaderEntries().add(firstLine + ";");
			
			outCode.addAll(sub);			
			outCode.add("");
		}
		
		translationManager.addClassHeaderInformation(headerInfo);	
		
		return outCode;
	}

}
