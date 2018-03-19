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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.CallTarget;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Subroutine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.CallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CallImpl#getSubroutine <em>Subroutine</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CallImpl#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CallImpl#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CallImpl#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallImpl extends CommandImpl implements Call {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected CallTarget target;

	/**
	 * The cached value of the '{@link #getSubroutine() <em>Subroutine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubroutine()
	 * @generated
	 * @ordered
	 */
	protected Subroutine subroutine;

	/**
	 * The cached value of the '{@link #getActualParameters() <em>Actual Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> actualParameters;

	/**
	 * The default value of the '{@link #getMachineName() <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineName()
	 * @generated
	 * @ordered
	 */
	protected static final String MACHINE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMachineName() <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineName()
	 * @generated
	 * @ordered
	 */
	protected String machineName = MACHINE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTarget getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (CallTarget)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.CALL__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTarget basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(CallTarget newTarget) {
		CallTarget oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CALL__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine getSubroutine() {
		if (subroutine != null && subroutine.eIsProxy()) {
			InternalEObject oldSubroutine = (InternalEObject)subroutine;
			subroutine = (Subroutine)eResolveProxy(oldSubroutine);
			if (subroutine != oldSubroutine) {
				InternalEObject newSubroutine = (InternalEObject)subroutine;
				NotificationChain msgs = oldSubroutine.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.CALL__SUBROUTINE, null, null);
				if (newSubroutine.eInternalContainer() == null) {
					msgs = newSubroutine.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.CALL__SUBROUTINE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.CALL__SUBROUTINE, oldSubroutine, subroutine));
			}
		}
		return subroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine basicGetSubroutine() {
		return subroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubroutine(Subroutine newSubroutine, NotificationChain msgs) {
		Subroutine oldSubroutine = subroutine;
		subroutine = newSubroutine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.CALL__SUBROUTINE, oldSubroutine, newSubroutine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubroutine(Subroutine newSubroutine) {
		if (newSubroutine != subroutine) {
			NotificationChain msgs = null;
			if (subroutine != null)
				msgs = ((InternalEObject)subroutine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.CALL__SUBROUTINE, null, msgs);
			if (newSubroutine != null)
				msgs = ((InternalEObject)newSubroutine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.CALL__SUBROUTINE, null, msgs);
			msgs = basicSetSubroutine(newSubroutine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CALL__SUBROUTINE, newSubroutine, newSubroutine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getActualParameters() {
		if (actualParameters == null) {
			actualParameters = new EObjectContainmentEList.Resolving<Parameter>(Parameter.class, this, Il1Package.CALL__ACTUAL_PARAMETERS);
		}
		return actualParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMachineName() {
		return machineName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachineName(String newMachineName) {
		String oldMachineName = machineName;
		machineName = newMachineName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CALL__MACHINE_NAME, oldMachineName, machineName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CALL__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.CALL__SUBROUTINE:
				return basicSetSubroutine(null, msgs);
			case Il1Package.CALL__ACTUAL_PARAMETERS:
				return ((InternalEList<?>)getActualParameters()).basicRemove(otherEnd, msgs);
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
			case Il1Package.CALL__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case Il1Package.CALL__SUBROUTINE:
				if (resolve) return getSubroutine();
				return basicGetSubroutine();
			case Il1Package.CALL__ACTUAL_PARAMETERS:
				return getActualParameters();
			case Il1Package.CALL__MACHINE_NAME:
				return getMachineName();
			case Il1Package.CALL__PROJECT_NAME:
				return getProjectName();
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
			case Il1Package.CALL__TARGET:
				setTarget((CallTarget)newValue);
				return;
			case Il1Package.CALL__SUBROUTINE:
				setSubroutine((Subroutine)newValue);
				return;
			case Il1Package.CALL__ACTUAL_PARAMETERS:
				getActualParameters().clear();
				getActualParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case Il1Package.CALL__MACHINE_NAME:
				setMachineName((String)newValue);
				return;
			case Il1Package.CALL__PROJECT_NAME:
				setProjectName((String)newValue);
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
			case Il1Package.CALL__TARGET:
				setTarget((CallTarget)null);
				return;
			case Il1Package.CALL__SUBROUTINE:
				setSubroutine((Subroutine)null);
				return;
			case Il1Package.CALL__ACTUAL_PARAMETERS:
				getActualParameters().clear();
				return;
			case Il1Package.CALL__MACHINE_NAME:
				setMachineName(MACHINE_NAME_EDEFAULT);
				return;
			case Il1Package.CALL__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
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
			case Il1Package.CALL__TARGET:
				return target != null;
			case Il1Package.CALL__SUBROUTINE:
				return subroutine != null;
			case Il1Package.CALL__ACTUAL_PARAMETERS:
				return actualParameters != null && !actualParameters.isEmpty();
			case Il1Package.CALL__MACHINE_NAME:
				return MACHINE_NAME_EDEFAULT == null ? machineName != null : !MACHINE_NAME_EDEFAULT.equals(machineName);
			case Il1Package.CALL__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
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
		result.append(" (machineName: ");
		result.append(machineName);
		result.append(", projectName: ");
		result.append(projectName);
		result.append(')');
		return result.toString();
	}

} //CallImpl
