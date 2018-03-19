package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class TypingError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Typing not set";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Typing not set";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

}
