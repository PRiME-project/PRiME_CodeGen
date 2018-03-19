package org.eventb.compositecontrol.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.compositecontrol.persistence.CompositeControlAttributes;
import org.eventb.compositecontrol.persistence.IEventWrapper;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class EventWrapper extends CompositeControlCommon implements IEventWrapper{

	
	public EventWrapper(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ELEMENT_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(EVENT_WRAPPER_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(EVENT_WRAPPER_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(EVENT_WRAPPER_ATTRIBUTE, string, monitor);
	}

	@Override
	public String getLabel() throws RodinDBException { 
		return getAttributeValue(CompositeControlAttributes.EVENT_WRAPPER_LABEL_ATTRIBUTE);
	}

	@Override
	public void setLabel(String label) throws RodinDBException {
		if (label == null)
			label = new String("");	//	sometimes event wrapper sends a null label and kills everything
		setAttributeValue(CompositeControlAttributes.EVENT_WRAPPER_LABEL_ATTRIBUTE, label, null);
	} 
	
	@Override
	public String getEventName() throws RodinDBException { 
		return getAttributeValue(CompositeControlAttributes.EVENT_WRAPPER_EVENTNAME_ATTRIBUTE);
	}

	@Override
	public void setEventName(String label) throws RodinDBException {
		if (label == null)
			label = new String("");	//	sometimes event wrapper sends a null label and kills everything
		setAttributeValue(CompositeControlAttributes.EVENT_WRAPPER_EVENTNAME_ATTRIBUTE, label, null);
	} 
}
