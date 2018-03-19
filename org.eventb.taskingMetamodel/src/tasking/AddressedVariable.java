/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addressed Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.AddressedVariable#getBase <em>Base</em>}</li>
 *   <li>{@link tasking.AddressedVariable#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getAddressedVariable()
 * @model
 * @generated
 */
public interface AddressedVariable extends Sensor {
	/**
	 * Returns the value of the '<em><b>Base</b></em>' attribute.
	 * The default value is <code>"16"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' attribute.
	 * @see #setBase(int)
	 * @see tasking.TaskingPackage#getAddressedVariable_Base()
	 * @model default="16"
	 * @generated
	 */
	int getBase();

	/**
	 * Sets the value of the '{@link tasking.AddressedVariable#getBase <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' attribute.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(int value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see tasking.TaskingPackage#getAddressedVariable_Address()
	 * @model required="true"
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link tasking.AddressedVariable#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

} // AddressedVariable
