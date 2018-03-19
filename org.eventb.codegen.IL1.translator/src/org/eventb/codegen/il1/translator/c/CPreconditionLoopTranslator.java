package org.eventb.codegen.il1.translator.c;

import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractPreconditionLoopIL1Translator;

public class CPreconditionLoopTranslator extends
		AbstractPreconditionLoopIL1Translator {

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new CTranslatorUtils();
	}

	@Override
	protected String getWhileStatement(String guardString) {
		return "while (" + guardString + ")";
	}

	@Override
	protected String getOpenCodeBlock() {
		return "{";
	}

	@Override
	protected String getCloseCodeBlock() {
		return "}";
	}

	@Override
	protected String getEndWhile() {
		return "";
	}

}
