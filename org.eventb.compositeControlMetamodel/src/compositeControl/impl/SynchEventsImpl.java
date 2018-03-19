///**
// * <copyright>
// * </copyright>
// *
// * $Id$
// */
//package compositeControl.impl;
//
//import java.util.List;
//
//import compositeControl.CompositeControlPackage;
//import compositeControl.EventWrapper;
//import compositeControl.SynchEvents;
//
//import org.eclipse.core.runtime.Status;
//import org.eclipse.emf.common.notify.Notification;
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.common.util.URI;
//
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.InternalEObject;
//
//import org.eclipse.emf.ecore.impl.ENotificationImpl;
//import org.eventb.emf.core.CorePackage;
//import org.eventb.emf.core.externalisation.External;
//import org.eventb.emf.core.impl.AbstractExtensionImpl;
//import org.eventb.emf.core.impl.EventBElementImpl;
//import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
//import org.eclipse.emf.ecore.impl.EObjectImpl;
//
//import org.eventb.emf.core.machine.Event;
//import org.eventb.emf.core.machine.Machine;
//import org.eventb.emf.core.machine.MachineFactory;
//import org.rodinp.core.RodinCore;
//
///**
// * <!-- begin-user-doc -->
// * An implementation of the model object '<em><b>Synch Events</b></em>'.
// * <!-- end-user-doc -->
// * <p>
// * The following features are implemented:
// * <ul>
// *   <li>{@link compositeControl.impl.SynchEventsImpl#getLocalEvent <em>Local Event</em>}</li>
// *   <li>{@link compositeControl.impl.SynchEventsImpl#getRemoteEvent <em>Remote Event</em>}</li>
// *   <li>{@link compositeControl.impl.SynchEventsImpl#getLocalEventName <em>Local Event Name</em>}</li>
// *   <li>{@link compositeControl.impl.SynchEventsImpl#getRemoteEventName <em>Remote Event Name</em>}</li>
// * </ul>
// * </p>
// *
// * @generated
// */
//public class SynchEventsImpl extends EventBElementImpl implements SynchEvents {
//	/**
//	 * The cached value of the '{@link #getLocalEvent() <em>Local Event</em>}' reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getLocalEvent()
//	 * @generated
//	 * @ordered
//	 */
//	protected Event localEvent;
//
//	/**
//	 * The cached value of the '{@link #getRemoteEvent() <em>Remote Event</em>}' reference.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getRemoteEvent()
//	 * @generated
//	 * @ordered
//	 */
//	protected Event remoteEvent;
//
//	/**
//	 * The default value of the '{@link #getLocalEventName() <em>Local Event Name</em>}' attribute.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getLocalEventName()
//	 * @generated
//	 * @ordered
//	 */
//	protected static final String LOCAL_EVENT_NAME_EDEFAULT = null;
//
//	/**
//	 * The cached value of the '{@link #getLocalEventName() <em>Local Event Name</em>}' attribute.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getLocalEventName()
//	 * @generated
//	 * @ordered
//	 */
//	protected String localEventName = LOCAL_EVENT_NAME_EDEFAULT;
//
//	/**
//	 * The default value of the '{@link #getRemoteEventName() <em>Remote Event Name</em>}' attribute.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getRemoteEventName()
//	 * @generated
//	 * @ordered
//	 */
//	protected static final String REMOTE_EVENT_NAME_EDEFAULT = null;
//
//	/**
//	 * The cached value of the '{@link #getRemoteEventName() <em>Remote Event Name</em>}' attribute.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see #getRemoteEventName()
//	 * @generated
//	 * @ordered
//	 */
//	protected String remoteEventName = REMOTE_EVENT_NAME_EDEFAULT;
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected SynchEventsImpl() {
//		super();
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	protected EClass eStaticClass() {
//		return CompositeControlPackage.Literals.SYNCH_EVENTS;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public Event getLocalEvent() {
//		if (localEvent != null && localEvent.eIsProxy()) {
//			InternalEObject oldLocalEvent = (InternalEObject)localEvent;
//			localEvent = (Event)eResolveProxy(oldLocalEvent);
//			if (localEvent != oldLocalEvent) {
//				if (eNotificationRequired())
//					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT, oldLocalEvent, localEvent));
//			}
//		}
//		return localEvent;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public Event basicGetLocalEvent() {
//		return localEvent;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setLocalEvent(Event newLocalEvent) {
//		Event oldLocalEvent = localEvent;
//		localEvent = newLocalEvent;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT, oldLocalEvent, localEvent));
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public Event getRemoteEvent() {
//		if (remoteEvent != null && remoteEvent.eIsProxy()) {
//			InternalEObject oldRemoteEvent = (InternalEObject)remoteEvent;
//			remoteEvent = (Event)eResolveProxy(oldRemoteEvent);
//			if (remoteEvent != oldRemoteEvent) {
//				if (eNotificationRequired())
//					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT, oldRemoteEvent, remoteEvent));
//			}
//		}
//		return remoteEvent;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public Event basicGetRemoteEvent() {
//		return remoteEvent;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setRemoteEvent(Event newRemoteEvent) {
//		Event oldRemoteEvent = remoteEvent;
//		remoteEvent = newRemoteEvent;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT, oldRemoteEvent, remoteEvent));
//	}
//
////	/**
////	 * <!-- begin-user-doc -->
////	 * <!-- end-user-doc -->
////	 * @generated
////	 */
////	public String getLocalEventName() {
////		return localEventName;
////	}
//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getLocalEventName() {
//		Event e = getLocalEvent();
//		
//		if (e == null)
//		{
//			return null;
//		}
//		
//		return e.getName();
//	}
//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void setLocalEventName(String newName) {
//		
//			//get the current Event
//			Event proxy = getLocalEvent();
//			
//			if (proxy == null)
//			{
//				addLocalEventName(newName);
//			}
//			else
//			{
//				//if currently has a proxy at that index, re-use it for the new reference otherwise create a new one.
//				if (!proxy.eIsProxy()) proxy = MachineFactory.eINSTANCE.createEvent();
//				//set the proxy uri to a dummy with fragment set to newName
//				((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Event.class.getName()+"."+newName));
//				//set the proxy at the given index (using setUnique to avoid checking uniqueness because it involves resolving and loading)
//				setLocalEvent(proxy);
//			}
//			
//			
//			//	Set the machine name as the comment
//		//	proxy.setComment(machineName);
//	}
//	
//	/**
//	 * <!-- begin-user-doc -->
//	 * Adds a new proxy referencing the given machine name at the given index in the refines list.
//	 * This method does not check to see whether the new referenced machine exists,
//	 * nor whether the reference is unique within the collection.
//	 * This method does not resolve any proxies that are not already resolved
//	 *
//	 * @param newName - name of the element referenced
//	 * <!-- end-user-doc -->
//	 * @custom
//	 */
//	protected void addLocalEventName(String newName) {
//		Event proxy = MachineFactory.eINSTANCE.createEvent();
//		//add the new proxy (using setUnique to avoid checking uniqueness because it involves resolving and loading)
//		((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Event.class.getName()+"."+newName));
//		setLocalEvent(proxy);
//	}
//
////	/**
////	 * <!-- begin-user-doc -->
////	 * <!-- end-user-doc -->
////	 * @generated
////	 */
////	public void setLocalEventName(String newLocalEventName) {
////		String oldLocalEventName = localEventName;
////		localEventName = newLocalEventName;
////		if (eNotificationRequired())
////			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME, oldLocalEventName, localEventName));
////	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public String getRemoteEventName() {
//		return remoteEventName;
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setRemoteEventName(String newRemoteEventName) {
//		String oldRemoteEventName = remoteEventName;
//		remoteEventName = newRemoteEventName;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME, oldRemoteEventName, remoteEventName));
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public Object eGet(int featureID, boolean resolve, boolean coreType) {
//		switch (featureID) {
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT:
//				if (resolve) return getLocalEvent();
//				return basicGetLocalEvent();
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT:
//				if (resolve) return getRemoteEvent();
//				return basicGetRemoteEvent();
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME:
//				return getLocalEventName();
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME:
//				return getRemoteEventName();
//		}
//		return super.eGet(featureID, resolve, coreType);
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public void eSet(int featureID, Object newValue) {
//		switch (featureID) {
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT:
//				setLocalEvent((Event)newValue);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT:
//				setRemoteEvent((Event)newValue);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME:
//				setLocalEventName((String)newValue);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME:
//				setRemoteEventName((String)newValue);
//				return;
//		}
//		super.eSet(featureID, newValue);
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public void eUnset(int featureID) {
//		switch (featureID) {
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT:
//				setLocalEvent((Event)null);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT:
//				setRemoteEvent((Event)null);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME:
//				setLocalEventName(LOCAL_EVENT_NAME_EDEFAULT);
//				return;
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME:
//				setRemoteEventName(REMOTE_EVENT_NAME_EDEFAULT);
//				return;
//		}
//		super.eUnset(featureID);
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public boolean eIsSet(int featureID) {
//		switch (featureID) {
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT:
//				return localEvent != null;
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT:
//				return remoteEvent != null;
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME:
//				return LOCAL_EVENT_NAME_EDEFAULT == null ? localEventName != null : !LOCAL_EVENT_NAME_EDEFAULT.equals(localEventName);
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME:
//				return REMOTE_EVENT_NAME_EDEFAULT == null ? remoteEventName != null : !REMOTE_EVENT_NAME_EDEFAULT.equals(remoteEventName);
//		}
//		return super.eIsSet(featureID);
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public String toString() {
//		if (eIsProxy()) return super.toString();
//
//		StringBuffer result = new StringBuffer(super.toString());
//		result.append(" (localEventName: ");
//		result.append(localEventName);
//		result.append(", remoteEventName: ");
//		result.append(remoteEventName);
//		result.append(')');
//		return result.toString();
//	}
//	
//	
//	
//	
//	
//
//	
//	
//	
//	
//	
//	
////	
////	/**
////	 * Resolves a proxy associated with this element.
////	 * URI's are constructed lazily. A dummy URI with just a fragment holding the name of the referenced item, is used
////	 * until this point. When a proxy is resolved, the URI is constructed based on this elements resource URI.
////	 * Therefore, proxies will not resolve until this element has been associated with a resource.
////	 *
////	 * Following construction of the URI, the proxy resolution is deferred to super
////	 *
////	 * @custom
////	 */
////
////	@Override
////	public EObject eResolveProxy(InternalEObject proxy){
////	  if (proxy != null && proxy.eIsProxy()){
////		  if (eResource()==null) return proxy;
////		  try{
////			 String reference = proxy.eProxyURI().fragment();
////			 
////			 // if resolved already in the parent, do not resolve again
////			 if (eContainer() != null)
////				 for (EObject component : eContainer().eContents())
////				 {							
////					 //	CJL - Adding instanceof to prevent exception being thrown when Events are passed through here
////					 if (component instanceof EventBNamedCommentedElementImpl && ((EventBNamedCommentedElementImpl) component).getReference().equals(reference))
////						 return component;
////					//	CJL - Adding check for wider range of objects
////					 else if (component instanceof EventBElementImpl && ((EventBElementImpl) component).getReference().equals(reference))
////						 return component;
////				 }
////			 
////			 // attempt to construct a suitable proxy URI
////			 URI uri=null;
////			 String projectName = getURI().trimSegments(getURI().segmentCount()-2).lastSegment();
////			 String resourceName = reference.substring(reference.lastIndexOf(".")+1);
////			 
////			 
////	
////			 //	CJL - get the name of the machine the event is in
////			// String machineResourceName = 
////
////			 if (proxy instanceof Event && getLocalEvent().equals(proxy)){
////				 
//	
//	// NOOOOOOOOOOOOOOOOO
//	//	SynchEvent will belong to a tasking machine
//	//	Tasking machine wont have a machine as its container - eventually it will be a composed machine that contains everything
//	//	So this will make identifying the machine much harder
////				 //	Go back through the containing classes to find the machine the event is
////				 //	SynchEvents --> EventWrapper --> Task Type --> Event
////				 EventWrapper eventWrapper = (EventWrapper)eContainer;
////				 
////				 //	Don't want to load tasking - breaks everything - so skip to event
////				 //TaskType taskType = (TaskType)eventWrapper.eContainer();
////				 //	twice .eContainer to skip TaskType as importing it breaks things
////				 Event event = (Event)eventWrapper.eContainer().eContainer();
////				 Machine machine = (Machine)event.eContainer();
////				 
////				 
////				 //	Partially from EventImpl - can do this as only one Machine can be refined per ComposedMachineImpl
////	//			 Machine refinedMachine = ((Machine)eContainer).getRefines().get(0);				 
////	//			 uri = refinedMachine.getURI()
////	//			 	.appendFragment(proxy.eProxyURI().fragment());
////				 
////				 
////				 uri = URI.createPlatformResourceURI(projectName, true)
////								 	.appendSegment(machine.getName())
////								 	.appendFileExtension(External.getString("FileExtensions.machine"))
////								 	.appendFragment(reference);
////				 
////				 
/////*		 From Machine
////				 uri = URI.createPlatformResourceURI(projectName, true)
////	//			 	.appendSegment(resourceName)
////				 	.appendSegment("Machine1")
////				 	.appendFileExtension(External.getString("FileExtensions.machine"))
////				 	.appendFragment(reference);
////*/				 	
////			 }
//////			 else if (proxy instanceof Context && getSees().contains(proxy)){
//////				 uri = URI.createPlatformResourceURI(projectName, true)
//////				 	.appendSegment(resourceName)
//////				 	.appendFileExtension(External.getString("FileExtensions.context"))
//////				 	.appendFragment(reference);				 
//////			 }
////			 if (uri!=null) proxy.eSetProxyURI(uri);
////		  }catch (Exception e){
////		//		RodinCore.getPlugin().getLog().log(new Status(Status.ERROR, "org.eventb.emf.core", "Cannot resolve: " + proxy, e));
////			  return proxy;
////		  }
////	  }
////	  return super.eResolveProxy(proxy);
////	}
////	
////	
////	/**
////	 * Overrides to always require notification. This is to ensure that changes to derived features can be reflected in the 
////	 * main features from which they are derived
////	 */
////	/* (non-Javadoc)
////	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
////	 */
////	@Override
////	public boolean eNotificationRequired(){return true;}
////	
////	
////	/**
////	 * Intercepts notification to reflect any changes made to the 'refinesNames' and 'seesNames' lists into
////	 * the 'refines' and 'sees' collections from which they are derived.
////	 * Then defers to super.
////	 */
////	/* (non-Javadoc)
////	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
////	 */
////	@SuppressWarnings("unchecked")
////	@Override
////	public void eNotify(Notification notification){
////		
////		if (notification.getFeatureID(this.getClass()) == CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME){
////			switch (notification.getEventType()){
////			case Notification.SET:
////				setLocalEventName(notification.getNewStringValue());
////				break;
////			case Notification.UNSET:
////				setLocalEvent(null);	//not expected to be used
////				break;
////			case Notification.ADD: {
////				addLocalEventName(notification.getNewStringValue());
////				break;
////			}
////			case Notification.REMOVE: {
////				setLocalEvent(null);
////				break;
////			}
////			case Notification.ADD_MANY: {
////				for (String newName : (List<String>)notification.getNewValue()){
////					addLocalEventName(newName);
////				}
////				break;
////			}
////			case Notification.REMOVE_MANY: {
////				if (notification.getNewValue()==null && notification.getPosition()==-1){
////					setLocalEvent(null);
////				}
////				break;
////			}
////			case Notification.MOVE:
////				//N.B decided it is better NOT to prevent exceptions, otherwise the names list will be out of sync with the references
////				//if (!(notification.getOldValue() instanceof Integer)) break;
////		//		int oldpos = ((Integer)notification.getOldValue()).intValue();
////		//		int newpos = notification.getPosition();
////				//if (oldpos<0 || newpos<0 || oldpos >= getSees().size() || newpos >= getSees().size() ) break;
////		//		getRefines().move(newpos, oldpos);
////				break;
////			default: break;
////			}
////		}
////		super.eNotify(notification);
////	}
////	
////	
////	
//	
//	
//	
//
//} //SynchEventsImpl
