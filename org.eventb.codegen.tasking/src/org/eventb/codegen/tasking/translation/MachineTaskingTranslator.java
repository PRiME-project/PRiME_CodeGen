package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_ELEMENT_IN;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.statemachines.StateMachineTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.codegen.tasking.utils.DeclarationList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.impl.ContextImpl;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.impl.MachineImpl;

import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.FMU_Machine;
import tasking.Implementation;
import tasking.ImplementationTypeEnum;
import tasking.Shared_Machine;
import tasking.Tasking_Machine;
import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

import compositeControl.CompositeControlFactory;
import compositeControl.EventWrapper;

/**
 * Machine translator.
 * 
 * Returns a Task for AutoTaskMachine,TaskMachine or EnvironMachine. Returns a
 * Protected for a SharedMachine.
 * 
 * @author Chris
 * 
 */
public class MachineTaskingTranslator extends AbstractTaskingTranslator {

	private enum MachineType {
		Tasking, Shared, Environ, FMU
	}

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {
		MachineImpl actualSource = (MachineImpl) source;
		
				
		String machineName = actualSource.getName();
		String projectName = translationManager.getProjectName(actualSource);

		boolean isSharedMachine = false;
		//boolean isFMUMachine = false;

		MachineType machineType = MachineType.Tasking;

		StateMachineTranslationManager stateMachineTranslationManager = new StateMachineTranslationManager();

		// Adjust generated elements, so that the typing flags are correctly set
		fixTypingFlagsForGenerateElements(actualSource);

		// Determine the type of machine this is
		for (EObject eObj : actualSource.eContents()) {
			if (eObj instanceof AutoTask_Machine
					|| eObj instanceof Tasking_Machine) {
				break;
			} else if (eObj instanceof Shared_Machine) {
				isSharedMachine = true;
				machineType = MachineType.Shared;
				break;
			} else if (eObj instanceof Environ_Machine) {
				machineType = MachineType.Environ;
				break;
			} /*else if (eObj instanceof FMU_Machine) {
				isFMUMachine = true;
				machineType = MachineType.FMU;
				break;
			}*/
		}

		if (isSharedMachine) {
			// This won't handle any synchronisation - this must be done by a
			// ComposedMachine
			Protected actualTarget = translationManager.getIL1Factory()
					.createProtected();
			actualTarget.setName(actualSource.getName());

			// Add constant declarations
			ArrayList<Declaration> cdecls = getDecls_EnumsConstants(
					actualSource, translationManager, machineName, projectName);
			for (Declaration d : cdecls) {
				translationManager.getConstantDeclNameMap().put(
						d.getIdentifier(), d);
			}

			// Add variable declarations?? and subroutines
			ArrayList<Subroutine> subroutines = getSubroutines(
					actualSource.getEvents(), translationManager,
					isSharedMachine, actualSource.getName(), machineType,
					actualSource);
			ArrayList<Declaration> declarations = getDeclarations(
					actualSource.getVariables(), actualSource.getInvariants(),
					actualSource.getEvents(), translationManager, machineName,
					projectName);

			actualTarget.getSubroutines().addAll(subroutines);
			actualTarget.getDecls().addAll(declarations);

			return actualTarget;
		}
		// End of isSharedMachine - Begin else isFMUMachine
		/*else if (isFMUMachine) {
			Protected actualTarget = null;

			for (AbstractExtension eObj : actualSource.getExtensions()) {
				if (eObj instanceof FMU_Machine) {
					// Add constant declarations
					ArrayList<Declaration> cdecls = getDecls_EnumsConstants(
							actualSource, translationManager, machineName,
							projectName);
					for (Declaration d : cdecls) {
						translationManager.getConstantDeclNameMap().put(
								d.getIdentifier(), d);
					}

					// Add variable declarations?? and subroutines
					ArrayList<Subroutine> subroutines = getSubroutines(
							actualSource.getEvents(), translationManager,
							isSharedMachine, actualSource.getName(),
							machineType, actualSource);
					ArrayList<Declaration> declarations = getDeclarations(
							actualSource.getVariables(),
							actualSource.getInvariants(),
							actualSource.getEvents(), translationManager,
							machineName, projectName);

					actualTarget = (Protected) translationManager
							.translate(eObj);
					actualTarget.getDecls().addAll(declarations);
				}
			}
			return actualTarget;
		}*/
		// End of isFMU - begin else ... that is,
		// else not an FMU or shared machine
		else {

			// EXTRACT INITIALISATION? - AS THEY WILL STATE INITIAL VALUES FOR
			// VARIABLES

			// Translate the events and put them in as subroutines
			// Do this first so that they can be referenced later on.
			ArrayList<VariableDecl> belongsPredicates = new ArrayList<VariableDecl>();

			ArrayList<Subroutine> subroutines = getSubroutines(
					actualSource.getEvents(), translationManager,
					isSharedMachine, actualSource.getName(), machineType,
					actualSource);

			Task actualTarget = null;
			// tasking.Task taskingMachine = null;

			// Find tasking specific entries - includes FMU translator
			// since we make use of the Task Body
			for (AbstractExtension eObj : actualSource.getExtensions()) {
				if (eObj instanceof AutoTask_Machine
						|| eObj instanceof Environ_Machine
						|| eObj instanceof Tasking_Machine
						|| eObj instanceof FMU_Machine) {
					// taskingMachine = (tasking.Task)eObj;
					actualTarget = (Task) translationManager.translate(eObj);
				}
			}

			if (actualTarget == null) {
				throw new TaskingTranslationException(
						"MachineTaskingTranslator: No tasking type specified for Machine - "
								+ actualSource);
			} else {
				// Set the name of the task
				actualTarget.setName(actualSource.getName());

				// statemachine translation.
				List<Call> smCalls = stateMachineTranslationManager.translate(
						actualSource, actualTarget, translationManager);

				// if there are any calls
				if (smCalls.size() > 0) {
					// get the exisiting body and add it as the right branch of
					// a new seq
					Command tmpBody = actualTarget.getBody();
					// get a single call or sequence of calls back
					Command newCommand = addToSeq(smCalls, tmpBody);
					// set the actualTarget body with the new command
					actualTarget.setBody(newCommand);
				}

				// We need to add a 'call' to each state-machine subroutine,
				// referred to in the
				// Main Entry Auto Task. Note that this is not related to the
				// state-machines of this
				// Auto Task : rather it refers to the 'Shared' Machines
				// referred to by the
				// Main Entry AutoTask.

				// Add the subroutines
				actualTarget.getSubroutines().addAll(subroutines);

				// Add the BelongsPredicate guards from the subroutines
				// This probably isn't doing anything as nothing is using
				// belongsPredicates by this point
				actualTarget.getDecls().addAll(belongsPredicates);

				// Add constant declarations
				ArrayList<Declaration> cdecls = getDecls_EnumsConstants(
						actualSource, translationManager, machineName,
						projectName);
				for (Declaration d : cdecls) {
					translationManager.getConstantDeclNameMap().put(
							d.getIdentifier(), d);
				}

				// Add variable?? declarations
				ArrayList<Declaration> declarations = getDeclarations(
						actualSource.getVariables(),
						actualSource.getInvariants(), actualSource.getEvents(),
						translationManager, machineName, projectName);
				actualTarget.getDecls().addAll(declarations);

				return actualTarget;
			}
		}
	}

