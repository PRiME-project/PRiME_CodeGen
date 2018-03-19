/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.FORMULA_ATTRIBUTE;
import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TRANSLATION_ATTRIBUTE;
import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ISCTranslationElement;
import org.eventb.codegen.theory.translator.core.ITranslationElement;
import org.eventb.codegen.theory.translator.core.ITypeFormulaElement;
import org.eventb.theory.core.TheoryElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public abstract class TranslatorTheoryElement extends TheoryElement implements
		ITranslationElement, ITypeFormulaElement, ISCTranslationElement {

	public TranslatorTheoryElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITypeFormulaElement#hasTypeFormula()
	 */
	@Override
	public boolean hasTypeFormula() throws RodinDBException {
		return hasAttribute(TYPE_FORMULA_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITypeFormulaElement#getTypeFormula()
	 */
	@Override
	public String getTypeFormula() throws RodinDBException {
		return getAttributeValue(TYPE_FORMULA_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.theory.translator.core.ITypeFormulaElement#setTypeFormula(java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setTypeFormula(String typeFormula, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(TYPE_FORMULA_ATTRIBUTE, typeFormula, monitor);
	}

	@Override
	public boolean hasTranslation() throws RodinDBException {
		return hasAttribute(TRANSLATION_ATTRIBUTE);
	}

	@Override
	public String getTranslation() throws RodinDBException {
		return getAttributeValue(TRANSLATION_ATTRIBUTE);
	}

	@Override
	public void setTranslation(String newTranslation, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(TRANSLATION_ATTRIBUTE, newTranslation, monitor);
	}

//	/* (non-Javadoc)
//	 * @see org.rodinp.core.basis.InternalElement#getElementType()
//	 */
//	@Override
//	public IInternalElementType<? extends IInternalElement> getElementType() {
//		return null;
//	}

	@Override
	public String getFormula() throws RodinDBException {
		return getAttributeValue(FORMULA_ATTRIBUTE);
	}

	@Override
	public boolean hasFormula() throws RodinDBException {
		return hasAttribute(FORMULA_ATTRIBUTE);
	}

	@Override
	public void setFormula(String formula, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(FORMULA_ATTRIBUTE, formula, monitor);
	}

	@Override
	public boolean hasSCTranslation() throws RodinDBException {
		return hasAttribute(TRANSLATION_ATTRIBUTE);
	}

	@Override
	public String getSCTranslation() throws RodinDBException {
		return getAttributeValue(TRANSLATION_ATTRIBUTE);
	}

	@Override
	public void setSCTranslation(String newTranslation, IProgressMonitor monitor)
			throws RodinDBException {
		setAttributeValue(TRANSLATION_ATTRIBUTE, newTranslation, monitor);
	}

}
