/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration;
import org.eventb.codegen.il1.RequiredFormula.DataType;
import org.eventb.codegen.il1.RequiredFormula.DataTypeEnum;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaFactory;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataPackageImpl;
import org.eventb.codegen.il1.impl.Il1PackageImpl;
import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredFormulaPackageImpl extends EPackageImpl implements RequiredFormulaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressedDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEnumEEnum = null;

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
	 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequiredFormulaPackageImpl() {
		super(eNS_URI, RequiredFormulaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequiredFormulaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequiredFormulaPackage init() {
		if (isInited) return (RequiredFormulaPackage)EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI);

		// Obtain or create and register package
		RequiredFormulaPackageImpl theRequiredFormulaPackage = (RequiredFormulaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RequiredFormulaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RequiredFormulaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Il1PackageImpl theIl1Package = (Il1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Il1Package.eNS_URI) instanceof Il1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Il1Package.eNS_URI) : Il1Package.eINSTANCE);
		RequiredMetadataPackageImpl theRequiredMetadataPackage = (RequiredMetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI) instanceof RequiredMetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI) : RequiredMetadataPackage.eINSTANCE);

		// Create package meta-data objects
		theRequiredFormulaPackage.createPackageContents();
		theIl1Package.createPackageContents();
		theRequiredMetadataPackage.createPackageContents();

		// Initialize created meta-data
		theRequiredFormulaPackage.initializePackageContents();
		theIl1Package.initializePackageContents();
		theRequiredMetadataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequiredFormulaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequiredFormulaPackage.eNS_URI, theRequiredFormulaPackage);
		return theRequiredFormulaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressedDeclaration() {
		return addressedDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressedDeclaration_NumberBase() {
		return (EAttribute)addressedDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddressedDeclaration_Address() {
		return (EAttribute)addressedDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataTypeEnum() {
		return dataTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredFormulaFactory getRequiredFormulaFactory() {
		return (RequiredFormulaFactory)getEFactoryInstance();
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
		dataTypeEClass = createEClass(DATA_TYPE);

		addressedDeclarationEClass = createEClass(ADDRESSED_DECLARATION);
		createEAttribute(addressedDeclarationEClass, ADDRESSED_DECLARATION__NUMBER_BASE);
		createEAttribute(addressedDeclarationEClass, ADDRESSED_DECLARATION__ADDRESS);

		// Create enums
		dataTypeEnumEEnum = createEEnum(DATA_TYPE_ENUM);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressedDeclarationEClass, AddressedDeclaration.class, "AddressedDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddressedDeclaration_NumberBase(), theEcorePackage.getEInt(), "numberBase", null, 0, 1, AddressedDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddressedDeclaration_Address(), theEcorePackage.getEString(), "address", null, 0, 1, AddressedDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEnumEEnum, DataTypeEnum.class, "DataTypeEnum");
		addEEnumLiteral(dataTypeEnumEEnum, DataTypeEnum.USER_SPECIFIED_DATA_TYPE);
		addEEnumLiteral(dataTypeEnumEEnum, DataTypeEnum.BOOLEAN_DATA_TYPE);
		addEEnumLiteral(dataTypeEnumEEnum, DataTypeEnum.INTEGER_DATA_TYPE);
	}

} //RequiredFormulaPackageImpl