	private Command addToSeq(List<Call> smCalls, Command tmpBody) {
		if (smCalls.size() == 0) {
			// case of no stateMachine calls
			return tmpBody;
		} else if (smCalls.size() == 1) {
			// case of the last state-machine call
			if (tmpBody != null) {
				// add the original body back in
				Seq newSeq = Il1Factory.eINSTANCE.createSeq();
				newSeq.setLeftBranch(smCalls.get(0));
				newSeq.setRightBranch(tmpBody);
				return newSeq;
			} else {
				// else there is no body, just return the last state-machine
				// call
				return smCalls.get(0);
			}
		} else {
			// else there are more state-machine calls which need to be
			// sequenced
			// remove and get the next call
			Call nextCall = smCalls.remove(0);
			Seq newSeq = Il1Factory.eINSTANCE.createSeq();
			// set the left branch as the next call
			newSeq.setLeftBranch(nextCall);
			// set the right branch to the subbranch recursively
			newSeq.setRightBranch(addToSeq(smCalls, tmpBody));
			return newSeq;
		}

	}

	/**
	 * Sets typing flags for generated elements, so that the whole thing doesn't
	 * crash.
	 * 
	 * @param actualSource
	 *            The machine being translated
	 */
	private void fixTypingFlagsForGenerateElements(MachineImpl actualSource) {
		// Check all invariants
		for (Invariant i : actualSource.getInvariants()) {
			// If this is a generated without typing attributes element
			if (i.isGenerated() && !CodeGenTaskingUtils.hasTypingAttribute(i)) {
				boolean typing = false;
				// Add the typing information to the invariant
				// if element_of or partition, it is a typing invariant
				if (i.getPredicate().contains(ELEMENT_OF)
						|| i.getPredicate().startsWith("partition")) {
					typing = true;
				}

				CodeGenTaskingUtils.addTaskingAttribute(i, typing);
			}
		}

		// Check all events
		for (Event e : actualSource.getEvents()) {
			for (org.eventb.emf.core.machine.Guard g : e.getGuards()) {
				if (g.isGenerated()
						&& !CodeGenTaskingUtils.hasTypingAttribute(g)) {
					boolean typing = false;

					// Add the typing information to the invariant
					// if element_of or partition, it is a typing invariant
					if (g.getPredicate().contains(ELEMENT_OF)
							|| g.getPredicate().startsWith("partition")) {
						typing = true;
					}

					CodeGenTaskingUtils.addTaskingAttribute(g, typing);
				}
			}
		}
	}

