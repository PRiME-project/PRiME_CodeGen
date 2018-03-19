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
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.MainEntry;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getDecls <em>Decls</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getProtected <em>Protected</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getEntryPoint <em>Entry Point</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getTaskTypeTasks <em>Task Type Tasks</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getSubroutines <em>Subroutines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getEnvironMachines <em>Environ Machines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProgramImpl#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends SignatureImpl implements Program {
	/**
	 * The cached value of the '{@link #getDecls() <em>Decls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecls()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> decls;

	/**
	 * The cached value of the '{@link #getProtected() <em>Protected</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtected()
	 * @generated
	 * @ordered
	 */
	protected EList<Protected> protected_;

	/**
	 * The cached value of the '{@link #getEntryPoint() <em>Entry Point</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoint()
	 * @generated
	 * @ordered
	 */
	protected MainEntry entryPoint;

	/**
	 * The cached value of the '{@link #getTaskTypeTasks() <em>Task Type Tasks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskTypeTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> taskTypeTasks;

	/**
	 * The cached value of the '{@link #getSubroutines() <em>Subroutines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubroutines()
	 * @generated
	 * @ordered
	 */
	protected EList<Subroutine> subroutines;

	/**
	 * The cached value of the '{@link #getEnvironMachines() <em>Environ Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<EnvironTask> environMachines;

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
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getDecls() {
		if (decls == null) {
			decls = new EObjectContainmentEList.Resolving<Declaration>(Declaration.class, this, Il1Package.PROGRAM__DECLS);
		}
		return decls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protected> getProtected() {
		if (protected_ == null) {
			protected_ = new EObjectContainmentEList.Resolving<Protected>(Protected.class, this, Il1Package.PROGRAM__PROTECTED);
		}
		return protected_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainEntry getEntryPoint() {
		if (entryPoint != null && entryPoint.eIsProxy()) {
			InternalEObject oldEntryPoint = (InternalEObject)entryPoint;
			entryPoint = (MainEntry)eResolveProxy(oldEntryPoint);
			if (entryPoint != oldEntryPoint) {
				InternalEObject newEntryPoint = (InternalEObject)entryPoint;
				NotificationChain msgs = oldEntryPoint.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.PROGRAM__ENTRY_POINT, null, null);
				if (newEntryPoint.eInternalContainer() == null) {
					msgs = newEntryPoint.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.PROGRAM__ENTRY_POINT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Il1Package.PROGRAM__ENTRY_POINT, oldEntryPoint, entryPoint));
			}
		}
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainEntry basicGetEntryPoint() {
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntryPoint(MainEntry newEntryPoint, NotificationChain msgs) {
		MainEntry oldEntryPoint = entryPoint;
		entryPoint = newEntryPoint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Il1Package.PROGRAM__ENTRY_POINT, oldEntryPoint, newEntryPoint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryPoint(MainEntry newEntryPoint) {
		if (newEntryPoint != entryPoint) {
			NotificationChain msgs = null;
			if (entryPoint != null)
				msgs = ((InternalEObject)entryPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Il1Package.PROGRAM__ENTRY_POINT, null, msgs);
			if (newEntryPoint != null)
				msgs = ((InternalEObject)newEntryPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Il1Package.PROGRAM__ENTRY_POINT, null, msgs);
			msgs = basicSetEntryPoint(newEntryPoint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PROGRAM__ENTRY_POINT, newEntryPoint, newEntryPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTaskTypeTasks() {
		if (taskTypeTasks == null) {
			taskTypeTasks = new EObjectContainmentEList.Resolving<Task>(Task.class, this, Il1Package.PROGRAM__TASK_TYPE_TASKS);
		}
		return taskTypeTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subroutine> getSubroutines() {
		if (subroutines == null) {
			subroutines = new EObjectContainmentEList.Resolving<Subroutine>(Subroutine.class, this, Il1Package.PROGRAM__SUBROUTINES);
		}
		return subroutines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnvironTask> getEnvironMachines() {
		if (environMachines == null) {
			environMachines = new EObjectContainmentEList.Resolving<EnvironTask>(EnvironTask.class, this, Il1Package.PROGRAM__ENVIRON_MACHINES);
		}
		return environMachines;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PROGRAM__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.PROGRAM__DECLS:
				return ((InternalEList<?>)getDecls()).basicRemove(otherEnd, msgs);
			case Il1Package.PROGRAM__PROTECTED:
				return ((InternalEList<?>)getProtected()).basicRemove(otherEnd, msgs);
			case Il1Package.PROGRAM__ENTRY_POINT:
				return basicSetEntryPoint(null, msgs);
			case Il1Package.PROGRAM__TASK_TYPE_TASKS:
				return ((InternalEList<?>)getTaskTypeTasks()).basicRemove(otherEnd, msgs);
			case Il1Package.PROGRAM__SUBROUTINES:
				return ((InternalEList<?>)getSubroutines()).basicRemove(otherEnd, msgs);
			case Il1Package.PROGRAM__ENVIRON_MACHINES:
				return ((InternalEList<?>)getEnvironMachines()).basicRemove(otherEnd, msgs);
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
			case Il1Package.PROGRAM__DECLS:
				return getDecls();
			case Il1Package.PROGRAM__PROTECTED:
				return getProtected();
			case Il1Package.PROGRAM__ENTRY_POINT:
				if (resolve) return getEntryPoint();
				return basicGetEntryPoint();
			case Il1Package.PROGRAM__TASK_TYPE_TASKS:
				return getTaskTypeTasks();
			case Il1Package.PROGRAM__SUBROUTINES:
				return getSubroutines();
			case Il1Package.PROGRAM__ENVIRON_MACHINES:
				return getEnvironMachines();
			case Il1Package.PROGRAM__PROJECT_NAME:
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
			case Il1Package.PROGRAM__DECLS:
				getDecls().clear();
				getDecls().addAll((Collection<? extends Declaration>)newValue);
				return;
			case Il1Package.PROGRAM__PROTECTED:
				getProtected().clear();
				getProtected().addAll((Collection<? extends Protected>)newValue);
				return;
			case Il1Package.PROGRAM__ENTRY_POINT:
				setEntryPoint((MainEntry)newValue);
				return;
			case Il1Package.PROGRAM__TASK_TYPE_TASKS:
				getTaskTypeTasks().clear();
				getTaskTypeTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case Il1Package.PROGRAM__SUBROUTINES:
				getSubroutines().clear();
				getSubroutines().addAll((Collection<? extends Subroutine>)newValue);
				return;
			case Il1Package.PROGRAM__ENVIRON_MACHINES:
				getEnvironMachines().clear();
				getEnvironMachines().addAll((Collection<? extends EnvironTask>)newValue);
				return;
			case Il1Package.PROGRAM__PROJECT_NAME:
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
			case Il1Package.PROGRAM__DECLS:
				getDecls().clear();
				return;
			case Il1Package.PROGRAM__PROTECTED:
				getProtected().clear();
				return;
			case Il1Package.PROGRAM__ENTRY_POINT:
				setEntryPoint((MainEntry)null);
				return;
			case Il1Package.PROGRAM__TASK_TYPE_TASKS:
				getTaskTypeTasks().clear();
				return;
			case Il1Package.PROGRAM__SUBROUTINES:
				getSubroutines().clear();
				return;
			case Il1Package.PROGRAM__ENVIRON_MACHINES:
				getEnvironMachines().clear();
				return;
			case Il1Package.PROGRAM__PROJECT_NAME:
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
			case Il1Package.PROGRAM__DECLS:
				return decls != null && !decls.isEmpty();
			case Il1Package.PROGRAM__PROTECTED:
				return protected_ != null && !protected_.isEmpty();
			case Il1Package.PROGRAM__ENTRY_POINT:
				return entryPoint != null;
			case Il1Package.PROGRAM__TASK_TYPE_TASKS:
				return taskTypeTasks != null && !taskTypeTasks.isEmpty();
			case Il1Package.PROGRAM__SUBROUTINES:
				return subroutines != null && !subroutines.isEmpty();
			case Il1Package.PROGRAM__ENVIRON_MACHINES:
				return environMachines != null && !environMachines.isEmpty();
			case Il1Package.PROGRAM__PROJECT_NAME:
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
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(')');
		return result.toString();
	}

} //ProgramImpl
