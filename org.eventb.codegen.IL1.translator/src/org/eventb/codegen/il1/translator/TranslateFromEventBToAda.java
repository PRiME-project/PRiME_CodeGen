package org.eventb.codegen.il1.translator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.utils.IL1CodeFiler;

public class TranslateFromEventBToAda extends AbstractTranslateEventBToTarget {

	public static boolean requiresAdaGPSProject = true;

	@Override
	protected TargetLanguage getTargetLanguage() {
		return new TargetLanguage("Ada");
	}

	@Override
	protected ArrayList<String> formatCode(List<String> code,
			IL1TranslationManager translationManager) {
		ArrayList<String> fcode = new ArrayList<String>();
		StringBuffer with = new StringBuffer("with ");
		StringBuffer use = new StringBuffer("use ");

		Map<String, ArrayList<String>> iMap = translationManager.getImportMap();

		boolean first = true;
		String globalSpecName = translationManager.getGlobalSpecName();
		if (globalSpecName != null) {
			with = with.append(globalSpecName);
			use = use.append(globalSpecName);
			first = false;
		}

		if (iMap != null) {
			// Get the auto task imports
			ArrayList<Task> taskList = translationManager.getAutoTaskList();
			taskList.addAll(translationManager.getEnvironTaskList());
			for (Task task : taskList) {
				ArrayList<String> imprt = iMap.get(task.getName());
				if (imprt != null) {
					for (String s : imprt) {
						if (!with.toString().contains(s)) {
							if (first) {
								with = with.append(s);
								use = use.append(s);
								first = false;
							} else {
								with = with.append(", " + s);
								use = use.append(", " + s);
							}
						}
					}
				}
			}
			for (Protected prot : translationManager.getProtectedObjectList()) {
				if (first) {
					with.append(prot.getName() + "Pkg");
					use.append(prot.getName() + "Pkg");
					first = false;
				} else {
					with.append(", " + prot.getName() + "Pkg");
					use.append(", " + prot.getName() + "Pkg");
				}

			}
			with.append(";");
			use.append(";");
			// add imports if any exist
		}

		// add the with'ed statements to the fcode output
		if (with.length() > 6) {
			fcode.add(with.toString());
			fcode.add(use.toString());
		}
		// End of formatting imports

		// format the remaining code
		int nTabs = 0;
		for (String line : code) {

			if (line.startsWith("type ")) {
				fcode.add(addTabs(nTabs) + line);
			} else if (line.startsWith("end ")) {
				nTabs--;
				fcode.add(addTabs(nTabs) + line);
			} else if (line.contains(" is ") || line.startsWith("if ")
					|| line.startsWith("loop ") || line.startsWith("while ")
					|| line.startsWith("accept") || line.startsWith("select ")) {
				fcode.add(addTabs(nTabs) + line);
				nTabs++;
			} else if (line.contains("end; ") || line.contains("begin ")
					|| line.startsWith("elsif") || line.startsWith("else ")
					|| line.startsWith("private")) {
				nTabs--;
				fcode.add(addTabs(nTabs) + line);
				nTabs++;
			} else {
				fcode.add(addTabs(nTabs) + line);
			}

			// print the boolean IO statement if an auto task uses it.
			// "package Bool_IO is new Enumeration_IO(Boolean);"
			// "use Bool_IO;"
			if (line.contains("task body ")) {
				StringBuffer str = new StringBuffer(line.trim());
				int endIdx = str.indexOf(" ", 10);
				String taskName = str.substring(10, endIdx);

				Map<String, ArrayList<String>> boolIOMap = translationManager
						.getBooleanIOMap();

				ArrayList<String> boolPkgDecl = boolIOMap.get(taskName);
				if (boolPkgDecl != null) {
					for (String s : boolPkgDecl) {
						fcode.add(addTabs(nTabs) + s);
					}
				}
			}
		}
		// if the last line is an empty string then delete it
//		int len = fcode.size()-1;
		return fcode;
	}

	@Override
	protected void saveToFile(List<String> codeToSave,
			ArrayList<ClassHeaderInformation> headerInformation,
			Program program, String directoryName,
			IL1TranslationManager translationManager) {

		// Need to output initial code (definitions and includes) before
		// everything else
		ArrayList<String> codeBlock = new ArrayList<String>();
		String mainName = program.getProjectName() + "_Main";
		String packageType = mainName;
		String packageName = mainName;

		// Now we can save the GPS gpr file if the boolean is true.
		// This needs to be linked to the preferences.
		if (requiresAdaGPSProject) {
			ArrayList<String> prjCode = new ArrayList<String>();
			prjCode.add("project " + mainName + " is");
			prjCode.add("  for Main use (\"" + mainName + ".adb\");");
			prjCode.add("end " + mainName + ";");

			IL1CodeFiler.getDefault().save(prjCode, directoryName, mainName + ".gpr", translationManager);
		}

		Iterator<String> outputIter = codeToSave.iterator();
		boolean foundPrimaryPackageName = false;
		while (outputIter.hasNext()) {
			String s = outputIter.next();
			if (!foundPrimaryPackageName) {
				if (s.toLowerCase().trim().startsWith("package ") 
						&& !s.toLowerCase().trim().contains("bool_io")) {
					foundPrimaryPackageName = true;
					String tmp = s.toLowerCase().trim().replace("package", "")
							.trim();
					if (tmp.startsWith("body")) {
						// we have a package body .adb file to save next time
						packageType = "body";
						// obtain the file name
						tmp = tmp.replace("body", "").trim();
						int end = tmp.indexOf(" ");
						tmp = tmp.substring(0, end);
						packageName = tmp;
					} else {
						// else we have a package spec .ads file to save next
						// time
						packageType = "spec";
						// obtain the file name
						int end = tmp.indexOf(" ");
						tmp = tmp.substring(0, end);
						packageName = tmp;
					}
				}
			}

			boolean stop = s.trim().contentEquals("-- End of Package");
			if (!stop) {
				// if we have reached the last line then save the file after
				// adding the last line, else continue
//				if (!outputIter.hasNext()) {
//					if (packageType.equals(mainName)
//							|| packageType.equalsIgnoreCase("body")) {
//						packageType = ".adb";
//					} else if (packageType.equalsIgnoreCase("spec")) {
//						packageType = ".ads";
//					}
//					codeBlock.add(s);
//					this.saveToFileHelper(codeBlock, packageName + packageType,
//							directoryName);
//				} else {
//					codeBlock.add(s);
//				}
				codeBlock.add(s);
			} else {
				// first time through we have, program.getName()+ "_Main", which
				// is an adb
				if (packageType.equals(mainName)
						|| packageType.equalsIgnoreCase("body")) {
					packageType = ".adb";
				} else if (packageType.equalsIgnoreCase("spec")) {
					packageType = ".ads";
				}
				// save the file
				IL1CodeFiler.getDefault().save(codeBlock, directoryName,
						packageName + packageType, translationManager);
				codeBlock.clear();
				foundPrimaryPackageName = false;
				// we ignore the line with -- End of Package
				// codeBlock.add(s);
			}
		}
	}
}
