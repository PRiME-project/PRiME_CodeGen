/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tasking.Task;
import tasking.TaskType;
import tasking.TaskingPackage;

import compositeControl.CompositeControl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tasking.impl.TaskImpl#getTaskType <em>Task Type</em>}</li>
 *   <li>{@link tasking.impl.TaskImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link tasking.impl.TaskImpl#getTaskBody <em>Task Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TaskImpl extends AbstractExtensionTaskingElementImpl implements Task {
	/**
	 * The cached value of the '{@link #getTaskType() <em>Task Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskType()
	 * @generated
	 * @ordered
	 */
	protected TaskType taskType;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 5;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaskBody() <em>Task Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskBody()
	 * @generated
	 * @ordered
	 */
	protected CompositeControl taskBody;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskingPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskType getTaskType() {
		if (taskType != null && taskType.eIsProxy()) {
			InternalEObject oldTaskType = (InternalEObject)taskType;
			taskType = (TaskType)eResolveProxy(oldTaskType);
			if (taskType != oldTaskType) {
				InternalEObject newTaskType = (InternalEObject)taskType;
				NotificationChain msgs = oldTaskType.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_TYPE, null, null);
				if (newTaskType.eInternalContainer() == null) {
					msgs = newTaskType.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_TYPE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TaskingPackage.TASK__TASK_TYPE, oldTaskType, taskType));
			}
		}
		return taskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskType basicGetTaskType() {
		return taskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskType(TaskType newTaskType, NotificationChain msgs) {
		TaskType oldTaskType = taskType;
		taskType = newTaskType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TaskingPackage.TASK__TASK_TYPE, oldTaskType, newTaskType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskType(TaskType newTaskType) {
		if (newTaskType != taskType) {
			NotificationChain msgs = null;
			if (taskType != null)
				msgs = ((InternalEObject)taskType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_TYPE, null, msgs);
			if (newTaskType != null)
				msgs = ((InternalEObject)newTaskType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_TYPE, null, msgs);
			msgs = basicSetTaskType(newTaskType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.TASK__TASK_TYPE, newTaskType, newTaskType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.TASK__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControl getTaskBody() {
		return taskBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskBody(CompositeControl newTaskBody, NotificationChain msgs) {
		CompositeControl oldTaskBody = taskBody;
		taskBody = newTaskBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TaskingPackage.TASK__TASK_BODY, oldTaskBody, newTaskBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskBody(CompositeControl newTaskBody) {
		if (newTaskBody != taskBody) {
			NotificationChain msgs = null;
			if (taskBody != null)
				msgs = ((InternalEObject)taskBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_BODY, null, msgs);
			if (newTaskBody != null)
				msgs = ((InternalEObject)newTaskBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.TASK__TASK_BODY, null, msgs);
			msgs = basicSetTaskBody(newTaskBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.TASK__TASK_BODY, newTaskBody, newTaskBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TaskingPackage.TASK__TASK_TYPE:
				return basicSetTaskType(null, msgs);
			case TaskingPackage.TASK__TASK_BODY:
				return basicSetTaskBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TaskingPackage.TASK__TASK_TYPE:
				if (resolve) return getTaskType();
				return basicGetTaskType();
			case TaskingPackage.TASK__PRIORITY:
				return getPriority();
			case TaskingPackage.TASK__TASK_BODY:
				return getTaskBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TaskingPackage.TASK__TASK_TYPE:
				setTaskType((TaskType)newValue);
				return;
			case TaskingPackage.TASK__PRIORITY:
				setPriority((Integer)newValue);
				return;
			case TaskingPackage.TASK__TASK_BODY:
				setTaskBody((CompositeControl)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TaskingPackage.TASK__TASK_TYPE:
				setTaskType((TaskType)null);
				return;
			case TaskingPackage.TASK__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case TaskingPackage.TASK__TASK_BODY:
				setTaskBody((CompositeControl)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TaskingPackage.TASK__TASK_TYPE:
				return taskType != null;
			case TaskingPackage.TASK__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case TaskingPackage.TASK__TASK_BODY:
				return taskBody != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} //TaskImpl
