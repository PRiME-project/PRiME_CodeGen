/**
 * 
 */
package org.eventb.codegen.theory.translator.core;

import org.eventb.core.ILabeledElement;
import org.eventb.core.ITraceableElement;
import org.eventb.theory.core.ISCFormulaElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;

/**
 * @author renatosilva
 *
 */
public interface ISCTranslatorRuleElement extends ISCFormulaElement, ITraceableElement, ISCTranslationElement, ILabeledElement{
	
	IInternalElementType<ISCTranslatorRuleElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".scTranslatorRuleElement");
}
