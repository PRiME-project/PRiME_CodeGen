/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import tasking.Main;
import tasking.TaskingPackage;

import compositeControl.CompositeControl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tasking.impl.MainImpl#getName <em>Name</em>}</li>
 *   <li>{@link tasking.impl.MainImpl#getMainBody <em>Main Body</em>}</li>
 *   <li>{@link tasking.impl.MainImpl#getMachines <em>Machines</em>}</li>
 *   <li>{@link tasking.impl.MainImpl#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MainImpl extends EObjectImpl implements Main {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMainBody() <em>Main Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainBody()
	 * @generated
	 * @ordered
	 */
	protected CompositeControl mainBody;

	/**
	 * The cached value of the '{@link #getMachines() <em>Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<Machine> machines;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> contexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskingPackage.Literals.MAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.MAIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControl getMainBody() {
		return mainBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainBody(CompositeControl newMainBody, NotificationChain msgs) {
		CompositeControl oldMainBody = mainBody;
		mainBody = newMainBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TaskingPackage.MAIN__MAIN_BODY, oldMainBody, newMainBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainBody(CompositeControl newMainBody) {
		if (newMainBody != mainBody) {
			NotificationChain msgs = null;
			if (mainBody != null)
				msgs = ((InternalEObject)mainBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.MAIN__MAIN_BODY, null, msgs);
			if (newMainBody != null)
				msgs = ((InternalEObject)newMainBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TaskingPackage.MAIN__MAIN_BODY, null, msgs);
			msgs = basicSetMainBody(newMainBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskingPackage.MAIN__MAIN_BODY, newMainBody, newMainBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machine> getMachines() {
		if (machines == null) {
			machines = new EObjectContainmentEList.Resolving<Machine>(Machine.class, this, TaskingPackage.MAIN__MACHINES);
		}
		return machines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList.Resolving<Context>(Context.class, this, TaskingPackage.MAIN__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TaskingPackage.MAIN__MAIN_BODY:
				return basicSetMainBody(null, msgs);
			case TaskingPackage.MAIN__MACHINES:
				return ((InternalEList<?>)getMachines()).basicRemove(otherEnd, msgs);
			case TaskingPackage.MAIN__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
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
			case TaskingPackage.MAIN__NAME:
				return getName();
			case TaskingPackage.MAIN__MAIN_BODY:
				return getMainBody();
			case TaskingPackage.MAIN__MACHINES:
				return getMachines();
			case TaskingPackage.MAIN__CONTEXTS:
				return getContexts();
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
			case TaskingPackage.MAIN__NAME:
				setName((String)newValue);
				return;
			case TaskingPackage.MAIN__MAIN_BODY:
				setMainBody((CompositeControl)newValue);
				return;
			case TaskingPackage.MAIN__MACHINES:
				getMachines().clear();
				getMachines().addAll((Collection<? extends Machine>)newValue);
				return;
			case TaskingPackage.MAIN__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends Context>)newValue);
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
			case TaskingPackage.MAIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TaskingPackage.MAIN__MAIN_BODY:
				setMainBody((CompositeControl)null);
				return;
			case TaskingPackage.MAIN__MACHINES:
				getMachines().clear();
				return;
			case TaskingPackage.MAIN__CONTEXTS:
				getContexts().clear();
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
			case TaskingPackage.MAIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TaskingPackage.MAIN__MAIN_BODY:
				return mainBody != null;
			case TaskingPackage.MAIN__MACHINES:
				return machines != null && !machines.isEmpty();
			case TaskingPackage.MAIN__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MainImpl
