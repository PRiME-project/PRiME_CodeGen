/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.impl.EventBElementImpl;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;

import compositeControl.CompositeControlPackage;
import compositeControl.EventWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Wrapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.EventWrapperImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link compositeControl.impl.EventWrapperImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link compositeControl.impl.EventWrapperImpl#getEventName <em>Event Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventWrapperImpl extends CompositeControlImpl implements EventWrapper {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected Event event;

	/**
	 * The default value of the '{@link #getEventName() <em>Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventName()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventName() <em>Event Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventName()
	 * @generated
	 * @ordered
	 */
	protected String eventName = EVENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.EVENT_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.EVENT_WRAPPER__LABEL, oldLabel, label));
	}

	
	public Event getEvent2(){
		Event evt = null;

		
		return evt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = (Event)eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositeControlPackage.EVENT_WRAPPER__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Event newEvent) {
		Event oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.EVENT_WRAPPER__EVENT, oldEvent, event));
	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public String getEventName() {
//		return eventName;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
//	public void setEventName(String newEventName) {
//		String oldEventName = eventName;
//		eventName = newEventName;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME, oldEventName, eventName));
//	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public String getEventName() {
//		return eventName;
//	}
	
//	MOVED TO LocalEventImpl
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEventName() {
		Event e = getEvent();
		
		if (e == null)
		{
			return null;
		}
		
		return e.getName();
	}
//	
//	MOVED TO LocalEventImpl
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setEventName(String newName) {
		
			//get the current Event
			Event proxy = getEvent();
			
			if (proxy == null)
			{
				addEventName(newName);
			}
			else
			{
				//if currently has a proxy at that index, re-use it for the new reference otherwise create a new one.
				if (!proxy.eIsProxy()) proxy = MachineFactory.eINSTANCE.createEvent();
				//set the proxy uri to a dummy with fragment set to newName
				((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Event.class.getName()+"."+newName));
				//set the proxy at the given index (using setUnique to avoid checking uniqueness because it involves resolving and loading)
				setEvent(proxy);
			}
			
			eventName = newName;
			
			//	Set the machine name as the comment
		//	proxy.setComment(machineName);
	}
//	
//	MOVED to LocalEventImpl	
	/**
	 * <!-- begin-user-doc -->
	 * Adds a new proxy referencing the given machine name at the given index in the refines list.
	 * This method does not check to see whether the new referenced machine exists,
	 * nor whether the reference is unique within the collection.
	 * This method does not resolve any proxies that are not already resolved
	 *
	 * @param newName - name of the element referenced
	 * <!-- end-user-doc -->
	 * @custom
	 */
	protected void addEventName(String newName) {
		Event proxy = MachineFactory.eINSTANCE.createEvent();
		//add the new proxy (using setUnique to avoid checking uniqueness because it involves resolving and loading)
		((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Event.class.getName()+"."+newName));
		setEvent(proxy);
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setEventName(String newEventName) {
//		String oldEventName = eventName;
//		eventName = newEventName;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME, oldEventName, eventName));
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositeControlPackage.EVENT_WRAPPER__LABEL:
				return getLabel();
			case CompositeControlPackage.EVENT_WRAPPER__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME:
				return getEventName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompositeControlPackage.EVENT_WRAPPER__LABEL:
				setLabel((String)newValue);
				return;
			case CompositeControlPackage.EVENT_WRAPPER__EVENT:
				setEvent((Event)newValue);
				return;
			case CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME:
				setEventName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompositeControlPackage.EVENT_WRAPPER__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case CompositeControlPackage.EVENT_WRAPPER__EVENT:
				setEvent((Event)null);
				return;
			case CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME:
				setEventName(EVENT_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompositeControlPackage.EVENT_WRAPPER__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case CompositeControlPackage.EVENT_WRAPPER__EVENT:
				return event != null;
			case CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME:
				return EVENT_NAME_EDEFAULT == null ? eventName != null : !EVENT_NAME_EDEFAULT.equals(eventName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", eventName: ");
		result.append(eventName);
		result.append(')');
		return result.toString();
	}
	
	
	
		
	/**
	 * Resolves a proxy associated with this element.
	 * URI's are constructed lazily. A dummy URI with just a fragment holding the name of the referenced item, is used
	 * until this point. When a proxy is resolved, the URI is constructed based on this elements resource URI.
	 * Therefore, proxies will not resolve until this element has been associated with a resource.
	 *
	 * Following construction of the URI, the proxy resolution is deferred to super
	 *
	 * @custom
	 */

	@Override
	public EObject eResolveProxy(InternalEObject proxy){
	  if (proxy != null && proxy.eIsProxy()){
		  if (eResource()==null) return proxy;
		  try{
			 String reference = proxy.eProxyURI().fragment();
			 
			 // if resolved already in the parent, do not resolve again
			 if (eContainer() != null)
				 for (EObject component : eContainer().eContents())
				 {							
					 //	CJL - Adding instanceof to prevent exception being thrown when Events are passed through here
					 if (component instanceof EventBNamedCommentedElementImpl && ((EventBNamedCommentedElementImpl) component).getReference().equals(reference))
						 return component;
					//	CJL - Adding check for wider range of objects
					 else if (component instanceof EventBElementImpl && ((EventBElementImpl) component).getReference().equals(reference))
						 return component;
				 }
			 
			 // attempt to construct a suitable proxy URI
			 URI uri=null;
			 String projectName = getURI().trimSegments(getURI().segmentCount()-2).lastSegment();
			 String resourceName = reference.substring(reference.lastIndexOf(".")+1);
			 
			 
	
			 //	CJL - get the name of the machine the event is in
			// String machineResourceName = 

			 if (proxy instanceof Event && event.equals(proxy)){
				 
	
				 //	Go up through the hierarchy until you get a machine
				 //	This may not (wont) work when ComposedMachines are added
				 //	but its not clear where ComposedMachines fit into this all
				 
				 EObject mContainer = eContainer;
				 while (mContainer != null && !(mContainer instanceof Machine))
				 {
					 mContainer = mContainer.eContainer();
				 }
				 
				 if (mContainer == null)
					 throw new Exception("DEBUG: EventWrapper does not have a machine parent");
				 
				 Machine machine = (Machine)mContainer;
				
				 //Sadegh: for some reason this method did not return the correct event, 
				 // the following code does the job. I did not remove the rest of the code 
				 // in case I am missing something.
				for(Event evt : machine.getEvents())
				{
					if(eventName.equals(evt.getName()))
					{
						return evt;
					}
				}
				//End of new code. Sadegh
				 
//				 EventWrapper eventWrapper = (EventWrapper)eContainer;
//				 
//				 //	Don't want to load tasking - breaks everything - so skip to event
//				 //TaskType taskType = (TaskType)eventWrapper.eContainer();
//				 //	twice .eContainer to skip TaskType as importing it breaks things
//				 Event event = (Event)eventWrapper.eContainer().eContainer();
//				 Machine machine = (Machine)event.eContainer();
//				 
				 
				 //	Partially from EventImpl - can do this as only one Machine can be refined per ComposedMachineImpl
	//			 Machine refinedMachine = ((Machine)eContainer).getRefines().get(0);				 
	//			 uri = refinedMachine.getURI()
	//			 	.appendFragment(proxy.eProxyURI().fragment());
				 
				 
				 uri = URI.createPlatformResourceURI(projectName, true)
								 	.appendSegment(machine.getName())
//								 	.appendFileExtension(External.getString("FileExtensions.machine"))
								 	.appendFileExtension("bum")
								 	.appendFragment(reference);
				 
				 
/*		 From Machine
				 uri = URI.createPlatformResourceURI(projectName, true)
	//			 	.appendSegment(resourceName)
				 	.appendSegment("Machine1")
				 	.appendFileExtension(External.getString("FileExtensions.machine"))
				 	.appendFragment(reference);
*/				 	
			 }
//			 else if (proxy instanceof Context && getSees().contains(proxy)){
//				 uri = URI.createPlatformResourceURI(projectName, true)
//				 	.appendSegment(resourceName)
//				 	.appendFileExtension(External.getString("FileExtensions.context"))
//				 	.appendFragment(reference);				 
//			 }
			 if (uri!=null) proxy.eSetProxyURI(uri);
		  }catch (Exception e){
		//		RodinCore.getPlugin().getLog().log(new Status(Status.ERROR, "org.eventb.emf.core", "Cannot resolve: " + proxy, e));
			  return proxy;
		  }
	  }
	  return super.eResolveProxy(proxy);
	}
	
	/**
	 * Overrides to always require notification. This is to ensure that changes to derived features can be reflected in the 
	 * main features from which they are derived
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotificationRequired()
	 */
	@Override
	public boolean eNotificationRequired(){return true;}
	
	
	/**
	 * Intercepts notification to reflect any changes made to the 'refinesNames' and 'seesNames' lists into
	 * the 'refines' and 'sees' collections from which they are derived.
	 * Then defers to super.
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eNotify(org.eclipse.emf.common.notify.Notification)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification){
		
		if (notification.getFeatureID(this.getClass()) == CompositeControlPackage.EVENT_WRAPPER__EVENT_NAME){
			switch (notification.getEventType()){
			case Notification.SET:
				setEventName(notification.getNewStringValue());
				break;
			case Notification.UNSET:
				setEvent(null);	//not expected to be used
				break;
			case Notification.ADD: {
				addEventName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE: {
				setEvent(null);
				break;
			}
			case Notification.ADD_MANY: {
	//			for (String newName : (List<String>)notification.getNewValue()){
	//				addEventName(newName);
	//			}
				//	can't be many
				addEventName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE_MANY: {
				if (notification.getNewValue()==null && notification.getPosition()==-1){
					setEvent(null);
				}
				break;
			}
			case Notification.MOVE:
				//N.B decided it is better NOT to prevent exceptions, otherwise the names list will be out of sync with the references
				//if (!(notification.getOldValue() instanceof Integer)) break;
		//		int oldpos = ((Integer)notification.getOldValue()).intValue();
		//		int newpos = notification.getPosition();
				//if (oldpos<0 || newpos<0 || oldpos >= getSees().size() || newpos >= getSees().size() ) break;
		//		getRefines().move(newpos, oldpos);
				break;
			default: break;
			}
		}
		super.eNotify(notification);
	}
	

} //EventWrapperImpl
