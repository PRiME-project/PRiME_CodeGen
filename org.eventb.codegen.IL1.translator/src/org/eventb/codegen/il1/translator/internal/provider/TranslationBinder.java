/**
 *
 */
package org.eventb.codegen.il1.translator.internal.provider;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jregex.MatchResult;
import jregex.Replacer;
import jregex.Substitution;
import jregex.TextBuffer;

import org.eventb.core.ast.Expression;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.FormulaFactory;
import org.eventb.core.ast.FreeIdentifier;
import org.eventb.core.ast.Predicate;
import org.eventb.core.ast.PredicateVariable;
import org.eventb.core.ast.Type;
import org.eventb.core.ast.ISpecialization;
//import org.eventb.core.ast.extensions.pm.;
//import org.eventb.core.ast.extensions.pm.IBinding;

/**
 * @author renatosilva
 *
 */
public class TranslationBinder {

	private static StringBuilder patternSb = new StringBuilder();

	/**
	 * Returns the output string resulting from binding the pattern by the given binding.
	 *
	 *
	 * @param pattern
	 *            the pattern in the form of a string.
	 * @param binding
	 *            the binding
	 * @return the resultant string
	 */
	public static String bind(String pattern, ISpecialization binding, Map<FreeIdentifier, String> typingMappings) {
		assert binding!=null;
		patternSb = new StringBuilder(pattern);

		TreeMap<String,String> mapSubs = buildMapSubs(binding, typingMappings, null);

		return applyReplacement(mapSubs);
	}


	/**
	 * Returns the output string resulting from binding the pattern by the given binding.
	 *
	 *
	 * @param pattern
	 *            the pattern in the form of a string.
	 * @param binding
	 *            the binding
	 * @return the resultant string
	 */
	public static String bind(String pattern, ISpecialization binding) {
		assert binding!=null;
		patternSb = new StringBuilder(pattern);

		TreeMap<String,String> mapSubs = buildMapSubs(binding, null, null);

		return applyReplacement(mapSubs);
	}

	/**
	 * Returns the output string resulting from binding the pattern by the given binding.
	 *
	 *
	 * @param pattern
	 *            the pattern in the form of a string.
	 * @param binding
	 *            the binding
	 * @param assignedIdentifier
	 * @return the resultant string
	 */
	public static String bindAssignment(String pattern, ISpecialization binding, FreeIdentifier assignedIdentifier) {
		assert binding!=null;
		patternSb = new StringBuilder(pattern);

		TreeMap<String,String> mapSubs = buildMapSubs(binding, null, assignedIdentifier);

		return applyReplacement(mapSubs);
	}

	/**
	 * Returns the output string resulting from binding the pattern by the given binding.
	 *
	 *
	 * @param pattern
	 *            the pattern in the form of a string.
	 * @param binding
	 *            the binding
	 * @param assignedIdentifier
	 * @return the resultant string
	 */
	public static String bindAssignment(String pattern, ISpecialization binding, FreeIdentifier assignedIdentifier, Map<FreeIdentifier, String> typingMappings) {
		assert binding!=null;
		patternSb = new StringBuilder(pattern);
		TreeMap<String,String> mapSubs = buildMapSubs(binding, typingMappings, assignedIdentifier);

		return applyReplacement(mapSubs);
	}

	/**
	 * Returns the output string resulting from binding the pattern by the given binderMap.
	 *
	 * @param pattern
	 * 			the pattern in the form of a string.
	 * @param binderMap
	 * 			the binding map
	 * @return
	 * 			the resultant string
	 */
	public static String bind(String pattern, Map<Formula<?>, String> binderMap) {
		assert binderMap!=null;
		String output = pattern;

		for(Entry<Formula<?>,String> entry :binderMap.entrySet()){
			Formula<?> formula = entry.getKey();
			String expressionTranslated = entry.getValue();

			//Optimisation: if there is no translation to do, continue
			if(formula.toString().equals(expressionTranslated))
				continue;

			output = replacePattern(formula.toString(), expressionTranslated, output);
		}

		return output;
	}

	/**
	 * Find all the symbols contained in the <code>input</code> and mask them, replaced <code>pattern</code> with <code>replacement</code>
	 * and return the corresponding <code>output</code>
	 *
	 * @param pattern
	 * @param replacement
	 * @param output
	 * @return
	 */
	public static String replacePattern(String pattern, String replacement, String input){
		StringBuilder outputSb = new StringBuilder(input);
		StringBuilder formulaInput = maskSymbols(pattern);

		//Replacement
		outputSb = regexReplace(formulaInput.toString(), outputSb, replacement);

		return outputSb.toString();
	}

