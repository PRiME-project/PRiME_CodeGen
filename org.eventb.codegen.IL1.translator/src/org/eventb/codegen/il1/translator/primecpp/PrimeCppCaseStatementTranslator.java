package org.eventb.codegen.il1.translator.primecpp;

import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractCaseStatementIL1Translator;

public class PrimeCppCaseStatementTranslator extends
		AbstractCaseStatementIL1Translator {

	@Override
	protected String getCaseStart(String caseValue, CaseStatement actualSource,
			IL1TranslationManager translationManager) {
		return "case " + caseValue + ":";
	}

	@Override
	protected String getCaseEnd(CaseStatement actualSource,
			IL1TranslationManager translationManager) {
		return "break;";
	}

}
