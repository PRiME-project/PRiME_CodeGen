package org.eventb.codegen.tasking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.MainEntry;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.tasking.flattening.Flattener;
import org.eventb.codegen.tasking.translation.DefaultTaskingTranslator;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.core.IEventBRoot;
import org.eventb.core.ISCContextRoot;
import org.eventb.core.ISCMachineRoot;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.core.basis.ContextRoot;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.Project;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.context.impl.ContextImpl;
import org.eventb.emf.core.impl.AnnotationImpl;
import org.eventb.emf.core.impl.StringToAttributeMapEntryImpl;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.osgi.service.prefs.BackingStoreException;
import org.rodinp.core.RodinDBException;

import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.FMU_Machine;
import tasking.MachineType;
import tasking.Shared_Machine;
import tasking.TaskingElement;
import tasking.Tasking_Machine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.eventb.statemachines.AbstractNode;
import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.Transition;
import compositeControl.CompositeControl;

/**
 * Used to manage the translation provider classes and the EMF objects to be translated.
 * Translation classes can be added through the plug-in mechanism, similar to how they are with SyncManager.
 * 
 * Also keeps track of what has been previously translated, to prevent duplicate translations.
 * 
 * Similar to (based on) SyncManager.
 */
/**
 * @author Chris
 * 
 */
public class TaskingTranslationManager {

	// private static final Map<String, AbstractTaskingTranslator> idMapping =
	// new HashMap<String, AbstractTaskingTranslator>();
	private static final Map<EClass, AbstractTaskingTranslator> emfMappingForIL1 = new HashMap<EClass, AbstractTaskingTranslator>();
	private static final Map<EClass, AbstractEventBTranslator> emfMappingForEventB = new HashMap<EClass, AbstractEventBTranslator>();

	// Map<source -> Map<target -> translator>>
	// private static final Map<EClass, Map<EClass, AbstractTaskingTranslator>>
	// emfMapping2 = new HashMap<EClass, Map<EClass,
	// AbstractTaskingTranslator>>();
	private static final String taskingTranslatorsID = "org.eventb.codegen.tasking.translator";
	private static final AbstractTaskingTranslator defaultTaskingTranslator;
	protected Il1Factory factory;
	private ITypeEnvironment defaultTypeEnvironment = null;

	// Maps the source to target when specifically requested by the translators.
	// Map between String identifier (reference) and the translated class
	// This is probably only going to work for Event/Subroutine pairs, as the
	// rest are using
	// non-unique keys.
	private Map<String, IL1Element> storedElementMap = new HashMap<String, IL1Element>();

	// Some elements, like the Case Branches, cannot use the 'naive' translation
	// produced
	// on the first-pass event translation. We must stop the events being
	// 'recovered'.
	// Here is a list - doNotRecoverPreviousTranslationList, add elements to
	// this list
	// to force the translator to recreate the element, even though there is a
	// stored translation.
	private List<EventBElement> doNotRecoverPreviousTranslationList = new ArrayList<EventBElement>();

	// Maps between URI and EventBElement with that URI.
	// Used for managing objects that are proxy objects later on.
	// Really a temporary measure, until proxy resolving is sorted out.
	private Map<String, EventBElement> elementStorageMap = new HashMap<String, EventBElement>();

	// Used to store composed machine information
	ArrayList<ComposedMachine> composedMachineList = null;
	Map<String, String> composedEventMap = null;

	// Stores the project names, as they may not be accessible by using
	// eContainer
	private Map<MachineImpl, String> machineProjectNameMap = new HashMap<MachineImpl, String>();
	private Map<String, String> contextProjectNameMap = new HashMap<String, String>();
	private Map<String, Declaration> constantDeclNameMap = new HashMap<String, Declaration>();
	// Stores the loaded shared machines
	private Map<String, Protected> sharedMachinesMap = null;
	// Stores the loaded environ machines
	private Map<String, EnvironTask> environMachinesMap = null;
	// ...and store the original Event-B FMU_Machines as a list
	private ArrayList<Machine> fmuMachineList = new ArrayList<Machine>();
	private ArrayList<ContextImpl> contextList = new ArrayList<ContextImpl>();

	// This will load in the different translation providers (classes),
	// like how synchronisers are loaded in and used.

	private ArrayList<String> sharedMachineNames = new ArrayList<String>();
	private ArrayList<String> environMachineNames = new ArrayList<String>();
	private ArrayList<String> autoTaskMachineNames = new ArrayList<String>();
	private ArrayList<String> fmuMachineNames = new ArrayList<String>();

	public ArrayList<Machine> getFMUMachineList() {
		return fmuMachineList;
	}

	public String getProjectName(MachineImpl machine) {
		return machineProjectNameMap.get(machine);
	}

	public String getProjectName(ContextImpl context) {
		return contextProjectNameMap.get(context.getName());
	}

