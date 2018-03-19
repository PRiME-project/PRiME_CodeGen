package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractConstantIL1Translator extends
		AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		ConstantDecl actualSource = (ConstantDecl) source;

		TranslatedDecl translated = translationManager.translateDeclaration(
				actualSource, targetLanguage);

		String contextName = actualSource.getComponentName();

		if (translated instanceof PartiallyTranslatedDecl) {
			String declLine = generateConstantDeclaration(translated.getType()
					.trim(), actualSource.getIdentifier().trim(),
					((PartiallyTranslatedDecl) translated)
							.getPartialInitialisationExpression(), contextName,
					translationManager);
			if (declLine.length() > 0) {
				outCode.add(declLine);
			}
		} else if (translated instanceof FullyTranslatedDecl) {
			outCode.addAll(handleFullyTranslatedDecl(
					(FullyTranslatedDecl) translated, actualSource,
					contextName, translationManager));
		}

		return outCode;
	}

	/**
	 * Generate a constant declaration from a given type, identifier and
	 * initialisation.
	 * 
	 * @param type
	 *            The type.
	 * @param identifier
	 *            The identifier.
	 * @param initialisation
	 *            The initialisation.
	 * @param machineName
	 *            The machine name, which may or may not be of use. This may
	 *            also be a context name. Ideally this value should only be used
	 *            to uniquely identify the constant.
	 * @param translationManager
	 * @return The full translation for a declaration.
	 */
	protected abstract String generateConstantDeclaration(String type,
			String identifier, String initialisation, String machineName,
			IL1TranslationManager translationManager);

	/**
	 * Handle a declaration that has been fully translated by the theory
	 * plug-in. Importantly the theory plug-in does not know about constants, so
	 * you may need to adjust the string to include a constant.
	 * 
	 * @param decl
	 *            The fully translated declaration, but without any constant
	 *            tag.
	 * @param actualSource
	 *            The object being translated.
	 * @param machineName
	 *            The machine name if required.
	 * @param translationManager
	 *            The translation manager if required.
	 * @return
	 */
	protected abstract ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, ConstantDecl actualSource,
			String machineName, IL1TranslationManager translationManager);
}
