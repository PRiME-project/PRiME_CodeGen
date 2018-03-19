package org.eventb.codegen.il1.translator.core;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationException;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.tasking.TaskingTranslationManager;

public abstract class AbstractProgramIL1Translator extends
		AbstractIL1Translator {

	// a default name for the Java source directory
	public static String GENERATED_PACKAGE_NAME = "a_package";
	public static String GENERATED_PACKAGE = "package "
	+ GENERATED_PACKAGE_NAME + ";";

	// To add an import statement, provide the implementation in the concrete class, else
	// just leave the concrete implementation empty;
	abstract protected void addImportStatement(boolean importGlobalConstants, IL1TranslationManager translationManager);
	
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

	/**
	 * Builds the program code from the given translated elements.
	 * 
	 * @param protectedList
	 *            The translated protected objects. Each ArrayList(String)
	 *            represents a single protected that was translated.
	 * @param mainEntryTasksList
	 *            The translated main entry objects. Each ArrayList(String)
	 *            represents a single main entry that was translated. These
	 *            should be called automatically when the program starts.
	 * @param standardTasksList
	 *            The translated tasks that are not main entry tasks. Each
	 *            ArrayList(String) represents a single task that was
	 *            translated.
	 * @param environTasksList
	 *            The translated environment machine objects. Each
	 *            ArrayList(String) represents a single environment machine that
	 *            was translated.
	 * @param globalDeclList
	 *            Any global declarations, such as enumerations.
	 * @param globalDeclarationIdentifiers
	 *            The identifiers of any global declarations.
	 * @param includeStatements
	 *            Any include or import statements that has been requested by
	 *            the translators.
	 * @param compilerDependentCode
	 *            Any compiler dependent code that has been requested by the
	 *            translators.
	 * @param actualSource
	 *            The actual Program being translated.
	 * @param translationManager
	 *            The translation manager.
	 * @param targetLanguage
	 *            The target language.
	 * @return The fully translated code for the program.
	 * @throws CoreException 
	 */
	protected abstract ArrayList<String> generateProgramCode(
			ArrayList<ArrayList<String>> protectedList,
			ArrayList<ArrayList<String>> mainEntryTasksList,
			ArrayList<ArrayList<String>> standardTasksList,
			ArrayList<ArrayList<String>> environTasksList,
			ArrayList<ArrayList<String>> globalDeclList,
			ArrayList<String> globalDeclarationIdentifiers,
			ArrayList<String> includeStatements,
			ArrayList<String> compilerDependentCode, Program actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) throws CoreException;

	public static void updatePackageNames(IL1TranslationManager translationManager) {
		String programName = translationManager.getProgramName();
		if(!(programName == null) && !(programName.equals("")) ){
			String coreLanguage = translationManager.getCurrentTranslationTarget().getCoreLanguage();
			String specificLanguage = translationManager.getCurrentTranslationTarget().getSpecificLanguage();
			if(specificLanguage.equalsIgnoreCase("default")){
				specificLanguage = "";
			}
			else{
				specificLanguage = "_" + specificLanguage;
			}
			
			AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME = programName.substring(0, 1).toLowerCase() + programName.substring(1);
			AbstractProgramIL1Translator.GENERATED_PACKAGE = "package "
					+ AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_" 
					+ coreLanguage + specificLanguage  
					+";";
		}
	}

}
