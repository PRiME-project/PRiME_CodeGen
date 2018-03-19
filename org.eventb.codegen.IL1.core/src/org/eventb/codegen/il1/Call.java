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
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Call#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Call#getSubroutine <em>Subroutine</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Call#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Call#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Call#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getCall()
 * @model
 * @generated
 */
public interface Call extends Command {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(CallTarget)
	 * @see org.eventb.codegen.il1.Il1Package#getCall_Target()
	 * @model
	 * @generated
	 */
	CallTarget getTarget();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Call#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(CallTarget value);

	/**
	 * Returns the value of the '<em><b>Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subroutine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subroutine</em>' containment reference.
	 * @see #setSubroutine(Subroutine)
	 * @see org.eventb.codegen.il1.Il1Package#getCall_Subroutine()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Subroutine getSubroutine();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Call#getSubroutine <em>Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subroutine</em>' containment reference.
	 * @see #getSubroutine()
	 * @generated
	 */
	void setSubroutine(Subroutine value);

	/**
	 * Returns the value of the '<em><b>Actual Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Parameters</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getCall_ActualParameters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getActualParameters();

	/**
	 * Returns the value of the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Name</em>' attribute.
	 * @see #setMachineName(String)
	 * @see org.eventb.codegen.il1.Il1Package#getCall_MachineName()
	 * @model
	 * @generated
	 */
	String getMachineName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Call#getMachineName <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Name</em>' attribute.
	 * @see #getMachineName()
	 * @generated
	 */
	void setMachineName(String value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.eventb.codegen.il1.Il1Package#getCall_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Call#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

} // Call
