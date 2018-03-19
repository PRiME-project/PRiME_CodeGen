package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.impl.TaskImpl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;

public class AdaProgramIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Program actualSource = (Program) source;

		EList<EnvironTask> envMchs = actualSource.getEnvironMachines();
		List<String> envMchNames = translationManager.getEnvironMachineNames();
		for(EnvironTask environTask: envMchs){
			envMchNames.add(environTask.getName());
		}
		
		String globalsPackageName = null;
		
		// check to see if there are any enums or constants
		EList<Declaration> declList = actualSource.getDecls();
		boolean hasGlobals = false;
		for (Declaration d : declList) {
			if (d instanceof Enumeration || d instanceof ConstantDecl) {
				// if there are, then import the file
				hasGlobals = true;
				globalsPackageName = actualSource.getProjectName() + "_Globals";
				translationManager.setGlobalSpecName(globalsPackageName);
				break;
			}
		}

		// identify all the enumerations, since they are types, rather than
		// being typed.
		ArrayList<String> enumTypeNameList = translationManager
				.getEnumTypeNameList();
		TreeIterator<EObject> iter = source.eAllContents();
		while (iter.hasNext()) {
			EObject e = iter.next();
			if (e instanceof Enumeration) {
				Enumeration en = (Enumeration) e;
				String id = en.getIdentifier();
				if (!enumTypeNameList.contains(id)) {
					enumTypeNameList.add(id);
				}
			}
		}
		
		String mainName = actualSource.getProjectName() + "_Main";

		outCode.add("procedure " + mainName + " is ");

		for (Protected prot : actualSource.getProtected()) {
			// shared object Decl
			outCode.add(prot.getName() + "Inst: " + prot.getName() + ";");
			translationManager.getProtectedObjectList().add(prot);
		}

		for (EnvironTask task : actualSource.getEnvironMachines()) {
			ArrayList<String> envCode = translationManager
					.translateIL1ElementToCode(task, targetLanguage);
			translationManager.getEnvironTaskList().add(task);
			outCode.addAll(envCode);
		}

		if (actualSource.getEntryPoint() != null) {
			for (Task task : actualSource.getEntryPoint().getAutoTasks()) {
				ArrayList<String> taskCode = translationManager
						.translateIL1ElementToCode(task, targetLanguage);
				if (task instanceof TaskImpl) {
					translationManager.getAutoTaskList().add(task);
				}

				if (taskCode != null) {
					outCode.addAll(taskCode);
				}
			}
		} else {
			TranslatorUtils
					.log("No AutoTask or EnvironMachine defined in this translation",
							Status.ERROR, actualSource);
		}

		outCode.add("begin ");
		outCode.add("null; ");
		outCode.add("end " + mainName + ";");
		outCode.add("-- End of Package"); // The end of package marker
		outCode.add("");

		for (Protected prot : actualSource.getProtected()) {
			ArrayList<String> protectedCode = translationManager
					.translateIL1ElementToCode(prot, targetLanguage);
			translationManager.getProtectedObjectList().add(prot);
			if (protectedCode != null) {
				outCode.addAll(protectedCode);
			}
		}

		// after all computation is done - and we've collected all of the
		// constants and enums, we need to add them to their own package.
		if (hasGlobals) {
			outCode.add("package " + globalsPackageName + " is ");
			for (Declaration decl : declList) {
				if (decl instanceof Enumeration) {
					Enumeration en = (Enumeration) decl;
					boolean first = true;
					EList<String> literalList = en.getLiteralValues();
					String literalStrings = "";
					String literalArray = "";
					int idx = 0;
					for (String l : literalList) {
						if (!first) {
							literalStrings = literalStrings + ", " + l;
							literalArray = literalArray + ", " + l + "=>" + idx;
						} else {
							literalStrings = l;
							literalArray = l + " => " + idx;
							first = false;
						}
						idx++;
					}
					outCode.add("type " + decl.getIdentifier() + " is ("
							+ literalStrings + ");");
					outCode.add("for " + decl.getIdentifier() + " use ");
					outCode.add("(" + literalArray + ");");
				} else {
					TranslatedDecl translatedDecl = translationManager.translateDeclaration(decl, targetLanguage);
					String typeStr = translatedDecl.getType();
					 
					String s = decl.getIdentifier() + " : constant "
							+ typeStr + " := " + decl.getInitialValue()
							+ ";";
					outCode.add(s);
				}
			}

			outCode.add("end " + actualSource.getProjectName() + "_Globals;");
			outCode.add("-- End of Package"); // The end of package marker
		}
		return outCode;
	}
}
