/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.internal.provider.TranslationRule;
import org.eventb.codegen.il1.translator.internal.provider.TranslationTypeRule;
import org.eventb.core.ast.ITypeEnvironment;

/**
 * @author renatosilva
 *
 */
public interface AbstractTranslatorProviderFactory {

	/**
	 * Creates a new instance of a translation rule having the target language as argument
	 *
	 * @param target
	 * 	The target Language
	 * @param typeEnvironment
	 * @return
	 * 	An instance of {@link TranslationRule}
	 */
	public ITranslationRule getTranslationRule(TargetLanguage target, ITypeEnvironment typeEnvironment);

	/**
	 * Creates a new instance of a translation Type rule having the target language as argument
	 *
	 * @param target
	 * @param typeEnvironment
	 * @return
	 * 	An instance of {@link TranslationTypeRule}
	 */
	public ITranslationRule getTranslationTypeRule(TargetLanguage target, ITypeEnvironment typeEnvironment);



}
