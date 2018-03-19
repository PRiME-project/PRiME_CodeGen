package org.eventb.codegen.il1.translator;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.TaskingTranslationException;

public abstract class AbstractIL1Translator {

	public ArrayList<Declaration> inputArguments = null;

	/**
	 * Translator from and IL1Element to code. This must return an
	 * ArrayList<String> object, even if it is empty. Do not return null.
	 * 
	 * @param source
	 *            The element to be translated. This will be guaranteed to be
	 *            the one it is linked to in the extension point.
	 * @param translationManager
	 *            The translation manager that called it and that can be used to
	 *            do further translation.
	 * @param targetLanguage
	 *            The target language to translate to. Must have Core language
	 *            set, can have specific language set.
	 * @return An ArrayList<String> of code. Each line of code should be a
	 *         separate element in the ArrayList. Do not return null.
	 * @throws IL1TranslationUnhandledTypeException
	 *             If anything goes wrong, this exception can be used.
	 * @throws CoreException
	 * @throws TaskingTranslationException
	 */
	public abstract ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException, CoreException,
			IL1TranslationException;

}
