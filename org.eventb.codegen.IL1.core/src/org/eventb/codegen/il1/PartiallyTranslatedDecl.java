/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partially Translated Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.PartiallyTranslatedDecl#getPartialInitialisationExpression <em>Partial Initialisation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getPartiallyTranslatedDecl()
 * @model
 * @generated
 */
public interface PartiallyTranslatedDecl extends TranslatedDecl {
	/**
	 * Returns the value of the '<em><b>Partial Initialisation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial Initialisation Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial Initialisation Expression</em>' attribute.
	 * @see #setPartialInitialisationExpression(String)
	 * @see org.eventb.codegen.il1.Il1Package#getPartiallyTranslatedDecl_PartialInitialisationExpression()
	 * @model
	 * @generated
	 */
	String getPartialInitialisationExpression();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.PartiallyTranslatedDecl#getPartialInitialisationExpression <em>Partial Initialisation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partial Initialisation Expression</em>' attribute.
	 * @see #getPartialInitialisationExpression()
	 * @generated
	 */
	void setPartialInitialisationExpression(String value);

} // PartiallyTranslatedDecl
