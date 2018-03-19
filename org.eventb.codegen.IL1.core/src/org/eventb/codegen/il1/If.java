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
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.If#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.If#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.If#getElse <em>Else</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.If#getRelatedEvent <em>Related Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getIf()
 * @model
 * @generated
 */
public interface If extends Command {
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
	 * @see org.eventb.codegen.il1.Il1Package#getIf_Condition()
	 * @model
	 * @generated
	 */
	EList<String> getCondition();

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
	 * @see org.eventb.codegen.il1.Il1Package#getIf_Branch()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ElseIf getBranch();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.If#getBranch <em>Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch</em>' containment reference.
	 * @see #getBranch()
	 * @generated
	 */
	void setBranch(ElseIf value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getIf_Else()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Command getElse();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.If#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(Command value);

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
	 * @see org.eventb.codegen.il1.Il1Package#getIf_RelatedEvent()
	 * @model
	 * @generated
	 */
	Event getRelatedEvent();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.If#getRelatedEvent <em>Related Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Event</em>' reference.
	 * @see #getRelatedEvent()
	 * @generated
	 */
	void setRelatedEvent(Event value);

} // If
