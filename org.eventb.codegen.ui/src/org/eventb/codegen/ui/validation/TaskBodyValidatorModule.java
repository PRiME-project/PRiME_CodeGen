package org.eventb.codegen.ui.validation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.EQUALS_SYMBOL;
import static org.eventb.codegen.ui.attributes.ParameterTypeAttribute.IN_PARAM;
import static org.eventb.codegen.ui.attributes.ParameterTypeAttribute.OUT_PARAM;
import static org.eventb.codegen.ui.attributes.ParameterTypeAttribute.PARAMETER_NOT_SET;
import static org.eventb.codegen.ui.attributes.ParameterTypeAttribute.PARAMETER_TYPE_ATTRIBUTE;
import static org.eventb.codegen.ui.attributes.TaskingContextAttribute.TASKING;
import static org.eventb.codegen.ui.attributes.TaskingContextAttribute.TASKING_CONTEXT_ATTRIBUTE;
import static org.eventb.codegen.ui.attributes.TypingAttribute.NON_TYPING;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPING_ATTRIBUTE;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.taskbodybuilder.TextToEMFParser;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.translation.EventWrapperTaskingTranslator;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IAction;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEvent;
import org.eventb.core.IGuard;
import org.eventb.core.IInvariant;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IParameter;
import org.eventb.core.ISeesContext;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.persistence.synchroniser.SyncManager;
import org.eventb.tasking.persistence.IMachineType;
import org.eventb.tasking.persistence.ITaskBody;
import org.eventb.tasking.persistence.ITaskType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinDBException;

import tasking.Task;
import tasking.impl.TaskImpl;

import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;
import compositeControl.SubBranch;

// SEE: http://wiki.event-b.org/index.php/Extending_the_Static_Checker_(How_to_extend_Rodin_Tutorial)

public class TaskBodyValidatorModule extends CodeGenerationValidatorModule {
	
	public static final IModuleType<TaskBodyValidatorModule> MODULE_TYPE = SCCore.getModuleType(EventBCodeGenerationUI.PLUGIN_ID + ".taskBodyModule");

