/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TARGET_LANGUAGE_ATTRIBUTE;

import java.util.Arrays;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.codegen.theory.translator.core.ITranslatorRuleElement;
import org.eventb.codegen.theory.translator.core.ITranslatorTypeRuleElement;
import org.eventb.theory.core.IMetavariable;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorElement extends TranslatorRuleElement implements ITranslatorElement {

	/**
	 * @param name
	 * @param parent
	 */
	public TranslatorElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ITranslatorElement.ELEMENT_TYPE;
	}

	@Override
	public IMetavariable getMetavariable(String name) {
		return getInternalElement(IMetavariable.ELEMENT_TYPE, name);
	}

	@Override
	public IMetavariable[] getMetavariables() throws RodinDBException {
		return getChildrenOfType(IMetavariable.ELEMENT_TYPE);
	}

	@Override
	public ITranslatorRuleElement getTranslatorRule(String name) {
		return getInternalElement(ITranslatorRuleElement.ELEMENT_TYPE, name);
	}

	@Override
	public ITranslatorRuleElement[] getTranslatorRules() throws RodinDBException {
		return getChildrenOfType(ITranslatorRuleElement.ELEMENT_TYPE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITargetLanguageElement#hasTargetLanguage()
	 */
	@Override
	public boolean hasTargetLanguage() throws RodinDBException {
		return hasAttribute(TARGET_LANGUAGE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITargetLanguageElement#getTargetLanguage()
	 */
	@Override
	public String getTargetLanguage() throws RodinDBException {
		return getAttributeValue(TARGET_LANGUAGE_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITargetLanguageElement#setTargetLanguage(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setTargetLanguage(String target, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(TARGET_LANGUAGE_ATTRIBUTE, target, monitor);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		try {
			return "TranslatorElement [getMetavariables()="
					+ Arrays.toString(getMetavariables())
					+ ", getTranslatorRules()="
					+ Arrays.toString(getTranslatorRules())
					+ ", getTargetLanguage()=" + getTargetLanguage()
					+ ", getTranslatorTypeRules()="
					+ Arrays.toString(getTranslatorTypeRules()) + "]";
		} catch (RodinDBException e) {
			return "";
		}
	}

	@Override
	public ITranslatorTypeRuleElement[] getTranslatorTypeRules() throws RodinDBException{
		return getChildrenOfType(ITranslatorTypeRuleElement.ELEMENT_TYPE);
	}



}
