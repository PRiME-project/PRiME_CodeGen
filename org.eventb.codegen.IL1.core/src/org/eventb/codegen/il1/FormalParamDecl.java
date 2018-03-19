/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Param Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eventb.codegen.il1.FormalParamDecl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eventb.codegen.il1.Il1Package#getFormalParamDecl()
 * @model
 * @generated
 */
public interface FormalParamDecl extends Declaration {
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eventb.codegen.il1.ParamModeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.eventb.codegen.il1.ParamModeEnum
	 * @see #setMode(ParamModeEnum)
	 * @see org.eventb.codegen.il1.Il1Package#getFormalParamDecl_Mode()
	 * @model required="true"
	 * @generated
	 */
	ParamModeEnum getMode();

	/**
	 * Sets the value of the '{@link org.eventb.codegen.il1.FormalParamDecl#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.eventb.codegen.il1.ParamModeEnum
	 * @see #getMode()
	 * @generated
	 */
	void setMode(ParamModeEnum value);

} // FormalParamDecl
