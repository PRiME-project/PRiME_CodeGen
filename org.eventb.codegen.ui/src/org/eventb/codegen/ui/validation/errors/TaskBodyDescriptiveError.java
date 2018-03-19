package org.eventb.codegen.ui.validation.errors;

import org.eclipse.core.resources.IMarker;
import org.rodinp.core.IRodinProblem;



public class TaskBodyDescriptiveError implements IRodinProblem {

	private String message = "";
	
	@Override
	public int getSeverity() {
		return IMarker.SEVERITY_ERROR;
	}

	@Override
	public String getErrorCode() {
		return "CODEGENError - TaskBody text invalid: " + message;
	}

	@Override
	public String getLocalizedMessage(Object[] args) {
		return message;
	}
	
	public void setMessage(String newMessage)
	{
		message = newMessage;
	}

}
