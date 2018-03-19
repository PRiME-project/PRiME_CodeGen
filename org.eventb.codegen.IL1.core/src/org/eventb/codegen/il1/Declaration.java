/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.Declaration#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Declaration#getType <em>Type</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Declaration#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Declaration#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eventb.codegen.il1.Declaration#getComponentName <em>Component Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface Declaration extends IL1Element {

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eventb.codegen.il1.Il1Package#getDeclaration_Identifier()
	 * @model default="" required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Declaration#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eventb.codegen.il1.Il1Package#getDeclaration_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Declaration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' attribute.
	 * @see #setInitialValue(String)
	 * @see org.eventb.codegen.il1.Il1Package#getDeclaration_InitialValue()
	 * @model
	 * @generated
	 */
	String getInitialValue();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Declaration#getInitialValue <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' attribute.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(String value);

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
	 * @see org.eventb.codegen.il1.Il1Package#getDeclaration_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Declaration#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Name</em>' attribute.
	 * @see #setComponentName(String)
	 * @see org.eventb.codegen.il1.Il1Package#getDeclaration_ComponentName()
	 * @model
	 * @generated
	 */
	String getComponentName();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.Declaration#getComponentName <em>Component Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Name</em>' attribute.
	 * @see #getComponentName()
	 * @generated
	 */
	void setComponentName(String value);
} // Declaration
