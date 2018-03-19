package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaConstantIL1Translator extends AbstractIL1Translator {

	public AdaConstantIL1Translator() {

	}

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		ConstantDecl actualSource = (ConstantDecl) source;

		
		
		TranslatedDecl declarationCode = translationManager
				.translateDeclaration(actualSource, targetLanguage);

		if (declarationCode instanceof PartiallyTranslatedDecl)
		{
			String decl = actualSource.getIdentifier() + " : constant "
					+ declarationCode.getType() + " := "
					+ ((PartiallyTranslatedDecl)declarationCode).getPartialInitialisationExpression() + ";";
	
			outCode.add(decl);
		}
		else if (declarationCode instanceof FullyTranslatedDecl)
		{
			outCode.addAll(((FullyTranslatedDecl)declarationCode).getFullInitialisationExpression());
		}
		
		return outCode;
	}

}
