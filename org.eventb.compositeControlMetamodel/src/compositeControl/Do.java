/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Do</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.Do#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.Do#getTaskBody <em>Task Body</em>}</li>
 *   <li>{@link compositeControl.Do#getFinally <em>Finally</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getDo()
 * @model
 * @generated
 */
public interface Do extends CompositeControl {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see compositeControl.CompositeControlPackage#getDo_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link compositeControl.Do#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Body</em>' containment reference.
	 * @see #setTaskBody(EventWrapper)
	 * @see compositeControl.CompositeControlPackage#getDo_TaskBody()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventWrapper getTaskBody();

	/**
	 * Sets the value of the '{@link compositeControl.Do#getTaskBody <em>Task Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Body</em>' containment reference.
	 * @see #getTaskBody()
	 * @generated
	 */
	void setTaskBody(EventWrapper value);

	/**
	 * Returns the value of the '<em><b>Finally</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally</em>' containment reference.
	 * @see #setFinally(EventWrapper)
	 * @see compositeControl.CompositeControlPackage#getDo_Finally()
	 * @model containment="true"
	 * @generated
	 */
	EventWrapper getFinally();

	/**
	 * Sets the value of the '{@link compositeControl.Do#getFinally <em>Finally</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally</em>' containment reference.
	 * @see #getFinally()
	 * @generated
	 */
	void setFinally(EventWrapper value);

} // Do