	public ComposedMachine getComposedMachine(String project, String machine,
			String event) {
		// Returns the ComposedMachine the given event belongs to except:
		if (composedEventMap == null || composedMachineList == null)
			return null;
		String cmName = composedEventMap.get(project + "/" + machine + "/"
				+ event);
		if (cmName != null) {
			for (ComposedMachine cm : composedMachineList) {
				if (cm.getName().equals(cmName)) {
					return cm;
				}
			}
		}
		return null;
	}

	public ArrayList<ComposedMachine> getComposedMachines() {
		return composedMachineList;
	}

	public Map<String, String> getComposedEvents() {
		return composedEventMap;
	}

	Map<String, Task> localMachineMap = null; // Stores the loaded local
												// machines

	// store the il1 program
	private Program program;
	// store a list of state-machine (elaborates) transition events
	public static List<String> elaboratesNamesList = new ArrayList<String>();
	// Store a list of NDCaseNames
	private static List<String> ND_StateMachineList = new ArrayList<String>();
	// which event is linked to which statemachine
	private static Map<Event, String> event_SM_Map = new HashMap<Event, String>();
	// store a list of statemachineNames to caseStatementBranchCountMap
	private static Map<String, Map<String, Integer>> stateMachineBranchCountMap = new HashMap<String, Map<String, Integer>>();
	// the total number of branches: required for calculating the state
	// transition conditions
	public static int MaxBranchCount = 0;
	// A map of events to their target (next state) node
	private Map<Event, AbstractNode> eventTargMap = new HashMap<Event, AbstractNode>();
	private static IProject project = null;
	// The string associated with the preference to flatten the machine before
	// loading.
	private static String prefFlatten = "PreferenceFlatten";
	// A similar preference for Java Interface Generation
	private static String prefJavaInterface = "PreferenceJavaInterface";
	// Setting (translationType = "tasking") => (the static checker is required
	// to validate the
	// typing info an tasking machines).
	// Other values omit these checks.
	public static final String DEFAULT_TRANSLATION_TYPE = "tasking";

	private static String translationType = DEFAULT_TRANSLATION_TYPE; // The
																		// default
																		// is
																		// tasking,
																		// so
																		// static
																		// checks
																		// are
																		// performed.

	private List<Subroutine> fmuCommunicatingSubroutines = new ArrayList<Subroutine>();

	private Map<String, Protected> fmuMachinesMap = null;

	public Protected getSharedMachineTranslation(String projectName,
			String machineName) {
		if (sharedMachinesMap != null) {
			return sharedMachinesMap.get(projectName + "/" + machineName);
		}
		return null;
	}

	public EnvironTask getEnvironMachineTranslation(String projectName,
			String machineName) {
		if (environMachinesMap != null) {
			return environMachinesMap.get(projectName + "/" + machineName);
		}
		return null;
	}

	public Task getLocalMachineTranslation(String projectName,
			String machineName) {
		if (localMachineMap != null) {
			return localMachineMap.get(projectName + "/" + machineName);
		}
		return null;
	}

	public Protected getFMUMachineTranslation(String projectName,
			String machineName) {
		if (fmuMachinesMap != null) {
			return fmuMachinesMap.get(projectName + "/" + machineName);
		}
		return null;
	}

	// Altered from SyncManager
	static {
		// populate synchroniser mappings from registered extensions
		for (final IExtension extension : Platform.getExtensionRegistry()
				.getExtensionPoint(taskingTranslatorsID).getExtensions()) {
			for (final IConfigurationElement packageElement : extension
					.getConfigurationElements()) {
				if ("emfPackage".equals(packageElement.getName())) {
					String nsURISource = packageElement
							.getAttribute("nsURISource");
					EPackage ePackageSource = EPackage.Registry.INSTANCE
							.getEPackage(nsURISource);

					if (ePackageSource == null) {
						try {
							throw new TaskingTranslationException(
									"Unable to find the metamodel nsURI: "
											+ nsURISource);
						} catch (TaskingTranslationException e) {
							Status status = new Status(IStatus.ERROR,
									CodeGenTasking.PLUGIN_ID,
									"Failed Translation: TaskingTranslationException"
											+ ":\n"
											+ extractFullExceptionMessage(e), e);
							StatusManager.getManager().handle(status,
									StatusManager.SHOW);
						}
					}

					String targetName = packageElement
							.getAttribute("TargetOutput");
					if (targetName.equals("IL1")) {
						for (final IConfigurationElement element : packageElement
								.getChildren("taskingTranslator")) {
							if ("taskingTranslator".equals(element.getName())) {
								try {
									final AbstractTaskingTranslator translator = (AbstractTaskingTranslator) element
											.createExecutableExtension("taskingTranslatorClass");
									EClassifier source = (EClassifier) ePackageSource
											.getEClassifier(element
													.getAttribute("sourceClass"));
									if (source != null) {
										emfMappingForIL1.put((EClass) source,
												translator);
									}
								} catch (final CoreException e) {
								}
							}
						}
					} else if (targetName.equals("EventB")) {
						for (final IConfigurationElement element : packageElement
								.getChildren("taskingTranslator")) {
							if ("taskingTranslator".equals(element.getName())) {
								try {
									final AbstractEventBTranslator translator = (AbstractEventBTranslator) element
											.createExecutableExtension("taskingTranslatorClass");
									EClassifier source = (EClassifier) ePackageSource
											.getEClassifier(element
													.getAttribute("sourceClass"));
									if (source != null) {
										emfMappingForEventB.put(
												(EClass) source, translator);
									}

								} catch (final CoreException e) {
								}
							}
						}
					}
				}
			}
		}
		defaultTaskingTranslator = new DefaultTaskingTranslator();// DynamicSynchroniser();
	}

