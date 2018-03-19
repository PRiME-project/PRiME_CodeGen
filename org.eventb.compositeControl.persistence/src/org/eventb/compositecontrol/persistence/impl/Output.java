package org.eventb.compositecontrol.persistence.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.compositecontrol.persistence.CompositeControlAttributes;
import org.eventb.compositecontrol.persistence.IOutput;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

public class Output extends CompositeControlCommon implements IOutput{

	
	public Output(String name, IRodinElement parent) {
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
		return hasAttribute(OUTPUT_ATTRIBUTE);
	} 

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#getSerialisedString()
	 */
	@Override
	public String getSerialisedString() throws RodinDBException {
		return getAttributeValue(OUTPUT_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.tasking.persistence.IAutoTask_Machine#setSerialisedString(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setSerialisedString(String string, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(OUTPUT_ATTRIBUTE, string, monitor);
	}

	@Override
	public String getText() throws RodinDBException { 
		return getAttributeValue(CompositeControlAttributes.OUTPUT_TEXT_ATTRIBUTE);
	}

	@Override
	public void setText(String label) throws RodinDBException {
		if (label == null)
			label = new String("");	//	sometimes event wrapper sends a null label and kills everything
		setAttributeValue(CompositeControlAttributes.OUTPUT_TEXT_ATTRIBUTE, label, null);
	}

	@Override
	public String getVariableName() throws RodinDBException {
		return getAttributeValue(CompositeControlAttributes.OUTPUT_VARIABLE_NAME_ATTRIBUTE);
	}

	@Override
	public void setVariableName(String name) throws RodinDBException {
		if (name == null)
			name = new String("");	//	sometimes event wrapper sends a null label and kills everything
		setAttributeValue(CompositeControlAttributes.OUTPUT_VARIABLE_NAME_ATTRIBUTE, name, null);		
	} 

}
