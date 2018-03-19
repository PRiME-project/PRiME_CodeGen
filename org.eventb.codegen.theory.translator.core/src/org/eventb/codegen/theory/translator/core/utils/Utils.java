/**
 * 
 */
package org.eventb.codegen.theory.translator.core.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class Utils {
	
	public static void log(Throwable exc, String message) {
		if (exc instanceof RodinDBException) {
			final Throwable nestedExc = ((RodinDBException) exc).getException();
			if (nestedExc != null) {
				exc = nestedExc;
			}
		}
		if (message == null) {
			message = "Unknown context"; //$NON-NLS-1$
		}
		IStatus status = new Status(IStatus.ERROR, EventBTheoryTranslatorPlugin.PLUGIN_ID,IStatus.ERROR, message, exc);
		EventBTheoryTranslatorPlugin.getDefault().getLog().log(status);
	}

}
