package org.eventb.codegen.il1.translator.c;

import org.eventb.codegen.il1.translator.core.AbstractElseIfIL1Translator;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;

public class CElseIfTranslator extends AbstractElseIfIL1Translator {

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new CTranslatorUtils();
	}

	@Override
	protected String getElseIfStatement(String guardString) {
		return "else if (" + guardString + ")";
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
