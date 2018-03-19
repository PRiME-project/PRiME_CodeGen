/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.ParameterType#getParameterType <em>Parameter Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getParameterType()
 * @model
 * @generated
 */
public interface ParameterType extends AbstractExtensionTaskingElement {
	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' attribute.
	 * The literals are from the enumeration {@link tasking.ParameterTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' attribute.
	 * @see tasking.ParameterTypeEnum
	 * @see #setParameterType(ParameterTypeEnum)
	 * @see tasking.TaskingPackage#getParameterType_ParameterType()
	 * @model required="true"
	 * @generated
	 */
	ParameterTypeEnum getParameterType();

	/**
	 * Sets the value of the '{@link tasking.ParameterType#getParameterType <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Type</em>' attribute.
	 * @see tasking.ParameterTypeEnum
	 * @see #getParameterType()
	 * @generated
	 */
	void setParameterType(ParameterTypeEnum value);

} // ParameterType
