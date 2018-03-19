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
 * A representation of the model object '<em><b>Precondition Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.PreconditionLoop#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.PreconditionLoop#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getPreconditionLoop()
 * @model
 * @generated
 */
public interface PreconditionLoop extends Command {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute list.
	 * @see org.eventb.codegen.il1.Il1Package#getPreconditionLoop_Condition()
	 * @model
	 * @generated
	 */
	EList<String> getCondition();

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' containment reference.
	 * @see #setCommand(Command)
	 * @see org.eventb.codegen.il1.Il1Package#getPreconditionLoop_Command()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Command getCommand();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.PreconditionLoop#getCommand <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' containment reference.
	 * @see #getCommand()
	 * @generated
	 */
	void setCommand(Command value);

} // PreconditionLoop
