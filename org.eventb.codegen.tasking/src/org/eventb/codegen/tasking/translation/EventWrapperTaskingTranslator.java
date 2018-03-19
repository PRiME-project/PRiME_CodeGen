//	MOVED to LocalEvent and RemoteEvent translators

package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.impl.MachineImpl;

import tasking.Shared_Machine;
import tasking.Task;
import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

import compositeControl.Branch;
import compositeControl.EventWrapper;
import compositeControl.SubBranch;

public class EventWrapperTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {
		EventWrapper actualSource = (EventWrapper) source; 
		Subroutine subroutineTarget = null;//(Subroutine) translationManager
		//		.translate(actualSource.getEvent());
		
		if(source.eContainer().eContainer() instanceof MachineImpl){
		Event evt = null;
		for(Event e :((MachineImpl)source.eContainer().eContainer()).getEvents())
		{
			if(e.getName().equals(((EventWrapper)source).getEventName()))
			{
				evt = e;
				subroutineTarget = (Subroutine) translationManager
							.translate(evt);
				break;
			}
		}
		}
		else
		{
			subroutineTarget = (Subroutine) translationManager
					.translate(actualSource.getEvent());

		}
		//
		// if this event is in the list of communicating events, we do not want to add it to
		// the task body
		List<Subroutine> communicatingSubroutines = translationManager.getCommunicatingSubroutines();
		if(communicatingSubroutines.contains(subroutineTarget)){return null;}
		
		IL1Element actualTarget = null;

		MachineImpl machine = TaskingTranslationManager
				.getParentMachine(source);

		// if there is no machine container, which is the case when translating
		// a state-machine,
		// then we see if the wrapper is contained in a branch.
		// If it is then we have a temporary branch, used for generating
		// case-branches for
		// state machine translations

		if ((actualSource.eContainer() instanceof Branch || actualSource
				.eContainer() instanceof SubBranch) && machine == null) {

			// Now do ini-value substitutions
			// Any variable that appears on right and left within an event or
			// event
			// synchronisation
			// should use the initial value of the variable on the right hand
			// side
			if (subroutineTarget.getBody() instanceof Seq) {
				Event event = actualSource.getEvent();
				ArrayList<String> actions = getActions((Seq) subroutineTarget
						.getBody());
				ArrayList<String> lrVars = getLeftRightElements(actions,
						subroutineTarget.getFormalParameters());
				Seq newSeq = updateRightHandSideEntry(event,
						(Seq) subroutineTarget.getBody(), lrVars);
				Machine parentMachine = TaskingTranslationManager
						.getParentMachine(event);
				createNewVariables(lrVars, parentMachine, translationManager);
				subroutineTarget.setBody(newSeq);
			}
			return subroutineTarget;
		}

		// Determine if the machine is a shared machine
		boolean isSharedMachine = false;
		if (machine != null) {
			for (EObject eObj : machine.eContents()) {
				if (eObj instanceof Task) {
					break;
				} else if (eObj instanceof Shared_Machine) {
					isSharedMachine = true;
					break;
				}
			}
		}

