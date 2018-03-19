/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.MainEntry;
import org.eventb.codegen.il1.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.MainEntryImpl#getAutoTasks <em>Auto Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MainEntryImpl extends CodeContainerImpl implements MainEntry {
	/**
	 * The cached value of the '{@link #getAutoTasks() <em>Auto Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> autoTasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.MAIN_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getAutoTasks() {
		if (autoTasks == null) {
			autoTasks = new EObjectContainmentEList.Resolving<Task>(Task.class, this, Il1Package.MAIN_ENTRY__AUTO_TASKS);
		}
		return autoTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.MAIN_ENTRY__AUTO_TASKS:
				return ((InternalEList<?>)getAutoTasks()).basicRemove(otherEnd, msgs);
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
			case Il1Package.MAIN_ENTRY__AUTO_TASKS:
				return getAutoTasks();
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
			case Il1Package.MAIN_ENTRY__AUTO_TASKS:
				getAutoTasks().clear();
				getAutoTasks().addAll((Collection<? extends Task>)newValue);
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
			case Il1Package.MAIN_ENTRY__AUTO_TASKS:
				getAutoTasks().clear();
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
			case Il1Package.MAIN_ENTRY__AUTO_TASKS:
				return autoTasks != null && !autoTasks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MainEntryImpl
