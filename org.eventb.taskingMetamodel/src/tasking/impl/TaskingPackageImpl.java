/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.MachinePackage;

import tasking.AbstractExtensionTaskingElement;
import tasking.AddressedVariable;
import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.EventBElementTaskingElement;
import tasking.FMU_Machine;
import tasking.Implementation;
import tasking.ImplementationTypeEnum;
import tasking.MachineType;
import tasking.Main;
import tasking.ParameterType;
import tasking.ParameterTypeEnum;
import tasking.PeriodicTaskType;
import tasking.Sensor;
import tasking.Shared_Machine;
import tasking.SimpleTaskType;
import tasking.Task;
import tasking.TaskType;
import tasking.TaskTypeEnum;
import tasking.TaskingElement;
import tasking.TaskingFactory;
import tasking.TaskingPackage;
import tasking.Tasking_Machine;
import tasking.Typing;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;

import compositeControl.CompositeControlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskingPackageImpl extends EPackageImpl implements TaskingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoTask_MachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tasking_MachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environ_MachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmU_MachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shared_MachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTaskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass periodicTaskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractExtensionTaskingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventBElementTaskingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum implementationTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterTypeEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tasking.TaskingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TaskingPackageImpl() {
		super(eNS_URI, TaskingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TaskingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TaskingPackage init() {
		if (isInited) return (TaskingPackage)EPackage.Registry.INSTANCE.getEPackage(TaskingPackage.eNS_URI);

		// Obtain or create and register package
		TaskingPackageImpl theTaskingPackage = (TaskingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TaskingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TaskingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CompositeControlPackage.eINSTANCE.eClass();
		CompositionmodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTaskingPackage.createPackageContents();

		// Initialize created meta-data
		theTaskingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTaskingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TaskingPackage.eNS_URI, theTaskingPackage);
		return theTaskingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMain() {
		return mainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMain_Name() {
		return (EAttribute)mainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_MainBody() {
		return (EReference)mainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Machines() {
		return (EReference)mainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMain_Contexts() {
		return (EReference)mainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_TaskType() {
		return (EReference)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Priority() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_TaskBody() {
		return (EReference)taskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoTask_Machine() {
		return autoTask_MachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTasking_Machine() {
		return tasking_MachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnviron_Machine() {
		return environ_MachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFMU_Machine() {
		return fmU_MachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShared_Machine() {
		return shared_MachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementation() {
		return implementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementation_ImplementationType() {
		return (EAttribute)implementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterType() {
		return parameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterType_ParameterType() {
		return (EAttribute)parameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskType() {
		return taskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleTaskType() {
		return simpleTaskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleTaskType_Type() {
		return (EAttribute)simpleTaskTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeriodicTaskType() {
		return periodicTaskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeriodicTaskType_Period() {
		return (EAttribute)periodicTaskTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensor() {
		return sensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressedVariable() {
		return addressedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressedVariable_Base() {
		return (EAttribute)addressedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressedVariable_Address() {
		return (EAttribute)addressedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskingElement() {
		return taskingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractExtensionTaskingElement() {
		return abstractExtensionTaskingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventBElementTaskingElement() {
		return eventBElementTaskingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMachineType() {
		return machineTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTyping() {
		return typingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskTypeEnum() {
		return taskTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImplementationTypeEnum() {
		return implementationTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterTypeEnum() {
		return parameterTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskingFactory getTaskingFactory() {
		return (TaskingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		mainEClass = createEClass(MAIN);
		createEAttribute(mainEClass, MAIN__NAME);
		createEReference(mainEClass, MAIN__MAIN_BODY);
		createEReference(mainEClass, MAIN__MACHINES);
		createEReference(mainEClass, MAIN__CONTEXTS);

		taskEClass = createEClass(TASK);
		createEReference(taskEClass, TASK__TASK_TYPE);
		createEAttribute(taskEClass, TASK__PRIORITY);
		createEReference(taskEClass, TASK__TASK_BODY);

		autoTask_MachineEClass = createEClass(AUTO_TASK_MACHINE);

		tasking_MachineEClass = createEClass(TASKING_MACHINE);

		environ_MachineEClass = createEClass(ENVIRON_MACHINE);

		fmU_MachineEClass = createEClass(FMU_MACHINE);

		shared_MachineEClass = createEClass(SHARED_MACHINE);

		implementationEClass = createEClass(IMPLEMENTATION);
		createEAttribute(implementationEClass, IMPLEMENTATION__IMPLEMENTATION_TYPE);

		parameterTypeEClass = createEClass(PARAMETER_TYPE);
		createEAttribute(parameterTypeEClass, PARAMETER_TYPE__PARAMETER_TYPE);

		taskTypeEClass = createEClass(TASK_TYPE);

		simpleTaskTypeEClass = createEClass(SIMPLE_TASK_TYPE);
		createEAttribute(simpleTaskTypeEClass, SIMPLE_TASK_TYPE__TYPE);

		periodicTaskTypeEClass = createEClass(PERIODIC_TASK_TYPE);
		createEAttribute(periodicTaskTypeEClass, PERIODIC_TASK_TYPE__PERIOD);

		sensorEClass = createEClass(SENSOR);

		addressedVariableEClass = createEClass(ADDRESSED_VARIABLE);
		createEAttribute(addressedVariableEClass, ADDRESSED_VARIABLE__BASE);
		createEAttribute(addressedVariableEClass, ADDRESSED_VARIABLE__ADDRESS);

		taskingElementEClass = createEClass(TASKING_ELEMENT);

		abstractExtensionTaskingElementEClass = createEClass(ABSTRACT_EXTENSION_TASKING_ELEMENT);

		eventBElementTaskingElementEClass = createEClass(EVENT_BELEMENT_TASKING_ELEMENT);

		machineTypeEClass = createEClass(MACHINE_TYPE);

		typingEClass = createEClass(TYPING);

		// Create enums
		taskTypeEnumEEnum = createEEnum(TASK_TYPE_ENUM);
		implementationTypeEnumEEnum = createEEnum(IMPLEMENTATION_TYPE_ENUM);
		parameterTypeEnumEEnum = createEEnum(PARAMETER_TYPE_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CompositeControlPackage theCompositeControlPackage = (CompositeControlPackage)EPackage.Registry.INSTANCE.getEPackage(CompositeControlPackage.eNS_URI);
		MachinePackage theMachinePackage = (MachinePackage)EPackage.Registry.INSTANCE.getEPackage(MachinePackage.eNS_URI);
		ContextPackage theContextPackage = (ContextPackage)EPackage.Registry.INSTANCE.getEPackage(ContextPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		taskEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());
		taskEClass.getESuperTypes().add(this.getMachineType());
		autoTask_MachineEClass.getESuperTypes().add(this.getTask());
		tasking_MachineEClass.getESuperTypes().add(this.getTask());
		environ_MachineEClass.getESuperTypes().add(this.getTask());
		fmU_MachineEClass.getESuperTypes().add(this.getTask());
		shared_MachineEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());
		shared_MachineEClass.getESuperTypes().add(this.getMachineType());
		implementationEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());
		parameterTypeEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());
		taskTypeEClass.getESuperTypes().add(this.getEventBElementTaskingElement());
		simpleTaskTypeEClass.getESuperTypes().add(this.getTaskType());
		periodicTaskTypeEClass.getESuperTypes().add(this.getTaskType());
		sensorEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());
		addressedVariableEClass.getESuperTypes().add(this.getSensor());
		taskingElementEClass.getESuperTypes().add(theCorePackage.getEventBElement());
		abstractExtensionTaskingElementEClass.getESuperTypes().add(theCorePackage.getAbstractExtension());
		abstractExtensionTaskingElementEClass.getESuperTypes().add(this.getTaskingElement());
		eventBElementTaskingElementEClass.getESuperTypes().add(theCorePackage.getEventBElement());
		eventBElementTaskingElementEClass.getESuperTypes().add(this.getTaskingElement());
		typingEClass.getESuperTypes().add(this.getAbstractExtensionTaskingElement());

		// Initialize classes and features; add operations and parameters
		initEClass(mainEClass, Main.class, "Main", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMain_Name(), ecorePackage.getEString(), "name", null, 1, 1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_MainBody(), theCompositeControlPackage.getCompositeControl(), null, "mainBody", null, 0, 1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Machines(), theMachinePackage.getMachine(), null, "machines", null, 0, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMain_Contexts(), theContextPackage.getContext(), null, "contexts", null, 0, -1, Main.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTask_TaskType(), this.getTaskType(), null, "taskType", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Priority(), ecorePackage.getEInt(), "priority", "5", 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_TaskBody(), theCompositeControlPackage.getCompositeControl(), null, "taskBody", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autoTask_MachineEClass, AutoTask_Machine.class, "AutoTask_Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tasking_MachineEClass, Tasking_Machine.class, "Tasking_Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(environ_MachineEClass, Environ_Machine.class, "Environ_Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fmU_MachineEClass, FMU_Machine.class, "FMU_Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shared_MachineEClass, Shared_Machine.class, "Shared_Machine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implementationEClass, Implementation.class, "Implementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImplementation_ImplementationType(), this.getImplementationTypeEnum(), "implementationType", null, 0, 1, Implementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterTypeEClass, ParameterType.class, "ParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterType_ParameterType(), this.getParameterTypeEnum(), "parameterType", null, 1, 1, ParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskTypeEClass, TaskType.class, "TaskType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleTaskTypeEClass, SimpleTaskType.class, "SimpleTaskType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleTaskType_Type(), this.getTaskTypeEnum(), "type", null, 1, 1, SimpleTaskType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(periodicTaskTypeEClass, PeriodicTaskType.class, "PeriodicTaskType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPeriodicTaskType_Period(), ecorePackage.getEInt(), "period", null, 1, 1, PeriodicTaskType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sensorEClass, Sensor.class, "Sensor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressedVariableEClass, AddressedVariable.class, "AddressedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddressedVariable_Base(), ecorePackage.getEInt(), "base", "16", 0, 1, AddressedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddressedVariable_Address(), ecorePackage.getEString(), "address", null, 1, 1, AddressedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskingElementEClass, TaskingElement.class, "TaskingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractExtensionTaskingElementEClass, AbstractExtensionTaskingElement.class, "AbstractExtensionTaskingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventBElementTaskingElementEClass, EventBElementTaskingElement.class, "EventBElementTaskingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(machineTypeEClass, MachineType.class, "MachineType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typingEClass, Typing.class, "Typing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(taskTypeEnumEEnum, TaskTypeEnum.class, "TaskTypeEnum");
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.REPEATING);
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.TRIGGERED);
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.ONE_SHOT);

		initEEnum(implementationTypeEnumEEnum, ImplementationTypeEnum.class, "ImplementationTypeEnum");
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.PROCEDURE_DEF);
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.PROCEDURE_SYNCH);
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.LOOP);
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.BRANCH);
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.SENSING);
		addEEnumLiteral(implementationTypeEnumEEnum, ImplementationTypeEnum.ACTUATING);

		initEEnum(parameterTypeEnumEEnum, ParameterTypeEnum.class, "ParameterTypeEnum");
		addEEnumLiteral(parameterTypeEnumEEnum, ParameterTypeEnum.IN);
		addEEnumLiteral(parameterTypeEnumEEnum, ParameterTypeEnum.OUT);
		addEEnumLiteral(parameterTypeEnumEEnum, ParameterTypeEnum.LOCAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.eventb.emf.core.extendedMetaClasses
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.eventb.emf.core.extendedMetaClasses</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eventb.emf.core.extendedMetaClasses";		
		addAnnotation
		  (taskEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine"),
			 URI.createURI(CompositionmodelPackage.eNS_URI).appendFragment("//ComposedMachine")
		   });		
		addAnnotation
		  (autoTask_MachineEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });		
		addAnnotation
		  (tasking_MachineEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });		
		addAnnotation
		  (environ_MachineEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });		
		addAnnotation
		  (fmU_MachineEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });		
		addAnnotation
		  (shared_MachineEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });		
		addAnnotation
		  (implementationEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Event")
		   });		
		addAnnotation
		  (parameterTypeEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Parameter")
		   });		
		addAnnotation
		  (addressedVariableEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Parameter"),
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Variable")
		   });		
		addAnnotation
		  (typingEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Invariant"),
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Guard"),
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//context/Axiom")
		   });
	}

} //TaskingPackageImpl
