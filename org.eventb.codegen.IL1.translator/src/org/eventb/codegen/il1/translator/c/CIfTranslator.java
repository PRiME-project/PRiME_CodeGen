package org.eventb.codegen.il1.translator.c;

import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractIfIL1Translator;

public class CIfTranslator extends AbstractIfIL1Translator {

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new CTranslatorUtils();
	}

	@Override
	protected String getIfStatement(String guardString) {
		return "if (" + guardString + ")";
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
	protected String getElse() {
		return "else";
	}

	@Override
	protected String getEndIf() {
		return "";
	}

}
