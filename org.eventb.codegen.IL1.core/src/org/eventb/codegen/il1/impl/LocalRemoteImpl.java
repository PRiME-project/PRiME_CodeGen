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
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Subroutine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Remote</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.LocalRemoteImpl#getLocalSubroutine <em>Local Subroutine</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.LocalRemoteImpl#getRemoteSubroutine <em>Remote Subroutine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalRemoteImpl extends IL1ElementImpl implements LocalRemote {
	/**
	 * The cached value of the '{@link #getLocalSubroutine() <em>Local Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalSubroutine()
	 * @generated
	 * @ordered
	 */
	protected Subroutine localSubroutine;

	/**
	 * The cached value of the '{@link #getRemoteSubroutine() <em>Remote Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteSubroutine()
	 * @generated
	 * @ordered
	 */
	protected Subroutine remoteSubroutine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalRemoteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.LOCAL_REMOTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine getLocalSubroutine() {
		if (localSubroutine != null && localSubroutine.eIsProxy()) {
			InternalEObject oldLocalSubroutine = (InternalEObject)localSubroutine;
			localSubroutine = (Subroutine)eResolveProxy(oldLocalSubroutine);
			if (localSubroutine != oldLocalSubroutine) {
				InternalEObject newLocalSubroutine = (InternalEObject)localSubroutine;
				NotificationChain msgs = oldLocalSubroutine.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, null, null);
				if (newLocalSubroutine.eInternalContainer() == null) {
					msgs = newLocalSubroutine.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, oldLocalSubroutine, localSubroutine));
			}
		}
		return localSubroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine basicGetLocalSubroutine() {
		return localSubroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalSubroutine(Subroutine newLocalSubroutine, NotificationChain msgs) {
		Subroutine oldLocalSubroutine = localSubroutine;
		localSubroutine = newLocalSubroutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, oldLocalSubroutine, newLocalSubroutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalSubroutine(Subroutine newLocalSubroutine) {
		if (newLocalSubroutine != localSubroutine) {
			NotificationChain msgs = null;
			if (localSubroutine != null)
				msgs = ((InternalEObject)localSubroutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, null, msgs);
			if (newLocalSubroutine != null)
				msgs = ((InternalEObject)newLocalSubroutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, null, msgs);
			msgs = basicSetLocalSubroutine(newLocalSubroutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE, newLocalSubroutine, newLocalSubroutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine getRemoteSubroutine() {
		if (remoteSubroutine != null && remoteSubroutine.eIsProxy()) {
			InternalEObject oldRemoteSubroutine = (InternalEObject)remoteSubroutine;
			remoteSubroutine = (Subroutine)eResolveProxy(oldRemoteSubroutine);
			if (remoteSubroutine != oldRemoteSubroutine) {
				InternalEObject newRemoteSubroutine = (InternalEObject)remoteSubroutine;
				NotificationChain msgs = oldRemoteSubroutine.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, null, null);
				if (newRemoteSubroutine.eInternalContainer() == null) {
					msgs = newRemoteSubroutine.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, oldRemoteSubroutine, remoteSubroutine));
			}
		}
		return remoteSubroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine basicGetRemoteSubroutine() {
		return remoteSubroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRemoteSubroutine(Subroutine newRemoteSubroutine, NotificationChain msgs) {
		Subroutine oldRemoteSubroutine = remoteSubroutine;
		remoteSubroutine = newRemoteSubroutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, oldRemoteSubroutine, newRemoteSubroutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteSubroutine(Subroutine newRemoteSubroutine) {
		if (newRemoteSubroutine != remoteSubroutine) {
			NotificationChain msgs = null;
			if (remoteSubroutine != null)
				msgs = ((InternalEObject)remoteSubroutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, null, msgs);
			if (newRemoteSubroutine != null)
				msgs = ((InternalEObject)newRemoteSubroutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, null, msgs);
			msgs = basicSetRemoteSubroutine(newRemoteSubroutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE, newRemoteSubroutine, newRemoteSubroutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE:
				return basicSetLocalSubroutine(null, msgs);
			case Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE:
				return basicSetRemoteSubroutine(null, msgs);
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
			case Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE:
				if (resolve) return getLocalSubroutine();
				return basicGetLocalSubroutine();
			case Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE:
				if (resolve) return getRemoteSubroutine();
				return basicGetRemoteSubroutine();
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
			case Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE:
				setLocalSubroutine((Subroutine)newValue);
				return;
			case Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE:
				setRemoteSubroutine((Subroutine)newValue);
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
			case Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE:
				setLocalSubroutine((Subroutine)null);
				return;
			case Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE:
				setRemoteSubroutine((Subroutine)null);
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
			case Il1Package.LOCAL_REMOTE__LOCAL_SUBROUTINE:
				return localSubroutine != null;
			case Il1Package.LOCAL_REMOTE__REMOTE_SUBROUTINE:
				return remoteSubroutine != null;
		}
		return super.eIsSet(featureID);
	}

} //LocalRemoteImpl
