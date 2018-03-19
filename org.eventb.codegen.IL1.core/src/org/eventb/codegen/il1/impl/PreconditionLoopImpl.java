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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.PreconditionLoop;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precondition Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.PreconditionLoopImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.PreconditionLoopImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreconditionLoopImpl extends CommandImpl implements PreconditionLoop {
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
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<String> condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreconditionLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.PRECONDITION_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCondition() {
		if (condition == null) {
			condition = new EDataTypeUniqueEList<String>(String.class, this, Il1Package.PRECONDITION_LOOP__CONDITION);
		}
		return condition;
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
				NotificationChain msgs = oldCommand.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.PRECONDITION_LOOP__COMMAND, null, null);
				if (newCommand.eInternalContainer() == null) {
					msgs = newCommand.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.PRECONDITION_LOOP__COMMAND, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.PRECONDITION_LOOP__COMMAND, oldCommand, command));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.PRECONDITION_LOOP__COMMAND, oldCommand, newCommand);
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
				msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.PRECONDITION_LOOP__COMMAND, null, msgs);
			if (newCommand != null)
				msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.PRECONDITION_LOOP__COMMAND, null, msgs);
			msgs = basicSetCommand(newCommand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PRECONDITION_LOOP__COMMAND, newCommand, newCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.PRECONDITION_LOOP__COMMAND:
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
			case Il1Package.PRECONDITION_LOOP__COMMAND:
				if (resolve) return getCommand();
				return basicGetCommand();
			case Il1Package.PRECONDITION_LOOP__CONDITION:
				return getCondition();
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
			case Il1Package.PRECONDITION_LOOP__COMMAND:
				setCommand((Command)newValue);
				return;
			case Il1Package.PRECONDITION_LOOP__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends String>)newValue);
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
			case Il1Package.PRECONDITION_LOOP__COMMAND:
				setCommand((Command)null);
				return;
			case Il1Package.PRECONDITION_LOOP__CONDITION:
				getCondition().clear();
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
			case Il1Package.PRECONDITION_LOOP__COMMAND:
				return command != null;
			case Il1Package.PRECONDITION_LOOP__CONDITION:
				return condition != null && !condition.isEmpty();
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

} //PreconditionLoopImpl
