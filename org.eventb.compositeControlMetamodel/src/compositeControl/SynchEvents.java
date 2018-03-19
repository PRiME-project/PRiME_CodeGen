/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synch Events</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link compositeControl.SynchEvents#getLocalEvent <em>Local Event</em>}</li>
 *   <li>{@link compositeControl.SynchEvents#getRemoteEvent <em>Remote Event</em>}</li>
 *   <li>{@link compositeControl.SynchEvents#getLocalEventName <em>Local Event Name</em>}</li>
 *   <li>{@link compositeControl.SynchEvents#getRemoteEventName <em>Remote Event Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see compositeControl.CompositeControlPackage#getSynchEvents()
 * @model
 * @generated
 */
public interface SynchEvents extends EventBElement {
	/**
	 * Returns the value of the '<em><b>Local Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Event</em>' reference.
	 * @see #setLocalEvent(Event)
	 * @see compositeControl.CompositeControlPackage#getSynchEvents_LocalEvent()
	 * @model
	 * @generated
	 */
	Event getLocalEvent();

	/**
	 * Sets the value of the '{@link compositeControl.SynchEvents#getLocalEvent <em>Local Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Event</em>' reference.
	 * @see #getLocalEvent()
	 * @generated
	 */
	void setLocalEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Remote Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Event</em>' reference.
	 * @see #setRemoteEvent(Event)
	 * @see compositeControl.CompositeControlPackage#getSynchEvents_RemoteEvent()
	 * @model
	 * @generated
	 */
	Event getRemoteEvent();

	/**
	 * Sets the value of the '{@link compositeControl.SynchEvents#getRemoteEvent <em>Remote Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Event</em>' reference.
	 * @see #getRemoteEvent()
	 * @generated
	 */
	void setRemoteEvent(Event value);

	/**
	 * Returns the value of the '<em><b>Local Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Event Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Event Name</em>' attribute.
	 * @see #setLocalEventName(String)
	 * @see compositeControl.CompositeControlPackage#getSynchEvents_LocalEventName()
	 * @model
	 * @generated
	 */
	String getLocalEventName();

	/**
	 * Sets the value of the '{@link compositeControl.SynchEvents#getLocalEventName <em>Local Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Event Name</em>' attribute.
	 * @see #getLocalEventName()
	 * @generated
	 */
	void setLocalEventName(String value);

	/**
	 * Returns the value of the '<em><b>Remote Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Event Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Event Name</em>' attribute.
	 * @see #setRemoteEventName(String)
	 * @see compositeControl.CompositeControlPackage#getSynchEvents_RemoteEventName()
	 * @model
	 * @generated
	 */
	String getRemoteEventName();

	/**
	 * Sets the value of the '{@link compositeControl.SynchEvents#getRemoteEventName <em>Remote Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Event Name</em>' attribute.
	 * @see #getRemoteEventName()
	 * @generated
	 */
	void setRemoteEventName(String value);

} // SynchEvents
