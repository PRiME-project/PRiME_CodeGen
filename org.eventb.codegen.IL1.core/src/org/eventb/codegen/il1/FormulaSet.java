/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.FormulaSet#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getFormulaSet()
 * @model
 * @generated
 */
public interface FormulaSet extends IL1Element {
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getFormulaSet_Conditions()
	 * @model
	 * @generated
	 */
	EList<String> getConditions();

} // FormulaSet
