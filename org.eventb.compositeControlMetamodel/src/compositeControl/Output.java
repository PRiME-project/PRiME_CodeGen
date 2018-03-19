/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import org.eventb.emf.core.machine.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.Output#getText <em>Text</em>}</li>
 *   <li>{@link compositeControl.Output#getElement <em>Element</em>}</li>
 *   <li>{@link compositeControl.Output#getVariableName <em>Variable Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends CompositeControl {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see compositeControl.CompositeControlPackage#getOutput_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link compositeControl.Output#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Variable)
	 * @see compositeControl.CompositeControlPackage#getOutput_Element()
	 * @model
	 * @generated
	 */
	Variable getElement();

	/**
	 * Sets the value of the '{@link compositeControl.Output#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Variable value);

	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see compositeControl.CompositeControlPackage#getOutput_VariableName()
	 * @model
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link compositeControl.Output#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

} // Output
