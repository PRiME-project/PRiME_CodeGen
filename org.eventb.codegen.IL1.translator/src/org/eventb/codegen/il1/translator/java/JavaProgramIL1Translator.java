package org.eventb.codegen.il1.translator.java;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;
import org.eventb.codegen.tasking.TaskingTranslationManager;

//	Mostly copied from the Cpp translator, not complete or tested.

public class JavaProgramIL1Translator extends AbstractProgramIL1Translator {

	@Override
	protected void addImportStatement(boolean importGlobalConstants,
			IL1TranslationManager translationManager) {
		if (importGlobalConstants) {
			PackagePath path = new PackagePath(translationManager);
			if(GENERATED_PACKAGE_NAME.equals("a_package")){
				updatePackageNames(translationManager);
			}
			translationManager.addIncludeStatement("import static "
					+ AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_" 
							+ path.getPackageName() 
					+ ".MainEntry." + "*;");
		}
	}

	@Override
	protected ArrayList<String> generateProgramCode(
			ArrayList<ArrayList<String>> protectedList,
			ArrayList<ArrayList<String>> mainEntryTasksList,
			ArrayList<ArrayList<String>> standardTasksList,
			ArrayList<ArrayList<String>> environTasksList,
			ArrayList<ArrayList<String>> globalDeclList,
			ArrayList<String> globalDeclIdentifiers,
			ArrayList<String> includeStatements,
			ArrayList<String> compilerDependentCode, Program actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) throws CoreException {

		updatePackageNames(translationManager);
		
		ArrayList<String> outCode = new ArrayList<String>();

		outCode.add("// Code generated: " + getCurrentTimeDate());
		outCode.add("");

		// Put the global declarations into Java import statements
		ArrayList<String> globalImports = new ArrayList<String>();

		Map<String, String> enumTypePathMap = translationManager
				.getEnumTypePathMap();
		Set<String> enumNames = enumTypePathMap.keySet();
		Iterator<String> names = enumNames.iterator();
		PackagePath path = new PackagePath(translationManager);
		while (names.hasNext()) {
			String stateName = names.next();
			String typeString = enumTypePathMap.get(stateName)+"Enum";
			globalImports.add("import static " + AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_"
				+ path.getPackageName() + ".MainEntry." + typeString + "." + stateName + ";");
		}

		// Protected objects
		ArrayList<String> protectedNames = new ArrayList<String>();
		if (protectedList.size() > 0) {

			for (ArrayList<String> p : protectedList) {
				outCode.add("// Protected"); // state we are in the protected
												// part of the code
				outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
				outCode.addAll(globalImports);

				// Add any imports to all classes
				outCode.addAll(includeStatements);

				// First line will be the name
				String pName = p.get(0).split(":")[1].trim();
				protectedNames.add(pName);

				outCode.addAll(p);

				outCode.add("// EndProtected");
			}

		}

		// Main entry tasks, call them all from the main method
		if (mainEntryTasksList.size() > 0) {
			ArrayList<String> taskNames = new ArrayList<String>();

			for (ArrayList<String> m : mainEntryTasksList) {
				outCode.add("// Task");
				outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
				outCode.addAll(globalImports);

				// Add any imports to all classes
				outCode.addAll(includeStatements);

				// First line will be the task name
				String taskName = m.get(0).split(":")[1].trim();
				taskNames.add(taskName);

				outCode.addAll(m);
				outCode.add("// EndTask");
			}

			// Add the environ machine names to the task names
			for (ArrayList<String> m : environTasksList) {
				String taskName = m.get(0).split(":")[1].trim();
				taskNames.add(taskName);
			}

			// Add the main method
			outCode.add("// MainEntry"); // notify start of main entry
			outCode.add("// MainEntry: MainEntry"); // the name
			outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
			outCode.add("import java.util.HashMap;");
			outCode.add("public class MainEntry");
			outCode.add("{"); // start class

			// Add the constants
			for (ArrayList<String> declaration : globalDeclList) {
				outCode.addAll(declaration);
				outCode.add("");
			}

			// Code for Task storage and communication
			outCode.add("//	Stores all tasks and shared machines with their names");
			outCode.add("private static HashMap<String, Object> tasks = new HashMap<String, Object>();");
			outCode.add("");
			outCode.add("public static void addTask(Object task, String name)");
			outCode.add("{");
			outCode.add("tasks.put(name, task);");
			outCode.add("}");
			outCode.add("");
			outCode.add("public static Object getTask(String name)");
			outCode.add("{");
			outCode.add("return tasks.get(name);");
			outCode.add("}");
			outCode.add("");

			// Back to the main code
			outCode.add("public static void main(String [] args)");
			outCode.add("{"); // start main

			// Initialise any protected objects
			if (protectedNames.size() > 0) {
				// Create the shared objects
				outCode.add("// Create the protected objects");
				int sId = 0;
				for (String t : protectedNames) {
					outCode.add(t + " protected" + sId + " = new " + t + "();");
					sId++;
				}

				outCode.add("");
				outCode.add("// Store the tasks in a shared map to allow communication between tasks");
				sId = 0;
				for (String t : protectedNames) {
					outCode.add("addTask(protected" + sId + ", \"" + t + "\");");
					sId++;
				}

				outCode.add("");
			}

			// Create the tasks
			outCode.add("// Create the tasks");
			int id = 0;
			for (String t : taskNames) {
				outCode.add(t + " task" + id + " = new " + t + "();");
				id++;
			}

			outCode.add("");
			outCode.add("// Store the tasks in a shared map to allow communication between tasks");
			id = 0;
			for (String t : taskNames) {
				outCode.add("addTask(task" + id + ", \"" + t + "\");");
				id++;
			}

			// Put the tasks in threads
			outCode.add("");
			outCode.add("// Create the threads");
			for (int i = 0; i < taskNames.size(); i++) {
				outCode.add("Thread thread" + i + " = new Thread(task" + i
						+ ");");
			}

			// Set the priorities
			outCode.add("");
			outCode.add("// Set priority");
			for (int i = 0; i < taskNames.size(); i++) {
				outCode.add("thread" + i + ".setPriority(task" + i
						+ ".getPriority());");
			}

			// Start them
			outCode.add("");
			outCode.add("// Start the threads");
			for (int j = 0; j < taskNames.size(); j++) {
				outCode.add("thread" + j + ".start();");
			}

			outCode.add("}"); // end main
			outCode.add("}"); // end class
			outCode.add("// EndMainEntry");

			// Add the Pointer class - regardless of whether it is used or not
			outCode.add("");
			outCode.add("// Task"); // using the Task flag to auto generate the
									// file later on
			outCode.add("// Task: Pointer");
			outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
			outCode.add("// Used to act as a pointer for out parameters in call-subroutines");
			outCode.add("public class Pointer<T>");
			outCode.add("{");
			outCode.add("T value;");
			outCode.add("}");
			outCode.add("// EndTask");

		}

		// Standard tasks
		if (standardTasksList.size() > 0) {
			for (ArrayList<String> s : standardTasksList) {
				outCode.add("// Task");
				outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
				outCode.addAll(globalImports);
				// Add any imports to all classes
				outCode.addAll(includeStatements);
				outCode.addAll(s);
				outCode.add("// EndTask");
			}

		}

		// Environ tasks
		if (environTasksList.size() > 0) {
			for (ArrayList<String> e : environTasksList) {
				outCode.add("// EnvironTask");
				outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
				outCode.addAll(globalImports);
				// Add any imports to all classes
				outCode.addAll(includeStatements);
				outCode.addAll(e);
				outCode.add("// EndEnvironTask");
			}
		}
		// now add a Java nature to the project if one is required
		addJDTNature();
		return outCode;
	}

	// This method adds a JDT nature if one is not already attached
	private void addJDTNature() throws CoreException {
		IProject project = TaskingTranslationManager.getProject();
		String javaNatureString = "org.eclipse.jdt.core.javanature";
		// if we have don't already have a nature
		if (!project.hasNature(javaNatureString)) {
			// Get the natureIDs from the project description
			IProjectDescription description = project.getDescription();
			String[] natureIdArray = description.getNatureIds();
			// We work with a variable length list, but asList returns a fixed
			// length list
			List<String> natureIDFixedList = Arrays.asList(natureIdArray);
			ArrayList<String> natureIDList = new ArrayList<String>();
			natureIDList.addAll(natureIDFixedList);
			// create a new array from the old one
			String[] newNatureIdArray = Arrays.copyOf(natureIdArray,
					natureIdArray.length + 1);
			newNatureIdArray[natureIdArray.length] = javaNatureString;
			// set the description with the new array
			description.setNatureIds(newNatureIdArray);
			// update the project description
			project.setDescription(description, IProject.KEEP_HISTORY, null);
		}
	}

	private String getCurrentTimeDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}
}
