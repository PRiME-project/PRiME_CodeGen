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
 * A representation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Case#getCaseExpression <em>Case Expression</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Case#getCaseStatement <em>Case Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getCase()
 * @model
 * @generated
 */
public interface Case extends Command {
	/**
	 * Returns the value of the '<em><b>Case Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Expression</em>' attribute.
	 * @see #setCaseExpression(String)
	 * @see org.eventb.codegen.il1.Il1Package#getCase_CaseExpression()
	 * @model required="true"
	 * @generated
	 */
	String getCaseExpression();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Case#getCaseExpression <em>Case Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Expression</em>' attribute.
	 * @see #getCaseExpression()
	 * @generated
	 */
	void setCaseExpression(String value);

	/**
	 * Returns the value of the '<em><b>Case Statement</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.CaseStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Statement</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Statement</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getCase_CaseStatement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CaseStatement> getCaseStatement();

} // Case
