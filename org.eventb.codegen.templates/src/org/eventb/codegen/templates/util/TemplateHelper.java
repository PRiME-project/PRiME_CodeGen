package org.eventb.codegen.templates.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.templates.IGenerator;
import org.eventb.codegen.templates.IGeneratorData;
import org.eventb.codegen.templates.TemplatesPlugin;

public class TemplateHelper {

	// The extension ID
	private static final String TEMPLATE_GEN_ID = "org.eventb.codegen.templates.generator";
	private static final String TEMPLATE_COMMENT_ID = "org.eventb.codegen.templates.tag";
	// Map of (keywords X generatorClasses)
	private static Map<String, IGenerator> generatorTagMap = null;
	public static String TAG_COMMENT_CHARS = null;
	private HashMap<String, File> templateFolderContentMap = null;
	// a data object that can be used in the executable generator
	private IGeneratorData data = null;
	// keep track of current and previous templates
	
	private File templateFile = null;
	// we only need to set up the generatorMap once, since we
	// make it a class variables.
	static {
		try {
			initialise();
		} catch (CoreException e) {
			Status status = new Status(IStatus.ERROR,
					TemplatesPlugin.PLUGIN_ID,
					"Failed Translation: CoreException:"
					+ e.getMessage() +":\n"+ TemplateException.extractFullExceptionMessage(e) , e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);
		}
	}

	public TemplateHelper(IGeneratorData data_) throws CoreException {
		// set the data element
		data = data_;
	}

	private static void initialise() throws CoreException {
		// create a new store
		generatorTagMap = new HashMap<String, IGenerator>();
		// find the generator extension
		IExtension[] generatorExtension = Platform.getExtensionRegistry()
				.getExtensionPoint(TEMPLATE_GEN_ID).getExtensions();
		for (final IExtension gen_extn : generatorExtension) {
			List<IConfigurationElement> ceList = Arrays.asList(gen_extn
					.getConfigurationElements());
			// look through the configuration elements for the template
			// generator configurator.
			for (IConfigurationElement configurationElement : ceList) {
				// Process the configurator if it is valid
				if (configurationElement.isValid()) {
					String[] attributeNames = configurationElement.getAttributeNames();
					// We store (keyword X generatorClass) pairs.
					for (int idx = 0; idx < attributeNames.length; idx = idx + 2) {
						IGenerator exeExt = (IGenerator) configurationElement
								.createExecutableExtension(attributeNames[idx]);
						generatorTagMap.put(configurationElement
								.getAttribute(attributeNames[idx + 1]), exeExt);
					}
		
				} else {
					// else the configurator was not valid
					try {
						throw new TemplateException("");
					} catch (TemplateException e) {
						Status status = new Status(IStatus.ERROR,
								TemplatesPlugin.PLUGIN_ID,
								"Failed Translation: TemplateException:", e);
						StatusManager.getManager().handle(status,
								StatusManager.SHOW);
					}
				}
			}
		}
		// get the begin-comment characters
		IExtension[] commentExtension = Platform.getExtensionRegistry()
				.getExtensionPoint(TEMPLATE_COMMENT_ID).getExtensions();
		for (final IExtension comment_extn : commentExtension) {
			List<IConfigurationElement> ceList = Arrays.asList(comment_extn
					.getConfigurationElements());
			// look through the configuration elements for the comment extension
			for (IConfigurationElement configurationElement : ceList) {
				// Process the comment configurator if it is valid
				if (configurationElement.isValid()) {
					String[] attributeNames = configurationElement.getAttributeNames();
					// We store the comment.
					for (int idx = 0; idx < attributeNames.length; idx = idx + 2) {
						TAG_COMMENT_CHARS = configurationElement.getAttribute(attributeNames[idx]);
					}
		
				} else {
					// else the configurator was not valid
					try {
						throw new TemplateException("");
					} catch (TemplateException e) {
						Status status = new Status(IStatus.ERROR,
								TemplatesPlugin.PLUGIN_ID,
								"Failed Translation: TemplateException:", e);
						StatusManager.getManager().handle(status,
								StatusManager.SHOW);
					}
				}
			}
		}

	}

	public List<String> generate(String tagword) throws Exception {
		List<String> newLines = new ArrayList<String>();
		
		// set previous from the last iteration
		templateFile = templateFolderContentMap.get(tagword);
		
		
		// if we have a template file then translate it.
		if (templateFile != null) {
			// We have found a template, in a template. Process it.
			// Create a bufferedReader, and use the default templateReader
			// to instantiate it ....
			FileReader reader = new FileReader(templateFile);
			BufferedReader bufferedReader = new BufferedReader(reader);
			TemplateProcessor templateProcessor = TemplateProcessor
					.getDefault();
			newLines = templateProcessor.internalInstantiateTemplate(
					bufferedReader, templateFolderContentMap);

		} else {
			// else we have a keyword in a template. Get the generator 
			// from the generatorTargetMap using the keyword.
			IGenerator generator = generatorTagMap.get(tagword);
			if (generator != null) {
				// run the generator with the data.
				newLines = generator.generate(data);
			}
		}
		// return the new lines
		return newLines;
	}

	public void setChildTemplateMap(HashMap<String, File> childTemplateMap_) {
		templateFolderContentMap = childTemplateMap_;
	}

	public File getTemplateFile() {
		return templateFile;
	}

}
