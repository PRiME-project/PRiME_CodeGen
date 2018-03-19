package org.eventb.codegen.il1.translator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;
import org.eventb.codegen.il1.translator.utils.IL1CodeFiler;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationManager;

public class InterfaceGenerator {

	private static InterfaceGenerator interfaceGenerator = new InterfaceGenerator();
	public static boolean requiresInterface;
	private IL1TranslationManager il1TranslationManager = null;
	TargetLanguage targetLanguage = null;

	private List<String> implementsList = new ArrayList<String>();

	public List<String> getImplementsList() {
		return implementsList;
	}

	// return the default object.
	public static InterfaceGenerator getDefault() {
		return interfaceGenerator;
	}

	// the Interface Generator's main point of entry.
	public void makeInterfaces(Program program, String targetDirectory,
			IL1TranslationManager il1TranslationManager_) {
		IPreferenceStore prefererenceStore = CodeGenTasking.getDefault()
				.getPreferenceStore();
		// check to see if interfaces are required
		requiresInterface = prefererenceStore
				.getBoolean(TaskingTranslationManager.getPrefJavaInterface());
		List<String> outCode = new ArrayList<String>();

		// If the preference option says create interfaces for protected and
		// environ machines
		if (requiresInterface) {
			// set up some fields before we move on.
			il1TranslationManager = il1TranslationManager_;
			targetLanguage = il1TranslationManager.getCurrentTranslationTarget();
			// then move on to the translation
			EList<EnvironTask> environList = program.getEnvironMachines();
			for (EnvironTask environTask : environList) {
				implementsList.add(environTask.getName());
				String className = environTask.getName();
				String interfaceName = "I" + className;
				EList<Subroutine> subroutineList = environTask.getSubroutines();
				makeInterface(outCode, className, interfaceName, subroutineList);
				save(outCode, targetDirectory, interfaceName + ".java");
				outCode.clear();
			}
			// At the time of writing I don't think we need interfaces for
			// protected objects
			// But here's the code in case we find out that it's useful.
			// EList<Protected> protectedList = program.getProtected();
			// for(Protected prot: protectedList){
			// implementsList.add(prot.getName());
			// String interfaceName = "I" + prot.getName();
			// EList<Subroutine> subroutineList = prot.getSubroutines();
			// makeInterface(outCode, interfaceName, subroutineList);
			// save(outCode, targetDirectory, interfaceName+".java");
			// outCode.clear();
			// }
		}
	}

	private void makeInterface(List<String> outCode, String className,
			String interfaceName, EList<Subroutine> subroutineList) {
		outCode.add(AbstractProgramIL1Translator.GENERATED_PACKAGE);
		outCode.add("public interface " + interfaceName + "{");
		for (Subroutine subroutine : subroutineList) {
			EList<Parameter> paramList = subroutine.getFormalParameters();
			boolean first = true;
			String signature = "public void " + subroutine.getName() + "(";
			for (Parameter param : paramList) {
				String paramDeclString = "";
				String paramName = param.getIdentifier();
				String paramType = il1TranslationManager.resolveType(
						param.getType(), param.getIdentifier(),
						param.getProjectName(), className, targetLanguage);

				if (param instanceof OutParameter) {
					// OutGoing parameters are represented as pointers, so
					// we can return more than one value.
					if (paramType.equals("int")) {
						paramType = "Integer";
					} else if (paramType.equals("boolean")) {
						paramType = "Boolean";
					}
					paramDeclString = "Pointer<" + paramType + "> "
							+ paramName;
				}
				// else we have an ingoing parameter wich is just its type
				// declaration - not a pointer conversion.
				else{
					paramDeclString = paramType + " " + paramName;
				}
				if (first) {
					signature = signature + paramDeclString;
					first = false;
				} else {
					signature = signature + ", " + paramDeclString;
				}
			}
			signature = signature + ");";
			outCode.add(signature);
		}
		outCode.add("}");
	}

	private void save(List<String> outCode, String directoryName,
			String interfaceName) {
		IL1CodeFiler.getDefault().save(outCode, directoryName, interfaceName, il1TranslationManager);
	}

}
