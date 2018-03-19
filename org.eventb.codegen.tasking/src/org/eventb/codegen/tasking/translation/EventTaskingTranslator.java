package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.EQUALS_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.UP_TO;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.RodinToEMFConverter;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.rodinp.keyboard.core.RodinKeyboardCore;

import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.Implementation;
import tasking.ImplementationTypeEnum;
import tasking.MachineType;
import tasking.ParameterType;
import tasking.ParameterTypeEnum;
import tasking.Shared_Machine;
import tasking.Task;

public class EventTaskingTranslator extends AbstractTaskingTranslator {

	private boolean wasProxy = false;

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		// Reset flag
		wasProxy = false;

		Event actualSource = (Event) source;
		Subroutine actualTarget = null;

		// Set the machine and project name in the subroutine
		MachineImpl parentMachine = TaskingTranslationManager
				.getParentMachine(source);

		if (actualSource.eIsProxy()) {
			actualSource = (Event) EcoreUtil.resolve(actualSource,
					RodinToEMFConverter.machineResSet);
		}

		// is this event on the doNotRecover list??
		List<EventBElement> doNotRecoverList = translationManager
				.getDoNotRecoverPreviousTranslationList();
		boolean doNotRecover = doNotRecoverList.contains(actualSource);

		// If still a proxy, look for the actual translation
		boolean previousTranslationExists = translationManager.previousTranslationExists(actualSource);
		if (!doNotRecover
				&& previousTranslationExists) {
			// To ensure the proxy isn't saved
			wasProxy = true;
			IL1Element translation = translationManager
					.recoverPreviousTranslation(actualSource);

			if (translation instanceof Subroutine) {
				// Just return as nothing else needed
				return (Subroutine) translation;
			} else {
				// Abort - something went wrong
				return null;
			}
		} else {
			actualTarget = translationManager.getIL1Factory()
					.createSubroutine();
			String parentMachineName = "";

			// if there is no parent then avoid throwing exceptions
			if (parentMachine != null) {
				parentMachineName = parentMachine.getName();
				String projectName = translationManager
						.getProjectName(parentMachine);

				actualTarget.setMachineName(parentMachineName);
				actualTarget.setProjectName(projectName);
			}
				// Store event so it can be recovered by proxies later on
				translationManager.storeEventBElement(actualSource, null, parentMachineName);
			
		}

		// Ignore initialisations, they are handled by declarations
		if (actualSource.getName().toUpperCase().trim()
				.equals("INITIALISATION")) {
			return null;
		}
		// Perform translation
		actualTarget.setName(actualSource.getName());

		// if source is temporary -- make target temporary
		if (isTemporary(actualSource)) {
			actualTarget.setTemporary(true);
		} else {
			actualTarget.setTemporary(false);
		}

		ArrayList<org.eventb.codegen.il1.Action> actions = new ArrayList<org.eventb.codegen.il1.Action>();

		Event pairedEvent = null;
		pairedEvent = CodeGenTaskingUtils.getComposedEvent(translationManager,
				actualTarget.getProjectName(), actualTarget.getMachineName(),
				actualTarget.getName());

		MachineType parentType = CodeGenTaskingUtils.getTaskType(parentMachine);
		MachineImpl pairedParentMachine = null;
		boolean removeActionsWithParams = false;
		boolean eqToAss = false;

		// if the event is synchronized with another in a paired machine
		if (pairedEvent != null) {
			pairedParentMachine = TaskingTranslationManager
					.getParentMachine(pairedEvent);
			// in pairs with environ-shared, or tasking-shared, we remove
			// parameters
			MachineType pairedParentType = CodeGenTaskingUtils
					.getTaskType(pairedParentMachine);

			// remove actions with params, for the case where actions with
			// parameters are replaced
			// by a parameter in a call, and the assignment occurs in the called
			// subroutine and passed back.
			// i.e. remove for environ-shared, and tasking-shared, or
			// autoTask-environ
			if (parentType instanceof Task
					&& pairedParentType instanceof Shared_Machine
					|| parentType instanceof AutoTask_Machine
					&& pairedParentType instanceof Environ_Machine) {
				removeActionsWithParams = true;
			}
			// Some guards are replaced by an assignment in a subroutine.
			// This happens for guards involving out parameters, in shared
			// machines
			if (parentType instanceof Shared_Machine
					|| parentType instanceof Environ_Machine
					&& pairedParentType instanceof Task) {
				eqToAss = true;
			}
		}

