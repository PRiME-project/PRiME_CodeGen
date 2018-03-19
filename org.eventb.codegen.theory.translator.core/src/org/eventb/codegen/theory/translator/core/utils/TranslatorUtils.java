package org.eventb.codegen.theory.translator.core.utils;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.theory.translator.core.ITypeFormulaElement;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.IParseResult;
import org.eventb.core.ast.ITypeCheckResult;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.sc.IMarkerDisplay;
import org.eventb.theory.core.IFormulaElement;
import org.eventb.theory.internal.core.util.CoreUtilities;
import org.rodinp.core.IAttributeType;

public class TranslatorUtils {

	/**
	 * Parses the formula stored in the given element.
	 * @param element the formula element
	 * @param ff the formula factory
	 * @param typeEnvironment
	 * @param markerDisplay the marker display
	 * @return the parsed formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> parseEventBFormula(IFormulaElement element,
			FormulaFactory ff, IAttributeType.String attributeType, IMarkerDisplay markerDisplay)throws CoreException {

		String formStr = element.getFormula();
		IParseResult result = ff.parseAssignment(formStr, null);

		if (!result.hasProblem()){
			return result.getParsedAssignment();
		}

		return parseFormula(element, ff, attributeType, markerDisplay);
	}
	/**
	 * Parses the formula stored in the given element.
	 * @param element the formula element
	 * @param ff the formula factory
	 * @param typeEnvironment
	 * @param markerDisplay the marker display
	 * @return the parsed formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> parseEventBFormula(ITypeFormulaElement element,
			FormulaFactory ff, IAttributeType.String attributeType, IMarkerDisplay markerDisplay)throws CoreException {

		String formStr = element.getTypeFormula();
		IParseResult result = ff.parseAssignment(formStr, null);

		if (!result.hasProblem()){
			return result.getParsedAssignment();
		}

		return parseFormula(element, ff, attributeType, markerDisplay);
	}

	/**
	 * Parses the formula stored in the given element.
	 * @param element the formula element
	 * @param ff the formula factory
	 * @param typeEnvironment
	 * @param markerDisplay the marker display
	 * @return the parsed formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> parseFormula(IFormulaElement element,
			FormulaFactory ff, IAttributeType.String attributeType, IMarkerDisplay markerDisplay)throws CoreException {
//		IAttributeType.String attributeType = EventBTheoryTranslatorAttributes.FORMULA_ATTRIBUTE;
		String form = element.getFormula();
		IParseResult result = ff.parseExpressionPattern(form, null);
		if(result.hasProblem()){
			result = ff.parsePredicatePattern(form, null);
			if (CoreUtilities.issueASTProblemMarkers(element,
					attributeType, result, markerDisplay)){
				return null;
			}
			return result.getParsedPredicate();
		}
		return result.getParsedExpression();
	}

	/**
	 * Type checks the formula.
	 * @param element the formula element
	 * @param formula the actual formula
	 * @param typeEnvironment the type environment
	 * @param markerDisplay the marker display
	 * @return the type checked formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> checkFormula(IFormulaElement element, Formula<?> formula,
			ITypeEnvironment typeEnvironment, IAttributeType.String attributeType,
			IMarkerDisplay markerDisplay)throws CoreException {
		ITypeCheckResult tcResult = formula.typeCheck(typeEnvironment);
		if(CoreUtilities.issueASTProblemMarkers(element,
				attributeType, tcResult, markerDisplay)){
			return null;
		}
		return formula;
	}

	/**
	 * Parses the formula stored in the given element.
	 * @param element the formula element
	 * @param ff the formula factory
	 * @param typeEnvironment
	 * @param markerDisplay the marker display
	 * @return the parsed formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> parseFormula(ITypeFormulaElement element,
			FormulaFactory ff, IAttributeType.String attributeType, IMarkerDisplay markerDisplay)throws CoreException {
//		IAttributeType.String attributeType = EventBTheoryTranslatorAttributes.FORMULA_ATTRIBUTE;
		String form = element.getTypeFormula();
		IParseResult result = ff.parseExpressionPattern(form, null);
		if(result.hasProblem()){
			result = ff.parsePredicatePattern(form, null);
			if (CoreUtilities.issueASTProblemMarkers(element,
					attributeType, result, markerDisplay)){
				return null;
			}
			return result.getParsedPredicate();
		}
		return result.getParsedExpression();
	}

	/**
	 * Type checks the formula.
	 * @param element the formula element
	 * @param formula the actual formula
	 * @param typeEnvironment the type environment
	 * @param markerDisplay the marker display
	 * @return the type checked formula, or <code>null</code>
	 * @throws CoreException
	 */
	public static Formula<?> checkFormula(ITypeFormulaElement element, Formula<?> formula,
			ITypeEnvironment typeEnvironment, IAttributeType.String attributeType,
			IMarkerDisplay markerDisplay)throws CoreException {
		ITypeCheckResult tcResult = formula.typeCheck(typeEnvironment);
		if(CoreUtilities.issueASTProblemMarkers(element,
				attributeType, tcResult, markerDisplay)){
			return null;
		}
		return formula;
	}

}
