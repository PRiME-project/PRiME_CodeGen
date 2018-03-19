package org.eventb.codegen.il1.translator;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.MINUS_SYMBOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.impl.ActionImpl;
import org.eventb.codegen.il1.impl.ProgramImpl;
import org.eventb.codegen.il1.translator.provider.IL1FormulaRulesVisitor;
import org.eventb.codegen.il1.translator.provider.IL1FormulaTypeRulesVisitor;
import org.eventb.codegen.il1.translator.provider.ITranslationRule;
import org.eventb.codegen.il1.translator.utils.TranslatorProblem;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEvent;
import org.eventb.core.IEventBProject;
import org.eventb.core.IEventBRoot;
import org.eventb.core.IMachineRoot;
import org.eventb.core.IPRRoot;
import org.eventb.core.ISCContextRoot;
import org.eventb.core.ISCEvent;
import org.eventb.core.ISCMachineRoot;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.FreeIdentifier;
import org.eventb.core.ast.IParseResult;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.core.basis.ContextRoot;
import org.eventb.core.basis.MachineRoot;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

/**
 * <p>
 * Used to manage the translation provider classes and the EMF objects to be translated.
 * Translation classes can be added through the plug-in mechanism, similar to how they are with SyncManager.
 * </p>
 * 
 * <p>
 * Can also keep track of what has been previously translated, to prevent duplicate translations.
 * </p>
 * 
 * <p>
 * Similar to (based on) SyncManager and TaskingTranslationManager in org.eventb.codegen.tasking.
 * </p>
 * 
 * @author Chris
 * @author <b>htson</b> Use ITypeEnvironmentBuilder instead of ITypeEnvironment (due to
 *         API changed).
 */

public class IL1TranslationManager {

	// @Deprecated
	// public enum TargetLanguage {
	// Ada, C
	// }

	// Contains list of supported languages from the extension point
	public static ArrayList<TargetLanguage> supportedLanguages = new ArrayList<TargetLanguage>();
	public static ArrayList<String> coreSupportedLanguageDisplayNames = new ArrayList<String>();

//	private static final AbstractIL1Translator defaultIL1Translator = new DefaultIL1Translator();

	// IL1 EMF translator ID
	private static final String IL1TranslatorsID = "org.eventb.codegen.il1.translator";

	static {
		ArrayList<String> coreLanguagesLowerCase = new ArrayList<String>();
		for (final IExtension extension : Platform.getExtensionRegistry()
				.getExtensionPoint(IL1TranslatorsID).getExtensions()) {
			for (final IConfigurationElement packageElement : extension
					.getConfigurationElements()) {
				if ("emfPackage".equals(packageElement.getName())) {
					String nsURISource = packageElement
							.getAttribute("nsURISource");
					EPackage ePackageSource = EPackage.Registry.INSTANCE
							.getEPackage(nsURISource);

					for (final IConfigurationElement element : packageElement
							.getChildren("il1Translator")) {

						if ("il1Translator".equals(element.getName())) {
							try {
								String coreTargetLanguage = element
										.getAttribute("coreTargetLanguage");
								String specificTargetLanguage = element
										.getAttribute("specificTargetLanguage");

								final AbstractIL1Translator translator = (AbstractIL1Translator) element
										.createExecutableExtension("IL1TranslatorClass");

								EClassifier source = (EClassifier) ePackageSource
										.getEClassifier(element
												.getAttribute("sourceClass"));

								if (coreTargetLanguage != null) {
									TargetLanguage targetLanguage = new TargetLanguage(
											coreTargetLanguage,
											specificTargetLanguage);

									// See if the target language has already
									// been created
									int index = supportedLanguages
											.indexOf(targetLanguage);
									if (index >= 0) {
										// Has already been created
										targetLanguage = supportedLanguages
												.get(index);
									} else {
										// Hasn't been added, so add it
										supportedLanguages.add(targetLanguage);

										if (!coreLanguagesLowerCase
												.contains(coreTargetLanguage
														.toLowerCase())) {
											coreLanguagesLowerCase
													.add(coreTargetLanguage
															.toLowerCase());
											coreSupportedLanguageDisplayNames
													.add(coreTargetLanguage);
										}
									}

									// Add the mapping
									targetLanguage.addMapping((EClass) source,
											translator);
								}
							} catch (final CoreException e) {

							}
						}
					}
				}
			}
		}

	}
	private ArrayList<Task> autoTask = new ArrayList<Task>();
	private Map<String, ArrayList<String>> booleanIOMap = new HashMap<String, ArrayList<String>>();

