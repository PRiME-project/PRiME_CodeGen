/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.EventWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Do</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.DoImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.impl.DoImpl#getTaskBody <em>Task Body</em>}</li>
 *   <li>{@link compositeControl.impl.DoImpl#getFinally <em>Finally</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoImpl extends CompositeControlImpl implements Do {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaskBody() <em>Task Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskBody()
	 * @generated
	 * @ordered
	 */
	protected EventWrapper taskBody;

	/**
	 * The cached value of the '{@link #getFinally() <em>Finally</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinally()
	 * @generated
	 * @ordered
	 */
	protected EventWrapper finally_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.DO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.DO__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper getTaskBody() {
		return taskBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskBody(EventWrapper newTaskBody, NotificationChain msgs) {
		EventWrapper oldTaskBody = taskBody;
		taskBody = newTaskBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.DO__TASK_BODY, oldTaskBody, newTaskBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskBody(EventWrapper newTaskBody) {
		if (newTaskBody != taskBody) {
			NotificationChain msgs = null;
			if (taskBody != null)
				msgs = ((InternalEObject)taskBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.DO__TASK_BODY, null, msgs);
			if (newTaskBody != null)
				msgs = ((InternalEObject)newTaskBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.DO__TASK_BODY, null, msgs);
			msgs = basicSetTaskBody(newTaskBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.DO__TASK_BODY, newTaskBody, newTaskBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper getFinally() {
		return finally_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinally(EventWrapper newFinally, NotificationChain msgs) {
		EventWrapper oldFinally = finally_;
		finally_ = newFinally;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.DO__FINALLY, oldFinally, newFinally);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinally(EventWrapper newFinally) {
		if (newFinally != finally_) {
			NotificationChain msgs = null;
			if (finally_ != null)
				msgs = ((InternalEObject)finally_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.DO__FINALLY, null, msgs);
			if (newFinally != null)
				msgs = ((InternalEObject)newFinally).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.DO__FINALLY, null, msgs);
			msgs = basicSetFinally(newFinally, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.DO__FINALLY, newFinally, newFinally));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositeControlPackage.DO__TASK_BODY:
				return basicSetTaskBody(null, msgs);
			case CompositeControlPackage.DO__FINALLY:
				return basicSetFinally(null, msgs);
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
			case CompositeControlPackage.DO__LABEL:
				return getLabel();
			case CompositeControlPackage.DO__TASK_BODY:
				return getTaskBody();
			case CompositeControlPackage.DO__FINALLY:
				return getFinally();
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
			case CompositeControlPackage.DO__LABEL:
				setLabel((String)newValue);
				return;
			case CompositeControlPackage.DO__TASK_BODY:
				setTaskBody((EventWrapper)newValue);
				return;
			case CompositeControlPackage.DO__FINALLY:
				setFinally((EventWrapper)newValue);
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
			case CompositeControlPackage.DO__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case CompositeControlPackage.DO__TASK_BODY:
				setTaskBody((EventWrapper)null);
				return;
			case CompositeControlPackage.DO__FINALLY:
				setFinally((EventWrapper)null);
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
			case CompositeControlPackage.DO__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case CompositeControlPackage.DO__TASK_BODY:
				return taskBody != null;
			case CompositeControlPackage.DO__FINALLY:
				return finally_ != null;
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //DoImpl
