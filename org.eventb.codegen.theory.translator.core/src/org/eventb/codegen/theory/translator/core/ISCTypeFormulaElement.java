/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.ITypeEnvironment;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public interface ISCTypeFormulaElement extends IInternalElement {

	/**
	 * Returns whether the formula attribute is set.
	 * @return whether the formula attribute is set
	 * @throws RodinDBException
	 */
	boolean hasSCTypeFormula() throws RodinDBException;

	/**
	 * Returns the SC formula associated with this element.
	 * @param ff the formula factory
	 * @param typeEnvironment the type environment
	 * @return the SC formula
	 * @throws RodinDBException
	 */
	Formula<?> getSCTypeFormula(FormulaFactory ff, ITypeEnvironment typeEnvironment) throws RodinDBException;

	/**
	 * Sets the formula attribute of this element to the given formula.
	 * @param formula the SC formula
	 * @param monitor the progress monitor
	 * @throws RodinDBException
	 */
	void setSCTypeFormula(Formula<?> formula, IProgressMonitor monitor) throws RodinDBException;

}