	// Used for putting header declarations in C
	private ArrayList<ClassHeaderInformation> classHeaderInformation = new ArrayList<ClassHeaderInformation>();
	private ArrayList<String> compilerDependentBlock = new ArrayList<String>();
	private ArrayList<String> compilerDependentBlocksAdded = new ArrayList<String>();
	// keep track of declarations in maps (parentName X (varName X
	// VariableDecl))
	private Map<String, Map<String, VariableDecl>> declarationMap = new HashMap<String, Map<String, VariableDecl>>();
	private ArrayList<String> enumTypeNameList = new ArrayList<String>();
	protected ITypeEnvironmentBuilder defaultTypeEnvironment = null;

	private ArrayList<EnvironTask> environTaskList = new ArrayList<EnvironTask>();
	private ArrayList<String> includeStatements = new ArrayList<String>();
	private final String MATH_EXTENSIONS_PROJ = "MathExtensions";
	private ArrayList<Protected> protectedObjectList = new ArrayList<Protected>();
	private static boolean issueMessages = false; // flag that when true issue
													// error messages if a
													// formula is not translated
	// this is the probability used to calculate the branch condition upper
	// limit
	public static int branchProbability = 0;
	
	private Map<IProject, List<ITranslationRule>> translatorRules;

	private Map<IProject, List<ITranslationRule>> translatorTypeRules;
	
	public TargetLanguage currentTranslationTarget = null;

	// iMap stores the imports for each component - ComponentName X POW(Imports)
	private Map<String, ArrayList<String>> importMap = new HashMap<String, ArrayList<String>>();
	// store a list of enum state names and their types (stateName X type)
	private Map<String, String> enumTypeMap = new HashMap<String, String>();
	// The name of the stored global spec - if one exists. To be with'ed in each
	// component
	private String globalSpecName = null;
	private List<String> environMachineNames = new ArrayList<String>();
	private String programName = "";
	private List<Subroutine> communicatingSubroutineList = new ArrayList<Subroutine>();
	public ArrayList<Declaration> inputArguments = new ArrayList<Declaration>();

	public void addClassHeaderInformation(ClassHeaderInformation c) {
		classHeaderInformation.add(c);
	}

	/**
	 * Will add a block of code to be placed after the includes, but before the
	 * rest of the generated code.
	 * 
	 * To be used for things where there may be platform specific functions
	 * used. For example sleep. This is used to define the appropriate sleep
	 * function for the platform being compiled to.
	 * 
	 * These MUST be executable, not just header defines, as they will go in a
	 * separate file in C. Other languages may do different things, or just not
	 * use this option.
	 * 
	 * @param name
	 *            - used to identify blocks to prevent duplicates
	 * @param block
	 */
	public void addCompilerDependentExecutableCodeBlock(String name,
			ArrayList<String> block) {
		if (!compilerDependentBlocksAdded.contains(name)) {
			compilerDependentBlock.addAll(block);
			compilerDependentBlocksAdded.add(name);
		}
	}

	/**
	 * Used to add required libraries, includes etc. Must state the requirement
	 * in the way the code is written. eg. #include<iostream.h> eg. using
	 * namespace std; eg. import java.util.HashMap;
	 * 
	 * This will ignore any duplicates, but only where the exact string matches.
	 * 
	 * @param include
	 *            The library to include in code format.
	 */
	public void addIncludeStatement(String include) {
		include = include.trim();

		if (!includeStatements.contains(include)) {
			includeStatements.add(include);
		}
	}

	public void clearCompilerDependentExecutableCodeBlock() {
		compilerDependentBlock.clear();
	}

	public void clearIncludeStatements() {
		includeStatements.clear();
	}

	public ArrayList<Task> getAutoTaskList() {
		return autoTask;
	}

	public Map<String, ArrayList<String>> getBooleanIOMap() {
		return booleanIOMap;
	}

	public ArrayList<ClassHeaderInformation> getClassHeaderInformation() {
		return classHeaderInformation;
	}

