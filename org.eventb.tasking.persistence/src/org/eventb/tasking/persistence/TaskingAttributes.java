package org.eventb.tasking.persistence;

import org.rodinp.core.IAttributeType;
import org.rodinp.core.RodinCore;

public final class TaskingAttributes {

//		public static final IAttributeType.String TASK_PRIORITY_ATTRIBUTE =
//			RodinCore.getStringAttrType(EventBPlugin.PLUGIN_ID + ".priority");

		public static IAttributeType.Integer TASK_PRIORITY_ATTRIBUTE = 
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".priority");
		
		public static final IAttributeType.Integer IMPLEMENTATION_TYPE_ATTRIBUTE =
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".impltype");
		
		public static final IAttributeType.Integer PARAMETERTYPE_ATTRIBUTE =
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".paramtype");
	
		public static final IAttributeType.Integer ADDRESSEDVARIABLE_BASE_ATTRIBUTE =
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".addressedvariablebase");
		
		public static final IAttributeType.String ADDRESSEDVARIABLE_ADDRESS_ATTRIBUTE =
			RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".addressedvariableaddress");
		
//	Replaced with SIMPLE_TASK_TYPE_ATTRIBUTE - kept for compatibility
		public static final IAttributeType.Integer OLD_SIMPLETASKTYPE_TYPE_ATTRIBUTE =
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".simpletasktypetype");
		
//	Replaced with PERIODIC_TASK_TYPE_ATTRIBUTE - kept for compatibility -- this is the period value
		public static final IAttributeType.Integer OLD_PERIODICTASKTYPE_TYPE_ATTRIBUTE =
			RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".periodictasktypetype");
		
		
		//	NEW TYPES
		public static final IAttributeType.String MACHINE_TYPE_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".machineTypeAttribute");
		public static final IAttributeType.String TASK_TYPE_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".taskTypeAttribute");
		public static final IAttributeType.String TASK_BODY_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".taskBodyAttribute");
		
		//	NEW TYPES THAT REPLACE EXISTING ONES
		public static final IAttributeType.String SIMPLE_TASK_TYPE_ATTRIBUTE = RodinCore.getStringAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".simpleTaskTypeAttribute");
		public static final IAttributeType.Integer PERIODIC_TASK_TYPE_ATTRIBUTE = RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".periodicTaskTypeAttribute");
}
