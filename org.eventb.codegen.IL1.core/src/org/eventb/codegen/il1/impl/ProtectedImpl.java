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
import org.eventb.codegen.il1.CallTarget;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Signature;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.RequiredFormula.impl.DataTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protected</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.ProtectedImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProtectedImpl#getSubroutines <em>Subroutines</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProtectedImpl#getDecls <em>Decls</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProtectedImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.ProtectedImpl#getMachineName <em>Machine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtectedImpl extends DataTypeImpl implements Protected {
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
	 * The cached value of the '{@link #getSubroutines() <em>Subroutines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubroutines()
	 * @generated
	 * @ordered
	 */
	protected EList<Subroutine> subroutines;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.PROTECTED;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PROTECTED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subroutine> getSubroutines() {
		if (subroutines == null) {
			subroutines = new EObjectContainmentEList.Resolving<Subroutine>(Subroutine.class, this, Il1Package.PROTECTED__SUBROUTINES);
		}
		return subroutines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getDecls() {
		if (decls == null) {
			decls = new EObjectContainmentEList.Resolving<Declaration>(Declaration.class, this, Il1Package.PROTECTED__DECLS);
		}
		return decls;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PROTECTED__PROJECT_NAME, oldProjectName, projectName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PROTECTED__MACHINE_NAME, oldMachineName, machineName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.PROTECTED__SUBROUTINES:
				return ((InternalEList<?>)getSubroutines()).basicRemove(otherEnd, msgs);
			case Il1Package.PROTECTED__DECLS:
				return ((InternalEList<?>)getDecls()).basicRemove(otherEnd, msgs);
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
			case Il1Package.PROTECTED__NAME:
				return getName();
			case Il1Package.PROTECTED__SUBROUTINES:
				return getSubroutines();
			case Il1Package.PROTECTED__DECLS:
				return getDecls();
			case Il1Package.PROTECTED__PROJECT_NAME:
				return getProjectName();
			case Il1Package.PROTECTED__MACHINE_NAME:
				return getMachineName();
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
			case Il1Package.PROTECTED__NAME:
				setName((String)newValue);
				return;
			case Il1Package.PROTECTED__SUBROUTINES:
				getSubroutines().clear();
				getSubroutines().addAll((Collection<? extends Subroutine>)newValue);
				return;
			case Il1Package.PROTECTED__DECLS:
				getDecls().clear();
				getDecls().addAll((Collection<? extends Declaration>)newValue);
				return;
			case Il1Package.PROTECTED__PROJECT_NAME:
				setProjectName((String)newValue);
				return;
			case Il1Package.PROTECTED__MACHINE_NAME:
				setMachineName((String)newValue);
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
			case Il1Package.PROTECTED__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Il1Package.PROTECTED__SUBROUTINES:
				getSubroutines().clear();
				return;
			case Il1Package.PROTECTED__DECLS:
				getDecls().clear();
				return;
			case Il1Package.PROTECTED__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
				return;
			case Il1Package.PROTECTED__MACHINE_NAME:
				setMachineName(MACHINE_NAME_EDEFAULT);
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
			case Il1Package.PROTECTED__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Il1Package.PROTECTED__SUBROUTINES:
				return subroutines != null && !subroutines.isEmpty();
			case Il1Package.PROTECTED__DECLS:
				return decls != null && !decls.isEmpty();
			case Il1Package.PROTECTED__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
			case Il1Package.PROTECTED__MACHINE_NAME:
				return MACHINE_NAME_EDEFAULT == null ? machineName != null : !MACHINE_NAME_EDEFAULT.equals(machineName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IL1Element.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Signature.class) {
			switch (derivedFeatureID) {
				case Il1Package.PROTECTED__NAME: return Il1Package.SIGNATURE__NAME;
				default: return -1;
			}
		}
		if (baseClass == CallTarget.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IL1Element.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Signature.class) {
			switch (baseFeatureID) {
				case Il1Package.SIGNATURE__NAME: return Il1Package.PROTECTED__NAME;
				default: return -1;
			}
		}
		if (baseClass == CallTarget.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", projectName: ");
		result.append(projectName);
		result.append(", machineName: ");
		result.append(machineName);
		result.append(')');
		return result.toString();
	}

} //ProtectedImpl
