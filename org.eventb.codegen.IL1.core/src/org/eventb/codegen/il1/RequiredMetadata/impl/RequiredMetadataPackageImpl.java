/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;
import org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataFactory;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;
import org.eventb.codegen.il1.impl.Il1PackageImpl;
import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredMetadataPackageImpl extends EPackageImpl implements RequiredMetadataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subroutineMetaDataEClass = null;

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
	 * @see org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequiredMetadataPackageImpl() {
		super(eNS_URI, RequiredMetadataFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequiredMetadataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequiredMetadataPackage init() {
		if (isInited) return (RequiredMetadataPackage)EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI);

		// Obtain or create and register package
		RequiredMetadataPackageImpl theRequiredMetadataPackage = (RequiredMetadataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RequiredMetadataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RequiredMetadataPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Il1PackageImpl theIl1Package = (Il1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Il1Package.eNS_URI) instanceof Il1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Il1Package.eNS_URI) : Il1Package.eINSTANCE);
		RequiredFormulaPackageImpl theRequiredFormulaPackage = (RequiredFormulaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI) instanceof RequiredFormulaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI) : RequiredFormulaPackage.eINSTANCE);

		// Create package meta-data objects
		theRequiredMetadataPackage.createPackageContents();
		theIl1Package.createPackageContents();
		theRequiredFormulaPackage.createPackageContents();

		// Initialize created meta-data
		theRequiredMetadataPackage.initializePackageContents();
		theIl1Package.initializePackageContents();
		theRequiredFormulaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequiredMetadataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequiredMetadataPackage.eNS_URI, theRequiredMetadataPackage);
		return theRequiredMetadataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubroutineMetaData() {
		return subroutineMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubroutineMetaData_Temporary() {
		return (EAttribute)subroutineMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredMetadataFactory getRequiredMetadataFactory() {
		return (RequiredMetadataFactory)getEFactoryInstance();
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
		subroutineMetaDataEClass = createEClass(SUBROUTINE_META_DATA);
		createEAttribute(subroutineMetaDataEClass, SUBROUTINE_META_DATA__TEMPORARY);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(subroutineMetaDataEClass, SubroutineMetaData.class, "SubroutineMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubroutineMetaData_Temporary(), ecorePackage.getEBoolean(), "temporary", null, 1, 1, SubroutineMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //RequiredMetadataPackageImpl
