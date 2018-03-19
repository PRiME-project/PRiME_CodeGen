package org.eventb.codegen.il1.translator.primecpp;

import java.util.ArrayList;

import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractEnumerationIL1Translator;
import org.eventb.codegen.il1.translator.core.AbstractIL1TranslatorUtils;

public class PrimeCppEnumerationTranslator extends AbstractEnumerationIL1Translator {

	@Override
	protected ArrayList<String> declareEnumeration(String enumerationName,
			ArrayList<String> literals, Enumeration actualSource, IL1TranslationManager translationManager) {		
		ArrayList<String> outCode = new ArrayList<String>();
		String outString = "typedef enum {" + enumerationName;
		
		boolean first = true;
		for (String l : literals)
		{
			if(first){
			outString = outString + (l);
			first = false;
			}
			else{
				outString = outString + (", "+l);
			}
		}
		outString = ""; //outString + ("} " + enumerationName + ";");		//	enumerationName needed at end to stop compiler complaining
		outCode.add(outString);
		return outCode;
	}

	@Override
	protected AbstractIL1TranslatorUtils getTranslatorUtils() {		
		return new PrimeCppTranslatorUtils();
	}

}
