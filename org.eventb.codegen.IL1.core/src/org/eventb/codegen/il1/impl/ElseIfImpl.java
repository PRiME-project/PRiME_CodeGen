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
import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.ElseIfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ElseIfImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ElseIfImpl#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ElseIfImpl#getRelatedEvent <em>Related Event</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ElseIfImpl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElseIfImpl extends IL1ElementImpl implements ElseIf {
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
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Command action;

	/**
	 * The cached value of the '{@link #getBranch() <em>Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch()
	 * @generated
	 * @ordered
	 */
	protected ElseIf branch;

	/**
	 * The cached value of the '{@link #getRelatedEvent() <em>Related Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedEvent()
	 * @generated
	 * @ordered
	 */
	protected Event relatedEvent;

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
	protected ElseIfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.ELSE_IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCondition() {
		if (condition == null) {
			condition = new EDataTypeUniqueEList<String>(String.class, this, Il1Package.ELSE_IF__CONDITION);
		}
		return condition;
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
				NotificationChain msgs = oldAction.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__ACTION, null, null);
				if (newAction.eInternalContainer() == null) {
					msgs = newAction.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__ACTION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.ELSE_IF__ACTION, oldAction, action));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__ACTION, oldAction, newAction);
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
				msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__ACTION, null, msgs);
			if (newAction != null)
				msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__ACTION, null, msgs);
			msgs = basicSetAction(newAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__ACTION, newAction, newAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseIf getBranch() {
		if (branch != null && branch.eIsProxy()) {
			InternalEObject oldBranch = (InternalEObject)branch;
			branch = (ElseIf)eResolveProxy(oldBranch);
			if (branch != oldBranch) {
				InternalEObject newBranch = (InternalEObject)branch;
				NotificationChain msgs = oldBranch.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__BRANCH, null, null);
				if (newBranch.eInternalContainer() == null) {
					msgs = newBranch.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__BRANCH, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.ELSE_IF__BRANCH, oldBranch, branch));
			}
		}
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseIf basicGetBranch() {
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBranch(ElseIf newBranch, NotificationChain msgs) {
		ElseIf oldBranch = branch;
		branch = newBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__BRANCH, oldBranch, newBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranch(ElseIf newBranch) {
		if (newBranch != branch) {
			NotificationChain msgs = null;
			if (branch != null)
				msgs = ((InternalEObject)branch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__BRANCH, null, msgs);
			if (newBranch != null)
				msgs = ((InternalEObject)newBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.ELSE_IF__BRANCH, null, msgs);
			msgs = basicSetBranch(newBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__BRANCH, newBranch, newBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getRelatedEvent() {
		if (relatedEvent != null && relatedEvent.eIsProxy()) {
			InternalEObject oldRelatedEvent = (InternalEObject)relatedEvent;
			relatedEvent = (Event)eResolveProxy(oldRelatedEvent);
			if (relatedEvent != oldRelatedEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.ELSE_IF__RELATED_EVENT, oldRelatedEvent, relatedEvent));
			}
		}
		return relatedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetRelatedEvent() {
		return relatedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedEvent(Event newRelatedEvent) {
		Event oldRelatedEvent = relatedEvent;
		relatedEvent = newRelatedEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__RELATED_EVENT, oldRelatedEvent, relatedEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.ELSE_IF__ENVIR_STATE_MACHINE_CHILD, oldEnvirStateMachineChild, envirStateMachineChild));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.ELSE_IF__ACTION:
				return basicSetAction(null, msgs);
			case Il1Package.ELSE_IF__BRANCH:
				return basicSetBranch(null, msgs);
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
			case Il1Package.ELSE_IF__CONDITION:
				return getCondition();
			case Il1Package.ELSE_IF__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case Il1Package.ELSE_IF__BRANCH:
				if (resolve) return getBranch();
				return basicGetBranch();
			case Il1Package.ELSE_IF__RELATED_EVENT:
				if (resolve) return getRelatedEvent();
				return basicGetRelatedEvent();
			case Il1Package.ELSE_IF__ENVIR_STATE_MACHINE_CHILD:
				return isEnvirStateMachineChild();
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
			case Il1Package.ELSE_IF__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends String>)newValue);
				return;
			case Il1Package.ELSE_IF__ACTION:
				setAction((Command)newValue);
				return;
			case Il1Package.ELSE_IF__BRANCH:
				setBranch((ElseIf)newValue);
				return;
			case Il1Package.ELSE_IF__RELATED_EVENT:
				setRelatedEvent((Event)newValue);
				return;
			case Il1Package.ELSE_IF__ENVIR_STATE_MACHINE_CHILD:
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
			case Il1Package.ELSE_IF__CONDITION:
				getCondition().clear();
				return;
			case Il1Package.ELSE_IF__ACTION:
				setAction((Command)null);
				return;
			case Il1Package.ELSE_IF__BRANCH:
				setBranch((ElseIf)null);
				return;
			case Il1Package.ELSE_IF__RELATED_EVENT:
				setRelatedEvent((Event)null);
				return;
			case Il1Package.ELSE_IF__ENVIR_STATE_MACHINE_CHILD:
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
			case Il1Package.ELSE_IF__CONDITION:
				return condition != null && !condition.isEmpty();
			case Il1Package.ELSE_IF__ACTION:
				return action != null;
			case Il1Package.ELSE_IF__BRANCH:
				return branch != null;
			case Il1Package.ELSE_IF__RELATED_EVENT:
				return relatedEvent != null;
			case Il1Package.ELSE_IF__ENVIR_STATE_MACHINE_CHILD:
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
		result.append(" (condition: ");
		result.append(condition);
		result.append(", envirStateMachineChild: ");
		result.append(envirStateMachineChild);
		result.append(')');
		return result.toString();
	}

} //ElseIfImpl
