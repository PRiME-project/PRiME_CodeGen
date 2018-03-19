/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import compositeControl.CompositeControl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tasking.Main#getName <em>Name</em>}</li>
 *   <li>{@link tasking.Main#getMainBody <em>Main Body</em>}</li>
 *   <li>{@link tasking.Main#getMachines <em>Machines</em>}</li>
 *   <li>{@link tasking.Main#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see tasking.TaskingPackage#getMain()
 * @model
 * @generated
 */
public interface Main extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tasking.TaskingPackage#getMain_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tasking.Main#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Main Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Body</em>' containment reference.
	 * @see #setMainBody(CompositeControl)
	 * @see tasking.TaskingPackage#getMain_MainBody()
	 * @model containment="true"
	 * @generated
	 */
	CompositeControl getMainBody();

	/**
	 * Sets the value of the '{@link tasking.Main#getMainBody <em>Main Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Body</em>' containment reference.
	 * @see #getMainBody()
	 * @generated
	 */
	void setMainBody(CompositeControl value);

	/**
	 * Returns the value of the '<em><b>Machines</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machines</em>' containment reference list.
	 * @see tasking.TaskingPackage#getMain_Machines()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Machine> getMachines();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.context.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see tasking.TaskingPackage#getMain_Contexts()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Context> getContexts();

} // Main
