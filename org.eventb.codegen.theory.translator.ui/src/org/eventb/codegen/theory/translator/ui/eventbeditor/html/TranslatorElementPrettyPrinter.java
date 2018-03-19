/**
 * 
 */
package org.eventb.codegen.theory.translator.ui.eventbeditor.html;

import static org.eventb.codegen.theory.translator.internal.ui.Messages.TRANSLATOR_TARGET_LANGUAGE_DEFAULT;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.getHTMLBeginForCSSClass;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.getHTMLEndForCSSClass;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.wrapString;

import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.internal.ui.UIUtils;
import org.eventb.internal.ui.eventbeditor.EventBEditorUtils;
import org.eventb.ui.prettyprint.DefaultPrettyPrinter;
import org.eventb.ui.prettyprint.IElementPrettyPrinter;
import org.eventb.ui.prettyprint.IPrettyPrintStream;
import org.eventb.ui.prettyprint.PrettyPrintAlignments.HorizontalAlignment;
import org.eventb.ui.prettyprint.PrettyPrintAlignments.VerticalAlignement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorElementPrettyPrinter extends DefaultPrettyPrinter implements IElementPrettyPrinter {
	
	private static final String TRANSLATOR_TARGET_LANGUAGE = "masterKeyword";
	private static final String TRANSLATOR_TARGET_LANGUAGE_SEPARATOR_BEGIN = null;
	private static final String TRANSLATOR_TARGET_LANGUAGE_SEPARATOR_END =null;
	
	@Override
	public void prettyPrint(IInternalElement elt, IInternalElement parent,	IPrettyPrintStream ps) {
		if (elt instanceof ITranslatorElement) {
			ITranslatorElement translator = (ITranslatorElement)elt;
			try {
				if(translator.hasTargetLanguage() && !translator.getTargetLanguage().equals(UIUtils.COMBO_VALUE_UNDEFINED))
					appendTargetLanguage(ps,wrapString(translator.getTargetLanguage()));
				else appendTargetLanguage(ps,wrapString(TRANSLATOR_TARGET_LANGUAGE_DEFAULT));
			} catch (RodinDBException e) {
				EventBEditorUtils.debugAndLogError(e,
						"Cannot get details for translation " + translator.getElementName());
			}
		}
	}
	
	private static void appendTargetLanguage(IPrettyPrintStream ps, String targetLanguage) {
		ps.appendString(targetLanguage, //
				getHTMLBeginForCSSClass(TRANSLATOR_TARGET_LANGUAGE, //
						HorizontalAlignment.LEFT, //
						VerticalAlignement.MIDDLE),//
						getHTMLEndForCSSClass(TRANSLATOR_TARGET_LANGUAGE, //
								HorizontalAlignment.LEFT, //
								VerticalAlignement.MIDDLE),//
								TRANSLATOR_TARGET_LANGUAGE_SEPARATOR_BEGIN, //
								TRANSLATOR_TARGET_LANGUAGE_SEPARATOR_END);
		
	}

}
