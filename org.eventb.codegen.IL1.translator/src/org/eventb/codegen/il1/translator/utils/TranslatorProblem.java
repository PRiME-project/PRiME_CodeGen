/**
 *
 */
package org.eventb.codegen.il1.translator.utils;

import java.text.MessageFormat;

import org.eclipse.core.resources.IMarker;
import org.eventb.codegen.il1.translator.IL1TranslatorPlugin;
import org.rodinp.core.IRodinProblem;

/**
 * @author renatosilva
 *
 */
public enum TranslatorProblem implements IRodinProblem {
	TraslationNotFound(IMarker.SEVERITY_WARNING, Messages.userTranslationNotFound),
	InitialValueNotFound(IMarker.SEVERITY_ERROR, Messages.userTranslationTypeInitialValueNotFound),
	InitialValueNotTranslated(IMarker.SEVERITY_WARNING, Messages.userTranslationTypeInitialValueNotTranslated),
	TranslationTypeNotFound(IMarker.SEVERITY_ERROR, Messages.userTranslationTypeNotFound),
	;

	private final String errorCode;

	private final String message;

	private final int severity;

	private TranslatorProblem(int severity,String message) {
		this.message = message;
		this.severity = severity;
		this.errorCode = IL1TranslatorPlugin.PLUGIN_ID + "." + name();
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
