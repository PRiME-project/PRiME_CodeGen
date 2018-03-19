/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Switch;
import org.eventb.codegen.il1.SwitchBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.SwitchImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SwitchImpl#getSwitchBlocks <em>Switch Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchImpl extends CommandImpl implements Switch {
	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSwitchBlocks() <em>Switch Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchBlock> switchBlocks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.SWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SWITCH__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchBlock> getSwitchBlocks() {
		if (switchBlocks == null) {
			switchBlocks = new EObjectContainmentEList.Resolving<SwitchBlock>(SwitchBlock.class, this, Il1Package.SWITCH__SWITCH_BLOCKS);
		}
		return switchBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.SWITCH__SWITCH_BLOCKS:
				return ((InternalEList<?>)getSwitchBlocks()).basicRemove(otherEnd, msgs);
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
			case Il1Package.SWITCH__CONDITION:
				return getCondition();
			case Il1Package.SWITCH__SWITCH_BLOCKS:
				return getSwitchBlocks();
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
			case Il1Package.SWITCH__CONDITION:
				setCondition((String)newValue);
				return;
			case Il1Package.SWITCH__SWITCH_BLOCKS:
				getSwitchBlocks().clear();
				getSwitchBlocks().addAll((Collection<? extends SwitchBlock>)newValue);
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
			case Il1Package.SWITCH__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case Il1Package.SWITCH__SWITCH_BLOCKS:
				getSwitchBlocks().clear();
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
			case Il1Package.SWITCH__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
			case Il1Package.SWITCH__SWITCH_BLOCKS:
				return switchBlocks != null && !switchBlocks.isEmpty();
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
		result.append(" (condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} //SwitchImpl
