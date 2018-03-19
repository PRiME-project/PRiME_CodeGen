/**
 *
 */
package org.eventb.codegen.theory.translator.core.utils;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

/**
 * @author renatosilva
 *
 */
public final class Messages {

	private static final String BUNDLE_NAME = "org.eventb.codegen.theory.translator.core.utils.messages";


	public static String progress_Translator;
	public static String progress_TranslatorLabel;
	public static String progress_TranslatorTarget;
	public static String progress_TranslatorMetavariable;

	public static String scuser_UndefinedLabel;
	public static String scuser_AmbigiousLabel;
	public static String scuser_UndefinedTranslation;
	public static String scuser_UndefinedTargetLanguage;
	public static String scuser_UndefinedFormula;
	public static String scuser_UnparsableFormula;
	public static String scuser_InvalidMetavariableIdentifier;
	public static String scuser_TypeAttrMissingForOpArgError;

	public static String exception_RetrievingDeployedTheoryRoot;
	public static String exception_RetrievingTypeEnvironment;



	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
		// Do not instantiate
	}

	/**
	 * Bind the given message's substitution locations with the given string
	 * values.
	 *
	 * @param message
	 *            the message to be manipulated
	 * @param bindings
	 *            An array of objects to be inserted into the message
	 * @return the manipulated String
	 */
	public static String bind(String message, Object... bindings) {
		return MessageFormat.format(message, bindings);
	}


}
