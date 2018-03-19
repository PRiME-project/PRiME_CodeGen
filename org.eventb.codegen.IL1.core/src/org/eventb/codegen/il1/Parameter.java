/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Parameter#getOrderNumber <em>Order Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getParameter()
 * @model abstract="true"
 * @generated
 */
public interface Parameter extends Declaration {
	/**
	 * Returns the value of the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order Number</em>' attribute.
	 * @see #setOrderNumber(int)
	 * @see org.eventb.codegen.il1.Il1Package#getParameter_OrderNumber()
	 * @model
	 * @generated
	 */
	int getOrderNumber();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Parameter#getOrderNumber <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order Number</em>' attribute.
	 * @see #getOrderNumber()
	 * @generated
	 */
	void setOrderNumber(int value);

} // Parameter
