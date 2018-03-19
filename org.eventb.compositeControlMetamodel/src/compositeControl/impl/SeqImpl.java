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

import compositeControl.CompositeControl;
import compositeControl.CompositeControlPackage;
import compositeControl.Seq;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seq</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.SeqImpl#getLeftBranch <em>Left Branch</em>}</li>
 *   <li>{@link compositeControl.impl.SeqImpl#getRightBranch <em>Right Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeqImpl extends CompositeControlImpl implements Seq {
	/**
	 * The cached value of the '{@link #getLeftBranch() <em>Left Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftBranch()
	 * @generated
	 * @ordered
	 */
	protected CompositeControl leftBranch;

	/**
	 * The cached value of the '{@link #getRightBranch() <em>Right Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightBranch()
	 * @generated
	 * @ordered
	 */
	protected CompositeControl rightBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeqImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.SEQ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControl getLeftBranch() {
		return leftBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftBranch(CompositeControl newLeftBranch, NotificationChain msgs) {
		CompositeControl oldLeftBranch = leftBranch;
		leftBranch = newLeftBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SEQ__LEFT_BRANCH, oldLeftBranch, newLeftBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftBranch(CompositeControl newLeftBranch) {
		if (newLeftBranch != leftBranch) {
			NotificationChain msgs = null;
			if (leftBranch != null)
				msgs = ((InternalEObject)leftBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SEQ__LEFT_BRANCH, null, msgs);
			if (newLeftBranch != null)
				msgs = ((InternalEObject)newLeftBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SEQ__LEFT_BRANCH, null, msgs);
			msgs = basicSetLeftBranch(newLeftBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SEQ__LEFT_BRANCH, newLeftBranch, newLeftBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControl getRightBranch() {
		return rightBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightBranch(CompositeControl newRightBranch, NotificationChain msgs) {
		CompositeControl oldRightBranch = rightBranch;
		rightBranch = newRightBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SEQ__RIGHT_BRANCH, oldRightBranch, newRightBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightBranch(CompositeControl newRightBranch) {
		if (newRightBranch != rightBranch) {
			NotificationChain msgs = null;
			if (rightBranch != null)
				msgs = ((InternalEObject)rightBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SEQ__RIGHT_BRANCH, null, msgs);
			if (newRightBranch != null)
				msgs = ((InternalEObject)newRightBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.SEQ__RIGHT_BRANCH, null, msgs);
			msgs = basicSetRightBranch(newRightBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SEQ__RIGHT_BRANCH, newRightBranch, newRightBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositeControlPackage.SEQ__LEFT_BRANCH:
				return basicSetLeftBranch(null, msgs);
			case CompositeControlPackage.SEQ__RIGHT_BRANCH:
				return basicSetRightBranch(null, msgs);
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
			case CompositeControlPackage.SEQ__LEFT_BRANCH:
				return getLeftBranch();
			case CompositeControlPackage.SEQ__RIGHT_BRANCH:
				return getRightBranch();
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
			case CompositeControlPackage.SEQ__LEFT_BRANCH:
				setLeftBranch((CompositeControl)newValue);
				return;
			case CompositeControlPackage.SEQ__RIGHT_BRANCH:
				setRightBranch((CompositeControl)newValue);
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
			case CompositeControlPackage.SEQ__LEFT_BRANCH:
				setLeftBranch((CompositeControl)null);
				return;
			case CompositeControlPackage.SEQ__RIGHT_BRANCH:
				setRightBranch((CompositeControl)null);
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
			case CompositeControlPackage.SEQ__LEFT_BRANCH:
				return leftBranch != null;
			case CompositeControlPackage.SEQ__RIGHT_BRANCH:
				return rightBranch != null;
		}
		return super.eIsSet(featureID);
	}

} //SeqImpl