		if (machine != null && subroutineTarget != null) {
			String machineName = machine.getName();
			String projectName = translationManager.getProjectName(machine);

			// If this has been given a SharedMachine, then don't try and find
			// the local machine it is attached to.
			// This will occur later when the EventWrapper is translated.
			if (!isSharedMachine) {
				String eventName = ((Subroutine) subroutineTarget).getName();
				ComposedMachine cm = translationManager.getComposedMachine(
						projectName, machineName, eventName);
				if (cm == null) {
					// The subroutine is the element to return
					actualTarget = subroutineTarget;
				} else {
					// Create a LocalRemote object and work out the remote
					// subroutine
					LocalRemote lr = Il1Factory.eINSTANCE.createLocalRemote();
					lr.setLocalSubroutine(EcoreUtil.copy(subroutineTarget));

					// Figure out the RemoteEvent (Subroutine)
					ComposedEvent actualComposedEvent = null;

					boolean foundCE = false;
					for (ComposedEvent ce : cm.getComposesEvents()) {
						if (foundCE) { break;}
							for (CombinedEventMachine cem : ce
									.getCombinesEvents()) {
								if (cem.getMachineName().equals(machineName)
										&& cem.getEventName().equals(eventName)) {
									actualComposedEvent = ce;
									foundCE = true;
									break;
								}
							}
					}
					if (actualComposedEvent != null) {
						Protected p = null;
						EnvironTask e = null;
						String evtName = "";
						// Now we have the composed event, and we want to work out
						// which is the shared machine
						for (CombinedEventMachine cem : actualComposedEvent
								.getCombinesEvents()) {
							// This will return the associated protected
							IL1Element element = translationManager
									.translate(cem);

							if (element != null && element instanceof Protected) {
								p = (Protected) element;
								evtName = cem.getEventName();
							} else if (element != null
									&& element instanceof EnvironTask) {
								e = (EnvironTask) element;
								evtName = cem.getEventName();
							}
						}

						if (p != null) {
							for (Subroutine s : p.getSubroutines()) {
								if (s.getName().equals(evtName)) {
									// This is the subroutine
									lr.setRemoteSubroutine(EcoreUtil.copy(s));
									break;
								}
							}
						}
						if (e != null) {
							for (Subroutine s : e.getSubroutines()) {
								if (s.getName().equals(evtName)) {
									// This is the subroutine
									lr.setRemoteSubroutine(EcoreUtil.copy(s));
									break;
								}
							}
						}
					}

					actualTarget = lr;
				}
			} else {
				actualTarget = subroutineTarget;
			}
		}
		
		// PUT some FMU Handling code here ??? It's like a shared machine
		// but has a sequence in the task body