	private static String extractFullExceptionMessage(Exception e) {
		String initialMessage = e.getMessage() + "\n";
		StackTraceElement[] stackTraceArray = e.getStackTrace();
		for (int idx = 0; idx < stackTraceArray.length; idx++) {
			initialMessage = initialMessage + stackTraceArray[idx] + "\n";
		}
		return initialMessage;
	}

	public TaskingTranslationManager(Il1Factory factory) {
		this.factory = factory;
		program = this.factory.createProgram();
	}

	public Il1Factory getIL1Factory() {
		return this.factory;
	}

	/**
	 * Entry point for translating to IL1.
	 * 
	 * Currently only accepts 1 machine - will be updated to accept sets of
	 * machines, contexts...
	 * 
	 * @param list
	 *            The list of highlighted objects (machines, contexts) to be
	 *            translated.
	 * @param composedMachines
	 *            The composed machines visible in the projects the selected
	 *            machines are in.
	 * @param composedEvents
	 *            mapping of ComposedEvent "[Project]/[Machine]/[Event]" names
	 *            to ComposedMachine names.
	 * @param relevantMachines
	 *            .contexts
	 * @return The unsaved result of the translation in EMF format.
	 * @throws TaskingTranslationUnhandledTypeException
	 * @throws BackingStoreException
	 * @throws CoreException
	 */
	public Program translateToIL1Entry(final Object[] list,
			ArrayList<ComposedMachine> composedMachines,
			Map<String, String> composedEvents,
			ArrayList<String> composedMachineNames,
			RMLDataStruct relevantMachines) throws TaskingTranslationException,
			BackingStoreException, CoreException {

		// Store all of the contexts so we can get back to them from the proxy
		// elements

		for (Context c : relevantMachines.contextList) {
			storeEventBElement(c, null , c.getName());
		}

		this.composedMachineList = composedMachines;
		this.composedEventMap = composedEvents;
		this.contextList = relevantMachines.contextList;
		contextProjectNameMap = relevantMachines.contextContainerMap;

		// Only have 1 main entry. Any auto tasks and environ machines go here.
		MainEntry mainObj = null;

		// Maps the "Project/Machine" name to the Protected
		Map<String, Protected> sharedMachinesMap = new HashMap<String, Protected>();
		Map<String, EnvironTask> environMachinesMap = new HashMap<String, EnvironTask>();
		Map<String, Protected> fmuMachinesMap = new HashMap<String, Protected>();

		// The list of shared machines.
		ArrayList<MachineImpl> sharedMachines = new ArrayList<MachineImpl>();
		ArrayList<MachineImpl> taskingMachines = new ArrayList<MachineImpl>();
		ArrayList<MachineImpl> environMachines = new ArrayList<MachineImpl>();

		// Flatten and then ....
		// Classify whether they are SharedMachine, Environ, FMU_Machines or
		// TaskingMachines
		for (Object obj : list) {
			if (obj instanceof MachineRoot || obj instanceof MachineImpl) {
				MachineImpl machine = null;

				if (obj instanceof MachineRoot) {
					MachineRoot machineRoot = (MachineRoot) obj;
					// Flatten Here
					Flattener f = new Flattener();
					f.flatten(machineRoot);
					// Convert from RODIN database to EMF
					machine = (MachineImpl) RodinToEMFConverter
							.loadMachine(machineRoot);
				} else {
					System.out.println("CANNOT FLATTEN MACHINE IF REQUIRED");
					machine = (MachineImpl) obj;
				}

				String projectName = "";
				// Get the project name
				if (obj instanceof MachineRoot) {
					// If the incoming object was a Rodin object, then get the
					// project this way
					projectName = (((MachineRoot) obj).getRodinProject()
							.getElementName());
				} else {
					// Otherwise the object will be an EMF object, so get it
					// this way
					projectName = (((Project) machine.eContainer()).getName());
				}

				// Store the project name
				machineProjectNameMap.put(machine, projectName);
				boolean projectNameStored = false;
				if (!projectNameStored) {
					program.setProjectName(projectName);
					projectNameStored = true;
				}

				// store machine and event proxies.
				storeEventBElement(machine, null, machine.getName());
				EList<Event> eventList = machine.getEvents();
				for (Event evt : eventList) {
					storeEventBElement(evt, machine.getName(), evt.getName());
				}
				// Determine the task type
				MachineType taskingType = CodeGenTaskingUtils
						.getTaskType(machine);

				// This Branch handles the new FMU translation, which translates
				// autotask machines (and possibly shared machines).
				if (translationType.equals("FMU")) {
					if (taskingType instanceof Shared_Machine) {
						sharedMachines.add(machine);
						sharedMachineNames.add(machine.getName());
					} else if (taskingType instanceof FMU_Machine) {
						fmuMachineList.add(machine);
						fmuMachineNames.add(machine.getName());
					} else if (taskingType instanceof AutoTask_Machine) {
						// if we have a tasking machine we change it internally
						// to an FMU machine
						CodeGenTaskingUtils.cloneAutoTaskToFMU(machine);
						fmuMachineList.add(machine);
						fmuMachineNames.add(machine.getName());
					} else if (taskingType instanceof Environ_Machine) {
						// if we have an environ machine we change it internally
						// to an FMU machine
						CodeGenTaskingUtils.cloneEnvironTaskToFMU(machine);
						fmuMachineList.add(machine);
						fmuMachineNames.add(machine.getName());
					}
				}
				// This branch is the legacy code. It handles traditional-style
				// translation
				// from a decomposed machine. It includes the possibility of
				// translation of a
				// decomposed model with an autotask master and FMU machine
				// slaves.
				else {
					if (taskingType instanceof Shared_Machine) {
						sharedMachines.add(machine);
						sharedMachineNames.add(machine.getName());
					} else if (taskingType instanceof FMU_Machine) {
						fmuMachineList.add(machine);
						fmuMachineNames.add(machine.getName());
					} else if (taskingType instanceof Environ_Machine) {
						environMachines.add(machine);
						environMachineNames.add(machine.getName());
					} else if (taskingType instanceof AutoTask_Machine) {
						taskingMachines.add(machine);
						autoTaskMachineNames.add(machine.getName());
					}
				}
			}
		}
		// End of flattening / prep stage

		// >>>>> Translate the shared machines
		for (MachineImpl sharedMachine : sharedMachines) {
			Protected protectedObj = (Protected) translate(sharedMachine);
			if (protectedObj != null) {
				program.getProtected().add(protectedObj);
				// Add to the shared machines
				sharedMachinesMap.put(machineProjectNameMap.get(sharedMachine)
						+ "/" + sharedMachine.getName(), protectedObj);
			}
			// Setting the Reference so Renato can see which project the machine
			// / task has come from
			// protectedObj.setReference(machineProjectNames.get(sharedMachine));
			protectedObj.setProjectName(machineProjectNameMap
					.get(sharedMachine));
			protectedObj.setMachineName(sharedMachine.getName());
			// program.setProjectName(machineProjectNameMap.get(sharedMachine));
		}

		// Make the shared machines accessible to the translation manager
		this.sharedMachinesMap = sharedMachinesMap;

		// A map of (statemachineName X (stateName X transitionList))
		Map<String, Map<String, EList<Transition>>> stateMachine_Transition_Map = new HashMap<String, Map<String, EList<Transition>>>();

		// Translate: (the FMU machine) or (the autoTask machine that has
		// been converted to FMU machines in the new approach). There should
		// only be one of them!
		for (Machine fmuMachine : fmuMachineList) {
			Protected prot = (Protected) translate(fmuMachine);
			program.getProtected().add(prot);
			String key = machineProjectNameMap.get(fmuMachine) + "/"
					+ fmuMachine.getName();
			fmuMachinesMap.put(key, prot);
		}

		// Set the field to the local data.
		this.fmuMachinesMap = fmuMachinesMap;

		// // Now add the global constant declarations to the program
		// declarations
		// EList<Declaration> pDeclsList = program.getDecls();
		// Collection<Declaration> constantDecls = constantDeclNameMap.values();
		// pDeclsList.addAll(constantDecls);

		// >>>>> Translate the environ machines
		for (MachineImpl environMachine : environMachines) {
			EnvironTask environTask = (EnvironTask) translate(environMachine);
			if (environTask != null) {
				program.getEnvironMachines().add(environTask);
				// Add to the environ machines map
				environMachinesMap.put(
						machineProjectNameMap.get(environMachine) + "/"
								+ environMachine.getName(), environTask);
			}
			// Setting the Reference so Renato can see which project the machine
			// / task has come from
			// environTask.setReference(machineProjectNames.get(environMachine));
			environTask.setProjectName(machineProjectNameMap
					.get(environMachine));
			environTask.setMachineName(environMachine.getName());
			// program.setProjectName(machineProjectNameMap.get(environMachine));
		}
		this.environMachinesMap = environMachinesMap;

		// >>>>> Now translate the Tasking machines
		for (MachineImpl taskingMachine : taskingMachines) {
			// before we translate these we need to work out the simulation
			// coverage count. We need to find the state machines and record the
			// number of outgoing transitions etc.
			EList<AbstractExtension> exts = taskingMachine.getExtensions();
			for (AbstractExtension ext : exts) {
				if (ext instanceof Statemachine) {
					Statemachine statemachine = (Statemachine) ext;
					Map<String, EList<Transition>> state_Transition_Map = new HashMap<String, EList<Transition>>();
					EList<AbstractNode> nodes = statemachine.getNodes();
					for (AbstractNode node : nodes) {
						if (node instanceof State) {
							State state = (State) node;
							EList<Transition> outgoing = state.getOutgoing();
							state_Transition_Map.put(state.getName(), outgoing);
						}
					}
					stateMachine_Transition_Map.put(statemachine.getName(),
							state_Transition_Map);
				}
			}
			// now we have collected all of the state transition data we
			// calculate the cross product for coverage
			// Rest the max branch count
			MaxBranchCount = 0;
			Iterator<String> stateMachineIterator = stateMachine_Transition_Map
					.keySet().iterator();
			// for each state-machine
			while (stateMachineIterator.hasNext()) {
				String stateMachineName = stateMachineIterator.next();
				Map<String, EList<Transition>> stateMachineTransitionMap = stateMachine_Transition_Map
						.get(stateMachineName);
				Iterator<String> stateIterator = stateMachineTransitionMap
						.keySet().iterator();
				// iterate over the states of the state machine
				int stateMachineTCount = 0;
				while (stateIterator.hasNext()) {
					String stateName = stateIterator.next();
					EList<Transition> tList = stateMachineTransitionMap
							.get(stateName);
					stateMachineTCount = stateMachineTCount + tList.size();
				}
				if (MaxBranchCount == 0) {
					MaxBranchCount = stateMachineTCount;
				} else {
					MaxBranchCount = MaxBranchCount * stateMachineTCount;
				}
			}
			Task task = (Task) translate(taskingMachine);

			MachineType taskingType = CodeGenTaskingUtils
					.getTaskType(taskingMachine);
			if (task != null) {
				if (taskingType instanceof AutoTask_Machine
						|| taskingType instanceof Environ_Machine) {
					if (mainObj == null) {
						mainObj = this.factory.createMainEntry();
						program.setEntryPoint(mainObj);
					}
					mainObj.getAutoTasks().add(task);
				} else if (taskingType instanceof Tasking_Machine) {
					program.getTaskTypeTasks().add(task);
				}
			}
			// Setting the Reference so Renato can see which project the machine
			// / task has come from
			// task.setReference(machineProjectNames.get(taskingMachine));
			task.setProjectName(machineProjectNameMap.get(taskingMachine));
			task.setMachineName(taskingMachine.getName());
			// program.setProjectName(machineProjectNameMap.get(taskingMachine));
		}

		// Now add the global constant declarations to the program declarations
		EList<Declaration> pDeclsList = program.getDecls();
		Collection<Declaration> constantDecls = constantDeclNameMap.values();
		pDeclsList.addAll(constantDecls);

		return program;
	}

