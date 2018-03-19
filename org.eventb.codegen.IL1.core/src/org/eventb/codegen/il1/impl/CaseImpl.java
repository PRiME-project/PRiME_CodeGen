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
import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.Il1Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.impl.CaseImpl#getCaseExpression <em>Case Expression</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.impl.CaseImpl#getCaseStatement <em>Case Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseImpl extends CommandImpl implements Case {
	/**
	 * The default value of the '{@link #getCaseExpression() <em>Case Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String CASE_EXPRESSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCaseExpression() <em>Case Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseExpression()
	 * @generated
	 * @ordered
	 */
	protected String caseExpression = CASE_EXPRESSION_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCaseStatement() <em>Case Statement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseStatement()
	 * @generated
	 * @ordered
	 */
	protected EList<CaseStatement> caseStatement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Il1Package.Literals.CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCaseExpression() {
		return caseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseExpression(String newCaseExpression) {
		String oldCaseExpression = caseExpression;
		caseExpression = newCaseExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Il1Package.CASE__CASE_EXPRESSION, oldCaseExpression, caseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CaseStatement> getCaseStatement() {
		if (caseStatement == null) {
			caseStatement = new EObjectContainmentEList.Resolving<CaseStatement>(CaseStatement.class, this, Il1Package.CASE__CASE_STATEMENT);
		}
		return caseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Il1Package.CASE__CASE_STATEMENT:
				return ((InternalEList<?>)getCaseStatement()).basicRemove(otherEnd, msgs);
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
			case Il1Package.CASE__CASE_EXPRESSION:
				return getCaseExpression();
			case Il1Package.CASE__CASE_STATEMENT:
				return getCaseStatement();
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
			case Il1Package.CASE__CASE_EXPRESSION:
				setCaseExpression((String)newValue);
				return;
			case Il1Package.CASE__CASE_STATEMENT:
				getCaseStatement().clear();
				getCaseStatement().addAll((Collection<? extends CaseStatement>)newValue);
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
			case Il1Package.CASE__CASE_EXPRESSION:
				setCaseExpression(CASE_EXPRESSION_EDEFAULT);
				return;
			case Il1Package.CASE__CASE_STATEMENT:
				getCaseStatement().clear();
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
			case Il1Package.CASE__CASE_EXPRESSION:
				return CASE_EXPRESSION_EDEFAULT == null ? caseExpression != null : !CASE_EXPRESSION_EDEFAULT.equals(caseExpression);
			case Il1Package.CASE__CASE_STATEMENT:
				return caseStatement != null && !caseStatement.isEmpty();
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
		result.append(" (caseExpression: ");
		result.append(caseExpression);
		result.append(')');
		return result.toString();
	}

} //CaseImpl
