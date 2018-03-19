/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Seq#getLeftBranch <em>Left Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Seq#getRightBranch <em>Right Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getSeq()
 * @model
 * @generated
 */
public interface Seq extends Command {
	/**
	 * Returns the value of the '<em><b>Left Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Branch</em>' containment reference.
	 * @see #setLeftBranch(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getSeq_LeftBranch()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Command getLeftBranch();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Seq#getLeftBranch <em>Left Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Branch</em>' containment reference.
	 * @see #getLeftBranch()
	 * @generated
	 */
	void setLeftBranch(Command value);

	/**
	 * Returns the value of the '<em><b>Right Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Branch</em>' containment reference.
	 * @see #setRightBranch(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getSeq_RightBranch()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Command getRightBranch();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Seq#getRightBranch <em>Right Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Branch</em>' containment reference.
	 * @see #getRightBranch()
	 * @generated
	 */
	void setRightBranch(Command value);

} // Seq
