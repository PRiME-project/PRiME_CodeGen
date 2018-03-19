package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class ParameterDirectionError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - No direction on parameter";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "No direction on parameter";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

}
