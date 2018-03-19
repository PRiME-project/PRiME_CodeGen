/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import org.eventb.codegen.theory.translator.core.ITranslatorRuleElement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorRuleElement extends TranslatorTheoryElement implements ITranslatorRuleElement{

	public TranslatorRuleElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ITranslatorRuleElement.ELEMENT_TYPE;
	}

	@Override
	public String toString() {
		try {
			return "Label:"+getLabel()+
			       "\nFormula:"+getFormula()+
			       "\nOutput:"+getTranslation();
		} catch (RodinDBException e) {
			return super.toString();
		}
	}

}