		for (Action a : actualSource.getActions()) {
			IL1Element actionTranslation = translationManager.translate(a);

			// In some places the action v:=p is not translated to target, but
			// becomes an actual param. Where, v is a machine variable, p is an
			// event parameter.
			// Removal occurs in autotasks of autotask-shared, or
			// environ of environ-shared communication.

			// But not removed in shared machines, which can have actions
			// involving parameters, w := q.
			// ... and not in Environ machines where Environ-task uses accept
			// statements,
			// with actions w := q. Where w is a machine variable and q is a
			// parameter.

			if (removeActionsWithParams) {
				// Only add the action if it does not have a parameter in it
				// add the parameter to a collection that we will use later in
				// iniValue declarations
				boolean actionHasParam = containsParameter(a.getAction(),
						actualSource.getParameters());
				if (!actionHasParam) {
					actions.add((org.eventb.codegen.il1.Action) actionTranslation);
				}
			} else {
				// add the action even if it has a parameter in it
				actions.add((org.eventb.codegen.il1.Action) actionTranslation);
			}
		}

		int paramNumber = 0; // maybe useful for working out or confirming
								// the order of parameters later on
		EList<Parameter> params = actualSource.getParameters();
		ArrayList<String> pNames = new ArrayList<String>();
		for (Parameter p : params) {
			pNames.add(p.getName());
		}

		// Process parameters here
		for (Parameter p : params) {
			String type = getType(p, actualSource.getGuards());
			// get the parameters that appear in guards
			String[] pvmGuards = getParameterVariableMatchFromGuards(p,
					actualSource.getGuards());
			// get the parameters that appear in actions
			String[] pvmActions = getParameterVariableMatchFromActions(p,
					actualSource.getActions());

			org.eventb.codegen.il1.Parameter il1Param = null;
			// if this parameter appears in a guard and it is typed in the guard
			if (pvmGuards != null && pvmGuards.length == 2) {
				String identifier = "";
				// It must be an 'out' parameter
				il1Param = Il1Factory.eINSTANCE.createOutParameter();

				String newActionString = "";

				// Parameter could be on left or right
				if (pvmGuards[0].trim().equals(p.getName().trim())) {
					if (eqToAss) {
						identifier = pvmGuards[0].trim();
						newActionString = identifier + " " + ASSIGNMENT_SYMBOL
								+ " " + pvmGuards[1].trim();
					} else {
						identifier = pvmGuards[1].trim();
					}
				} else {
					if (eqToAss) {
						identifier = pvmGuards[1].trim();
						newActionString = identifier + " " + ASSIGNMENT_SYMBOL
								+ " " + pvmGuards[0].trim();
					} else {
						identifier = pvmGuards[0].trim();
					}
				}

				if (newActionString != null && newActionString.length() > 0) {
					org.eventb.codegen.il1.Action a = translationManager
							.getIL1Factory().createAction();
					a.setAction(newActionString);
					actions.add(a);
				}

				il1Param.setIdentifier(identifier);
				il1Param.setOrderNumber(paramNumber);
				il1Param.setType(type);
				il1Param.setProjectName(translationManager
						.getProjectName(parentMachine));
				actualTarget.getFormalParameters().add(il1Param);
			} else if (pvmActions != null && pvmActions.length == 2) {
				// else if the parameter appears in the actions
				String identifier = "";

				// A guard in the actions means that it is an 'in' parameter
				il1Param = Il1Factory.eINSTANCE.createInParameter();

				// Parameter will be on right rhs

				if (removeActionsWithParams) {
					// This will be a call to something, so use the actual
					// parameter
					identifier = pvmActions[0].trim();
				} else {
					// This will be a function definition, so use the parameter
					// name
					identifier = pvmActions[1].trim();
				}

				il1Param.setIdentifier(identifier);
				il1Param.setOrderNumber(paramNumber);
				il1Param.setType(type);
				il1Param.setProjectName(translationManager
						.getProjectName(parentMachine));
				actualTarget.getFormalParameters().add(il1Param);
			} else {
				System.out.println("EventTaskingTranslator: Parameter "
						+ p.getName() + " not matched to variable "
						+ " in Event " + actualSource.getName());
			}

			paramNumber++;
		}

		
//		Command commands = orderActions(actions);
//		actualTarget.setBody(commands);

