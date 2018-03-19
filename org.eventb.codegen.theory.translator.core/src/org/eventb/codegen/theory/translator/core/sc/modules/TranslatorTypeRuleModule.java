/**
 *
 */
package org.eventb.codegen.theory.translator.core.sc.modules;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.codegen.theory.translator.core.ISCTranslatorElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorTypeRuleElement;
import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.codegen.theory.translator.core.ITranslatorTypeRuleElement;
import org.eventb.codegen.theory.translator.core.sc.TranslatorProblem;
import org.eventb.codegen.theory.translator.core.sc.state.TranslatorSymbolFactory;
import org.eventb.codegen.theory.translator.core.utils.Messages;
import org.eventb.codegen.theory.translator.core.utils.TranslatorUtils;
import org.eventb.core.EventBAttributes;
import org.eventb.core.ILabeledElement;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FreeIdentifier;
import org.eventb.core.sc.GraphProblem;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.SCProcessorModule;
import org.eventb.core.sc.state.ILabelSymbolInfo;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;

/**
 * @author renatosilva
 *
 */
public class TranslatorTypeRuleModule extends SCProcessorModule {

	public static final IModuleType<TranslatorTypeRuleModule> MODULE_TYPE = SCCore.getModuleType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorTypeRuleModule");
	private final static int LABEL_SYMTAB_SIZE = 2047;
	private static final String TRANSLATOR_TYPE_RULE_NAME = "TRANSL_TYPE_RULE";
	private final String EMPTY_STRING = "";
	Set<ILabelSymbolInfo> labelSymbolTable = new HashSet<ILabelSymbolInfo>(LABEL_SYMTAB_SIZE);
	private ITranslatorTypeRuleElement[] translatorTypeRuleElements;

	/* (non-Javadoc)
	 * @see org.eventb.internal.core.tool.types.IModule#getModuleType()
	 */
	@Override
	public IModuleType<?> getModuleType() {
		return MODULE_TYPE;
	}

	@Override
	public void initModule(
			IRodinElement element,
			ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
		translatorTypeRuleElements = getTranslationTypeRuleElements((ITranslatorElement)element);
		super.initModule(element, repository, monitor);
	}

	/* (non-Javadoc)
	 * @see org.eventb.internal.core.tool.types.ISCProcessorModule#process(org.rodinp.core.IRodinElement, org.rodinp.core.IInternalElement, org.eventb.core.sc.state.ISCStateRepository, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void process(IRodinElement element, IInternalElement target,
			ISCStateRepository repository, IProgressMonitor monitor)
			throws CoreException {
		ILabelSymbolInfo[] symbolInfos = fetchTranslatorTypeRules((ITranslatorElement) element, repository,monitor);
		ISCTranslatorTypeRuleElement[] scTranslatorTypeRuleElements = new ISCTranslatorTypeRuleElement[translatorTypeRuleElements.length];
		if(translatorTypeRuleElements.length>0){
			commitTranslatorTypeRules((ISCTranslatorElement) target, scTranslatorTypeRuleElements, symbolInfos,repository, monitor);
			processTranslatorTypeRules(scTranslatorTypeRuleElements, repository, symbolInfos, monitor);
		}
	}

	@Override
	public void endModule(
			IRodinElement element,
			ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
		endProcessorModules(element, repository, monitor);
	}

	private ITranslatorTypeRuleElement[] getTranslationTypeRuleElements(ITranslatorElement element)
			throws CoreException {
		return element.getTranslatorTypeRules();
	}

	private ILabelSymbolInfo[] fetchTranslatorTypeRules(ITranslatorElement element,
			ISCStateRepository repository, IProgressMonitor monitor)
			throws CoreException {
		String fileName = element.getElementName();
		ILabelSymbolInfo[] symbolInfos = new ILabelSymbolInfo[translatorTypeRuleElements.length];
		labelSymbolTable.clear();

		for (int i = 0; i < translatorTypeRuleElements.length; i++) {
			ITranslatorTypeRuleElement translator = translatorTypeRuleElements[i];
			symbolInfos[i] = fetchLabel(translator, fileName, monitor);
			if (symbolInfos[i] == null)
				continue;
		}
		return symbolInfos;
	}

	protected ILabelSymbolInfo createLabelSymbolInfo(String symbol,
			ILabeledElement element, String component) throws CoreException {
		return TranslatorSymbolFactory.getInstance().makeLocalTypeRuleTranslator(symbol, true, element, component);
	}

	/**
	 * Adds a new label symbol to the label symbol table. Returns the new symbol
	 * info created if the label is not already in use, and <code>null</code>
	 * otherwise.
	 *
	 * @param internalElement
	 *            the labeled element
	 * @return the new label symbol
	 * @throws CoreException
	 *             if there was a problem with the database or the symbol table
	 */
	private ILabelSymbolInfo fetchLabel(IInternalElement internalElement,
			String component, IProgressMonitor monitor) throws CoreException {

		ILabeledElement labeledElement = (ILabeledElement) internalElement;

		if (!labeledElement.hasLabel()) {
			createProblemMarker(labeledElement,
					EventBAttributes.LABEL_ATTRIBUTE,
					GraphProblem.LabelUndefError);
			return null;
		}

		if (labeledElement.getLabel().trim().equals("")) {
			createProblemMarker(labeledElement,
					EventBAttributes.LABEL_ATTRIBUTE,
					GraphProblem.EmptyLabelError);
			return null;
		}

		String label = labeledElement.getLabel();

		ILabelSymbolInfo newSymbolInfo = createLabelSymbolInfo(label,
				labeledElement, component);

		if(!labelSymbolTable.add(newSymbolInfo)){
			newSymbolInfo.createConflictMarker(this);

			return null;
		}

		newSymbolInfo.setAttributeValue(EventBAttributes.SOURCE_ATTRIBUTE,labeledElement);
		return newSymbolInfo;
	}

