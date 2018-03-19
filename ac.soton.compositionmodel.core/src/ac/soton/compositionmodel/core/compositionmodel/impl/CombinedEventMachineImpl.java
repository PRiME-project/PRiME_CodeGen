/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.impl.EventBElementImpl;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combined Event Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl#getMachineName <em>Machine Name</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl#getEventName <em>Event Name</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CombinedEventMachineImpl extends EventBElementImpl implements CombinedEventMachine {
	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine machine;

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
	 * The default value of the '{@link #getMachineName() <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineName()
	 * @generated
	 * @ordered
	 */
	protected static final String MACHINE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMachineName() <em>Machine Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineName()
	 * @generated
	 * @ordered
	 */
	protected String machineName = MACHINE_NAME_EDEFAULT;

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
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedEventMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionmodelPackage.eINSTANCE.getCombinedEventMachine();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getMachine() {
		if (machine != null && machine.eIsProxy()) {
			InternalEObject oldMachine = (InternalEObject)machine;
			machine = (Machine)eResolveProxy(oldMachine);
			if (machine != oldMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE, oldMachine, machine));
			}
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Machine newMachine) {
		Machine oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE, oldMachine, machine));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT, oldEvent, event));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT, oldEvent, event));
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public String getMachineName() {
//		return machineName;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMachineName() {
		Machine e = getMachine();

		if (e == null)
		{
			return null;
		}

		return e.getName();
	}



//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setMachineName(String newMachineName) {
//		String oldMachineName = machineName;
//		machineName = newMachineName;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME, oldMachineName, machineName));
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMachineName(String newName) {

			//get the current Event
			Machine proxy = getMachine();

			if (proxy == null)
			{
				addMachineName(newName);
			}
			else
			{
				//if currently has a proxy at that index, re-use it for the new reference otherwise create a new one.
				if (!proxy.eIsProxy()) proxy = MachineFactory.eINSTANCE.createMachine();
				//set the proxy uri to a dummy with fragment set to newName
				((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Machine.class.getName()+"."+newName));
				//set the proxy at the given index (using setUnique to avoid checking uniqueness because it involves resolving and loading)
				setMachine(proxy);
			}




			//	Adding actually saving the machine name!
			machineName = newName;


			//	Set the machine name as the comment
		//	proxy.setComment(machineName);
	}

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
	protected void addMachineName(String newName) {
		Machine proxy = MachineFactory.eINSTANCE.createMachine();
		//add the new proxy (using setUnique to avoid checking uniqueness because it involves resolving and loading)
		((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Machine.class.getName()+"."+newName));
		setMachine(proxy);
	}

//
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
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public void setEventName(String newEventName) {
//		String oldEventName = eventName;
//		eventName = newEventName;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME, oldEventName, eventName));
//	}


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

			//	Actually setting the event name
			eventName = newName;

			//	Set the machine name as the comment
		//	proxy.setComment(machineName);
	}


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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMBINED_EVENT_MACHINE__PROJECT_NAME, oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME:
				return getMachineName();
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME:
				return getEventName();
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__PROJECT_NAME:
				return getProjectName();
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
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE:
				setMachine((Machine)newValue);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT:
				setEvent((Event)newValue);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME:
				setMachineName((String)newValue);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME:
				setEventName((String)newValue);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__PROJECT_NAME:
				setProjectName((String)newValue);
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
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE:
				setMachine((Machine)null);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT:
				setEvent((Event)null);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME:
				setMachineName(MACHINE_NAME_EDEFAULT);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME:
				setEventName(EVENT_NAME_EDEFAULT);
				return;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
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
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE:
				return machine != null;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT:
				return event != null;
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME:
				return MACHINE_NAME_EDEFAULT == null ? machineName != null : !MACHINE_NAME_EDEFAULT.equals(machineName);
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME:
				return EVENT_NAME_EDEFAULT == null ? eventName != null : !EVENT_NAME_EDEFAULT.equals(eventName);
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
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
		result.append(" (machineName: ");
		result.append(machineName);
		result.append(", eventName: ");
		result.append(eventName);
		result.append(", projectName: ");
		result.append(projectName);
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

				 //	May just need to load in the machine here...

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
			 else if (proxy instanceof Machine && machine.equals(proxy)){

				 uri = URI.createPlatformResourceURI(projectName, true)
								 	.appendSegment(resourceName)
								 	//.appendFileExtension(External.getString("FileExtensions.machine"))
								 	.appendFileExtension("bum")
								 	.appendFragment(reference);

			 }
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
	@Override
	public void eNotify(Notification notification){

		if (notification.getFeatureID(this.getClass()) == CompositionmodelPackage.COMBINED_EVENT_MACHINE__EVENT_NAME){
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
		else if (notification.getFeatureID(this.getClass()) == CompositionmodelPackage.COMBINED_EVENT_MACHINE__MACHINE_NAME){
			switch (notification.getEventType()){
			case Notification.SET:
				setMachineName(notification.getNewStringValue());
				break;
			case Notification.UNSET:
				setMachine(null);	//not expected to be used
				break;
			case Notification.ADD: {
				addMachineName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE: {
				setMachine(null);
				break;
			}
			case Notification.ADD_MANY: {
	//			for (String newName : (List<String>)notification.getNewValue()){
	//				addEventName(newName);
	//			}
				//	can't be many
				addMachineName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE_MANY: {
				if (notification.getNewValue()==null && notification.getPosition()==-1){
					setMachine(null);
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







} //CombinedEventMachineImpl
