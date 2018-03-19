/**
 *
 */
package org.eventb.codegen.il1.translator.utils;

import java.util.Scanner;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.impl.ProgramImpl;
import org.eventb.codegen.il1.translator.IL1TranslatorPlugin;
import org.eventb.core.IEventBProject;
import org.eventb.core.ast.IntegerLiteral;
import org.eventb.internal.core.EventBProject;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorUtils {
	
	// returns true if the string contains only asii characters
	public static boolean isASCII_only(String outputFormula) {
		return outputFormula.matches("\\A\\p{ASCII}*\\z");
	}

	// replace the * unicode (\u2217) character with 
	// the * ASCII character (\x2a)
	public static String removeUnicode(String outputFormula) {
		char[] oldCharArray = outputFormula.toCharArray();
		String newOutputFormula = new String();
		// for each character
		for (int i = 0; i < oldCharArray.length; i++) {
			// if the character is not ascii 
			if (((int) oldCharArray[i]) > 127) {
				// and if it is the unicode *
				if(oldCharArray[i] == '\u2217'){
					// add an ASCII * to the output
					newOutputFormula = newOutputFormula + "*";
				}
				else{
					// Else add the unicode char back.
					// This is where a handler might appear,
					// for other characters needing replacement
					newOutputFormula = newOutputFormula + oldCharArray[i];
				}
			}else{
				// Else we have an ASCII character to add to the formula
				newOutputFormula = newOutputFormula + oldCharArray[i];
			}
		}
		// return the new formula
		return newOutputFormula;
	}


	public static String surroundWithParentheses(String input){
		return "("+input+")";
	}

	public static void log(Throwable exc, String message) {
		if (exc instanceof RodinDBException) {
			final Throwable nestedExc = ((RodinDBException) exc).getException();
			if (nestedExc != null) {
				exc = nestedExc;
			}
		}
		if (message == null) {
			message = "Unknown context"; //$NON-NLS-1$
		}
		IStatus status = new Status(IStatus.ERROR, IL1TranslatorPlugin.PLUGIN_ID,IStatus.ERROR, message, exc);
		IL1TranslatorPlugin.getDefault().getLog().log(status);
	}

	/**
	 * Utility method to log info, problems, errors
	 *
	 * @param message
	 * 			Message to be displayed by the log
	 * @param statusType
	 * 			Status of the log Entry
	 * @param obj
	 * 		  obj that generated the log entry
	 */
	public static void log(String message, int statusType, Object obj) {
		if (message == null) {
			message = "Unknown context"; //$NON-NLS-1$
		}

		if(isLoggable(obj)){
			ILog log = IL1TranslatorPlugin.getDefault().getLog();
			IStatus status = new Status(statusType, IL1TranslatorPlugin.PLUGIN_ID, message);
			log.log(status);
		}
	}

	/**
	 * Utility method to log info, problems, errors
	 *
	 * @param message
	 * 			Message to be displayed by the log
	 * @param statusType
	 * 			Status of the log Entry
	 * @param obj
	 * 		  obj that generated the log entry
	 */
	public static void log(int statusType, Object obj, TranslatorProblem translationProb, Object... args) {
		if(isLoggable(obj)){
			ILog log = IL1TranslatorPlugin.getDefault().getLog();
			IStatus status = new Status(statusType, IL1TranslatorPlugin.PLUGIN_ID, translationProb.getLocalizedMessage(args));
			log.log(status);
		}
	}

	public static boolean isLoggable(Object obj){
		boolean loggable = true;

		if(obj instanceof IntegerLiteral){
			loggable = false;
		}
		else if(obj instanceof Declaration){
			Declaration d = (Declaration) obj;
			if(d.getInitialValue()!=null){
				Scanner scanner = new Scanner(d.getInitialValue());
				loggable = !scanner.hasNextDouble();
			}
		}

		return loggable;
	}

	public static IInternalElement getIInternalElement(Object obj){
		IInternalElement element = null;
		if(obj instanceof IInternalElement){
			element = (IInternalElement) obj;
		}else if(obj instanceof Declaration){
			Declaration decl = (Declaration) obj;
			String componentName = decl.getComponentName();
			String projectName = decl.getProjectName();
			IEventBProject evtProj = new EventBProject(RodinCore.getRodinDB().getRodinProject(projectName));
			element = evtProj.getMachineRoot(componentName);
			if(element==null)
				element = evtProj.getContextRoot(componentName).getRoot();
		}else if(obj instanceof IL1Element){
			IL1Element il1Element = (IL1Element) obj;
			EObject eContainer = il1Element.eContainer();
			while(eContainer!=null){
				if(eContainer instanceof ProgramImpl){
					ProgramImpl prog = (ProgramImpl) eContainer;
					String projectName = prog.getProjectName();
					String machineName = prog.getName();
					if(machineName==null){
						Task task = prog.getTaskTypeTasks().get(0);
						machineName = task.getMachineName();
					}
					IEventBProject evtProj = new EventBProject(RodinCore.getRodinDB().getRodinProject(projectName));
					element = evtProj.getMachineFile(machineName).getRoot();
					break;
				}else eContainer = eContainer.eContainer();
			}
		}


		return element;
	}

	 public static MessageConsole findConsole(String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});

//	      IConsole myConsole = ...;// your console instance
//	      IWorkbenchPage page = ...;// obtain the active page
//	      String id = IConsoleConstants.ID_CONSOLE_VIEW;
//	      IConsoleView view = (IConsoleView) page.showView(id);
//	      view.display(myConsole);

	      return myConsole;
	   }

}
