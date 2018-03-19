/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Seq;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seq</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.SeqImpl#getLeftBranch <em>Left Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SeqImpl#getRightBranch <em>Right Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeqImpl extends CommandImpl implements Seq {
	/**
	 * The cached value of the '{@link #getLeftBranch() <em>Left Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftBranch()
	 * @generated
	 * @ordered
	 */
	protected Command leftBranch;

	/**
	 * The cached value of the '{@link #getRightBranch() <em>Right Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightBranch()
	 * @generated
	 * @ordered
	 */
	protected Command rightBranch;

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
		return Il1Package.Literals.SEQ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getLeftBranch() {
		if (leftBranch != null && leftBranch.eIsProxy()) {
			InternalEObject oldLeftBranch = (InternalEObject)leftBranch;
			leftBranch = (Command)eResolveProxy(oldLeftBranch);
			if (leftBranch != oldLeftBranch) {
				InternalEObject newLeftBranch = (InternalEObject)leftBranch;
				NotificationChain msgs = oldLeftBranch.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__LEFT_BRANCH, null, null);
				if (newLeftBranch.eInternalContainer() == null) {
					msgs = newLeftBranch.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__LEFT_BRANCH, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.SEQ__LEFT_BRANCH, oldLeftBranch, leftBranch));
			}
		}
		return leftBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetLeftBranch() {
		return leftBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftBranch(Command newLeftBranch, NotificationChain msgs) {
		Command oldLeftBranch = leftBranch;
		leftBranch = newLeftBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.SEQ__LEFT_BRANCH, oldLeftBranch, newLeftBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftBranch(Command newLeftBranch) {
		if (newLeftBranch != leftBranch) {
			NotificationChain msgs = null;
			if (leftBranch != null)
				msgs = ((InternalEObject)leftBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__LEFT_BRANCH, null, msgs);
			if (newLeftBranch != null)
				msgs = ((InternalEObject)newLeftBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__LEFT_BRANCH, null, msgs);
			msgs = basicSetLeftBranch(newLeftBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SEQ__LEFT_BRANCH, newLeftBranch, newLeftBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getRightBranch() {
		if (rightBranch != null && rightBranch.eIsProxy()) {
			InternalEObject oldRightBranch = (InternalEObject)rightBranch;
			rightBranch = (Command)eResolveProxy(oldRightBranch);
			if (rightBranch != oldRightBranch) {
				InternalEObject newRightBranch = (InternalEObject)rightBranch;
				NotificationChain msgs = oldRightBranch.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__RIGHT_BRANCH, null, null);
				if (newRightBranch.eInternalContainer() == null) {
					msgs = newRightBranch.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__RIGHT_BRANCH, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.SEQ__RIGHT_BRANCH, oldRightBranch, rightBranch));
			}
		}
		return rightBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetRightBranch() {
		return rightBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightBranch(Command newRightBranch, NotificationChain msgs) {
		Command oldRightBranch = rightBranch;
		rightBranch = newRightBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.SEQ__RIGHT_BRANCH, oldRightBranch, newRightBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightBranch(Command newRightBranch) {
		if (newRightBranch != rightBranch) {
			NotificationChain msgs = null;
			if (rightBranch != null)
				msgs = ((InternalEObject)rightBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__RIGHT_BRANCH, null, msgs);
			if (newRightBranch != null)
				msgs = ((InternalEObject)newRightBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SEQ__RIGHT_BRANCH, null, msgs);
			msgs = basicSetRightBranch(newRightBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SEQ__RIGHT_BRANCH, newRightBranch, newRightBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.SEQ__LEFT_BRANCH:
				return basicSetLeftBranch(null, msgs);
			case Il1Package.SEQ__RIGHT_BRANCH:
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
			case Il1Package.SEQ__LEFT_BRANCH:
				if (resolve) return getLeftBranch();
				return basicGetLeftBranch();
			case Il1Package.SEQ__RIGHT_BRANCH:
				if (resolve) return getRightBranch();
				return basicGetRightBranch();
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
			case Il1Package.SEQ__LEFT_BRANCH:
				setLeftBranch((Command)newValue);
				return;
			case Il1Package.SEQ__RIGHT_BRANCH:
				setRightBranch((Command)newValue);
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
			case Il1Package.SEQ__LEFT_BRANCH:
				setLeftBranch((Command)null);
				return;
			case Il1Package.SEQ__RIGHT_BRANCH:
				setRightBranch((Command)null);
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
			case Il1Package.SEQ__LEFT_BRANCH:
				return leftBranch != null;
			case Il1Package.SEQ__RIGHT_BRANCH:
				return rightBranch != null;
		}
		return super.eIsSet(featureID);
	}

} //SeqImpl
