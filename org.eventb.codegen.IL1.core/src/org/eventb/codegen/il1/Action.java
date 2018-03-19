/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Action#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Action#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getAction()
 * @model
 * @generated
 */
public interface Action extends Command {
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
	 * @see org.eventb.codegen.il1.Il1Package#getAction_Command()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Action#getCommand <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' containment reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see org.eventb.codegen.il1.Il1Package#getAction_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Action#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

} // Action
