/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.Seq#getLeftBranch <em>Left Branch</em>}</li>
 *   <li>{@link compositeControl.Seq#getRightBranch <em>Right Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getSeq()
 * @model
 * @generated
 */
public interface Seq extends CompositeControl {
	/**
	 * Returns the value of the '<em><b>Left Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Branch</em>' containment reference.
	 * @see #setLeftBranch(CompositeControl)
	 * @see compositeControl.CompositeControlPackage#getSeq_LeftBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeControl getLeftBranch();

	/**
	 * Sets the value of the '{@link compositeControl.Seq#getLeftBranch <em>Left Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Branch</em>' containment reference.
	 * @see #getLeftBranch()
	 * @generated
	 */
	void setLeftBranch(CompositeControl value);

	/**
	 * Returns the value of the '<em><b>Right Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Branch</em>' containment reference.
	 * @see #setRightBranch(CompositeControl)
	 * @see compositeControl.CompositeControlPackage#getSeq_RightBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeControl getRightBranch();

	/**
	 * Sets the value of the '{@link compositeControl.Seq#getRightBranch <em>Right Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Branch</em>' containment reference.
	 * @see #getRightBranch()
	 * @generated
	 */
	void setRightBranch(CompositeControl value);

} // Seq
