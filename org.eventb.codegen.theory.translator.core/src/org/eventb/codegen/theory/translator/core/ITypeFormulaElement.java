/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;


/**
 * The common protocol for typeFormula elements.
 *
 * * <p> The element may contain an Event-B <b>isOfType</b> expression.
 *
 * @author renatosilva
 *
 */
public interface ITypeFormulaElement extends IInternalElement {

	/**
	 * Returns whether the type formula attribute is set or not.
	 * @return whether the attribute is present
	 * @throws RodinDBException
	 */
	boolean hasTypeFormula() throws RodinDBException;

	/**
	 * Returns the type formula associated with this element is definitional.
	 * @return the set type formula
	 * @throws RodinDBException
	 */
	String getTypeFormula() throws RodinDBException;

	/**
	 * Sets this element type formula attribute to the given value.
	 * @param typeFormula the new type formula
	 * @param monitor the progress monitor
	 * @throws RodinDBException
	 */
	void setTypeFormula(String typeFormula, IProgressMonitor monitor) throws RodinDBException;

}
