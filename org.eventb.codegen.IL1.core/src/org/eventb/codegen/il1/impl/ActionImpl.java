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
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.ActionImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ActionImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends CommandImpl implements Action {
	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected Command command;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCommand() {
		if (command != null && command.eIsProxy()) {
			InternalEObject oldCommand = (InternalEObject)command;
			command = (Command)eResolveProxy(oldCommand);
			if (command != oldCommand) {
				InternalEObject newCommand = (InternalEObject)command;
				NotificationChain msgs = oldCommand.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ACTION__COMMAND, null, null);
				if (newCommand.eInternalContainer() == null) {
					msgs = newCommand.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ACTION__COMMAND, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.ACTION__COMMAND, oldCommand, command));
			}
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommand(Command newCommand, NotificationChain msgs) {
		Command oldCommand = command;
		command = newCommand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.ACTION__COMMAND, oldCommand, newCommand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(Command newCommand) {
		if (newCommand != command) {
			NotificationChain msgs = null;
			if (command != null)
				msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ACTION__COMMAND, null, msgs);
			if (newCommand != null)
				msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ACTION__COMMAND, null, msgs);
			msgs = basicSetCommand(newCommand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ACTION__COMMAND, newCommand, newCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ACTION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.ACTION__COMMAND:
				return basicSetCommand(null, msgs);
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
			case Il1Package.ACTION__COMMAND:
				if (resolve) return getCommand();
				return basicGetCommand();
			case Il1Package.ACTION__ACTION:
				return getAction();
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
			case Il1Package.ACTION__COMMAND:
				setCommand((Command)newValue);
				return;
			case Il1Package.ACTION__ACTION:
				setAction((String)newValue);
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
			case Il1Package.ACTION__COMMAND:
				setCommand((Command)null);
				return;
			case Il1Package.ACTION__ACTION:
				setAction(ACTION_EDEFAULT);
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
			case Il1Package.ACTION__COMMAND:
				return command != null;
			case Il1Package.ACTION__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
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
		result.append(" (action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
