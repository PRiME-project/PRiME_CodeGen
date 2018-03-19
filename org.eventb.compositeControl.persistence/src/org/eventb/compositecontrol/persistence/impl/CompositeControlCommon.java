package org.eventb.compositecontrol.persistence.impl;

import org.eventb.compositecontrol.persistence.CompositeControlAttributes;
import org.eventb.compositecontrol.persistence.ICompositeControlCommon;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;
import org.rodinp.core.basis.InternalElement;

public abstract class CompositeControlCommon extends InternalElement implements ICompositeControlCommon{

	public CompositeControlCommon(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public int getFeatureID() throws RodinDBException {
		return getAttributeValue(CompositeControlAttributes.FEATURE_ID_ATTRIBUTE);
	}

	@Override
	public void setFeatureID(int feature) throws RodinDBException {
		setAttributeValue(CompositeControlAttributes.FEATURE_ID_ATTRIBUTE, feature, null);		
	}
}
