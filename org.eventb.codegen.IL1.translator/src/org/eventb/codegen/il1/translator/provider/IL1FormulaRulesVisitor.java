/**
 *
 */
package org.eventb.codegen.il1.translator.provider;

import java.util.HashMap;
import java.util.Iterator;
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
import org.eventb.core.ast.GivenType;
import org.eventb.core.ast.ISpecialization;
import org.eventb.core.ast.ITypeCheckResult;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.core.ast.IntegerLiteral;
import org.eventb.core.ast.LiteralPredicate;
import org.eventb.core.ast.MultiplePredicate;
import org.eventb.core.ast.Predicate;
import org.eventb.core.ast.PredicateVariable;
import org.eventb.core.ast.QuantifiedExpression;
import org.eventb.core.ast.QuantifiedPredicate;
import org.eventb.core.ast.RelationalPredicate;
import org.eventb.core.ast.SetExtension;
import org.eventb.core.ast.SimplePredicate;
import org.eventb.core.ast.Type;
import org.eventb.core.ast.UnaryExpression;
import org.eventb.core.ast.UnaryPredicate;
import org.eventb.core.ast.extension.IFormulaExtension;
import org.eventb.core.ast.extensions.pm.Matcher;

/**
 * @author renatosilva
 * @author <b>htson</b> Use ITypeEnvironmentBuilder instead of ITypeEnvironment (due to
 *         API changed).
 */
public class IL1FormulaRulesVisitor extends AbstractIL1FormulaRuleVisitor{

	public IL1FormulaRulesVisitor(String formula, ITypeEnvironment typeEnvironment, List<ITranslationRule> rules, boolean issueMessages) {
		super(formula, typeEnvironment,rules,issueMessages);
	}

	@Override
	public void visitBecomesEqualTo(BecomesEqualTo assignment) {
		executeTranslationAssignment(assignment);
	}

	@Override
	public void visitBecomesMemberOf(BecomesMemberOf assignment) {
		//Limited support: enumerated INT or BOOL
		executeTranslationAssignment(assignment);
	}

	@Override
	public void visitBecomesSuchThat(BecomesSuchThat assignment) {
		//Not supported
	}

	@Override
	public void visitBoundIdentDecl(BoundIdentDecl boundIdentDecl) {
		// Not supported
	}

	@Override
	public void visitAssociativeExpression(AssociativeExpression expression) {
		boolean simpleTranslation = true;
		Map<Formula<?>,String> binder = new HashMap<Formula<?>,String>();
		for(Expression expressionChild: expression.getChildren()){
			IL1FormulaRulesVisitor il1FormulaVisitor = new IL1FormulaRulesVisitor(expressionChild.toString(), typeEnvironment, rules,false);
			String expressionChildTranslation = il1FormulaVisitor.translate();
			binder.put(expressionChild, expressionChildTranslation);
			if(simpleTranslation && !expressionChildTranslation.equals(expressionChild.toString()))
				simpleTranslation = false;
		}

		if(!simpleTranslation){
			executeTranslation(expression,binder);
		}
		else {
			executeTranslation(expression);
		}

		//add parentheses to the output
		outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);

		if(issueMessages && outputFormula.trim().isEmpty())
			TranslatorUtils.log(IStatus.INFO,expression,TranslatorProblem.TraslationNotFound,expression);
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
		Map<Formula<?>,String> binder = new TreeMap<Formula<?>,String>(new TranslatorComparator());

		IL1FormulaRulesVisitor leftIl1FormulaVisitor = new IL1FormulaRulesVisitor(TranslatorUtils.surroundWithParentheses(left.toString()), typeEnvironment, rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaRulesVisitor rightIl1FormulaVisitor = new IL1FormulaRulesVisitor(right.toString(), typeEnvironment, rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if(!leftTranslation.equals(left.toString()) || !rightTranslation.equals(TranslatorUtils.surroundWithParentheses(right.toString()))){
			executeTranslation(expression,binder);
		}
		else {
			executeTranslation(expression);
		}

		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages )
			TranslatorUtils.log(IStatus.INFO,expression,TranslatorProblem.TraslationNotFound,expression);
	}

