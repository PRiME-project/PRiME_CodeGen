package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public abstract class AbstractPreconditionLoopIL1Translator extends
		AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {


		ArrayList<String> outCode = new ArrayList<String>();
		PreconditionLoop actualSource = (PreconditionLoop)source;
		
		//	Build the guard string
		AbstractIL1TranslatorUtils utils = getTranslatorUtils();
		String guardString = utils.buildGuardConditionString(actualSource.getCondition(), actualSource, translationManager, targetLanguage);	
		
		//	Generate the While statement
		outCode.add(getWhileStatement(guardString));

		//	Open code block using curly braces etc.
		String open = getOpenCodeBlock();
		if (!open.equals(""))
			outCode.add(open);
		
		//	Add the task body
		outCode.addAll(translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage));
		
		//	Close the code block
		String close = getCloseCodeBlock();
		if (!close.equals(""))
			outCode.add(close);
		
		
		String endWhile = getEndWhile();
		
		if (!endWhile.equals(""))
		{
			outCode.add(endWhile);
		}
		
		return outCode;	
	}
	
	
	
	/**
	 * Return the AbstractIL1TranslatorUtils object for the language you are translating.
	 * @return
	 */
	protected abstract AbstractIL1TranslatorUtils getTranslatorUtils();
	
	
	/**
	 * Return the string that represents a While in your language with the given guard string.
	 * Do not include any open a code block using braces or similar here.
	 * Do include brackets around the guard string if they are required in your language.
	 * @return
	 */
	protected abstract String getWhileStatement(String guardString);
	
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
	 * Return the string for EndWhile, if it exists in your language.
	 * Return "" if it does not.
	 * @return
	 */
	protected abstract String getEndWhile();

}
