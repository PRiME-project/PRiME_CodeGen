/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tasking.ParameterType;
import tasking.ParameterTypeEnum;
import tasking.TaskingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tasking.impl.ParameterTypeImpl#getParameterType <em>Parameter Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterTypeImpl extends AbstractExtensionTaskingElementImpl implements ParameterType {
	/**
	 * The default value of the '{@link #getParameterType() <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterTypeEnum PARAMETER_TYPE_EDEFAULT = ParameterTypeEnum.IN;

	/**
	 * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected ParameterTypeEnum parameterType = PARAMETER_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskingPackage.Literals.PARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTypeEnum getParameterType() {
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterType(ParameterTypeEnum newParameterType) {
		ParameterTypeEnum oldParameterType = parameterType;
		parameterType = newParameterType == null ? PARAMETER_TYPE_EDEFAULT : newParameterType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.PARAMETER_TYPE__PARAMETER_TYPE, oldParameterType, parameterType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TaskingPackage.PARAMETER_TYPE__PARAMETER_TYPE:
				return getParameterType();
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
			case TaskingPackage.PARAMETER_TYPE__PARAMETER_TYPE:
				setParameterType((ParameterTypeEnum)newValue);
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
			case TaskingPackage.PARAMETER_TYPE__PARAMETER_TYPE:
				setParameterType(PARAMETER_TYPE_EDEFAULT);
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
			case TaskingPackage.PARAMETER_TYPE__PARAMETER_TYPE:
				return parameterType != PARAMETER_TYPE_EDEFAULT;
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
		result.append(" (parameterType: ");
		result.append(parameterType);
		result.append(')');
		return result.toString();
	}

} //ParameterTypeImpl
