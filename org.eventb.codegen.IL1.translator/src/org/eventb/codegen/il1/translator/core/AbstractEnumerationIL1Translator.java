package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractEnumerationIL1Translator extends
		AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Enumeration enumeration = (Enumeration) source;

		AbstractIL1TranslatorUtils utils = this.getTranslatorUtils();

		outCode = declareEnumeration(enumeration.getIdentifier(),
				utils.convertToArrayList(enumeration.getLiteralValues()),
				enumeration, translationManager);

		return outCode;
	}

	/**
	 * Used to translate the enumeration name and set of literals, into the
	 * language correct declaration for a enumeration.
	 * 
	 * @param enumerationName
	 *            The name of the enumeration.
	 * @param literals
	 *            The set of literals to use.
	 * @param actualSource
	 *            The actual enumeration being translated.
	 * @param translationManager
	 *            The translation manager being used.
	 * @return The language specific translation of an enumeration.
	 */
	protected abstract ArrayList<String> declareEnumeration(
			String enumerationName, ArrayList<String> literals,
			Enumeration actualSource, IL1TranslationManager translationManager);

	/**
	 * Return the AbstractIL1TranslatorUtils object for the language you are
	 * translating.
	 * 
	 * @return
	 */
	protected abstract AbstractIL1TranslatorUtils getTranslatorUtils();
}
