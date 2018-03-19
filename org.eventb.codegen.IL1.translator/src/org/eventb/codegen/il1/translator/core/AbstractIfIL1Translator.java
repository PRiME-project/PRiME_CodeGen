package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractIfIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		If actualSource = (If)source;
		
		//	Build the guard string
		AbstractIL1TranslatorUtils utils = getTranslatorUtils();
		String guardString = utils.buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);
	

		if(actualSource.isEnvirStateMachineChild()){
			// we have an environ state-machine, so we need to add some
			// non-deterministic guards. Check that we have a caseStatement container
			EObject container = actualSource.eContainer();
			if(container instanceof CaseStatement){
				String programName = translationManager.getProgramName();
				String ndPart = programName+"_random <= "+ IL1TranslationManager.branchProbability--;
				if(guardString != null && guardString.length()>2){
					guardString = guardString + " && ("+ ndPart+")";
				}
				else{
					guardString = "("+ ndPart+")";
				}
			}
		}
		
		//	Generate the If statement
		outCode.add(getIfStatement(guardString));
		
		//	Open code block using curly braces etc.
		String open = getOpenCodeBlock();
		if (!open.equals(""))
			outCode.add(open);
				
		//	Translate the body
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage));

		//	Close the code block
		String close = getCloseCodeBlock();
		if (!close.equals(""))
			outCode.add(close);
		
		//	if branch
		if (actualSource.getBranch() != null)
		{
			outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBranch(), targetLanguage));
		}

		//	Handle any Else commands
		if (actualSource.getElse() != null)
		{
			
			if(targetLanguage.getCoreLanguage().equalsIgnoreCase("java") 
					&& actualSource.getElse().getBody()==null
					&& actualSource.isEnvirStateMachineChild()){
				System.out.println("!!!!! we have a null else body for: " + actualSource.getParentEventName());	
			}else{
			
			outCode.add(getElse());
			
			//	Open code block using curly braces etc.
			if (!open.equals(""))
				outCode.add(open);

			outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getElse(), targetLanguage));

			if (!close.equals(""))
				outCode.add(close);
			}
		}
		
		String endIf = getEndIf();
		
		if (!endIf.equals(""))
		{
			outCode.add(endIf);
		}
		
		return outCode;	
	}
	
	
	/**
	 * Return the AbstractIL1TranslatorUtils object for the language you are translating.
	 * @return
	 */
	protected abstract AbstractIL1TranslatorUtils getTranslatorUtils();
	
	
	/**
	 * Return the string that represents an If in your language with the given guard string.
	 * Do not include any open a code block using braces or similar here.
	 * Do include brackets around the guard string if they are required in your language.
	 * @return
	 */
	protected abstract String getIfStatement(String guardString);
	
	
	/**
	 * Return the string that represents opening a code block.
	 * Eg. { in C or Java.
	 * Return "" if there is no such command or requirement - eg. in Ada.
	 * @return
	 */
	protected abstract String getOpenCodeBlock();
	
	/**
	 * Return the string that represents closing a code block.
	 * Eg. } in C or Java.
	 * Return "" if there is no such command or requirement - eg. in Ada.
	 * @return
	 */
	protected abstract String getCloseCodeBlock();
	
	
	/**
	 * Return the string that represents Else in your language.
	 * @return
	 */
	protected abstract String getElse();
	
	/**
	 * Return the string for EndIf, if it exists in your language.
	 * Return "" if it does not.
	 * @return
	 */
	protected abstract String getEndIf();

}
