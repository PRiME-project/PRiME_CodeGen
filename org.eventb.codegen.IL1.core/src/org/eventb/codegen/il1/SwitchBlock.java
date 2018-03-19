/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.SwitchBlock#getTest <em>Test</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.SwitchBlock#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getSwitchBlock()
 * @model
 * @generated
 */
public interface SwitchBlock extends IL1Element {
	/**
	 * Returns the value of the '<em><b>Test</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' containment reference.
	 * @see #setTest(ConstantDecl)
	 * @see org.eventb.codegen.il1.Il1Package#getSwitchBlock_Test()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ConstantDecl getTest();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.SwitchBlock#getTest <em>Test</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test</em>' containment reference.
	 * @see #getTest()
	 * @generated
	 */
	void setTest(ConstantDecl value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getSwitchBlock_Action()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Command getAction();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.SwitchBlock#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Command value);

} // SwitchBlock
