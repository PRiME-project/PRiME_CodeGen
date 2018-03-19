package org.eventb.codegen.il1.translator.c;

import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractCaseIL1Translator;

public class CCaseTranslator extends AbstractCaseIL1Translator {

	@Override
	protected String getCaseBlockStatement(String caseExpression,
			Case actualSource, IL1TranslationManager translationManager) {
		return "switch(" + caseExpression + "_" + translationManager.getRodinMachineName(actualSource) + ")";
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
