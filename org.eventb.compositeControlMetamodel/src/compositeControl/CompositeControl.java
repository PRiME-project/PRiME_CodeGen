/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import org.eventb.emf.core.AbstractExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.CompositeControl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getCompositeControl()
 * @model abstract="true"
 * @generated
 */
public interface CompositeControl extends AbstractExtension {

	/**
	 * Returns the value of the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Envir State Machine Child</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Envir State Machine Child</em>' attribute.
	 * @see #setEnvirStateMachineChild(boolean)
	 * @see compositeControl.CompositeControlPackage#getCompositeControl_EnvirStateMachineChild()
	 * @model default="false"
	 * @generated
	 */
	boolean isEnvirStateMachineChild();

	/**
	 * Sets the value of the '{@link compositeControl.CompositeControl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Envir State Machine Child</em>' attribute.
	 * @see #isEnvirStateMachineChild()
	 * @generated
	 */
	void setEnvirStateMachineChild(boolean value);
} // CompositeControl
