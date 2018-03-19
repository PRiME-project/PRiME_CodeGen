package org.eventb.codegen.il1.translator.primecpp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.il1.SimpleTaskType;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.TaskTypeEnum;
import org.eventb.codegen.il1.translator.ClassHeaderInformation;
import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.il1.translator.IL1TranslationUnhandledTypeException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.core.AbstractTaskIL1Translator;
import org.eventb.core.IContextRoot;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

public class PrimeCppTaskTranslator extends AbstractTaskIL1Translator {


	public ArrayList<String> translate(IL1Element source,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		
		Task actualSource = (Task)source;		

		//	Translate the declarations - must happen first otherwise theory translator will break.
		//	Each decl translation will be put in a separate ArrayList<String> so that they can be easily
		//	identified individually if needed.
		ArrayList<ArrayList<String>> declList = new ArrayList<ArrayList<String>>();
	
		for (Declaration decl : actualSource.getDecls())
		{

			ArrayList<String> declStringList = translationManager.translateIL1ElementToCode(decl, targetLanguage);

			ArrayList<String> enumNames = translationManager.getEnumTypeNameList();
			// if this declared type is an enum, we add a suffix
			String declType = decl.getType();
			if(enumNames.contains(declType)){
				// get the declaration from the returned array. An var with an enum type should be the first
				// in the list
				String thisDecl = declStringList.get(0);
				// add the suffix
				int insertAt = thisDecl.lastIndexOf(declType)+declType.length();
				String firstPart = thisDecl.substring(0, insertAt);
				String lastPart = thisDecl.substring(insertAt);
				declStringList.remove(0);
				declStringList.add(firstPart+"Enum"+lastPart);
				
			}
			declList.add(declStringList);
		}
		

		//	Translate the subroutines.
		//	Each subroutine translation will be put in a separate ArrayList<String> so that they can be easily
		//	identified individually if needed.
		ArrayList<ArrayList<String>> subroutineList = new ArrayList<ArrayList<String>>();
		for (Subroutine subroutine : actualSource.getSubroutines())
		{
			ArrayList<String> subStr = translationManager.translateIL1ElementToCode(subroutine, targetLanguage);
			subroutineList.add(subStr);			
		}
		
		
		//	Translate the task body
		ArrayList<String> taskBody = translationManager.translateIL1ElementToCode(actualSource.getBody(), targetLanguage);
		
		
		//	See if periodic or repeating
		boolean isPeriodic = false;
		boolean isRepeating = false;	//	additional flag on periodic
		int period = -1;				//	default for not periodic
		
		if (actualSource.getTaskType() != null)
		{
			if (actualSource.getTaskType() instanceof PeriodicTaskType)
			{
				isPeriodic = true;
				period = ((PeriodicTaskType)actualSource.getTaskType()).getPeriod();
			}
			if (actualSource.getTaskType() instanceof SimpleTaskType && ((SimpleTaskType)actualSource.getTaskType()).getType() == TaskTypeEnum.REPEATING)
			{
				isRepeating = true;
			}
		}

		//	Get the concrete TaskIL1Translator to put it all together
		ArrayList<String> outCode = this.generateTaskCode(actualSource
				.getName().replaceAll(" ", "").trim(),
				actualSource.getTaskType(), isPeriodic, isRepeating,
				actualSource.getPriority(), period, declList, subroutineList,
				taskBody, actualSource, translationManager, targetLanguage);
		

		return outCode;
	}
	@Override
	protected ArrayList<String> generateTaskCode(String taskName,
			TaskType taskType, boolean isPeriodic, boolean isRepeating,
			int priority, int period, ArrayList<ArrayList<String>> declList,
			ArrayList<ArrayList<String>> subroutineList,
			ArrayList<String> taskBody, Task actualSource,
			IL1TranslationManager translationManager,
			TargetLanguage targetLanguage) {

		ClassHeaderInformation headerInfo = new ClassHeaderInformation();
		headerInfo.setClassName(actualSource.getName());
		//localVariable(taskBody);

		int i = 0;
		for(String task : taskBody)
		{
			if(task.contains("LOCALVAR_"))
			{
				String t = task.replace("LOCALVAR_", "int ");
				taskBody.set(i, t);
			}		
			i++;
		}

		
		
		
		ArrayList<String> outCode = new ArrayList<String>();	
		//outCode.add("#include \"" + actualSource.getMachineName() + ".hpp\"");
		outCode.add("// Task: " + taskName);
		outCode.add("");
		//outCode.add("class " + taskName+ " {");
		outCode.add("namespace prime {");
		outCode.add("namespace codegen {");
		// Add the variables and constants namespace codegen{
		//outCode.add("// Variables and constants");
		//for (ArrayList<String> decl : declList)
		//	outCode.addAll(decl);

		// Add priority variable
		//outCode.add("const int priority_" + taskName + " = " + priority + ";");

		outCode.add("");

		// Add the subroutines
		outCode.add("");
		outCode.add("// Subroutines");

		doArrayInits(taskName, outCode, declList);

		headerInfo.getHeaderEntries().add("namespace prime {");
		headerInfo.getHeaderEntries().add("namespace codegen {");
		headerInfo.getHeaderEntries().add("class " + taskName+"{");
		headerInfo.getHeaderEntries().add("public:");
		headerInfo.getHeaderEntries().add(taskName +"();");
		headerInfo.getHeaderEntries().add("~"+ taskName +"();");

		for (ArrayList<String> sub : subroutineList) {
			String firstLine = sub.get(0);
			headerInfo.getHeaderEntries().add(firstLine + ";");
			outCode.addAll(sub);
			outCode.add("");
		}

		String input = getInputArgs(actualSource, translationManager, targetLanguage);
	
		
		headerInfo.getHeaderEntries().add("void run("+ input +");");


		outCode.add(taskName +"::~" + taskName + "(){");
		outCode.add("}");

		outCode.add("");
		
		// Task body
		outCode.add("void "+ taskName + "::run("+ input +")");
		outCode.add("{"); // Start TaskBody

		// Handle periodic or repeating tasks
		if (isPeriodic || isRepeating) {
			translationManager.addIncludeStatement("#define TRUE 1");

			outCode.add("while(TRUE)");
			outCode.add("{"); // start while loop

			// Get timer information
			if (isPeriodic) {
				// Add the timer information
				outCode.add("// [Internal] Timer information for repeating or periodic tasks");
				outCode.add("double internalPeriodicStartTime = omp_get_wtime();");
				outCode.add("double internalTimeDifference;");
				outCode.add("");
			}

			outCode.add("// Translated code");
			outCode.addAll(taskBody);

			if (isPeriodic) {
				outCode.add("");
				outCode.add("// [Internal] Code to monitor time between periodic tasks");
				outCode.add("internalTimeDifference = omp_get_wtime() - internalPeriodicStartTime;");
				//outCode.add("__SLEEP(" + period
				//		+ " - (internalTimeDifference * 1000));");
			}

			outCode.add("}"); // end while loop
		} else {
			outCode.addAll(taskBody);
		}

		outCode.add("}");
		outCode.add("}");
		outCode.add("}"); // End TaskBody
		//addSleepFunction(translationManager);
		//headerInfo.getHeaderEntries().add("void __SLEEP(int period);");
		headerInfo.getHeaderEntries().add("private:");
		for (ArrayList<String> decl : declList){
			String d = decl.get(0);
			if(!d.contains("outarg_")){
			String[] bothdecls = d.split("%");
			headerInfo.getHeaderEntries().add(bothdecls[1]);
			}
		}

		headerInfo.getHeaderEntries().add("};");
		headerInfo.getHeaderEntries().add("}");
		headerInfo.getHeaderEntries().add("}");
		

		translationManager.addClassHeaderInformation(headerInfo);

		return outCode;
	}