	// In this method we obtain all the declared enums and constants seen by the
	// machine.
	// We iterate through all the seen contexts and get the declarations.
	// The context translator, translate(ctx) is responsible for returning the
	// contents of extended contexts too.
	private ArrayList<Declaration> getDecls_EnumsConstants(
			MachineImpl actualSource,
			TaskingTranslationManager translationManager, String machineName,
			String projectName) throws TaskingTranslationException {
		ArrayList<ContextImpl> allContexts = translationManager.getContexts();

		EList<String> names = actualSource.getSeesNames();
		ArrayList<Declaration> cDecls = new ArrayList<Declaration>();

		for (Context ctx : allContexts) {
			if (names.contains(ctx.getName())) {
				DeclarationList d = (DeclarationList) translationManager
						.translate(ctx);
				cDecls.addAll(d.getDeclarations());
			}
		}

		return cDecls;
	}

	public static boolean isProcedureDefSynch(Event e) {
		for (AbstractExtension ext : e.getExtensions()) {
			if (ext instanceof Implementation) {
				ImplementationTypeEnum impType = ((Implementation) ext)
						.getImplementationType();

				if (impType == ImplementationTypeEnum.PROCEDURE_DEF) {
					return true;
				} else if (impType == ImplementationTypeEnum.PROCEDURE_SYNCH) {
					return true;
				}
			}
		}

		return false;
	}

