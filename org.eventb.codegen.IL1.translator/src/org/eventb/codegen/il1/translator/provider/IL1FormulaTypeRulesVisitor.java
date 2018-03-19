/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.core.runtime.IStatus;
import org.eventb.codegen.il1.translator.internal.provider.TranslationBinder;
import org.eventb.codegen.il1.translator.utils.TranslatorProblem;
import org.eventb.codegen.il1.translator.utils.TranslatorUtils;
import org.eventb.core.ast.Assignment;
import org.eventb.core.ast.AssociativeExpression;
import org.eventb.core.ast.AssociativePredicate;
import org.eventb.core.ast.AtomicExpression;
import org.eventb.core.ast.BecomesEqualTo;
import org.eventb.core.ast.BecomesMemberOf;
import org.eventb.core.ast.BecomesSuchThat;
import org.eventb.core.ast.BinaryExpression;
import org.eventb.core.ast.BinaryPredicate;
import org.eventb.core.ast.BoolExpression;
import org.eventb.core.ast.BoundIdentDecl;
import org.eventb.core.ast.BoundIdentifier;
import org.eventb.core.ast.Expression;
import org.eventb.core.ast.ExtendedExpression;
import org.eventb.core.ast.ExtendedPredicate;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.FreeIdentifier;
import org.eventb.core.ast.ISpecialization;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.IntegerLiteral;
import org.eventb.core.ast.LiteralPredicate;
import org.eventb.core.ast.MultiplePredicate;
import org.eventb.core.ast.Predicate;
import org.eventb.core.ast.QuantifiedExpression;
import org.eventb.core.ast.QuantifiedPredicate;
import org.eventb.core.ast.RelationalPredicate;
import org.eventb.core.ast.SetExtension;
import org.eventb.core.ast.SimplePredicate;
import org.eventb.core.ast.UnaryExpression;
import org.eventb.core.ast.UnaryPredicate;
//import org.eventb.core.ast.extensions.pm.IBinding;
import org.eventb.core.ast.extensions.pm.Matcher;

/**
 * @author renatosilva
 *
 */
public class IL1FormulaTypeRulesVisitor extends AbstractIL1FormulaRuleVisitor {

	private String identifier;

	public IL1FormulaTypeRulesVisitor(String identifier, String type,
			ITypeEnvironment typeEnvironment,
			List<ITranslationRule> translatorTypeRules, boolean issueMessages) {
		super(type, typeEnvironment,translatorTypeRules, issueMessages);
		assert (type != null);
		this.identifier = identifier;
	}

	/**
	 * Translates the <code>inputTypeDeclaration</code> and output the translation
	 *
	 * @return
	 * 		the value of the type after translation or an empty string in
	 *         case the type was not translated
	 */
	@Override
	public String translate() {
		if (null != inputFormula)
			inputFormula.accept(this);
		return outputFormula;
	}

	@Override
	public void visitBecomesEqualTo(BecomesEqualTo assignment) {
		executeTranslationAssignment(assignment);
	}

	@Override
	public void visitBecomesMemberOf(BecomesMemberOf assignment) {
		// Limited support: enumerated INT or BOOL
		executeTranslationAssignment(assignment);
	}

	@Override
	public void visitBecomesSuchThat(BecomesSuchThat assignment) {
		// Not supported
	}

	@Override
	public void visitBoundIdentDecl(BoundIdentDecl boundIdentDecl) {
		// Not supported
	}

	@Override
	public void visitAssociativeExpression(AssociativeExpression expression) {
		boolean simpleTranslation = true;
		Map<Formula<?>, String> binder = new HashMap<Formula<?>, String>();
		for (Expression expressionChild : expression.getChildren()) {
			IL1FormulaTypeRulesVisitor il1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
					identifier, expressionChild.toString(), typeEnvironment,
					rules,false);
			String expressionChildTranslation = il1FormulaVisitor.translate();
			binder.put(expressionChild, expressionChildTranslation);
			if (simpleTranslation
					&& !expressionChildTranslation.equals(expressionChild
							.toString()))
				simpleTranslation = false;
		}

