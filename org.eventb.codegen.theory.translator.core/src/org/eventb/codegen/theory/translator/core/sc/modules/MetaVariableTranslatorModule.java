/**
 * 
 */
package org.eventb.codegen.theory.translator.core.sc.modules;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.codegen.theory.translator.core.ISCTranslatorElement;
import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.codegen.theory.translator.core.sc.symbolTable.TranslatorMetavariableSymbolTable;
import org.eventb.core.IIdentifierElement;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.core.ast.Type;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.state.IIdentifierSymbolInfo;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.eventb.internal.core.sc.modules.IdentifierModule;
import org.eventb.theory.core.IMetavariable;
import org.eventb.theory.core.ISCMetavariable;
import org.eventb.theory.core.ITheoryRoot;
import org.eventb.theory.core.sc.modules.MetavariableModule;
import org.eventb.theory.core.sc.states.TheorySymbolFactory;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;

/**
 * @author renatosilva
 *
 */
@SuppressWarnings("restriction")
public class MetaVariableTranslatorModule extends IdentifierModule {

	private final IModuleType<MetavariableModule> MODULE_TYPE = SCCore.getModuleType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".metavariableModule");
	private final static int IDENT_SYMTAB_SIZE = 2047;
//	private TheoryAccuracyInfo accuracyInfo;

	@Override
	public void process(IRodinElement element, IInternalElement target,
			ISCStateRepository repository, IProgressMonitor monitor)
	throws CoreException {
		ITranslatorElement translatorElement = (ITranslatorElement) element;
		ISCTranslatorElement scTranslatorElement = (ISCTranslatorElement) target;
		IMetavariable[] metavars = translatorElement.getMetavariables();
		fetchSymbols(metavars, scTranslatorElement, repository, monitor);
		boolean accurate = true;
//		// in case some metavars were not filtered in
		if(identifierSymbolTable.getSymbolInfosFromTop().size() != metavars.length){
			accurate = false;
		}
		for (IIdentifierSymbolInfo symbolInfo : identifierSymbolTable.getSymbolInfosFromTop()) {
			if (symbolInfo.getSymbolType().equals(ISCMetavariable.ELEMENT_TYPE)
					&& symbolInfo.isPersistent()) {
				Type type = symbolInfo.getType();
				if (type == null) { // identifier could not be typed
//					symbolInfo.createUntypedErrorMarker(this);
					symbolInfo.setError();
					accurate = false;
				} else if (!symbolInfo.hasError()) {
					if (target != null) {
						symbolInfo.createSCElement(target, null);
					}
				}
			}
			else {
				accurate = false;
			}
		}
//		if(!accurate)
//			accuracyInfo.setNotAccurate();
	}

	@Override
	public IModuleType<?> getModuleType() {
		return MODULE_TYPE;
	}

	@Override
	public void initModule(IRodinElement element,
			ISCStateRepository repository, IProgressMonitor monitor)
	throws CoreException {
		super.initModule(element, repository, monitor);
		identifierSymbolTable = new TranslatorMetavariableSymbolTable(IDENT_SYMTAB_SIZE,repository.getFormulaFactory());
		repository.setState(identifierSymbolTable);
//		accuracyInfo = (TheoryAccuracyInfo) repository.getState(TheoryAccuracyInfo.STATE_TYPE);
	}

	@Override
	public void endModule(IRodinElement element, ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
//		accuracyInfo = null;
		super.endModule(element, repository, monitor);
	}

	protected void typeIdentifierSymbol(IIdentifierSymbolInfo newSymbolInfo,
			final ITypeEnvironmentBuilder environment) throws CoreException {
		environment.addName(newSymbolInfo.getSymbol(), newSymbolInfo.getType());
	}


	@Override
	protected IIdentifierSymbolInfo createIdentifierSymbolInfo(String name,
			IIdentifierElement element) {
		return TheorySymbolFactory.getInstance().makeLocalMetavariable(
				name, true, element, element.getAncestor(ITheoryRoot.ELEMENT_TYPE).getComponentName());
	}

}
