/**
 * 
 */
package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public interface ITranslationElement extends IInternalElement{
	
	IInternalElementType<ITranslationElement> ELEMENT_TYPE = 
		RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translationElement");
	
	/**
	 * Tests whether the 'Translation Element' attribute is defined or not.
	 * 
	 * @return whether the 'Translation Element' attribute is defined or not
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	boolean hasTranslation() throws RodinDBException;

	/**
	 * Returns the 'Translation Element' attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @return 'Translation Element' attribute value
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	String getTranslation() throws RodinDBException;

	/**
	 * Sets the 'Translation Element' attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @param newTranslation
	 *            the new translation value
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting is not desired
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	void setTranslation(String newTranslation, IProgressMonitor monitor) throws RodinDBException;

}
