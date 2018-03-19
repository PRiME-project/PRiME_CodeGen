package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaEnumerationIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		 Enumeration actualSource = (Enumeration) source;

		
		 String literalStrings = "";
		 EList<String> literals = actualSource.getLiteralValues();
		 String literalArray = "" ;
		 int idx = 0;
		 boolean first = true;
		 for(String l: literals){
			 if(!first){
				 literalStrings = literalStrings + ", " + l ;
				 literalArray = literalArray + ", " + l + "=>" + idx;
			 }
			 else{
				 literalStrings = l;
				 literalArray = l + " => " + idx;
				 first = false;
			 }
			 idx++;
		 }
		 
		 outCode.add("type "+actualSource.getIdentifier()+" is "+"("+literalStrings+");");
		 outCode.add("for "+actualSource.getIdentifier()+" use ");
		 outCode.add("("+literalArray+");");
		 
		
		return outCode;
	}

}
