/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.Implementation#getImplementationType <em>Implementation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getImplementation()
 * @model
 * @generated
 */
public interface Implementation extends AbstractExtensionTaskingElement {
	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link tasking.ImplementationTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see tasking.ImplementationTypeEnum
	 * @see #setImplementationType(ImplementationTypeEnum)
	 * @see tasking.TaskingPackage#getImplementation_ImplementationType()
	 * @model
	 * @generated
	 */
	ImplementationTypeEnum getImplementationType();

	/**
	 * Sets the value of the '{@link tasking.Implementation#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see tasking.ImplementationTypeEnum
	 * @see #getImplementationType()
	 * @generated
	 */
	void setImplementationType(ImplementationTypeEnum value);

} // Implementation
