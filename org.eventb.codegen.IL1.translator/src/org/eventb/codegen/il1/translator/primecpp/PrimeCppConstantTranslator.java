package org.eventb.codegen.il1.translator.primecpp;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractConstantIL1Translator;
import org.eventb.codegen.tasking.CodeGenTasking;

public class PrimeCppConstantTranslator extends AbstractConstantIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		ArrayList<String> outCode = new ArrayList<String>();
		ConstantDecl actualSource = (ConstantDecl) source;

		TranslatedDecl translated = translationManager.translateDeclaration(
				actualSource, targetLanguage);

		String contextName = actualSource.getComponentName();

		if (translated instanceof PartiallyTranslatedDecl) {
			String declLine = generateConstantDeclaration(translated.getType()
					.trim(), actualSource.getIdentifier().trim(),
					((PartiallyTranslatedDecl) translated)
							.getPartialInitialisationExpression(), contextName,
					translationManager);
			if (declLine.length() > 0) {
				outCode.add(declLine);
			}
		} else if (translated instanceof FullyTranslatedDecl) {
			outCode.addAll(handleFullyTranslatedDecl(
					(FullyTranslatedDecl) translated, actualSource,
					contextName, translationManager));
		}

		return outCode;
	}

	@Override
	protected String generateConstantDeclaration(String type,
			String identifier, String initialisation, String machineName, IL1TranslationManager translationManager) {

		if(translationManager.getEnumTypeNameList().contains(type) || type.equals("")){
			// do not return a declaration if it is of enum type (el : Enum_states)
			// or the enumerated type itself (Enum_states).
			return "";
		}
		
		//	Don't add the context (machine) name, as it is not unique to just one place for global constants
		if (initialisation != null && !initialisation.equals(""))
		{
			if(!type.contains("array"))
			return "const " + type + " " + identifier + " = " + initialisation + ";";
			else
				return  "constvar " + getConstArrayInit(type, identifier, initialisation);//+ type + " " + identifier + " = " + getConstArrayInit(initialisation) + ";";
		}
		else
		{
			return "const " + type + " " + identifier + ";";
		}
	}

	private String getConstArrayInit(String type, String identifier, String initialisation) {

		String[] init = initialisation.split(",");
		String output = "";
		int i = 0;
		for(String s : init)
		{
			s = s.trim();
			s = s.replace("}", "");
			String[] e = s.split(Pattern.quote("\u21A6")); //char: mapto
			if(i == 0){
				output = "{" +  e[1];
				i++;
			}
			else{
				output = output + "," + e[1];
				i++;
			}
			if(i == init.length)
				output = output + "}";
			

		}
		String[] t = type.split("array");
		output = t[0] + identifier + t[1] + " = " + output + ";";
		
		return output;
	}

	@Override
	protected ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, ConstantDecl actualSource,
			String machineName, IL1TranslationManager translationManager) {
	
		ArrayList<String> outCode = new ArrayList<String>();
		boolean first = true;
		for (String s : decl.getFullInitialisationExpression())
		{
			//	Tokenize gLine to find the variables
			s = translationManager.tokenizeVariablesOperators(s);
			//	Append machine name to the variables
			// s = CActionIL1Translator.updateVariableName(s, actualSource, translationManager);
			PrimeCppTranslatorUtils utils = new PrimeCppTranslatorUtils();
			s = utils.updateVariableName(s, actualSource, translationManager);
			
			if (first)
			{
				outCode.add("const " + s + ";");
				first = false;
			}
			else
			{
				outCode.add(s + ";");	//	not in original version, looks like it should be
			}
			
		}
		
		return outCode;
	}

}
