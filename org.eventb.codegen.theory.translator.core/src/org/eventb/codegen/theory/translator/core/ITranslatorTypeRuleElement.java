/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eventb.core.ICommentedElement;
import org.eventb.core.ILabeledElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;

/**
 * @author renatosilva
 *
 */
public interface ITranslatorTypeRuleElement extends ILabeledElement, ITypeFormulaElement,
		ICommentedElement, ITranslationElement {

	IInternalElementType<ITranslatorTypeRuleElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorTypeRuleElement");

}
