package org.eventb.codegen.il1.translator.c;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractCallIL1Translator;

public class CCallTranslator extends AbstractCallIL1Translator {

	@Override
	protected ArrayList<String> generateFunctionCall(String functionName,
			EList<Parameter> parameters, String remoteMachineName,
			String localMachineName, Call actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {			
		
		//	Should be MachineName_FunctionName - although original C translator did not do this.
		String functionCall = remoteMachineName + "_" + functionName + "(";
		
		boolean first = true;
		for (Parameter p : parameters)
		{
			String paramName = p.getIdentifier();
			if (p instanceof InParameter)
			{
				//	Needs to be a pointer sent
				paramName = "&" + paramName;
			}
			
			//	Update paramName to include the machine name too
			paramName = paramName + "_" + localMachineName;	//	full variable (becomes parameter) name
			
			if (first)
			{
				functionCall += paramName;
				first=false;
			}
			else
			{
				functionCall += ", " + paramName;
			}
		}
		
		functionCall += ");";

		//	Build the output string
		ArrayList<String> output = new ArrayList<String>();
				
		//	Then the function call
		output.add(functionCall);
						
		return output;
	}

}
