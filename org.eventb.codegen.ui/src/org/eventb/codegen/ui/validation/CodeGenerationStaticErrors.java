package org.eventb.codegen.ui.validation;

import org.eventb.codegen.ui.validation.errors.InParameterDefinitionError;
import org.eventb.codegen.ui.validation.errors.MultipleTaskBodyError;
import org.eventb.codegen.ui.validation.errors.MultipleTaskTypeError;
import org.eventb.codegen.ui.validation.errors.MultipleTaskingElementsError;
import org.eventb.codegen.ui.validation.errors.MultipleTypingError;
import org.eventb.codegen.ui.validation.errors.OutParameterDefinitionError;
import org.eventb.codegen.ui.validation.errors.ParameterDirectionError;
import org.eventb.codegen.ui.validation.errors.PossiblyIncorrectNonTypingWarning;
import org.eventb.codegen.ui.validation.errors.PossiblyIncorrectTypingWarning;
import org.eventb.codegen.ui.validation.errors.TaskBodyDescriptiveError;
import org.eventb.codegen.ui.validation.errors.TaskingContextError;
import org.eventb.codegen.ui.validation.errors.TypingError;

public class CodeGenerationStaticErrors 
{
	static MultipleTaskingElementsError multipleTaskingElements = new MultipleTaskingElementsError();
	static MultipleTaskTypeError multipleTaskType = new MultipleTaskTypeError();
	static MultipleTaskBodyError multipleTaskBody = new MultipleTaskBodyError();
	static TaskBodyDescriptiveError taskBodyDescriptiveError = new TaskBodyDescriptiveError();
	static ParameterDirectionError parameterDirectionError = new ParameterDirectionError();
	static TypingError typingError = new TypingError();
	static MultipleTypingError multipleTypingError = new MultipleTypingError();
	static InParameterDefinitionError inParameterDefinitionError = new InParameterDefinitionError();
	static OutParameterDefinitionError outParameterDefinitionError = new OutParameterDefinitionError();
	static PossiblyIncorrectNonTypingWarning possiblyIncorrectNonTypingWarning = new PossiblyIncorrectNonTypingWarning();
	static PossiblyIncorrectTypingWarning possiblyIncorrectTypingWarning = new PossiblyIncorrectTypingWarning();
	static TaskingContextError taskingContextError = new TaskingContextError(); 
}