		// Do guards
		// Guards are not translated in ProcedureSynch events, since they
		// are only
		// used to type the in and out parameters.
		// Guards in procedureDef events map to conditions that represent
		// blocking
		// structures in the implementations (and therefore should not
		// appear in any
		// subroutines arising from tasking events)

		// NEW: Add guards regardless, let whatever called the translation
		// work out where to put them
		String randact = "";
		
		for (Guard g : actualSource.getGuards()) {
			// if the guard is a typing predicate then we ignore it,
			// since it has
			// no practical use in the implementation, go to the next
			// guard.
			if (g.getPredicate().contains(ELEMENT_OF)) {
				if(isRandom(g))
				{
					randact = g.getPredicate();
				}
				
				continue;
			}

			// Don't put into the IL1 any guards with parameters in them
			if (!containsParameter(g.getPredicate(),
					actualSource.getParameters())) {
				// Not using guard translator
				String guard = g.getPredicate();
				actualTarget.getGuards().add(guard);
			}
		}
		
		if(randact != "")
		{
			String[] r = randact.split(ELEMENT_OF);
			String lhs = r[0];
			String[] rhs = r[1].split(RodinKeyboardCore.translate("\\upto"));
			String min = rhs[0];
			String max = rhs[1];
			//String act = lhs.trim() + " " + ASSIGNMENT_SYMBOL + " RAND(" + min.trim() + ", " + max.trim() + ")"; 
			String act = "LOCALVAR_" + lhs.trim() + " " + ASSIGNMENT_SYMBOL + r[1]; 
			org.eventb.codegen.il1.Action aa = translationManager
					.getIL1Factory().createAction();
			aa.setAction(act);
			actions.add(0, aa);
			//actions.add(aa);
		}
		
		
		Command commands = orderActions(actions);
		actualTarget.setBody(commands);

