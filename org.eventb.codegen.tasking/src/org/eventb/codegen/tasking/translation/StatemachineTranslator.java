package org.eventb.codegen.tasking.translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.RodinToEMFConverter;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.impl.MachineImpl;

import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.Final;
import ac.soton.eventb.statemachines.Initial;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Transition;
import ac.soton.eventb.statemachines.impl.InitialImpl;
import ac.soton.eventb.statemachines.impl.StatemachineImpl;

import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.CompositeControlFactory;
import compositeControl.EventWrapper;
import compositeControl.SubBranch;

public class StatemachineTranslator extends AbstractTaskingTranslator {


	@Override
	public Call translate(EventBElement source, IL1Element actualTarget,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {
		
		// Get the state machine.
		StatemachineImpl statemachine = (StatemachineImpl) source;
		MachineImpl parentMachine = TaskingTranslationManager
				.getParentMachine(statemachine);

		// Is this marked as an environment state-machine (thus requiring
		// non-deterministic do-nothing transitions). We will see if a
		// comment has been appended to the state machine.
		// we can add a 'proper' attribute to state-machines to guide the
		// code generator, at a later date.
		boolean isEnvironStateMachine = false;
		String comment = statemachine.getComment();
		if (comment != null
				&& comment.toLowerCase().startsWith("environment simulation")) {
			isEnvironStateMachine = true;
		}

		// Add an enumeration containing the state information
		Enumeration stateEnum = Il1Factory.eINSTANCE.createEnumeration();
		String stateMachineName = statemachine.getName();
		stateEnum.setIdentifier(statemachine.getName() + "_STATES");
		EList<String> stateLiterals = stateEnum.getLiteralValues();
		// a flag that will be set to add a final state to the list of states
		boolean requiresFinalState = false;

		// It is useful to have a map of stateNames to a list of outgoing events
		Map<String, List<Event>> stateEventMap = new HashMap<String, List<Event>>();

		// Get the names of the states from the nodes.
		EList<AbstractNode> nodes = statemachine.getNodes();
		List<String> stateNames = new ArrayList<String>();

		// Keep a count of the branches in each case statement
		Map<String, Integer> caseStatementBranchCountMap = new HashMap<String, Integer>();

		for (AbstractNode node : nodes) {
			int branchCount = 0;

			if (node instanceof Initial) {
				// ignore the initialisation
				// stateNames.add(s.getName() + "_init");
			} else if (node instanceof State) {
				State si = (State) node;
				String stateName = si.getName();
				stateNames.add(stateName);

				EList<Transition> outGoing = si.getOutgoing();
				// add the events of the outgoing transition to the hashmap
				branchCount = branchCount + outGoing.size();

				List<Event> eventList = new ArrayList<Event>();
				for (Transition t : outGoing) {
					EList<Event> events = t.getElaborates();
					// sometimes we obtain a proxy which will need to be
					// resolved
					for (Event event : events) {
						if (event.eIsProxy()) {
							event = (Event) EcoreUtil.resolve(event,
									RodinToEMFConverter.machineResSet);
						}
						// add this event to the list of transition elaborates
						// events
						// these events do not need to be constructed in
						// machines
						if (!TaskingTranslationManager.elaboratesNamesList
								.contains(event.getName())) {
							TaskingTranslationManager.elaboratesNamesList
									.add(event.getName());
						}
						eventList.add(event);
						translationManager.getEventTargMap().put(event,
								t.getTarget());

						// this is where we store the link between the event and
						// the statemachine
						// that has a transition that elaborates it.
						TaskingTranslationManager.getEvent_SM_Map().put(event,
								stateMachineName);
					}
				}
				stateEventMap.put(stateName, eventList);

				if (isEnvironStateMachine) {
					caseStatementBranchCountMap.put(stateName, branchCount);
					TaskingTranslationManager.getStateMachineBranchCountMap()
							.put(stateMachineName, caseStatementBranchCountMap);
					// add the parent machine to the list if
					// environStateMachines
				}

			} else if (node instanceof Final) {
				requiresFinalState = true;
			}
		}

		// add the state names that have been identified for enumeration
		for (String name : stateNames) {
			stateLiterals.add(name);
		}
		// add a final state if required
		String finalState = null;
		if (requiresFinalState) {
			finalState = statemachine.getName() + "Final";
			stateLiterals.add(finalState);
		}

		String projectName = translationManager
				.getProjectName((MachineImpl) parentMachine);
		stateEnum.setComponentName(parentMachine.getName());
		stateEnum.setProjectName(projectName);
		Program program = translationManager.getProgram();

		// non-initial transitions relate to cases statements, find the first
		// transition
		// so we can initialise the variable.
		EList<Transition> transitions = statemachine.getTransitions();
		for (Transition transition : transitions) {
			AbstractNode initialNode = null;
			// The initial transition is handled separately
			if (transition.getSource() instanceof InitialImpl) {
				initialNode = transition.getTarget();
				String rawPathString = initialNode
						.getReference();
				Path p = new Path(rawPathString.replace(".",
						String.valueOf(Path.SEPARATOR)));
			}
		}

		// create a new case statement for the subroutine
		Case caseContainer = Il1Factory.eINSTANCE.createCase();

		caseContainer.setCaseExpression(statemachine.getName());
		for (String currentStateName : stateNames) {
			// for each state in the statemachine add a case.
			CaseStatement caseStatement = Il1Factory.eINSTANCE
					.createCaseStatement();
			caseStatement.setCaseValue(currentStateName);
			caseContainer.getCaseStatement().add(caseStatement);
			// The next state update statement : initialised to the
			// state-machine name
			String nextStateStatement = statemachine.getName();

			// Each outgoing transition of a state, may have event elaborations.
			// We have a branch for each event of an outgoing transition.
			// The guard maps to a condition, and actions to updates
			// Each transition is associated with 'guards+state'
			// First: get the events associated with outgoing transitions of the
			// named state.
			List<Event> events = stateEventMap.get(currentStateName);
			// if there are no events then no further action is required for
			// this state since there are no outgoing transitions
			if (events == null || events.size() == 0) {
				break;
			} else if (events.size() == 1 && !isEnvironStateMachine) {
				// if there is just one outgoing transition then there are no
				// branch options within the case itself, just output the action
				// with the next state statement appended.
				Event event = events.get(0);

				// we modify this event, so add this to the list of events that
				// need
				// to be translated, rather than recovered from the first-pass
				// store.
				translationManager.getDoNotRecoverPreviousTranslationList()
						.add(event);

				Subroutine subroutine = (Subroutine) translationManager
						.translate(event);
				Command originalBody = subroutine.getBody();
				// the next statement can be obtained from the event
				AbstractNode targetNode = translationManager.getEventTargMap()
						.get(event);
				if (targetNode instanceof Final) {
					nextStateStatement = nextStateStatement
							+ CodeGenTaskingUtils.ASSIGNMENT_SYMBOL + " "
							+ finalState;
				} else if (targetNode instanceof State) {
					// targetNode instance of State
					State state = (State) targetNode;
					nextStateStatement = nextStateStatement + " "
							+ CodeGenTaskingUtils.ASSIGNMENT_SYMBOL + " "
							+ state.getName();
				}

				// If we have a guard other than the existing case guard
				// and typing guards we need to add a branch.
				// so filter out these guards
				EList<Guard> guards = event.getGuards();
				// remove any typing guards
				List<Guard> cleanedUpGuards = new ArrayList<Guard>();
				for (Guard g : guards) {
					String predicate = g.getPredicate();
					predicate = CodeGenTaskingUtils
							.makeSingleSpaceBetweenElements(predicate);
					String casePredicate = stateMachineName + " = "
							+ currentStateName;
					if (predicate.equals(casePredicate)) {
						// if we have encountered the case predicate then ignore
						// it
						break;
					} else if (!predicate
							.contains(CodeGenTaskingUtils.ELEMENT_OF)) {
						cleanedUpGuards.add(g);
					}
				}

				If newBranch = null;
				if (cleanedUpGuards.size() > 0) {
					newBranch = Il1Factory.eINSTANCE.createIf();
					for (Guard g : cleanedUpGuards) {
						String predicate = g.getPredicate();
						newBranch.getCondition().add(predicate);
					}
				}
				// if there is no body, add just the state update statement
				if (originalBody == null) {
					Action newAction = Il1Factory.eINSTANCE.createAction();
					newAction.setAction(nextStateStatement);
					if (newBranch == null) {
						// there are no actions in the original body, and no
						// branch
						caseStatement.setCommand(newAction);
					} else {
						// there are no actions in the original body, and a
						// branch
						newBranch.setBody(newAction);
						caseStatement.setCommand(newBranch);
					}
				} else {
					// else there was an original body
					// - create a new seq to contain the new update statement
					// but only if the nextStatement is not already in the
					// actions
					EList<org.eventb.emf.core.machine.Action> actionList = event
							.getActions();
					List<String> actStrings = new ArrayList<String>();
					for (org.eventb.emf.core.machine.Action action : actionList) {
						actStrings.add(action.getAction().trim());
					}

					// if the action string list DOES NOT contain the
					// nextStateStatement we must add it
					if (!(actStrings.contains(nextStateStatement))) {

						org.eventb.codegen.il1.Seq newSeq = Il1Factory.eINSTANCE
								.createSeq();
						newSeq.setLeftBranch(originalBody);
						Action newAction = Il1Factory.eINSTANCE.createAction();
						newAction.setAction(nextStateStatement);
						newSeq.setRightBranch(newAction);

						if (newBranch == null) {
							// there are actions in the original body, and no
							// branch
							caseStatement.setCommand(newSeq);
						} else {
							// there are actions in the original body, and a
							// branch
							newBranch.setBody(newSeq);
							caseStatement.setCommand(newBranch);
						}
					}
					else {
						// the list of actions DOES contain the
						// nextStateStatement, no need to add it
						// just use original body
						
						if (newBranch == null) {
							caseStatement.setCommand(originalBody);
						} else {
							newBranch.setBody(originalBody);
							caseStatement.setCommand(newBranch);
						}
						
					}
					
					
				}
			} else if (events.size() > 1 || isEnvironStateMachine) {
				// Else if there is more than one outgoing transition, or
				// it is an environMachine - possibly with one transition - but
				// maybe more.
				// Create a temporary Tasking Event-B branch and translate this
				// using the existing TEB-IL1 translator.
				Branch branch = CompositeControlFactory.eINSTANCE
						.createBranch();
				// on the first iteration there is no parent
				CompositeControl parent = null;
				// if there are associated events
				boolean first = true;
				for (Event event : events) {
					// We need to add a branch to the code:
					// evt1: if g = true then a ; sm_state = B end.
					// The next state is stored in a Map of (Event X State),
					// generated above.

					// we modify this event, so add this to the list of events
					// that need
					// to be translated rather than recovered from the
					// first-pass store.
					translationManager.getDoNotRecoverPreviousTranslationList()
							.add(event);

					// we will first remove the unwanted guards from the events
					// We can remove a controller variable from the condition
					EList<Guard> guards = event.getGuards();
					int idx = -1;
					boolean found = false;
					for (Guard guard : guards) {
						idx++;
						String predicate = CodeGenTaskingUtils
								.makeSingleSpaceBetweenElements(guard
										.getPredicate());
						String casePredicate = stateMachineName + " = "
								+ currentStateName;
						if (predicate.equals(casePredicate)) {
							found = true;
							break;
						}
					}
					if (found) {
						guards.remove(idx);
					}

					if (first) {
						EventWrapper wrapper = CompositeControlFactory.eINSTANCE
								.createEventWrapper();
						first = false;
						wrapper.setEvent(event);
						branch.setEventWrapper(wrapper);
						// this first time - the branch is the parent
						parent = branch;
						if (isEnvironStateMachine) {
							branch.setEnvirStateMachineChild(true);
						}
					} else {
						EventWrapper wrapper = CompositeControlFactory.eINSTANCE
								.createEventWrapper();
						wrapper.setEvent(event);
						SubBranch subBranch = CompositeControlFactory.eINSTANCE
								.createSubBranch();
						subBranch.setEventWrapper(wrapper);

						if (parent instanceof Branch) {
							// set the parent's subBranch
							Branch parentBranch = (Branch) parent;
							parentBranch.setSubBranch(subBranch);
							// the new parent is now the subBranch
							parent = subBranch;
						} else if (parent instanceof SubBranch) {
							SubBranch parentSubBranch = (SubBranch) parent;
							parentSubBranch.setSubBranch(subBranch);
							parent = subBranch;
						}
						// If the subbranch is part of an environ state-machine
						// then
						// assign the state-machine true attribute to the
						// subbranch.
						if (isEnvironStateMachine) {
							subBranch.setEnvirStateMachineChild(true);
						}
					}
				}
				// If a branch is part of an environ state-machine then
				// we will need to add a randomizer so we note that this 'case'
				// will be non-deterministic
				if (isEnvironStateMachine) {
					List<String> ndSMList = TaskingTranslationManager
							.getND_StateMachineList();
					if (!ndSMList.contains(stateMachineName)) {
						ndSMList.add(stateMachineName);
					}
				}

				// THIS IS WHERE THE CASE BRANCHING STRUCTURE IS TRANSLATED
				// We now have a temporary Event-B branch structure of the
				// outgoing transitions of the current state.
				// Translate this now to IL1...
				If translated = (If) translationManager.translate(branch);

				caseStatement.setCommand((Command) translated);
			}
		}

		// add the final state case - which has a 'null' action in the current
		// implementation. But, this will change if we have nested
		// state-machines
		// since we will need to transfer to an outside state.

		if (requiresFinalState) {
			CaseStatement caseStatement = Il1Factory.eINSTANCE
					.createCaseStatement();
			caseStatement.setCaseValue(finalState);
			caseContainer.getCaseStatement().add(caseStatement);
		}

		// Add the subroutines and decls to the protected/tasks
		Subroutine subroutine = Il1Factory.eINSTANCE.createSubroutine();
		subroutine.setMachineName(parentMachine.getName());
		subroutine.setName(statemachine.getName() + "stateMachine");
		subroutine.setProjectName(projectName);
		if (actualTarget instanceof Protected) {
			Protected p = (Protected) actualTarget;
			p.getSubroutines().add(subroutine);
		} else if (actualTarget instanceof Task) {
			Task t = (Task) actualTarget;
			t.getSubroutines().add(subroutine);
		}
		subroutine.setBody(caseContainer);

		// Now we should create and return the call to the subroutine
		Call call = Il1Factory.eINSTANCE.createCall();
		Subroutine subroutineCopy = EcoreUtil.copy(subroutine);
		call.setSubroutine(subroutineCopy);
		call.setMachineName(parentMachine.getName());
		call.setProjectName(projectName);

		return call;
	}
}
