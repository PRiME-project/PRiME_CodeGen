package org.eventb.codegen.tasking;

public class TaskingTranslationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -450146664232440801L;

	public TaskingTranslationException()
	{
		super();
	}
	
	public TaskingTranslationException(String error)
	{
		super(error);
	}
}
