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
public interface ITargetLanguageElement extends IInternalElement{
	
	IInternalElementType<ITargetLanguageElement> ELEMENT_TYPE = 
		RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".targetLanguage");
	
	/**
	 * Tests whether the 'Target Language' attribute is defined or not.
	 * 
	 * @return whether the 'Target Language' attribute is defined or not
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	boolean hasTargetLanguage() throws RodinDBException;

	/**
	 * Returns the 'Target Language' attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @return 'Target Language' attribute value
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	String getTargetLanguage() throws RodinDBException;

	/**
	 * Sets the 'Target Language' attribute, which is supposed to indicate the target language for this translation.
	 * 
	 * @param target
	 *            the target language of this translation
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting is not desired
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	void setTargetLanguage(String target, IProgressMonitor monitor) throws RodinDBException;
}
