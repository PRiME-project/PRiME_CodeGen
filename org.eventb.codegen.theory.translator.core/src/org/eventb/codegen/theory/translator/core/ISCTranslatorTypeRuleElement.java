/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eventb.core.ILabeledElement;
import org.eventb.core.ITraceableElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;

/**
 * @author renatosilva
 *
 */
public interface ISCTranslatorTypeRuleElement extends ITraceableElement,
		ISCTranslationElement, ILabeledElement, ISCTypeFormulaElement {

	IInternalElementType<ISCTranslatorTypeRuleElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".scTranslatorTypeRuleElement");
}
