/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel;

import org.eventb.emf.core.EventBCommentedElement;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Included Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getIncludedMachine()
 * @model
 * @generated
 */
public interface IncludedMachine extends EventBCommentedElement {
	/**
	 * Returns the value of the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' reference.
	 * @see #setMachine(Machine)
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getIncludedMachine_Machine()
	 * @model
	 * @generated
	 */
	Machine getMachine();

	/**
	 * Sets the value of the '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachine <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Machine value);

	/**
	 * Returns the value of the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Name</em>' attribute.
	 * @see #setMachineName(String)
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getIncludedMachine_MachineName()
	 * @model
	 * @generated
	 */
	String getMachineName();

	/**
	 * Sets the value of the '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachineName <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Name</em>' attribute.
	 * @see #getMachineName()
	 * @generated
	 */
	void setMachineName(String value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage#getIncludedMachine_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

} // IncludedMachine
