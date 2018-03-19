/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage
 * @generated
 */
public interface RequiredFormulaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequiredFormulaFactory eINSTANCE = org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Addressed Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addressed Declaration</em>'.
	 * @generated
	 */
	AddressedDeclaration createAddressedDeclaration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RequiredFormulaPackage getRequiredFormulaPackage();

} //RequiredFormulaFactory
