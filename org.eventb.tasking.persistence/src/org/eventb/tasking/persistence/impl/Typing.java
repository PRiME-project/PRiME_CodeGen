package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.ITyping;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;


@Deprecated
/**
 * Should no longer be used. Typing is set by adding the appropriate attribute in the 
 * parent element in the Rodin database entry.
 * @author Chris
 *
 */
public class Typing extends InternalElement implements ITyping{
	
	public Typing(String name, IRodinElement parent) {
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
		return hasAttribute(TYPINGTYPE_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(TYPINGTYPE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(TYPINGTYPE_ATTRIBUTE, string, monitor);
	}
	
	
	
//	
//
//	@Override
//	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
//			throws RodinDBException {
//
//		if (element instanceof Invariant)
//		{
//			((Invariant) element).setAttributeValue(TYPINGTYPE_ATTRIBUTE, "NonTyping", monitor);
//		}
//		else if (element instanceof Guard)
//		{
//			((Guard) element).setAttributeValue(TYPINGTYPE_ATTRIBUTE, "NonTyping", monitor);
//		}
//	}
//
//	@Override
//	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
//			throws RodinDBException {
//		
//		if (element instanceof Invariant)
//		{
//			return ((Invariant) element).hasAttribute(TYPINGTYPE_ATTRIBUTE);
//		}
//		else if (element instanceof Guard)
//		{
//			return ((Guard) element).hasAttribute(TYPINGTYPE_ATTRIBUTE);
//		}
//		
//		return false;
//	}
//
//	@Override
//	public String getValue(IRodinElement element, IProgressMonitor monitor)
//			throws RodinDBException {
//		if (element instanceof Invariant)
//		{
//			return ((Invariant) element).getAttributeValue(TYPINGTYPE_ATTRIBUTE);
//		}
//		else if (element instanceof Guard)
//		{
//			return ((Guard) element).getAttributeValue(TYPINGTYPE_ATTRIBUTE);
//		}
//		return null;
//	}
//
//	@Override
//	public void setValue(IRodinElement element, String value,
//			IProgressMonitor monitor) throws RodinDBException {
//
//		if (element instanceof Invariant)
//		{
//			((Invariant) element).setAttributeValue(TYPINGTYPE_ATTRIBUTE, value, monitor);
//		}
//		else if (element instanceof Guard)
//		{
//			((Guard) element).setAttributeValue(TYPINGTYPE_ATTRIBUTE, value, monitor);
//		}		
//	}
//
//	@Override
//	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
//			throws RodinDBException {
//		
//		if (element instanceof Invariant)
//		{
//			((Invariant) element).removeAttribute(TYPINGTYPE_ATTRIBUTE, monitor);
//		}
//		else if (element instanceof Guard)
//		{
//			((Guard) element).removeAttribute(TYPINGTYPE_ATTRIBUTE, monitor);
//		}
//		
//	}
//
//	@Override
//	public String[] getPossibleValues(IRodinElement element,
//			IProgressMonitor monitor) {
//		String [] values = {"NonTyping","Typing"};
//		return values;
//	}
}
