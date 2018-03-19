/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.impl.AbstractExtensionImpl;

import compositeControl.CompositeControl;
import compositeControl.CompositeControlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.CompositeControlImpl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeControlImpl extends AbstractExtensionImpl implements CompositeControl {
	/**
	 * The default value of the '{@link #isEnvirStateMachineChild() <em>Envir State Machine Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnvirStateMachineChild()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENVIR_STATE_MACHINE_CHILD_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isEnvirStateMachineChild() <em>Envir State Machine Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnvirStateMachineChild()
	 * @generated
	 * @ordered
	 */
	protected boolean envirStateMachineChild = ENVIR_STATE_MACHINE_CHILD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.COMPOSITE_CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnvirStateMachineChild() {
		return envirStateMachineChild;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvirStateMachineChild(boolean newEnvirStateMachineChild) {
		boolean oldEnvirStateMachineChild = envirStateMachineChild;
		envirStateMachineChild = newEnvirStateMachineChild;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD, oldEnvirStateMachineChild, envirStateMachineChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD:
				return isEnvirStateMachineChild();
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
			case CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD:
				setEnvirStateMachineChild((Boolean)newValue);
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
			case CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD:
				setEnvirStateMachineChild(ENVIR_STATE_MACHINE_CHILD_EDEFAULT);
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
			case CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD:
				return envirStateMachineChild != ENVIR_STATE_MACHINE_CHILD_EDEFAULT;
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
		result.append(" (envirStateMachineChild: ");
		result.append(envirStateMachineChild);
		result.append(')');
		return result.toString();
	}

} //CompositeControlImpl
