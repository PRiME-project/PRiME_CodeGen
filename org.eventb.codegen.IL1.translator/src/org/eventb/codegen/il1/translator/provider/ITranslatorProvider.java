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
 *
 */
public interface ITranslatorProvider {

	public List<ITranslationRule> getRules(TargetLanguage targetLanguage, IEventBProject eventBProject) throws CoreException;

	public List<ITranslationRule> getTypeRules(TargetLanguage targetLanguage, IEventBProject eventBProject) throws CoreException;
	
	List<ITranslationRule> getDirectRules(TargetLanguage targetLanguage, IEventBProject eventBProject, List<ITranslationRule> translationRule) throws CoreException;


}
