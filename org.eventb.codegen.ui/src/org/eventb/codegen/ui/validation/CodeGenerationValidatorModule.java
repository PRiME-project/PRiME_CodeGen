package org.eventb.codegen.ui.validation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;
import static org.eventb.codegen.ui.attributes.TypingAttribute.NON_TYPING;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPE_NOT_SET;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPING;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPING_ATTRIBUTE;

import java.util.ArrayList;

import org.eventb.core.EventBAttributes;
import org.eventb.core.IConstant;
import org.eventb.core.IIdentifierElement;
import org.eventb.core.IParameter;
import org.eventb.core.IVariable;
import org.eventb.core.sc.SCProcessorModule;
import org.rodinp.core.IAttributeValue;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.RodinDBException;

public abstract class CodeGenerationValidatorModule extends SCProcessorModule {

	/**
	 * Checks the typing and issues the required errors and warnings.
	 * @param i The element to check (either Invariant, Guard or Axiom).
	 * @param predicate The predicate string.
	 * @param leftHandNames Array list to use for left hand names found. This should be used for each local block of invariants or guards. Eg. all invariants in one event.
	 */
	protected void checkTyping(IInternalElement i, String predicate,ArrayList<String> leftHandNames)
	{
//		Typing
		String lhs = getLeftHandSide(predicate);
		String type = null;		
		
		//	Will only generate errors on non-generated elements
		boolean isGenerated = false;
		try {
			IAttributeValue attr [] = i.getAttributeValues();
			
			for (IAttributeValue v : attr)
			{
				if (v.getType().getId().equals("org.eventb.core.generated"))
				{
					isGenerated = (Boolean)v.getValue();
				}
			}
		} catch (RodinDBException e) {
			e.printStackTrace();
		}
		try
		{
		
			try
			{			
				type = i.getAttributeValue(TYPING_ATTRIBUTE); 			
			}
			catch (RodinDBException exp)
			{
				//	If typing is not set it will arrive here 
				if (!isGenerated)
					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
				

				//	If generated and it will be a typing element, add the name to the left hand sides
				//	so that it registers the element as being typed
				if (isGenerated)
				{
					if (predicate.contains(ELEMENT_OF) || predicate.startsWith("partition"))
					{
						leftHandNames.add(lhs);
					}
				}
				return;
			}
		

			if (type.equals(TYPE_NOT_SET))
			{
				if (!isGenerated)
					createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
			}
			else if (type.equals(TYPING))
			{
				if (leftHandNames.contains(lhs) && !predicate.startsWith("partition"))
				{
					//	this has already been typed
					if (!isGenerated)
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTypingError);	
				}
				
				leftHandNames.add(lhs);
				
				//	Check if it contains ELEMENT_OF
				if (!predicate.contains(ELEMENT_OF) && !predicate.startsWith("partition"))
				{
					//	Add warning
					if (!isGenerated)
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectTypingWarning);
				}
			}
			else if (type.equals(NON_TYPING))
			{
				//	Check if it contains ELEMENT_OF
				if (predicate.contains(ELEMENT_OF) || predicate.startsWith("partition"))
				{
					//	Add warning
					if (!isGenerated)
						createProblemMarker(i, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.possiblyIncorrectNonTypingWarning);
				}
			}
		}
		catch (RodinDBException exp)
		{
			//	create problem marker went wrong
			System.err.println("Problem creating problem marker");
		}
	}
	
	
	public String getLeftHandSide(String pred)
	{
		//	Spaces are not always present between text and non-text
		pred = addSpacesBetweenElements(pred);
		pred = pred.trim();		
		
		if (pred.length() == 0)
			return "";
		
		String lhs = pred.split(" ")[0];
		
		return lhs.trim();
	}
	
	public String addSpacesBetweenElements(String predIn)
	{
		String pred = "";
		
		boolean lastNormal = true;
		
		for (char c : predIn.toCharArray())
		{
			
			boolean currentNormal = ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ' || c == '_' || (c >= '0' && c<='9'));
			
			if (lastNormal && currentNormal)
			{
				//	do nothing special
			}
			else if (lastNormal && !currentNormal)
			{
				// add a space
				pred += ' ';
			}
			else if (!lastNormal && currentNormal)
			{
				// do nothing special
			}
			else if (!lastNormal && !currentNormal)
			{
				//	do nothing special
			}
			
			lastNormal = currentNormal;
			pred += c;
		}
		
		return pred;
	}
	
//	/**
//	 * Checks that all invariants  
//	 * @param elements
//	 * @param leftHandSideNames
//	 */
//	protected void checkTypeFlagSet(IInvariant [] invariants, ArrayList<String> leftHandSideNames)
//	{
	
	
//	protected ArrayList<String> getVariableNames(IVariable [] variables)
//	{
//		ArrayList<String> names = new ArrayList<String>();
//		for (IVariable p : variables)
//		{
//			names.add(p.getElementName().trim());
//		}
//		
//		return names;
//	}
//	
//	protected ArrayList<String> getParameterNames(IParameter [] parameters)
//	{
//		ArrayList<String> names = new ArrayList<String>();
//		for (IParameter p : parameters)
//		{
//			names.add(p.getElementName().trim());
//		}
//		
//		return names;
//	}
//	
//	protected ArrayList<String> getConstantNames(IConstant [] constants)
//	{
//		ArrayList<String> names = new ArrayList<String>();
//		for (IConstant p : constants)
//		{
//			names.add(p.getElementName().trim());
//		}
//		
//		return names;
//	}
		
	/**
	 * Checks that all parameters have been typed.
	 * @param parameters The list of parameters.
	 * @param typedParameterNames The names of the parameters that have been confirmed typed by checkTyping.
	 */
	protected void checkParametersHaveTypes(IParameter [] parameters, ArrayList<String> typedParameterNames)
	{
		checkElementsHaveTypes(parameters, typedParameterNames);		
	}
	
	protected void checkConstantsHaveTypes(IConstant [] constants, ArrayList<String> typedConstantNames)
	{
		checkElementsHaveTypes(constants, typedConstantNames);
	}
	
	protected void checkVariablesHaveTypes(IVariable [] variables, ArrayList<String> typedVariableNames)
	{
		checkElementsHaveTypes(variables, typedVariableNames);
	}
	
	protected void checkElementsHaveTypes(IIdentifierElement [] elements, ArrayList<String> typedElementNames)
	{
		for (IIdentifierElement e : elements)
		{
			try
			{
				String identifier = e.getIdentifierString().trim();
				
				if (!typedElementNames.contains(identifier))
				{					
						createProblemMarker(e, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);					
				}
			}
			catch (RodinDBException e1)
			{
				
			}
		}
	}

}
