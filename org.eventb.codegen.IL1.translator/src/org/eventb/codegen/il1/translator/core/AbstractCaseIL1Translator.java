package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractCaseIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Case actualSource = (Case)source;
		
		//	Get the case expression
		String caseExpression = actualSource.getCaseExpression();
		
		//	Get how to structure the case
		String caseStatement = getCaseBlockStatement(caseExpression, actualSource, translationManager);
		
		//	Generate the first part of the case statement
		outCode.add(caseStatement);
		
		//	Get how to open the code block
		String open = getOpenCodeBlock();
		if(!(open.isEmpty())) outCode.add(open);
		
		//	Translate and add the individual case statements
		for (CaseStatement c : actualSource.getCaseStatement())
		{
			outCode.addAll(translationManager.translateIL1ElementToCode(c, targetLanguage));
		}
		
		
		//	Get how to close the code block
		String close = getCloseCodeBlock();
		if(!close.isEmpty())outCode.add(close);
		
		
		return outCode;
	}
	
	/**
	 * Return the string that holds the initial part of the case statement. For example "switch(expression)".
	 * @param caseExpression The translated expression for the case statement.
	 * @param actualSource The actual Case being translated.
	 * @param translationManager The translation manager being used.
	 * @return The string that represents that initial part of the case statement.
	 */
	protected abstract String getCaseBlockStatement(String caseExpression, Case actualSource, IL1TranslationManager translationManager);
	
	/**
	 * Return the string that represents opening a code block.
	 * Eg. { in C or Java.
	 * Return "" if there is no such command or requirement - eg. in Ada.
	 * @return
	 */
	protected abstract String getOpenCodeBlock();
	
	/**
	 * Return the string that represents closing a code block.
	 * Eg. } in C or Java.
	 * Return "" if there is no such command or requirement - eg. in Ada.
	 * @return
	 */
	protected abstract String getCloseCodeBlock();

}
