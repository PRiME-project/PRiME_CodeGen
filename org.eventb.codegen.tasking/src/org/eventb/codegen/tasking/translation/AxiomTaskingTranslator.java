package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.EQUALS_SYMBOL;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.Axiom;
import org.eventb.emf.core.context.impl.AxiomImpl;
import org.eventb.emf.core.context.impl.ContextImpl;


public class AxiomTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		Axiom actualSource = (Axiom) source;

		ContextImpl parentContext = TaskingTranslationManager
				.getParentContext(actualSource);
		String contextName = parentContext.getName();
		String projectName = translationManager.getProjectName(parentContext);

		Declaration actualTarget = null;

		EList<AbstractExtension> ext = actualSource.getExtensions();
		boolean isTypingAxiom = false;
		boolean isExpaning = false;
		
		//ignore expanding axioms
		if(actualSource instanceof AxiomImpl)
		{
			Attribute expanding = actualSource.getAttributes().get("org.eventb.codegen.ui.branchingAttribute");
			String typingAttribute = (String) expanding.getValue();		//	The value: Typing/NonTyping
			
			if (typingAttribute.equals("Expanded"))
			{
				isExpaning = true;
			}			

		}
		
		//	See if it is a typing axiom
		if (actualSource.getAttributes().size() > 0)
		{						
			Attribute attr = actualSource.getAttributes().get(CodeGenTasking.TYPING_ATTRIBUTE_IDENT);
			if (attr != null)
			{
				String typingAttribute = (String) attr.getValue();		//	The value: Typing/NonTyping
				
				if (typingAttribute.equals("Typing"))
				{
					isTypingAxiom = true;
				}			
			}
		}
		
		boolean isEnum = isEnumeration(actualSource);

		// handle typing axioms, but not enums if someone has attached a typing
		// annotation to an enum.
		if (!isEnum && isTypingAxiom && !isExpaning) {
			ConstantDecl newConstantDecl = Il1Factory.eINSTANCE
					.createConstantDecl();
			// get the name from the typing predicate
			String pred = actualSource.getPredicate();
			int loc = pred.indexOf(ELEMENT_OF);
			String id = pred.substring(0, loc).trim();
			newConstantDecl.setIdentifier(id);
			String type = pred.substring(pred.lastIndexOf(ELEMENT_OF) + 1,
					pred.length());
			newConstantDecl.setType(type.trim());

			// And anything else that is required - see getConstantDecls in
			// MachineTaskingTranslator
			newConstantDecl.setComponentName(contextName);
			newConstantDecl.setProjectName(projectName);

			// find the initialisation from the context's axioms
			EList<Axiom> axioms = parentContext.getAxioms();
			for (Axiom axiom : axioms) {
				
				//ignore expanding axioms 
				boolean expanding = false;
				for(Entry<String, Attribute> a : axiom.getAttributes())
				{
					if(a.getKey().equals("org.eventb.codegen.ui.branchingAttribute"))
					{
						if(a.getValue().getValue().equals("Expanded"))
						expanding = true;
					}
				}
				if(expanding)
					continue;
				
				String prd = axiom.getPredicate();
				prd = prd.trim();

				// cName must be at the start and be the only token,
				// or be followed by =
				if ((prd.startsWith(id + " ") && (prd.contains(EQUALS_SYMBOL)))
						|| prd.startsWith(id + EQUALS_SYMBOL)) {
					String substr = prd.substring(
							prd.lastIndexOf(EQUALS_SYMBOL) + 1, prd.length());
					newConstantDecl.setInitialValue(substr.trim());
					break;
				}
			}
			actualTarget = newConstantDecl;

		} else if (isEnum && isTypingAxiom) {
			// Now handle the enumerations
			Enumeration enumeration = Il1Factory.eINSTANCE.createEnumeration();
			enumeration.setComponentName(contextName);
			enumeration.setProjectName(projectName);

			// create the identifier and literals from the partition
			String pred = actualSource.getPredicate().substring(10);
			int endIndex = pred.indexOf(",");
			String id = pred.substring(0, endIndex);
			String literals = pred.substring(endIndex + 1, pred.length());
			enumeration.setIdentifier(id);
			String[] literalArray = literals.split("[{]");

			for (int i = 0; i < literalArray.length; i++) {
				String partialLiteral = literalArray[i].trim();
				int endIdx = partialLiteral.indexOf("}");
				if (endIdx != -1) {
					String literal = partialLiteral.substring(0, endIdx);
					enumeration.getLiteralValues().add(literal);
				}
			}
			actualTarget = enumeration;
		}
		return actualTarget;
	}

	protected boolean isEnumeration(Axiom axiom) {
		if (axiom.getPredicate().startsWith("partition("))
			return true;
		else
			return false;
	}

}
