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
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.SwitchBlock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.SwitchBlockImpl#getTest <em>Test</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SwitchBlockImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchBlockImpl extends IL1ElementImpl implements SwitchBlock {
	/**
	 * The cached value of the '{@link #getTest() <em>Test</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTest()
	 * @generated
	 * @ordered
	 */
	protected ConstantDecl test;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Command action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.SWITCH_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantDecl getTest() {
		if (test != null && test.eIsProxy()) {
			InternalEObject oldTest = (InternalEObject)test;
			test = (ConstantDecl)eResolveProxy(oldTest);
			if (test != oldTest) {
				InternalEObject newTest = (InternalEObject)test;
				NotificationChain msgs = oldTest.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__TEST, null, null);
				if (newTest.eInternalContainer() == null) {
					msgs = newTest.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__TEST, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.SWITCH_BLOCK__TEST, oldTest, test));
			}
		}
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantDecl basicGetTest() {
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTest(ConstantDecl newTest, NotificationChain msgs) {
		ConstantDecl oldTest = test;
		test = newTest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.SWITCH_BLOCK__TEST, oldTest, newTest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTest(ConstantDecl newTest) {
		if (newTest != test) {
			NotificationChain msgs = null;
			if (test != null)
				msgs = ((InternalEObject)test).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__TEST, null, msgs);
			if (newTest != null)
				msgs = ((InternalEObject)newTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__TEST, null, msgs);
			msgs = basicSetTest(newTest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SWITCH_BLOCK__TEST, newTest, newTest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Command)eResolveProxy(oldAction);
			if (action != oldAction) {
				InternalEObject newAction = (InternalEObject)action;
				NotificationChain msgs = oldAction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__ACTION, null, null);
				if (newAction.eInternalContainer() == null) {
					msgs = newAction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__ACTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.SWITCH_BLOCK__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAction(Command newAction, NotificationChain msgs) {
		Command oldAction = action;
		action = newAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.SWITCH_BLOCK__ACTION, oldAction, newAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Command newAction) {
		if (newAction != action) {
			NotificationChain msgs = null;
			if (action != null)
				msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__ACTION, null, msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.SWITCH_BLOCK__ACTION, null, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SWITCH_BLOCK__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.SWITCH_BLOCK__TEST:
				return basicSetTest(null, msgs);
			case Il1Package.SWITCH_BLOCK__ACTION:
				return basicSetAction(null, msgs);
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
			case Il1Package.SWITCH_BLOCK__TEST:
				if (resolve) return getTest();
				return basicGetTest();
			case Il1Package.SWITCH_BLOCK__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
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
			case Il1Package.SWITCH_BLOCK__TEST:
				setTest((ConstantDecl)newValue);
				return;
			case Il1Package.SWITCH_BLOCK__ACTION:
				setAction((Command)newValue);
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
			case Il1Package.SWITCH_BLOCK__TEST:
				setTest((ConstantDecl)null);
				return;
			case Il1Package.SWITCH_BLOCK__ACTION:
				setAction((Command)null);
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
			case Il1Package.SWITCH_BLOCK__TEST:
				return test != null;
			case Il1Package.SWITCH_BLOCK__ACTION:
				return action != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchBlockImpl
