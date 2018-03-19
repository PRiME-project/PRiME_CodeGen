package org.eventb.compositecontrol.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.compositecontrol.persistence.CompositeControlAttributes;
import org.eventb.compositecontrol.persistence.IBranch;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class Branch extends CompositeControlCommon implements IBranch{

	
	public Branch(String name, IRodinElement parent) {
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
		return hasAttribute(BRANCH_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(BRANCH_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(BRANCH_ATTRIBUTE, string, monitor);
	}

	@Override
	public String getLabel() throws RodinDBException { 
		return getAttributeValue(CompositeControlAttributes.BRANCH_LABEL_ATTRIBUTE);
	}

	@Override
	public void setLabel(String label) throws RodinDBException {
		if (label == null)
			label = "";
		setAttributeValue(CompositeControlAttributes.BRANCH_LABEL_ATTRIBUTE, label, null);
	} 

}
