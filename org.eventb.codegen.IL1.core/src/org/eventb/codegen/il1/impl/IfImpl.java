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
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.IfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.IfImpl#getBranch <em>Branch</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.IfImpl#getElse <em>Else</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.IfImpl#getRelatedEvent <em>Related Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfImpl extends CommandImpl implements If {
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
	 * The cached value of the '{@link #getBranch() <em>Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch()
	 * @generated
	 * @ordered
	 */
	protected ElseIf branch;

	/**
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected Command else_;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCondition() {
		if (condition == null) {
			condition = new EDataTypeUniqueEList<String>(String.class, this, Il1Package.IF__CONDITION);
		}
		return condition;
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
				NotificationChain msgs = oldBranch.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__BRANCH, null, null);
				if (newBranch.eInternalContainer() == null) {
					msgs = newBranch.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__BRANCH, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.IF__BRANCH, oldBranch, branch));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.IF__BRANCH, oldBranch, newBranch);
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
				msgs = ((InternalEObject)branch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__BRANCH, null, msgs);
			if (newBranch != null)
				msgs = ((InternalEObject)newBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__BRANCH, null, msgs);
			msgs = basicSetBranch(newBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.IF__BRANCH, newBranch, newBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getElse() {
		if (else_ != null && else_.eIsProxy()) {
			InternalEObject oldElse = (InternalEObject)else_;
			else_ = (Command)eResolveProxy(oldElse);
			if (else_ != oldElse) {
				InternalEObject newElse = (InternalEObject)else_;
				NotificationChain msgs = oldElse.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__ELSE, null, null);
				if (newElse.eInternalContainer() == null) {
					msgs = newElse.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__ELSE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.IF__ELSE, oldElse, else_));
			}
		}
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetElse() {
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElse(Command newElse, NotificationChain msgs) {
		Command oldElse = else_;
		else_ = newElse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.IF__ELSE, oldElse, newElse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(Command newElse) {
		if (newElse != else_) {
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__ELSE, null, msgs);
			if (newElse != null)
				msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.IF__ELSE, null, msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.IF__ELSE, newElse, newElse));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.IF__RELATED_EVENT, oldRelatedEvent, relatedEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.IF__RELATED_EVENT, oldRelatedEvent, relatedEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.IF__BRANCH:
				return basicSetBranch(null, msgs);
			case Il1Package.IF__ELSE:
				return basicSetElse(null, msgs);
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
			case Il1Package.IF__CONDITION:
				return getCondition();
			case Il1Package.IF__BRANCH:
				if (resolve) return getBranch();
				return basicGetBranch();
			case Il1Package.IF__ELSE:
				if (resolve) return getElse();
				return basicGetElse();
			case Il1Package.IF__RELATED_EVENT:
				if (resolve) return getRelatedEvent();
				return basicGetRelatedEvent();
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
			case Il1Package.IF__CONDITION:
				getCondition().clear();
				getCondition().addAll((Collection<? extends String>)newValue);
				return;
			case Il1Package.IF__BRANCH:
				setBranch((ElseIf)newValue);
				return;
			case Il1Package.IF__ELSE:
				setElse((Command)newValue);
				return;
			case Il1Package.IF__RELATED_EVENT:
				setRelatedEvent((Event)newValue);
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
			case Il1Package.IF__CONDITION:
				getCondition().clear();
				return;
			case Il1Package.IF__BRANCH:
				setBranch((ElseIf)null);
				return;
			case Il1Package.IF__ELSE:
				setElse((Command)null);
				return;
			case Il1Package.IF__RELATED_EVENT:
				setRelatedEvent((Event)null);
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
			case Il1Package.IF__CONDITION:
				return condition != null && !condition.isEmpty();
			case Il1Package.IF__BRANCH:
				return branch != null;
			case Il1Package.IF__ELSE:
				return else_ != null;
			case Il1Package.IF__RELATED_EVENT:
				return relatedEvent != null;
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

} //IfImpl
