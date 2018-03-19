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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.Signature;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subroutine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#isTemporary <em>Temporary</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getLocalDeclarations <em>Local Declarations</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getGuards <em>Guards</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.SubroutineImpl#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubroutineImpl extends CodeContainerImpl implements Subroutine {
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
	 * The default value of the '{@link #isTemporary() <em>Temporary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemporary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPORARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemporary() <em>Temporary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemporary()
	 * @generated
	 * @ordered
	 */
	protected boolean temporary = TEMPORARY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormalParameters() <em>Formal Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormalParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> formalParameters;

	/**
	 * The cached value of the '{@link #getLocalDeclarations() <em>Local Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> localDeclarations;

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
	 * The cached value of the '{@link #getGuards() <em>Guards</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<String> guards;

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
	protected SubroutineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.SUBROUTINE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SUBROUTINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemporary() {
		return temporary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemporary(boolean newTemporary) {
		boolean oldTemporary = temporary;
		temporary = newTemporary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SUBROUTINE__TEMPORARY, oldTemporary, temporary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getFormalParameters() {
		if (formalParameters == null) {
			formalParameters = new EObjectContainmentEList.Resolving<Parameter>(Parameter.class, this, Il1Package.SUBROUTINE__FORMAL_PARAMETERS);
		}
		return formalParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getLocalDeclarations() {
		if (localDeclarations == null) {
			localDeclarations = new EObjectContainmentEList.Resolving<Declaration>(Declaration.class, this, Il1Package.SUBROUTINE__LOCAL_DECLARATIONS);
		}
		return localDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getGuards() {
		if (guards == null) {
			guards = new EDataTypeUniqueEList<String>(String.class, this, Il1Package.SUBROUTINE__GUARDS);
		}
		return guards;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SUBROUTINE__PROJECT_NAME, oldProjectName, projectName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.SUBROUTINE__MACHINE_NAME, oldMachineName, machineName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
				return ((InternalEList<?>)getFormalParameters()).basicRemove(otherEnd, msgs);
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
				return ((InternalEList<?>)getLocalDeclarations()).basicRemove(otherEnd, msgs);
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
			case Il1Package.SUBROUTINE__NAME:
				return getName();
			case Il1Package.SUBROUTINE__TEMPORARY:
				return isTemporary();
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
				return getFormalParameters();
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
				return getLocalDeclarations();
			case Il1Package.SUBROUTINE__MACHINE_NAME:
				return getMachineName();
			case Il1Package.SUBROUTINE__GUARDS:
				return getGuards();
			case Il1Package.SUBROUTINE__PROJECT_NAME:
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
			case Il1Package.SUBROUTINE__NAME:
				setName((String)newValue);
				return;
			case Il1Package.SUBROUTINE__TEMPORARY:
				setTemporary((Boolean)newValue);
				return;
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
				getFormalParameters().clear();
				getFormalParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
				getLocalDeclarations().clear();
				getLocalDeclarations().addAll((Collection<? extends Declaration>)newValue);
				return;
			case Il1Package.SUBROUTINE__MACHINE_NAME:
				setMachineName((String)newValue);
				return;
			case Il1Package.SUBROUTINE__GUARDS:
				getGuards().clear();
				getGuards().addAll((Collection<? extends String>)newValue);
				return;
			case Il1Package.SUBROUTINE__PROJECT_NAME:
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
			case Il1Package.SUBROUTINE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Il1Package.SUBROUTINE__TEMPORARY:
				setTemporary(TEMPORARY_EDEFAULT);
				return;
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
				getFormalParameters().clear();
				return;
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
				getLocalDeclarations().clear();
				return;
			case Il1Package.SUBROUTINE__MACHINE_NAME:
				setMachineName(MACHINE_NAME_EDEFAULT);
				return;
			case Il1Package.SUBROUTINE__GUARDS:
				getGuards().clear();
				return;
			case Il1Package.SUBROUTINE__PROJECT_NAME:
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
			case Il1Package.SUBROUTINE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Il1Package.SUBROUTINE__TEMPORARY:
				return temporary != TEMPORARY_EDEFAULT;
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
				return formalParameters != null && !formalParameters.isEmpty();
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
				return localDeclarations != null && !localDeclarations.isEmpty();
			case Il1Package.SUBROUTINE__MACHINE_NAME:
				return MACHINE_NAME_EDEFAULT == null ? machineName != null : !MACHINE_NAME_EDEFAULT.equals(machineName);
			case Il1Package.SUBROUTINE__GUARDS:
				return guards != null && !guards.isEmpty();
			case Il1Package.SUBROUTINE__PROJECT_NAME:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Signature.class) {
			switch (derivedFeatureID) {
				case Il1Package.SUBROUTINE__NAME: return Il1Package.SIGNATURE__NAME;
				default: return -1;
			}
		}
		if (baseClass == SubroutineMetaData.class) {
			switch (derivedFeatureID) {
				case Il1Package.SUBROUTINE__TEMPORARY: return RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY;
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
		if (baseClass == Signature.class) {
			switch (baseFeatureID) {
				case Il1Package.SIGNATURE__NAME: return Il1Package.SUBROUTINE__NAME;
				default: return -1;
			}
		}
		if (baseClass == SubroutineMetaData.class) {
			switch (baseFeatureID) {
				case RequiredMetadataPackage.SUBROUTINE_META_DATA__TEMPORARY: return Il1Package.SUBROUTINE__TEMPORARY;
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
		result.append(", temporary: ");
		result.append(temporary);
		result.append(", machineName: ");
		result.append(machineName);
		result.append(", guards: ");
		result.append(guards);
		result.append(", projectName: ");
		result.append(projectName);
		result.append(')');
		return result.toString();
	}

} //SubroutineImpl
