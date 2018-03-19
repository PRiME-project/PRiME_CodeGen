package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.impl.ConstantImpl;

public class ConstantTaskingTranslator extends AbstractTaskingTranslator {


	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {

		ConstantImpl actualIn = (ConstantImpl) source;
		ConstantDecl actualOut = translationManager.getIL1Factory().createConstantDecl();
				
		//	From Chris: Name has been removed, as I think it is replaced by identifier 
		actualOut.setIdentifier(actualIn.getName());
		
		return actualOut;		
	}

}
