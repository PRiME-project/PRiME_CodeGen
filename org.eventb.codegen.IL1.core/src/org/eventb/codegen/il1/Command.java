/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Command#getParentEventName <em>Parent Event Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Command#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getCommand()
 * @model abstract="true"
 * @generated
 */
public interface Command extends CodeContainer {

	/**
	 * Returns the value of the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Event Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Event Name</em>' attribute.
	 * @see #setParentEventName(String)
	 * @see org.eventb.codegen.il1.Il1Package#getCommand_ParentEventName()
	 * @model
	 * @generated
	 */
	String getParentEventName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Command#getParentEventName <em>Parent Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Event Name</em>' attribute.
	 * @see #getParentEventName()
	 * @generated
	 */
	void setParentEventName(String value);

	/**
	 * Returns the value of the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Envir State Machine Child</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Envir State Machine Child</em>' attribute.
	 * @see #setEnvirStateMachineChild(boolean)
	 * @see org.eventb.codegen.il1.Il1Package#getCommand_EnvirStateMachineChild()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnvirStateMachineChild();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Command#isEnvirStateMachineChild <em>Envir State Machine Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Envir State Machine Child</em>' attribute.
	 * @see #isEnvirStateMachineChild()
	 * @generated
	 */
	void setEnvirStateMachineChild(boolean value);
} // Command
