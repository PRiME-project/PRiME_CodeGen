/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import org.eventb.codegen.theory.translator.core.ITranslatorTypeRuleElement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorTypeRuleElement extends TranslatorTheoryElement implements ITranslatorTypeRuleElement {

	/**
	 * @param name
	 * @param parent
	 */
	public TranslatorTypeRuleElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ITranslatorTypeRuleElement.ELEMENT_TYPE;
	}

	@Override
	public String toString() {
		try {
			return "Label:"+getLabel()+
			       "\nTypeFormula:"+getTypeFormula()+
			       "\nOutput:"+getTranslation();
		} catch (RodinDBException e) {
			return super.toString();
		}
	}

}
