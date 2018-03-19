/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.MachinePackage;

import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.CompositeControlFactory;
import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;
import compositeControl.SubBranch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeControlPackageImpl extends EPackageImpl implements CompositeControlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seqEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

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
	 * @see compositeControl.CompositeControlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompositeControlPackageImpl() {
		super(eNS_URI, CompositeControlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompositeControlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompositeControlPackage init() {
		if (isInited) return (CompositeControlPackage)EPackage.Registry.INSTANCE.getEPackage(CompositeControlPackage.eNS_URI);

		// Obtain or create and register package
		CompositeControlPackageImpl theCompositeControlPackage = (CompositeControlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompositeControlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompositeControlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompositeControlPackage.createPackageContents();

		// Initialize created meta-data
		theCompositeControlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompositeControlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompositeControlPackage.eNS_URI, theCompositeControlPackage);
		return theCompositeControlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeControl() {
		return compositeControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeControl_EnvirStateMachineChild() {
		return (EAttribute)compositeControlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeq() {
		return seqEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeq_LeftBranch() {
		return (EReference)seqEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeq_RightBranch() {
		return (EReference)seqEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDo() {
		return doEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDo_Label() {
		return (EAttribute)doEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDo_TaskBody() {
		return (EReference)doEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDo_Finally() {
		return (EReference)doEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranch() {
		return branchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranch_Label() {
		return (EAttribute)branchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_EventWrapper() {
		return (EReference)branchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_SubBranch() {
		return (EReference)branchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_Alt() {
		return (EReference)branchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubBranch() {
		return subBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubBranch_EventWrapper() {
		return (EReference)subBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubBranch_SubBranch() {
		return (EReference)subBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventWrapper() {
		return eventWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventWrapper_Label() {
		return (EAttribute)eventWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventWrapper_Event() {
		return (EReference)eventWrapperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventWrapper_EventName() {
		return (EAttribute)eventWrapperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Text() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Element() {
		return (EReference)outputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_VariableName() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlFactory getCompositeControlFactory() {
		return (CompositeControlFactory)getEFactoryInstance();
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
		compositeControlEClass = createEClass(COMPOSITE_CONTROL);
		createEAttribute(compositeControlEClass, COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD);

		seqEClass = createEClass(SEQ);
		createEReference(seqEClass, SEQ__LEFT_BRANCH);
		createEReference(seqEClass, SEQ__RIGHT_BRANCH);

		doEClass = createEClass(DO);
		createEAttribute(doEClass, DO__LABEL);
		createEReference(doEClass, DO__TASK_BODY);
		createEReference(doEClass, DO__FINALLY);

		branchEClass = createEClass(BRANCH);
		createEAttribute(branchEClass, BRANCH__LABEL);
		createEReference(branchEClass, BRANCH__EVENT_WRAPPER);
		createEReference(branchEClass, BRANCH__SUB_BRANCH);
		createEReference(branchEClass, BRANCH__ALT);

		subBranchEClass = createEClass(SUB_BRANCH);
		createEReference(subBranchEClass, SUB_BRANCH__EVENT_WRAPPER);
		createEReference(subBranchEClass, SUB_BRANCH__SUB_BRANCH);

		eventWrapperEClass = createEClass(EVENT_WRAPPER);
		createEAttribute(eventWrapperEClass, EVENT_WRAPPER__LABEL);
		createEReference(eventWrapperEClass, EVENT_WRAPPER__EVENT);
		createEAttribute(eventWrapperEClass, EVENT_WRAPPER__EVENT_NAME);

		outputEClass = createEClass(OUTPUT);
		createEAttribute(outputEClass, OUTPUT__TEXT);
		createEReference(outputEClass, OUTPUT__ELEMENT);
		createEAttribute(outputEClass, OUTPUT__VARIABLE_NAME);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		MachinePackage theMachinePackage = (MachinePackage)EPackage.Registry.INSTANCE.getEPackage(MachinePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeControlEClass.getESuperTypes().add(theCorePackage.getAbstractExtension());
		seqEClass.getESuperTypes().add(this.getCompositeControl());
		doEClass.getESuperTypes().add(this.getCompositeControl());
		branchEClass.getESuperTypes().add(this.getCompositeControl());
		subBranchEClass.getESuperTypes().add(this.getCompositeControl());
		eventWrapperEClass.getESuperTypes().add(this.getCompositeControl());
		outputEClass.getESuperTypes().add(this.getCompositeControl());

		// Initialize classes and features; add operations and parameters
		initEClass(compositeControlEClass, CompositeControl.class, "CompositeControl", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeControl_EnvirStateMachineChild(), theEcorePackage.getEBoolean(), "envirStateMachineChild", "false", 0, 1, CompositeControl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seqEClass, Seq.class, "Seq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeq_LeftBranch(), this.getCompositeControl(), null, "leftBranch", null, 1, 1, Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeq_RightBranch(), this.getCompositeControl(), null, "rightBranch", null, 1, 1, Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doEClass, Do.class, "Do", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDo_Label(), ecorePackage.getEString(), "label", null, 1, 1, Do.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDo_TaskBody(), this.getEventWrapper(), null, "taskBody", null, 1, 1, Do.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDo_Finally(), this.getEventWrapper(), null, "finally", null, 0, 1, Do.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(branchEClass, Branch.class, "Branch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranch_Label(), ecorePackage.getEString(), "label", null, 1, 1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranch_EventWrapper(), this.getEventWrapper(), null, "eventWrapper", null, 1, 1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranch_SubBranch(), this.getSubBranch(), null, "subBranch", null, 0, 1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranch_Alt(), this.getEventWrapper(), null, "alt", null, 0, 1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subBranchEClass, SubBranch.class, "SubBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubBranch_EventWrapper(), this.getEventWrapper(), null, "eventWrapper", null, 1, 1, SubBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubBranch_SubBranch(), this.getSubBranch(), null, "subBranch", null, 0, 1, SubBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventWrapperEClass, EventWrapper.class, "EventWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventWrapper_Label(), ecorePackage.getEString(), "label", null, 1, 1, EventWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventWrapper_Event(), theMachinePackage.getEvent(), null, "event", null, 0, 1, EventWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventWrapper_EventName(), theEcorePackage.getEString(), "eventName", null, 0, 1, EventWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutput_Text(), theEcorePackage.getEString(), "text", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutput_Element(), theMachinePackage.getVariable(), null, "element", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_VariableName(), theEcorePackage.getEString(), "variableName", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CompositeControlPackageImpl