		// Now do ini-value substitutions
		// Any variable that appears on right and left within an event or event
		// synchronisation
		// should use the initial value of the variable on the right hand side
		if (actualTarget instanceof Subroutine) {
			Subroutine s = (Subroutine) actualTarget;

			// Body will either contain just an Action or a Seq of actions
			// Do nothing if it is an Action, as there will only be one of them
			if (s.getBody() instanceof Seq) {
				Event event = actualSource.getEvent();
				ArrayList<String> actions = getActions((Seq) s.getBody());
				ArrayList<String> lrVars = getLeftRightElements(actions,
						s.getFormalParameters());
				Seq newSeq = updateRightHandSideEntry(event, (Seq) s.getBody(),
						lrVars);
				createNewVariables(lrVars, actualSource, translationManager);
				((Subroutine) actualTarget).setBody(newSeq);
			}

		} else if (actualTarget instanceof LocalRemote) {
			LocalRemote lr = (LocalRemote) actualTarget;
			if (lr.getLocalSubroutine() != null) {
				iniValSubsSubroutine(lr.getLocalSubroutine(), actualSource,
						translationManager);

			}
		}
		return actualTarget;

	}

	private void iniValSubsSubroutine(Subroutine s, EventWrapper actualSource,
			TaskingTranslationManager translationManager) {
		Event event = actualSource.getEvent();
		if (s.getBody() instanceof Seq) {
			ArrayList<String> actions = getActions((Seq) s.getBody());
			ArrayList<String> lrVars = getLeftRightElements(actions,
					s.getFormalParameters());
			Seq originalSeq = (Seq) s.getBody();
			// Update seq based on actions only first
			Seq newSeq = updateRightHandSideEntry(event, originalSeq,
					s.getFormalParameters(), lrVars);
			createNewVariables(lrVars, actualSource, translationManager);
			s.setBody(newSeq);

		} else if (s.getBody() instanceof Action) {
			ArrayList<String> actions = new ArrayList<String>();
			actions.add(((Action) s.getBody()).getAction());

			// DEBUG: NOTE
			// Does this handle the case where we have parameters, and thus a
			// parametrised call???
			// This code does not seem to handle the case where this is so.
			ArrayList<String> lrVars = getLeftRightElements(actions,
					s.getFormalParameters());

			Seq tmpSeq = Il1Factory.eINSTANCE.createSeq();
			tmpSeq.setLeftBranch(s.getBody());
			// The lrVars will be the tokens to replace - but how can this be
			// determined without looking at the
			// formal parameters?
			Seq newSeq = updateRightHandSideEntry(event, tmpSeq,
					s.getFormalParameters(), lrVars);

			createNewVariables(lrVars, actualSource, translationManager);

			if (newSeq.getLeftBranch() instanceof Action
					&& newSeq.getRightBranch() == null) {
				s.setBody(newSeq.getLeftBranch());
			} else {
				s.setBody(newSeq);
			}
		}
	}

	private ArrayList<String> getActions(Seq seq) {
		ArrayList<String> actions = new ArrayList<String>();

		if (seq.getLeftBranch() instanceof Action) {
			actions.add(((Action) seq.getLeftBranch()).getAction());
		} else if (seq.getLeftBranch() instanceof Seq) {
			actions.addAll(getActions((Seq) seq.getLeftBranch()));
		}

		if (seq.getRightBranch() instanceof Action) {
			actions.add(((Action) seq.getRightBranch()).getAction());
		} else if (seq.getRightBranch() instanceof Seq) {
			actions.addAll(getActions((Seq) seq.getRightBranch()));
		}

		return actions;
	}

	/**
	 * Returns the name of any variables that appear on the left and right hand
	 * side of any action in the set given.
	 * 
	 * @param actions
	 * @param parameters
	 * @return
	 */
	private ArrayList<String> getLeftRightElements(ArrayList<String> actions,
			EList<Parameter> parameters) {
		ArrayList<String> lrVariables = new ArrayList<String>();

		ArrayList<String> lhs = new ArrayList<String>(); // contains all left
															// hand sides
		ArrayList<String> rhs = new ArrayList<String>(); // contains all right
															// hand sides

		// consider v := v+1 || op(v) which translates to ini_v := v; v:=
		// ini_v+1; op(ini_v);
		// the out parameter v acts as a rhs variable.
		// So we add parameter names to the rhs variable list, if a list of
		// parameters has been supplied.

		if (parameters != null) {
			for (Parameter param : parameters) {
				rhs.add(param.getIdentifier());
			}
		}

		// DEBUG NOTE it would appear that y := y + 1 || v := v + y is not being
		// process properly since
		// the rhs y is not added to the rhs list. Investigate

		// Get left hand sides first, this will contain the things being
		// assigned to
		// Assume split on assignment
		for (String s : actions) {
			String[] split = s.split(ASSIGNMENT_SYMBOL);

			if (split.length == 2) {
				String l = split[0].trim();
				String r = split[1].trim();

				// Only consider if left isn't contained in right of same
				// expression
				// Eg. if this is y := y + 1, then don't add rhs only lhs

				// DEBUG NOTE:
				// in the test example (that fails) v:= v + y.
				// If the rhs does not contain the assigned variable add the rhs
				// variable.
				// But here the rhs variable contains the assigned variable and
				// forgets
				// that y need to be added since the rhs = v + y
				ArrayList<String> rhsTokens = tokeniseRHS(r);
				lhs.add(l);

				// scan each rhs token, if it is not the same as the lhs token
				// then add it to the list
				// of variables that appear on the rhs
				for (String token : rhsTokens) {
					if (!token.equalsIgnoreCase(l)) {
						rhs.add(token);
					}
				}

				// if (!(rhsTokens.contains(l)))
				// {
				// rhs.add(r);
				// }
			}
		}

		// DEBUG NOTE:
		// so at this point we have a list lhs of variables appearing on the
		// left.
		// ... and we have a list rhs of variables:
		// where the lhs variable does not appear on the rhs

		// Now go through rhs
		for (String s : rhs) {
			ArrayList<String> tokens = tokeniseRHS(s);

			// If any token appears in the left hand side, add it to the
			// lrVariables
			for (String token : tokens) {
				if (lhs.contains(token) && !lrVariables.contains(token)) {
					lrVariables.add(token);
				}
			}
		}

		return lrVariables;
	}

	public static ArrayList<String> tokeniseRHS(String rhs) {
		rhs = rhs.trim();
		ArrayList<String> tokens = new ArrayList<String>();
		boolean buildingString = false;
		String currentToken = "";
		for (char c : rhs.toCharArray()) {
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
					|| (buildingString && (c >= '0' && c <= '9')) || (c == '_')) {
				// Part of a token
				buildingString = true;
				currentToken += c;
			} else {
				// Not part of a token

				if (buildingString) {
					// If was building a token, complete it
					tokens.add(currentToken);
					currentToken = "";
					buildingString = false;
				}
			}
		}

		// Catch any strings that were being built but not completed
		if (buildingString) {
			// If was building a token, complete it
			tokens.add(currentToken);
			currentToken = "";
			buildingString = false;
		}

		return tokens;
	}

	private Seq updateRightHandSideEntry(Event event, Seq s,
			EList<Parameter> parameters, ArrayList<String> tokensToReplace) {
		ArrayList<String> actionsToAddFromSeq = updateRightHandSideInternal(s,
				tokensToReplace);
		ArrayList<String> actionsToAddFromParams = updateRightHandSideInternal(
				parameters, tokensToReplace);

		ArrayList<String> actionsToAdd = new ArrayList<String>(
				actionsToAddFromSeq);
		for (String a : actionsToAddFromParams) {
			if (!actionsToAdd.contains(a)) {
				actionsToAdd.add(a);
			}
		}

		if (actionsToAdd.size() > 0) {
			Seq newTop = Il1Factory.eINSTANCE.createSeq();
			Seq currSeq = newTop;

			for (String action : actionsToAdd) {
				Action act = Il1Factory.eINSTANCE.createAction();
				act.setParentEventName(event.getName());
				act.setAction(action);

				if (currSeq.getLeftBranch() != null) {
					Seq newSeq = Il1Factory.eINSTANCE.createSeq();
					currSeq.setRightBranch(newSeq);
					currSeq = newSeq;
				}

				currSeq.setLeftBranch(act);
			}

			currSeq.setRightBranch(s);

			return newTop;
		} else {
			return s;
		}
	}

	/**
	 * Does ini-value subs on s, using a list of tokens to replace. Returns an
	 * updated sequence
	 * 
	 * @param s
	 * @param tokensToReplace
	 * @return
	 */
	private Seq updateRightHandSideEntry(Event event, Seq s,
			ArrayList<String> tokensToReplace) {
		ArrayList<String> actionsToAdd = updateRightHandSideInternal(s,
				tokensToReplace);

		if (actionsToAdd.size() > 0) {
			Seq newTop = Il1Factory.eINSTANCE.createSeq();
			Seq currSeq = newTop;

			for (String action : actionsToAdd) {
				Action act = Il1Factory.eINSTANCE.createAction();
				act.setParentEventName(event.getName());
				act.setAction(action);

				if (currSeq.getLeftBranch() != null) {
					Seq newSeq = Il1Factory.eINSTANCE.createSeq();
					currSeq.setRightBranch(newSeq);
					currSeq = newSeq;
				}

				currSeq.setLeftBranch(act);
			}

			currSeq.setRightBranch(s);

			return newTop;
		} else {
			return s;
		}
	}

	private ArrayList<String> updateRightHandSideInternal(
			EList<Parameter> parameters, ArrayList<String> tokensToReplace) {
		ArrayList<String> actionsToAdd = new ArrayList<String>();

		for (Parameter p : parameters) {
			String pStr = p.getIdentifier().trim();
			if (tokensToReplace.contains(pStr)) {
				String newToken = pStr + "InitialValue";
				p.setIdentifier(newToken);

				actionsToAdd.add(newToken + " " + ASSIGNMENT_SYMBOL + " "
						+ pStr);
			}
		}

		return actionsToAdd;
	}

	/**
	 * Updates the Seq with ini-value substitutions. Also returns any new
	 * actions that are required.
	 * 
	 * @param s
	 * @param tokensToReplace
	 * @return
	 */
	private ArrayList<String> updateRightHandSideInternal(Seq s,
			ArrayList<String> tokensToReplace) {
		ArrayList<String> actionsToAdd = new ArrayList<String>();
		if (s.getLeftBranch() instanceof Action) {
			// Update actions by replacing variableNames with IniValue versions,
			// where applicable.
			// Each new ini value will need an associated assignment
			// vInitialValue := v, which is returned
			ArrayList<String> newActions = updateAction(
					(Action) s.getLeftBranch(), tokensToReplace);

			for (String a : newActions) {
				a = a.trim();
				// if the list of new actions to add does not already contain
				// the action.
				if (!actionsToAdd.contains(a)) {
					actionsToAdd.add(a);
				}
			}
		} else if (s.getLeftBranch() instanceof Seq) {
			// Update actions by replacing variableNames with IniValue versions,
			// where applicable.
			// Each new ini value will need an associated assignment
			// vInitialValue := v, which is returned
			ArrayList<String> actions = updateRightHandSideInternal(
					(Seq) s.getLeftBranch(), tokensToReplace);
			for (String a : actions) {
				a = a.trim();
				// if the list of new actions to add does not already contain
				// the action.
				if (!actionsToAdd.contains(a)) {
					actionsToAdd.add(a);
				}
			}
		}

		if (s.getRightBranch() instanceof Action) {
			// Update actions by replacing variableNames with IniValue versions,
			// where applicable.
			// Each new ini value will need an associated assignment
			// vInitialValue := v, which is returned
			ArrayList<String> actions = updateAction(
					(Action) s.getRightBranch(), tokensToReplace);
			for (String a : actions) {
				a = a.trim();
				// if the list of new actions to add does not already contain
				// the action.
				if (!actionsToAdd.contains(a)) {
					actionsToAdd.add(a);
				}
			}
		} else if (s.getRightBranch() instanceof Seq) {
			// Update actions by replacing variableNames with IniValue versions,
			// where applicable.
			// Each new ini value will need an associated assignment
			// vInitialValue := v, which is returned
			ArrayList<String> actions = updateRightHandSideInternal(
					(Seq) s.getRightBranch(), tokensToReplace);

			for (String a : actions) {
				a = a.trim();
				// if the list of new actions to add does not already contain
				// the action.
				if (!actionsToAdd.contains(a)) {
					actionsToAdd.add(a);
				}
			}
		}
		return actionsToAdd;
	}

	/**
	 * Performs ini-value substitution on an action, and returns any new actions
	 * that are required
	 * 
	 * @param a
	 * @param tokensToReplace
	 * @return
	 */
	private ArrayList<String> updateAction(Action a,
			ArrayList<String> tokensToReplace) {
		ArrayList<String> actionsToAdd = new ArrayList<String>();

		String[] split = a.getAction().split(ASSIGNMENT_SYMBOL);

		if (split.length == 2) {
			String rhs = split[1].trim();

			// Update the action string
			boolean buildingString = false;
			String currentToken = "";
			String newActionString = split[0] + " " + ASSIGNMENT_SYMBOL + " ";
			for (char c : rhs.toCharArray()) {
				if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
						|| (buildingString && (c >= '0' && c <= '9'))
						|| (c == '_')) {
					// Part of a token
					buildingString = true;
					currentToken += c;
				} else {
					// Not part of a token

					if (buildingString) {
						// If was building a token, see if it is one to swap out
						// and swap it
						if (tokensToReplace.contains(currentToken)) {
							// Replace
							String newToken = currentToken + "InitialValue";
							newActionString += (currentToken + "InitialValue");

							actionsToAdd.add(newToken + " " + ASSIGNMENT_SYMBOL
									+ " " + currentToken);
						} else {
							newActionString += currentToken;
						}

						currentToken = "";
						buildingString = false;
					}

					newActionString += c;
				}
			}

			// Catch any final tokens
			if (buildingString) {
				// If was building a token, see if it is one to swap out and
				// swap it
				if (tokensToReplace.contains(currentToken)) {
					// Replace
					String newToken = currentToken + "InitialValue";
					newActionString += (currentToken + "InitialValue");

					actionsToAdd.add(newToken + " " + ASSIGNMENT_SYMBOL + " "
							+ currentToken);
				} else {
					newActionString += currentToken;
				}

				currentToken = "";
				buildingString = false;
			}

			a.setAction(newActionString);
		}

		return actionsToAdd;
	}

	/**
	 * Adds to the Machine a set of generated Invariant, Variable and
	 * INITIALSIATION events for any new variables created.
	 * 
	 * @param tokensToReplace
	 *            The original name of the variables that are being mapped to
	 *            variableInitialValue.
	 * @param eventWrapper
	 *            The event wrapper being translated.
	 * @param translationManager
	 *            The translation manager.
	 */
	private void createNewVariables(ArrayList<String> tokensToReplace,
			EventWrapper eventWrapper,
			TaskingTranslationManager translationManager) {
		// Get the machine the eventWrapper is in.
		EObject eObj = eventWrapper;
		while (!(eObj instanceof MachineImpl) && eObj.eContainer() != null)
			eObj = eObj.eContainer();

		if (eObj instanceof MachineImpl) {
			MachineImpl m = (MachineImpl) eObj;

			for (String originalName : tokensToReplace) {
				String newName = originalName + "InitialValue";

				// Make sure this variable hasn't already been added
				// Eg in branches it is possible the same ini-value substitution
				// could occur
				if (getTypingInvariant(newName, m.getInvariants()) == null) {

					// Find the Variable declaration for the original name
					Invariant i = getTypingInvariant(originalName,
							m.getInvariants());

					if (i != null) {
						Invariant iNew = MachineFactory.eINSTANCE
								.createInvariant();
						iNew.setGenerated(true);
						iNew.setPredicate(i.getPredicate().replace(
								originalName, newName));

						CodeGenTaskingUtils.addTaskingAttribute(iNew, true);

						m.getInvariants().add(iNew);

						Variable v = MachineFactory.eINSTANCE.createVariable();
						v.setGenerated(true);
						v.setName(newName);
						m.getVariables().add(v);
						// Event e = getInitialisation(m.getEvents());
					}
				}
			}
		} else {
			System.err
					.println("EventWrapperTaskingTranslator: createNewVariables - Machine not found");
		}
	}

	private void createNewVariables(ArrayList<String> tokensToReplace,
			Machine parentMachine, TaskingTranslationManager translationManager) {
		// Get the machine the eventWrapper is in.

		for (String originalName : tokensToReplace) {
			String newName = originalName + "InitialValue";

			// Make sure this variable hasn't already been added
			// Eg in branches it is possible the same ini-value substitution
			// could occur
			if (getTypingInvariant(newName, parentMachine.getInvariants()) == null) {

				// Find the Variable declaration for the original name
				Invariant i = getTypingInvariant(originalName,
						parentMachine.getInvariants());
				// Make sure this variable hasn't already been added
				// Eg in branches it is possible the same ini-value substitution
				// could occur
				if (i != null) {
					Invariant iNew = MachineFactory.eINSTANCE.createInvariant();
					CodeGenTaskingUtils.addTaskingAttribute(iNew, true);
					iNew.setGenerated(true);
					iNew.setPredicate(i.getPredicate().replace(originalName,
							newName));
					parentMachine.getInvariants().add(iNew);
					Variable v = MachineFactory.eINSTANCE.createVariable();
					v.setGenerated(true);
					v.setName(newName);
					parentMachine.getVariables().add(v);
					// Event e = getInitialisation(m.getEvents());
				}

			}
		}
	}

	private Invariant getTypingInvariant(String originalName,
			EList<Invariant> variables) {
		Invariant iOut = null;

		for (Invariant i : variables) {
			// Make sure it is a typing invariant
			Attribute a = i.getAttributes().get(
					CodeGenTasking.TYPING_ATTRIBUTE_IDENT);
			if (a != null && a.getValue().equals("Typing")) {

				String vName = i.getPredicate().trim();

				if (vName.startsWith(originalName + " ")
						|| vName.startsWith(originalName + ELEMENT_OF)) {
					return i;
				}
			}
		}

		return iOut;
	}
}
