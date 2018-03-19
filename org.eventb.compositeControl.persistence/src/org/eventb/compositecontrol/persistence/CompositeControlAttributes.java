package org.eventb.compositecontrol.persistence;

import org.rodinp.core.IAttributeType;
import org.rodinp.core.RodinCore;

public final class CompositeControlAttributes {

		public static final IAttributeType.String DO_LABEL_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".dolabel");
		
		public static final IAttributeType.String BRANCH_LABEL_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".branchlabel");
		
		public static final IAttributeType.String EVENT_WRAPPER_LABEL_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".eventwrapperlabel");
		
		public static final IAttributeType.String EVENT_WRAPPER_EVENTNAME_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".eventwrappereventname");
		
		public static final IAttributeType.String OUTPUT_TEXT_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".outputtext");
		
		public static final IAttributeType.String OUTPUT_VARIABLE_NAME_ATTRIBUTE =
			RodinCore.getStringAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".outputvariablename");
		
		public static final IAttributeType.Integer FEATURE_ID_ATTRIBUTE =
			RodinCore.getIntegerAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".compcontrolfeatureid");

//		public static IAttributeType.Integer TASK_PRIORITY_ATTRIBUTE = 
//			RodinCore.getIntegerAttrType(CompositeControlPersistencePlugin.PLUGIN_ID + ".priority");
		
		
}
