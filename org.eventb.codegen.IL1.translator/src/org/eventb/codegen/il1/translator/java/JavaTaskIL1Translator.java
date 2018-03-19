package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractTaskIL1Translator;
import org.eventb.codegen.tasking.TaskingTranslationManager;

public class JavaTaskIL1Translator extends AbstractTaskIL1Translator {

	@Override
	protected ArrayList<String> generateTaskCode(String taskName,
			TaskType taskType, boolean isPeriodic, boolean isRepeating,
			int priority, int period, ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subroutineList,
			ArrayList<String> taskBody, Task actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {
		


		ArrayList<String> outCode = new ArrayList<String>();
		outCode.add("// Task: " + taskName);
		outCode.add("");
		
		//	Add the class definition
		outCode.add("public class " + taskName + " implements Runnable");
		outCode.add("{");	//	start class
		outCode.add("");
		
		//	Add the instance variables
		outCode.add("// Instance variables and constants");
		for (ArrayList<String> decl : declList)
			outCode.addAll(decl);

		String programName = translationManager.getProgramName();


		boolean hasEnvironStateMachines = TaskingTranslationManager.getND_StateMachineList().size() > 0 ;

		
		// add the random variable for environ state machines if required
		if (hasEnvironStateMachines) {
			// we have a non-deterministic case - how many random options??
			int upperBound = TaskingTranslationManager.MaxBranchCount;
			String varName = programName+ "_random";
			outCode.add("protected int "+ varName+ " = 0 + (int)(Math.random()*"+upperBound+");");
		}
				
		
		
		
		
		//	Add priority instance variable
		outCode.add("protected int priority = " + priority + ";");
		
		outCode.add("");
		
		//	Add the constructor - all task body will go in here
		outCode.add("public " + taskName + "()");
		outCode.add("{");	//	start constructor
		
		outCode.add("}");	// 	end constructor
		
		outCode.add("");
		
		//	Add the run method for Runnable		
		outCode.add("public void run()");
		outCode.add("{");				//	start run
		
		//	Handle periodic or repeating tasks
		if (isPeriodic || isRepeating)
		{
			outCode.add("while(true)");
			outCode.add("{");	//	start while loop
			
			//	Get timer information
			if (isPeriodic)
			{				
				outCode.add("// [Internal] Timer information for repeating or periodic tasks");
				outCode.add("long THREAD_START_TIME = System.currentTimeMillis();");
				outCode.add("");
			}
			
			outCode.add("// Translated code");
			outCode.addAll(taskBody);
			
			if (isPeriodic)
			{			
				outCode.add("");
				outCode.add("// [Internal] Code to monitor time between periodic tasks");
				outCode.add("long THREAD_END_TIME = System.currentTimeMillis();");
				outCode.add("long THREAD_TIME_TAKEN = THREAD_END_TIME - THREAD_START_TIME;");
				
				
				//	Now the sleep code
				outCode.add("try");
				outCode.add("{");
				outCode.add("Thread.sleep(Math.max(" + period + " - THREAD_TIME_TAKEN,0));");				
				outCode.add("}");
				outCode.add("catch (InterruptedException e)");
				outCode.add("{");
				outCode.add("e.printStackTrace();");
				outCode.add("}");
			}
			
			outCode.add("}");	//	end while loop
		}
		else
		{		
			outCode.addAll(taskBody);
		}
				
		
		outCode.add("}");				//	end run
		
		
		//		Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");
		for (ArrayList<String> sub : subroutineList)
		{
			outCode.addAll(sub);
			outCode.add("");
		}
		
		//	Add get priority method		
		outCode.add("public int getPriority()");
		outCode.add("{");
		outCode.add("return priority;");
		outCode.add("}");
		
		outCode.add("");
		
		outCode.add("}");	//	end class
		
		return outCode;
		
	}



}
