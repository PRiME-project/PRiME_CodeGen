/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.VariableDecl#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getVariableDecl()
 * @model
 * @generated
 */
public interface VariableDecl extends Declaration {
	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(AddressedDeclaration)
	 * @see org.eventb.codegen.il1.Il1Package#getVariableDecl_Address()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	AddressedDeclaration getAddress();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.VariableDecl#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(AddressedDeclaration value);

} // VariableDecl
