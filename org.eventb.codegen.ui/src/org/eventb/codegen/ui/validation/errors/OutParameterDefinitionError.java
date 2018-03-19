package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class OutParameterDefinitionError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Out parameter defined without correct guard condition";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Out parameter defined without correct guard condition";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

}
