package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;
import java.util.List;

import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.core.AbstractVariableIL1Translator;

public class CVariableTranslator extends AbstractVariableIL1Translator {

	@Override
	protected String generateVariableDeclaration(String type,
			String identifier, String initialisation, String machineName,
			boolean isProtected) {

		String id = identifier + "_" + machineName;
		if (initialisation != null && !initialisation.equals("")) {
			// if we have some kind of array we need to re-write the type
			// expression.
			if (type.contains("[")) {
				String oldType = type;
				int openingIndex = oldType.indexOf("[");
				int closingIndex = oldType.lastIndexOf("]");
				type = oldType.substring(0, openingIndex);
				String arraySizePart = oldType.substring(openingIndex,
						closingIndex + 1);
				// Add the ID to a list of Identifiers to be used for post
				// processing.
				// In the case of array IDs, incompatibilities between Event-B, C
				// and the theory's
				// pattern matching approach means the array ID must be removed
				// from array assignments.
				CTranslatorUtils.getArrayIDs().add(id);
				// initialise the array in the init function of the task 
				// not in the declaration.
				// We need to record the dimensions of the array to do this.
				// split on the closing bracket and remove the opening one
				String[] splitArray = arraySizePart.split("\\]");
				List<String> arrayDimList = new ArrayList<String>();
				for(int i = 0; i < splitArray.length; i++){
					String dimensionElement = splitArray[i];
					dimensionElement = dimensionElement.replace("[", "");
					arrayDimList.add(dimensionElement);
				}
				// add it to the map: stored for later use
				CTranslatorUtils.getArrayDimensions().put(identifier, arrayDimList);
				CTranslatorUtils.getArrayInitValue().put(identifier, initialisation);
				
				return type + " " + id + arraySizePart + ";";
			}
			return type + " " + id + " = " + initialisation + ";";
		} else {
			return type + " " + id + ";";
		}
	}

	@Override
	protected ArrayList<String> handleFullyTranslatedDecl(
			FullyTranslatedDecl decl, VariableDecl actualSource,
			String machineName, IL1TranslationManager translationManager) {
		ArrayList<String> outCode = new ArrayList<String>();
		// Update any variable decls in each line of the initialiser
		for (String s : decl.getFullInitialisationExpression()) {
			// Tokenize gLine to find the variables
			s = translationManager.tokenizeVariablesOperators(s);
			// Append machine name to the variables
			// s = CActionIL1Translator.updateVariableName(s, actualSource,
			// translationManager);
			CTranslatorUtils utils = new CTranslatorUtils();
			s = utils.updateVariableName(s, actualSource, translationManager);

			if (decl.getType() != null) {
				s = decl.getType() + " " + s;
			}
			outCode.add(s + ";");
		}
		return outCode;
	}

}
