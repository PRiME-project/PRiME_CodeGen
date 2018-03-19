/**
 *
 */
package org.eventb.codegen.taskbodybuilder;

import org.eventb.codegen.taskbodybuilder.utils.TaskingGrammarUtils;

import tasking.Task;

import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;
import compositeControl.SubBranch;

/**
 * @author renatosilva
 *
 */
public class EMFToTextParser {
	private Task parentTask;
	boolean parsing_error = false;

	public EMFToTextParser(Task parent) {
		parentTask = parent;
	}

	private String parseInput(CompositeControl compositeElement){
		StringBuffer outputText = new StringBuffer();

		if(compositeElement instanceof Seq){
			Seq seq = (Seq) compositeElement;
			CompositeControl leftBranch = seq.getLeftBranch();
			assert leftBranch!=null;
			if(leftBranch==null){
				parsing_error = true;
				return ""; //$NON-NLS-1$
			}
			String leftBranchText = parseInput(leftBranch);

			outputText.append(TaskingGrammarUtils.outputTextLeftSeq(leftBranchText));

			CompositeControl rightBranch = seq.getRightBranch();
			assert rightBranch!=null;
			String rightBranchText = parseInput(rightBranch);
			outputText.append(TaskingGrammarUtils.outputTextRightSeq(rightBranchText));
		}
		else if(compositeElement instanceof Branch){
			Branch branch = (Branch) compositeElement;
			assert branch.getEventWrapper()!=null;
			if(branch.getEventWrapper()==null){
				parsing_error = true;
				return ""; //$NON-NLS-1$
			}

			outputText.append(TaskingGrammarUtils.outputTextBranch(branch));

			if(branch.getSubBranch()!=null){
				String subBranchText=parseInput(branch.getSubBranch());
				outputText.append(TaskingGrammarUtils.outputTextBranchElseIf(subBranchText));
			}

			outputText.append(TaskingGrammarUtils.outputTextBranchElse(branch,outputText));
		}
		else if(compositeElement instanceof SubBranch){
			SubBranch subBranch = (SubBranch) compositeElement;
			assert subBranch.getEventWrapper()!=null;
			if(subBranch.getEventWrapper()==null){
				parsing_error = true;
				return ""; //$NON-NLS-1$
			}

			outputText.append(TaskingGrammarUtils.outputTextSubBranch(subBranch));

			if(subBranch.getSubBranch()!=null){
				outputText.append(parseInput(subBranch.getSubBranch()));
			}
		}
		else if(compositeElement instanceof Do){
			Do doCycle = (Do)compositeElement;
			EventWrapper taskBody = doCycle.getTaskBody();
			assert taskBody!=null;
			if(taskBody==null){
				parsing_error = true;
				return ""; //$NON-NLS-1$
			}

			outputText.append(TaskingGrammarUtils.outputTextDo(doCycle));
		}
		else if(compositeElement instanceof Output){
			Output outputElement = (Output)compositeElement;
			outputText.append(TaskingGrammarUtils.outputTextOutputCommand(outputElement));
		}
		else if(compositeElement instanceof EventWrapper){
			EventWrapper eventWrapper = (EventWrapper)compositeElement;
			outputText.append(TaskingGrammarUtils.outputTextEventWrapper(eventWrapper));
		}

		return outputText.toString();
	}

	public String outputText(){
		return parseInput(parentTask.getTaskBody());
	}

	public boolean existsParsingError(){
		return parsing_error;
	}
}
