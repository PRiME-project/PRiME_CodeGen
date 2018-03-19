package org.eventb.codegen.il1.translator.c.OLD;

import java.util.ArrayList;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.ClassHeaderInformation;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
@Deprecated
public class CProtectedIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		ArrayList<String> outCode = new ArrayList<String>();
		Protected actualSource = (Protected)source;
		
		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
		headerInfo.setClassName(actualSource.getName());
		
		outCode.add("// Protected: " + actualSource.getName());
		outCode.add("");
		outCode.add("// Variables");
		outCode.add("");
		
		for (Declaration decl : actualSource.getDecls())
		{
			ArrayList<String> declStr = translationManager.translateIL1ElementToCode(decl, targetLanguage);
			outCode.addAll(declStr);
		}
		
		outCode.add("");
		outCode.add("// Subroutines");
		
		for (Subroutine subroutine : actualSource.getSubroutines())
		{
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(subroutine, targetLanguage);
			
			if (subStr != null)
			{
				//	The first line will contain the information to be placed in the header file for this protected object
				String firstLine = subStr.get(0);
				headerInfo.getHeaderEntries().add(firstLine + ";");
				
				outCode.addAll(subStr);
			}
			outCode.add("");
		}
		
		translationManager.addClassHeaderInformation(headerInfo);
		
		return outCode;
	}

}
