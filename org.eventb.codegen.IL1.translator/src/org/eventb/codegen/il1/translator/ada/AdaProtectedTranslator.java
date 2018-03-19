package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaProtectedTranslator extends AbstractIL1Translator {

	public AdaProtectedTranslator() {
	}

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Protected actualSource = (Protected) source;
		
		//	Declarations must be translated first (regardless of where code is put), to allow theory to work
		ArrayList<String> declCode = new ArrayList<String>();
		for (Declaration decl : actualSource.getDecls()) {
			ArrayList<String> declStr = translationManager.translateIL1ElementToCode(
					decl, targetLanguage);
			if(declStr.get(0).contains(" array ")){
				int rangeBegin = declStr.get(0).indexOf('(');
				int rangeEnd = declStr.get(0).indexOf(')') + 1;
				int typeBegin = declStr.get(0).indexOf(" of ") + 1;
				int typeEnd = declStr.get(0).indexOf(" := ");
				
				
				String rangeDecl = declStr.get(0).substring(rangeBegin, rangeEnd);
				String containedTypeDecl = declStr.get(0).substring(typeBegin, typeEnd);
				String decl1 = "type " + decl.getIdentifier()+"_array is array "+rangeDecl +" "+ containedTypeDecl+";";
				declCode.add(decl1);
				
				
				int initBegin = declStr.get(0).indexOf(" := ") + 1;
				int initEnd = declStr.get(0).length();
				String initString = declStr.get(0).substring(initBegin, initEnd);
				String decl2 = decl.getIdentifier()+" : "+decl.getIdentifier()+"_array "+initString; 
				declCode.add(decl2);
			}
			else{
				declCode.addAll(declStr);
			}
		}
		// THE SPEC
		// add the global import if one exists
		String specName = translationManager.getGlobalSpecName();
		if(specName != null){
			outCode.add("with "+ specName+";");
			outCode.add("use "+ specName+";");
		}
		outCode.add("package " + actualSource.getName() + "Pkg is ");
		// Add constant and type decls here !!!
		// These are now done in a globals file - which must be with'ed
		for(String declStr: declCode){
			if(declStr.contains(" constant ")){
				outCode.add(declStr);
			}
			else if(declStr.contains("type ")){
				outCode.add(declStr);
			}
		}
		
		outCode.add("protected type " + actualSource.getName() + " is ");
		// procedure declarations here
		for (Subroutine subroutine : actualSource.getSubroutines()) {
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(
					subroutine, targetLanguage);
			if (subStr != null) {
				String replacement = subStr.get(0).replaceAll("is", "").trim(); 
				outCode.add(replacement + ";");
			}
		}
		
		outCode.add("end " + actualSource.getName() + ";");

		boolean first = true;
		for(String declStr: declCode){
			if(! (declStr.contains(" constant ")
					|| declStr.contains("type "))){
				if(first){
					outCode.add("private ");
					first = false;
				}
				outCode.add(declStr);
			}
		}
		outCode.add("end " + actualSource.getName() + "Pkg;");
		outCode.add("-- End of Package"); // The end of package marker
		outCode.add("");
		
		
		// THE BODY
		outCode.add("package body " + actualSource.getName() + "Pkg is ");
		outCode.add("protected body " + actualSource.getName() + " is ");
		for (Subroutine subroutine : actualSource.getSubroutines()) {
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(
					subroutine, targetLanguage);
			if (subStr != null) {
				outCode.addAll(subStr);
			}
		}
		outCode.add("end " + actualSource.getName() + ";");
		outCode.add("end " + actualSource.getName() + "Pkg;");
		outCode.add("-- End of Package"); // The end of package marker
		return outCode;
	}
}
