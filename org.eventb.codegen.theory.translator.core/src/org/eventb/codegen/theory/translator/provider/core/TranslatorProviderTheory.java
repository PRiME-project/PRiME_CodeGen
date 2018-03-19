/**
 *
 */
package org.eventb.codegen.theory.translator.provider.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.provider.AbstractTranslatorProvider;
import org.eventb.codegen.il1.translator.provider.IL1FormulaRulesVisitor;
import org.eventb.codegen.il1.translator.provider.ITranslationRule;
import org.eventb.codegen.il1.translator.provider.TranslatorProviderManager;
import org.eventb.codegen.theory.translator.core.ISCTranslatorElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorRuleElement;
import org.eventb.codegen.theory.translator.core.ISCTranslatorTypeRuleElement;
import org.eventb.codegen.theory.translator.core.ITranslatorElement;
import org.eventb.codegen.theory.translator.core.ITranslatorRuleElement;
import org.eventb.codegen.theory.translator.core.utils.Messages;
import org.eventb.codegen.theory.translator.core.utils.Utils;
import org.eventb.core.IEventBProject;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.IParseResult;
import org.eventb.core.ast.ITypeCheckResult;
import org.eventb.core.ast.ITypeEnvironment;
import org.eventb.core.ast.ITypeEnvironmentBuilder;
import org.eventb.theory.core.IDeployedTheoryRoot;
import org.eventb.theory.core.ISCDirectOperatorDefinition;
import org.eventb.theory.core.ISCMetavariable;
import org.eventb.theory.core.ISCNewOperatorDefinition;
import org.eventb.theory.core.ISCOperatorArgument;
import org.eventb.theory.core.ITheoryRoot;
import org.eventb.theory.core.IUseTheory;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

/**
 * @author renatosilva
 *
 */
public class TranslatorProviderTheory extends AbstractTranslatorProvider {

	private List<IDeployedTheoryRoot> deployRootList = new ArrayList<IDeployedTheoryRoot>();
	private final IInternalElementType<IDeployedTheoryRoot> rootElementType = IDeployedTheoryRoot.ELEMENT_TYPE;

	
	/**
	 *
	 */
	public TranslatorProviderTheory() {
	}

	private void loadAvailableDeployTheories(IEventBProject project) {
		deployRootList.clear();
		try {
			deployRootList.addAll(Arrays.asList(project.getRodinProject().getRootElementsOfType(rootElementType)));
			loadMathExtensions(project);
		} catch (RodinDBException e) {
			Utils.log(e, Messages.exception_RetrievingDeployedTheoryRoot + " " + project.toString());
			e.printStackTrace();
		}
	}

