/**
 * 
 */
package org.eventb.codegen.theory.translator.core;

import org.eventb.core.ICommentedElement;
import org.eventb.core.ILabeledElement;
import org.eventb.theory.core.IFormulaElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;


/**
 * @author renatosilva
 *
 */
public interface ITranslatorRuleElement extends IFormulaElement, ILabeledElement, ITranslationElement, ICommentedElement {
	
	IInternalElementType<ITranslatorRuleElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorRuleElement");
}
