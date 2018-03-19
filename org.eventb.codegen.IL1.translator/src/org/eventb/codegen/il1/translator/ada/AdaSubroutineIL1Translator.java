package org.eventb.codegen.il1.translator.ada;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaSubroutineIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Subroutine actualSource = (Subroutine) source;

		EObject parent = source.eContainer();
		String subprogramType = "unspecified";
		if(parent instanceof EnvironTask){
			subprogramType = "entry";
		}
		else if(parent instanceof Protected){
			if(actualSource.getGuards() != null && actualSource.getGuards().size() > 0){
				subprogramType = "entry";
			}
			else{
				subprogramType = "procedure";
			}
		}
		else if(parent instanceof Task){
			// This case should just be for state-machine subroutines 
			if(actualSource.getGuards() != null && actualSource.getGuards().size() > 0){
				subprogramType = "entry";
			}
			else{
				subprogramType = "procedure";
			}
		}
		
		if (!actualSource.getName().startsWith("INITIALISATION")) {
			String declaration = subprogramType +" "+ actualSource.getName();

			ArrayList<LocalVariable> localVariables = new ArrayList<LocalVariable>();
			boolean first = true;
			for (Parameter p : actualSource.getFormalParameters()) {
				if (p instanceof LocalVariable) {
					localVariables.add((LocalVariable) p);
				} else {
					String pType = translationManager.resolveType(p.getType(), p.getIdentifier(), actualSource.getProjectName(), actualSource.getMachineName(),
							targetLanguage);

					if (!first) {
						declaration = declaration + "; ";
					} else {
						declaration = declaration + "(";
					}

					declaration = declaration + p.getIdentifier() + ": ";

					if (p instanceof OutParameter) {
						declaration = declaration + " out ";
					} else if (p instanceof InParameter) {
						declaration = declaration + " in ";
					}

					declaration = declaration + pType;

					first = false;
				}
			}

			if (!first) {
				declaration = declaration + ")";
			}

			if (!(actualSource.getGuards().size() > 0)) {
				declaration = declaration + " is ";
			}

			outCode.add(declaration);
			// Guards
			if (actualSource.getGuards().size() > 0) {
				String guardCode = " when (";

				for (int i = 0; i < actualSource.getGuards().size(); i++) {
						String gLine = translationManager
								.translatePredicateExpression(
										actualSource.getGuards().get(i),
										actualSource, targetLanguage);
						guardCode = guardCode + gLine;

						if (i + 1 < actualSource.getGuards().size()
								&& !gLine.trim().equals("")) {
							guardCode = guardCode + " and ";
						}
				}

				guardCode = guardCode + ")";
				guardCode = guardCode + " is";
				outCode.add(guardCode);
			}

			if (localVariables.size() > 0) {
				// Local variables
				for (LocalVariable l : localVariables) {
					ArrayList<String> lvCode = translationManager
							.translateIL1ElementToCode(l, targetLanguage);
					if (lvCode != null)
						outCode.addAll(lvCode);
				}
			}
			outCode.add("begin ");
			// Body code
			ArrayList<String> bodyCode = translationManager
					.translateIL1ElementToCode(actualSource.getBody(),
							targetLanguage);
			if (bodyCode != null) {
				if(bodyCode.size() > 0){
				outCode.addAll(bodyCode);
				} else{
					outCode.add("null;");
				}
			}
			outCode.add("end " + actualSource.getName() + ";");
		}
		return outCode;
	}

}
