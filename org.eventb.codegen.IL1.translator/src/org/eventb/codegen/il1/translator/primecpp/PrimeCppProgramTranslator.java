package org.eventb.codegen.il1.translator.primecpp;

import static org.eventb.codegen.il1.translator.TranslateFromEventBToC_OpenMP_C.COMMON_HEADER_FULL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.IL1TranslationException;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;
import org.eventb.codegen.tasking.TaskingTranslationManager;

public class PrimeCppProgramTranslator extends AbstractProgramIL1Translator {

	
	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException, CoreException, IL1TranslationException {

		Program actualSource = (Program) source;
		IL1TranslationManager.branchProbability = TaskingTranslationManager.MaxBranchCount;
		// Add the random generator and packages etc for coverage testing
		
		String programName = actualSource.getProjectName();
		if(programName == null){
			throw new IL1TranslationException("The IL1 model has no program name (often caused by incorrect settings in Composed Machine, following refinement.)");
		}
		programName = programName.replaceAll("\\W", "_");
		translationManager.setProgramName(programName);

		// Ensure there are no include statements from previous translations
		translationManager.clearIncludeStatements();
		translationManager.clearCompilerDependentExecutableCodeBlock();

		// Translate any enumerations before protected objects
		// Put each enumeration in its own ArrayList<String>
		ArrayList<ArrayList<String>> globalDeclList = new ArrayList<ArrayList<String>>();
		ArrayList<String> globalDeclIdentifiers = new ArrayList<String>();
		boolean importGlobalConstants = false;
		
		for (Declaration decl : actualSource.getDecls()) {
			// translate the declarations and add to the collection of global
			// declarations
			ArrayList<String> globalDeclCode = translationManager
					.translateIL1ElementToCode(decl, targetLanguage);
			globalDeclList.add(globalDeclCode);

			// If the declaration is an enumeration, add it to the enumeration
			// list so that the
			// declaration translator later will ignore translating the type for
			// any variables or constants that are of an enumeration type.
			if (decl instanceof Enumeration) {
				translationManager.getEnumTypeNameList().add(
						decl.getIdentifier());
			} else if (decl instanceof ConstantDecl) {
				ConstantDecl c = (ConstantDecl) decl;
				ArrayList<String> enumTypeNames = translationManager
						.getEnumTypeNameList();
				if (enumTypeNames.contains(c.getType())) {
					translationManager.getEnumTypePathMap().put(
							decl.getIdentifier(), decl.getType());
				}
				// if we have a constant decl we will want to import it later so
				// set this flag
				if (!importGlobalConstants) {
					importGlobalConstants = true;
				}
			}

			globalDeclIdentifiers.add(decl.getIdentifier());
		}

		addImportStatement(importGlobalConstants, translationManager);


		// Translate protected objects second
		// Put each protected in its own ArrayList<String>
		ArrayList<ArrayList<String>> protectedList = new ArrayList<ArrayList<String>>();
		for (Protected p : actualSource.getProtected()) {
			ArrayList<String> pStr = translationManager
					.translateIL1ElementToCode(p, targetLanguage);
			protectedList.add(pStr);
		}

		// Translate main entry tasks
		// Put each task in its own ArrayList<String>
		ArrayList<ArrayList<String>> mainEntryTasksList = new ArrayList<ArrayList<String>>();
		if (actualSource.getEntryPoint() != null) {
			for (Task task : actualSource.getEntryPoint().getAutoTasks()) {
				ArrayList<String> taskCode = translationManager
						.translateIL1ElementToCode(task, targetLanguage);
				mainEntryTasksList.add(taskCode);
			}
		}

		// Translate any standard tasks
		// Put each task in its own ArrayList<String>
		ArrayList<ArrayList<String>> standardTasksList = new ArrayList<ArrayList<String>>();
		for (Task task : actualSource.getTaskTypeTasks()) {
			ArrayList<String> taskCode = translationManager
					.translateIL1ElementToCode(task, targetLanguage);
			standardTasksList.add(taskCode);
		}

		// Translate any standard tasks
		// Put each environ task in its own ArrayList<String>
		ArrayList<ArrayList<String>> environTasksList = new ArrayList<ArrayList<String>>();
		for (EnvironTask task : actualSource.getEnvironMachines()) {
			ArrayList<String> taskCode = translationManager
					.translateIL1ElementToCode(task, targetLanguage);
			environTasksList.add(taskCode);
		}

		// Get any other stored code that may exist
		ArrayList<String> includeStatements = translationManager
				.getIncludeStatements();
		ArrayList<String> compilerDependentCode = translationManager
				.getCompilerDependentExecutableCodeBlock();

		ArrayList<String> outCode = this.generateProgramCode(protectedList,
				mainEntryTasksList, standardTasksList, environTasksList,
				globalDeclList, globalDeclIdentifiers, includeStatements,
				compilerDependentCode, actualSource, translationManager,
				targetLanguage);

		return outCode;
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
			TargetLanguage targetLanguage) {

		ArrayList<String> outCode = new ArrayList<String>(); // contains the
																// full code
																// including
																// include
																// statements
																// and body code
		ArrayList<String> mainCode = new ArrayList<String>(); // code for the
																// main function

		ArrayList<String> inputVariables = new ArrayList<String>();
		
		// Adds boolean information by default, so it can be used elsewhere by
		// actions, variables and the theories
		translationManager.addIncludeStatement("typedef int BOOL;");
		translationManager.addIncludeStatement("#define TRUE 1");
		translationManager.addIncludeStatement("#define FALSE 0");

		updatePackageNames(translationManager);

		// Required header used by all code - generated in
		// TranslateFromEventBToC

		// Add code for threads

		outCode.add("// Code generated: " + getCurrentTimeDate());
		outCode.add("");

		if (globalDeclList.size() > 0) {
			outCode.add("// GlobalDeclarations");
			// Output global declarations first
			// assuming they are constants
			String cons = "";
			for (ArrayList<String> declarations : globalDeclList) {
				for (String dString : declarations) {
					if(dString.startsWith("constvar"))
					{
						// remove const
						dString = dString.replace("constvar", "");
						// add define
						cons = "const " + dString.trim();
						//outCode.add(dString);
					}
					else if (dString.startsWith("const")) {
						// remove const
						dString = dString.replace("const", "");
						// replace = with a space
						dString = dString.replace("=", "");
						// remove ending ;
						dString = dString.replace(";", "");
						if(dString.contains("inarg_")){
							inputVariables.add(dString);
							continue;
						}
						// add define
						dString = "#define " + dString.trim();
						outCode.add(dString);
					} else if(dString.trim().length() > 0){
						outCode.addAll(declarations);
					}
				}
			}
			outCode.add(cons);
			outCode.add("// EndGlobalDeclarations");
		}

		// Protected objects
		if (protectedList.size() > 0) {
			for (ArrayList<String> p : protectedList) {
				outCode.add("// Protected"); // state we are in the protected
												// part of the code
				// Required header used by all code - generated in
				// TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				outCode.addAll(p);
				outCode.add("// EndProtected");
			}
		}

		// Then any main entry tasks
		if (mainEntryTasksList.size() > 0 || environTasksList.size() > 0) {
			ArrayList<String> mainMethodTaskNames = new ArrayList<String>();
			for (ArrayList<String> m : mainEntryTasksList) {
				outCode.add("// Task");
				// Required header used by all code - generated in
				// TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				// First line will be the task name
				String taskName = m.get(0).split(":")[1].trim();
				outCode.add("#include \"" + taskName + ".hpp\"");
				outCode.add("#include \"comlib.hpp\"");

				mainMethodTaskNames.add(taskName);
				outCode.addAll(m);
				outCode.add("// EndTask");
			}

			// Add the environ machine names to the task names
			for (ArrayList<String> m : environTasksList) {
				String taskName = m.get(0).split(":")[1].trim();
				mainMethodTaskNames.add(taskName);
			}

			mainCode.add("// MainEntry"); // notify start of main entry
			mainCode.add("// MainEntry: MainEntry"); // the name
			// Required header used by all code - generated in
			// TranslateFromEventBToC
			mainCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
			for (String m : mainMethodTaskNames) {
				mainCode.add("#include \"" + m.trim()  + ".cpp\""); 
				mainCode.add("#include \"" + m.trim()  + ".hpp\""); 
			}
			mainCode.add("int main (int argc, char *argv[])");
			mainCode.add("{"); // start main

			
			// Call the initialisation function of each task
//			for (String m : mainMethodTaskNames) {
//				mainCode.add(m.trim() + "_init();"); 
//			}

			// Add code to start the tasks
			for (String m : mainMethodTaskNames) {
				mainCode.add("prime::codegen::" + m.trim()  + "* cg" + " = new prime::codegen::"+  m.trim() + "();"); 
			}
			
			//mainCode.add( );
			
			mainCode.add("}"); // end main
		}

		// Standard tasks
		if (standardTasksList.size() > 0) {
			for (ArrayList<String> s : standardTasksList) {
				outCode.add("// Task");
				// Required header used by all code - generated in
				// TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");

				outCode.addAll(s);
				outCode.add("// EndTask");
			}
		}

		//COMLIB
		
		outCode.add("// COMLIB");
		outCode.addAll(getComLib());
		outCode.add("// EndCOMLIB");
		
		//ENDCOMLIB
		
		//COMLIB
		
		outCode.add("// COMLIBH");
		outCode.addAll(getComLibH());
		outCode.add("// EndCOMLIBH");
		
		//ENDCOMLIB
		
		
		
		
		
		// Environ tasks
		// These are added to the main entry in the code above
		if (environTasksList.size() > 0) {
			for (ArrayList<String> e : environTasksList) {
				outCode.add("// EnvironTask");

				// Required header used by all code - generated in
				// TranslateFromEventBToC
				outCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
				outCode.addAll(e);
				outCode.add("// EndEnvironTask");
			}
		}

		outCode.add("");
		outCode.addAll(mainCode);

		outCode.add(""); // blank line to stop ANSI C moaning
		return outCode;
	}

