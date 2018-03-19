/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaFactory
 * @model kind="package"
 * @generated
 */
public interface RequiredFormulaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RequiredFormula";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://RequiredFormula.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RequiredFormula";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequiredFormulaPackage eINSTANCE = org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.RequiredFormula.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.RequiredFormula.impl.DataTypeImpl
	 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl <em>Addressed Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl
	 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getAddressedDeclaration()
	 * @generated
	 */
	int ADDRESSED_DECLARATION = 1;

	/**
	 * The feature id for the '<em><b>Number Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_DECLARATION__NUMBER_BASE = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_DECLARATION__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Addressed Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.RequiredFormula.DataTypeEnum <em>Data Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.RequiredFormula.DataTypeEnum
	 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getDataTypeEnum()
	 * @generated
	 */
	int DATA_TYPE_ENUM = 2;

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.RequiredFormula.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eventb.codegen.il1.RequiredFormula.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration <em>Addressed Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addressed Declaration</em>'.
	 * @see org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration
	 * @generated
	 */
	EClass getAddressedDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getNumberBase <em>Number Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Base</em>'.
	 * @see org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getNumberBase()
	 * @see #getAddressedDeclaration()
	 * @generated
	 */
	EAttribute getAddressedDeclaration_NumberBase();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getAddress()
	 * @see #getAddressedDeclaration()
	 * @generated
	 */
	EAttribute getAddressedDeclaration_Address();

	/**
	 * Returns the meta object for enum '{@link org.eventb.codegen.il1.RequiredFormula.DataTypeEnum <em>Data Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type Enum</em>'.
	 * @see org.eventb.codegen.il1.RequiredFormula.DataTypeEnum
	 * @generated
	 */
	EEnum getDataTypeEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequiredFormulaFactory getRequiredFormulaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.RequiredFormula.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.RequiredFormula.impl.DataTypeImpl
		 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl <em>Addressed Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl
		 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getAddressedDeclaration()
		 * @generated
		 */
		EClass ADDRESSED_DECLARATION = eINSTANCE.getAddressedDeclaration();

		/**
		 * The meta object literal for the '<em><b>Number Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESSED_DECLARATION__NUMBER_BASE = eINSTANCE.getAddressedDeclaration_NumberBase();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESSED_DECLARATION__ADDRESS = eINSTANCE.getAddressedDeclaration_Address();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.RequiredFormula.DataTypeEnum <em>Data Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.RequiredFormula.DataTypeEnum
		 * @see org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl#getDataTypeEnum()
		 * @generated
		 */
		EEnum DATA_TYPE_ENUM = eINSTANCE.getDataTypeEnum();

	}

} //RequiredFormulaPackage
