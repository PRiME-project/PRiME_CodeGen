/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodic Task Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.PeriodicTaskType#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getPeriodicTaskType()
 * @model
 * @generated
 */
public interface PeriodicTaskType extends TaskType {
	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(int)
	 * @see tasking.TaskingPackage#getPeriodicTaskType_Period()
	 * @model required="true"
	 * @generated
	 */
	int getPeriod();

	/**
	 * Sets the value of the '{@link tasking.PeriodicTaskType#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(int value);

} // PeriodicTaskType
