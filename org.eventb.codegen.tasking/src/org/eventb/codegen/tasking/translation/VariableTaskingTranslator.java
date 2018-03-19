package org.eventb.codegen.tasking.translation;

import org.eclipse.emf.common.util.EMap;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Variable;

public class VariableTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		Variable actualIn = (Variable)source;
		VariableDecl actualOut = translationManager.getIL1Factory().createVariableDecl();
				
		EMap<String, Attribute> atts = actualIn.getAttributes();
		actualOut.setIdentifier(actualIn.getName());
		
		return actualOut;		
	}
	
	

	/* (non-Javadoc)
	 * 
	 * Want to remember translation, so Invariant translation can pick it up later
	 * 
	 * @see org.eventb.codegen.tasking.translation.AbstractTaskingTranslator#canStoreTranslationInTranslationManager()
	 */
	public boolean canStoreTranslationInTranslationManager()
	{
		return true;
	}

}
