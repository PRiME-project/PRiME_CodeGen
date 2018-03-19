package org.eventb.codegen.tasking.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eventb.codegen.tasking.CodeGenTasking;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = CodeGenTasking.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.flattenPref, true);
		store.setDefault(PreferenceConstants.javaInterfacePref, false);
	}

}
