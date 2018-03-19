/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.RequiredFormula.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Task#getTaskType <em>Task Type</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Task#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Task#getDecls <em>Decls</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Task#getSubroutines <em>Subroutines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Task#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Task#getMachineName <em>Machine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getTask()
 * @model
 * @generated
 */
public interface Task extends CodeContainer, DataType, CallTarget {
	/**
	 * Returns the value of the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Type</em>' containment reference.
	 * @see #setTaskType(TaskType)
	 * @see org.eventb.codegen.il1.Il1Package#getTask_TaskType()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	TaskType getTaskType();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Task#getTaskType <em>Task Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Type</em>' containment reference.
	 * @see #getTaskType()
	 * @generated
	 */
	void setTaskType(TaskType value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.eventb.codegen.il1.Il1Package#getTask_Priority()
	 * @model default="5"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Task#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decls</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getTask_Decls()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Declaration> getDecls();

	/**
	 * Returns the value of the '<em><b>Subroutines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Subroutine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subroutines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subroutines</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getTask_Subroutines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Subroutine> getSubroutines();

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
	 * @see org.eventb.codegen.il1.Il1Package#getTask_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Task#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

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
	 * @see org.eventb.codegen.il1.Il1Package#getTask_MachineName()
	 * @model
	 * @generated
	 */
	String getMachineName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Task#getMachineName <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Name</em>' attribute.
	 * @see #getMachineName()
	 * @generated
	 */
	void setMachineName(String value);

} // Task
