/**
 * 
 */
package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.ITraceableElement;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public interface ISCTranslationElement extends ITraceableElement, IInternalElement{
	
	/**
	 * Tests whether the 'Translation Element' SC attribute is defined or not.
	 * 
	 * @return whether the 'Translation Element' attribute is defined or not
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	boolean hasSCTranslation() throws RodinDBException;

	/**
	 * Returns the 'Translation Element' SC attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @return 'Translation Element' attribute value
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	String getSCTranslation() throws RodinDBException;

	/**
	 * Sets the 'Translation Element' SC attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @param newTranslation
	 *            the new translation value
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting is not desired
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	void setSCTranslation(String newTranslation, IProgressMonitor monitor) throws RodinDBException;

}