	private void loadMathExtensions(IEventBProject project) throws RodinDBException{
		IRodinProject rodinProj = project.getRodinProject().getRodinDB().getRodinProject("MathExtensions");

		// get the list of theories
		if(rodinProj!=null)
			deployRootList.addAll(Arrays.asList(rodinProj.getRootElementsOfType(rootElementType)));
		
		
		// project.getRodinProject().getRootElementsOfType(theoryPath_);
		
		List<IDeployedTheoryRoot> arr = new ArrayList<IDeployedTheoryRoot>();
		
		// iterate through the theories and order imports first 
		Iterator<IDeployedTheoryRoot> iter = deployRootList.iterator();
		while(iter.hasNext()){
			IDeployedTheoryRoot tr = iter.next();
			IUseTheory[] usedTheories = tr.getUsedTheories();
			for(IUseTheory usedTheory: usedTheories){
				IDeployedTheoryRoot deployedTheory = usedTheory.getUsedTheory();
				if(!arr.contains(deployedTheory)){
					arr.add(deployedTheory);
				}
			}
			if(!arr.contains(tr)){
				arr.add(tr);
			}
		}
		
		// replace the unordered theory list with the ordered one
		deployRootList.clear();
		for(IDeployedTheoryRoot dep: arr){
			deployRootList.add(dep);
		}
		
		
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslatorProvider#getRules(java.lang.String)
	 */
	@Override
	public List<ITranslationRule> getRules(TargetLanguage targetLanguage, IEventBProject eventBProject) throws CoreException {
		loadAvailableDeployTheories(eventBProject);
		List<ITranslationRule> translationRulesList = new ArrayList<ITranslationRule>();

		for(IDeployedTheoryRoot root: deployRootList){
						
			ISCTranslatorElement[] translatorElements = root.getChildrenOfType(ISCTranslatorElement.ELEMENT_TYPE);
			
						
			if(translatorElements.length==0)
				continue;

			FormulaFactory ff = root.getFormulaFactory();
			ITypeEnvironment typeEnvironment = root.getTypeEnvironment(ff);
			for(ISCTranslatorElement translatorElement:translatorElements){
				ITypeEnvironmentBuilder innerTypeEnvironment = typeEnvironment.makeBuilder();
				for (ISCMetavariable scMetaVariable :translatorElement.getSCMetavariables()){
					innerTypeEnvironment.addName(scMetaVariable.getIdentifierString(), scMetaVariable.getType(ff));
				}
				String scTargetLanguage = translatorElement.getSCTargetLanguage();
				if(scTargetLanguage.equalsIgnoreCase(targetLanguage.getCoreLanguage()))
					translationRulesList.addAll(getTranslationRule(translatorElement, targetLanguage,ff,innerTypeEnvironment));
			}
		}

		return translationRulesList;//.toArray(new ITranslationRule[translationRulesList.size()]);
	}
	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslatorProvider#getRules(java.lang.String)
	 */
	@Override
	public List<ITranslationRule> getDirectRules(TargetLanguage targetLanguage, IEventBProject eventBProject, List<ITranslationRule> translationRules) throws CoreException {
		loadAvailableDeployTheories(eventBProject);
		List<ITranslationRule> translationRulesList = new ArrayList<ITranslationRule>();

		for(IDeployedTheoryRoot root: deployRootList){
			FormulaFactory ff = root.getFormulaFactory();
			ITypeEnvironment typeEnvironment = root.getTypeEnvironment(ff);
			
			ISCNewOperatorDefinition[] operatorElements = root.getChildrenOfType(ISCNewOperatorDefinition.ELEMENT_TYPE);
			if(operatorElements.length==0)
				continue;
			
			for(ISCNewOperatorDefinition operatorElement:operatorElements){
				ITypeEnvironmentBuilder innerTypeEnvironment = typeEnvironment.makeBuilder();
				for (ISCOperatorArgument operatorArgument :operatorElement.getOperatorArguments()){
					innerTypeEnvironment.addName(operatorArgument.getIdentifierString(), operatorArgument.getType(ff));
				}
				ITranslationRule directTranslationRule = getDirectTranslationRule(operatorElement, targetLanguage,ff,innerTypeEnvironment, translationRules);
				boolean exist = false;
				for (ITranslationRule translationRule : translationRules) {
					if (translationRule.getFormula().toString().startsWith(operatorElement.getLabel())){
						exist = true;
						break;
					}
				}
				if (!exist)
					translationRulesList.add(directTranslationRule);
			}
		}
		
		return translationRulesList;//.toArray(new ITranslationRule[translationRulesList.size()]);
	}
	
	private ITranslationRule getDirectTranslationRule(ISCNewOperatorDefinition operatorElement,TargetLanguage targetLanguage, FormulaFactory ff, ITypeEnvironment typeEnvironment, List<ITranslationRule> translationRules) throws CoreException {
		TranslatorProviderManager translatorProviderManager = TranslatorProviderManager.getInstance();
		ITranslationRule rule = translatorProviderManager.getTranslationRule(targetLanguage, typeEnvironment);
		ISCDirectOperatorDefinition[] scOperatordefinitions;
		try {
			scOperatordefinitions = operatorElement.getDirectOperatorDefinitions();
			// only one direct definition is accepted as a direct translation
			if (scOperatordefinitions.length > 1)
				return rule;

			ISCDirectOperatorDefinition scOperatordefinition = scOperatordefinitions[0];
			Formula<?> operatorDefFormula = scOperatordefinition.getSCFormula(ff, typeEnvironment);
			String translation = operatorDefFormula.toString();
			assert operatorDefFormula != null;
			Formula<?> scFormula = getSCFormula(operatorElement, ff, typeEnvironment, translationRules);
			assert scFormula!=null;			
			rule.setFormula(scFormula);
			rule.setName(operatorElement.getLabel());
			
			IL1FormulaRulesVisitor formulaVisitor = new IL1FormulaRulesVisitor(operatorDefFormula.toString(), typeEnvironment, translationRules, false);
			String translatedExpression = formulaVisitor.translate();
			if(!translatedExpression.equals(operatorDefFormula.toString())){
				translation = translatedExpression;
			}
			
			rule.setTranslation(translation);
		} catch (RodinDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rule;
	}

	private List<ITranslationRule> getTranslationRule(ISCTranslatorElement translatorElement,TargetLanguage targetLanguage, FormulaFactory ff, ITypeEnvironment typeEnvironment) throws CoreException{
		List<ITranslationRule> translationRulesList = new ArrayList<ITranslationRule>();
		ISCTranslatorRuleElement[] scTranslatorRules = translatorElement.getSCTranslatorRules();
		TranslatorProviderManager translatorProviderManager = TranslatorProviderManager.getInstance();

		for(ISCTranslatorRuleElement scTranslatorRule:scTranslatorRules){
			ITranslationRule rule = translatorProviderManager.getTranslationRule(targetLanguage, typeEnvironment);
			Formula<?> scFormula = scTranslatorRule.getSCFormula(ff, typeEnvironment);
			assert scFormula!=null;
			rule.setFormula(scFormula);
			rule.setName(scTranslatorRule.getLabel());
			rule.setTranslation(scTranslatorRule.getSCTranslation());
			translationRulesList.add(rule);
		}

		return translationRulesList;
	}

	private List<ITranslationRule> getTranslationTypeRule(ISCTranslatorElement scTranslatorElement,TargetLanguage targetLanguage, FormulaFactory ff, ITypeEnvironment typeEnvironment) throws RodinDBException{
		List<ITranslationRule> translationTypeRulesList = new ArrayList<ITranslationRule>();
		ISCTranslatorTypeRuleElement[] scTranslatorTypeRules = scTranslatorElement.getSCTranslatorTypeRules();
		TranslatorProviderManager translatorProviderManager = TranslatorProviderManager.getInstance();

		for(ISCTranslatorTypeRuleElement scTranslatorTypeRule:scTranslatorTypeRules){
			ITranslationRule rule = translatorProviderManager.getTranslationTypeRule(targetLanguage, typeEnvironment);
			Formula<?> scFormula = scTranslatorTypeRule.getSCTypeFormula(ff, typeEnvironment);
			assert scFormula!=null;
			rule.setFormula(scFormula);
			rule.setName(scTranslatorTypeRule.getLabel());
			rule.setTranslation(scTranslatorTypeRule.getSCTranslation());
			translationTypeRulesList.add(rule);
		}

		return translationTypeRulesList;
	}

	@Override
	public List<ITranslationRule> getTypeRules(
			TargetLanguage targetLanguage, IEventBProject eventBProject)
			throws CoreException {
		loadAvailableDeployTheories(eventBProject);
		List<ITranslationRule> translationTypeRulesList = new ArrayList<ITranslationRule>();

		for(IDeployedTheoryRoot root: deployRootList){
			ISCTranslatorElement[] translatorElements = root.getChildrenOfType(ISCTranslatorElement.ELEMENT_TYPE);
			if(translatorElements.length==0)
				continue;

			FormulaFactory ff = root.getFormulaFactory();
			ITypeEnvironment typeEnvironment = root.getTypeEnvironment(ff);
			for(ISCTranslatorElement translatorElement:translatorElements){
				ITypeEnvironmentBuilder innerTypeEnvironment = typeEnvironment.makeBuilder();
				for (ISCMetavariable meta :translatorElement.getSCMetavariables()){
					innerTypeEnvironment.addName(meta.getIdentifierString(), meta.getType(ff));
				}
				String scTargetLanguage = translatorElement.getSCTargetLanguage();
				if(scTargetLanguage.equalsIgnoreCase(targetLanguage.getCoreLanguage()))
					translationTypeRulesList.addAll(getTranslationTypeRule(translatorElement, targetLanguage,ff,innerTypeEnvironment));
			}
		}

		return translationTypeRulesList;//.toArray(new ITranslationRule[translationRulesList.size()]);

	}
	
	private Formula<?> getSCFormula(ISCNewOperatorDefinition operatorElement, FormulaFactory ff, ITypeEnvironment typeEnvironment, List<ITranslationRule> translationRules) throws RodinDBException {		
		String formula = operatorElement.getLabel();		
		formula = formula.concat("(");		
		for (ISCOperatorArgument operatorArgument : operatorElement.getOperatorArguments()){		
			formula = formula.concat(operatorArgument.getElementName().toString());		
			formula = formula.concat(",");		
		}		
		formula = formula.concat(")");		
		formula = formula.replace(",)", ")");		
				
		//Formula<?> scFormula = AstUtilities.parseFormula(formula, true, ff);		
		Formula<?> scFormula = parseFormulaAndAssignments(formula, ff, true);		
		if (scFormula == null) {		
			return null;		
		}		
		ITypeCheckResult result = scFormula.typeCheck(typeEnvironment);		
		if (result.hasProblem()) {		
			return null;		
		}		
		return scFormula;		
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
				res = ff.parsePredicate(formStr,  null);		
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
