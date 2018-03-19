/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subroutine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Subroutine#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Subroutine#getLocalDeclarations <em>Local Declarations</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Subroutine#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Subroutine#getGuards <em>Guards</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Subroutine#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getSubroutine()
 * @model
 * @generated
 */
public interface Subroutine extends CodeContainer, Signature, SubroutineMetaData {
	/**
	 * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formal Parameters</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getSubroutine_FormalParameters()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Parameter> getFormalParameters();

	/**
	 * Returns the value of the '<em><b>Local Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Declarations</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getSubroutine_LocalDeclarations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Declaration> getLocalDeclarations();

	/**
	 * Returns the value of the '<em><b>Guards</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guards</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getSubroutine_Guards()
	 * @model
	 * @generated
	 */
	EList<String> getGuards();

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
	 * @see org.eventb.codegen.il1.Il1Package#getSubroutine_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Subroutine#getProjectName <em>Project Name</em>}' attribute.
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
	 * @see org.eventb.codegen.il1.Il1Package#getSubroutine_MachineName()
	 * @model
	 * @generated
	 */
	String getMachineName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Subroutine#getMachineName <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Name</em>' attribute.
	 * @see #getMachineName()
	 * @generated
	 */
	void setMachineName(String value);

} // Subroutine
