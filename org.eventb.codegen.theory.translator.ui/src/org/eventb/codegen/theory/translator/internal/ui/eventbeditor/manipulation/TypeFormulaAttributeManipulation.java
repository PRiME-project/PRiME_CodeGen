/**
 *
 */
package org.eventb.codegen.theory.translator.internal.ui.eventbeditor.manipulation;

import static org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ITypeFormulaElement;
import org.eventb.internal.ui.UIUtils;
import org.eventb.internal.ui.eventbeditor.manipulation.AbstractAttributeManipulation;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TypeFormulaAttributeManipulation extends
		AbstractAttributeManipulation implements IAttributeManipulation {


	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setDefaultValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		asTypeFormula(element).setTypeFormula("", monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#hasValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTypeFormula(element).hasTypeFormula();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getValue(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return asTypeFormula(element).getTypeFormula();
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#setValue(org.rodinp.core.IRodinElement, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void setValue(IRodinElement element, String newValue,
			IProgressMonitor monitor) throws RodinDBException {
		asTypeFormula(element).setTypeFormula(newValue, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#removeAttribute(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		logCantRemove(TYPE_FORMULA_ATTRIBUTE);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.ui.eventbeditor.manipulation.IAttributeManipulation#getPossibleValues(org.rodinp.core.IRodinElement, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		logCantGetPossibleValues(TYPE_FORMULA_ATTRIBUTE);
		return null;
	}

	private ITypeFormulaElement asTypeFormula(IRodinElement element) {
		assert element instanceof ITypeFormulaElement;
		return (ITypeFormulaElement) element;
	}

	protected void logCantGetPossibleValues(IAttributeType attribute) {
		UIUtils.log(null, "Cannot get the possible values for attribute "
				+ attribute);
	}

}
