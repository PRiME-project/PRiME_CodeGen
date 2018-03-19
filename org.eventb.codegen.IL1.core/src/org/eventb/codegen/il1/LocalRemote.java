/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Remote</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.LocalRemote#getLocalSubroutine <em>Local Subroutine</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.LocalRemote#getRemoteSubroutine <em>Remote Subroutine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getLocalRemote()
 * @model
 * @generated
 */
public interface LocalRemote extends IL1Element {
	/**
	 * Returns the value of the '<em><b>Local Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Subroutine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Subroutine</em>' containment reference.
	 * @see #setLocalSubroutine(Subroutine)
	 * @see org.eventb.codegen.il1.Il1Package#getLocalRemote_LocalSubroutine()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Subroutine getLocalSubroutine();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.LocalRemote#getLocalSubroutine <em>Local Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Subroutine</em>' containment reference.
	 * @see #getLocalSubroutine()
	 * @generated
	 */
	void setLocalSubroutine(Subroutine value);

	/**
	 * Returns the value of the '<em><b>Remote Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Subroutine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Subroutine</em>' containment reference.
	 * @see #setRemoteSubroutine(Subroutine)
	 * @see org.eventb.codegen.il1.Il1Package#getLocalRemote_RemoteSubroutine()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Subroutine getRemoteSubroutine();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.LocalRemote#getRemoteSubroutine <em>Remote Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Subroutine</em>' containment reference.
	 * @see #getRemoteSubroutine()
	 * @generated
	 */
	void setRemoteSubroutine(Subroutine value);

} // LocalRemote
