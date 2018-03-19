package org.eventb.codegen.il1.translator;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class IL1TranslatorPlugin extends AbstractUIPlugin {

	private static BundleContext context;

	public static final String METAVARIABLE_INIT_SUFFIX = "0";

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eventb.codegen.IL1.translator";

	// The shared instance
	private static IL1TranslatorPlugin plugin;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		IL1TranslatorPlugin.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		IL1TranslatorPlugin.context = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static IL1TranslatorPlugin getDefault() {
		return plugin;
	}

}
