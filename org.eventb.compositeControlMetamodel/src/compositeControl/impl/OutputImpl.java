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
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.impl.EventBElementImpl;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Variable;

import compositeControl.CompositeControlPackage;
import compositeControl.Output;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link compositeControl.impl.OutputImpl#getText <em>Text</em>}</li>
 *   <li>{@link compositeControl.impl.OutputImpl#getElement <em>Element</em>}</li>
 *   <li>{@link compositeControl.impl.OutputImpl#getVariableName <em>Variable Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputImpl extends CompositeControlImpl implements Output {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Variable element;

	/**
	 * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected String variableName = VARIABLE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositeControlPackage.Literals.OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.OUTPUT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (Variable)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositeControlPackage.OUTPUT__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Variable newElement) {
		Variable oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositeControlPackage.OUTPUT__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getVariableName() {
		Variable v = getElement();
		
		if (v == null)
		{
			return null;
		}
		
		return v.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setVariableName(String newVariableName) {
		//get the current Event
		Variable proxy = getElement();
		
		if (proxy == null)
		{
			addVariableName(newVariableName);
		}
		else
		{
			//if currently has a proxy at that index, re-use it for the new reference otherwise create a new one.
			if (!proxy.eIsProxy()) proxy = MachineFactory.eINSTANCE.createVariable();
			//set the proxy uri to a dummy with fragment set to newName
			((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Variable.class.getName()+"."+newVariableName));
			//set the proxy at the given index (using setUnique to avoid checking uniqueness because it involves resolving and loading)
			setElement(proxy);
		}
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
	protected void addVariableName(String newName) {
		Variable proxy = MachineFactory.eINSTANCE.createVariable();
		//add the new proxy (using setUnique to avoid checking uniqueness because it involves resolving and loading)
		((InternalEObject)proxy).eSetProxyURI(CorePackage.dummyURI.appendFragment(Variable.class.getName()+"."+newName));
		setElement(proxy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositeControlPackage.OUTPUT__TEXT:
				return getText();
			case CompositeControlPackage.OUTPUT__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case CompositeControlPackage.OUTPUT__VARIABLE_NAME:
				return getVariableName();
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
			case CompositeControlPackage.OUTPUT__TEXT:
				setText((String)newValue);
				return;
			case CompositeControlPackage.OUTPUT__ELEMENT:
				setElement((Variable)newValue);
				return;
			case CompositeControlPackage.OUTPUT__VARIABLE_NAME:
				setVariableName((String)newValue);
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
			case CompositeControlPackage.OUTPUT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case CompositeControlPackage.OUTPUT__ELEMENT:
				setElement((Variable)null);
				return;
			case CompositeControlPackage.OUTPUT__VARIABLE_NAME:
				setVariableName(VARIABLE_NAME_EDEFAULT);
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
			case CompositeControlPackage.OUTPUT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case CompositeControlPackage.OUTPUT__ELEMENT:
				return element != null;
			case CompositeControlPackage.OUTPUT__VARIABLE_NAME:
				return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", variableName: ");
		result.append(variableName);
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

			 if (proxy instanceof Variable && element.equals(proxy)){
				 
	
				 //	Go up through the hierarchy until you get a machine
				 //	This may not (wont) work when ComposedMachines are added
				 //	but its not clear where ComposedMachines fit into this all
				 
				 EObject mContainer = eContainer;
				 while (mContainer != null && !(mContainer instanceof Machine))
				 {
					 mContainer = mContainer.eContainer();
				 }
				 
				 if (mContainer == null)
					 throw new Exception("DEBUG: Variable does not have a machine parent");
				 
				 Machine machine = (Machine)mContainer;
						 
				 
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
		
		if (notification.getFeatureID(this.getClass()) == CompositeControlPackage.OUTPUT__VARIABLE_NAME){
			switch (notification.getEventType()){
			case Notification.SET:
				setVariableName(notification.getNewStringValue());
				break;
			case Notification.UNSET:
				setElement(null);	//not expected to be used
				break;
			case Notification.ADD: {
				addVariableName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE: {
				setElement(null);
				break;
			}
			case Notification.ADD_MANY: {
	//			for (String newName : (List<String>)notification.getNewValue()){
	//				addEventName(newName);
	//			}
				//	can't be many
				addVariableName(notification.getNewStringValue());
				break;
			}
			case Notification.REMOVE_MANY: {
				if (notification.getNewValue()==null && notification.getPosition()==-1){
					setElement(null);
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

} //OutputImpl
