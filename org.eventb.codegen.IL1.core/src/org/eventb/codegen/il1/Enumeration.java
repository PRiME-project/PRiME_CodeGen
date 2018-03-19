/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Enumeration#getLiteralValues <em>Literal Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Literal Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Values</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getEnumeration_LiteralValues()
	 * @model
	 * @generated
	 */
	EList<String> getLiteralValues();

} // Enumeration