	@Override
	public void process(IRodinElement element, IInternalElement target,
			ISCStateRepository repository, IProgressMonitor monitor)
			throws CoreException {
		
		
		//	This is where the checks are performed - get the task body elements
		final IRodinFile machineFile = (IRodinFile) element;
		final IMachineRoot machineRoot = (IMachineRoot) machineFile.getRoot();
		final IMachineType [] machineTypeArr = (IMachineType[]) machineRoot.getChildrenOfType(IMachineType.ELEMENT_TYPE);
		
		if (machineTypeArr.length > 0)
		{
			//	Check task type information
			final ITaskType [] taskTypeArr = (ITaskType[]) machineTypeArr[0].getChildrenOfType(ITaskType.ELEMENT_TYPE);
			if (taskTypeArr.length > 1)
			{
				//	Too many task types
				for (ITaskType t : taskTypeArr)
				{
					createProblemMarker(t, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTaskType);
				}
			}
			
			//	Check task body information - requires task body and parent Task		
			final ITaskBody [] taskBodyArr = (ITaskBody[]) machineTypeArr[0].getChildrenOfType(ITaskBody.ELEMENT_TYPE);
			
			if (taskBodyArr.length > 0)
			{
				String taskBody = taskBodyArr[0].getTaskBody();
				Task parentTask = getParentTask(machineRoot);
				
				if (codeLinesValid(taskBody))
				{
				
					if (parentTask != null)
					{									
						try {
							TextToEMFParser parser = new TextToEMFParser(taskBody, parentTask);
	
							//	This checks the syntax
							if (!parser.validParsingGrammar())
							{
								String errorDescription = parser.getError_description();
								CodeGenerationStaticErrors.taskBodyDescriptiveError.setMessage(errorDescription);
								createProblemMarker(taskBodyArr[0], EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.taskBodyDescriptiveError);
								
	//							Set<ErrorLocation> errors = parser.getErrorsLocations();
	//							
	//							for (ErrorLocation e : errors)
	//							{
	//								int column = e.getColumnNumber();
	//								int line = e.getLineNumber();					
	//							}
							}
							
							//	This has further checks, such as multiple naming.
							parser.validateInputAndGenerateEMF();
							if (!parser.getError_description().isEmpty())
							{
								CodeGenerationStaticErrors.taskBodyDescriptiveError.setMessage(parser.getError_description());
								createProblemMarker(taskBodyArr[0], EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.taskBodyDescriptiveError);
							}
							
						} catch (UnsupportedEncodingException e) { 
							e.printStackTrace();
						} catch (org.eventb.codegen.taskbodybuilder.ParseException e) {
							e.printStackTrace();
						}
					
					
						//	As the parser doesn't check to see if events are valid, check them manually
						ArrayList<String> invalidNames = new ArrayList<String>();
						
						//	Well that didn't work! The EMF it is using doesn't contain the same as the task body string
						//	so this isn't all that good for checking the task body string
						//	Actually this was because it is not picking up no Seq ; in the task body...
						//	Add missing ; check
						if (!validNames(parentTask, invalidNames))
						{
							String names = "";
							
							for (int i = 0 ; i < invalidNames.size(); i++)
							{
								if (i > 0)
								{
									names += ", " + invalidNames.get(i);
								}
								else
								{
									names += invalidNames.get(i);
								}
							}										
							
							CodeGenerationStaticErrors.taskBodyDescriptiveError.setMessage("Invalid names: " + names);
							createProblemMarker(taskBodyArr[0], EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.taskBodyDescriptiveError);
						}
	
					}
					
					//	Should only be one task body, otherwise error			
					if (taskBodyArr.length > 1)
					{
						for (ITaskBody t : taskBodyArr)
						{
							createProblemMarker(t, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTaskBody);
						}
					}
				}	//	EndIf codeLinesValid()
				else
				{
					//	error message set in codeLinesValid()
					createProblemMarker(taskBodyArr[0], EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.taskBodyDescriptiveError);
				}
			}
			
			//	If more than one machine type - error
			if (machineTypeArr.length > 1)
			{
				for (IMachineType m : machineTypeArr)
				{
					createProblemMarker(m, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTaskingElements);
				}
			}
			
			//	This will only be called if it is a CodeGen machine (Task, Shared, Environ) due to "machineTypeArr.length > 0"
			
			//	Check events for parameter direction and guard typing
			final IEvent [] events = (IEvent[]) machineRoot.getChildrenOfType(IEvent.ELEMENT_TYPE);
			this.staticCheckEventsForTasking(events);
			
			//	Check invariants for typing
			final IInvariant [] invariants = (IInvariant[]) machineRoot.getChildrenOfType(IInvariant.ELEMENT_TYPE);
			ArrayList<String> variablesTyped = this.staticCheckInvariantsForTasking(invariants);
			this.checkVariablesHaveTypes(machineRoot.getVariables(), variablesTyped);
			
			//	Check that seen contexts to make sure they are looking at Tasking contexts
			final ISeesContext [] seesContexts = (ISeesContext[]) machineRoot.getChildrenOfType(ISeesContext.ELEMENT_TYPE);
			this.staticCheckSeesContextsForTasking(seesContexts);
		}
	}



	private boolean codeLinesValid(String taskBody) {
		
		String [] tokens = taskBody.split(";");
		for (int i = 1; i < tokens.length; i++)
		{
			String line = tokens[i];
			//	line = line.trim();		-	 no, trim also gets rid of new line commands
			
			//	Remove leading white space
			while (line.startsWith(" "))
				line = line.substring(1);
						
			if (!line.startsWith(System.getProperty("line.separator")) && !line.startsWith("\n"))	//	line.separator will get most, \n will get the rest of new line markers
			{
				CodeGenerationStaticErrors.taskBodyDescriptiveError.setMessage("New line required after " + tokens[i-1] + ";");
				return false;
			}
		}	
					
		return true;
	}

	private boolean validNames(Task parentTask, ArrayList<String> invalidNames) {
		
		invalidNames.clear();
		
		validNames(parentTask.getTaskBody(), invalidNames, parentTask);
		
		return invalidNames.size() == 0;	//	true if no invalid names, false otherwise
	}
	
