package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Output;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.tasking.TaskingTranslationUnhandledTypeException;
import org.eventb.emf.core.EventBElement;

public class OutputTaskingTranslator  extends AbstractTaskingTranslator{

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationUnhandledTypeException {
		
		
		Output out = Il1Factory.eINSTANCE.createOutput();
		compositeControl.Output actualSource = (compositeControl.Output)source;
		
		out.setText(actualSource.getText());
		
		if (actualSource.getElement() != null)
		{
			out.setElement(actualSource.getElement().getName());
		}
		
		return out;
		
	}

}
