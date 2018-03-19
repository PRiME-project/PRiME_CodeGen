/**
 * 
 */
package org.eventb.codegen.theory.translator.internal.ui;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

/**
 * @author renatosilva
 *
 */
public class Messages {
	
//	public static String TARGET_LANGUAGES;
	public static String TRANSLATOR_LABEL_DEFAULT;
	public static String TRANSLATOR_FORMULA_DEFAULT;
	public static String TRANSLATOR_OUTPUT_DEFAULT;
	public static String TRANSLATOR_TARGET_LANGUAGE_DEFAULT;
	
	
	private static final String BUNDLE_NAME = "org.eventb.codegen.theory.translator.internal.ui.messages"; //$NON-NLS-1$

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