	/**
	 * Predicate variables will have appended backslashes to avoid conflicts during replacement
	 *
	 * @param input
	 * @return String corresponding to the input with the symbols masked
	 */
	private static String maskPredicateVariable(final String input){
		StringBuilder matchSymbol = new StringBuilder(PredicateVariable.LEADING_SYMBOL);
		String predicateVarMasked = input;
		if(predicateVarMasked.contains(matchSymbol)){
			StringBuilder matchSymbolReplacement = new StringBuilder("\\"+PredicateVariable.LEADING_SYMBOL);
			predicateVarMasked = predicateVarMasked.replace(matchSymbol, matchSymbolReplacement);
		}

		return predicateVarMasked;
	}


	/**
	 * //All the non-characters and non-digits and non-spaces will have appended backslashes to avoid conflicts during replacement
	 *
	 * @param input
	 * @return StringBuilder corresponding to the input with the symbols masked
	 */
	private static StringBuilder maskSymbols(final String input){
		StringBuilder matcherInput = new StringBuilder(input);

		//	Below says anything that is not A-Z or a-z, not 0-9 and not ' ', or is > or <
		//	But should also say and not > or <
		//	As > and < should not have a \ put before them, as the jregex.Pattern.replace will not work for something like y < 3 in more complex expressions
		//	eg. �(y<3) && �(z<=4) given as a single string
		//	strangely, �(y<3) would work if given on it's own using old version (and new version)
//		Pattern p = Pattern.compile("[\\W&&\\D&&\\S|(>|<)]{1}");

		Pattern p = Pattern.compile("[(\\W&&\\D&&\\S&&[^(>|<)])|\\(|\\)|\\+]{1}");
		Matcher matcher = p.matcher(matcherInput);
		StringBuffer formulaInput = new StringBuffer();
		while (matcher.find()) {
			String group = matcher.group();
			matcher.appendReplacement(formulaInput,"\\\\"+group);
		}
		matcher.appendTail(formulaInput);

		return new StringBuilder(formulaInput);
	}

	private static String replaceAllPrimeIdentifier(String predicateInput, FreeIdentifier freeIdentifier, FormulaFactory ff){
		StringBuilder output = new StringBuilder(predicateInput);
		output = regexReplace(freeIdentifier.getName(), output , freeIdentifier.withPrime().toString());
		return output.toString();//predicateInput.replaceAll(freeIdentifier.getName(), freeIdentifier.withPrime(ff).toString());
	}

	private static StringBuilder regexReplace(final String key, StringBuilder outputSb, final String replacement){
		jregex.Pattern pp=new jregex.Pattern("("+key+")");
		Substitution substitution=new Substitution(){
			@Override
			public void appendSubstitution(MatchResult match,TextBuffer tb){
				boolean validReplacement = true;
				jregex.Pattern pp1=new jregex.Pattern("[\\w]{1}");

				int start = match.start();
				if(start !=0){
					char charAt = match.target().charAt(start-1);
					String stringPrefix = String.valueOf(charAt);
					jregex.Matcher m1=pp1.matcher(stringPrefix);
					if(m1.find()){
						validReplacement = false;
						match.getGroup(MatchResult.MATCH,tb);
					}
				}

				if(validReplacement && match.suffix().trim().length()>0){
					int end = match.end();
					char charAt = match.target().charAt(end);
					String stringSuffix = String.valueOf(charAt);
					jregex.Matcher m1=pp1.matcher(stringSuffix);
					if(m1.find()){
						validReplacement = false;
						match.getGroup(MatchResult.MATCH,tb);
					}
				}

				if(validReplacement){
					tb.append(replacement);
				}
			}
		};
		Replacer replacer=new Replacer(pp,substitution);
		String output = replacer.replace(outputSb.toString());

		return new StringBuilder(output);
	}

	private static String buildRegex(int i){
//		new Random(i);
		return "_#_"+i+"_#_";
	}

