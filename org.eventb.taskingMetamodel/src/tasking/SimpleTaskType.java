/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Task Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.SimpleTaskType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getSimpleTaskType()
 * @model
 * @generated
 */
public interface SimpleTaskType extends TaskType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link tasking.TaskTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see tasking.TaskTypeEnum
	 * @see #setType(TaskTypeEnum)
	 * @see tasking.TaskingPackage#getSimpleTaskType_Type()
	 * @model required="true"
	 * @generated
	 */
	TaskTypeEnum getType();

	/**
	 * Sets the value of the '{@link tasking.SimpleTaskType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see tasking.TaskTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(TaskTypeEnum value);

} // SimpleTaskType
