/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.eventb.core.ICommentedElement;
import org.eventb.theory.core.IMetavariable;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public interface ITranslatorElement extends ICommentedElement, ITargetLanguageElement{

	IInternalElementType<ITranslatorElement> ELEMENT_TYPE = RodinCore.getInternalElementType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorElement");

	/**
	 * Returns a handle to the metavariable with the given name.
	 * @param name of the metavariable
	 * @return the metavariable
	 */
	IMetavariable getMetavariable(String name);

	/**
	 * Returns all metavariables of this block.
	 * @return all metavariables
	 * @throws RodinDBException
	 */
	IMetavariable[] getMetavariables() throws RodinDBException;

	/**
	 * Returns a handle to the translator rule with the given name.
	 * @param name of the translator rule
	 * @return the rule
	 */
	ITranslatorRuleElement getTranslatorRule(String name);

	/**
	 * Returns all translatorRules of this block.
	 * @return all translatorRules
	 * @throws RodinDBException
	 */
	ITranslatorRuleElement[] getTranslatorRules() throws RodinDBException;

	/**
	 * Returns all translatorTypeRules of this block.
	 * @return all translatorTypeRules
	 * @throws RodinDBException
	 */
	ITranslatorTypeRuleElement[] getTranslatorTypeRules() throws RodinDBException;

}
