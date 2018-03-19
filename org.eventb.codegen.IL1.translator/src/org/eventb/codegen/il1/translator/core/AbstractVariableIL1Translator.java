package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractVariableIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		VariableDecl actualSource = (VariableDecl)source;
		
		TranslatedDecl translated = translationManager.translateDeclaration(actualSource, targetLanguage);
		
		String machineName = "";
		boolean isProtected = false;
		Task t = translationManager.getParentTask(actualSource);
		if (t != null)
		{
			machineName = t.getName();
		}
		else
		{
			Protected p = translationManager.getParentProtected(actualSource);
			machineName = p.getName();
			isProtected = true;
		}
		
		
		if (translated instanceof PartiallyTranslatedDecl)
		{
			String declLine = generateVariableDeclaration(translated.getType().trim(), actualSource.getIdentifier().trim(), ((PartiallyTranslatedDecl)translated).getPartialInitialisationExpression(), machineName, isProtected);			
			
			outCode.add(declLine);
		}
		else if (translated instanceof FullyTranslatedDecl)
		{
			outCode.addAll(handleFullyTranslatedDecl((FullyTranslatedDecl) translated, actualSource, machineName, translationManager));
		}
		
		return outCode;		
	}
	
	/**
	 * Generate a variable declaration from a given type, identifier and initialisation.
	 * @param type The type.
	 * @param identifier The identifier.
	 * @param initialisation The initialisation.
	 * @param machineName The machine name, which may or may not be of use.
	 * @param isProtected Whether the parent is a Protected
	 * @return The full translation for a declaration.
	 */
	protected abstract String generateVariableDeclaration(String type, String identifier, String initialisation, String machineName, boolean isProtected);

	/**
	 * Handle a variable declaration that has been fully translated by the theory plug-in. 

	 * @param decl The fully translated declaration.
	 * @param actualSource The object being translated.
	 * @param machineName The machine name if required.
	 * @param translationManager The translation manager if required.
	 * @return
	 */
	protected abstract ArrayList<String> handleFullyTranslatedDecl(FullyTranslatedDecl decl, VariableDecl actualSource, String machineName, IL1TranslationManager translationManager);

}
