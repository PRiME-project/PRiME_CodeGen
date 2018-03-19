/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import org.eventb.emf.core.machine.Event;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.EventWrapper#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.EventWrapper#getEvent <em>Event</em>}</li>
 *   <li>{@link compositeControl.EventWrapper#getEventName <em>Event Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getEventWrapper()
 * @model
 * @generated
 */
public interface EventWrapper extends CompositeControl {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see compositeControl.CompositeControlPackage#getEventWrapper_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link compositeControl.EventWrapper#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(Event)
	 * @see compositeControl.CompositeControlPackage#getEventWrapper_Event()
	 * @model
	 * @generated
	 */
	Event getEvent();

	/**
	 * Sets the value of the '{@link compositeControl.EventWrapper#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Name</em>' attribute.
	 * @see #setEventName(String)
	 * @see compositeControl.CompositeControlPackage#getEventWrapper_EventName()
	 * @model
	 * @generated
	 */
	String getEventName();

	/**
	 * Sets the value of the '{@link compositeControl.EventWrapper#getEventName <em>Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Name</em>' attribute.
	 * @see #getEventName()
	 * @generated
	 */
	void setEventName(String value);

} // EventWrapper
