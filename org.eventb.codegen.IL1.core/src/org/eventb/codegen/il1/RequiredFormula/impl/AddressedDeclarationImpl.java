/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addressed Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl#getNumberBase <em>Number Base</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.RequiredFormula.impl.AddressedDeclarationImpl#getAddress <em>Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddressedDeclarationImpl extends EObjectImpl implements AddressedDeclaration {
	/**
	 * The default value of the '{@link #getNumberBase() <em>Number Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberBase()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_BASE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberBase() <em>Number Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberBase()
	 * @generated
	 * @ordered
	 */
	protected int numberBase = NUMBER_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressedDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequiredFormulaPackage.Literals.ADDRESSED_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberBase() {
		return numberBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberBase(int newNumberBase) {
		int oldNumberBase = numberBase;
		numberBase = newNumberBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequiredFormulaPackage.ADDRESSED_DECLARATION__NUMBER_BASE, oldNumberBase, numberBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequiredFormulaPackage.ADDRESSED_DECLARATION__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__NUMBER_BASE:
				return getNumberBase();
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__ADDRESS:
				return getAddress();
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
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__NUMBER_BASE:
				setNumberBase((Integer)newValue);
				return;
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__ADDRESS:
				setAddress((String)newValue);
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
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__NUMBER_BASE:
				setNumberBase(NUMBER_BASE_EDEFAULT);
				return;
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
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
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__NUMBER_BASE:
				return numberBase != NUMBER_BASE_EDEFAULT;
			case RequiredFormulaPackage.ADDRESSED_DECLARATION__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
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
		result.append(" (numberBase: ");
		result.append(numberBase);
		result.append(", address: ");
		result.append(address);
		result.append(')');
		return result.toString();
	}

} //AddressedDeclarationImpl