	public ArrayList<String> getCompilerDependentExecutableCodeBlock() {
		return compilerDependentBlock;
	}

	public Map<String, Map<String, VariableDecl>> getDeclarationMap() {
		return declarationMap;
	}

	private EObject getEContainer(EObject source) {
		return source.eContainer();
	}

	public ArrayList<EnvironTask> getEnvironTaskList() {
		return environTaskList;
	}

	public Map<String, ArrayList<String>> getImportMap() {
		return importMap;
	}

	public ArrayList<String> getIncludeStatements() {
		return includeStatements;
	}

	/**
	 * Returns the parameters of the subroutine the action is in (if any or if
	 * in a subroutine)
	 * 
	 * @param a
	 * @return
	 */
	public EList<Parameter> getParameters(Action a) {
		Subroutine s = getSubroutine(a);

		if (s != null) {
			return s.getFormalParameters();
		}

		return null;
	}

	public Protected getParentProtected(IL1Element element) {
		if (element instanceof Protected)
			return (Protected) element;
		else if (element == null)
			return null;
		else if (element.eContainer() instanceof IL1Element)
			return getParentProtected((IL1Element) element.eContainer());
		else
			return null;
	}

	public Task getParentTask(IL1Element element) {
		if (element instanceof Task)
			return (Task) element;
		else if (element == null)
			return null;
		else if (element.eContainer() instanceof IL1Element)
			return getParentTask((IL1Element) element.eContainer());
		else
			return null;
	}

	public ArrayList<Protected> getProtectedObjectList() {
		return protectedObjectList;
	}

	private List<ITranslationRule> getRelevantTranslatorRules(
			IInternalElement element) {
		List<ITranslationRule> localTranslationRules = new ArrayList<ITranslationRule>();
		IProject localProject = element.getRodinProject().getProject();

		for (Entry<IProject, List<ITranslationRule>> entry : translatorRules
				.entrySet()) {
			if (entry.getKey().equals(MATH_EXTENSIONS_PROJ)
					|| entry.getKey().equals(localProject)) {
				localTranslationRules.addAll(entry.getValue());
			}
		}

		return localTranslationRules;
	}

	private List<ITranslationRule> getRelevantTranslatorTypeRules(
			IInternalElement element) {
		List<ITranslationRule> localTranslationTypeRules = new ArrayList<ITranslationRule>();
		IProject localProject = element.getRodinProject().getProject();

		for (Entry<IProject, List<ITranslationRule>> entry : translatorTypeRules
				.entrySet()) {
			if (entry.getKey().equals(MATH_EXTENSIONS_PROJ)
					|| entry.getKey().equals(localProject)) {
				localTranslationTypeRules.addAll(entry.getValue());
			}
		}

		return localTranslationTypeRules;
	}

	public String getRodinMachineName(IL1Element source) {
		EObject object = getEContainer(source);

		// SOMEHOW we have to get a machine name for this constant.
		// the constants will be part of the prog, hence have no container.
		// They come from the context which is the source's component.
		if (object instanceof ProgramImpl && source instanceof ConstantDecl) {
			return ((ConstantDecl) source).getComponentName();
		}

		while (!(object instanceof Task) && !(object instanceof Protected)
				&& (object != null)) {
			object = getEContainer(object);
		}

		if (object instanceof Task) {
			return ((Task) object).getName();
		} else if (object instanceof Protected) {
			return ((Protected) object).getName();
		} else if (object instanceof Protected) {
			return ((Protected) object).getName();
		} else {
			return null;
		}
	}

	public String getRodinProjectName(IL1Element source) {
		EObject object = getEContainer(source);

		// while it isn't a Task and not a Protected and not null
		while (!(object instanceof Task) && !(object instanceof Protected)
				&& !(object == null)) {
			object = getEContainer(object);
		}
		if (object instanceof Task) {
			return ((Task) object).getProjectName();
		} else if (object instanceof Protected) {
			return ((Protected) object).getProjectName();
		} else if (object == null && source instanceof ConstantDecl) {
			return ((ConstantDecl) source).getProjectName();
		} else {
			return null;
		}
	}