		if (!simpleTranslation) {
			executeTranslation(expression, binder);
		} else {
			executeTranslation(expression);
		}
	}

	@Override
	public void visitAtomicExpression(AtomicExpression expression) {
		executeTranslation(expression);
	}

	@Override
	public void visitBinaryExpression(BinaryExpression expression) {
		Formula<?> left = expression.getLeft();
		String leftTranslation = left.toString();
		Formula<?> right = expression.getRight();
		String rightTranslation = right.toString();
		Map<Formula<?>, String> binder = new TreeMap<Formula<?>, String>(
				new TranslatorComparator());

		IL1FormulaTypeRulesVisitor leftIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, left.toString(), typeEnvironment,
				rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaTypeRulesVisitor rightIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, right.toString(), typeEnvironment,
				rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if (!leftTranslation.equals(left.toString())
				|| !rightTranslation.equals(right.toString())) {
			executeTranslation(expression, binder);
		} else {
			executeTranslation(expression);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,expression,TranslatorProblem.TranslationTypeNotFound,expression);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,expression);
		}
	}

	@Override
	public void visitBoolExpression(BoolExpression expression) {
		executeTranslation(expression);
	}

	@Override
	public void visitIntegerLiteral(IntegerLiteral expression) {
		// was:
		// Do nothing
		// :: how on earth did this 'ever' work ??
		
		// now set the outputFormula to the literal value
		outputFormula = expression.getValue().toString();
	}

	@Override
	public void visitQuantifiedExpression(QuantifiedExpression expression) {
		// Ignore
	}

	@Override
	public void visitSetExtension(SetExtension expression) {
		// Ignore
	}

	@Override
	public void visitUnaryExpression(UnaryExpression expression) {
		// Ignore
	}

	@Override
	public void visitBoundIdentifier(BoundIdentifier identifierExpression) {
		// Not supported
	}

	@Override
	public void visitFreeIdentifier(FreeIdentifier identifierExpression) {
		// was:
		// Do nothing
		// :: how on earth did this 'ever' work ??
		
		// now set the outputFormula to the identifier string
		outputFormula = identifierExpression.getName();
	}

	@Override
	public void visitAssociativePredicate(AssociativePredicate predicate) {
		boolean simpleTranslation = true;
		Map<Formula<?>, String> binder = new HashMap<Formula<?>, String>();
		for (Predicate predicateChild : predicate.getChildren()) {
			IL1FormulaTypeRulesVisitor il1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
					identifier, predicateChild.toString(), typeEnvironment,
					rules,false);
			String predicateChildTranslation = il1FormulaVisitor.translate();
			binder.put(predicateChild, predicateChildTranslation);
			if (simpleTranslation
					&& !predicateChildTranslation.equals(predicateChild
							.toString()))
				simpleTranslation = false;
		}

		if (!simpleTranslation) {
			executeTranslation(predicate, binder);
		} else {
			executeTranslation(predicate);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TranslationTypeNotFound,predicate);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,);
		}
	}

	@Override
	public void visitBinaryPredicate(BinaryPredicate predicate) {
		Formula<?> left = predicate.getLeft();
		String leftTranslation = left.toString();
		Formula<?> right = predicate.getRight();
		String rightTranslation = right.toString();
		Map<Formula<?>, String> binder = new TreeMap<Formula<?>, String>(
				new TranslatorComparator());

		IL1FormulaTypeRulesVisitor leftIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, left.toString(), typeEnvironment,
				rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaTypeRulesVisitor rightIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, right.toString(), typeEnvironment,
				rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if (!leftTranslation.equals(left.toString())
				|| !rightTranslation.equals(right.toString())) {
			executeTranslation(predicate, binder);
		} else {
			executeTranslation(predicate);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TranslationTypeNotFound,predicate);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,predicate);
		}
	}

	@Override
	public void visitLiteralPredicate(LiteralPredicate predicate) {
		executeTranslation(predicate);
	}

	@Override
	public void visitMultiplePredicate(MultiplePredicate predicate) {
		boolean simpleTranslation = true;
		Map<Formula<?>, String> binder = new HashMap<Formula<?>, String>();
		for (Expression expressionChild : predicate.getChildren()) {
			IL1FormulaTypeRulesVisitor il1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
					identifier, expressionChild.toString(), typeEnvironment,
					rules,false);
			String predicateChildTranslation = il1FormulaVisitor.translate();
			binder.put(expressionChild, predicateChildTranslation);
			if (simpleTranslation
					&& !predicateChildTranslation.equals(expressionChild
							.toString()))
				simpleTranslation = false;
		}

		if (!simpleTranslation) {
			executeTranslation(predicate, binder);
		} else {
			executeTranslation(predicate);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TranslationTypeNotFound,predicate);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,predicate);
		}
	}

	@Override
	public void visitQuantifiedPredicate(QuantifiedPredicate predicate) {
		// Not supported
	}

	@Override
	public void visitRelationalPredicate(RelationalPredicate predicate) {
		Formula<?> left = predicate.getLeft();
		String leftTranslation = left.toString();
		Formula<?> right = predicate.getRight();
		String rightTranslation = right.toString();
		Map<Formula<?>, String> binder = new TreeMap<Formula<?>, String>(
				new TranslatorComparator());

		IL1FormulaTypeRulesVisitor leftIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, left.toString(), typeEnvironment,
				rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaTypeRulesVisitor rightIl1FormulaVisitor = new IL1FormulaTypeRulesVisitor(
				identifier, right.toString(), typeEnvironment,
				rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if (!leftTranslation.equals(left.toString())
				|| !rightTranslation.equals(right.toString())) {
			executeTranslation(predicate, binder);
		} else {
			executeTranslation(predicate);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TranslationTypeNotFound,predicate);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,predicate);
		}
	}

	@Override
	public void visitSimplePredicate(SimplePredicate predicate) {
		// Not supported
	}

	@Override
	public void visitUnaryPredicate(UnaryPredicate predicate) {
		// Ignore
		}

	@Override
	public void visitExtendedExpression(ExtendedExpression expression) {
		executeTranslation(expression);



		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,expression,TranslatorProblem.TranslationTypeNotFound,expression);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,expression);
		}
	}

	@Override
	public void visitExtendedPredicate(ExtendedPredicate predicate) {
		FreeIdentifier[] freeIdentifiers = predicate.getFreeIdentifiers();
		for (FreeIdentifier freeIdentifier : freeIdentifiers) {
			if (freeIdentifier.getName().equals(identifier)) {
				executeTranslation(predicate);
				break;
			}
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TranslationTypeNotFound,predicate);
//			TranslatorUtils.log(Messages.bind(Messages.userTranslationTypeNotFound, inputFormulaString), IStatus.ERROR,predicate);
		}
	}

	public String getTranslatedFormula() {
		return outputFormula;
	}

	private void executeTranslation(Formula<?> predicate,Map<Formula<?>, String> binder) {
		
		//Matcher matcher = new Matcher(ff);
		Matcher matcher = new Matcher();
		String tempTranslatedFormula = predicate.toString();

		for (ITranslationRule rule : rules) {
			Formula<?> r = rule.getFormula();
			if(!r.getFactory().equals(predicate.getFactory())){
				FormulaFactory ff = predicate.getFactory();
				if(!(r instanceof Assignment) && r.isTranslatable(ff))
					r = r.translate(ff);
				}

			ISpecialization bind = null;
			if(r.getFactory().equals(predicate.getFactory()))
			bind = Matcher.match(predicate, r); // pattern = Formula (lhs)
			if (null != bind) {
				if (TranslationBinder.getExpressionMapping(bind).size()+ TranslationBinder.getPredicateMapping(bind).size() > 0)
					tempTranslatedFormula = TranslationBinder.bind(rule.getTranslation(), bind); // resulting
				else
					outputFormula = rule.getTranslation();
				break;
			}
		}

		outputFormula = TranslationBinder.bind(tempTranslatedFormula,binder);
	}

	private void executeTranslationAssignment(Assignment assignment) {
		assert assignment != null;
		Map<FreeIdentifier, String> assignmentCommands = new LinkedHashMap<FreeIdentifier, String>();

		if (assignment instanceof BecomesMemberOf) {
			for (FreeIdentifier assignedIdentifier : assignment
					.getAssignedIdentifiers()) {
				assignmentCommands.putAll(getAssignmentCommand(
						assignedIdentifier,
						((BecomesMemberOf) assignment).getSet(), assignment));
			}
		} else if (assignment instanceof BecomesEqualTo) {
			BecomesEqualTo localAssignment = (BecomesEqualTo) assignment;
			FreeIdentifier[] assignedIdentifiers = assignment
					.getAssignedIdentifiers();
			for (int i = 0; i < localAssignment.getExpressions().length; i++) {
				Expression expression = localAssignment.getExpressions()[i];
				assignmentCommands.putAll(getAssignmentCommand(
						assignedIdentifiers[i], expression, assignment));
			}
		}

		for (Entry<FreeIdentifier, String> entry : assignmentCommands
				.entrySet()) {
			if (!entry.getValue().trim().isEmpty())
				outputFormula += entry.getValue() + STATEMENT_SEPARATOR;
		}

		if (!outputFormula.trim().isEmpty())
			outputFormula = outputFormula.substring(0,outputFormula.lastIndexOf(STATEMENT_SEPARATOR));
	}

	/**
	 * Returns the corresponding commands for the expression and
	 * assignedIdentifier sent as argument.
	 *
	 * @param assignedIdentifier
	 *            identifier to be assigned
	 * @param expression
	 *            expression associated with this assignment
	 * @param assignement
	 *            the assignment
	 * @return a Map<FreeIdentifier, String> containing the translated commands
	 *         for this assignment
	 */
	private Map<FreeIdentifier, String> getAssignmentCommand(
			FreeIdentifier assignedIdentifier, Expression expression,
			Assignment assignement) {
		Map<FreeIdentifier, String> assignmentCommands = new LinkedHashMap<FreeIdentifier, String>();
		Matcher matcher = new Matcher();
		Assignment assign = null;

		if (assignement instanceof BecomesEqualTo)
			assign = ff.makeBecomesEqualTo(assignedIdentifier, expression, null);
		else if (assignement instanceof BecomesMemberOf)
			assign = (BecomesMemberOf) assignement;// ff.makeBecomesMemberOf(assignedIdentifier,
		else // other assignment are not supported
			return assignmentCommands;

		Predicate baPredicate = assign.getBAPredicate();

		// Check if there is a matching translationRule for this assignment
		String assignmentString = assign.toString();
		for (ITranslationRule rule : rules) {
			if (!(rule.getFormula() instanceof Assignment)) {
				continue;
			}
			Assignment assignementRule = (Assignment) rule.getFormula();
			Predicate assignmentPredicate = assignementRule.getBAPredicate();
			if(!baPredicate.getFactory().equals(assignmentPredicate.getFactory())){
				FormulaFactory ff = assignmentPredicate.getFactory();
				baPredicate = baPredicate.translate(ff);
				}
			ISpecialization bind = Matcher.match(baPredicate, assignmentPredicate); // pattern = Formula (lhs)
			if (null != bind) {
				if (TranslationBinder.getExpressionMapping(bind).size()+ TranslationBinder.getPredicateMapping(bind).size() > 0) {
				//if(bind.getFreeIdentifiers().length+bind.getPredicateVariables().length>0){
					assignmentString = TranslationBinder.bindAssignment(
							rule.getTranslation(), bind, assignedIdentifier,
							addTypingTranslation(bind)); // resulting
					// translation rule
					// (rhs)
					assignmentCommands
					.put(assignedIdentifier, assignmentString);
				} else {
					assignmentCommands.put(assignedIdentifier,
							rule.getTranslation());
				}

				break;
			}
		}

		// Check if there is a translation rule for this expression
		IL1FormulaTypeRulesVisitor formulaVisitor = new IL1FormulaTypeRulesVisitor(identifier, expression.toString(), typeEnvironment,rules,false);
		String translatedExpression = formulaVisitor.translate();

		// If an expression translation exists, then substitute in the
		// assignment
		if (!translatedExpression.trim().isEmpty()
				&& !translatedExpression
				.equalsIgnoreCase(expression.toString())) {
			Map<Formula<?>, String> binderMap = new HashMap<Formula<?>, String>();
			binderMap.put(expression, translatedExpression);
			assignmentString = TranslationBinder.bind(assignmentString,
					binderMap);
			assignmentCommands.put(assignedIdentifier, assignmentString);
		}

		// If there have not been any substitution, then do a "normal"
		// assignment
		if (!assignmentCommands.containsKey(assignedIdentifier)
				&& !translatedExpression.trim().isEmpty()) {
			assignmentCommands.put(assignedIdentifier, assignedIdentifier
					+ VARIABLE_ASSIGNMENT_OPERATOR + translatedExpression);
		}

		return assignmentCommands;
	}

//	/**
//	 * Check if the expressionTranslated match to a existing typeRule
//	 *
//	 * @param bind
//	 * @return Map<FreeIdentifier, String> containing the additional type
//	 *         translations
//	 */
//	private Map<FreeIdentifier, String> addTypingTranslation(IBinding bind) {
//		Map<FreeIdentifier, Expression> expressionMappings = bind.getExpressionMappings();
//		Map<FreeIdentifier, String> typingMappings = new HashMap<FreeIdentifier, String>();
//
//		for (Entry<FreeIdentifier, Expression> entry : expressionMappings.entrySet()) {
//			FreeIdentifier identifier = entry.getKey();
//			Expression expressionTranslated = entry.getValue();
//
//			IL1FormulaTypeRulesVisitor formulaVisitor = new IL1FormulaTypeRulesVisitor(
//					identifier.toString(), expressionTranslated.toString(),
//					typeEnvironment, rules,false);
//			String translatedExpression = formulaVisitor.translate();
//			if (!translatedExpression.trim().isEmpty())
//				typingMappings.put(identifier, translatedExpression);
//		}
//
//		return typingMappings;
//	}

}
