package org.eventb.codegen.il1.translator.ada;

import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractCaseStatementIL1Translator;

public class AdaCaseStatementIL1Translator extends
		AbstractCaseStatementIL1Translator {

	@Override
	protected String getCaseStart(String caseValue, CaseStatement actualSource,
			IL1TranslationManager translationManager) {
		return "when " + caseValue + " => ";
	}

	@Override
	protected String getCaseEnd(CaseStatement actualSource,
			IL1TranslationManager translationManager) {
		return "";
	}

}
