package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractProtectedIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		Protected actualSource = (Protected) source;
		
		String name = actualSource.getName();
		
		//	Declarations must be translated first
		ArrayList<ArrayList<String>> declList = new ArrayList<ArrayList<String>>();
		for (Declaration decl : actualSource.getDecls())
		{
			ArrayList<String> declStr = translationManager.translateIL1ElementToCode(decl, targetLanguage);
			declList.add(declStr);
		}
		
		
		//	Translate the subroutines
		ArrayList<ArrayList<String>> subList = new ArrayList<ArrayList<String>>();
		for (Subroutine subroutine : actualSource.getSubroutines())
		{
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(subroutine, targetLanguage);
			if(subStr.size()>0){
				subList.add(subStr);
			}
		}
		
		ArrayList<String> outCode = this.generateProtectedCode(declList, subList, name, actualSource, translationManager, targetLanguage);
		
		return outCode;	
	}
	
	/**
	 * Build the code for the protected from the given translated elements.
	 * 
	 * @param declList The translated list of declarations. Each ArrayList(String) represents a single declaration that has been translated.
	 * @param subList The translated list of subroutines. Each ArrayList(String) represents a single subroutine that has been translated.
	 * @param name The name of the protected.
	 * @param actualSource The actual Protected being translated if required.
	 * @param translationManager The translation manager being used.
	 * @param targetLanguage The actual target language for the translation. 
	 * @return The fully translated code for a protected.
	 */
	protected abstract ArrayList<String> generateProtectedCode(ArrayList<ArrayList<String>> declList, ArrayList<ArrayList<String>> subList, String name, Protected actualSource, IL1TranslationManager translationManager, TargetLanguage targetLanguage);

}
