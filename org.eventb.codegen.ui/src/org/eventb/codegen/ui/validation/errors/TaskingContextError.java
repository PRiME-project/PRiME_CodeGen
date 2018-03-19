package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;

public class TaskingContextError implements IRodinProblem {

	@Override
	public String getErrorCode() {
		return "CODEGENError - Context is not a Tasking Context";
	}

	@Override
	public String getLocalizedMessage(Object[] arg0) {
		return "Context is not a Tasking Context";
	}

	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

}
