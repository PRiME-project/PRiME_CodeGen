package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;
import java.util.List;

import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractCaseStatementIL1Translator extends
		AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		ArrayList<String> outCode = new ArrayList<String>();
		CaseStatement actualSource = (CaseStatement)source;
		List<String> caseStatements = new ArrayList<String>();
		//	Get start case
		String startCaseStatement = getCaseStart(actualSource.getCaseValue(), actualSource, translationManager);
		//	Translate the action
		ArrayList<String> statements = translationManager.translateIL1ElementToCode(actualSource.getCommand(),targetLanguage);
		if(statements.size() == 0) caseStatements.add(startCaseStatement + " null;");
		else{
			caseStatements.add(startCaseStatement);
			caseStatements.addAll(statements);
		}
		//	End case
		String endString = getCaseEnd(actualSource, translationManager);
		if(!endString.isEmpty()) caseStatements.add(endString);
		outCode.addAll(caseStatements);
		return outCode;
	}
	
	
	/**
	 * Returns the start of a case statement. For example: "case A:"
	 * @param caseValue The value to be used in the case statement.
	 * @param actualSource The actual CaseStatement being translated.
	 * @param translationManager The translation manager if needed.
	 * @return The start of a case statement.
	 */
	protected abstract String getCaseStart(String caseValue, CaseStatement actualSource, IL1TranslationManager translationManager);
	
	/**
	 * Returns how to end a case statement. For example: "break;"
	 * @param actualSource The actual CaseStatement being translated.
	 * @param translationManager The translation manager if needed.
	 * @return The end of a case statement.
	 */
	protected abstract String getCaseEnd(CaseStatement actualSource, IL1TranslationManager translationManager);

}
