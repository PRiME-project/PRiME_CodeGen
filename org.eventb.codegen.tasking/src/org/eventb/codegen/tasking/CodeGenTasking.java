package org.eventb.codegen.tasking;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.RodinCore;

public class CodeGenTasking extends AbstractUIPlugin implements BundleActivator {

	private static BundleContext context;

	// The shared instance
	private static CodeGenTasking plugin;

	/**
	 * The plug-in identifier of the Rodin core support (value
	 * <code>"org.rodinp.core"</code>).
	 */
	//LOCAL ATTRIBUTES
	public static final String PLUGIN_ID = "org.eventb.codegen.tasking"; //$NON-NLS-1$
	public static IAttributeType.Boolean FLATTENED_ATTRIBUTE = RodinCore
			.getBooleanAttrType(PLUGIN_ID + ".flattened");
	
	//ATTRIBUTES OF OTHER PLUG_INS, THAT NEED REFACTORING TO MAKE ACCESSIBLE
	// due to cyclic dependencies
	public static final String TYPING_ATTRIBUTE_IDENT = "org.eventb.codegen.ui.typingAttribute";
	public static final String PARAM_DIR_IDENT = "org.eventb.codegen.ui.parameterTypeAttribute";
	public static final String BRANCHING_ATTRIBUTE_IDENT = "org.eventb.codegen.ui.branchingAttribute";
	public static final String TASKING_CONTEXT_ATTRIBUTE_IDENT = "org.eventb.codegen.ui.taskingContextAttribute";
	
	public static IAttributeType.String TASKING_CONTEXT_ATTRIBUTE = RodinCore
			.getStringAttrType(TASKING_CONTEXT_ATTRIBUTE_IDENT);
	public static IAttributeType.String TYPING_ATTRIBUTE = RodinCore
			.getStringAttrType(TYPING_ATTRIBUTE_IDENT);
	public static IAttributeType.String PARAM_DIR_ATTRIBUTE = RodinCore
			.getStringAttrType(PARAM_DIR_IDENT);
	public static IAttributeType.String BRANCHING_ATTRIBUTE = RodinCore
			.getStringAttrType(BRANCHING_ATTRIBUTE_IDENT);

	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		CodeGenTasking.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		CodeGenTasking.context = null;
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static CodeGenTasking getDefault() {
		return plugin;
	}

}