	/**
	 * Builds a Map of the substitutions  and updates the pattern StringBuilder <code>patternSb</code>
	 *
	 * @param binding
	 * @return Map of the substitutions for expressions
	 */
	private static TreeMap<String,String> buildMapSubs(ISpecialization binding, Map<FreeIdentifier, String> typingMappings, FreeIdentifier assignedIdentifier){
		TreeMap<String,String> mapSubs = new TreeMap<String, String>();
		int regexIndex = 0;

		mapSubs.putAll(buildMapSubsExpression(getExpressionMapping(binding), regexIndex, typingMappings, assignedIdentifier,binding.getFactory()));
		mapSubs.putAll(buildMapSubsPredicate(getPredicateMapping(binding), mapSubs.size()));

		return mapSubs;
	}

	/**
	 * Builds a Map of the substitutions for predicateVariables and updates the pattern StringBuilder <code>patternSb</code>
	 *
	 * @param predicateMapping
	 * @param startingRegexIndex
	 * @return Map of the substitutions for expressions
	 */
	private static TreeMap<String,String> buildMapSubsPredicate(Map<PredicateVariable,Predicate> predicateMapping,int startingRegexIndex){
		TreeMap<String,String> mapSubs = new TreeMap<String, String>();
		for(Entry<PredicateVariable,Predicate> entry: predicateMapping.entrySet()){
			PredicateVariable predicateVar = entry.getKey();
			Predicate predicateTranslated = entry.getValue();

			//Optimisation: if there is no translation to do, continue
			if(predicateVar.toString().equals(predicateTranslated.toString()))
				continue;

			String regex = buildRegex(startingRegexIndex);
			String predicateVarMasked = maskPredicateVariable(predicateVar.getName());
			patternSb = regexReplace(predicateVarMasked, patternSb, regex);

			//Map of regexs to ensure that there is no clash or invalid replacements after
			mapSubs.put(regex, predicateTranslated.toString());
			startingRegexIndex++;
		}

		return mapSubs;
	}

	/**
	 * Builds a Map of the substitutions for expressions and updates the pattern StringBuilder <code>patternSb</code>
	 *
	 * @param expressionMapping
	 * @param startingRegexIndex
	 * @return Map of the substitutions for expressions
	 */
	private static TreeMap<String,String> buildMapSubsExpression(Map<FreeIdentifier, Expression> expressionMapping, int startingRegexIndex, Map<FreeIdentifier, String> typingMappings, FreeIdentifier assignedIdentifier, FormulaFactory ff){
		TreeMap<String,String> mapSubs = new TreeMap<String, String>();

		for(Entry<FreeIdentifier,Expression> entry: expressionMapping.entrySet()){
			FreeIdentifier identifier = entry.getKey();
			Expression expressionTranslated = entry.getValue();

			//Optimisation: if there is no translation to do, continue
			if(identifier.toString().equals(expressionTranslated.toString()))
				continue;

			String regex = buildRegex(startingRegexIndex);
//			if(assignedIdentifier==null)
//				patternSb = regexReplace(identifier.getName(), patternSb, regex);
			String regexValue = expressionTranslated.toString();
			if(typingMappings!=null && typingMappings.containsKey(identifier))
				regexValue = typingMappings.get(identifier);

			//Because it is an assignment, make sure that the assigned variable is also primed in the pattern (patternSb) to be found by regex
			if(assignedIdentifier!=null && expressionTranslated.equals(assignedIdentifier.withPrime())){
				patternSb = new StringBuilder(replaceAllPrimeIdentifier(patternSb.toString(), identifier.withoutPrime(), ff));
				regexValue = assignedIdentifier.toString();//((FreeIdentifier)expressionTranslated).withoutPrime(binding.getFormulaFactory()).toString();
			}

			patternSb = regexReplace(identifier.getName(), patternSb, regex);
			//Map of regexs to ensure that there is no clash or invalid replacements after
			mapSubs.put(regex, regexValue);
			startingRegexIndex++;
		}

		return mapSubs;
	}

	private static String applyReplacement(TreeMap<String,String> mapSubs){
		String output = patternSb.toString();
		NavigableMap<String, String> descendingMap = mapSubs.descendingMap();
		for(Entry<String,String> entry: descendingMap.entrySet()){
			output = output.replaceAll(entry.getKey(), entry.getValue());
		}

		return output.toString();
	}
	
	

	public static Map<FreeIdentifier, Expression> getExpressionMapping(ISpecialization bind){
		Map<FreeIdentifier, Expression> map = new HashMap<FreeIdentifier, Expression>();
		
		for(FreeIdentifier id : bind.getFreeIdentifiers())
			map.put(id, bind.get(id));
		
		return map;
	}
	
	public static Map<PredicateVariable, Predicate> getPredicateMapping(ISpecialization bind){
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

}
