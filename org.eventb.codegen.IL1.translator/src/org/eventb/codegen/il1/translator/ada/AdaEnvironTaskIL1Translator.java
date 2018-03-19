package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.il1.SimpleTaskType;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.TaskTypeEnum;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaEnvironTaskIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Task actualSource = (Task) source;

		// Declarations must be translated first (regardless of where code is
		// put), to allow theory to work
		ArrayList<String> declCode = new ArrayList<String>();
		for (Declaration decl : actualSource.getDecls()) {
			ArrayList<String> declStr = translationManager
					.translateIL1ElementToCode(decl, targetLanguage);
			declCode.addAll(declStr);
		}

		// >>> Beginning of Task Spec'n
		outCode.add("task " + actualSource.getName() + " is ");
		outCode.add("pragma priority(" + actualSource.getPriority() + ");");

		EList<Subroutine> subroutineList = actualSource.getSubroutines();
		for (Subroutine subroutine : subroutineList) {
			ArrayList<String> subStr = translationManager
					.translateIL1ElementToCode(subroutine, targetLanguage);

			if (subStr != null) {
				String replacement = subStr.get(0).replaceAll(" is ", "")
						.trim();
				outCode.add(replacement + ";");
			}
		}
		outCode.add("end " + actualSource.getName() + ";");

		// >>> Beginning of Task Body Elaboration
		outCode.add("task body " + actualSource.getName() + " is ");

		// Add the previously translated declarations
		outCode.addAll(declCode);

		boolean periodic = false;
		boolean loop = false;
		TaskType taskType = actualSource.getTaskType();
		if (taskType instanceof PeriodicTaskType) {
			String parentName = Utils.getParentName(actualSource);
			Map<String, ArrayList<String>> iMap = translationManager
					.getImportMap();
			if (iMap.containsKey(parentName)) {
				ArrayList<String> importList = iMap.get(parentName);
				importList.add("Ada.Real_Time");
			} else {
				ArrayList<String> newImportList = new ArrayList<String>();
				newImportList.add("Ada.Real_Time");
				iMap.put(parentName, newImportList);
			}
			double period = ((PeriodicTaskType) taskType).getPeriod() / 1000.0;
			periodic = true;
			loop = true;
			outCode.add("period: constant Time_Span := To_Time_Span(" + period
					+ ");");
			outCode.add("nextTime: Time := clock + period;");
		} else if (taskType instanceof SimpleTaskType) {
			TaskTypeEnum tskType = ((SimpleTaskType) taskType).getType();
			if (tskType.getValue() == TaskTypeEnum.REPEATING_VALUE) {
				loop = true;
			}
		}

		outCode.add("begin ");

		if (loop) {
			outCode.add("loop ");
		}
		if (periodic) {
			outCode.add("delay until nextTime;");
		}
		if (actualSource.getBody() != null) {
			ArrayList<String> bodyStr = translationManager
					.translateIL1ElementToCode(actualSource.getBody(),
							targetLanguage);
			outCode.addAll(bodyStr);
		}else{
			outCode.add("null;");
		}

		// Handle accepting entry statements here
		boolean first = true;
		for (Subroutine subroutine : subroutineList) {
			if (first) {
				outCode.add("select ");
				first = false;
			} else {
				outCode.add("or ");
			}
			ArrayList<String> subStr = translationManager
					.translateIL1ElementToCode(subroutine, targetLanguage);

			// We need to modify the 'given' subroutine for use as an Ada accept
			// statement.
			// This involves replacing entry by accept, is by do, and adding an
			// extra end; clause
			// before the closing end clause;
			if (subStr != null) {
				String replacement = subStr.get(0).replace("entry ", "accept ");
				replacement = replacement.replace(" is ", " do ");
				subStr.add(1, replacement);
				subStr.remove(0);
				subStr.add(subStr.size() - 1, "end; ");
			}
			outCode.addAll(subStr);
		}
		if (subroutineList.size() > 0) {
			outCode.add("else ");
			outCode.add("null;");
			outCode.add("end select;"); // end of select statements
		}

		if (periodic) {
			outCode.add("nextTime := nextTime + period;");
		}
		if (loop) {
			outCode.add("end loop; ");
		}

		outCode.add("end " + actualSource.getName() + ";");

		return outCode;
	}

}
