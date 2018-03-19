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
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partially Translated Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.PartiallyTranslatedDeclImpl#getPartialInitialisationExpression <em>Partial Initialisation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartiallyTranslatedDeclImpl extends TranslatedDeclImpl implements PartiallyTranslatedDecl {
	/**
	 * The default value of the '{@link #getPartialInitialisationExpression() <em>Partial Initialisation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialInitialisationExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTIAL_INITIALISATION_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartialInitialisationExpression() <em>Partial Initialisation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialInitialisationExpression()
	 * @generated
	 * @ordered
	 */
	protected String partialInitialisationExpression = PARTIAL_INITIALISATION_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartiallyTranslatedDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.PARTIALLY_TRANSLATED_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartialInitialisationExpression() {
		return partialInitialisationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartialInitialisationExpression(String newPartialInitialisationExpression) {
		String oldPartialInitialisationExpression = partialInitialisationExpression;
		partialInitialisationExpression = newPartialInitialisationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION, oldPartialInitialisationExpression, partialInitialisationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Il1Package.PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION:
				return getPartialInitialisationExpression();
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
			case Il1Package.PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION:
				setPartialInitialisationExpression((String)newValue);
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
			case Il1Package.PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION:
				setPartialInitialisationExpression(PARTIAL_INITIALISATION_EXPRESSION_EDEFAULT);
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
			case Il1Package.PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION:
				return PARTIAL_INITIALISATION_EXPRESSION_EDEFAULT == null ? partialInitialisationExpression != null : !PARTIAL_INITIALISATION_EXPRESSION_EDEFAULT.equals(partialInitialisationExpression);
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
		result.append(" (partialInitialisationExpression: ");
		result.append(partialInitialisationExpression);
		result.append(')');
		return result.toString();
	}

} //PartiallyTranslatedDeclImpl
