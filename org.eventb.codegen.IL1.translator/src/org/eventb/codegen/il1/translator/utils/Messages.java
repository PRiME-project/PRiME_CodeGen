package org.eventb.codegen.il1.translator.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eventb.codegen.il1.translator.utils.messages"; //$NON-NLS-1$
	public static String userTranslationNotFound;
	public static String userTranslationTypeNotFound;
	public static String userTranslationTypeInitialValueNotFound;
	public static String userTranslationTypeInitialValueNotTranslated;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
