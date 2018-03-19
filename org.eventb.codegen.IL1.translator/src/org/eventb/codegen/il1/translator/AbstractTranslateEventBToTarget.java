package org.eventb.codegen.il1.translator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.translator.core.AbstractProgramIL1Translator;
import org.eventb.codegen.il1.translator.provider.AbstractTranslatorProvider;
import org.eventb.codegen.il1.translator.provider.ITranslationRule;
import org.eventb.codegen.il1.translator.provider.TranslatorProviderManager;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.RelevantMachineLoader;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.codegen.tasking.TranslateToIL1;
import org.eventb.core.basis.ContextRoot;
import org.eventb.core.basis.MachineRoot;
import org.osgi.service.prefs.BackingStoreException;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.IComposedMachineRoot;

/**
 * @author ae
 * @author <b>htson</b> Use ITypeEnvironmentBuilder instead of ITypeEnvironment (due to
 *         API changed).
 */
public abstract class AbstractTranslateEventBToTarget implements
		IObjectActionDelegate {
	private IStructuredSelection selection;
	protected Shell shell;
	// store resources for use in updates
	protected List<IResource> resourceUpdateList = new ArrayList<IResource>();
	protected String projectSrcDirectoryString;
	protected String targetDirectoryString;

	public AbstractTranslateEventBToTarget() {
		super();
	}

	/**
	 * Returns the target language for the translator.
	 * 
	 * @return The target language.
	 */
	protected abstract TargetLanguage getTargetLanguage();

	/**
	 * Perform any post processing of the code to get the desired format etc.
	 * Can use the formatCodeBraces method to format based on braces.
	 * 
	 * @param code
	 *            The translated code to be formatted.
	 * @param translationManager
	 *            The translation manager incase it is required.
	 * @return The correctly formatted code.
	 */
	protected abstract List<String> formatCode(List<String> code,
			IL1TranslationManager translationManager);

	/**
	 * Saves the code to a file. Allows languages to save the code in different
	 * ways, eg in separate files. Can use the helper method, saveToFileHelper,
	 * that will save a block of code to the given file.
	 * 
	 * @param codeToSave
	 *            The translated and formatted code to save to file.
	 * @param headerInformation
	 *            Any header information from the translation.
	 * @param program
	 *            The IL1 Program and it's tree in case it is required.
	 * @param translationManager
	 *            The IL1 to Code translation manager.
	 */
	protected abstract void saveToFile(List<String> codeToSave,
			ArrayList<ClassHeaderInformation> headerInformation,
			Program program, String directoryName,
			IL1TranslationManager translationManager);

	@Override
	public void run(IAction arg0) {
		// Force a build of the project, to catch any static checks that may not
		// have been performed
		// actually this code didn't work, so it has been removed
		// rebuild(selection);

		// Translate EventBToIL1
		MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION
				| SWT.CANCEL);

		dialog.setText("Translation Status");
		try {
			Program program = TranslateToIL1
					.translateEventBToIL1(getSelection());

			// Now to the code generation
			IL1TranslationManager il1TranslationManager = new IL1TranslationManager();

			il1TranslationManager
					.setCurrentTranslationTarget(getTargetLanguage());

			List<String> code = null;

			// Translation Rules
			Map<IProject, List<ITranslationRule>> translationRules = loadTranslatorRules();
			il1TranslationManager.setTranslatorRules(translationRules);
			
						
			
			// Types Rules
			Map<IProject, List<ITranslationRule>> translationTypeRules = loadTranslatorTypeRules();
			il1TranslationManager.setTranslatorTypeRules(translationTypeRules);

            //Direct Operation Definition Translation Rules
            Map<IProject, List<ITranslationRule>> allTranslationRules = mergHashMap(translationRules, translationTypeRules);
            Map<IProject, List<ITranslationRule>> translationDirectRules = loadTranslatorDirectRules(allTranslationRules);
            
            //Check if there is a translation rule for the direct translation rules
//          for (IProject p: translationDirectRules.keySet()) {
//              List<ITranslationRule> translationDirectRuleElements = translationDirectRules.get(p);
//              for (ITranslationRule translationDirectRule: translationDirectRuleElements) {
//                  IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(translationDirectRule.getFormula().toString(), typeEnvironment, rules,false);
//                  String translatedExpression = formulaVisitor.translate();
//              }
//              
//          }
 
            
            il1TranslationManager.setTranslatorRules(mergHashMap(translationRules, translationDirectRules));

			code = il1TranslationManager.translateIL1ElementToCode(program,
					getTargetLanguage());
			code = formatCode(code, il1TranslationManager);

			// for C we will remove unicode *
			TargetLanguage translationTarget = il1TranslationManager
					.getCurrentTranslationTarget();
			boolean isC = translationTarget.getCoreLanguage().equals("c");
			if (isC) {
				List<String> processedCode = new ArrayList<String>();
				for (String codeLine : code) {
					// if there is non-ASCII characters in the line, replace if possible.
					// The unicode * must be replaced by an ASCII *, for instance.
					if (!TranslatorUtils.isASCII_only(codeLine)) {
						codeLine = TranslatorUtils.removeUnicode(codeLine);
						processedCode.add(codeLine);
					} else {
						processedCode.add(codeLine);
					}
				}
				//
				code = processedCode;
			}

			// Find the current directory from the first selected item
			String directoryName = getFilePathFromSelected();
			if (directoryName != null) {
				// make the directory
				setupDirectory(directoryName);
			} else
				throw new IL1TranslationException(
						"Failed to find directory path in " + this);

			// make the interfaces
			InterfaceGenerator interfaceGenerator = InterfaceGenerator
					.getDefault();
			interfaceGenerator.makeInterfaces(program, targetDirectoryString,
					il1TranslationManager);
			saveToFile(code, il1TranslationManager.getClassHeaderInformation(),
					program, targetDirectoryString, il1TranslationManager);

			System.out.println("*************************");
			System.out.println("CODE:");
			System.out.println();

			if (code != null) {
				for (String str : code) {
					System.out.println(str);
				}
			}

			System.out.println("*************************");

			updateResources();

		} catch (TaskingTranslationException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: TaskingTranslationException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (RodinDBException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (IL1TranslationUnhandledTypeException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: IL1TranslationUnhandledTypeException",
					e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (BackingStoreException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: BackingStoreException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (CoreException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (IL1TranslationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dialog.setMessage("Translation Ended");
		dialog.open();
	}

	
    protected Map<IProject, List<ITranslationRule>> loadTranslatorDirectRules(Map<IProject, List<ITranslationRule>> translationRules)
            throws TaskingTranslationUnhandledTypeException, CoreException {
        Map<IProject, List<ITranslationRule>> translationDirectRules = new HashMap<IProject, List<ITranslationRule>>();
        Object[] list = getSelection().toArray();
        TargetLanguage targetLanguage = this.getTargetLanguage();
 
        list = RelevantMachineLoader.getAllRelevantMachines(list).machineArray;
 
        for (Object obj : list) {
            IProject p = ((MachineRoot) obj).getResource().getProject();
 
            if (obj instanceof MachineRoot) {
                TranslatorProviderManager translatorProviderManager = TranslatorProviderManager
                        .getInstance();
                List<AbstractTranslatorProvider> translatorProviders = translatorProviderManager
                        .getTranslatorProviders();
                for (AbstractTranslatorProvider translatorProvider : translatorProviders) {
                    List<ITranslationRule> newDirectRules = translatorProvider
                            .getDirectRules(targetLanguage,
                                    ((MachineRoot) obj).getEventBProject(), translationRules.get(p));
                    if (translationDirectRules.containsKey(p)) {
                        List<ITranslationRule> existingRules = translationDirectRules
                                .get(p);
 
                        if (!existingRules.containsAll(newDirectRules)) {
                            for (ITranslationRule newDirectRule : newDirectRules) {
                                if (!existingRules.contains(newDirectRule))
                                    existingRules.add(newDirectRule);
                            }
                            translationDirectRules.put(p, existingRules);
                        }
 
                    } else {
                        translationDirectRules.put(p, newDirectRules);
                    }
                }
            }
        }
 
        return translationDirectRules;
    }

	protected void setupDirectory(String directoryName) {
		String specificLanguage = getTargetLanguage().getSpecificLanguage();
		if (specificLanguage.trim().equalsIgnoreCase("default")) {
			specificLanguage = "";
		} else {
			specificLanguage = "_" + specificLanguage;
		}

		projectSrcDirectoryString = directoryName + "src" + File.separatorChar;
		targetDirectoryString = directoryName + "src" + File.separatorChar
				+ AbstractProgramIL1Translator.GENERATED_PACKAGE_NAME + "_"
				+ getTargetLanguage().getCoreLanguage() + specificLanguage
				+ File.separatorChar;

		// Add the directory information for code, does nothing if it
		// already exists
		File fa = new File(projectSrcDirectoryString);
		File fb = new File(targetDirectoryString);

		fa.mkdir();
		fb.mkdir();
	}

	protected void updateResources() throws TaskingTranslationException {
		resourceUpdateList.add(getProjectResourceFromSelected());
		try {
			for (IResource resource : resourceUpdateList) {
				resource.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
		} catch (CoreException e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.setSelection((IStructuredSelection) selection);
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	protected Map<IProject, List<ITranslationRule>> loadTranslatorRules()
			throws CoreException, TaskingTranslationUnhandledTypeException {
		Map<IProject, List<ITranslationRule>> translationRules = new HashMap<IProject, List<ITranslationRule>>();
		Object[] list = getSelection().toArray();
		TargetLanguage targetLanguage = this.getTargetLanguage();

		list = RelevantMachineLoader.getAllRelevantMachines(list).machineArray;

		for (Object obj : list) {
			IProject p = ((MachineRoot) obj).getResource().getProject();
			if (obj instanceof MachineRoot) {
				TranslatorProviderManager translatorProviderManager = TranslatorProviderManager
						.getInstance();
				List<AbstractTranslatorProvider> translatorProviders = translatorProviderManager
						.getTranslatorProviders();
				
				for (AbstractTranslatorProvider translatorProvider : translatorProviders) {
					
					List<ITranslationRule> newRules = translatorProvider
							.getRules(targetLanguage,
									((MachineRoot) obj).getEventBProject());
					
					
					if (translationRules.containsKey(p)) {
						List<ITranslationRule> existingRules = translationRules
								.get(p);

						if (!existingRules.containsAll(newRules)) {
							for (ITranslationRule newRule : newRules) {
								if (!existingRules.contains(newRule))
									existingRules.add(newRule);
							}
							translationRules.put(p, existingRules);
						}

					} else {
						translationRules.put(p, newRules);
					}
				}
			}
		}
				
		return translationRules;
	}

	protected Map<IProject, List<ITranslationRule>> loadTranslatorTypeRules()
			throws CoreException, TaskingTranslationUnhandledTypeException {
		Map<IProject, List<ITranslationRule>> translationTypeRules = new HashMap<IProject, List<ITranslationRule>>();
		Object[] list = getSelection().toArray();
		TargetLanguage targetLanguage = this.getTargetLanguage();

		list = RelevantMachineLoader.getAllRelevantMachines(list).machineArray;

		for (Object obj : list) {
			IProject p = ((MachineRoot) obj).getResource().getProject();

			if (obj instanceof MachineRoot) {
				TranslatorProviderManager translatorProviderManager = TranslatorProviderManager
						.getInstance();
				List<AbstractTranslatorProvider> translatorProviders = translatorProviderManager
						.getTranslatorProviders();
				for (AbstractTranslatorProvider translatorProvider : translatorProviders) {
					List<ITranslationRule> newTypeRules = translatorProvider
							.getTypeRules(targetLanguage,
									((MachineRoot) obj).getEventBProject());
					if (translationTypeRules.containsKey(p)) {
						List<ITranslationRule> existingTypeRules = translationTypeRules
								.get(p);

						if (!existingTypeRules.containsAll(newTypeRules)) {
							for (ITranslationRule newTypeRule : newTypeRules) {
								if (!existingTypeRules.contains(newTypeRule))
									existingTypeRules.add(newTypeRule);
							}
							translationTypeRules.put(p, existingTypeRules);
						}

					} else {
						translationTypeRules.put(p, newTypeRules);
					}
				}
			}
		}

		return translationTypeRules;
	}

	/**
	 * Formats the code by using braces {}.
	 * 
	 * @param code
	 *            The translated code to format.
	 * @return The formatted code.
	 */
	protected List<String> formatCodeBraces(List<String> code) {
		ArrayList<String> formatted = new ArrayList<String>();

		int nTabs = 0;
		for (String line : code) {
			if (line.contains("}"))
				nTabs--;

			formatted.add(addTabs(nTabs) + line);

			// so { is on the original tab level
			if (line.contains("{"))
				nTabs++;
		}

		return formatted;
	}

	/**
	 * Generates n tab characters in a string.
	 * 
	 * @param n
	 *            The number of tabs to create.
	 * @return A string contain n tab characters.
	 */
	protected String addTabs(int n) {
		String out = "";
		for (int i = 0; i < n; i++) {
			out += "\t";
		}

		return out;
	}

	protected IResource getProjectResourceFromSelected() {
		for (Object o : getSelection().toArray()) {
			if (o instanceof MachineRoot) {
				return ((MachineRoot) o).getRodinProject().getProject();
			} else if (o instanceof ContextRoot) {
				return ((ContextRoot) o).getRodinProject().getProject();
			} else if (o instanceof IComposedMachineRoot) {
				return ((IComposedMachineRoot) o).getRodinProject()
						.getProject();
			}
		}
		return null;
	}

	protected String getFilePathFromSelected() {
		String path = null;
		String tPath = null;

		for (Object o : getSelection().toArray()) {
			if (o instanceof MachineRoot) {
				IRodinFile rodinFile = ((MachineRoot) o).getRodinFile();
				tPath = rodinFile.getResource().getRawLocation().toString();
				break;
			} else if (o instanceof ContextRoot) {
				IRodinFile rodinFile = ((ContextRoot) o).getRodinFile();
				tPath = rodinFile.getResource().getRawLocation().toString();
				break;
			} else if (o instanceof IComposedMachineRoot) {
				IRodinFile rodinFile = ((IComposedMachineRoot) o)
						.getRodinFile();
				tPath = rodinFile.getResource().getRawLocation().toString();
				break;
			}
		}

		if (tPath != null) {
			path = "";

			if (File.separator.equals("\\")) {
				path = "";
			} else if (File.separator.equals("/")) {
				path = "/";
			} else if (File.separator.equals(":")) {
				path = "::";
			}

			// Remove the final part
			StringTokenizer st = new StringTokenizer(tPath, "/");
			int tokens = st.countTokens();
			int tokenCounter = 0;
			while (tokenCounter < tokens - 1) {
				path = path + st.nextToken() + File.separatorChar;
				tokenCounter++;
			}
		}

		return path;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}
	
    protected Map<IProject, List<ITranslationRule>> mergHashMap(
            Map<IProject, List<ITranslationRule>> oldMap, 
            Map<IProject, List<ITranslationRule>> newMap) {
        Map<IProject, List<ITranslationRule>> merged = new HashMap<IProject, List<ITranslationRule>>();
        for (IProject p: newMap.keySet()) {
            if (oldMap.containsKey(p)) {
                List<ITranslationRule> existingRules = new ArrayList<ITranslationRule>();
                existingRules.addAll(oldMap.get(p));
                existingRules.addAll(newMap.get(p));
                merged.put(p, existingRules);
            } else {
                merged.put(p, newMap.get(p));
            }
        }
        return merged;
    }

}
