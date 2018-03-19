package org.eventb.codegen.il1.translator;

import java.util.ArrayList;
import java.util.List;

import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.utils.IL1CodeFiler;

public class TranslateFromEventBToCpp extends AbstractTranslateEventBToTarget {

	@Override
	protected TargetLanguage getTargetLanguage() {
		return new TargetLanguage("C","CppOpenMP");
	}

	@Override
	protected List<String> formatCode(List<String> code, IL1TranslationManager translationManager) {
		return formatCodeBraces(code);
	}

	@Override
	protected void saveToFile(List<String> codeToSave,
			ArrayList<ClassHeaderInformation> headerInformation,
			Program program, String directoryName,
			IL1TranslationManager translationManager) {

		String codeGenerateTimestamp = codeToSave.get(0);

		//		Need to output initial code (definitions and includes) before everything else
		//	This initial code block will go in a standard header
		ArrayList<String> initial = new ArrayList<String>();
		int idx = 0;
		for ( ; idx < codeToSave.size(); idx++)
		{
			String s = codeToSave.get(idx);

			//	Find first protected or task
			if (s.startsWith("// Protected:") || s.startsWith("// Task:"))
			{
				break;
			}
			else
			{
				initial.add(s);
			}
		}
		
		//	Now for each remaining task
		for ( ; idx < codeToSave.size(); idx++)
		{
			String s = codeToSave.get(idx);

			if (s.startsWith("// Protected:"))
			{
				String name = s.substring("// Protected: ".length());

				ArrayList<String> codeBlock = new ArrayList<String>();
				codeBlock.add(codeGenerateTimestamp);
				codeBlock.add("#include \"CommonHeader.h\"");
				codeBlock.add(s);
				idx++;

				for ( ; idx < codeToSave.size(); idx++)
				{
					String t = codeToSave.get(idx);

					//	Find first protected or task
					if (t.startsWith("// Protected:") || t.startsWith("// Task:"))
					{
						idx--;
						break;
					}
					else
					{
						codeBlock.add(t);
					}
				}

				IL1CodeFiler.getDefault().save(codeBlock, directoryName, name + ".cpp", translationManager);
			}
			else if (s.startsWith("// Task: "))
			{
				String name = s.substring("// Task: ".length());

				ArrayList<String> codeBlock = new ArrayList<String>();
				codeBlock.add(codeGenerateTimestamp);
				codeBlock.add("#include \"CommonHeader.h\"");
				codeBlock.add(s);
				idx++;

				for ( ; idx < codeToSave.size(); idx++)
				{
					String t = codeToSave.get(idx);

					//	Find first protected or task
					if (t.startsWith("// Protected:") || t.startsWith("// Task:"))
					{
						idx--;
						break;
					}
					else
					{
						codeBlock.add(t);
					}
				}

				IL1CodeFiler.getDefault().save(codeBlock, directoryName, name + ".cpp", translationManager);
			}
			
			//	For common header
			ClassHeaderInformation common = new ClassHeaderInformation();
			common.setClassName("CommonHeader");
		
			//	wont use initial now, will add headers manually, then add common class for compiler specific code
			common.getHeaderEntries().addAll(translationManager.getIncludeStatements());

			//	Add the header files to include in the initial data
			for (ClassHeaderInformation c : headerInformation)
			{
				String headerName = c.getClassName() + ".h";
				common.getHeaderEntries().add("#include \"" + headerName + "\"");
			}

			headerInformation.add(common);

			if (translationManager.getCompilerDependentExecutableCodeBlock().size() > 0)
			{
				ArrayList<String> commonCode = new ArrayList<String>();
				commonCode.add(codeGenerateTimestamp);
				commonCode.add("#include \"CommonHeader.h\"");
				commonCode.addAll(formatCode(translationManager.getCompilerDependentExecutableCodeBlock(), translationManager));
				IL1CodeFiler.getDefault().save(commonCode, directoryName, "CommonSource.cpp", translationManager);				
			}


			//	Save the header files
			for (ClassHeaderInformation c : headerInformation)
			{
				String headerName = c.getClassName();
				String headerPreBlock = c.getClassName().toUpperCase() + "_H";

				ArrayList<String> headerCode = new ArrayList<String>();
				headerCode.add(codeGenerateTimestamp);
				headerCode.add("#ifndef " + headerPreBlock);
				headerCode.add("#define " + headerPreBlock);

				for (String i : c.getHeaderEntries())
				{
					headerCode.add(i);
				}

				headerCode.add("#endif");
				headerCode.add("");		//	blank line

				IL1CodeFiler.getDefault().save(headerCode, directoryName, headerName + ".h", translationManager);				
			}
		}
	}
}
