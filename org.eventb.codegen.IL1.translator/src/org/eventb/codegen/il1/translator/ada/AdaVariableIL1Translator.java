package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;

/**
 * This handles the translation for Variable Declarations
 * 
 * @author Andy
 * 
 */
public class AdaVariableIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage) {

		ArrayList<String> outCode = new ArrayList<String>();
		VariableDecl actualSource = (VariableDecl) source;

		String parentName = Utils.getParentName(actualSource);
		
		Map<String, Map<String, VariableDecl>> tManDeclMap = translationManager.getDeclarationMap();
		Map<String, VariableDecl> varDeclRecords = tManDeclMap.get(parentName);
		
		if(varDeclRecords == null){
			// a record does not exist for this machine
			Map<String, VariableDecl> newRecord = new HashMap<String, VariableDecl>();
			newRecord.put(actualSource.getIdentifier(), actualSource);
			tManDeclMap.put(parentName, newRecord);			
		}
		else{
			// a record exists, so just add it to the existing map
			varDeclRecords.put(actualSource.getIdentifier(), actualSource);
		}

		
		// Up to this point, the code is just housekeeping.
		// The real translation begins here, in the call to translateDeclaration().
		TranslatedDecl decl = translationManager.translateDeclaration(
				actualSource, targetLanguage);

		if (decl instanceof PartiallyTranslatedDecl)
		{
			StringBuffer text = new StringBuffer();
			text.append(actualSource.getIdentifier() + " : " + decl.getType());
			if (((PartiallyTranslatedDecl) decl).getPartialInitialisationExpression() != null && !((PartiallyTranslatedDecl) decl).getPartialInitialisationExpression().equals(""))
			{
				text.append(" := " + ((PartiallyTranslatedDecl)decl).getPartialInitialisationExpression());
			}
			text.append(";");
			outCode.add(text.toString());
		}
		else if (decl instanceof FullyTranslatedDecl)
		{
			outCode.addAll(((FullyTranslatedDecl)decl).getFullInitialisationExpression());
		}
		return outCode;
	}
}