	private ArrayList<Subroutine> getSubroutines(EList<Event> events,
			TaskingTranslationManager translationManager,
			boolean requiresSubroutines, String machineName,
			MachineType machineType, MachineImpl machine)
			throws TaskingTranslationException {

		ArrayList<Subroutine> subroutines = new ArrayList<Subroutine>();
		// a flag to be set for creating entries, since each subroutine entry
		// mapping,
		// in an environ machine, has to be calculated on an individual basis.
		boolean hasEntry = false;

		for (Event e : events) {
			EList<AbstractExtension> extList = e.getExtensions();
			// sensing and actuating code is not used at the moment, it can be
			// commented
			// out and left as a reference in case it is required in the future
			// boolean isSensingOrActuating = false;
			// for (AbstractExtension ext : extList) {
			// if (ext instanceof Implementation) {
			// Implementation impl = (Implementation) ext;
			// ImplementationTypeEnum implType = impl
			// .getImplementationType();
			// if ((implType == ImplementationTypeEnum.SENSING || implType ==
			// ImplementationTypeEnum.ACTUATING)
			// && machineType != MachineType.Tasking) {
			// isSensingOrActuating = true;
			// break;
			// }
			// }
			// }

			// only translate a subroutine if the event is not an elaboration
			if (!TaskingTranslationManager.elaboratesNamesList.contains(e
					.getName())) {
				Subroutine subroutine = (Subroutine) translationManager
						.translate(e);

				// Force ini-value substitutions on SharedMachines
				// Local machines happen automatically when their EventWrapper
				// is translated.
				if (machineType == MachineType.Shared) {
					// To force ini-value substituions on remote/shared machines
					EventWrapper ew = CompositeControlFactory.eINSTANCE
							.createEventWrapper();
					ew.setGenerated(true);
					machine.getExtensions().add(ew); // temporarily link them
					ew.setEvent(e);
					ew.setEventName(e.getName());	
					//Sadegh
					//subroutine = (Subroutine) translationManager.translate(ew);
					machine.getExtensions().remove(ew); // dereference this
														// temporary event
														// wrapper
				} else if (machineType == machineType.Environ) {
					// the environ machine will require the subroutine if it
					// is called (an entry, in Ada) by another task.
					// We can tell this if the event synchronizes with another
					// event.

					// Firstly we set requiresSubroutines to false, since we
					// will not
					// be using this to determine if an entry is required - we
					// use 'hasEntry' instead, which is set on a per-event
					// basis.
					requiresSubroutines = false;
					// Get the composed machine associated with the subroutine.
					if (subroutine != null) {
						ComposedMachine cm = translationManager
								.getComposedMachine(
										subroutine.getProjectName(),
										subroutine.getMachineName(),
										subroutine.getName());

						if (cm != null) {
							// Figure out the RemoteEvent (Subroutine)
							for (ComposedEvent ce : cm.getComposesEvents()) {
								for (CombinedEventMachine cem : ce
										.getCombinesEvents()) {
									if (cem.getMachineName().equals(
											subroutine.getMachineName())
											&& cem.getEventName().equals(
													subroutine.getName())) {
										// We have found the
										// composedEventMachine of the Event
										// (subroutine)
										EList<CombinedEventMachine> combinesEvents = ce
												.getCombinesEvents();
										// Search through combinedEvents
										for (CombinedEventMachine combinedEventMch : combinesEvents) {
											String callingMchName = combinedEventMch
													.getMachineName();
											// if the callingMachine is an
											// autoTask then this is
											// an environ entry, so add the
											// subroutine is required
											ArrayList<String> autoTaskMchNames = translationManager
													.getAutoTaskMachineNames();
											if (autoTaskMchNames
													.contains(callingMchName)) {
												// ok we finally find that an
												// entry is required
												hasEntry = true;
											}
										}
									}
								}
							}
						}
					}
				} else if (machineType == machineType.FMU && subroutine != null) {
					// handle the subroutines of the FMU here
					// There are only two types of composed events used in FMUs
					// 1 - events involved in communication with the master,
					// fmiGetXXX
					// 2 - XXX_fmiDoStep_n, events appearing in the task body
					// (doStepSequence)
					//
					ComposedMachine composedMachine = translationManager
							.getComposedMachine(
									translationManager.getProjectName(machine),
									machine.getName(), e.getName());

					if (composedMachine != null) {
						EList<ComposedEvent> composesEventList = composedMachine
								.getComposesEvents();
						// iterate through the list of synched events and see if
						// we can
						// find the event linked with the subroutine
						for (ComposedEvent composedEvt : composesEventList) {
							EList<CombinedEventMachine> combinesEventsList = composedEvt
									.getCombinesEvents();
							boolean match = false;
							for (CombinedEventMachine cem : combinesEventsList) {
								String tmpEventName = cem.getEventName();
								String tmpMachineName = cem.getMachineName();
								String tmpProjectName = cem.getProjectName();
								if (subroutine.getName().equals(tmpEventName)
										&& subroutine.getMachineName().equals(
												tmpMachineName)
										&& subroutine.getProjectName().equals(
												tmpProjectName)) {
									match = true;
									break;
								}
							}
							// if we have found the subroutine
							if (match) {
								// In an FMU, if there is only one element in
								// the combines list
								// (combinesEvents) then it doesn't combine with
								// anything actually,
								// so it cannot be a communicating event. For
								// this reason it is local and
								// will be expanded inline in translation of the
								// DOSTEP sequence.
								// It can be marked as temporary, for removal.
								if (composedEvt.getCombinesEvents().size() <= 1) {
									subroutine.setTemporary(true);
								}
							}
						}
					}
					// else we have an FMU without a composed machine - in which case we need to set requiresSubroutine
					// (it will require getters and setters)
					else{
						requiresSubroutines = true;
					}
				} 
				
				// add subroutines that are proceduredef, or that require
				// subroutines to be returned
				if (subroutine != null
						&& (isProcedureDefSynch(e) || requiresSubroutines
						// || isSensingOrActuating
						|| hasEntry)) { 
					subroutine.setMachineName(machineName);
					subroutines.add(subroutine);
				}
			}
			// reset the flag for the next event
			hasEntry = false;
		}

		return subroutines;
	}

