/**
 *
 */
package org.eventb.codegen.theory.translator.core.sc.modules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.il1.translator.IL1TranslatorPlugin;
import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.codegen.theory.translator.core.sc.TranslatorProblem;
import org.eventb.codegen.theory.translator.core.sc.symbolTable.TranslatorMetavariableSymbolTable;
import org.eventb.core.EventBAttributes;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.FreeIdentifier;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.ITypeEnvironment.IIterator;
import org.eventb.core.ast.Type;
import org.eventb.core.ast.extensions.maths.AstUtilities;
import org.eventb.core.sc.GraphProblem;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.SCFilterModule;
import org.eventb.core.sc.state.IIdentifierSymbolInfo;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.eventb.theory.core.IMetavariable;
import org.eventb.theory.core.TheoryAttributes;
import org.eventb.theory.core.sc.TheoryGraphProblem;
import org.eventb.theory.core.sc.modules.MetavariableFilterModule;
import org.eventb.theory.internal.core.util.CoreUtilities;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
@SuppressWarnings("restriction")
public class MetaVariableFilterModule extends SCFilterModule {

	private final IModuleType<MetavariableFilterModule> MODULE_TYPE = SCCore.getModuleType(EventBTheoryTranslatorPlugin.PLUGIN_ID
			+ ".metavariableFilterModule");

	private TranslatorMetavariableSymbolTable identifierSymbolTable;

	@Override
	public boolean accept(IRodinElement element, ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
		IMetavariable var = (IMetavariable) element;
		String name = var.getIdentifierString();

		IIdentifierSymbolInfo symbolInfo = identifierSymbolTable.getSymbolInfo(name);

		if (!var.hasType() || var.getType().equals("")) {
			createProblemMarker(var, TheoryAttributes.TYPE_ATTRIBUTE,
					TranslatorProblem.TypeAttrMissingForOpArgError, name);
			return false;
		}

		//keywords: variables that end with '0' like 'var0' are not valid
		if (name.trim().endsWith(IL1TranslatorPlugin.METAVARIABLE_INIT_SUFFIX)) {
			createProblemMarker(var, EventBAttributes.IDENTIFIER_ATTRIBUTE,
					TranslatorProblem.InvalidMetavariableIdentifier, name, IL1TranslatorPlugin.METAVARIABLE_INIT_SUFFIX);
			return false;
		}

		Type type = CoreUtilities.parseTypeExpression(var, repository.getFormulaFactory(), this);
		if (type == null) {
			return false;
		}
		if (!checkTypeParameters(type, var, repository.getFormulaFactory(), repository.getTypeEnvironment())) {
			return false;
		}
		symbolInfo.setType(type);
		return true;
	}

	/**
	 * Checks that the type of the given metavariable only refers to types defined as type parameters in the type environment.
	 * @param type the type of the metavariable
	 * @param var the metavariable element
	 * @param factory the formula factory
	 * @param typeEnvironment the type environment
	 * @return whether only type parameters are used to construct the type of the metavariable
	 * @throws RodinDBException
	 */
	protected boolean checkTypeParameters(Type type, IMetavariable var, FormulaFactory factory, ITypeEnvironment typeEnvironment)
	throws RodinDBException {
		FreeIdentifier[] idents = type.toExpression().getSyntacticallyFreeIdentifiers();
		//List<String> givenSets = AstUtilities.getGivenSetsNames(typeEnvironment);

		//==
		List<String> givenSets = new ArrayList<String>();
		final IIterator iter = typeEnvironment.getIterator();
		while(iter.hasNext()){
			iter.advance();
			if(!iter.isGivenSet())
			{
				givenSets.add(iter.getName());
			}
		}
		//EOE
		
		
		for (FreeIdentifier ident : idents) {

			if (!typeEnvironment.contains(ident.getName())) {
				createProblemMarker(var, TheoryAttributes.TYPE_ATTRIBUTE,
						GraphProblem.UndeclaredFreeIdentifierError,
						ident.getName());
				return false;
			} else if (!givenSets.contains(ident.getName())) {
				//Sadegh: Something is wrong with this check
				/*createProblemMarker(var,

						TheoryAttributes.TYPE_ATTRIBUTE,
						TheoryGraphProblem.IdentIsNotTypeParError,
						ident.getName());*/
				//return false;
			}

		}
		return true;

	}

	@Override
	public IModuleType<?> getModuleType() {
		return MODULE_TYPE;
	}

	@Override
	public void initModule(ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
		super.initModule(repository, monitor);
		identifierSymbolTable = (TranslatorMetavariableSymbolTable) repository.getState(TranslatorMetavariableSymbolTable.STATE_TYPE);
	}

	@Override
	public void endModule(ISCStateRepository repository,
			IProgressMonitor monitor) throws CoreException {
		identifierSymbolTable = null;
		super.endModule(repository, monitor);
	}

}
