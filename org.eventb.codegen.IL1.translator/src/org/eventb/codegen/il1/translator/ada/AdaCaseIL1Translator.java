package org.eventb.codegen.il1.translator.ada;

import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractCaseIL1Translator;

public class AdaCaseIL1Translator extends AbstractCaseIL1Translator {

	@Override
	protected String getCaseBlockStatement(String caseExpression,
			Case actualSource, IL1TranslationManager translationManager) {
		return "case " + caseExpression + " is";
	}

	@Override
	protected String getOpenCodeBlock() {
		return "";
	}

	@Override
	protected String getCloseCodeBlock() {
		return "end case;";
	}

}
