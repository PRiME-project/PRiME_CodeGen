package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.codegen.tasking.utils.DeclarationList;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.Axiom;
import org.eventb.emf.core.context.Context;

public class ContextTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		Context actualSource = (Context) source;
		
		//	Set typing flags for generated elements
		fixTypingFlagsForGenerateElements(actualSource);
		
		DeclarationList declarationList = new DeclarationList();

		EList<Axiom> axioms = actualSource.getAxioms();
		// translate the axioms of extended contexts
		EList<Context> extended = actualSource.getExtends();
		for(Context ctx_proxy: extended){
			
			// resolve the proxy
			//String proxyName = ctx_proxy.getName();
			EventBElement ctx = translationManager.getEventBElementFromStore(null, ctx_proxy.getName());
			if(ctx != null){
				// recursively call the translator on extended contexts to translate #1 below
				DeclarationList extendsDecls = (DeclarationList) translate(ctx, target, translationManager);
				// add the retured declarations to the 
				declarationList.getDeclarations().addAll(extendsDecls.getDeclarations());
			}

		}
		
		// #1 
		// Translate each axiom in the current context to constant or enum declarations
		// if required.  Anything which is a partition is translated to an enum.
		// Anything that has the typing annotation added is translated to a
		// constant declaration
		for (Axiom a : axioms) {
			
//			if(a.getName().contains("_inarg")) //PRIMECHANGE
//				continue;
			
			Declaration decl = (Declaration) translationManager.translate(a);
			if(a.getName().contains("_inarg")) //PRIMECHANGE
				decl.setIdentifier("inarg_" + decl.getIdentifier());
			if (decl != null) {
				declarationList.addDeclaration(decl);
			}
		}
		return declarationList;
	}
	
	/**
	 * Sets typing flags for generated elements, so that the whole thing doesn't crash.
	 * 
	 * @param actualSource The machine being translated
	 */
	private void fixTypingFlagsForGenerateElements(Context actualSource) 
	{
		//	Check all axioms
		for (Axiom a : actualSource.getAxioms())
		{
			//	If this is a generated without typing attributes element
			if (a.isGenerated() && !CodeGenTaskingUtils.hasTypingAttribute(a))
			{
				boolean typing = false;
				//	Add the typing information to the invariant
				//	if element_of or partition, it is a typing axiom
				if (a.getPredicate().contains(ELEMENT_OF) || a.getPredicate().startsWith("partition"))
				{
					typing = true;
				}
				
				CodeGenTaskingUtils.addTaskingAttribute(a, typing);				
			}
		}
	}
}
