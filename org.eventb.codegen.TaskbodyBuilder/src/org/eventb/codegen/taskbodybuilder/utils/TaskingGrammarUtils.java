package org.eventb.codegen.taskbodybuilder.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eventb.codegen.taskbodybuilder.TaskingGrammarConstants;

import compositeControl.Branch;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.SubBranch;

public class TaskingGrammarUtils {

	private static boolean parsingError = false;

	public static String getKeyWord(int keyword){
		return TaskingGrammarConstants.tokenImage[keyword].replaceAll("\"", "").trim();
	}


	/**
	 * Validates if the string number is actually a number
	 * @param number
	 * @return true if it in fact a number or false otherwise
	 */
	public static boolean isNumeric(String number){
		boolean isValid = false;
		/*Explaination:
           [-+]?: Can have an optional - or + sign at the beginning.
           [0-9]*: Can have any numbers of digits between 0 and 9
           \\.? : the digits may have an optional decimal point.
       [0-9]+$: The string must have a digit at the end.
       If you want to consider x. as a valid number change
           the expression as follows. (but I treat this as an invalid number.).
          String expression = "[-+]?[0-9]*\\.?[0-9\\.]+$";
		 */
		String expression = "[-+]?[0-9]*\\.?[0-9]+$";
		CharSequence inputStr = number;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches()){
			isValid = true;
		}
		return isValid;
	}

	public static int getIndex(String itemValue, String[] items){
		int index = -1;
		for(int i=0;i<items.length;i++){
			if(itemValue.equalsIgnoreCase(items[i])){
				index = i;
				break;
			}
		}
		return index;
	}

	public static StringBuffer outputTextLeftSeq(String leftBranchText){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(leftBranchText));
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.SEQ))+Messages.user_EMFToTextParserSeq_Suffix);
		return outputText;
	}

	public static StringBuffer outputTextRightSeq(String rightBranchText){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(rightBranchText));
		return outputText;
	}

	public static StringBuffer outputTextBranch(Branch branch){
		return outputTextBranch(branch.getEventWrapper().getEventName());
	}

	public static StringBuffer outputTextBranch(String eventWrapper){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.IF)));
		outputText.append(appendOutput(eventWrapper)+Messages.user_EMFToTextParser_If_Suffix);
		return outputText;
	}

	public static StringBuffer outputTextBranchElseIf(String subBranchText){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(subBranchText));
		return outputText;
	}

	public static StringBuffer outputTextBranchElse(Branch branch,StringBuffer existingOutputText){
		StringBuffer outputText = new StringBuffer();
		if(branch.getAlt()!=null){
			outputText.append(outputTextBranchElse(branch.getAlt().getEventName(),existingOutputText));
		}
		return outputText;
	}

	public static StringBuffer outputTextBranchElse(String evtName,StringBuffer existingOutputText){
		StringBuffer outputText = new StringBuffer();
		if(existingOutputText.lastIndexOf(Messages.user_EMFToTextParser_Else_Prefix)!=existingOutputText.length()-1)
			outputText.append(Messages.user_EMFToTextParser_Else_Prefix);
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.ELSE)));
		outputText.append(appendOutput(evtName));
		return outputText;
	}

	public static StringBuffer outputTextSubBranch(SubBranch subBranch){
		StringBuffer outputText = new StringBuffer();
		outputText.append(outputTextOtherSubBranch(subBranch.getEventWrapper().getEventName()));

		return outputText;
	}

	public static StringBuffer outputTextOtherSubBranch(String subBranchEventWrapper){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.ELSEIF)));
		outputText.append(appendOutput(subBranchEventWrapper) + Messages.user_EMFToTextParser_ElseIf_Suffix);

		return outputText;
	}

	public static StringBuffer outputTextDo(Do doCycle){
		StringBuffer outputText = new StringBuffer();
		outputText.append(outputTextDo(doCycle.getTaskBody().getEventName()));

		if(doCycle.getFinally()!=null){
			outputText.append(outputTextFinally(doCycle.getFinally().getEventName()));
		}

		return outputText;
	}

	public static StringBuffer outputTextDo(String doEventWrapper){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.DO)));
		outputText.append(appendOutput(doEventWrapper));
		return outputText;
	}

	public static StringBuffer outputTextFinally(String finallyEventWrapper){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.FINALLY)));
		outputText.append(appendOutput(finallyEventWrapper));
		return outputText;
	}

	public static StringBuffer outputTextOutputCommand(Output outputElement){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(TaskingGrammarUtils.getKeyWord(TaskingGrammarConstants.OUTPUT)));
		if(outputElement.getText()!=null)
			outputText.append(appendOutput("\""+outputElement.getText()+"\"")); //$NON-NLS-1$ //$NON-NLS-2$
		if(outputElement.getVariableName()!=null)
			outputText.append(appendOutput(outputElement.getVariableName()));

		return outputText;
	}

	public static StringBuffer outputTextEventWrapper(EventWrapper eventWrapper){
		StringBuffer outputText = new StringBuffer();
		outputText.append(appendOutput(eventWrapper.getEventName()));

		return outputText;
	}



	private static String appendOutput(String append){
		return " " + append.trim();
	}

	public static boolean getParsingError(){
		return parsingError;

	}

}