	// END OF main IL1 translator code
	// ///////////////////////////////////////////////////////////////////

	// Generic translator
	/**
	 * Used by some things that are an EObject type, to do with abstract
	 * extension.
	 * 
	 * @param source
	 * @param target
	 * @return
	 * @throws TaskingTranslationUnhandledTypeException
	 */
	public IL1Element translate(final EObject source, final EObject target)
			throws TaskingTranslationException {
		if (source instanceof TaskingElement) {
			return translate((TaskingElement) source);
		} else if (source instanceof CompositeControl) {
			return translate((CompositeControl) source);
		} else if (source instanceof MachineImpl) {
			return translate((MachineImpl) source, (IL1Element) target);
		} else if (source instanceof ContextImpl) {
			// Not Used - navigate contexts through machine translation
		} else if (source instanceof StringToAttributeMapEntryImpl) {
			return null;
		}
		// else if (object instanceof ComposedMachineImpl)
		else if (source instanceof AnnotationImpl) {
			return null;
		} else if (source == null) {
			return null;
		}

		// If all of the above fail...
		// Unknown / unhandled type
		throw new TaskingTranslationUnhandledTypeException(source);
	}

	public String translateToEventB(EventBElement source, MachineImpl machine,
			String waitGuard) {
		return translateToEventB(source, machine, waitGuard, null);
	}

