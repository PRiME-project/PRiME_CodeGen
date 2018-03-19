/**
 *
 */
package org.eventb.codegen.theory.translator.core;

import org.rodinp.core.IAttributeType;
import org.rodinp.core.RodinCore;

/**
 *  This class provides access to the database attributes defined in this plug-in.
 *
 * @author renatosilva
 *
 */
public class EventBTheoryTranslatorAttributes {

	public static IAttributeType.String TARGET_LANGUAGE_ATTRIBUTE = RodinCore.getStringAttrType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".targetLanguage");
	public static IAttributeType.String TRANSLATION_ATTRIBUTE = RodinCore.getStringAttrType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translationElement");
	public static IAttributeType.String FORMULA_ATTRIBUTE = RodinCore.getStringAttrType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".formula");
	public static IAttributeType.String TYPE_FORMULA_ATTRIBUTE = RodinCore.getStringAttrType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".typeFormula");


}
