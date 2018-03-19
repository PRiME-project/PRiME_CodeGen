/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataFactory
 * @model kind="package"
 * @generated
 */
public interface RequiredMetadataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RequiredMetadata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://RequiredMetadata.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RequiredMetadata";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequiredMetadataPackage eINSTANCE = org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.RequiredMetadata.impl.SubroutineMetaDataImpl <em>Subroutine Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.RequiredMetadata.impl.SubroutineMetaDataImpl
	 * @see org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataPackageImpl#getSubroutineMetaData()
	 * @generated
	 */
	int SUBROUTINE_META_DATA = 0;

	/**
	 * The feature id for the '<em><b>Temporary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_META_DATA__TEMPORARY = 0;

	/**
	 * The number of structural features of the '<em>Subroutine Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_META_DATA_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData <em>Subroutine Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subroutine Meta Data</em>'.
	 * @see org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData
	 * @generated
	 */
	EClass getSubroutineMetaData();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData#isTemporary <em>Temporary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Temporary</em>'.
	 * @see org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData#isTemporary()
	 * @see #getSubroutineMetaData()
	 * @generated
	 */
	EAttribute getSubroutineMetaData_Temporary();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequiredMetadataFactory getRequiredMetadataFactory();

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
		 * The meta object literal for the '{@link org.eventb.codegen.il1.RequiredMetadata.impl.SubroutineMetaDataImpl <em>Subroutine Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.RequiredMetadata.impl.SubroutineMetaDataImpl
		 * @see org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataPackageImpl#getSubroutineMetaData()
		 * @generated
		 */
		EClass SUBROUTINE_META_DATA = eINSTANCE.getSubroutineMetaData();

		/**
		 * The meta object literal for the '<em><b>Temporary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBROUTINE_META_DATA__TEMPORARY = eINSTANCE.getSubroutineMetaData_Temporary();

	}

} //RequiredMetadataPackage
