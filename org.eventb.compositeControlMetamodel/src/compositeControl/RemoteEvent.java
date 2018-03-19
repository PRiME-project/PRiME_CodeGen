/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.RemoteEvent#getComposedEvent <em>Composed Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getRemoteEvent()
 * @model
 * @generated
 */
public interface RemoteEvent extends EventWrapper {

	/**
	 * Returns the value of the '<em><b>Composed Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Event</em>' reference.
	 * @see #setComposedEvent(ComposedEvent)
	 * @see compositeControl.CompositeControlPackage#getRemoteEvent_ComposedEvent()
	 * @model
	 * @generated
	 */
	ComposedEvent getComposedEvent();

	/**
	 * Sets the value of the '{@link compositeControl.RemoteEvent#getComposedEvent <em>Composed Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed Event</em>' reference.
	 * @see #getComposedEvent()
	 * @generated
	 */
	void setComposedEvent(ComposedEvent value);
} // RemoteEvent
