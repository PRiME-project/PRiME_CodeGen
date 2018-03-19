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
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.CommandImpl#getParentEventName <em>Parent Event Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CommandImpl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommandImpl extends CodeContainerImpl implements Command {
	/**
	 * The default value of the '{@link #getParentEventName() <em>Parent Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentEventName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_EVENT_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getParentEventName() <em>Parent Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentEventName()
	 * @generated
	 * @ordered
	 */
	protected String parentEventName = PARENT_EVENT_NAME_EDEFAULT;

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
	protected CommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentEventName() {
		return parentEventName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentEventName(String newParentEventName) {
		String oldParentEventName = parentEventName;
		parentEventName = newParentEventName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.COMMAND__PARENT_EVENT_NAME, oldParentEventName, parentEventName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.COMMAND__ENVIR_STATE_MACHINE_CHILD, oldEnvirStateMachineChild, envirStateMachineChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Il1Package.COMMAND__PARENT_EVENT_NAME:
				return getParentEventName();
			case Il1Package.COMMAND__ENVIR_STATE_MACHINE_CHILD:
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
			case Il1Package.COMMAND__PARENT_EVENT_NAME:
				setParentEventName((String)newValue);
				return;
			case Il1Package.COMMAND__ENVIR_STATE_MACHINE_CHILD:
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
			case Il1Package.COMMAND__PARENT_EVENT_NAME:
				setParentEventName(PARENT_EVENT_NAME_EDEFAULT);
				return;
			case Il1Package.COMMAND__ENVIR_STATE_MACHINE_CHILD:
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
			case Il1Package.COMMAND__PARENT_EVENT_NAME:
				return PARENT_EVENT_NAME_EDEFAULT == null ? parentEventName != null : !PARENT_EVENT_NAME_EDEFAULT.equals(parentEventName);
			case Il1Package.COMMAND__ENVIR_STATE_MACHINE_CHILD:
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
		result.append(" (ParentEventName: ");
		result.append(parentEventName);
		result.append(", envirStateMachineChild: ");
		result.append(envirStateMachineChild);
		result.append(')');
		return result.toString();
	}

} //CommandImpl
