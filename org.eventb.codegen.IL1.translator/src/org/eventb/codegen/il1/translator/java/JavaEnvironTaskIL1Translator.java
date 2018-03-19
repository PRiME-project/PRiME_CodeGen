package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.InterfaceGenerator;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractEnvironIL1Translator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;

public class JavaEnvironTaskIL1Translator extends AbstractEnvironIL1Translator {

	@Override
	protected ArrayList<String> generateEnvironCode(String taskName,
			TaskType taskType, boolean isPeriodic, boolean isRepeating,
			int priority, int period, ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subroutineList,
			ArrayList<String> taskBody, Task actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ArrayList<String> outCode = new ArrayList<String>();
		outCode.add("// EnvironTask: " + taskName);
		outCode.add("");

		// Add the class definition
		String signature = "public class " + taskName + " implements Runnable";

		// do we need to implement an interface?
		if(InterfaceGenerator.requiresInterface){
			InterfaceGenerator generator = InterfaceGenerator.getDefault();
			List<String> implementsList = generator.getImplementsList();
			//just check that the class has an interface
			if(!implementsList.contains(taskName)){
				try {
					throw new TaskingTranslationException("Interface required but not found for "+ taskName);
				} catch (TaskingTranslationException e) {
					Status status = new Status(IStatus.ERROR,
							CodeGenTasking.PLUGIN_ID,
							"Failed Translation: TaskingTranslationException:"
							+ e.getMessage(), e);
						StatusManager.getManager().handle(status,
							StatusManager.SHOW);
				}
			}
			else{
				signature = signature + ", I"+taskName;
			}
		}

		outCode.add(signature);
		outCode.add("{"); // start class
		outCode.add("");

		// Add the instance variables
		outCode.add("// Instance variables and constants");
		for (ArrayList<String> decl : declList)
			outCode.addAll(decl);

		// Add the lock object
		outCode.add("private static Object lock = new Object();");

		outCode.add("");

		// Add priority instance variable
		outCode.add("protected int priority = " + priority + ";");

		outCode.add("");

		// Add the constructor - all task body will go in here
		outCode.add("public " + taskName + "()");
		outCode.add("{"); // start constructor

		outCode.add("}"); // end constructor

		outCode.add("");

		// Add the run method for Runnable
		outCode.add("public void run()");
		outCode.add("{"); // start run

		// Handle periodic or repeating tasks
		if (isPeriodic || isRepeating) {
			outCode.add("while(true)");
			outCode.add("{"); // start while loop

			// Get timer information
			if (isPeriodic) {
				outCode.add("// [Internal] Timer information for repeating or periodic tasks");
				outCode.add("long THREAD_START_TIME = System.currentTimeMillis();");
			}

			outCode.add("synchronized(lock)");
			outCode.add("{");
			outCode.add("// Translated code");
			outCode.addAll(taskBody);
			outCode.add("}");

			if (isPeriodic) {
				outCode.add("// [Internal] Code to monitor time between periodic tasks");
				outCode.add("long THREAD_END_TIME = System.currentTimeMillis();");
				outCode.add("long THREAD_TIME_TAKEN = THREAD_END_TIME - THREAD_START_TIME;");

				// Now the sleep code
				outCode.add("try");
				outCode.add("{");
				outCode.add("Thread.sleep(Math.max(" + period
						+ " - THREAD_TIME_TAKEN,0));");
				outCode.add("}");
				outCode.add("catch (InterruptedException e)");
				outCode.add("{");
				outCode.add("e.printStackTrace();");
				outCode.add("}");

			}

			outCode.add("}"); // end while loop
		} else {
			outCode.addAll(taskBody);
		}

		outCode.add("}"); // end run

		// Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");
		for (ArrayList<String> sub : subroutineList) {
			outCode.addAll(sub);
			outCode.add("");
		}

		// Add get priority method
		outCode.add("public int getPriority()");
		outCode.add("{");
		outCode.add("return priority;");
		outCode.add("}");

		outCode.add("");

		outCode.add("}"); // end class

		return outCode;
	}

}
