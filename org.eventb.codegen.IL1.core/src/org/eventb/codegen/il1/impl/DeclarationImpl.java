/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.DeclarationImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.DeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.DeclarationImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.DeclarationImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.DeclarationImpl#getComponentName <em>Component Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DeclarationImpl extends IL1ElementImpl implements Declaration {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;
	/**
	 * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIAL_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected String initialValue = INITIAL_VALUE_EDEFAULT;
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
	 * The default value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentName()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getComponentName() <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentName()
	 * @generated
	 * @ordered
	 */
	protected String componentName = COMPONENT_NAME_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.DECLARATION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.DECLARATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(String newInitialValue) {
		String oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.DECLARATION__INITIAL_VALUE, oldInitialValue, initialValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.DECLARATION__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentName(String newComponentName) {
		String oldComponentName = componentName;
		componentName = newComponentName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.DECLARATION__COMPONENT_NAME, oldComponentName, componentName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Il1Package.DECLARATION__IDENTIFIER:
				return getIdentifier();
			case Il1Package.DECLARATION__TYPE:
				return getType();
			case Il1Package.DECLARATION__INITIAL_VALUE:
				return getInitialValue();
			case Il1Package.DECLARATION__PROJECT_NAME:
				return getProjectName();
			case Il1Package.DECLARATION__COMPONENT_NAME:
				return getComponentName();
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
			case Il1Package.DECLARATION__IDENTIFIER:
				setIdentifier((String)newValue);
				return;
			case Il1Package.DECLARATION__TYPE:
				setType((String)newValue);
				return;
			case Il1Package.DECLARATION__INITIAL_VALUE:
				setInitialValue((String)newValue);
				return;
			case Il1Package.DECLARATION__PROJECT_NAME:
				setProjectName((String)newValue);
				return;
			case Il1Package.DECLARATION__COMPONENT_NAME:
				setComponentName((String)newValue);
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
			case Il1Package.DECLARATION__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
				return;
			case Il1Package.DECLARATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Il1Package.DECLARATION__INITIAL_VALUE:
				setInitialValue(INITIAL_VALUE_EDEFAULT);
				return;
			case Il1Package.DECLARATION__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
				return;
			case Il1Package.DECLARATION__COMPONENT_NAME:
				setComponentName(COMPONENT_NAME_EDEFAULT);
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
			case Il1Package.DECLARATION__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
			case Il1Package.DECLARATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case Il1Package.DECLARATION__INITIAL_VALUE:
				return INITIAL_VALUE_EDEFAULT == null ? initialValue != null : !INITIAL_VALUE_EDEFAULT.equals(initialValue);
			case Il1Package.DECLARATION__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
			case Il1Package.DECLARATION__COMPONENT_NAME:
				return COMPONENT_NAME_EDEFAULT == null ? componentName != null : !COMPONENT_NAME_EDEFAULT.equals(componentName);
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(", type: ");
		result.append(type);
		result.append(", initialValue: ");
		result.append(initialValue);
		result.append(", ProjectName: ");
		result.append(projectName);
		result.append(", ComponentName: ");
		result.append(componentName);
		result.append(')');
		return result.toString();
	}

} //DeclarationImpl
