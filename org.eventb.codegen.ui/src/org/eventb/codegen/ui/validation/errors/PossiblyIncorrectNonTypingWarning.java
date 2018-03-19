package org.eventb.codegen.ui.validation.errors;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class PossiblyIncorrectNonTypingWarning implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Non-typing flag possibly set incorrectly due to " + ELEMENT_OF + " symbol";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Non-typing flag possibly set incorrectly due to " + ELEMENT_OF + " symbol";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_WARNING;
	}

}
