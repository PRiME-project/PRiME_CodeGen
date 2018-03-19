package org.eventb.codegen.ui.validation.errors;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class PossiblyIncorrectTypingWarning implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Typing flag possibly set incorrectly due to missing " + ELEMENT_OF + " symbol";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Typing flag possibly set incorrectly due to missing " + ELEMENT_OF + " symbol";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_WARNING;
	}

}
