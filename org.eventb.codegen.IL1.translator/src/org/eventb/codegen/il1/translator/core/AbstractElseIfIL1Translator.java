package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractElseIfIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		ElseIf actualSource = (ElseIf)source;
		
		//	Build the guard string
		AbstractIL1TranslatorUtils utils = getTranslatorUtils();
		String guardCode = utils.buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);
		
		if(actualSource.isEnvirStateMachineChild()){
			// we have an environ state-machine, so we need to add some
			// non-deterministic guards. Check that we have a caseStatement container
			CaseStatement caseStatement = getParentCaseStatement(actualSource);
			
			if(caseStatement == null){
				return null;
			}
			else{
				// which state-machine is this associated with?
				String programName = translationManager.getProgramName();
				String ndPart = programName+"_random <= "+ IL1TranslationManager.branchProbability--;
				if(guardCode.length()>2){
					guardCode = guardCode + " && ("+ ndPart+")";
				}
				else{
					guardCode = "("+ ndPart+")";
				}
			}
		}

		
		//	Generate the ElseIf statement
		outCode.add(getElseIfStatement(guardCode));
		
		//	Open code block using curly braces etc.
		String open = getOpenCodeBlock();
		if (!open.equals(""))
			outCode.add(open);
		
		//	Translate the action
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getAction(), targetLanguage));
		
		//	Close the code block
		String close = getCloseCodeBlock();
		if (!close.equals(""))
			outCode.add(close);
		
		//	Translate any further branches
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBranch(), targetLanguage));		
		
		return outCode;		
		
	}
	
	private CaseStatement getParentCaseStatement(EObject object) {
		while(object != null){
			EObject container = object.eContainer();
			if(container instanceof CaseStatement){
				return (CaseStatement) container;
			}
			object = container;
		}
		return null;
	}
	
	
	/**
	 * Return the AbstractIL1TranslatorUtils object for the language you are translating.
	 * @return
	 */
	protected abstract AbstractIL1TranslatorUtils getTranslatorUtils();
	
	/**
	 * Return the string that represents an ElseIf in your language with the given guard string.
	 * Do not include any open a code block using braces or similar here.
	 * Do include brackets around the guard string if they are required in your language.
	 * @return
	 */
	protected abstract String getElseIfStatement(String guardString);
	
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
	
}
