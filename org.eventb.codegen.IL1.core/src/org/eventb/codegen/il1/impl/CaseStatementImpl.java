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
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.CaseStatementImpl#getCaseValue <em>Case Value</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CaseStatementImpl#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseStatementImpl extends IL1ElementImpl implements CaseStatement {
	/**
	 * The default value of the '{@link #getCaseValue() <em>Case Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseValue()
	 * @generated
	 * @ordered
	 */
	protected static final String CASE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCaseValue() <em>Case Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseValue()
	 * @generated
	 * @ordered
	 */
	protected String caseValue = CASE_VALUE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaseStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.CASE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCaseValue() {
		return caseValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseValue(String newCaseValue) {
		String oldCaseValue = caseValue;
		caseValue = newCaseValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CASE_STATEMENT__CASE_VALUE, oldCaseValue, caseValue));
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
				NotificationChain msgs = oldCommand.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.CASE_STATEMENT__COMMAND, null, null);
				if (newCommand.eInternalContainer() == null) {
					msgs = newCommand.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.CASE_STATEMENT__COMMAND, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.CASE_STATEMENT__COMMAND, oldCommand, command));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.CASE_STATEMENT__COMMAND, oldCommand, newCommand);
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
				msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.CASE_STATEMENT__COMMAND, null, msgs);
			if (newCommand != null)
				msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.CASE_STATEMENT__COMMAND, null, msgs);
			msgs = basicSetCommand(newCommand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CASE_STATEMENT__COMMAND, newCommand, newCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.CASE_STATEMENT__COMMAND:
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
			case Il1Package.CASE_STATEMENT__CASE_VALUE:
				return getCaseValue();
			case Il1Package.CASE_STATEMENT__COMMAND:
				if (resolve) return getCommand();
				return basicGetCommand();
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
			case Il1Package.CASE_STATEMENT__CASE_VALUE:
				setCaseValue((String)newValue);
				return;
			case Il1Package.CASE_STATEMENT__COMMAND:
				setCommand((Command)newValue);
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
			case Il1Package.CASE_STATEMENT__CASE_VALUE:
				setCaseValue(CASE_VALUE_EDEFAULT);
				return;
			case Il1Package.CASE_STATEMENT__COMMAND:
				setCommand((Command)null);
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
			case Il1Package.CASE_STATEMENT__CASE_VALUE:
				return CASE_VALUE_EDEFAULT == null ? caseValue != null : !CASE_VALUE_EDEFAULT.equals(caseValue);
			case Il1Package.CASE_STATEMENT__COMMAND:
				return command != null;
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
		result.append(" (caseValue: ");
		result.append(caseValue);
		result.append(')');
		return result.toString();
	}

} //CaseStatementImpl
