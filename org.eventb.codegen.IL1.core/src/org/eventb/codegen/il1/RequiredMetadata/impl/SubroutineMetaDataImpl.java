/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subroutine Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.RequiredMetadata.impl.SubroutineMetaDataImpl#isTemporary <em>Temporary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubroutineMetaDataImpl extends EObjectImpl implements SubroutineMetaData {
	/**
	 * The default value of the '{@link #isTemporary() <em>Temporary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemporary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPORARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemporary() <em>Temporary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemporary()
	 * @generated
	 * @ordered
	 */
	protected boolean temporary = TEMPORARY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubroutineMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequiredMetadataPackage.Literals.SUBROUTINE_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemporary() {
		return temporary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemporary(boolean newTemporary) {
		boolean oldTemporary = temporary;
		temporary = newTemporary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY, oldTemporary, temporary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY:
				return isTemporary();
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
			case RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY:
				setTemporary((Boolean)newValue);
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
			case RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY:
				setTemporary(TEMPORARY_EDEFAULT);
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
			case RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY:
				return temporary != TEMPORARY_EDEFAULT;
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
		result.append(" (temporary: ");
		result.append(temporary);
		result.append(')');
		return result.toString();
	}

} //SubroutineMetaDataImpl
