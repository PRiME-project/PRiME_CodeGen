/**
 * 
 */
package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

/**
 * @author Chris
 *
 */
public class MultipleTypingError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Multiple typing set for this left hand side";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Multiple typing set for this left hand side";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}
}
