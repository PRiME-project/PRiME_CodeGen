/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fully Translated Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.FullyTranslatedDeclImpl#getFullInitialisationExpression <em>Full Initialisation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FullyTranslatedDeclImpl extends TranslatedDeclImpl implements FullyTranslatedDecl {
	/**
	 * The cached value of the '{@link #getFullInitialisationExpression() <em>Full Initialisation Expression</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullInitialisationExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fullInitialisationExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FullyTranslatedDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.FULLY_TRANSLATED_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFullInitialisationExpression() {
		if (fullInitialisationExpression == null) {
			fullInitialisationExpression = new EDataTypeUniqueEList<String>(String.class, this, Il1Package.FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION);
		}
		return fullInitialisationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Il1Package.FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION:
				return getFullInitialisationExpression();
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
			case Il1Package.FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION:
				getFullInitialisationExpression().clear();
				getFullInitialisationExpression().addAll((Collection<? extends String>)newValue);
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
			case Il1Package.FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION:
				getFullInitialisationExpression().clear();
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
			case Il1Package.FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION:
				return fullInitialisationExpression != null && !fullInitialisationExpression.isEmpty();
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
		result.append(" (fullInitialisationExpression: ");
		result.append(fullInitialisationExpression);
		result.append(')');
		return result.toString();
	}

} //FullyTranslatedDeclImpl
