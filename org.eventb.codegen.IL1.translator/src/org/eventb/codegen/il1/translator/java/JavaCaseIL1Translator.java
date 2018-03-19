package org.eventb.codegen.il1.translator.java;

import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractCaseIL1Translator;

public class JavaCaseIL1Translator extends AbstractCaseIL1Translator {

	@Override
	protected String getCaseBlockStatement(String caseExpression,
			Case actualSource, IL1TranslationManager translationManager) {
		return "switch(" + caseExpression + ")";
	}

	@Override
	protected String getOpenCodeBlock() {		
		return "{";
	}

	@Override
	protected String getCloseCodeBlock() {
		return "}";
	}

}
