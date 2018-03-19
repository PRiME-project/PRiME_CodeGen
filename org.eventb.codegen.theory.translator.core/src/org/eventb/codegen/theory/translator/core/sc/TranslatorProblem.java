/**
 *
 */
package org.eventb.codegen.theory.translator.core.sc;

import java.text.MessageFormat;

import org.eclipse.core.resources.IMarker;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.codegen.theory.translator.core.utils.Messages;
import org.rodinp.core.IRodinProblem;

/**
 * @author renatosilva
 *
 */
public enum TranslatorProblem implements IRodinProblem {
	UndefinedLabelError(IMarker.SEVERITY_ERROR, Messages.scuser_UndefinedLabel),
	TranslatorLabelConflictError(IMarker.SEVERITY_ERROR, Messages.scuser_AmbigiousLabel),
	TranslatorLabelConflictWarning(IMarker.SEVERITY_WARNING, Messages.scuser_AmbigiousLabel),
	UndefinedTranslationError(IMarker.SEVERITY_ERROR, Messages.scuser_UndefinedTranslation),
	UndefinedTargetError(IMarker.SEVERITY_ERROR, Messages.scuser_UndefinedTargetLanguage),
	UndefinedFormulaError(IMarker.SEVERITY_ERROR, Messages.scuser_UndefinedFormula),
	UnparseableFormulaError(IMarker.SEVERITY_ERROR, Messages.scuser_UnparsableFormula),
	InvalidMetavariableIdentifier(IMarker.SEVERITY_ERROR, Messages.scuser_InvalidMetavariableIdentifier),
	TypeAttrMissingForOpArgError(IMarker.SEVERITY_ERROR, Messages.scuser_TypeAttrMissingForOpArgError)
	;


	private final String errorCode;

	private final String message;

	private final int severity;

	private TranslatorProblem(int severity,String message) {
		this.message = message;
		this.severity = severity;
		this.errorCode = EventBTheoryTranslatorPlugin.PLUGIN_ID + "." + name();
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
