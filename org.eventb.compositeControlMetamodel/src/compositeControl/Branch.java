/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.Branch#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.Branch#getEventWrapper <em>Event Wrapper</em>}</li>
 *   <li>{@link compositeControl.Branch#getSubBranch <em>Sub Branch</em>}</li>
 *   <li>{@link compositeControl.Branch#getAlt <em>Alt</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getBranch()
 * @model
 * @generated
 */
public interface Branch extends CompositeControl {
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
	 * @see compositeControl.CompositeControlPackage#getBranch_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link compositeControl.Branch#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

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
	 * @see compositeControl.CompositeControlPackage#getBranch_EventWrapper()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EventWrapper getEventWrapper();

	/**
	 * Sets the value of the '{@link compositeControl.Branch#getEventWrapper <em>Event Wrapper</em>}' containment reference.
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
	 * @see compositeControl.CompositeControlPackage#getBranch_SubBranch()
	 * @model containment="true"
	 * @generated
	 */
	SubBranch getSubBranch();

	/**
	 * Sets the value of the '{@link compositeControl.Branch#getSubBranch <em>Sub Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Branch</em>' containment reference.
	 * @see #getSubBranch()
	 * @generated
	 */
	void setSubBranch(SubBranch value);

	/**
	 * Returns the value of the '<em><b>Alt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alt</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alt</em>' containment reference.
	 * @see #setAlt(EventWrapper)
	 * @see compositeControl.CompositeControlPackage#getBranch_Alt()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EventWrapper getAlt();

	/**
	 * Sets the value of the '{@link compositeControl.Branch#getAlt <em>Alt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alt</em>' containment reference.
	 * @see #getAlt()
	 * @generated
	 */
	void setAlt(EventWrapper value);

} // Branch
