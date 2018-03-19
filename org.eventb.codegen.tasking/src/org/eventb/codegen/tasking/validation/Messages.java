/**
 * 
 */
package org.eventb.codegen.tasking.validation;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

/**
 * @author renatosilva
 *
 */
public final class Messages {
	
	private static final String BUNDLE_NAME = "org.eventb.codegen.tasking.validation.messages";//$NON-NLS-1$

	
	public static String scuser_NoTaskingMachineError;
	public static String scuser_MultipleTaskingTypeError;
	public static String scuser_NoTaskBodyError;
	public static String scuser_NoTaskTypeError;
	public static String scuser_NoPeriodTaskDefinedError;
	public static String scuser_NoSimpleTaskDefinedError;


	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Bind the given message's substitution locations with the given string values.
	 * 
	 * @param message the message to be manipulated
	 * @param bindings An array of objects to be inserted into the message
	 * @return the manipulated String
	 */
	public static String bind(String message, Object... bindings) {
		return MessageFormat.format(message, bindings);
	}
	
	private Messages() {
		// Do not instantiate
	}

}
