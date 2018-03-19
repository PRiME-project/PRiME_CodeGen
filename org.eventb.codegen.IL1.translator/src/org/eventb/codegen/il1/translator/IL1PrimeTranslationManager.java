package org.eventb.codegen.il1.translator;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.primecpp.PrimeCppTaskTranslator;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;
import org.eventb.codegen.tasking.CodeGenTasking;

public class IL1PrimeTranslationManager extends IL1TranslationManager{
	
	public ArrayList<String> translateIL1ElementToCode(IL1Element source,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		
		if (source == null) {
			return new ArrayList<String>();
		}
		

		// Set the target language
		this.currentTranslationTarget = targetLanguage;
		AbstractIL1Translator translator = null;

		// Get the real target language information,
		// the given targetLanguage just contains coreLanguage and
		// specificLanguage strings.
		int index = supportedLanguages.indexOf(targetLanguage);
		if (index == -1) {
			TranslatorUtils.log("Undefined translator for type: " + source
					+ " Core: " + targetLanguage.getCoreLanguage()
					+ ". Specific: " + targetLanguage.getSpecificLanguage(),
					IStatus.WARNING, source);

			throw new IL1TranslationUnhandledTypeException(source,
					targetLanguage);
		} else {
			// See if the index exists in the supported languages (contains the
			// translators to use)
			// Then if the index also has the required translator

			
			TargetLanguage actualTargetLanguage = supportedLanguages.get(index);
			translator = actualTargetLanguage.getTranslator(source);

			if (translator == null) {
				// If this isn't already requesting the default translator,
				// see if the default version of the required translator exists
				if (!targetLanguage.getSpecificLanguage().equals("Default")) {
					TargetLanguage defaultTargetLanguage = new TargetLanguage(
							targetLanguage.getCoreLanguage());
					index = supportedLanguages.indexOf(defaultTargetLanguage);

					if (index >= 0) {
						actualTargetLanguage = supportedLanguages.get(index);
						translator = actualTargetLanguage.getTranslator(source);
					}
				}

				// If the translator is still null, abort
				if (translator == null) {
					TranslatorUtils.log("Undefined translator for type: "
							+ source + " Undefined translator. Core: "
							+ targetLanguage.getCoreLanguage() + ". Specific: "
							+ targetLanguage.getSpecificLanguage(),
							IStatus.WARNING, source);

					throw new IL1TranslationUnhandledTypeException(source,
							targetLanguage);
				}
			}
		}

		if (source instanceof Enumeration) {
			Enumeration e = (Enumeration) source;
			if (e.getIdentifier().startsWith("Eng")) {
				System.out.println("Enum " + e.getIdentifier());
			}
		}
		// This is where we translate the ILElements to code
		ArrayList<String> code = new ArrayList<String>();
		try {
			
			if(translator instanceof PrimeCppTaskTranslator)
				translator.inputArguments = inputArguments;

			code = translator.translate(source, this, targetLanguage);

		} catch (CoreException e) {
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		} catch (IL1TranslationException e) {
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: IL1TranslationException" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		} catch (Exception e)
		{
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Exception (" + e.toString() + ") :" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		}
		

				
		return code;
	}


}
