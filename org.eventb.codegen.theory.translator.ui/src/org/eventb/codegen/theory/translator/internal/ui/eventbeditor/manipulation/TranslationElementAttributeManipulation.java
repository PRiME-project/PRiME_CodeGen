/**
 * 
 */
package org.eventb.codegen.theory.translator.internal.ui.eventbeditor.manipulation;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TRANSLATION_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ITranslationElement;
import org.eventb.internal.ui.UIUtils;
import org.eventb.internal.ui.eventbeditor.manipulation.AbstractAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslationElementAttributeManipulation extends AbstractAttributeManipulation {
	
	private final String DEFAULT_VALUE = "";

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setDefaultValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		asTranslationElement(element).setTranslation(DEFAULT_VALUE, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#hasValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTranslationElement(element).hasTranslation();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTranslationElement(element).getTranslation();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setValue(org.rodinp.core.IRodinElement, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {
		asTranslationElement(element).setTranslation(value, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#removeAttribute(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		asTranslationElement(element).removeAttribute(TRANSLATION_ATTRIBUTE, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getPossibleValues(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		// Not applicable for translation Element.
		logCantGetPossibleValues(TRANSLATION_ATTRIBUTE);
		return null;
	}
	
	protected ITranslationElement asTranslationElement(IRodinElement element){
		assert element instanceof ITranslationElement;
		return (ITranslationElement) element;
	}

	protected void logCantGetPossibleValues(IAttributeType attribute) {
		UIUtils.log(null, "Cannot get the possible values for attribute "
				+ attribute);
	}
}
