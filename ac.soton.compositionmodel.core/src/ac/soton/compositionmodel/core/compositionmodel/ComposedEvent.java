/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBNamedCommentedElement;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composed Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getCombinesEvents <em>Combines Events</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getConvergence <em>Convergence</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefinesNames <em>Refines Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedEvent()
 * @model
 * @generated
 */
public interface ComposedEvent extends EventBNamedCommentedElement {
	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list.
	 * The list contents are of type {@link org.eventb.emf.core.machine.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedEvent_Refines()
	 * @model
	 * @generated
	 */
	EList<Event> getRefines();

	/**
	 * Returns the value of the '<em><b>Combines Events</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Combines Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Combines Events</em>' containment reference list.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedEvent_CombinesEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CombinedEventMachine> getCombinesEvents();

	/**
	 * Returns the value of the '<em><b>Convergence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eventb.emf.core.machine.Convergence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Convergence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Convergence</em>' attribute.
	 * @see org.eventb.emf.core.machine.Convergence
	 * @see #setConvergence(Convergence)
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedEvent_Convergence()
	 * @model
	 * @generated
	 */
	Convergence getConvergence();

	/**
	 * Sets the value of the '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getConvergence <em>Convergence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Convergence</em>' attribute.
	 * @see org.eventb.emf.core.machine.Convergence
	 * @see #getConvergence()
	 * @generated
	 */
	void setConvergence(Convergence value);

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
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getComposedEvent_RefinesNames()
	 * @model
	 * @generated
	 */
	EList<String> getRefinesNames();

} // ComposedEvent