	private void validNames(CompositeControl cc, ArrayList<String> invalidNames, Task parentTask)
	{
				
		//	Go down the tree and find EventWrappers
	//	CompositeControl taskBody = parentTask.getTaskBody();

		
		if (cc instanceof Do)
		{
			validNames(((Do) cc).getTaskBody(), invalidNames, parentTask);
			validNames(((Do) cc).getFinally(), invalidNames, parentTask);
		}
		else if (cc instanceof Seq)
		{
			validNames(((Seq) cc).getLeftBranch(), invalidNames, parentTask);
			validNames(((Seq) cc).getRightBranch(), invalidNames, parentTask);
		}
		else if (cc instanceof Branch)
		{
			validNames(((Branch) cc).getEventWrapper(), invalidNames, parentTask);
			validNames(((Branch) cc).getSubBranch(), invalidNames, parentTask);
			validNames(((Branch) cc).getAlt(), invalidNames, parentTask);
		}
		else if (cc instanceof SubBranch)
		{
			validNames(((SubBranch) cc).getEventWrapper(), invalidNames, parentTask);
			validNames(((SubBranch) cc).getSubBranch(), invalidNames, parentTask);
		}
		else if (cc instanceof EventWrapper)
		{
			String eventName = ((EventWrapper) cc).getEventName();
			
			//	is valid name?
			if (!isValidEventName(eventName, parentTask))
			{
				// if not:
				String error = "Event: " + eventName; 
				invalidNames.add(error);
			}
		}
		else if (cc instanceof Output)
		{
			//	is valid variable name?
			String variableName = ((Output) cc).getVariableName();
			
			if (!isValidVariableName(variableName, parentTask))
			{			
				//	if not:
				String error = "Variable: " + variableName; 
				invalidNames.add(error);
			}
		}
		else
		{
			//	is null
		}
	}
	
	

	private boolean isValidVariableName(String variableName, Task parentTask) {
		//	Get the machine
		Machine machine = (Machine) parentTask.eContainer();
		
		//	See if the variable name is the same as one of the variables
		for (Variable v : machine.getVariables())
		{
			if (v.getName().equals(variableName))
			{
				return true;
			}
		}
		
		return false;
	}

