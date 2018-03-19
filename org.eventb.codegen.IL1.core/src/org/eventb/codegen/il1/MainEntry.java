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
 * A representation of the model object '<em><b>Main Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.MainEntry#getAutoTasks <em>Auto Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getMainEntry()
 * @model
 * @generated
 */
public interface MainEntry extends CodeContainer {
	/**
	 * Returns the value of the '<em><b>Auto Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.codegen.il1.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Tasks</em>' containment reference list.
	 * @see org.eventb.codegen.il1.Il1Package#getMainEntry_AutoTasks()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Task> getAutoTasks();

} // MainEntry