	private void commitTranslatorTypeRules(ISCTranslatorElement target, ISCTranslatorTypeRuleElement[] scTranslatorTypeRuleElements,
			ILabelSymbolInfo[] symbolInfos,
			ISCStateRepository repository, IProgressMonitor monitor) throws CoreException {
		int index = EventBTheoryTranslatorPlugin.SC_STARTING_INDEX;
		for (int i = 0; i < scTranslatorTypeRuleElements.length; i++) {
			if (symbolInfos[i] != null && !symbolInfos[i].hasError()) {
				scTranslatorTypeRuleElements[i] = createSCTranslatorTypeRule(target, index++, symbolInfos[i],
						 monitor);
				scTranslatorTypeRuleElements[i].setLabel(translatorTypeRuleElements[i].getLabel(), monitor);
			}
		}
	}

	// create an empty sc element
	private ISCTranslatorTypeRuleElement createSCTranslatorTypeRule(ISCTranslatorElement target, int index,
			ILabelSymbolInfo symbolInfo,
			IProgressMonitor monitor) throws CoreException {
		ILabeledElement element = symbolInfo.createSCElement(target, TRANSLATOR_TYPE_RULE_NAME + index, monitor);
		return (ISCTranslatorTypeRuleElement) element;
	}

	private void processTranslatorTypeRules(
			ISCTranslatorTypeRuleElement[] scTranslatorTypeRuleElements, ISCStateRepository repository, ILabelSymbolInfo[] symbolInfos,
			IProgressMonitor monitor) throws CoreException{

		SubMonitor progress = SubMonitor.convert(monitor, translatorTypeRuleElements.length*2);

		for(int i = 0;i<translatorTypeRuleElements.length;i++){
			ITranslatorTypeRuleElement translatorTypeElement = translatorTypeRuleElements[i];
			progress.beginTask(Messages.progress_Translator, 2);
			progress.subTask(Messages.progress_TranslatorLabel);

			if(null==scTranslatorTypeRuleElements[i]){
				progress.worked(2);
				continue;
			}

			//Check formula
			if(!translatorTypeElement.hasTypeFormula() || null==translatorTypeElement.getTypeFormula() || translatorTypeElement.getTypeFormula().equals(EMPTY_STRING)){
				createProblemMarker(translatorTypeElement,
						EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE,
						TranslatorProblem.UndefinedFormulaError,
						translatorTypeElement.getLabel());
				continue;
			}
			else {
				Formula<?> parseFormula = TranslatorUtils.parseEventBFormula(translatorTypeElement, repository.getFormulaFactory(), EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE, this);
				if(null==parseFormula || parseFormula instanceof FreeIdentifier){
					createProblemMarker(translatorTypeElement,
							EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE,
							TranslatorProblem.UnparseableFormulaError,
							translatorTypeElement.getLabel());
					continue;
				}
				else{
					Formula<?> checkFormula = TranslatorUtils.checkFormula(translatorTypeElement, parseFormula, repository.getTypeEnvironment(), EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE, this);
				    if(null!=checkFormula){
				    	boolean error = false;
						// check all idents of the lhs formula were actually declared BUG FIXED.
						for (FreeIdentifier identifier : checkFormula.getFreeIdentifiers()){
							if (!repository.getTypeEnvironment().contains(identifier.getName())){
								error = true;
								createProblemMarker(translatorTypeElement, EventBTheoryTranslatorAttributes.TYPE_FORMULA_ATTRIBUTE,
										GraphProblem.UndeclaredFreeIdentifierError, identifier.getName());
							}
						}
						if(error)
							continue;
				    	scTranslatorTypeRuleElements[i].setSCTypeFormula(parseFormula, monitor);
				    }
				}
			}
			progress.worked(1);

			//Check that Translation is not empty
			String translation = translatorTypeElement.getTranslation();
			if(!translatorTypeElement.hasTranslation() || null==translation || translation.equals(EMPTY_STRING)){
				createProblemMarker(translatorTypeElement,
						EventBTheoryTranslatorAttributes.TRANSLATION_ATTRIBUTE,
						TranslatorProblem.UndefinedTranslationError,
						translatorTypeElement.getLabel());
			}
			else {
				scTranslatorTypeRuleElements[i].setSCTranslation(translation, monitor);
			}
			progress.worked(1);
		}



	}

}
