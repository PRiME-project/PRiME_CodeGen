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
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Program#getDecls <em>Decls</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getProtected <em>Protected</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getEntryPoint <em>Entry Point</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getTaskTypeTasks <em>Task Type Tasks</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getSubroutines <em>Subroutines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getEnvironMachines <em>Environ Machines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Program#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getProgram()
 * @model
 * @generated
 */
public interface Program extends Signature {
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
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_Decls()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Declaration> getDecls();

	/**
	 * Returns the value of the '<em><b>Protected</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Protected}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protected</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protected</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_Protected()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Protected> getProtected();

	/**
	 * Returns the value of the '<em><b>Entry Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Point</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Point</em>' containment reference.
	 * @see #setEntryPoint(MainEntry)
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_EntryPoint()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	MainEntry getEntryPoint();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Program#getEntryPoint <em>Entry Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Point</em>' containment reference.
	 * @see #getEntryPoint()
	 * @generated
	 */
	void setEntryPoint(MainEntry value);

	/**
	 * Returns the value of the '<em><b>Task Type Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Type Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Type Tasks</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_TaskTypeTasks()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Task> getTaskTypeTasks();

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
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_Subroutines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Subroutine> getSubroutines();

	/**
	 * Returns the value of the '<em><b>Environ Machines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.EnvironTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environ Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environ Machines</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_EnvironMachines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EnvironTask> getEnvironMachines();

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
	 * @see org.eventb.codegen.il1.Il1Package#getProgram_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Program#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

} // Program
