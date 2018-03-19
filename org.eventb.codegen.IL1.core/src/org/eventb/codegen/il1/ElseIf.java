/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.ElseIf#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.ElseIf#getAction <em>Action</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.ElseIf#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.ElseIf#getRelatedEvent <em>Related Event</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.ElseIf#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getElseIf()
 * @model
 * @generated
 */
public interface ElseIf extends IL1Element {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getElseIf_Condition()
	 * @model
	 * @generated
	 */
	EList<String> getCondition();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getElseIf_Action()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Command getAction();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.ElseIf#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Command value);

	/**
	 * Returns the value of the '<em><b>Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch</em>' containment reference.
	 * @see #setBranch(ElseIf)
	 * @see org.eventb.codegen.il1.Il1Package#getElseIf_Branch()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ElseIf getBranch();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.ElseIf#getBranch <em>Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch</em>' containment reference.
	 * @see #getBranch()
	 * @generated
	 */
	void setBranch(ElseIf value);

	/**
	 * Returns the value of the '<em><b>Related Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Event</em>' reference.
	 * @see #setRelatedEvent(Event)
	 * @see org.eventb.codegen.il1.Il1Package#getElseIf_RelatedEvent()
	 * @model
	 * @generated
	 */
	Event getRelatedEvent();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.ElseIf#getRelatedEvent <em>Related Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Event</em>' reference.
	 * @see #getRelatedEvent()
	 * @generated
	 */
	void setRelatedEvent(Event value);

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
	 * @see org.eventb.codegen.il1.Il1Package#getElseIf_EnvirStateMachineChild()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnvirStateMachineChild();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.ElseIf#isEnvirStateMachineChild <em>Envir State Machine Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Envir State Machine Child</em>' attribute.
	 * @see #isEnvirStateMachineChild()
	 * @generated
	 */
	void setEnvirStateMachineChild(boolean value);

} // ElseIf