		return actualTarget;
	}

	private boolean isRandom(Guard g) {
		String upto = RodinKeyboardCore.translate("\\upto");
		if(g.getPredicate().contains(upto))
			return true;
		else
			return false;
	}

	public boolean isSensingEvent(Event e) {
		ImplementationTypeEnum type = getImplementationType(e);

		return type == ImplementationTypeEnum.SENSING;
	}

	public boolean isActuatingEvent(Event e) {
		ImplementationTypeEnum type = getImplementationType(e);

		return type == ImplementationTypeEnum.ACTUATING;
	}

	public boolean isProcedureDefEvent(Event e) {
		ImplementationTypeEnum type = getImplementationType(e);

		return type == ImplementationTypeEnum.PROCEDURE_DEF;
	}

	public boolean isProcedureSynchEvent(Event e) {
		ImplementationTypeEnum type = getImplementationType(e);

		return type == ImplementationTypeEnum.PROCEDURE_SYNCH;
	}

	public ImplementationTypeEnum getImplementationType(Event e) {
		for (AbstractExtension ext : e.getExtensions()) {
			if (ext instanceof Implementation) {
				return ((Implementation) ext).getImplementationType();
			}
		}

		return null;
	}

	public static boolean hasActualInParam(Action action, Event sourceEvent) {
		ArrayList<String> actualInNames = new ArrayList<String>();
		for (Parameter p : sourceEvent.getParameters()) {
			for (AbstractExtension e : p.getExtensions()) {
				if (e instanceof ParameterType) {
					if (((ParameterType) e).getParameterType() == ParameterTypeEnum.IN) {
						actualInNames.add(p.getName());
					}
				}
			}
		}

		// Iterate through the names and return true if an actualIn parameter
		// name is found
		// in the action string or else false
		for (String s : actualInNames) {
			if (action.getName() == s) {
				return true;
			}
		}

		return false;
	}

	public static boolean hasOutParam(Event e) {
		for (Guard g : e.getGuards()) {
			if (hasOutParam(e, g))
				return true;
		}

		return false;
	}

	public static boolean hasOutParam(Event e, Guard g) {
		ArrayList<String> eventOutParamNames = new ArrayList<String>();
		for (Parameter p : e.getParameters()) {
			boolean added = false; // For efficiency - only add once per
									// parameter
			for (AbstractExtension ext : p.getExtensions()) {
				if (!added) {
					if (ext instanceof ParameterType) {
						switch (((ParameterType) ext).getParameterType()) {
						case OUT:
						case IN:
							added = true;
							eventOutParamNames.add(p.getName());
							break;
						default:
							// Do nothing
							break;
						}
					}
				}
			}
		}

		// iterate through the names and return true if a formalOut parameter
		// name is found
		// in the predicate string or else false
		for (String name : eventOutParamNames) {
			if (!(g.getPredicate().indexOf(name) == -1)) {
				return true;
			}
		}

		return false;
	}

	public List<String> actionsToCommandSet(EList<Action> actions,
			Event sourceEvent) {
		List<String> commands = new ArrayList<String>();

		for (Action a : actions) {
			// If the action has an actual parameter it is not created
			if (!hasActualInParam(a, sourceEvent)) {

			}
		}

		return commands;
	}

	public Command orderActions(ArrayList<org.eventb.codegen.il1.Action> actions) {

		// Put together into one command to return
		if (actions.size() == 1) {
			// Just return the action
			return actions.get(0);
		} else if (actions.size() > 1) {
			// Put them in a seq in the order they appear
			Seq seqTop = Il1Factory.eINSTANCE.createSeq();
			seqTop.setLeftBranch(actions.get(0));

			Seq next = seqTop;

			for (int i = 1; i < actions.size(); i++) {
				if (i + 1 < actions.size()) {
					// Produce a new seq
					Seq newSeq = Il1Factory.eINSTANCE.createSeq();
					newSeq.setLeftBranch(actions.get(i));
					next.setRightBranch(newSeq);
					next = newSeq;
				} else {
					// finish the current seq
					next.setRightBranch(actions.get(i));
				}
			}

			return seqTop;
		} else {
			return null;
		}
	}

	@Override
	public boolean canStoreTranslationInTranslationManager() {
		return !wasProxy;
	}

	protected boolean isTemporary(Event e) {
		for (AbstractExtension ext : e.getExtensions()) {
			if (ext instanceof Implementation) {
				ImplementationTypeEnum iType = ((Implementation) ext)
						.getImplementationType();
				// A procedure definition is not temporary
				if (iType == ImplementationTypeEnum.PROCEDURE_DEF) {
					return false;
				}

				if (iType == ImplementationTypeEnum.SENSING
						|| iType == ImplementationTypeEnum.ACTUATING) {
					return false;
				}

				if (iType == ImplementationTypeEnum.PROCEDURE_SYNCH) {
					// a procedure synch with out params is not temporary
					if (EventTaskingTranslator.hasOutParam(e)) {
						return false;
					}
					// a procedureSynch with actions is not temporary
					else if (e.getActions().size() > 0) {
						return false;
					}
					// case procedureSynch with no actions is temporary
					return true;
				}
			} else {
				// other implementations such as branch, loop, etc. are
				// temporary
				return true;
			}
		}

		// so we have no `Implementation extension` so the default is to
		// implement.
		// Maybe flag a warning here !!
		return false;
	}

	boolean isSharedMachine(Event event) {
		Machine m = (Machine) event.eContainer();

		for (AbstractExtension ae : m.getExtensions()) {
			if (ae instanceof Shared_Machine) {
				return true;
			}
		}

		return false;
	}

	boolean isEnvironMachine(Event event) {
		Machine m = (Machine) event.eContainer();

		for (AbstractExtension ae : m.getExtensions()) {
			if (ae instanceof Environ_Machine) {
				return true;
			}
		}

		return false;
	}

	String getType(Parameter p, EList<Guard> guards) {
		String type = "";
		String pName = p.getName();

		// CJL updated 24/04/2012
		// This now finds the guard where the typing flag has been set, not just
		// ELEMENT_OF
		for (Guard g : guards) {

			if (isTypingGuard(g)) {
				String gStr = g.getPredicate().trim();

				if (gStr.startsWith(pName + " ")
						|| gStr.startsWith(pName + ELEMENT_OF)) {
					if (gStr.contains(ELEMENT_OF)) {
						int idx = gStr.indexOf(ELEMENT_OF);
						type = gStr.substring(idx + 1);
						break;
					}
				}
			}
		}
		return type;
	}

	/**
	 * Returns true if the typing flag has been set.
	 * 
	 * @param g
	 * @return
	 */
	public boolean isTypingGuard(Guard g) {
		Attribute a = g.getAttributes().get(
				CodeGenTasking.TYPING_ATTRIBUTE_IDENT);

		if (a != null) {
			if (a.getValue().equals("Typing")) {
				return true;
			}
		}

		return false;
	}
	

	/**
	 * Returns the guard where the parameter is linked to a variable
	 * 
	 * IMPORTANT: ANY CHANGES HERE SHOULD BE REFLECTED IN
	 * TaskBodyValidatorModule in org.eventb.codegen.ui.validation
	 * 
	 * @param p
	 * @param guards
	 * @return
	 */
	String[] getParameterVariableMatchFromGuards(Parameter p,
			EList<Guard> guards) {
		String pName = p.getName().trim();

		for (Guard g : guards) {
			if (g.getPredicate().contains(EQUALS_SYMBOL)) {
				String[] parts = g.getPredicate().split(EQUALS_SYMBOL);

				for (String s : parts) {
					if (s.trim().equals(pName)) {
						return parts;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Returns the string where the parameter is equated to the actual parameter
	 * 
	 * IMPORTANT: ANY CHANGES HERE SHOULD BE REFLECTED IN
	 * TaskBodyValidatorModule in org.eventb.codegen.ui.validation
	 * 
	 * @param p
	 *            The parameter to find *
	 * @param actions
	 *            The actions to search
	 * @return lhs and rhs components
	 */
	String[] getParameterVariableMatchFromActions(Parameter p,
			EList<Action> actions) {
		String pName = p.getName().trim();

		for (Action a : actions) {
			if (a.getAction().contains(ASSIGNMENT_SYMBOL)) {
				String[] parts = a.getAction().split(ASSIGNMENT_SYMBOL);

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

	private boolean containsParameter(String q, EList<Parameter> parameters) {
		q = q.trim();
		String[] pSplit1 = q.split(EQUALS_SYMBOL);
		String[] pSplit2 = q.split(ASSIGNMENT_SYMBOL);

		if (pSplit1 != null && pSplit1.length == 2) {
			pSplit1[0] = pSplit1[0].trim();
			pSplit1[1] = pSplit1[1].trim();

			for (Parameter p : parameters) {
				if (p.getName().trim().equals(pSplit1[0])
						|| p.getName().trim().equals(pSplit1[1])) {
					return true;
				}
			}
		}

		if (pSplit2 != null && pSplit2.length == 2) {
			pSplit2[0] = pSplit2[0].trim();
			pSplit2[1] = pSplit2[1].trim();

			for (Parameter p : parameters) {
				if (p.getName().trim().equals(pSplit2[0])
						|| p.getName().trim().equals(pSplit2[1])) {
					return true;
				}
			}
		}

		return false;
	}

//	private ArrayList<String> getParameters(String q,
//			EList<Parameter> parameters) {
//		ArrayList<String> paramList = new ArrayList<String>();
//		q = q.trim();
//		String[] pSplit1 = q.split(EQUALS_SYMBOL);
//		String[] pSplit2 = q.split(ASSIGNMENT_SYMBOL);
//
//		if (pSplit1 != null && pSplit1.length == 2) {
//			pSplit1[0] = pSplit1[0].trim();
//			pSplit1[1] = pSplit1[1].trim();
//
//			for (Parameter p : parameters) {
//				if (p.getName().trim().equals(pSplit1[0])
//						|| p.getName().trim().equals(pSplit1[1])) {
//					paramList.add(p.getName().trim());
//				}
//			}
//		}
//
//		if (pSplit2 != null && pSplit2.length == 2) {
//			pSplit2[0] = pSplit2[0].trim();
//			pSplit2[1] = pSplit2[1].trim();
//
//			for (Parameter p : parameters) {
//				if (p.getName().trim().equals(pSplit2[0])
//						|| p.getName().trim().equals(pSplit2[1])) {
//					paramList.add(p.getName().trim());
//				}
//			}
//		}
//
//		return paramList;
//	}
	
}
