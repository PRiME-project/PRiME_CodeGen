package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.Plugin;
import org.eventb.core.IConfigurationElement;
import org.eventb.theory.core.ITheoryRoot;
import org.osgi.framework.BundleContext;
import org.rodinp.core.ElementChangedEvent;
import org.rodinp.core.IElementChangedListener;
import org.rodinp.core.IRodinElementDelta;
import org.rodinp.core.RodinDBException;

public class EventBTheoryTranslatorPlugin extends Plugin implements IElementChangedListener{

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eventb.codegen.theory.translator.core"; //$NON-NLS-1$

	/**
	 * The ID of the static checker configuration for translator (matches id in plugin.xml)
	 */
	public static final String CONFIGURATION = PLUGIN_ID + ".thyTranslator";

	public static final int SC_STARTING_INDEX = 0;

	// The shared instance
	private static EventBTheoryTranslatorPlugin plugin;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

//	/*
//	 * (non-Javadoc)
//	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
//	 */
//	public void start(BundleContext bundleContext) throws Exception {
//		EventBTheoryTranslatorPlugin.context = bundleContext;
//	}

//	/*
//	 * (non-Javadoc)
//	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
//	 */
//	public void stop(BundleContext bundleContext) throws Exception {
//		EventBTheoryTranslatorPlugin.context = null;
//	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		enableAssertions();
		org.rodinp.core.RodinCore.addElementChangedListener(this);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		org.rodinp.core.RodinCore.removeElementChangedListener(this);
	}

	/**
	 * Enable Java assertion checks for this plug-in.
	 */
	private void enableAssertions() {
		getClass().getClassLoader().setDefaultAssertionStatus(true);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EventBTheoryTranslatorPlugin getDefault() {
		return plugin;
	}

	/**
	 * look for changes to Contexts with Records and add Records configuration
	 */
	public void elementChanged(ElementChangedEvent event) {
		try {
			updateReaction(event.getDelta());
		} catch (RodinDBException e) {
			e.printStackTrace();
		}
	}

	private void updateReaction(IRodinElementDelta dl) throws RodinDBException {
		try {
			if (dl.getElement() instanceof ITranslatorElement) {
				ITheoryRoot root = (ITheoryRoot) ((ITranslatorElement) dl.getElement()).getRoot();
				IConfigurationElement conf = (IConfigurationElement) root.getRodinFile().getRoot();
				String config = conf.getConfiguration();
				if (!config.equals(CONFIGURATION)) {
					config = CONFIGURATION; //REMOVE THIS LINE FOR NEXT RODIN RELEASE
					conf.setConfiguration(config, null);
				}
			} else {
				if (dl.getAffectedChildren() != null) {
					for (IRodinElementDelta d : dl.getAffectedChildren()) {
						updateReaction(d);
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
