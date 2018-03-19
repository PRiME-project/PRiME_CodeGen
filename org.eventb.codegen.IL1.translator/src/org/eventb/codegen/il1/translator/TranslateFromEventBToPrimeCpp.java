package org.eventb.codegen.il1.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.primecpp.PrimeCppTranslatorUtils;
import org.eventb.codegen.il1.translator.provider.ITranslationRule;
import org.eventb.codegen.il1.translator.utils.IL1CodeFiler;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TranslateToIL1;
import org.osgi.service.prefs.BackingStoreException;
import org.rodinp.core.RodinDBException;

public class TranslateFromEventBToPrimeCpp extends
AbstractTranslateEventBToTarget{

	public static String COMMON_HEADER_PARTIAL = "Common";
	public static String COMMON_HEADER_FULL = COMMON_HEADER_PARTIAL + ".hpp";

	@Override
	protected TargetLanguage getTargetLanguage() {
		return new TargetLanguage("Cpp");
	}

	@Override
	public void run(IAction arg0) {
		// Force a build of the project, to catch any static checks that may not
		// have been performed
		// actually this code didn't work, so it has been removed
		// rebuild(selection);

		// Translate EventBToIL1
		MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION
				| SWT.CANCEL);

		dialog.setText("Translation Status");
		try {
			Program program = TranslateToIL1
					.translateEventBToIL1(getSelection());

			// Now to the code generation
			IL1PrimeTranslationManager il1TranslationManager = new IL1PrimeTranslationManager();

			il1TranslationManager
					.setCurrentTranslationTarget(getTargetLanguage());

			List<String> code = null;

			// Translation Rules
			Map<IProject, List<ITranslationRule>> translationRules = loadTranslatorRules();
			il1TranslationManager.setTranslatorRules(translationRules);
			
						
			
			// Types Rules
			Map<IProject, List<ITranslationRule>> translationTypeRules = loadTranslatorTypeRules();
			il1TranslationManager.setTranslatorTypeRules(translationTypeRules);

            //Direct Operation Definition Translation Rules
            Map<IProject, List<ITranslationRule>> allTranslationRules = mergHashMap(translationRules, translationTypeRules);
            Map<IProject, List<ITranslationRule>> translationDirectRules = loadTranslatorDirectRules(allTranslationRules);
            
            //Check if there is a translation rule for the direct translation rules
//          for (IProject p: translationDirectRules.keySet()) {
//              List<ITranslationRule> translationDirectRuleElements = translationDirectRules.get(p);
//              for (ITranslationRule translationDirectRule: translationDirectRuleElements) {
//                  IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(translationDirectRule.getFormula().toString(), typeEnvironment, rules,false);
//                  String translatedExpression = formulaVisitor.translate();
//              }
//              
//          }
 
            
            il1TranslationManager.setTranslatorRules(mergHashMap(translationRules, translationDirectRules));

			code = il1TranslationManager.translateIL1ElementToCode(program,
					getTargetLanguage());
			code = formatCode(code, il1TranslationManager);

			// for C we will remove unicode *
			TargetLanguage translationTarget = il1TranslationManager
					.getCurrentTranslationTarget();
			boolean isC = translationTarget.getCoreLanguage().equals("c");
			if (isC) {
				List<String> processedCode = new ArrayList<String>();
				for (String codeLine : code) {
					// if there is non-ASCII characters in the line, replace if possible.
					// The unicode * must be replaced by an ASCII *, for instance.
					if (!TranslatorUtils.isASCII_only(codeLine)) {
						codeLine = TranslatorUtils.removeUnicode(codeLine);
						processedCode.add(codeLine);
					} else {
						processedCode.add(codeLine);
					}
				}
				//
				code = processedCode;
			}

			// Find the current directory from the first selected item
			String directoryName = getFilePathFromSelected();
			if (directoryName != null) {
				// make the directory
				setupDirectory(directoryName);
			} else
				throw new IL1TranslationException(
						"Failed to find directory path in " + this);

			// make the interfaces
			InterfaceGenerator interfaceGenerator = InterfaceGenerator
					.getDefault();
			interfaceGenerator.makeInterfaces(program, targetDirectoryString,
					il1TranslationManager);
			saveToFile(code, il1TranslationManager.getClassHeaderInformation(),
					program, targetDirectoryString, il1TranslationManager);

			System.out.println("*************************");
			System.out.println("CODE:");
			System.out.println();

			if (code != null) {
				for (String str : code) {
					System.out.println(str);
				}
			}

			System.out.println("*************************");

			updateResources();

		} catch (TaskingTranslationException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: TaskingTranslationException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (RodinDBException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (IL1TranslationUnhandledTypeException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: IL1TranslationUnhandledTypeException",
					e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (BackingStoreException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: BackingStoreException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (CoreException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (IL1TranslationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dialog.setMessage("Translation Ended");
		dialog.open();
	}


	@Override
	protected List<String> formatCode(List<String> code,
		IL1TranslationManager translationManager) {
		List<String> formatted1 = formatCodeBraces(code);
		List<String> formatted2 = formatBadArrayAssignments(formatted1);
		return formatted2;
	}

	private List<String> formatBadArrayAssignments(List<String> code) {
		List<String> formattedCodeArray = new ArrayList<String>();
		
		for(String line: code){
			for(String arrayID : PrimeCppTranslatorUtils.getArrayIDs()){
				int index = line.indexOf(arrayID);
				if(index != -1){
					// We have a line of code with an arrayID.
					
					// We assume only one array assignment is being done;
					// so the arrayID search loop quits when an arrayID is found.
					
					// If we have an incorrect translation, the arrayID 
					// will NOT be followed by the opening bracket. 
					if(line.charAt(index+arrayID.length()) != '['){
						// It looks like this is an incorrect translation. 
						// Just check that it IS followed by an assignment.
						// If so, then delete the assignment
						if(line.charAt(index+arrayID.length() + 1) == '='){
							line = line.substring(index+arrayID.length() + 2).trim();
							break;
						}
					}
				}
			}
			formattedCodeArray.add(line);
		}
		return formattedCodeArray;
	}

	@Override
	protected void saveToFile(List<String> codeToSave,
			ArrayList<ClassHeaderInformation> headerInformation,
			Program program, String directoryName,
			IL1TranslationManager translationManager) {
		ArrayList<String> globalDecls = new ArrayList<String>();

		for (int lineNumber = 0; lineNumber < codeToSave.size(); lineNumber++) {
			String line = codeToSave.get(lineNumber);

			if (line.equals("// Protected")) {
				// Extract the protected code
				ArrayList<String> protectedCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndProtected", protectedCode);

				// Get the protected name
				// Assumes first line is // Protected:
				String name = getName(protectedCode, "// Protected:");

				IL1CodeFiler.getDefault().save(protectedCode, directoryName,
						name + ".cpp", translationManager);
				} else if (line.equals("// Task")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndTask", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// Task:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".cpp", translationManager);
			} else if (line.equals("// MainEntry")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndMainEntry", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// MainEntry:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".cpp", translationManager);
			} else if(line.equals("// COMLIB")){
				
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndCOMLIB", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// COMLIB:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						"comlib.cpp", translationManager);

			} else if(line.equals("// COMLIBH")){
				
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndCOMLIBH", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// COMLIBH:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						"comlib.hpp", translationManager);

			}			
			else if (line.equals("// EnvironTask")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndEnvironTask", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// EnvironTask:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".cpp", translationManager);
			} else if (line.equals("// GlobalDeclarations")) {
				ArrayList<String> globalDeclCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndGlobalDeclarations", globalDeclCode);
				globalDecls.addAll(globalDeclCode);
			} 
			else {
				// Do nothing with it
			}
		}
		// Now sort out header files
		// For common header
		ClassHeaderInformation common = new ClassHeaderInformation();
		common.setClassName(COMMON_HEADER_PARTIAL);

		// wont use initial now, will add headers manually, then add common
		// class for compiler specific code
		common.getHeaderEntries().addAll(
				translationManager.getIncludeStatements());

		// Add any global declarations
		common.getHeaderEntries().addAll(globalDecls);

		// Add the header files to include in the initial data
		for (ClassHeaderInformation c : headerInformation) {
			String headerName = c.getClassName() + ".hpp";
			common.getHeaderEntries().add("#include \"" + headerName + "\"");
		}

		headerInformation.add(common);

		if (translationManager.getCompilerDependentExecutableCodeBlock().size() > 0) {
			ArrayList<String> commonCode = new ArrayList<String>();
			// commonCode.add(codeGenerateTimestamp);
			commonCode.add("#include \"" + COMMON_HEADER_FULL + "\"");
			commonCode.addAll(formatCode(translationManager
					.getCompilerDependentExecutableCodeBlock(),
					translationManager));
			IL1CodeFiler.getDefault().save(commonCode, directoryName,
					"Common.cpp", translationManager);
		}

		// Save the header files
		for (ClassHeaderInformation c : headerInformation) {
			String headerName = c.getClassName();
			String headerPreBlock = c.getClassName().toUpperCase() + "_H";

			ArrayList<String> headerCode = new ArrayList<String>();
			// headerCode.add(codeGenerateTimestamp);
			headerCode.add("#ifndef " + headerPreBlock);
			headerCode.add("#define " + headerPreBlock);
			headerCode.add("#include \"Common.hpp\"");

			for (String i : c.getHeaderEntries()) {
				headerCode.add(i);
			}

			headerCode.add("#endif");
			headerCode.add(""); // blank line

			IL1CodeFiler.getDefault().save(formatCode(headerCode, translationManager), directoryName,
					headerName + ".hpp", translationManager);
		}
	}

	protected int getCodeBlock(List<String> codeIn, int startIdx,
			String endStatement, ArrayList<String> codeOut) {
		int endIdx = startIdx;
		for (int i = startIdx; i < codeIn.size()
				&& !codeIn.get(i).equals(endStatement); i++, endIdx++) {
			codeOut.add(codeIn.get(i));
		}

		return endIdx;
	}

	protected String getName(ArrayList<String> codeIn, String lhs) {
		// Find first occurence of the lhs string
		// As the first lines may be include / import statements
		for (String s : codeIn) {
			if (s.startsWith(lhs)) {
				return s.split(lhs)[1].trim();
			}
		}

		return ""; // something went wrong
	}
}
