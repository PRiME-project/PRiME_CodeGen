/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addressed Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getNumberBase <em>Number Base</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage#getAddressedDeclaration()
 * @model
 * @generated
 */
public interface AddressedDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Base</em>' attribute.
	 * @see #setNumberBase(int)
	 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage#getAddressedDeclaration_NumberBase()
	 * @model
	 * @generated
	 */
	int getNumberBase();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getNumberBase <em>Number Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Base</em>' attribute.
	 * @see #getNumberBase()
	 * @generated
	 */
	void setNumberBase(int value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage#getAddressedDeclaration_Address()
	 * @model
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

} // AddressedDeclaration
