/**
 * 
 */
package org.eventb.codegen.theory.translator.core.sc.modules;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorAttributes;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.codegen.theory.translator.core.ISCTranslatorElement;
import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.codegen.theory.translator.core.sc.TranslatorProblem;
import org.eventb.codegen.theory.translator.core.utils.Messages;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.SCProcessorModule;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.eventb.internal.ui.UIUtils;
import org.eventb.theory.core.ISCTheoryRoot;
import org.eventb.theory.core.ITheoryRoot;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;


/**
 * @author renatosilva
 *
 */
public class TranslatorModule extends SCProcessorModule {
	
	public static final IModuleType<TranslatorModule> MODULE_TYPE = SCCore.getModuleType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorModule");
	private ITheoryRoot root;
	private static final String TRANSLATOR_NAME = "TRANSL";
	private final String EMPTY_STRING = "";
	private ITranslatorElement[] translatorElements;
	private ITypeEnvironmentBuilder globalTypeEnvironment;

	/* (non-Javadoc)
	 * @see org.eventb.internal.core.tool.types.ISCProcessorModule#process(org.rodinp.core.IRodinElement, org.rodinp.core.IInternalElement, org.eventb.core.sc.state.ISCStateRepository, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void process(IRodinElement element, IInternalElement target,
			ISCStateRepository repository, IProgressMonitor monitor)
					throws CoreException {

		ISCTranslatorElement[] scTranslatorElements = new ISCTranslatorElement[translatorElements.length];
		processTranslators((ISCTheoryRoot)target, scTranslatorElements, repository, monitor);
	}
	
	private void processTranslators(ISCTheoryRoot target, ISCTranslatorElement[] scTranslationElements,
			ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException{
		
		SubMonitor progress = SubMonitor.convert(monitor, scTranslationElements.length*2);
		int index = EventBTheoryTranslatorPlugin.SC_STARTING_INDEX;
		
		FormulaFactory factory = repository.getFormulaFactory();
		globalTypeEnvironment = repository.getTypeEnvironment();
		for(ITranslatorElement translatorElement: translatorElements){
			progress.beginTask(Messages.progress_Translator, 2);
			progress.subTask(Messages.progress_TranslatorTarget);
			
			//Check that target language is not empty or undefined
			if(!translatorElement.hasTargetLanguage() || null==translatorElement.getTargetLanguage() || translatorElement.getTargetLanguage().equals(EMPTY_STRING) || translatorElement.getTargetLanguage().equals(UIUtils.COMBO_VALUE_UNDEFINED)){
				createProblemMarker(translatorElement,
						EventBTheoryTranslatorAttributes.TARGET_LANGUAGE_ATTRIBUTE,
						TranslatorProblem.UndefinedTargetError);
			}
			progress.worked(1);
			progress.subTask(Messages.progress_TranslatorMetavariable);
			
			scTranslationElements[index] = createSCTranslator(translatorElement, target, index, monitor);
			
			
			ITypeEnvironmentBuilder opTypeEnvironment = factory.makeTypeEnvironment();
			opTypeEnvironment.addAll(globalTypeEnvironment);
			repository.setTypeEnvironment(opTypeEnvironment);
			
			// call the children processor module
			initProcessorModules(translatorElement, repository, monitor);
			processModules(translatorElement, scTranslationElements[index], repository, monitor);
			endProcessorModules(translatorElement, repository, monitor);
			repository.setTypeEnvironment(globalTypeEnvironment);
			index++;
			progress.worked(1);
		}
		repository.setTypeEnvironment(globalTypeEnvironment);
	}

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
		
		IRodinFile rf = (IRodinFile) element;
		root = (ITheoryRoot) rf.getRoot();
		globalTypeEnvironment = repository.getTypeEnvironment();
		translatorElements = getTranslationElements();
	}
	
	@Override
	public void endModule(
			IRodinElement element,
			ISCStateRepository repository, 
			IProgressMonitor monitor) throws CoreException {
		repository.setTypeEnvironment(globalTypeEnvironment);
//		theoryAccuracyInfo = null;
		globalTypeEnvironment = null;
		super.endModule(element, repository, monitor);
	}
	
	// Utilities
	
	private ITranslatorElement[] getTranslationElements()
			throws CoreException {
		return root.getChildrenOfType(ITranslatorElement.ELEMENT_TYPE);
	}
	
	// create an empty sc element
	private ISCTranslatorElement createSCTranslator(ITranslatorElement translatorElement, ISCTheoryRoot target, int index,
			IProgressMonitor monitor) throws CoreException {
		ISCTranslatorElement scTranslatorElement = target.getInternalElement(ISCTranslatorElement.ELEMENT_TYPE, TRANSLATOR_NAME + index);
		scTranslatorElement.create(null, monitor);
		scTranslatorElement.setSCTargetLanguage(translatorElement.getTargetLanguage(), monitor);
		scTranslatorElement.setSource(translatorElement, monitor);
		return scTranslatorElement;
	}

}
