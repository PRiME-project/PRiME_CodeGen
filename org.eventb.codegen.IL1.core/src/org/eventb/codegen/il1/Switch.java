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
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Switch#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Switch#getSwitchBlocks <em>Switch Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getSwitch()
 * @model
 * @generated
 */
public interface Switch extends Command {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see org.eventb.codegen.il1.Il1Package#getSwitch_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Switch#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Switch Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.SwitchBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch Blocks</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getSwitch_SwitchBlocks()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<SwitchBlock> getSwitchBlocks();

} // Switch
