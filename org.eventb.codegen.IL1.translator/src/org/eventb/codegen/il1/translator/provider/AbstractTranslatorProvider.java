/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.core.IEventBProject;

/**
 * @author renatosilva
 * @author <b>htson</b> Use ITypeEnvironmentBuilder instead of ITypeEnvironment (due to
 *         API changed).
 */
public abstract class AbstractTranslatorProvider implements ITranslatorProvider {

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslatorProvider#getRules(org.eventb.codegen.il1.translator.IL1TranslationManager.TargetLanguage)
	 */
	@Override
	public abstract List<ITranslationRule> getRules(TargetLanguage targetLanguage, IEventBProject eventBProject)
			throws CoreException;

	@Override
	public abstract List<ITranslationRule> getTypeRules(
			TargetLanguage targetLanguage, IEventBProject eventBProject)
			throws CoreException;
	
	@Override
	public abstract List<ITranslationRule> getDirectRules(TargetLanguage targetLanguage,
			IEventBProject eventBProject, List<ITranslationRule> translationRule) throws CoreException;


}
