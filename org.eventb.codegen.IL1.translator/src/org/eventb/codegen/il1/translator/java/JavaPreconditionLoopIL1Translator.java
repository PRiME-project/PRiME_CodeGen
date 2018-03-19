package org.eventb.codegen.il1.translator.java;

import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;
import org.eventb.codegen.il1.translator.core.AbstractPreconditionLoopIL1Translator;

public class JavaPreconditionLoopIL1Translator extends AbstractPreconditionLoopIL1Translator {

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {
		return new JavaIL1TranslatorUtils();
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
