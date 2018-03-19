package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaCallTranslator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Call actualSource = (Call) source;

		Subroutine s = actualSource.getSubroutine();

		String subProgramCall = null;

		// The calling machine name
		String callMchName = actualSource.getMachineName();
		// The called Machine Name
		String subroutineMchName = s.getMachineName();
		
		if (Utils.isEnvironMachineName(s.getMachineName(), translationManager)) {
			subProgramCall = s.getMachineName() + "." + s.getName();
		} else if(subroutineMchName.equals(callMchName)) {
			subProgramCall = s.getName();
		}
		else{
			subProgramCall = s.getMachineName() + "Inst." + s.getName();
		}

		boolean hasParams = s.getFormalParameters().size() > 0;
		if (hasParams) {
			subProgramCall = subProgramCall + "(";

			boolean first = true;
			for (Parameter p : actualSource.getActualParameters()) {
				if (!first)
					subProgramCall = subProgramCall + ", ";

				subProgramCall = subProgramCall + p.getIdentifier();
				first = false;
			}

			subProgramCall = subProgramCall + ")";

		}

		outCode.add(subProgramCall + ";");

		return outCode;
	}

}