	public IEventBRoot getSourceRoot(String projectName, String componentName) {
		IRodinProject rodinProject = RodinCore.getRodinDB().getRodinProject(
				projectName);
		ArrayList<String> machineNames = new ArrayList<String>();
		ArrayList<String> contextNames = new ArrayList<String>();
		try {
			for (IRodinElement element : rodinProject.getChildren()) {
				if (element instanceof IRodinFile) {
					IInternalElement root = ((IRodinFile) element).getRoot();
					if (root instanceof IMachineRoot) {
						machineNames
								.add(((IMachineRoot) root).getElementName());
					} else if (root instanceof IContextRoot) {
						contextNames
								.add(((IContextRoot) root).getElementName());
					}
				}
			}
		} catch (RodinDBException e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException:"
					+ e.getMessage(), e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);
		}

		IEventBRoot root = null;
		if (machineNames.contains(componentName)) {
			IEventBProject eventBProject = (IEventBProject) rodinProject.getAdapter(IEventBProject.class);
			root = eventBProject.getMachineRoot(componentName);
		} else {
			IEventBProject eventBProject = (IEventBProject) rodinProject.getAdapter(IEventBProject.class);
			root = eventBProject.getContextRoot(componentName);
		}
		return root;
	}

	public Subroutine getSubroutine(IL1Element e) {
		if (e instanceof Subroutine)
			return (Subroutine) e;

		if (e.eContainer() != null && e.eContainer() instanceof IL1Element)
			return getSubroutine((IL1Element) e.eContainer());

		return null;
	}

	/**
	 * Return the type of the variable varName in the parent parentName
	 * 
	 * @param name
	 * @return
	 */
	public VariableDecl getType(String parentName, String varName) {
		Map<String, VariableDecl> decl = declarationMap.get(parentName);
		if (decl != null)
			return decl.get(varName);
		else
			return null;
	}

	private void initialiseTypeEnvironment(FormulaFactory formulaFactory) {
		if (defaultTypeEnvironment == null)
			defaultTypeEnvironment = formulaFactory.makeTypeEnvironment();
	}

	/**
	 * Enhance the defaultTypeEnvironment with the IL1Element source
	 * 
	 * @param source
	 * @param typeEnvironment
	 */
	private void enhanceDefaultTypeEnvironment(IL1Element source,
			ITypeEnvironment typeEnvironment) {
		if (source instanceof Declaration) {
			Declaration varDecl = (Declaration) source;
			if (!typeEnvironment.contains(varDecl.getIdentifier())) {
				IParseResult parseTypeResult = typeEnvironment
						.getFormulaFactory().parseType(varDecl.getType());
				if (!parseTypeResult.hasProblem()) {
					FreeIdentifier freeId = typeEnvironment.getFormulaFactory()
							.makeFreeIdentifier(varDecl.getIdentifier(), null,
									parseTypeResult.getParsedType());
					defaultTypeEnvironment.add(freeId);
					//inputArguments.add(varDecl);
				}
			}
		}
	}

	private ISCMachineRoot getSCMachine(IMachineRoot root) {
		return root.getSCMachineRoot();
	}

	private ISCContextRoot getSCContext(IContextRoot root) {
		return root.getSCContextRoot();
	}

	public ITypeEnvironment getTypeEnvironment(IEventBRoot sourceRoot) {
		ITypeEnvironmentBuilder typeEnvironment = FormulaFactory.getDefault()
				.makeTypeEnvironment();
		try {

			if (sourceRoot instanceof ContextRoot) {
				ISCContextRoot scContextRoot = sourceRoot.getSCContextRoot();
				typeEnvironment = scContextRoot
						.getTypeEnvironment();
			} else if (sourceRoot instanceof MachineRoot) {
				ISCMachineRoot scMachineRoot = sourceRoot.getSCMachineRoot();
				typeEnvironment = scMachineRoot
						.getTypeEnvironment();
			}
		} catch (CoreException e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException:"
					+ e.getMessage(), e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);		}

		typeEnvironment.addAll(defaultTypeEnvironment);

		return typeEnvironment;
	}

	/**
	 * For situations where the theory plug-in will fail.
	 * 
	 * @param line
	 *            The string to replace UTF8 characters in
	 * @param targetLanguage
	 *            The target language being used
	 * @return
	 */
	String replaceUTF8Characters(String line, TargetLanguage targetLanguage) {
		// For all languages
		String output = line.replace(MINUS_SYMBOL, "-");

		// Turned this off, as 'not', 'and' and 'or' are handled by the theory
		// now
		/*
		 * // For specific languages switch (targetLanguage) { case C: output =
		 * output.replace('¬', '!'); output = output.replace("∧", "&&"); output
		 * = output.replace("∨", "||"); break; case Ada: // for not ¬A to not(A)
		 * output = output.replace("¬", " ¬ "); // forces a space between ¬ and
		 * any leading bracket that may exist output = output.replace("(",
		 * " ( "); output = output.replace(")", " ) ");
		 * 
		 * String tokenString = tokenizeVariablesOperators(output).trim();
		 * 
		 * // Remove double spaces, so each token is split by one ' '
		 * while(tokenString.contains("  ")) { tokenString =
		 * tokenString.replace("  ", " "); } output = ""; String [] tokens =
		 * tokenString.split(" "); for (int i = 0; i < tokens.length; i++) { if
		 * (i+1 < tokens.length) { if (tokens[i].equals("¬")) { if
		 * (tokens[i+1].equals("(")) { // Find all elements within the brackets
		 * String inside = tokens[i+1]; int bracketCounter = 1;
		 * 
		 * for (i = i+2; i < tokens.length && bracketCounter > 0; i++) { inside
		 * += " " + tokens[i];
		 * 
		 * if (tokens[i].equals("(")) { bracketCounter++; } else if
		 * (tokens[i].equals(")")) { bracketCounter--; } }
		 * 
		 * output += " not(" + inside + ")"; i--; // as for loop above will go
		 * i+1 over and not use the value } else { output += " not(" +
		 * tokens[i+1] + ")"; i++; } } else { output += " " + tokens[i]; } }
		 * else { output += " " + tokens[i]; } } output = output.trim();
		 * 
		 * 
		 * output = output.replace("∧", " and "); output = output.replace("∨",
		 * " or "); output = output.replace("  ", " "); // to remove extra
		 * spaces added by 'and' or 'or'
		 * 
		 * break; }
		 */

		return output;
	}

	public String resolveType(String bType, String parameterName,
			String projectName, String machineName,
			TargetLanguage targetLanguage) {
		// Create a dummy variable decl with no initial value, and the theory
		// should sort it out
		VariableDecl vDummy = Il1Factory.eINSTANCE.createVariableDecl();
		vDummy.setIdentifier(parameterName);
		vDummy.setType(bType);
		vDummy.setInitialValue(null);
		vDummy.setProjectName(projectName);
		vDummy.setComponentName(machineName);

		return translateDeclaration(vDummy, targetLanguage).getType();
	}

	public void setTranslatorRules(
			Map<IProject, List<ITranslationRule>> translatorRules) {
		this.translatorRules = translatorRules;
	}

	public void setTranslatorTypeRules(
			Map<IProject, List<ITranslationRule>> translatorTypeRules) {
		this.translatorTypeRules = translatorTypeRules;
	}

	/**
	 * Splits the given line into one where variables and constants are
	 * separated from operators
	 * 
	 * @param line
	 * @return
	 */
	public String tokenizeVariablesOperators(String actionLine) {
		ArrayList<String> empty = new ArrayList<String>();
		empty.add("\\");
		empty.add("%");
		return tokenizeVariablesOperators(actionLine, empty);
	}

	public String tokenizeVariablesOperators(String actionLine,
			ArrayList<String> optionalAllowableTokens) {
		String newActionLine = " ";
		boolean lastNumberLetterSpace = true;
		for (char c : actionLine.toCharArray()) {
			// if (lastNumberLetterSpace)
			// {
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
					|| (c >= '0' && c <= '9') || c == ' ' || c == '_'
					|| optionalAllowableTokens.contains(Character.toString(c))) {
				// A character
				if (!lastNumberLetterSpace)
					newActionLine += " ";
				newActionLine += c;
				lastNumberLetterSpace = true;
			} else {
				// To prevent separating == to = =
				if (lastNumberLetterSpace) {
					// An operator
					newActionLine += ' ';
					newActionLine += c;
					// newActionLine += ' ';
					lastNumberLetterSpace = false;
				} else {
					newActionLine += c;
				}
			}
		}

		newActionLine += ' ';

		// Remove any double spaces
		while (newActionLine.contains("  ")) {
			newActionLine = newActionLine.replace("  ", " ");
		}

		return newActionLine;
	}

	/**
	 * Handles variable declaration translation between IL1 and Theory. This
	 * handles Variables, LocalVariables and Constants. The LocalVariables do
	 * not give as much information as Variables currently, this could be a
	 * problem.
	 * 
	 * @param decl
	 *            The declaration of the element to be translated.
	 * @param targetLanguage
	 *            The target language.
	 * @param eventName
	 * @return The TranslatedDecl object in the requested language.
	 */
	public TranslatedDecl translateDeclaration(Declaration decl,
			TargetLanguage targetLanguage) {
		issueMessages = false;
		TranslatedDecl output = Il1Factory.eINSTANCE
				.createPartiallyTranslatedDecl();
		String type = null;
		if (decl.getType() != null) {
			type = decl.getType().trim();
		}
		String identifier = decl.getIdentifier().trim();
		String initialValue = decl.getInitialValue();

		assert identifier == null : decl;
		//Input arguments
		if(identifier.contains("inarg_") || identifier.contains("outarg_"))
			inputArguments.add(decl);
		enhanceDefaultTypeEnvironment(decl, getTypeEnvironment(decl));
		
		
		
		// Translation in two phases:

		// Initial Value translation
		String tempInitialValue = "";
		if (enumTypeNameList.contains(type)) {
			// this is an enum type -simply set the type and return it
			output.setType(type);
			((PartiallyTranslatedDecl) output)
					.setPartialInitialisationExpression(initialValue);
			return output;
		} else if (null != initialValue) {
			// Try to translatate the initialValue
			tempInitialValue = translatePredicateExpression(initialValue, decl,
					targetLanguage); // translateTypeDeclaration(identifier,
										// initialValue, targetLanguage, decl);
			if (!tempInitialValue.trim().isEmpty()
					&& !(tempInitialValue.equals(initialValue))) {
				((PartiallyTranslatedDecl) output)
						.setPartialInitialisationExpression(tempInitialValue);
			} else {
				issueMessages = false;
				// Translation of the initialValue failed.
				String declarationString = identifier + ASSIGNMENT_SYMBOL
						+ initialValue;
				tempInitialValue = translateTypeDeclaration(identifier,
						declarationString, decl, targetLanguage);
				if (!tempInitialValue.trim().isEmpty()) {
					output = Il1Factory.eINSTANCE.createFullyTranslatedDecl();
					((FullyTranslatedDecl) output)
							.getFullInitialisationExpression().add(
									tempInitialValue);
				} else {
					((PartiallyTranslatedDecl) output)
							.setPartialInitialisationExpression(initialValue);
					if ((decl instanceof VariableDecl || decl instanceof ConstantDecl)) {
						// This code generates a false error message.
//						TranslatorUtils.log(Status.INFO, decl,
//								TranslatorProblem.InitialValueNotTranslated,
//								initialValue, identifier);
					}
				}
			}
		} else {
			((PartiallyTranslatedDecl) output)
					.setPartialInitialisationExpression("");
			if (decl instanceof VariableDecl || decl instanceof ConstantDecl) {
				// This is not a problem - the initial value should be found later
				// on in the translation process
//				TranslatorUtils.log(Status.WARNING, decl,
//				TranslatorProblem.InitialValueNotFound, identifier);
			}
		}

		// Type translation
		if (null != type) {
			String translatedTypeDeclaration = translateTypeDeclaration(
					identifier, type, decl, targetLanguage);
			output.setType(translatedTypeDeclaration);
		} else {
			output.setType("");
		}

		if (output.getType().trim().isEmpty() || output.getType().equals(type)) {
			TranslatorUtils.log(Status.WARNING, decl,
					TranslatorProblem.TranslationTypeNotFound, identifier);
		}

		issueMessages = true;
		return output;
	}

	// The main workhorse for translating elements into code fragments.
	// The first part of the method ensures there is a translator for the
	// element.
	public ArrayList<String> translateIL1ElementToCode(IL1Element source,
			TargetLanguage targetLanguage)
			throws IL1TranslationUnhandledTypeException {
		
		
		if (source == null) {
			return new ArrayList<String>();
		}
		

		// Set the target language
		this.currentTranslationTarget = targetLanguage;
		AbstractIL1Translator translator = null;

		// Get the real target language information,
		// the given targetLanguage just contains coreLanguage and
		// specificLanguage strings.
		int index = supportedLanguages.indexOf(targetLanguage);
		if (index == -1) {
			TranslatorUtils.log("Undefined translator for type: " + source
					+ " Core: " + targetLanguage.getCoreLanguage()
					+ ". Specific: " + targetLanguage.getSpecificLanguage(),
					IStatus.WARNING, source);

			throw new IL1TranslationUnhandledTypeException(source,
					targetLanguage);
		} else {
			// See if the index exists in the supported languages (contains the
			// translators to use)
			// Then if the index also has the required translator

			
			TargetLanguage actualTargetLanguage = supportedLanguages.get(index);
			translator = actualTargetLanguage.getTranslator(source);

			if (translator == null) {
				// If this isn't already requesting the default translator,
				// see if the default version of the required translator exists
				if (!targetLanguage.getSpecificLanguage().equals("Default")) {
					TargetLanguage defaultTargetLanguage = new TargetLanguage(
							targetLanguage.getCoreLanguage());
					index = supportedLanguages.indexOf(defaultTargetLanguage);

					if (index >= 0) {
						actualTargetLanguage = supportedLanguages.get(index);
						translator = actualTargetLanguage.getTranslator(source);
					}
				}

				// If the translator is still null, abort
				if (translator == null) {
					TranslatorUtils.log("Undefined translator for type: "
							+ source + " Undefined translator. Core: "
							+ targetLanguage.getCoreLanguage() + ". Specific: "
							+ targetLanguage.getSpecificLanguage(),
							IStatus.WARNING, source);

					throw new IL1TranslationUnhandledTypeException(source,
							targetLanguage);
				}
			}
		}

		if (source instanceof Enumeration) {
			Enumeration e = (Enumeration) source;
			if (e.getIdentifier().startsWith("Eng")) {
				System.out.println("Enum " + e.getIdentifier());
			}
		}
		// This is where we translate the ILElements to code
		ArrayList<String> code = new ArrayList<String>();
		try {
			
			code = translator.translate(source, this, targetLanguage);

		} catch (CoreException e) {
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		} catch (IL1TranslationException e) {
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: IL1TranslationException" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		} catch (Exception e)
		{
			Status s = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Exception (" + e.toString() + ") :" + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		}
		

				
		return code;
	}

	// From Chris - I don't think this should return ArrayList<String> as
	// predicates will only be a single line
	// Otherwise could break things such as Guards becoming elements in an if
	// (GUARD) block
	public String translatePredicateExpression(String formula,
			IL1Element source, TargetLanguage targetLanguage) {
		String output = "";

		String projectName = getRodinProjectName(source);
		String machineName = getRodinMachineName(source);// assumption : source
															// is a machine
		// EObject obj = source.eContainer();

		String eventName = null;
		if (source instanceof ActionImpl) {
			eventName = ((ActionImpl) source).getParentEventName();
		}
		
		if (projectName != null && machineName != null) {
			IEventBRoot sourceRoot = getSourceRoot(projectName, machineName);
			ITypeEnvironment typeEnvironment = getTypeEnv(sourceRoot, eventName);
			if(typeEnvironment == null){
				typeEnvironment = defaultTypeEnvironment;
			}

			List<ITranslationRule> relevantTranslatorRules = getRelevantTranslatorRules(sourceRoot);
			// ITypeEnvironment typeEnvironment =
			// getTypeEnvironment(sourceRoot); //
			// enhanceDefaultTypeEnvironment(source,getTypeEnvironment(source));
			IL1FormulaRulesVisitor il1FormulaVisitor = new IL1FormulaRulesVisitor(
					formula, typeEnvironment, relevantTranslatorRules,
					issueMessages);
			output = il1FormulaVisitor.translate();

		}
		output = replaceUTF8Characters(output, targetLanguage);
		return output;
	}

	/**
	 * @param sourceRoot
	 * @param eventName
	 * @return
	 */
	private ITypeEnvironment getTypeEnv(IEventBRoot sourceRoot, String eventName) {

		ITypeEnvironmentBuilder typeEnvironment = null;
		if (sourceRoot instanceof MachineRoot) {
			IMachineRoot machineRoot = (IMachineRoot) sourceRoot;
			ISCMachineRoot scMachine = getSCMachine(machineRoot);

			try {
				typeEnvironment = scMachine.getTypeEnvironment();
				if (eventName != null) {
					IEvent event = null;
					for (IEvent e : machineRoot.getEvents()) {
						if (e.getLabel().equals(eventName)) {
							event = e;
							break;
						}
					}
					for (ISCEvent scEvent : scMachine.getSCEvents()) {
						IRodinElement source = scEvent.getSource();
						if (source.equals(event)) {
							typeEnvironment = scEvent.getTypeEnvironment(
									typeEnvironment);
							break;
						}
					}
				} else {
					typeEnvironment = scMachine.getTypeEnvironment();
				}
			} catch (CoreException e) {
				Status status = new Status(IStatus.ERROR,
						CodeGenTasking.PLUGIN_ID,
						"Failed Translation: RodinDBException:"
						+ e.getMessage(), e);
					StatusManager.getManager().handle(status,
						StatusManager.SHOW);			}
		} else if (sourceRoot instanceof ContextRoot) {
			ISCContextRoot scMachine = getSCContext((IContextRoot) sourceRoot);
			try {
				typeEnvironment = scMachine.getTypeEnvironment();
			} catch (CoreException e) {
				Status status = new Status(IStatus.ERROR,
						CodeGenTasking.PLUGIN_ID,
						"Failed Translation: RodinDBException:"
						+ e.getMessage(), e);
					StatusManager.getManager().handle(status,
						StatusManager.SHOW);
			}
		}
		return typeEnvironment;
	}

	private ITypeEnvironment getTypeEnvironment(Declaration source) {
		String projectName = source.getProjectName();
		if (projectName == null)
			projectName = getRodinProjectName(source);
		String machineName = source.getComponentName();
		if (machineName == null)
			machineName = getRodinMachineName(source);
		IEventBRoot sourceRoot = getSourceRoot(projectName, machineName);
		IPRRoot prRoot = sourceRoot.getPRRoot();
		FormulaFactory formulaFactory = prRoot.getFormulaFactory();

		initialiseTypeEnvironment(formulaFactory);

		return getTypeEnvironment(sourceRoot);
	}

	private String translateTypeDeclaration(String identifier,
			String typeOrInitialValue, Declaration input,
			TargetLanguage targetLanguage) {
		String output = "";
		final String projectName = input.getProjectName();
		final String componentName = input.getComponentName();
		final IEventBRoot sourceRoot = getSourceRoot(projectName, componentName);

		List<ITranslationRule> relevantTranslatorTypeRules = getRelevantTranslatorTypeRules(sourceRoot);
		// TranslatorUtils.log("relevantTranslatorTypeRules="+relevantTranslatorTypeRules.toString(),IStatus.INFO);
		IL1FormulaTypeRulesVisitor il1FormulaVisitor;
		ITypeEnvironment typeEnvironment = getTypeEnv(sourceRoot, null);
		if(typeEnvironment == null){
			typeEnvironment = defaultTypeEnvironment;
		}
		il1FormulaVisitor = new IL1FormulaTypeRulesVisitor(identifier,
				typeOrInitialValue, typeEnvironment,
				relevantTranslatorTypeRules, issueMessages);
		String translation = il1FormulaVisitor.translate();
		if (!translation.trim().isEmpty()) {
			output = translation;
		}
		return output;
	}

	/**
	 * @return the enumTypeNameList
	 */
	public ArrayList<String> getEnumTypeNameList() {
		return enumTypeNameList;
	}

	// set the global specName
	public void setGlobalSpecName(String with) {
		globalSpecName = with;
	}

	// get the global specName
	public String getGlobalSpecName() {
		return globalSpecName;
	}

	public List<String> getEnvironMachineNames() {
		return environMachineNames;
	}

	public Map<String, String> getEnumTypePathMap() {
		return enumTypeMap;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public TargetLanguage getCurrentTranslationTarget() {
		return currentTranslationTarget;
	}

	public void setCurrentTranslationTarget(TargetLanguage currentTranslationTarget) {
		this.currentTranslationTarget = currentTranslationTarget;
	}

	public List<Subroutine> getCommunicatingSubroutines() {
		return communicatingSubroutineList;
	}

}