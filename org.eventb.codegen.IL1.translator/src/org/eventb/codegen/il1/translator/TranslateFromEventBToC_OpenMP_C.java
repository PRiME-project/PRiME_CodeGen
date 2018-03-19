package org.eventb.codegen.il1.translator;

import java.util.ArrayList;
import java.util.List;

import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.c.CTranslatorUtils;
import org.eventb.codegen.il1.translator.utils.IL1CodeFiler;

public class TranslateFromEventBToC_OpenMP_C extends
		AbstractTranslateEventBToTarget {

	public static String COMMON_HEADER_PARTIAL = "Common";
	public static String COMMON_HEADER_FULL = COMMON_HEADER_PARTIAL + ".hpp";

	@Override
	protected TargetLanguage getTargetLanguage() {
		return new TargetLanguage("C", "OpenMP");
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
			for(String arrayID : CTranslatorUtils.getArrayIDs()){
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
						name + ".c", translationManager);
			} else if (line.equals("// Task")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndTask", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// Task:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".c", translationManager);
			} else if (line.equals("// MainEntry")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndMainEntry", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// MainEntry:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".c", translationManager);
			} else if (line.equals("// EnvironTask")) {
				// Extract the protected code
				ArrayList<String> taskCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndEnvironTask", taskCode);

				// Get the protected name
				// Assumes first line is // Task:
				String name = getName(taskCode, "// EnvironTask:");

				IL1CodeFiler.getDefault().save(taskCode, directoryName,
						name + ".c", translationManager);
			} else if (line.equals("// GlobalDeclarations")) {
				ArrayList<String> globalDeclCode = new ArrayList<String>();
				lineNumber = getCodeBlock(codeToSave, lineNumber + 1,
						"// EndGlobalDeclarations", globalDeclCode);
				globalDecls.addAll(globalDeclCode);
			} else {
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
			String headerName = c.getClassName() + ".h";
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
					"Common.c", translationManager);
		}

		// Save the header files
		for (ClassHeaderInformation c : headerInformation) {
			String headerName = c.getClassName();
			String headerPreBlock = c.getClassName().toUpperCase() + "_H";

			ArrayList<String> headerCode = new ArrayList<String>();
			// headerCode.add(codeGenerateTimestamp);
			headerCode.add("#ifndef " + headerPreBlock);
			headerCode.add("#define " + headerPreBlock);

			for (String i : c.getHeaderEntries()) {
				headerCode.add(i);
			}

			headerCode.add("#endif");
			headerCode.add(""); // blank line

			IL1CodeFiler.getDefault().save(headerCode, directoryName,
					headerName + ".h", translationManager);
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
