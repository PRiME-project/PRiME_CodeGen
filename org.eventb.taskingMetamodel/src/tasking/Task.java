/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;

import compositeControl.CompositeControl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.Task#getTaskType <em>Task Type</em>}</li>
 *   <li>{@link tasking.Task#getPriority <em>Priority</em>}</li>
 *   <li>{@link tasking.Task#getTaskBody <em>Task Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getTask()
 * @model abstract="true"
 * @generated
 */
public interface Task extends AbstractExtensionTaskingElement, MachineType {
	/**
	 * Returns the value of the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Type</em>' containment reference.
	 * @see #setTaskType(TaskType)
	 * @see tasking.TaskingPackage#getTask_TaskType()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	TaskType getTaskType();

	/**
	 * Sets the value of the '{@link tasking.Task#getTaskType <em>Task Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Type</em>' containment reference.
	 * @see #getTaskType()
	 * @generated
	 */
	void setTaskType(TaskType value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see tasking.TaskingPackage#getTask_Priority()
	 * @model default="5"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link tasking.Task#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Body</em>' containment reference.
	 * @see #setTaskBody(CompositeControl)
	 * @see tasking.TaskingPackage#getTask_TaskBody()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeControl getTaskBody();

	/**
	 * Sets the value of the '{@link tasking.Task#getTaskBody <em>Task Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Body</em>' containment reference.
	 * @see #getTaskBody()
	 * @generated
	 */
	void setTaskBody(CompositeControl value);

} // Task
