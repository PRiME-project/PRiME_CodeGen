package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class MultipleTaskingElementsError implements IRodinProblem {

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

	@Override
	public String getErrorCode() {
		return "CODEGENError - Too many tasking elements";
	}

	@Override
	public String getLocalizedMessage(Object[] args) {
		return "Too many tasking elements";
	}

}
