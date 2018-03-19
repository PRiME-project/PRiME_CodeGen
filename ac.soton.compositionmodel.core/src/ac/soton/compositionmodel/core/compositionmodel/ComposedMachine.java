/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSees <em>Sees</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getIncludes <em>Includes</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getComposesEvents <em>Composes Events</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefinesNames <em>Refines Names</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSeesNames <em>Sees Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine()
 * @model
 * @generated
 */
public interface ComposedMachine extends EventBNamedCommentedComponentElement {
	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Invariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_Invariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Invariant> getInvariants();

	/**
	 * Returns the value of the '<em><b>Sees</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.context.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sees</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sees</em>' reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_Sees()
	 * @model
	 * @generated
	 */
	EList<Context> getSees();

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_Refines()
	 * @model
	 * @generated
	 */
	EList<Machine> getRefines();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_Includes()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IncludedMachine> getIncludes();

	/**
	 * Returns the value of the '<em><b>Composes Events</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composes Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composes Events</em>' containment reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_ComposesEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ComposedEvent> getComposesEvents();

	/**
	 * Returns the value of the '<em><b>Refines Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines Names</em>' attribute list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_RefinesNames()
	 * @model
	 * @generated
	 */
	EList<String> getRefinesNames();

	/**
	 * Returns the value of the '<em><b>Sees Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sees Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sees Names</em>' attribute list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedMachine_SeesNames()
	 * @model
	 * @generated
	 */
	EList<String> getSeesNames();

} // ComposedMachine
