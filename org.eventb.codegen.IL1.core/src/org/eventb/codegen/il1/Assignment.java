/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Assignment#getUpdated <em>Updated</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Assignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends Command {
	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(String)
	 * @see org.eventb.codegen.il1.Il1Package#getAssignment_Updated()
	 * @model
	 * @generated
	 */
	String getUpdated();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Assignment#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eventb.codegen.il1.Il1Package#getAssignment_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Assignment#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Assignment
