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

public class AdaAutoTaskIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Task actualSource = (Task) source;

		// >>> Beginning of Task Spec'n
		outCode.add("task " + actualSource.getName() + " is ");
		outCode.add("pragma priority(" + actualSource.getPriority() + ");");
		outCode.add("end " + actualSource.getName() + ";");

		// >>> Beginning of Task Body Elaboration
		outCode.add("task body " + actualSource.getName() + " is ");
		for (Declaration decl : actualSource.getDecls()) {
			ArrayList<String> declStr = translationManager
					.translateIL1ElementToCode(decl, targetLanguage);
			outCode.addAll(declStr);
		}

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

		EList<Subroutine> subroutines = actualSource.getSubroutines();
		for (Subroutine subroutine : subroutines) {
			ArrayList<String> subroutineCode = translationManager
					.translateIL1ElementToCode(subroutine, targetLanguage);
			outCode.addAll(subroutineCode);
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
