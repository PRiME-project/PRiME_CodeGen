/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TARGET_LANGUAGE_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ISCTranslatorElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorRuleElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorTypeRuleElement;
import org.eventb.theory.core.ISCMetavariable;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class SCTranslatorElement extends TranslatorRuleElement implements ISCTranslatorElement {

	/**
	 * @param name
	 * @param parent
	 */
	public SCTranslatorElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ISCTranslatorElement.ELEMENT_TYPE;
	}

	@Override
	public ISCMetavariable getSCMetavariable(String name) {
		return getInternalElement(ISCMetavariable.ELEMENT_TYPE, name);
	}

	@Override
	public ISCMetavariable[] getSCMetavariables() throws RodinDBException {
		return getChildrenOfType(ISCMetavariable.ELEMENT_TYPE);
	}

	@Override
	public ISCTranslatorRuleElement getSCTranslatorRule(String name) {
		return getInternalElement(ISCTranslatorRuleElement.ELEMENT_TYPE, name);
	}

	@Override
	public ISCTranslatorRuleElement[] getSCTranslatorRules() throws RodinDBException {
		return getChildrenOfType(ISCTranslatorRuleElement.ELEMENT_TYPE);
	}

	@Override
	public String getSCTargetLanguage() throws RodinDBException {
		return getAttributeValue(TARGET_LANGUAGE_ATTRIBUTE);
	}

	@Override
	public void setSCTargetLanguage(String targetLanguage,
			IProgressMonitor monitor) throws RodinDBException {
		setAttributeValue(TARGET_LANGUAGE_ATTRIBUTE, targetLanguage, monitor);
	}

	@Override
	public ISCTranslatorTypeRuleElement getSCTranslatorTypeRule(String name) {
		return getInternalElement(ISCTranslatorTypeRuleElement.ELEMENT_TYPE, name);
	}

	@Override
	public ISCTranslatorTypeRuleElement[] getSCTranslatorTypeRules() throws RodinDBException {
		return getChildrenOfType(ISCTranslatorTypeRuleElement.ELEMENT_TYPE);
	}
}