	public String translateToEventB(EventBElement source, MachineImpl machine,
			String waitGuard, String forceGuardName) {
		if (source == null)
			return waitGuard;

		final AbstractEventBTranslator translator = emfMappingForEventB
				.get(source.eClass());

		String output = waitGuard;

		try {
			if (translator != null) {
				output = translator.translate(source, machine, waitGuard,
						forceGuardName, this);
			} else {
				// Default
				System.out
						.println("Unknown TaskingEventB to EventB translator for: "
								+ source);
			}
		} catch (TaskingTranslationUnhandledTypeException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: TaskingTranslationUnhandledTypeException:"
							+ e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}

		return output;
	}

	public IL1Element translate(final EventBElement source)
			throws TaskingTranslationException
	// , final IL1Element target)
	{
		if (source == null)
			return null;

		// Get mapping by emf element
		// final AbstractTaskingTranslator translator =
		// emfMapping2.get(source.eClass()).get(target.eClass());
		final AbstractTaskingTranslator translator = emfMappingForIL1
				.get(source.eClass());

		IL1Element il1Element = null;

		// try {
		if (translator != null) {
			il1Element = translator.translate(source, null, this);

			if (il1Element != null
					&& translator.canStoreTranslationInTranslationManager()) {

				if (source instanceof Event && il1Element instanceof Subroutine) {
					addPreviousTranslation((Event) source,
							(Subroutine) il1Element);
				} else {
					storedElementMap.put(source.getReference(), il1Element);
				}
			}

		} else {
			il1Element = defaultTaskingTranslator.translate(source, null, this);
		}
		return il1Element;
	}

