/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subroutine Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData#isTemporary <em>Temporary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage#getSubroutineMetaData()
 * @model
 * @generated
 */
public interface SubroutineMetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>Temporary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temporary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temporary</em>' attribute.
	 * @see #setTemporary(boolean)
	 * @see org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage#getSubroutineMetaData_Temporary()
	 * @model required="true"
	 * @generated
	 */
	boolean isTemporary();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData#isTemporary <em>Temporary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temporary</em>' attribute.
	 * @see #isTemporary()
	 * @generated
	 */
	void setTemporary(boolean value);

} // SubroutineMetaData
