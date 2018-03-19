/**
 *
 */
package org.eventb.codegen.taskbodybuilder;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eventb.codegen.taskbodybuilder.TextToEMFParser.TaskElement;
import org.eventb.codegen.taskbodybuilder.utils.Messages;
import org.eventb.codegen.taskbodybuilder.utils.TaskingGrammarUtils;
import org.rodinp.core.RodinDBException;

import compositeControl.CompositeControl;

/**
 * @author renatosilva
 *
 */
public abstract class AbstractTextParser {

	private Map<ErrorLocation,String> error_description = new LinkedHashMap<ErrorLocation, String>();
	protected String inputString = ""; //$NON-NLS-1$
	protected int previousKind = -1;

	public String getError_description() {
		StringBuffer sb = new StringBuffer();
		for(String error: error_description.values())
			sb.append(error+"\n"); //$NON-NLS-1$
		return sb.toString();
	}

	public Set<ErrorLocation> getErrorsLocations() {
		return error_description.keySet();
	}

	public boolean isParseValid(){
		return error_description.isEmpty();
	}

	protected abstract void parseInput(Token token) throws UnsupportedEncodingException, RodinDBException;

	/**
	 * Method to add errors when taskElement named 'elementName' does not exist
	 *
	 * @param taskElement
	 * @param elementName
	 */
	protected void addErrorNotExist(TaskElement taskElement, String elementName, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_taskElement_does_not_exist,taskElement.getDescription(), elementName)); //$NON-NLS-1$
	}

	/**
	 * Method to add errors when event named 'eventName' has been used before in the same task
	 *
	 * @param taskElement
	 * @param elementName
	 */
	protected void addErrorEventAlreadyUsed(TaskElement taskElement, String eventName, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_event_duplicated, eventName));
	}

	/**
	 * Method to add error when if clause does not have an else clause
	 *
	 * @param taskElement
	 * @param elementName
	 */
	protected void addErrorIfClauseWithoutElse(String ifClause, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_if_clause_without_else, ifClause));
	}

	/**
	 * Method to add errors when elseif clause is misplaced
	 *
	 * @param taskElement
	 * @param elementName
	 */
	protected void addErrorElseIfMisplaced(String elseifClause, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_elseif_clause_misplaced, elseifClause));
	}


	/**
	 * Method to add errors that occur near an element named 'elementName' and 'expectedKeyword' is expected.
	 *
	 * @param expectedKeyword
	 * @param elementName
	 */
	protected void addErrorParse(String expectedKeyword, String elementName, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_parsing_error, elementName,expectedKeyword));
	}

	/**
	 * Method to add error when a set of keywords are expected
	 *
	 * @param expectedKeywords
	 */
	protected void addErrorParse(int[] expectedKeywords, Token token){
		String keywords = ""; //$NON-NLS-1$
		final String append_and = Messages.user_and;
		for(int keyword: expectedKeywords){
			keywords = TaskingGrammarUtils.getKeyWord(keyword) + append_and;
		}
		keywords = keywords.substring(0, keywords.lastIndexOf(append_and));
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn), Messages.bind(Messages.user_parsing_error_keywords, keywords)); //$NON-NLS-2$
	}

	/**
	 * Method to add errors with the corresponding 'errorMessage'
	 *
	 * @param errorMessage
	 */
	protected void addError(String errorMessage, Token token){
		error_description.put(new ErrorLocation(token.beginLine, token.beginColumn),  errorMessage);
	}

	/**
	 * Method to add errors with the corresponding 'errorMessage'
	 *
	 * @param errorMessage
	 */
	protected void addError(String errorMessage, ErrorLocation errorLocation){
		error_description.put(errorLocation, errorMessage);
	}

	/**
	 * Validate the input text and generate the corresponding EMF
	 *
	 * @return the EMF CompositeControl corresponding to the input text
	 * @throws UnsupportedEncodingException
	 * @throws Error 
	 * @throws RodinDBException 
	 */
	public abstract CompositeControl validateInputAndGenerateEMF() throws UnsupportedEncodingException, RodinDBException, Error;

	/**
	 * Parse for grammar errors and return true if no error were found
	 *
	 * @return whether error where found (true) or not (false)
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	public abstract boolean validParsingGrammar() throws UnsupportedEncodingException, ParseException;


	/**
	 * Returns the corresponding EMF as a CompositeControl
	 * @return corresponding EMF as a CompositeControl
	 */
	public abstract CompositeControl getNewValue();

	public class ErrorLocation{
		private int lineNumber;
		private int columnNumber;

		public ErrorLocation(int lineNumber, int columnNumber) {
			super();
			this.lineNumber = lineNumber;
			this.columnNumber = columnNumber;
		}

		public int getLineNumber() {
			return lineNumber;
		}

		public int getColumnNumber() {
			return columnNumber;
		}
	}

}
