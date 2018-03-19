package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class InParameterDefinitionError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - In parameter defined without correct action";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "In parameter defined without correct action";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

}
