/**
 *
 */
package org.eventb.codegen.theory.translator.ui.eventbeditor.html;

import static org.eventb.codegen.theory.translator.internal.ui.Messages.TRANSLATOR_FORMULA_DEFAULT;
import static org.eventb.codegen.theory.translator.internal.ui.Messages.TRANSLATOR_LABEL_DEFAULT;
import static org.eventb.codegen.theory.translator.internal.ui.Messages.TRANSLATOR_OUTPUT_DEFAULT;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.getHTMLBeginForCSSClass;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.getHTMLEndForCSSClass;
import static org.eventb.ui.prettyprint.PrettyPrintUtils.wrapString;

import org.eventb.codegen.theory.translator.core.ITranslatorTypeRuleElement;
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
public class TranslatorTypeRuleElementPrettyPrinter extends
		DefaultPrettyPrinter implements IElementPrettyPrinter {

	private static final String TRANSLATOR_LABEL = "eventLabel";
	private static final String TRANSLATOR_LABEL_SEPARATOR_BEGIN = null;
	private static final String TRANSLATOR_LABEL_SEPARATOR_END = ":";

	private static final String TRANSLATOR_TYPE_FORMULA = "componentName";
	private static final String TRANSLATOR_TYPE_FORMULA_SEPARATOR_BEGIN = null;
	private static final String TRANSLATOR_TYPE_FORMULA_SEPARATOR_END = null;

	private static final String TRANSLATOR_OUTPUT_SEPARATOR = "\u27FE";//"OUTPUTS";
	private static final String TRANSLATOR_OUTPUT_SEPARATOR_CSS_CLASS = "level1";
	private static final String TRANSLATOR_OUTPUT = "componentName";
	private static final String TRANSLATOR_OUTPUT_SEPARATOR_BEGIN = null;
	private static final String TRANSLATOR_OUTPUT_SEPARATOR_END = null;

	private static final String ONE_SPACE = "&nbsp";


	@Override
	public void prettyPrint(IInternalElement elt, IInternalElement parent,	IPrettyPrintStream ps) {
		if (elt instanceof ITranslatorTypeRuleElement) {
			ITranslatorTypeRuleElement translation = (ITranslatorTypeRuleElement)elt;
			try {
				if(translation.hasLabel() && !translation.getLabel().equals(""))
					appendLabel(ps, wrapString(translation.getLabel()));
				else appendLabel(ps, wrapString(TRANSLATOR_LABEL_DEFAULT));
				if(translation.hasTypeFormula() && !translation.getTypeFormula().equals(""))
					appendFormula(ps,wrapString(translation.getTypeFormula()));
				else appendFormula(ps,wrapString(TRANSLATOR_FORMULA_DEFAULT));
				if(translation.hasTranslation() && !translation.getTranslation().equals(""))
					appendOutput(ps,wrapString(translation.getTranslation()));
				else appendOutput(ps,wrapString(TRANSLATOR_OUTPUT_DEFAULT));
			} catch (RodinDBException e) {
				EventBEditorUtils.debugAndLogError(e,
						"Cannot get details for translation " + translation.getElementName());
			}
		}
	}

	private static void appendLabel(IPrettyPrintStream ps, String label) {
	    ps.appendString(label, //
	      getHTMLBeginForCSSClass(TRANSLATOR_LABEL, //
	                              HorizontalAlignment.LEFT, //
	                              VerticalAlignement.MIDDLE),//
	      getHTMLEndForCSSClass(TRANSLATOR_LABEL, //
	                              HorizontalAlignment.LEFT, //
	                              VerticalAlignement.MIDDLE),//
	                              TRANSLATOR_LABEL_SEPARATOR_BEGIN, //
	                              TRANSLATOR_LABEL_SEPARATOR_END);
	}

	private static void appendFormula(IPrettyPrintStream ps, String formula) {
		ps.appendString(formula, //
				getHTMLBeginForCSSClass(TRANSLATOR_TYPE_FORMULA, //
						HorizontalAlignment.LEFT, //
						VerticalAlignement.MIDDLE),//
						getHTMLEndForCSSClass(TRANSLATOR_TYPE_FORMULA, //
								HorizontalAlignment.LEFT, //
								VerticalAlignement.MIDDLE),//
								TRANSLATOR_TYPE_FORMULA_SEPARATOR_BEGIN, //
								TRANSLATOR_TYPE_FORMULA_SEPARATOR_END);
	}

	private static void appendOutput(IPrettyPrintStream ps, String output) {
		ps.appendString(ONE_SPACE + TRANSLATOR_OUTPUT_SEPARATOR + ONE_SPACE, //
				getHTMLBeginForCSSClass(TRANSLATOR_OUTPUT_SEPARATOR_CSS_CLASS, //
						HorizontalAlignment.LEFT, //
						VerticalAlignement.MIDDLE),//
						getHTMLEndForCSSClass(TRANSLATOR_OUTPUT_SEPARATOR_CSS_CLASS, //
								HorizontalAlignment.LEFT, //
								VerticalAlignement.MIDDLE),//
								TRANSLATOR_OUTPUT_SEPARATOR_BEGIN, //
								TRANSLATOR_OUTPUT_SEPARATOR_END);

		ps.appendString(output, //
				getHTMLBeginForCSSClass(TRANSLATOR_OUTPUT, //
						HorizontalAlignment.LEFT, //
						VerticalAlignement.MIDDLE),//
						getHTMLEndForCSSClass(TRANSLATOR_OUTPUT, //
								HorizontalAlignment.LEFT, //
								VerticalAlignement.MIDDLE),//
								TRANSLATOR_OUTPUT_SEPARATOR_BEGIN, //
								TRANSLATOR_OUTPUT_SEPARATOR_END);
	}

}
