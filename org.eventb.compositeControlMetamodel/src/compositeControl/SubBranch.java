/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.SubBranch#getEventWrapper <em>Event Wrapper</em>}</li>
 *   <li>{@link compositeControl.SubBranch#getSubBranch <em>Sub Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getSubBranch()
 * @model
 * @generated
 */
public interface SubBranch extends CompositeControl {
	/**
	 * Returns the value of the '<em><b>Event Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Wrapper</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Wrapper</em>' containment reference.
	 * @see #setEventWrapper(EventWrapper)
	 * @see compositeControl.CompositeControlPackage#getSubBranch_EventWrapper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventWrapper getEventWrapper();

	/**
	 * Sets the value of the '{@link compositeControl.SubBranch#getEventWrapper <em>Event Wrapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Wrapper</em>' containment reference.
	 * @see #getEventWrapper()
	 * @generated
	 */
	void setEventWrapper(EventWrapper value);

	/**
	 * Returns the value of the '<em><b>Sub Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Branch</em>' containment reference.
	 * @see #setSubBranch(SubBranch)
	 * @see compositeControl.CompositeControlPackage#getSubBranch_SubBranch()
	 * @model containment="true"
	 * @generated
	 */
	SubBranch getSubBranch();

	/**
	 * Sets the value of the '{@link compositeControl.SubBranch#getSubBranch <em>Sub Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Branch</em>' containment reference.
	 * @see #getSubBranch()
	 * @generated
	 */
	void setSubBranch(SubBranch value);

} // SubBranch
