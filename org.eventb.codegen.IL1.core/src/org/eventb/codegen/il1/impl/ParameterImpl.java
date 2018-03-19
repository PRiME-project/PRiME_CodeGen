/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.ParameterImpl#getOrderNumber <em>Order Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterImpl extends DeclarationImpl implements Parameter {
	/**
	 * The default value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected int orderNumber = ORDER_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderNumber(int newOrderNumber) {
		int oldOrderNumber = orderNumber;
		orderNumber = newOrderNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PARAMETER__ORDER_NUMBER, oldOrderNumber, orderNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Il1Package.PARAMETER__ORDER_NUMBER:
				return getOrderNumber();
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
			case Il1Package.PARAMETER__ORDER_NUMBER:
				setOrderNumber((Integer)newValue);
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
			case Il1Package.PARAMETER__ORDER_NUMBER:
				setOrderNumber(ORDER_NUMBER_EDEFAULT);
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
			case Il1Package.PARAMETER__ORDER_NUMBER:
				return orderNumber != ORDER_NUMBER_EDEFAULT;
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
		result.append(" (orderNumber: ");
		result.append(orderNumber);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
