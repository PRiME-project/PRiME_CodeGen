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
 * A representation of the model object '<em><b>Fully Translated Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.FullyTranslatedDecl#getFullInitialisationExpression <em>Full Initialisation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getFullyTranslatedDecl()
 * @model
 * @generated
 */
public interface FullyTranslatedDecl extends TranslatedDecl {
	/**
	 * Returns the value of the '<em><b>Full Initialisation Expression</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Initialisation Expression</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Initialisation Expression</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getFullyTranslatedDecl_FullInitialisationExpression()
	 * @model
	 * @generated
	 */
	EList<String> getFullInitialisationExpression();

} // FullyTranslatedDecl
