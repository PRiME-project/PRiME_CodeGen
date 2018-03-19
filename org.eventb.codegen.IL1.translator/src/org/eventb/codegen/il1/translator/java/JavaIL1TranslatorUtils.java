package org.eventb.codegen.il1.translator.java;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;

public class JavaIL1TranslatorUtils extends AbstractIL1TranslatorUtils {

	@Override
	protected String getTrue() {
		return "true";
	}

	@Override
	protected String getFalse() {
		return "false";
	}

	@Override
	protected String getAnd() {
		return "&&";
	}

	//	Not needed here
	@Override
	protected String updateVariableName(String actionLine,
			IL1Element actualSource, IL1TranslationManager translationManager) {

		return actionLine;
	}

}
