package org.eventb.codegen.il1.translator.ada;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.INT_SYMBOL;

import java.util.ArrayList;
import java.util.Map;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.translator.AbstractIL1Translator;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;

public class AdaOutputIL1Translator extends AbstractIL1Translator {

	@Override
	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager, TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {

		ArrayList<String> outCode = new ArrayList<String>();
		Output actualSource = (Output)source;
		
		String varName = actualSource.getElement(); // The name of the element whose value we wish to output
		//retrieve the variableDecl so we know what to print
		String parentName = Utils.getParentName(actualSource);
		VariableDecl varDecl = translationManager.getType(parentName, varName);

		String type = varDecl.getType();
		
		if(type == null){
			System.err.println("Error: Encountered a Variable without type: \n\t " + actualSource);
		}
		else
		// if the type is an integer
		if (type.contains(INT_SYMBOL)){
			Map<String, ArrayList<String>> importMap = translationManager.getImportMap();
			if(!importMap.containsKey(parentName)){
				ArrayList<String> list = new ArrayList<String>();
				list.add("Ada.Text_IO");
				list.add("Ada.Integer_Text_IO");
				importMap.put(parentName, list);
			}
			else{
				ArrayList<String> importList = importMap.get(parentName);
				if(!importList.contains("Ada.Text_IO")){
					importList.add("Ada.Text_IO");
				}
				if(!importList.contains("Ada.Integer_Text_IO")){
					importList.add("Ada.Integer_Text_IO");
				}
			}
		}
		else if (type.contains("BOOL")){
			Map<String, ArrayList<String>> boolIOMap = translationManager.getBooleanIOMap();
			Map<String, ArrayList<String>> importMap = translationManager.getImportMap();
			if(!boolIOMap.containsKey(parentName)){
				ArrayList<String> boolIOlist = new ArrayList<String>();
				ArrayList<String> importList = new ArrayList<String>();
				if(!importList.contains("Ada.Text_IO")){
					importList.add("Ada.Text_IO");
				}
				if(!importMap.containsKey(parentName)){
					importMap.put(parentName, importList);
				}
				else{
					ArrayList<String> impList = importMap.get(parentName);
					if(!impList.contains("Ada.Text_IO")){
						impList.add("Ada.Text_IO");
					}
				}
				boolIOlist.add("package Bool_IO is new Enumeration_IO(Boolean);");
				boolIOlist.add("use Bool_IO;");
				boolIOMap.put(parentName, boolIOlist);
			}
			else{
				// Do nothing - since the package Bool_IO declaration will work
				// for all Bool_IO
			}
		}
		
		outCode.add("put(\""+ actualSource.getText() + " \"); put("+ actualSource.getElement()+ "); New_Line;");
		
		return outCode;
	}

}
