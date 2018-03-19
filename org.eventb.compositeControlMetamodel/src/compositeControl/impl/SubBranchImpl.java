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
import compositeControl.EventWrapper;
import compositeControl.SubBranch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.SubBranchImpl#getEventWrapper <em>Event Wrapper</em>}</li>
 *   <li>{@link compositeControl.impl.SubBranchImpl#getSubBranch <em>Sub Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubBranchImpl extends CompositeControlImpl implements SubBranch {
	/**
	 * The cached value of the '{@link #getEventWrapper() <em>Event Wrapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventWrapper()
	 * @generated
	 * @ordered
	 */
	protected EventWrapper eventWrapper;

	/**
	 * The cached value of the '{@link #getSubBranch() <em>Sub Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubBranch()
	 * @generated
	 * @ordered
	 */
	protected SubBranch subBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubBranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.SUB_BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper getEventWrapper() {
		return eventWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventWrapper(EventWrapper newEventWrapper, NotificationChain msgs) {
		EventWrapper oldEventWrapper = eventWrapper;
		eventWrapper = newEventWrapper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER, oldEventWrapper, newEventWrapper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventWrapper(EventWrapper newEventWrapper) {
		if (newEventWrapper != eventWrapper) {
			NotificationChain msgs = null;
			if (eventWrapper != null)
				msgs = ((InternalEObject)eventWrapper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER, null, msgs);
			if (newEventWrapper != null)
				msgs = ((InternalEObject)newEventWrapper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER, null, msgs);
			msgs = basicSetEventWrapper(newEventWrapper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER, newEventWrapper, newEventWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubBranch getSubBranch() {
		return subBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubBranch(SubBranch newSubBranch, NotificationChain msgs) {
		SubBranch oldSubBranch = subBranch;
		subBranch = newSubBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SUB_BRANCH__SUB_BRANCH, oldSubBranch, newSubBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubBranch(SubBranch newSubBranch) {
		if (newSubBranch != subBranch) {
			NotificationChain msgs = null;
			if (subBranch != null)
				msgs = ((InternalEObject)subBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SUB_BRANCH__SUB_BRANCH, null, msgs);
			if (newSubBranch != null)
				msgs = ((InternalEObject)newSubBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SUB_BRANCH__SUB_BRANCH, null, msgs);
			msgs = basicSetSubBranch(newSubBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SUB_BRANCH__SUB_BRANCH, newSubBranch, newSubBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER:
				return basicSetEventWrapper(null, msgs);
			case CompositeControlPackage.SUB_BRANCH__SUB_BRANCH:
				return basicSetSubBranch(null, msgs);
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
			case CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER:
				return getEventWrapper();
			case CompositeControlPackage.SUB_BRANCH__SUB_BRANCH:
				return getSubBranch();
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
			case CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER:
				setEventWrapper((EventWrapper)newValue);
				return;
			case CompositeControlPackage.SUB_BRANCH__SUB_BRANCH:
				setSubBranch((SubBranch)newValue);
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
			case CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER:
				setEventWrapper((EventWrapper)null);
				return;
			case CompositeControlPackage.SUB_BRANCH__SUB_BRANCH:
				setSubBranch((SubBranch)null);
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
			case CompositeControlPackage.SUB_BRANCH__EVENT_WRAPPER:
				return eventWrapper != null;
			case CompositeControlPackage.SUB_BRANCH__SUB_BRANCH:
				return subBranch != null;
		}
		return super.eIsSet(featureID);
	}

} //SubBranchImpl
