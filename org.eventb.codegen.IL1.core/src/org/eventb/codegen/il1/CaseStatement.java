/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.CaseStatement#getCaseValue <em>Case Value</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.CaseStatement#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getCaseStatement()
 * @model
 * @generated
 */
public interface CaseStatement extends IL1Element {
	/**
	 * Returns the value of the '<em><b>Case Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Value</em>' attribute.
	 * @see #setCaseValue(String)
	 * @see org.eventb.codegen.il1.Il1Package#getCaseStatement_CaseValue()
	 * @model
	 * @generated
	 */
	String getCaseValue();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.CaseStatement#getCaseValue <em>Case Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Value</em>' attribute.
	 * @see #getCaseValue()
	 * @generated
	 */
	void setCaseValue(String value);

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' containment reference.
	 * @see #setCommand(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getCaseStatement_Command()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.CaseStatement#getCommand <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' containment reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

} // CaseStatement
