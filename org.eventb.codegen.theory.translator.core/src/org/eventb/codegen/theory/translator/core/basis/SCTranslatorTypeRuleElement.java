/**
 *
 */
package org.eventb.codegen.theory.translator.core.basis;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.theory.translator.core.ISCTranslatorTypeRuleElement;
import org.eventb.codegen.theory.translator.core.ISCTypeFormulaElement;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.IParseResult;
import org.eventb.core.ast.ITypeCheckResult;
import org.eventb.core.ast.ITypeEnvironment;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class SCTranslatorTypeRuleElement extends TranslatorTheoryElement implements ISCTranslatorTypeRuleElement, ISCTypeFormulaElement {

	/**
	 * @param name
	 * @param parent
	 */
	public SCTranslatorTypeRuleElement(String name, IRodinElement parent) {
		super(name, parent);
	}

	@Override
	public boolean hasSCTypeFormula() throws RodinDBException {
		return hasTypeFormula();
	}

	@Override
	public Formula<?> getSCTypeFormula(FormulaFactory ff,
			ITypeEnvironment typeEnvironment) throws RodinDBException {
		String form = getTypeFormula();

		//Check also if it is an assignment
		Formula<?> formula = this.parseFormulaAndAssignments(form, ff, true);
		if (formula == null) {
			return null;
		}
		ITypeCheckResult result = formula.typeCheck(typeEnvironment);
		if (result.hasProblem()) {
			return null;
		}
		return formula;
	}

	@Override
	public void setSCTypeFormula(Formula<?> formula, IProgressMonitor monitor)
			throws RodinDBException {
		setTypeFormula(formula.toStringWithTypes(), monitor);
	}

	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return ISCTranslatorTypeRuleElement.ELEMENT_TYPE;
	}

	/**
	 * Parses the formula string provided using the given formula factory. The
	 * formula string may contain predicate variables.
	 *
	 * @param formStr
	 *            the formula string
	 * @param ff
	 *            the formula factory
	 * @param isPattern
	 *            whether the formula is expected to have predicate variables
	 * @return the parsed formula
	 */
	private Formula<?> parseFormulaAndAssignments(String formStr, FormulaFactory ff,
			boolean isPattern) {
		Formula<?> formula = null;
		if (isPattern) {
			IParseResult res = ff.parseExpressionPattern(formStr, null);
			if (!res.hasProblem()) {
				formula = res.getParsedExpression();
			} else {
				res = ff.parsePredicatePattern(formStr, null);
				if (!res.hasProblem()) {
					formula = res.getParsedPredicate();
				}
				else{
					res = ff.parseAssignment(formStr, null);
					if (!res.hasProblem()) {
						formula = res.getParsedAssignment();
					}
				}
			}
		} else {
			IParseResult res = ff.parseExpression(formStr, null);
			if (!res.hasProblem()) {
				formula = res.getParsedExpression();
			} else {
				res = ff.parsePredicate(formStr, null);
				if (!res.hasProblem()) {
					formula = res.getParsedPredicate();
				}
				else{
					res = ff.parseAssignment(formStr, null);
					if (!res.hasProblem()) {
						formula = res.getParsedAssignment();
					}
				}
			}
		}

		return formula;
	}

}