	@Override
	public void visitBoolExpression(BoolExpression expression) {
		executeTranslation(expression);
	}

	@Override
	public void visitIntegerLiteral(IntegerLiteral expression) {
		executeTranslation(expression);
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
		executeTranslation(expression);
		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages)
			TranslatorUtils.log(IStatus.INFO,expression,TranslatorProblem.TraslationNotFound,expression);
	}

	@Override
	public void visitBoundIdentifier(BoundIdentifier identifierExpression) {
		// Not supported?
	}

	@Override
	public void visitFreeIdentifier(FreeIdentifier identifierExpression) {
		// Do nothing
	}

	@Override
	public void visitAssociativePredicate(AssociativePredicate predicate) {
		boolean simpleTranslation = true;
		Map<Formula<?>,String> binder = new HashMap<Formula<?>,String>();
		for(Predicate predicateChild: predicate.getChildren()){
			IL1FormulaRulesVisitor il1FormulaVisitor = new IL1FormulaRulesVisitor(TranslatorUtils.surroundWithParentheses(predicateChild.toString()), typeEnvironment, rules,false);
			String predicateChildTranslation = il1FormulaVisitor.translate();
			binder.put(predicateChild, predicateChildTranslation);
			if(simpleTranslation && !predicateChildTranslation.equals(predicateChild.toString()))
				simpleTranslation = false;
		}

		if(!simpleTranslation){
			executeTranslation(predicate,binder);
		}
		else {
			executeTranslation(predicate);
		}

		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages){
			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
		}
	}

	@Override
	public void visitBinaryPredicate(BinaryPredicate predicate) {
		Formula<?> left = predicate.getLeft();
		String leftTranslation = left.toString();
		Formula<?> right = predicate.getRight();
		String rightTranslation = right.toString();
		Map<Formula<?>,String> binder = new TreeMap<Formula<?>,String>(new TranslatorComparator());

		IL1FormulaRulesVisitor leftIl1FormulaVisitor = new IL1FormulaRulesVisitor(left.toString(), typeEnvironment, rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaRulesVisitor rightIl1FormulaVisitor = new IL1FormulaRulesVisitor(right.toString(), typeEnvironment, rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if(!leftTranslation.equals(left.toString()) || !rightTranslation.equals(right.toString())){
			executeTranslation(predicate,binder);
		}
		else {
			executeTranslation(predicate);
		}

		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages){
			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
		}
	}

	@Override
	public void visitLiteralPredicate(LiteralPredicate predicate) {
		executeTranslation(predicate);
	}

	@Override
	public void visitMultiplePredicate(MultiplePredicate predicate) {
		boolean simpleTranslation = true;
		Map<Formula<?>,String> binder = new HashMap<Formula<?>,String>();
		for(Expression expressionChild: predicate.getChildren()){
			IL1FormulaRulesVisitor il1FormulaVisitor = new IL1FormulaRulesVisitor(expressionChild.toString(), typeEnvironment, rules,false);
			String predicateChildTranslation = il1FormulaVisitor.translate();
			binder.put(expressionChild, predicateChildTranslation);
			if(simpleTranslation && !predicateChildTranslation.equals(expressionChild.toString()))
				simpleTranslation = false;
		}

		if(!simpleTranslation){
			executeTranslation(predicate,binder);
		}
		else {
			executeTranslation(predicate);
		}

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
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
		Map<Formula<?>,String> binder = new TreeMap<Formula<?>,String>(new TranslatorComparator());

		IL1FormulaRulesVisitor leftIl1FormulaVisitor = new IL1FormulaRulesVisitor(left.toString(), typeEnvironment, rules,false);
		leftTranslation = leftIl1FormulaVisitor.translate();
		binder.put(left, leftTranslation);

		IL1FormulaRulesVisitor rightIl1FormulaVisitor = new IL1FormulaRulesVisitor(right.toString(), typeEnvironment, rules,false);
		rightTranslation = rightIl1FormulaVisitor.translate();
		binder.put(right, rightTranslation);

		if(!leftTranslation.equals(left.toString()) || !rightTranslation.equals(right.toString())){
			executeTranslation(predicate,binder);
		}
		else {
			executeTranslation(predicate);
		}

		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages){
			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
		}
	}

	@Override
	public void visitSimplePredicate(SimplePredicate predicate) {
		// Not supported
	}

	@Override
	public void visitUnaryPredicate(UnaryPredicate predicate) {
		Map<Formula<?>,String> binder = new TreeMap<Formula<?>,String>(new TranslatorComparator());
		Formula<?> innerFormula = predicate.getChild();

		IL1FormulaRulesVisitor innerIl1FormulaVisitor = new IL1FormulaRulesVisitor(TranslatorUtils.surroundWithParentheses(innerFormula.toString()), typeEnvironment, rules,false);
		String innerFormulaTranslation = innerIl1FormulaVisitor.translate();
		binder.put(innerFormula, innerFormulaTranslation);

		if(!innerFormulaTranslation.equals(innerFormula.toString())){
			executeTranslation(predicate,binder);
		}
		else {
			executeTranslation(predicate);
		}

		if(!outputFormula.trim().isEmpty())
			outputFormula = TranslatorUtils.surroundWithParentheses(outputFormula);
		else if(issueMessages){
			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
		}
	}

	@Override
	public void visitExtendedExpression(ExtendedExpression expression) {
		executeTranslation(expression);

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,expression,TranslatorProblem.TraslationNotFound,expression);
		}
	}

	@Override
	public void visitExtendedPredicate(ExtendedPredicate predicate) {
		executeTranslation(predicate);

		if(issueMessages && outputFormula.trim().isEmpty()){
			TranslatorUtils.log(IStatus.ERROR,predicate,TranslatorProblem.TraslationNotFound,predicate);
		}
	}

	private void executeTranslation(Formula<?> predicate,
			Map<Formula<?>, String> binder) {
		//Matcher matcher = new Matcher(ff);
		Matcher matcher = new Matcher();
		String tempTranslatedFormula = predicate.toString();
		//This binderMap is used for predicateVariables that have multiple predicates
		Map<Formula<?>,String> binderMap = new HashMap<Formula<?>, String>();

		for(ITranslationRule rule: rules){
			Formula<?> r = rule.getFormula();
			if(!r.getFactory().equals(predicate.getFactory())){
				FormulaFactory ff = predicate.getFactory();
				if(!(r instanceof Assignment) && r.isTranslatable(ff))
					r = r.translate(ff);
				}
				ISpecialization binding = null;
				if(r.getFactory().equals(predicate.getFactory()))
				binding = Matcher.match(predicate, r); //pattern = Formula (lhs)
			
			if(binding!=null){
				Map<PredicateVariable, Predicate> predicateMappings = TranslationBinder.getPredicateMapping(binding);
				if(!predicateMappings.isEmpty()){
					for(Entry<PredicateVariable, Predicate> entry: predicateMappings.entrySet()){
						IL1FormulaRulesVisitor visitor = new IL1FormulaRulesVisitor(entry.getValue().toString(), typeEnvironment, rules,false);
						String visitorTranslation = visitor.translate();
						binderMap.put(entry.getValue(), visitorTranslation);
						tempTranslatedFormula = TranslationBinder.bind(rule.getTranslation(), binding);
					}
				}
				else {
					if(TranslationBinder.getExpressionMapping(binding).size()>0){
						tempTranslatedFormula = TranslationBinder.bind(rule.getTranslation(), binding); //resulting translation rule (rhs)
					}
					else{
						tempTranslatedFormula = rule.getTranslation();
					}
					break;
				}
			}
		}

		if(binderMap.isEmpty())
			outputFormula = TranslationBinder.bind(tempTranslatedFormula, binder);
		else outputFormula = TranslationBinder.bind(tempTranslatedFormula, binderMap);

//		if(issueMessages)
//			TranslatorUtils.log(IStatus.INFO,predicate,TranslatorProblem.TraslationNotFound,predicate);
	}

	private void executeTranslationAssignment(Assignment assignment){
		assert assignment!=null;
		Map<FreeIdentifier, String> assignmentCommands =  new LinkedHashMap<FreeIdentifier,String>();

		if(assignment instanceof BecomesMemberOf){
			for(FreeIdentifier assignedIdentifier: assignment.getAssignedIdentifiers()){
				assignmentCommands.putAll(getAssignmentCommand(assignedIdentifier, ((BecomesMemberOf)assignment). getSet(), assignment));
			}
		}else if(assignment instanceof BecomesEqualTo){
			BecomesEqualTo localAssignment = (BecomesEqualTo) assignment;
			FreeIdentifier[] assignedIdentifiers = assignment.getAssignedIdentifiers();
			for(int i = 0; i<localAssignment.getExpressions().length;i++){
				Expression expression = localAssignment.getExpressions()[i];
				assignmentCommands.putAll(getAssignmentCommand(assignedIdentifiers[i], expression, assignment));
			}
		}

		for(Entry<FreeIdentifier,String> entry: assignmentCommands.entrySet()){
			outputFormula += entry.getValue() + STATEMENT_SEPARATOR;
		}

		outputFormula = outputFormula.substring(0, outputFormula.lastIndexOf(STATEMENT_SEPARATOR));
	}

	private Map<FreeIdentifier, String> getAssignmentCommand1(FreeIdentifier assignedIdentifier,Expression expression, Assignment assignement){
		Map<FreeIdentifier, String> assignmentCommands =  new LinkedHashMap<FreeIdentifier,String>();
		
		//Matcher matcher = new Matcher();
		
		Assignment assign = null;

		if(assignement instanceof BecomesEqualTo)
			assign = ff.makeBecomesEqualTo(assignedIdentifier, expression, null);
		else if(assignement instanceof BecomesMemberOf)
			assign = (BecomesMemberOf) assignement;//ff.makeBecomesMemberOf(assignedIdentifier, expression, null);
		else //other assignment are not supported
			return assignmentCommands;

		//ITypeEnvironmentBuilder newTypeEnvironment = typeEnvironment.makeBuilder();
		ITypeCheckResult result = assign.typeCheck(typeEnvironment);
		boolean typeChecked = result.isSuccess();
		Predicate baPredicate = null;

		//Check if there is a matching translationRule for this assignment
		String assignmentString = assign.toString();
		for(ITranslationRule rule: rules){
			if(!(rule.getFormula() instanceof Assignment)){
				continue;
			}
			Assignment assignementRule = (Assignment)rule.getFormula();
			Predicate assignmentPredicate = assignementRule.getBAPredicate();

			ISpecialization bind = null;

			if(typeChecked){
				baPredicate = assign.getBAPredicate();
				if(!baPredicate.getFactory().equals(assignmentPredicate.getFactory())){
					FormulaFactory ff = assignmentPredicate.getFactory();
					if(baPredicate.isTranslatable(ff))
						baPredicate = baPredicate.translate(ff);
				}
				if(baPredicate.getFactory().equals(assignmentPredicate.getFactory()))
				bind = Matcher.match(baPredicate, assignmentPredicate); //pattern = Formula (lhs)
			}
			if(bind != null){
				if(TranslationBinder.getExpressionMapping(bind).size()+TranslationBinder.getPredicateMapping(bind).size()>0){
					assignmentString = TranslationBinder.bindAssignment(rule.getTranslation(), bind, assignedIdentifier); //resulting translation rule (rhs)
					assignmentCommands.put(assignedIdentifier, assignmentString);
				}else {
					assignmentCommands.put(assignedIdentifier, rule.getTranslation());
				}
				break;
			}
		}

		
		
		//Check if there is a translation rule for this expression
		IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(expression.toString(), typeEnvironment, rules,false);
		String translatedExpression = formulaVisitor.translate();

		//If an expression translation exists, then substitute in the assignment
		if(!translatedExpression.equals(expression.toString())){
			Map<Formula<?>,String> binderMap = new HashMap<Formula<?>, String>();
			binderMap.put(expression, translatedExpression);
			assignmentString = TranslationBinder.bind(assignmentString, binderMap);
			//assignmentCommands.put(assignedIdentifier, assignmentString);
		}

		//If there have not been any substitution, then do a "normal" assignment
		if(!assignmentCommands.containsKey(assignedIdentifier)){
			assignmentCommands.put(assignedIdentifier, assignedIdentifier + VARIABLE_ASSIGNMENT_OPERATOR + translatedExpression);
		}
		
		//Check if there is a translation rule for this expression children
		if (expression instanceof ExtendedExpression){
			Expression[] expChildren = ((ExtendedExpression) expression).getChildExpressions();
			Map<Formula<?>,String> binderMap = new HashMap<Formula<?>, String>();
			for (Expression child: expChildren){
				IL1FormulaRulesVisitor formulaVisitor1 = new IL1FormulaRulesVisitor(child.toString(), typeEnvironment, rules,false);
				String translatedExpression1 = formulaVisitor1.translate();

				//If an expression translation exists, then substitute in the assignment
				if(!translatedExpression1.equals(child.toString())){
					binderMap.put(child, translatedExpression1);
				}

				//If there have not been any substitution, then do a "normal" assignment
				if(!assignmentCommands.containsKey(assignedIdentifier)){
					assignmentCommands.put(assignedIdentifier, assignedIdentifier + VARIABLE_ASSIGNMENT_OPERATOR + translatedExpression);
				}
			}

			assignmentString = TranslationBinder.bind(assignmentString, binderMap);
			assignmentCommands.put(assignedIdentifier, assignmentString);
		}

		return assignmentCommands;
	}
	
	public Map<FreeIdentifier, Expression> getExpressionMapping(ISpecialization bind){
		Map<FreeIdentifier, Expression> map = new HashMap<FreeIdentifier, Expression>();
		
		for(FreeIdentifier id : bind.getFreeIdentifiers())
			map.put(id, bind.get(id));
		
		return map;
	}
	
	public Map<PredicateVariable, Predicate> getPredicateMapping(ISpecialization bind){
		Map<PredicateVariable, Predicate> map = new HashMap<PredicateVariable, Predicate>();
		
		for(PredicateVariable id : bind.getPredicateVariables())
			map.put(id, bind.get(id));
		
		return map;
	}

	public Map<FreeIdentifier, Type> getTypeMapping(ISpecialization bind){
		Map<FreeIdentifier, Type> map = new HashMap<FreeIdentifier, Type>();
		
		for(FreeIdentifier id : bind.getFreeIdentifiers())
			map.put(id, id.getType());
		
		return map;
	}

	private Map<FreeIdentifier, String> getAssignmentCommand(FreeIdentifier assignedIdentifier,Expression expression, Assignment assignement){
		
		Map<FreeIdentifier, String> assignmentCommands =  new LinkedHashMap<FreeIdentifier,String>();
		Assignment assign = null;
	
		if(assignement instanceof BecomesEqualTo)
			assign = ff.makeBecomesEqualTo(assignedIdentifier, expression, null);
		else if(assignement instanceof BecomesMemberOf)
			assign = (BecomesMemberOf) assignement;
		else 
			return assignmentCommands;
	
		//Check if there is a translation rule for this expression
		IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(expression.toString(), typeEnvironment, rules,false);
		String translatedExpression = formulaVisitor.translate();
				
		
		ITypeCheckResult result = assign.typeCheck(typeEnvironment);
		boolean typeChecked = result.isSuccess();
		Predicate baPredicate = null;
	
		//Check if there is a matching translationRule for this assignment
		String assignmentString = assign.toString();
		for(ITranslationRule rule: rules){
			if(!(rule.getFormula() instanceof Assignment)){
				continue;
			}
			Assignment assignementRule = (Assignment)rule.getFormula();
			Predicate assignmentPredicate = assignementRule.getBAPredicate();
	
			ISpecialization bind = null;
	
			if(typeChecked){
				baPredicate = assign.getBAPredicate();
				if(!baPredicate.getFactory().equals(assignmentPredicate.getFactory())){
					FormulaFactory ff = baPredicate.getFactory();
					if(assignmentPredicate.isTranslatable(ff))
						assignmentPredicate = assignmentPredicate.translate(ff);
				}
				if(baPredicate.getFactory().equals(assignmentPredicate.getFactory()))
				bind = Matcher.match(baPredicate, assignmentPredicate); //pattern = Formula (lhs)
			}
			if(bind != null){
				if(TranslationBinder.getExpressionMapping(bind).size()+TranslationBinder.getPredicateMapping(bind).size()>0){
					assignmentString = TranslationBinder.bindAssignment(rule.getTranslation(), bind, assignedIdentifier);
					assignmentCommands.put(assignedIdentifier, assignmentString);
				}else {
					assignmentCommands.put(assignedIdentifier, rule.getTranslation());
				}
				break;
			}
		}
	
		
		
		//Check if there is a translation rule for this expression
		//IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(expression.toString(), typeEnvironment, rules,false);
		//String translatedExpression = formulaVisitor.translate();
	
		//If an expression translation exists, then substitute in the assignment
		if(!translatedExpression.equals(expression.toString())){
			Map<Formula<?>,String> binderMap = new HashMap<Formula<?>, String>();
			binderMap.put(expression, translatedExpression);
			assignmentString = TranslationBinder.bind(assignmentString, binderMap);
			assignmentCommands.put(assignedIdentifier, assignmentString);
		}
	
		//If there have not been any substitution, then do a "normal" assignment
		if(!assignmentCommands.containsKey(assignedIdentifier)){
			assignmentCommands.put(assignedIdentifier, assignedIdentifier + VARIABLE_ASSIGNMENT_OPERATOR + translatedExpression);
		}
		
		//Check if there is a translation rule for this expression children
		if (expression instanceof ExtendedExpression){
			Expression[] expChildren = ((ExtendedExpression) expression).getChildExpressions();
			Map<Formula<?>,String> binderMap = new HashMap<Formula<?>, String>();
			for (Expression child: expChildren){
				IL1FormulaRulesVisitor formulaVisitor1 = new IL1FormulaRulesVisitor(child.toString(), typeEnvironment, rules,false);
				String translatedExpression1 = formulaVisitor1.translate();
	
				//If an expression translation exists, then substitute in the assignment
				if(!translatedExpression1.equals(child.toString())){
					binderMap.put(child, translatedExpression1);
				}
	
				//If there have not been any substitution, then do a "normal" assignment
				if(!assignmentCommands.containsKey(assignedIdentifier)){
					assignmentCommands.put(assignedIdentifier, assignedIdentifier + VARIABLE_ASSIGNMENT_OPERATOR + translatedExpression);
				}
			}
	
			assignmentString = TranslationBinder.bind(assignmentString, binderMap);
			assignmentCommands.put(assignedIdentifier, assignmentString);
		}
	
		return assignmentCommands;
	}

}
