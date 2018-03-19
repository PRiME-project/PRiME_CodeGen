/**
 * 
 */
package org.eventb.codegen.theory.translator.core.sc.symbolTable;

import org.eventb.codegen.theory.translator.core.EventBTheoryTranslatorPlugin;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.state.ISCState;
import org.eventb.core.tool.IStateType;
import org.eventb.internal.core.sc.symbolTable.IdentifierSymbolTable;

/**
 * @author renatosilva
 *
 */
@SuppressWarnings("restriction")
public class TranslatorMetavariableSymbolTable extends IdentifierSymbolTable
		implements ISCState {
	
	public final static IStateType<TranslatorMetavariableSymbolTable> STATE_TYPE = SCCore.getToolStateType(EventBTheoryTranslatorPlugin.PLUGIN_ID + ".translatorMetavariableSymbolTable");

	/**
	 * @param identSize
	 * @param factory
	 */
	public TranslatorMetavariableSymbolTable(int identSize,
			FormulaFactory factory) {
		super(identSize, factory);
	}
	
	@Override
	public IStateType<?> getStateType() {
		return TranslatorMetavariableSymbolTable.STATE_TYPE;
	}
}
