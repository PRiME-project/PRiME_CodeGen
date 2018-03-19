package org.eventb.codegen.il1.translator.primecpp;

import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractIfIL1Translator;

public class PrimeCppIfTranslator extends AbstractIfIL1Translator {

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new PrimeCppTranslatorUtils();
	}

	@Override
	protected String getIfStatement(String guardString) {
		guardString = translateUntranslated(guardString);
		return "if (" + guardString + ")";
	}

	private String translateUntranslated(String guardString) {
		if(guardString.contains("∨"))
			guardString = guardString.replace("∨", " || ");
		
		return guardString;
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