	private ArrayList<Declaration> getDeclarations(EList<Variable> variables,
			EList<Invariant> invariants, EList<Event> events,
			TaskingTranslationManager translationManager, String machineName,
			String projectName) throws TaskingTranslationException {
		ArrayList<Declaration> declarations = new ArrayList<Declaration>();

		// Find the initialisation event
		Event initialisation = null;
		for (Event e : events) {
			if (e.getName().startsWith("INITIALISATION")) {
				initialisation = e;
				break;
			}
		}

		if (initialisation == null) {
			System.err.println("No INITIALISATION event found");
			throw new TaskingTranslationException(
					"No INITIALISATION event found");
		}

		for (Variable v : variables) {
			ArrayList<Invariant> possibleTypingInvariants = new ArrayList<Invariant>();
			//if(v.getComment() != null && v.getComment().contains("**out**"))
				//v.setName("outarg_" + v.getName());
			// ArrayList<String> uniqueInvariants -- This is used to keep track
			// of the unique invariants
			// (sometimes in decomposition you get two typing invariants the
			// same,
			// so for auto-selecting the typing invariant we want to ignore
			// duplicates and count them as one invariant).
			ArrayList<String> uniqueInvariants = new ArrayList<String>();
			VariableDecl d = (VariableDecl) translationManager.translate(v);
			// d.setVariableType(VariableTypeEnum.VARIABLE);
			d.setComponentName(machineName);
			d.setProjectName(projectName);

			// Find invariant with lhs the same as the variable
			String variableName = v.getName();
			for (Invariant i : invariants) {

				// CJL: 24/04/2012, adding typing check here. As only want
				// typing invariants.
				// Typing check was originally made later on in the all else
				// fails case,
				// but here it makes more sense and ignores anything that is not
				// a typing invariant.

				Attribute a = i.getAttributes().get(
						CodeGenTasking.TYPING_ATTRIBUTE_IDENT);

				if (a != null && a.getValue().equals("Typing")) {
					String predicate = i.getPredicate();

					// Typing invariants will contain 'element of'
					//Sadegh: It should not matter if variable name followed by space or not
					if ((predicate.startsWith(variableName + " ") || predicate
							.startsWith(variableName + ELEMENT_OF))
							&& predicate.contains(ELEMENT_OF)) {
						possibleTypingInvariants.add(i);

						if (!uniqueInvariants.contains(i.getPredicate().trim())) {
							uniqueInvariants.add(i.getPredicate().trim());
						}
					}
				}
			}

			// CJL: 24/04/2012 - note.
			// The possibleTypingInvariants will now 1 element,
			// as the static checks ensure each variable has one and only one
			// guard,
			// and no variable has mulitple guards.
			// Have left old elseif's in for now.

			// Work out which of the invariants is the typing invariant
			// If only 1 possible typing invariant, take that as the typing
			// invariant (while no editor available)
			if (possibleTypingInvariants.size() == 1) {
				String iString = possibleTypingInvariants.get(0).getPredicate();
				d.setType(iString.substring(iString.indexOf(ELEMENT_OF) + 1)
						.trim());
			}
			// THESE CASES NO LONGER NEEDED - SEE NOTE ABOVE
			// left in regardless for the time being
			else if (uniqueInvariants.size() == 1) {
				String iString = uniqueInvariants.get(0);
				d.setType(iString.substring(iString.indexOf(ELEMENT_OF) + 1)
						.trim());
			} else {
				for (Invariant i : possibleTypingInvariants) {
					if (i.getAttributes().size() > 0) {
						Attribute attr = i.getAttributes().get(
								CodeGenTasking.TYPING_ATTRIBUTE_IDENT);
						if (attr != null) {
							String typingAttribute = (String) attr.getValue(); // The
																				// value:
																				// Typing/NonTyping

							if (typingAttribute.equals("Typing")) {
								String iString = i.getPredicate();
								d.setType(iString.substring(
										iString.indexOf(ELEMENT_OF) + 1).trim());
								break; // don't want to set several types!
							}
						}
					}
				}
			}

			for (Action a : initialisation.getActions()) {
				String aName = a.getAction();
				if (aName.contains(ASSIGNMENT_ELEMENT_IN)) {
					System.err
							.println("non-deterministic assignment not allowed in "
									+ machineName + ": " + aName);
				}
				aName = aName.trim();

				// to prevent it finding the substring
				boolean hasDetAssignment = aName.startsWith(variableName +" "+ ASSIGNMENT_SYMBOL);
				boolean hasNonDetAssignment = aName.startsWith(variableName+" "+ ASSIGNMENT_ELEMENT_IN);
				//Sadegh: Doesnt matter if variableName followed by white space or not
				//if (aName.startsWith(variableName + " ") || hasDetAssignment || hasNonDetAssignment) {
				if (aName.startsWith(variableName) || hasDetAssignment || hasNonDetAssignment) {
					String[] aInit = null;
					if(hasDetAssignment){
						aInit = aName.split(ASSIGNMENT_SYMBOL);
					}
					else if(hasNonDetAssignment){
						aInit = aName.split(ASSIGNMENT_ELEMENT_IN);
					}
					if (aInit != null && aInit.length > 1) {
						d.setInitialValue(aInit[1].trim());
					}
				}
			}

			if (d != null) {
				if(v.getComment()!=null && v.getComment().contains("**out**")){
					d.setIdentifier("outarg_" + d.getIdentifier());
					v.setName("outarg_" + v.getName());
				}
				declarations.add(d);
			}
		}

		return declarations;
	}

}
