/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionmodelPackageImpl extends EPackageImpl implements CompositionmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass composedEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includedMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass combinedEventMachineEClass = null;

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
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompositionmodelPackageImpl() {
		super(eNS_URI, CompositionmodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompositionmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompositionmodelPackage init() {
		if (isInited) return (CompositionmodelPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionmodelPackage.eNS_URI);

		// Obtain or create and register package
		CompositionmodelPackageImpl theCompositionmodelPackage = (CompositionmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompositionmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompositionmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompositionmodelPackage.createPackageContents();

		// Initialize created meta-data
		theCompositionmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompositionmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompositionmodelPackage.eNS_URI, theCompositionmodelPackage);
		return theCompositionmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposedMachine() {
		return composedMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedMachine_Invariants() {
		return (EReference)composedMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedMachine_Sees() {
		return (EReference)composedMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedMachine_Refines() {
		return (EReference)composedMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedMachine_Includes() {
		return (EReference)composedMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedMachine_ComposesEvents() {
		return (EReference)composedMachineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComposedMachine_RefinesNames() {
		return (EAttribute)composedMachineEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComposedMachine_SeesNames() {
		return (EAttribute)composedMachineEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComposedEvent() {
		return composedEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedEvent_Refines() {
		return (EReference)composedEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComposedEvent_CombinesEvents() {
		return (EReference)composedEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComposedEvent_Convergence() {
		return (EAttribute)composedEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComposedEvent_RefinesNames() {
		return (EAttribute)composedEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncludedMachine() {
		return includedMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncludedMachine_Machine() {
		return (EReference)includedMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncludedMachine_MachineName() {
		return (EAttribute)includedMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncludedMachine_ProjectName() {
		return (EAttribute)includedMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCombinedEventMachine() {
		return combinedEventMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedEventMachine_Machine() {
		return (EReference)combinedEventMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCombinedEventMachine_Event() {
		return (EReference)combinedEventMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedEventMachine_MachineName() {
		return (EAttribute)combinedEventMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedEventMachine_EventName() {
		return (EAttribute)combinedEventMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCombinedEventMachine_ProjectName() {
		return (EAttribute)combinedEventMachineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionmodelFactory getCompositionmodelFactory() {
		return (CompositionmodelFactory)getEFactoryInstance();
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
		composedMachineEClass = createEClass(COMPOSED_MACHINE);
		createEReference(composedMachineEClass, COMPOSED_MACHINE__INVARIANTS);
		createEReference(composedMachineEClass, COMPOSED_MACHINE__SEES);
		createEReference(composedMachineEClass, COMPOSED_MACHINE__REFINES);
		createEReference(composedMachineEClass, COMPOSED_MACHINE__INCLUDES);
		createEReference(composedMachineEClass, COMPOSED_MACHINE__COMPOSES_EVENTS);
		createEAttribute(composedMachineEClass, COMPOSED_MACHINE__REFINES_NAMES);
		createEAttribute(composedMachineEClass, COMPOSED_MACHINE__SEES_NAMES);

		composedEventEClass = createEClass(COMPOSED_EVENT);
		createEReference(composedEventEClass, COMPOSED_EVENT__REFINES);
		createEReference(composedEventEClass, COMPOSED_EVENT__COMBINES_EVENTS);
		createEAttribute(composedEventEClass, COMPOSED_EVENT__CONVERGENCE);
		createEAttribute(composedEventEClass, COMPOSED_EVENT__REFINES_NAMES);

		includedMachineEClass = createEClass(INCLUDED_MACHINE);
		createEReference(includedMachineEClass, INCLUDED_MACHINE__MACHINE);
		createEAttribute(includedMachineEClass, INCLUDED_MACHINE__MACHINE_NAME);
		createEAttribute(includedMachineEClass, INCLUDED_MACHINE__PROJECT_NAME);

		combinedEventMachineEClass = createEClass(COMBINED_EVENT_MACHINE);
		createEReference(combinedEventMachineEClass, COMBINED_EVENT_MACHINE__MACHINE);
		createEReference(combinedEventMachineEClass, COMBINED_EVENT_MACHINE__EVENT);
		createEAttribute(combinedEventMachineEClass, COMBINED_EVENT_MACHINE__MACHINE_NAME);
		createEAttribute(combinedEventMachineEClass, COMBINED_EVENT_MACHINE__EVENT_NAME);
		createEAttribute(combinedEventMachineEClass, COMBINED_EVENT_MACHINE__PROJECT_NAME);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		MachinePackage theMachinePackage = (MachinePackage)EPackage.Registry.INSTANCE.getEPackage(MachinePackage.eNS_URI);
		ContextPackage theContextPackage = (ContextPackage)EPackage.Registry.INSTANCE.getEPackage(ContextPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		composedMachineEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedComponentElement());
		composedEventEClass.getESuperTypes().add(theCorePackage.getEventBNamedCommentedElement());
		includedMachineEClass.getESuperTypes().add(theCorePackage.getEventBCommentedElement());
		combinedEventMachineEClass.getESuperTypes().add(theCorePackage.getEventBElement());

		// Initialize classes and features; add operations and parameters
		initEClass(composedMachineEClass, ComposedMachine.class, "ComposedMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedMachine_Invariants(), theMachinePackage.getInvariant(), null, "invariants", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposedMachine_Sees(), theContextPackage.getContext(), null, "sees", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposedMachine_Refines(), theMachinePackage.getMachine(), null, "refines", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposedMachine_Includes(), this.getIncludedMachine(), null, "includes", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposedMachine_ComposesEvents(), this.getComposedEvent(), null, "composesEvents", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComposedMachine_RefinesNames(), theEcorePackage.getEString(), "refinesNames", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComposedMachine_SeesNames(), theEcorePackage.getEString(), "seesNames", null, 0, -1, ComposedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(composedEventEClass, ComposedEvent.class, "ComposedEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComposedEvent_Refines(), theMachinePackage.getEvent(), null, "refines", null, 0, -1, ComposedEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComposedEvent_CombinesEvents(), this.getCombinedEventMachine(), null, "combinesEvents", null, 0, -1, ComposedEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComposedEvent_Convergence(), theMachinePackage.getConvergence(), "convergence", null, 0, 1, ComposedEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComposedEvent_RefinesNames(), theEcorePackage.getEString(), "refinesNames", null, 0, -1, ComposedEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(includedMachineEClass, IncludedMachine.class, "IncludedMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncludedMachine_Machine(), theMachinePackage.getMachine(), null, "machine", null, 0, 1, IncludedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncludedMachine_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, IncludedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncludedMachine_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, IncludedMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(combinedEventMachineEClass, CombinedEventMachine.class, "CombinedEventMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCombinedEventMachine_Machine(), theMachinePackage.getMachine(), null, "machine", null, 0, 1, CombinedEventMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCombinedEventMachine_Event(), theMachinePackage.getEvent(), null, "event", null, 0, 1, CombinedEventMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombinedEventMachine_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, CombinedEventMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombinedEventMachine_EventName(), theEcorePackage.getEString(), "eventName", null, 0, 1, CombinedEventMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCombinedEventMachine_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, CombinedEventMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompositionmodelPackageImpl
