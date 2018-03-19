package org.eventb.compositecontrol.persistence;

import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public interface ICompositeControlCommon extends IInternalElement {

	public static IAttributeType.String FEATURE_ID_ATTRIBUTE = RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".compositecontrol");
		
	//	Used to determine what feature ID to use in synchronisation
	int getFeatureID() throws RodinDBException;
	void setFeatureID(int feature) throws RodinDBException;
}
