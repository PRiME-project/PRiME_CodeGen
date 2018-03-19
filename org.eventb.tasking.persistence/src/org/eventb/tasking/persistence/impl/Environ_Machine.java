package org.eventb.tasking.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.tasking.persistence.IEnviron_Machine;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;



public class Environ_Machine extends Task implements IEnviron_Machine {

	public Environ_Machine(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
//	@Override
//	public IInternalElementType<? extends IInternalElement> getElementType() {
//		return ELEMENT_TYPE;
//	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#hasSerialisedString()
	 */
	@Override
	public boolean hasSerialisedString() throws RodinDBException {
		return hasAttribute(ENVIRON_MACHINE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(ENVIRON_MACHINE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(ENVIRON_MACHINE_ATTRIBUTE, string, monitor);
	}

}