	private boolean isValidEventName(String eventName, Task parentTask) {
		//	Get the machine
		Machine machine = (Machine) parentTask.eContainer();
		
		//	See if the event name is the same as one of the variables
		for (Event e : machine.getEvents())
		{
			if (e.getName().equals(eventName))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public IModuleType<?> getModuleType() {
		return MODULE_TYPE;
	}
	
	
	private Task getParentTask(IMachineRoot machineRoot)
	{

		SyncManager syncManager = new SyncManager();
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		
		try {
			Machine emfMachine = (Machine) syncManager.loadRodinElement(machineRoot, null, map, null);
			
			if (emfMachine != null)
			{
				//	Go through the abstract extensions and find the task body				
				for (AbstractExtension e : emfMachine.getExtensions())
				{
					if (e instanceof TaskImpl)
					{
						return (Task)e;
					}
				}						
			}
			
		} catch (Exception e) {
			//	Could not load the emf version of the machine
			//	This could be because the sees context has not been set
//			e.printStackTrace();
		}	
		
		//	No task body element - which there should be if it go this far!
		//	Actually - it can get here if the sees context is not set.
		return null;
	}
	
	
	
	private void staticCheckEventsForTasking(IEvent [] events) throws RodinDBException 
	{
		for (IEvent e : events)
		{
			//	Parameter direction
			try
			{
				ArrayList<IParameter> inParams = new ArrayList<IParameter>();
				ArrayList<IParameter> outParams = new ArrayList<IParameter>();
				for (IParameter p : e.getParameters())
				{
					String parameter = null;
					try 
					{
						parameter = p.getAttributeValue(PARAMETER_TYPE_ATTRIBUTE);
					}
					catch(RodinDBException exp)
					{
						//	if the attribute simply doesn't exist, code will end up here
						createProblemMarker(p, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.parameterDirectionError);
					}
				
					if (parameter != null)
					{
						if (parameter.equals(PARAMETER_NOT_SET))
						{
							createProblemMarker(p, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.parameterDirectionError);
						}
						else if (parameter.equals(IN_PARAM))
						{
							inParams.add(p);
						}
						else if (parameter.equals(OUT_PARAM))
						{
							outParams.add(p);
						}
					}
				}
				
				
				//	Check in parameters for correct actions
				for (IParameter p : inParams)
				{
					checkInParameterCorrect(p, e);
				}
				
				//	Check out parameters for correct guards
				for (IParameter p : outParams)
				{
					checkOutParameterCorrect(p, e);
				}
			}
			catch (RodinDBException exp)
			{
				
			}
			
			
//			Guard typing (currently not needed as we force non-typing) - but may be useful if auto typing added
			ArrayList<String> leftHandNames = new ArrayList<String>();
			for (IGuard g : e.getGuards())
			{
				String pred = g.getPredicateString();
				checkTyping(g, pred, leftHandNames);
			}
			
			//	Check that all the parameters have been typed
			this.checkParametersHaveTypes(e.getParameters(), leftHandNames);
			
			
			
			//	replaced by above method call
	/*		
			
			ArrayList<String> leftHandNames = new ArrayList<String>();
			try
			{
				for (IGuard g : e.getGuards())
				{
					String pred = g.getPredicateString();
					String lhs = getLeftHandSide(pred);
					
					String type = g.getAttributeValue(TYPING_ATTRIBUTE);
					
					if (type.equals(TYPE_NOT_SET))
					{
						createProblemMarker(g, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
					}
					else if (type.equals(TYPING))
					{
						if (leftHandNames.contains(lhs))
						{
							//	this has already been typed
							createProblemMarker(g, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTypingError);	
						}
						
						leftHandNames.add(lhs);
					}
				}				
			}
			catch (RodinDBException exp)
			{
				
			}
			*/
		}
	}
	
	/**
	 * Performs static checks on invariants and returns the names of those variables
	 * where the typing flag has been checked.
	 * @param invariants The set of invariants.
	 * @return The names of the variables that typing flags have been set.
	 * @throws RodinDBException
	 */
	private ArrayList<String> staticCheckInvariantsForTasking(IInvariant [] invariants) throws RodinDBException
	{
		ArrayList<String> leftHandNames = new ArrayList<String>();
		for (IInvariant i : invariants)
		{
			String pred = i.getPredicateString();
			checkTyping(i,pred,leftHandNames);
/*			
			//	Typing
			try
			{
				String pred = i.getPredicateString();
				String lhs = getLeftHandSide(pred);
				
				String type = i.getAttributeValue(TYPING_ATTRIBUTE);
								
				if (type.equals(TYPE_NOT_SET))
				{
					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
				}
				else if (type.equals(TYPING))
				{
					if (leftHandNames.contains(lhs))
					{
						//	this has already been typed
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTypingError);	
					}
					
					leftHandNames.add(lhs);
					
					//	Check if it contains ELEMENT_OF
					if (!pred.contains(ELEMENT_OF))
					{
						//	Add warning
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectTypingWarning);
					}
				}
				else if (type.equals(NON_TYPING))
				{
					//	Check if it contains ELEMENT_OF
					if (pred.contains(ELEMENT_OF))
					{
						//	Add warning
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectNonTypingWarning);
					}
				}
			}
			catch (RodinDBException exp)
			{
				
			}
*/			
		}
		
		
		return leftHandNames;
	}
	
//	/**
//	 * Checks the typing and issues the required errors and warnings.
//	 * @param i The element to check (either Invariant, Guard or Axiom).
//	 * @param predicate The predicate string.
//	 * @param leftHandNames Array list to use for left hand names found. This should be used for each local block of invariants or guards. Eg. all invariants in one event.
//	 */
//	private void checkTyping(IInternalElement i, String predicate,ArrayList<String> leftHandNames)
//	{
////		Typing
//		try
//		{			
//			String lhs = getLeftHandSide(predicate);
//			String type = i.getAttributeValue(TYPING_ATTRIBUTE);
//								
//			if (type.equals(TYPE_NOT_SET))
//			{
//				createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
//			}
//			else if (type.equals(TYPING))
//			{
//				if (leftHandNames.contains(lhs))
//				{
//					//	this has already been typed
//					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTypingError);	
//				}
//				
//				leftHandNames.add(lhs);
//				
//				//	Check if it contains ELEMENT_OF
//				if (!predicate.contains(ELEMENT_OF))
//				{
//					//	Add warning
//					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectTypingWarning);
//				}
//			}
//			else if (type.equals(NON_TYPING))
//			{
//				//	Check if it contains ELEMENT_OF
//				if (predicate.contains(ELEMENT_OF))
//				{
//					//	Add warning
//					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectNonTypingWarning);
//				}
//			}
//		}
//		catch (RodinDBException exp)
//		{
//			
//		}
//	}
	
	
//	public static String getLeftHandSide(String pred)
//	{
//		pred = pred.trim();
//		
//		if (pred.length() == 0)
//			return "";
//		
//		String lhs = pred.split(" ")[0];
//		
//		return lhs;
//	}
	
	
	
	private void checkInParameterCorrect(IParameter inParam, IEvent e)
	{
		try {
			String p = inParam.getIdentifierString();
			
			String [] pvmActions = getParameterVariableMatchFromActions(p,e.getActions());
			
			if (pvmActions == null || pvmActions.length != 2)
			{
				//	Something wrong
				createProblemMarker(inParam, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.inParameterDefinitionError);
			}
			
		} catch (RodinDBException e1) {
			e1.printStackTrace();
		}
	
	}
	
	private void checkOutParameterCorrect(IParameter outParam, IEvent e)
	{
		try {
			String p = outParam.getIdentifierString();
			
			String [] pvmGuards = getParameterVariableMatchFromGuards(p,e.getGuards());
			
			if (pvmGuards == null || pvmGuards.length != 2)
			{
				//	Something wrong
				createProblemMarker(outParam, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.outParameterDefinitionError);
			}
			
			
		} catch (RodinDBException e1) {
			e1.printStackTrace();
		}
	}
	
	
	/**
	 * Copied from EventTaskingTranslator
	 * 
	 * Gets the guards where there are parameters in them
	 * 
	 * CHANGED - SO ONLY LOOKS AT NON_TYPING GUARDS
	 * 
	 * @param p
	 * @param guards
	 * @return
	 * @throws RodinDBException 
	 */
	private String[] getParameterVariableMatchFromGuards(String pName,
			IGuard [] guards) throws RodinDBException {
//		String pName = p.getName().trim();

		for (IGuard g : guards) {
			if (g.getAttributeValue(TYPING_ATTRIBUTE).equals(NON_TYPING))
			{
				if (g.getPredicateString().contains(EQUALS_SYMBOL)) {
					String[] parts = g.getPredicateString().split(EQUALS_SYMBOL);
	
					for (String s : parts) {
						if (s.trim().equals(pName)) {
							return parts;
						}
					}
				}
			}
		}

		return null;
	}
	
	/**
	 * Copied from EventTaskingTranslator
	 * 
	 * @param p
	 * @param actions
	 * @return
	 */
	String[] getParameterVariableMatchFromActions(String pName,
			IAction [] actions) throws RodinDBException {
//		String pName = p.getName().trim();

		for (IAction a : actions) {
			if (a.getAssignmentString().contains(ASSIGNMENT_SYMBOL)) {
				String[] parts = a.getAssignmentString().split(ASSIGNMENT_SYMBOL);

				int idx = 0;
				for (String s : parts) {

					ArrayList<String> tStr = EventWrapperTaskingTranslator
							.tokeniseRHS(s);

					for (String t : tStr) {
						if (t.trim().equals(pName)) {
							parts[idx] = t.trim();
							return parts;
						}
					}

					idx++;
				}
			}
		}

		return null;
	}
	
	
	
	private void staticCheckSeesContextsForTasking(ISeesContext[] seesContexts) 
	{
		for (ISeesContext sc : seesContexts)
		{
			try {
				IContextRoot c = sc.getSeenContextRoot();
				if (c.hasAttribute(TASKING_CONTEXT_ATTRIBUTE) && c.getAttributeValue(TASKING_CONTEXT_ATTRIBUTE).equals(TASKING))
				{
					//	This is a tasking context - so fine
				}
				else
				{
					createProblemMarker(sc, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.taskingContextError);
				}
				
				
			} catch (RodinDBException e) {
				Status status = new Status(IStatus.ERROR,
						CodeGenTasking.PLUGIN_ID,
						"Failed Translation: TaskingTranslationException:"
						+ e.getMessage() +":\n"+ CodeGenTaskingUtils.extractFullExceptionMessage(e) , e);
					StatusManager.getManager().handle(status,
						StatusManager.SHOW);

			}		
		}
		
	}

}