	public Seq evaluateLocalRemote(Subroutine localSubroutine,
			Subroutine remoteSubroutine) {
		Seq seq = Il1Factory.eINSTANCE.createSeq();

		if (localSubroutine != null) {
			seq.setLeftBranch((Command) copy(localSubroutine.getBody()));
		}

		if (remoteSubroutine != null) {
			Call call = Il1Factory.eINSTANCE.createCall();
			call.setSubroutine((Subroutine) copy(remoteSubroutine));

			// Copy the parameters over
			for (Parameter p : localSubroutine.getFormalParameters()) {
				p.setComponentName(localSubroutine.getMachineName());
				p.setProjectName(localSubroutine.getProjectName());
				call.getActualParameters().add((Parameter) this.copy(p));
			}
			// find guards in the local that should be true before the calls
			EList<String> guards = localSubroutine.getGuards();
			If branch = null;
			if (guards.size() > 0) {
				branch = Il1Factory.eINSTANCE.createIf();
				EList<String> conditions = branch.getCondition();
				conditions.addAll(guards);
				branch.setBody(call);
				seq.setRightBranch(branch);
			} else {
				seq.setRightBranch(call);
			}
		}

		return seq;
	}

	/**
	 * Obtains the previous translation for the element given.
	 * 
	 * CHRIS: 02/05/2012 - getReferenceWithoutResolving is a terrible way of
	 * recovering as you can have duplicates. Better way is to use
	 * source.getURI() + source.getName()
	 * 
	 * @param source
	 *            The source element that has been translated previously
	 * @return The translated element, or null if not previously translated.
	 * @deprecated
	 */
	// public IL1Element recoverPreviousTranslation(EventBElement source) {
	// return recoverPreviousTranslation(source.getReferenceWithoutResolving());
	// // return storedElements.get(source.getReferenceWithoutResolving());
	// }

	public IL1Element recoverPreviousTranslation(Event source) {
		boolean isProxy = source.eIsProxy();
		String id = source.getURI() + "/" + source.getName();
		// the retrieval does not appear to work. The wrong name is
		// being used. Don't know what has changed to make it stop working.
		if (isProxy) {
			String firstPart = id.substring(0, id.indexOf("#"));
			String lastPart = id.substring(id.lastIndexOf("/"));
			id = firstPart + lastPart;
		}

		return recoverPreviousTranslation(id);
	}

	public boolean previousTranslationExists(Event source) {
		boolean isProxy = source.eIsProxy();
		String id = source.getURI() + "/" + source.getName();
		// the retrieval does not appear to work. The wrong name is
		// being used. Don't know what has changed to make it stop working.
		if (isProxy) {
			String firstPart = id.substring(0, id.indexOf("#"));
			String lastPart = id.substring(id.lastIndexOf("/"));
			id = firstPart + lastPart;
		}

		return storedElementMap.containsKey(id);
	}

	public void addPreviousTranslation(Event source, Subroutine translation) {
		String id = source.getURI() + "/" + source.getName();
		storedElementMap.put(id, translation);
	}

	public IL1Element recoverPreviousTranslation(String reference) {
		return storedElementMap.get(reference);
	}

	// Map based store for partially generated EventB Elements: 
	// If the element is 'contained' in a machine or context, 
	// then the key is as string :- <parentName>_<elementName>.
	// Machines and contexts have the machine's name as the elementName
	// and the first the first argument can be null or the empty string.
	// Keys have the form _<elementName>.
	public void storeEventBElement(EventBElement toRemember,
			String parentElementName, String elementName) {
		if (parentElementName == null) {
			parentElementName = "";
		}
		elementStorageMap.put(parentElementName + "_" + elementName, toRemember);
	}

	// Retrieval of element, see above.
	public EventBElement getEventBElementFromStore(String parentElementName, String elementName) {
		if (parentElementName == null) {
			parentElementName = "";
		}
		return elementStorageMap.get(parentElementName + "_" + elementName);
	}

	public IL1Element copy(IL1Element element) {
		return (IL1Element) EcoreUtil.copy(element);
	}

	// public Collection<BFormula> copyAll(Collection<BFormula> collection) {
	// return (Collection<BFormula>) EcoreUtil.copyAll(collection);
	// }

