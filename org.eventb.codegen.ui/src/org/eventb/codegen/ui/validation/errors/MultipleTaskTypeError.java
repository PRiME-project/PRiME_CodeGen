package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class MultipleTaskTypeError implements IRodinProblem {

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

	@Override
	public String getErrorCode() {
		return "CODEGENError - Too many task type elements";
	}

	@Override
	public String getLocalizedMessage(Object[] args) {
		return "Too many task type elements";
	}

}
