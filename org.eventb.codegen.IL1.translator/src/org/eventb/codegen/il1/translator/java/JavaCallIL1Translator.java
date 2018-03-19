package org.eventb.codegen.il1.translator.java;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractCallIL1Translator;

public class JavaCallIL1Translator extends AbstractCallIL1Translator {

	@Override
	protected ArrayList<String> generateFunctionCall(String functionName,
			EList<Parameter> parameters, String remoteMachineName, String localMachineName, Call actualSource, IL1TranslationManager translationManager, TargetLanguage targetLanguage) {
		
		ArrayList<String> outParameterNames = new ArrayList<String>();
		ArrayList<String> outParameterDefn = new ArrayList<String>();	//	code for out parameter definitions
		
		//	Have to update function call for remote objects, so that it gets the actual object and is not making a static call
		String functionCall;
		functionCall = "((" + remoteMachineName + ")MainEntry.getTask(\"" + remoteMachineName + "\"))." + functionName + "(";
		
		boolean first = true;
		for (Parameter p : parameters)
		{
			String paramName = p.getIdentifier();
			if (p instanceof InParameter)
			{
				paramName = p.getIdentifier() + "Pointer";
				String pType = translationManager.resolveType(p.getType(), p.getIdentifier(), p.getProjectName(), p.getComponentName(), targetLanguage);
				//pType gets modified to be an int - whereas it should really be an Integer class, 
				// and this goes for Booleans as well. We must change int to Integer and boolean to Boolean
				if(pType.equals("int")){pType = "Integer";}
				else if(pType.equals("boolean")){pType = "Boolean";}
				outParameterDefn.add("Pointer<" + pType + "> " + paramName + " = new Pointer<" + pType + ">();");
				outParameterNames.add(p.getIdentifier());
			}
			
			if (first)
			{
				functionCall += paramName;
				first = false;
			}
			else
			{
				functionCall += ", " + paramName;
			}
		}
		
		functionCall += ");";

		//	Build the output string
		ArrayList<String> output = new ArrayList<String>();
		
		//	First any OutParameters that have been converted to Pointers
		output.addAll(outParameterDefn);
		
		//	Then the function call
		output.add(functionCall);
		
		//	Then getting any out parameters back
		for (String p : outParameterNames)
		{
			output.add(p + " = " + p + "Pointer.value;");
		}
		
		return output;
	}


}
