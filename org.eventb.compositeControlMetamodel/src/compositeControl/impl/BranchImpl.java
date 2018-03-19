/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import compositeControl.Branch;
import compositeControl.CompositeControlPackage;
import compositeControl.EventWrapper;
import compositeControl.SubBranch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.BranchImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.impl.BranchImpl#getEventWrapper <em>Event Wrapper</em>}</li>
 *   <li>{@link compositeControl.impl.BranchImpl#getSubBranch <em>Sub Branch</em>}</li>
 *   <li>{@link compositeControl.impl.BranchImpl#getAlt <em>Alt</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchImpl extends CompositeControlImpl implements Branch {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEventWrapper() <em>Event Wrapper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventWrapper()
	 * @generated
	 * @ordered
	 */
	protected EventWrapper eventWrapper;

	/**
	 * The cached value of the '{@link #getSubBranch() <em>Sub Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubBranch()
	 * @generated
	 * @ordered
	 */
	protected SubBranch subBranch;

	/**
	 * The cached value of the '{@link #getAlt() <em>Alt</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlt()
	 * @generated
	 * @ordered
	 */
	protected EventWrapper alt;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper getEventWrapper() {
		return eventWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventWrapper(EventWrapper newEventWrapper, NotificationChain msgs) {
		EventWrapper oldEventWrapper = eventWrapper;
		eventWrapper = newEventWrapper;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__EVENT_WRAPPER, oldEventWrapper, newEventWrapper);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventWrapper(EventWrapper newEventWrapper) {
		if (newEventWrapper != eventWrapper) {
			NotificationChain msgs = null;
			if (eventWrapper != null)
				msgs = ((InternalEObject)eventWrapper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__EVENT_WRAPPER, null, msgs);
			if (newEventWrapper != null)
				msgs = ((InternalEObject)newEventWrapper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__EVENT_WRAPPER, null, msgs);
			msgs = basicSetEventWrapper(newEventWrapper, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__EVENT_WRAPPER, newEventWrapper, newEventWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubBranch getSubBranch() {
		return subBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubBranch(SubBranch newSubBranch, NotificationChain msgs) {
		SubBranch oldSubBranch = subBranch;
		subBranch = newSubBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__SUB_BRANCH, oldSubBranch, newSubBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubBranch(SubBranch newSubBranch) {
		if (newSubBranch != subBranch) {
			NotificationChain msgs = null;
			if (subBranch != null)
				msgs = ((InternalEObject)subBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__SUB_BRANCH, null, msgs);
			if (newSubBranch != null)
				msgs = ((InternalEObject)newSubBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__SUB_BRANCH, null, msgs);
			msgs = basicSetSubBranch(newSubBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__SUB_BRANCH, newSubBranch, newSubBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper getAlt() {
		if (alt != null && alt.eIsProxy()) {
			InternalEObject oldAlt = (InternalEObject)alt;
			alt = (EventWrapper)eResolveProxy(oldAlt);
			if (alt != oldAlt) {
				InternalEObject newAlt = (InternalEObject)alt;
				NotificationChain msgs = oldAlt.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__ALT, null, null);
				if (newAlt.eInternalContainer() == null) {
					msgs = newAlt.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__ALT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositeControlPackage.BRANCH__ALT, oldAlt, alt));
			}
		}
		return alt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper basicGetAlt() {
		return alt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlt(EventWrapper newAlt, NotificationChain msgs) {
		EventWrapper oldAlt = alt;
		alt = newAlt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__ALT, oldAlt, newAlt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlt(EventWrapper newAlt) {
		if (newAlt != alt) {
			NotificationChain msgs = null;
			if (alt != null)
				msgs = ((InternalEObject)alt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__ALT, null, msgs);
			if (newAlt != null)
				msgs = ((InternalEObject)newAlt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompositeControlPackage.BRANCH__ALT, null, msgs);
			msgs = basicSetAlt(newAlt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.BRANCH__ALT, newAlt, newAlt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositeControlPackage.BRANCH__EVENT_WRAPPER:
				return basicSetEventWrapper(null, msgs);
			case CompositeControlPackage.BRANCH__SUB_BRANCH:
				return basicSetSubBranch(null, msgs);
			case CompositeControlPackage.BRANCH__ALT:
				return basicSetAlt(null, msgs);
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
			case CompositeControlPackage.BRANCH__LABEL:
				return getLabel();
			case CompositeControlPackage.BRANCH__EVENT_WRAPPER:
				return getEventWrapper();
			case CompositeControlPackage.BRANCH__SUB_BRANCH:
				return getSubBranch();
			case CompositeControlPackage.BRANCH__ALT:
				if (resolve) return getAlt();
				return basicGetAlt();
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
			case CompositeControlPackage.BRANCH__LABEL:
				setLabel((String)newValue);
				return;
			case CompositeControlPackage.BRANCH__EVENT_WRAPPER:
				setEventWrapper((EventWrapper)newValue);
				return;
			case CompositeControlPackage.BRANCH__SUB_BRANCH:
				setSubBranch((SubBranch)newValue);
				return;
			case CompositeControlPackage.BRANCH__ALT:
				setAlt((EventWrapper)newValue);
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
			case CompositeControlPackage.BRANCH__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case CompositeControlPackage.BRANCH__EVENT_WRAPPER:
				setEventWrapper((EventWrapper)null);
				return;
			case CompositeControlPackage.BRANCH__SUB_BRANCH:
				setSubBranch((SubBranch)null);
				return;
			case CompositeControlPackage.BRANCH__ALT:
				setAlt((EventWrapper)null);
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
			case CompositeControlPackage.BRANCH__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case CompositeControlPackage.BRANCH__EVENT_WRAPPER:
				return eventWrapper != null;
			case CompositeControlPackage.BRANCH__SUB_BRANCH:
				return subBranch != null;
			case CompositeControlPackage.BRANCH__ALT:
				return alt != null;
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //BranchImpl