	public boolean isSharedMachine(String machineName) {
		return sharedMachineNames.contains(machineName);
	}

	public boolean isEnvironMachine(String machineName) {
		return environMachineNames.contains(machineName);
	}

	/**
	 * Returns true if the given name is in the list of composed events
	 * 
	 * @param fullname
	 *            Must be in form Project/Machine/Event
	 * @return
	 */
	public boolean isComposedEvent(String fullname) {
		return composedEventMap.containsKey(fullname);
	}

	public boolean isComposedEvent(Event event) {
		// Event cannot be a proxy
		if (event.eIsProxy())
			return false;

		Machine machine = (Machine) event.eContainer();
		Project project = (Project) machine.eContainer();

		String eventNameFull = project + "/" + machine + "/" + event;

		return isComposedEvent(eventNameFull);
	}

	public Map<String, IL1Element> getStoredElements() {
		return storedElementMap;
	}

	public static MachineImpl getParentMachine(EventBElement element) {
		while (!(element instanceof MachineImpl)
				&& element.eContainer() != null
				&& element.eContainer() instanceof EventBElement)
			element = (EventBElement) element.eContainer();

		if (element instanceof MachineImpl)
			return (MachineImpl) element;

		return null;
	}

	public static ContextImpl getParentContext(EventBElement element) {
		while (!(element instanceof ContextImpl)
				&& element.eContainer() != null
				&& element.eContainer() instanceof EventBElement)
			element = (EventBElement) element.eContainer();

		if (element instanceof ContextImpl)
			return (ContextImpl) element;

		return null;
	}

	/**
	 * @return the contexts
	 */
	public ArrayList<ContextImpl> getContexts() {
		return contextList;
	}

	public static MachineImpl clearAllGeneratedElements(MachineImpl machine) {
		// Remove any generated guards or actions
		ArrayList<Event> eventsToRemove = new ArrayList<Event>();
		for (Event e : machine.getEvents()) {
			if (e.isGenerated()) {
				eventsToRemove.add(e);
			} else {
				ArrayList<Guard> guardsToRemove = new ArrayList<Guard>();
				for (Guard g : e.getGuards()) {
					if (g.isGenerated()) {
						guardsToRemove.add(g);
					}
				}
				e.getGuards().removeAll(guardsToRemove);

				ArrayList<Action> actionsToRemove = new ArrayList<Action>();
				for (Action a : e.getActions()) {
					if (a.isGenerated()) {
						actionsToRemove.add(a);
					}
				}
				e.getActions().removeAll(actionsToRemove);
			}
		}
		machine.getEvents().removeAll(eventsToRemove);

		ArrayList<Invariant> invariantsToRemove = new ArrayList<Invariant>();
		for (Invariant iv : machine.getInvariants()) {
			if (iv.isGenerated()) {
				invariantsToRemove.add(iv);
			}
		}
		machine.getInvariants().removeAll(invariantsToRemove);

		ArrayList<Variable> variablesToRemove = new ArrayList<Variable>();
		for (Variable v : machine.getVariables()) {
			if (v.isGenerated()) {
				variablesToRemove.add(v);
			}
		}
		machine.getVariables().removeAll(variablesToRemove);
		return machine;
	}

	/**
	 * @return the contextNameMap
	 */
	public Map<String, Declaration> getConstantDeclNameMap() {
		return constantDeclNameMap;
	}

	public void addSharedMachineName(String machineName) {
		sharedMachineNames.add(machineName);
	}

	/**
	 * @return the environMachineNames
	 */
	public ArrayList<String> getEnvironMachineNames() {
		return environMachineNames;
	}

	/**
	 * @return the autoTaskMachineNames
	 */
	public ArrayList<String> getAutoTaskMachineNames() {
		return autoTaskMachineNames;
	}

	/**
	 * @return the program
	 */
	public Program getProgram() {
		return program;
	}

	/**
	 * @return the eventTargMap
	 */
	public Map<Event, AbstractNode> getEventTargMap() {
		return eventTargMap;
	}

	public static List<String> getND_StateMachineList() {
		return ND_StateMachineList;
	}

	public static Map<Event, String> getEvent_SM_Map() {
		return event_SM_Map;
	}

	public static Map<String, Map<String, Integer>> getStateMachineBranchCountMap() {
		return stateMachineBranchCountMap;
	}

	public void setProject(IProject project) {
		TaskingTranslationManager.project = project;

	}

	public static IProject getProject() {
		return project;
	}

	public static void setPrefFlatten(String value) {
		prefFlatten = value;
	}

	public static String getPrefFlatten() {
		return prefFlatten;
	}

	public static void setPrefJavaInterface(String value) {
		prefJavaInterface = value;
	}

	public static String getPrefJavaInterface() {
		return prefJavaInterface;
	}

	/**
	 * @return the doNotRecoverPreviousTranslationList
	 */
	public List<EventBElement> getDoNotRecoverPreviousTranslationList() {
		return doNotRecoverPreviousTranslationList;
	}

