/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage
 * @generated
 */
public interface RequiredMetadataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequiredMetadataFactory eINSTANCE = org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Subroutine Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subroutine Meta Data</em>'.
	 * @generated
	 */
	SubroutineMetaData createSubroutineMetaData();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RequiredMetadataPackage getRequiredMetadataPackage();

} //RequiredMetadataFactory
