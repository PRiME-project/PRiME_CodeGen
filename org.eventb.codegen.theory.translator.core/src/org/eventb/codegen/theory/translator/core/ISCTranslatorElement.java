/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.core.ITraceableElement;
import org.eventb.theory.core.ISCMetavariable;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public interface ISCTranslatorElement extends ITraceableElement{

	IInternalElementType<ISCTranslatorElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".scTranslatorElement");

	/**
	 * Returns a handle to the metavariable with the given name.
	 * @param name of the metavariable
	 * @return the metavariable
	 */
	ISCMetavariable getSCMetavariable(String name);

	/**
	 * Returns all metavariables of this block.
	 * @return all metavariables
	 * @throws RodinDBException
	 */
	ISCMetavariable[] getSCMetavariables() throws RodinDBException;

	/**
	 * Returns a handle to the translator rule with the given name.
	 * @param name of the rule
	 * @return the rule
	 */
	ISCTranslatorRuleElement getSCTranslatorRule(String name);

	/**
	 * Returns all translator rules of this block.
	 * @return all scRules
	 * @throws RodinDBException
	 */
	ISCTranslatorRuleElement[] getSCTranslatorRules() throws RodinDBException;

	/**
	 * Returns the SC 'Target Language' attribute, which is supposed to indicate the target language for this translation.
	 *
	 * @return SC 'Target Language' attribute value
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	String getSCTargetLanguage() throws RodinDBException;

	/**
	 * Sets the SC 'Target Language' attribute, which is supposed to indicate the target language for this translation.
	 *
	 * @param targetLanguage
	 *            the SC target language of this translation
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting is not desired
	 * @throws RodinDBException
	 *             if there was a problem accessing the database
	 */
	void setSCTargetLanguage(String targetLanguage, IProgressMonitor monitor) throws RodinDBException;

	/**
	 * Returns a handle to the translator scTypeRule with the given name.
	 * @param name of the scTypeRule
	 * @return the typeRule
	 */
	ISCTranslatorTypeRuleElement getSCTranslatorTypeRule(String name);

	/**
	 * Returns all translator scTypeRules of this block.
	 * @return all scTypeRules
	 * @throws RodinDBException
	 */
	ISCTranslatorTypeRuleElement[] getSCTranslatorTypeRules() throws RodinDBException;



}