	public Map<String, Protected> getSharedMachines() {
		return sharedMachinesMap;
	}

	public void setSharedMachines(Map<String, Protected> sharedMachines) {
		this.sharedMachinesMap = sharedMachines;
	}

	public Map<MachineImpl, String> getMachineProjectNames() {
		return machineProjectNameMap;
	}

	public void setMachineProjectNames(
			Map<MachineImpl, String> machineProjectNames) {
		this.machineProjectNameMap = machineProjectNames;
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// This whole translate to Event-B needs to be looked at
	public void translateToEventB(final Object[] list,
			ArrayList<ComposedMachine> composedMachines,
			Map<String, String> composedEvents,
			ArrayList<String> composedMachineNames,
			ArrayList<ContextImpl> contexts)
			throws TaskingTranslationUnhandledTypeException, RodinDBException {
		this.composedMachineList = composedMachines;
		this.composedEventMap = composedEvents;
		this.contextList = contexts;

		// Maps the "Project/Machine" name to the Protected
		Map<String, Protected> sharedMachinesMap = new HashMap<String, Protected>();
		Map<String, EnvironTask> environMachinesMap = new HashMap<String, EnvironTask>();

		ArrayList<MachineImpl> sharedMachines = new ArrayList<MachineImpl>();
		ArrayList<MachineImpl> taskingMachines = new ArrayList<MachineImpl>();
		ArrayList<MachineImpl> environMachines = new ArrayList<MachineImpl>();

		// Classify whether they are SharedMachine or TaskingMachines
		for (Object obj : list) {
			if (obj instanceof MachineRoot || obj instanceof MachineImpl) {
				MachineImpl machine = null;

				if (obj instanceof MachineRoot) {
					// Convert from RODIN database to EMF
					machine = (MachineImpl) RodinToEMFConverter
							.loadMachine((MachineRoot) obj);
				} else {
					machine = (MachineImpl) obj;
				}

				String projectName = "";
				// Get the project name
				if (obj instanceof MachineRoot) {
					// If the incoming object was a Rodin object, then get the
					// project this way
					projectName = (((MachineRoot) obj).getRodinProject()
							.getElementName());
				} else {
					// Otherwise the object will be an EMF object, so get it
					// this way
					projectName = (((Project) machine.eContainer()).getName());
				}

				// Store the project name
				machineProjectNameMap.put(machine, projectName);

				// Determine the task type
				MachineType taskingType = CodeGenTaskingUtils
						.getTaskType(machine);

				if (taskingType instanceof Shared_Machine) {
					sharedMachines.add(machine);
				} else if (taskingType instanceof Environ_Machine) {
					environMachines.add(machine);
				} else {
					taskingMachines.add(machine);
				}
			}
		}

		// Translate the shared machines
		for (MachineImpl sharedMachine : sharedMachines) {
			translateToEventB(sharedMachine, sharedMachine, null, null);
		}

		// Make the shared machines accessible to the translation manager
		this.sharedMachinesMap = sharedMachinesMap;

		// Translate the environ machines
		for (MachineImpl environMachine : environMachines) {
			translateToEventB(environMachine, environMachine, null, null);
		}

		this.environMachinesMap = environMachinesMap;

		// Now translate the Tasking machines
		for (MachineImpl taskingMachine : taskingMachines) {
			translateToEventB(taskingMachine, taskingMachine, null, null);
		}
	}

	// End of Tasking to Event-B Translator
	// /////////////////////////////////////////////////////////////////////

	public ITypeEnvironment getTypeEnvironment(IEventBRoot sourceRoot) throws CoreException {
		// make the ff's defaultTypeEnvironment;
		if (defaultTypeEnvironment == null) {
			defaultTypeEnvironment = FormulaFactory.getDefault()
					.makeTypeEnvironment();
		}
		// get the source root's ff, and make its type environment.
		FormulaFactory formulaFactory = sourceRoot.getFormulaFactory();
		ITypeEnvironment typeEnvironment = formulaFactory.makeTypeEnvironment();
		try {
			if (sourceRoot instanceof ContextRoot) {
				ISCContextRoot scContextRoot = sourceRoot.getSCContextRoot();
				typeEnvironment = scContextRoot
						.getTypeEnvironment();
			} else if (sourceRoot instanceof MachineRoot) {
				ISCMachineRoot scMachineRoot = sourceRoot.getSCMachineRoot();
				typeEnvironment = scMachineRoot
						.getTypeEnvironment();
			}
		} catch (RodinDBException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException:" + e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
		ITypeEnvironmentBuilder typeEnvBuilder = typeEnvironment.makeBuilder();
		typeEnvBuilder.addAll(defaultTypeEnvironment);

		return typeEnvBuilder.makeSnapshot();

	}

	public List<Subroutine> getCommunicatingSubroutines() {
		return fmuCommunicatingSubroutines;
	}

	public static String getTranslationType() {
		return translationType;
	}

	public static void setTranslationType(String s) {
		translationType = s;
	}
}
