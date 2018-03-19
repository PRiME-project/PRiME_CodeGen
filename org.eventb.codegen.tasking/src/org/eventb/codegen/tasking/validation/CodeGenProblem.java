/**
 * 
 */
package org.eventb.codegen.tasking.validation;

import java.text.MessageFormat;

import org.eclipse.core.resources.IMarker;
import org.eventb.codegen.tasking.CodeGenTasking;

/**
 * @author renatosilva
 *
 */
public enum CodeGenProblem implements ICodeGenerationProblem {
	NoTaskingMachineError(IMarker.SEVERITY_ERROR, Messages.scuser_NoTaskingMachineError),
	MultipleTaskingTypeError(IMarker.SEVERITY_ERROR, Messages.scuser_MultipleTaskingTypeError),
	NoTaskBodyError(IMarker.SEVERITY_WARNING, Messages.scuser_NoTaskBodyError),
	NoTaskTypeError(IMarker.SEVERITY_ERROR, Messages.scuser_NoTaskTypeError),
	NoPeriodTaskTypeError(IMarker.SEVERITY_ERROR, Messages.scuser_NoPeriodTaskDefinedError),
	NoSimpleTaskTypeError(IMarker.SEVERITY_ERROR, Messages.scuser_NoSimpleTaskDefinedError),
	;
	
	private final String errorCode;
	
	private final String message;
	
	private final int severity;
	
	private CodeGenProblem(int severity, String message) {
		this.severity = severity;
		this.message = message;
		this.errorCode = CodeGenTasking.PLUGIN_ID + "." + name();
	}

	@Override
	public int getSeverity() {
		return severity;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getLocalizedMessage(Object[] args) {
		return MessageFormat.format(message, args);
	}

}