	private void localVariable(ArrayList<String> taskBody) {
		int i = 0;
		for(String task : taskBody)
		{
			if(task.contains("LOCALVAR_"))
			{
				String t = task.replace("LOCALVAR_", "int ");
				taskBody.set(i, t);
			}		
			i++;
		}
	}
		
	private String getInputArgs(Task actualSource, IL1TranslationManager translationManager, TargetLanguage targetLanguage) {
		ArrayList<ArrayList<String>> declList = new ArrayList<ArrayList<String>>();
		String in = "";
		ArrayList<Declaration> temp = new ArrayList<Declaration>();
		temp.addAll(inputArguments);
		for (Declaration decl : temp)
		{
			try {
				ArrayList<String> declStringList = translationManager.translateIL1ElementToCode(decl, targetLanguage);
				declList.add(declStringList);
			} catch (IL1TranslationUnhandledTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int i = 0;
		for(ArrayList<String> d : declList)
		{
			for(String c : d)
			{
				c = c.replace("const", "");
				c = c.replaceAll(";", "");
				c = c.replace("inarg_", "");
				c = c.replace("outarg_", "");
				String mn = actualSource.getMachineName();
				c = c.replace("_" + mn, "");

				c = c.trim();
				
				if(i != 0)
					in = in + ", ";
				i++;
				in = in + c;
			}
		}
		
		return in;
	}
	
	
    public static IContextRoot[] getContextRootChildren(IRodinProject project) throws RodinDBException {
        ArrayList<IContextRoot> result = new ArrayList<IContextRoot>();
        for (IRodinElement element : project.getChildren()) {
              if (element instanceof IRodinFile) {
                    IInternalElement root = ((IRodinFile) element).getRoot();
                    if (root instanceof IContextRoot) {
                          result.add((IContextRoot) root);
                    }
              }
        }
        return result.toArray(new IContextRoot[result.size()]);
  }

	private void doArrayInits(String taskName, ArrayList<String> outCode, ArrayList<ArrayList<String>> declList) {
		// add an initialisation function
		outCode.add("" + taskName + "::" + taskName + "(){");

		for (ArrayList<String> decl : declList){
			//outCode.addAll(decl);
			String d = decl.get(0);
			if(!d.contains("outarg_")){
			String[] bothdecls = d.split("%");
			outCode.add(bothdecls[0]);
			}
		}
		
		Map<String, List<String>> arrayDimensionsMap = PrimeCppTranslatorUtils
				.getArrayDimensions();
		// each arrayElement should be initialised
		
		 List<String> arrayNamesList = Arrays.asList(arrayDimensionsMap.keySet().toArray(new String[arrayDimensionsMap.size()]));

		// for each array declaration
		for (String arrayName : arrayNamesList) {
			List<String> dimensionList = arrayDimensionsMap.get(arrayName);
			// we need to initialise each dimension
			int index = 0;
			// make a for loop for each dimension
			for (String dimension : dimensionList) {
				makeForPart(outCode, index, dimension, dimensionList.size());
				index++;
			}
			// initialise
			String initPart = arrayName+"_"+taskName;
			for (int i = 0; i < dimensionList.size(); i++) {
				initPart = initPart + "[i" + i + "]";
			}
			outCode.add(initPart = initPart 
					+ " = " + PrimeCppTranslatorUtils.getArrayInitValue().get(arrayName)
					+ ";");
			// add closing brackets
			for (int i = 0; i < dimensionList.size(); i++) {
				outCode.add("}");
			}
		}
		outCode.add("}\n");
	}

	private void makeForPart(ArrayList<String> outCode, int index,
			String dimension, int dimListSize) {
		outCode.add("int i" + index + "= 0;");
		outCode.add("for( ; i" + index + " < " + dimension
				+ "; i" + index + "++){");
	}

	/**
	 * Will add the different sleep functions, for different architectures
	 */
	public static void addSleepFunction(IL1TranslationManager translationManager) {
		ArrayList<String> sleepFunctionStr = new ArrayList<String>();

		sleepFunctionStr.add("// Platform specific function: sleep");
		sleepFunctionStr.add("// Supported platforms: Win32, UNIX");
		// Unix
		sleepFunctionStr.add("#ifdef __unix__");
		sleepFunctionStr.add("#include<unistd.h>");
		sleepFunctionStr.add("void __SLEEP(int period)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("if (period > 0)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("usleep(period*1000);");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("}");
		// Win32
		sleepFunctionStr.add("#elif defined _WIN32");
		sleepFunctionStr.add("#include<windows.h>");
		sleepFunctionStr.add("void __SLEEP(int period)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("if (period > 0)");
		sleepFunctionStr.add("{");
		sleepFunctionStr.add("Sleep(period);");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("}");
		sleepFunctionStr.add("#endif");
		sleepFunctionStr.add("");

		translationManager.addCompilerDependentExecutableCodeBlock("sleep",
				sleepFunctionStr);
	}
}
