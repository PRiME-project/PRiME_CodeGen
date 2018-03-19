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
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.VariableDeclImpl#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclImpl extends DeclarationImpl implements VariableDecl {
	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected AddressedDeclaration address;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.VARIABLE_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressedDeclaration getAddress() {
		if (address != null && address.eIsProxy()) {
			InternalEObject oldAddress = (InternalEObject)address;
			address = (AddressedDeclaration)eResolveProxy(oldAddress);
			if (address != oldAddress) {
				InternalEObject newAddress = (InternalEObject)address;
				NotificationChain msgs = oldAddress.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.VARIABLE_DECL__ADDRESS, null, null);
				if (newAddress.eInternalContainer() == null) {
					msgs = newAddress.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.VARIABLE_DECL__ADDRESS, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.VARIABLE_DECL__ADDRESS, oldAddress, address));
			}
		}
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressedDeclaration basicGetAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(AddressedDeclaration newAddress, NotificationChain msgs) {
		AddressedDeclaration oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.VARIABLE_DECL__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(AddressedDeclaration newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.VARIABLE_DECL__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.VARIABLE_DECL__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.VARIABLE_DECL__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.VARIABLE_DECL__ADDRESS:
				return basicSetAddress(null, msgs);
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
			case Il1Package.VARIABLE_DECL__ADDRESS:
				if (resolve) return getAddress();
				return basicGetAddress();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Il1Package.VARIABLE_DECL__ADDRESS:
				setAddress((AddressedDeclaration)newValue);
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
			case Il1Package.VARIABLE_DECL__ADDRESS:
				setAddress((AddressedDeclaration)null);
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
			case Il1Package.VARIABLE_DECL__ADDRESS:
				return address != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableDeclImpl
