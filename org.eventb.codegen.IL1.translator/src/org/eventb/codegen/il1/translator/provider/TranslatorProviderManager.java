/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.internal.provider.TranslationRule;
import org.eventb.codegen.il1.translator.internal.provider.TranslationTypeRule;
import org.eventb.core.ast.ITypeEnvironment;

/**
 * @author renatosilva
 * 
 */
public class TranslatorProviderManager implements
		AbstractTranslatorProviderFactory {

	private static TranslatorProviderManager translatorProviderManager = null;
	private final String translatorProviderID = "org.eventb.codegen.il1.translatorProvider";
	private List<AbstractTranslatorProvider> translatorProviderList = new ArrayList<AbstractTranslatorProvider>();

	private TranslatorProviderManager() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(translatorProviderID);
		for (final IConfigurationElement translatorProviderElement : extensionPoint
				.getConfigurationElements()) {
			try {
				final AbstractTranslatorProvider translatorProvider = 
						(AbstractTranslatorProvider) translatorProviderElement
						.createExecutableExtension("class");
				translatorProviderList.add(translatorProvider);
				
			} catch (final CoreException e) {
//				Status myStatus = new Status(IStatus.ERROR,
//						CodeGenTasking.PLUGIN_ID, "Failed Translation: CoreException", e);
//				StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
				e.printStackTrace(System.err);
			}
		}
	}

	public static TranslatorProviderManager getInstance() {
		if (translatorProviderManager == null)
			translatorProviderManager = new TranslatorProviderManager();
		return translatorProviderManager;
	}

	@Override
	public ITranslationRule getTranslationRule(TargetLanguage target,
			ITypeEnvironment typeEnvironment) {
		return new TranslationRule(target, typeEnvironment);
	}

	@Override
	public ITranslationRule getTranslationTypeRule(TargetLanguage target,
			ITypeEnvironment typeEnvironment) {
		return new TranslationTypeRule(target, typeEnvironment);
	}

	public List<AbstractTranslatorProvider> getTranslatorProviders() {
		return translatorProviderList;
	}
}
