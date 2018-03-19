package org.eventb.codegen.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eventb.codegen.ui.validation.TaskBodyValidatorListener;
import org.osgi.framework.BundleContext;
import org.rodinp.core.RodinCore;

/**
 * The activator class controls the plug-in life cycle
 */
public class EventBCodeGenerationUI extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eventb.codegen.ui"; //$NON-NLS-1$

	// The shared instance
	private static EventBCodeGenerationUI plugin;
	
	/**
	 * The constructor
	 */
	public EventBCodeGenerationUI() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		setCGConfig();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EventBCodeGenerationUI getDefault() {
		return plugin;
	}
	
	// From Expanding the Static Checker tutorial, to register the static checking module
	public static void setCGConfig()
	{
		RodinCore.addElementChangedListener(new TaskBodyValidatorListener());
	}

}