	private Collection<? extends String> getComLib() {
		ArrayList<String> code = new ArrayList<String>();
		code.add("#include <iostream>");
		code.add("#include \"Common.hpp\"");
		//code.add("namespace prime { namespace codegen { namespace comlib{");
		code.add("int MAXROW(int *a)");
		code.add("{");
		code.add("int max = -100;");
		code.add("int i, maxindex = 0; ");
		code.add("for (i = 0; i < N; ++i) { ");
		code.add("if (a[i] > max) { ");
		code.add("maxindex = i; ");
		code.add("max = a[i]; ");
		code.add("} ");
		code.add("} ");
		code.add("return maxindex; ");
		code.add("} ");


		code.add("int RAND(int a, int b)");
		code.add("{");
		code.add("return rand()%(b-a + 1) + a;");
		code.add("}");		
		//code.add("}}}");

		return code;
	}

	private Collection<? extends String> getComLibH() {
		ArrayList<String> code = new ArrayList<String>();
		code.add("#ifndef COMLIB_H");
		code.add("#define COMLIB_H");
		//code.add("namespace prime { namespace codegen { namespace comlib{");
		code.add("#define min(a,b) (((int)(a)<=(int)(b))?(int)(a):(int)(b))");
		code.add("#define max(a,b) (((int)(a)>=(int)(b))?(int)(a):(int)(b))");
		code.add("int MAXROW(int *a);");
		code.add("int RAND(int a, int b);");
		//code.add("}}}");
		code.add("#endif");
		return code;
	}

	private String getCurrentTimeDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}

	@Override
	protected void addImportStatement(boolean importGlobalConstants,
			IL1TranslationManager translationManager) {
		// Implement this if c++ requires import statements
		// This is meant to do nothing for C
	}

}
