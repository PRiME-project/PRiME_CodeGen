package org.eventb.codegen.templates.util;

public class TemplateException extends Exception {

	public TemplateException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7899778464629670227L;

	@Override
	public String getMessage() {
		String initialMessage = super.getMessage() + "\n";
		StackTraceElement[] stackTraceArray = getStackTrace();
		for (int idx = 0; idx < stackTraceArray.length; idx++) {
			initialMessage = initialMessage + stackTraceArray[idx] + "\n";
		}
		return initialMessage;
	}
	
	public static String extractFullExceptionMessage(Exception e) {
		String initialMessage = e.getMessage() + "\n";
		StackTraceElement[] stackTraceArray = e.getStackTrace();
		for (int idx = 0; idx < stackTraceArray.length; idx++) {
			initialMessage = initialMessage + stackTraceArray[idx] + "\n";
		}
		return initialMessage;
	}
}
