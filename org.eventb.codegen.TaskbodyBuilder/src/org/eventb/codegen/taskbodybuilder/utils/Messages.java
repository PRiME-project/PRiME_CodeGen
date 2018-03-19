/**
 *
 */
package org.eventb.codegen.taskbodybuilder.utils;

import org.eclipse.osgi.util.NLS;

/**
 * @author renatosilva
 *
 */
public final class Messages extends NLS {
private static final String BUNDLE_NAME = "org.eventb.codegen.taskbodybuilder.utils.messages"; //$NON-NLS-1$

	public static String label_task_priority;
	public static String button_set_taskBody;

	public static String user_and;
	public static String user_EMFToTextParser_ElseIf_Suffix;
	public static String user_EMFToTextParser_Else_Prefix;
	public static String user_EMFToTextParserSeq_Suffix;
	public static String user_EMFToTextParser_If_Suffix;

	public static String user_event_duplicated;
	public static String user_if_clause_without_else;
	public static String user_parsing_error;
	public static String user_parsing_error_keywords;
	public static String user_taskElement_does_not_exist;
	public static String user_elseif_clause_misplaced;




	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
