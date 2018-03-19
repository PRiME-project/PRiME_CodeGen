package org.eventb.codegen.ui.validation;

import static org.eventb.codegen.ui.attributes.TaskingContextAttribute.TASKING;
import static org.eventb.codegen.ui.attributes.TaskingContextAttribute.TASKING_CONTEXT_ATTRIBUTE;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.IAxiom;
import org.eventb.core.IContextRoot;
import org.eventb.core.sc.SCCore;
import org.eventb.core.sc.state.ISCStateRepository;
import org.eventb.core.tool.IModuleType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.RodinDBException;

public class ContextTaskingValidatorModule extends CodeGenerationValidatorModule {

	public static final IModuleType<TaskBodyValidatorModule> MODULE_TYPE = SCCore.getModuleType(EventBCodeGenerationUI.PLUGIN_ID + ".contextModule");
	
	public ContextTaskingValidatorModule()
	{
		
	}
	
	@Override
	public void process(IRodinElement element, IInternalElement target,
			ISCStateRepository repository, IProgressMonitor monitor)
			throws CoreException {

		//	This is where the checks are performed
		final IRodinFile contextFile = (IRodinFile) element;
		final IContextRoot contextRoot = (IContextRoot) contextFile.getRoot();
		
		
		//	Only perform checks if the context is being used in a tasking machine

		boolean isTaskingContext = false;
		if (contextRoot.hasAttribute(TASKING_CONTEXT_ATTRIBUTE) && contextRoot.getAttributeValue(TASKING_CONTEXT_ATTRIBUTE).equals(TASKING))
		{
			isTaskingContext = true;
		}
		
		
		//	Only perform this if the context is seen by a tasking machine
		if (isTaskingContext)
		{
			//	Check axioms
			final IAxiom [] axioms = (IAxiom[])contextRoot.getChildrenOfType(IAxiom.ELEMENT_TYPE);
			ArrayList<String> typedConstantNames = this.staticCheckAxiomsForTasking(axioms);			
			this.checkConstantsHaveTypes(contextRoot.getConstants(), typedConstantNames);
		}
	}

	@Override
	public IModuleType<?> getModuleType() {
		return MODULE_TYPE;
	}	
		
	private ArrayList<String> staticCheckAxiomsForTasking(IAxiom [] axioms) throws RodinDBException
	{
		ArrayList<String> leftHandNames = new ArrayList<String>();
		for (IAxiom a : axioms)
		{
			
			String pred = a.getPredicateString();
			checkTyping(a, pred, leftHandNames);
			
			
			//	Constants can also be defined in partitions, so get the names of any constants 
			//	from there and add them to list.
			if (pred.trim().startsWith("partition"))
			{
				//	Get all the types
				
				ArrayList<String> types = getPartitionTypes(pred);
				leftHandNames.addAll(types);
			}
			
			//	Typing
//			try
//			{
//				String pred = a.getPredicateString();
//				String lhs = getLeftHandSide(pred);
//				
//				String type = a.getAttributeValue(TYPING_ATTRIBUTE);
//				
//				if (type.equals(TYPE_NOT_SET))
//				{
//					createProblemMarker(a, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.typingError);
//				}
//				else if (type.equals(TYPING))
//				{
//					if (leftHandNames.contains(lhs))
//					{
//						//	this has already been typed
//						createProblemMarker(a, EventBAttributes.TYPE_ATTRIBUTE, CodeGenerationStaticErrors.multipleTypingError);	
//					}
//					
//					leftHandNames.add(lhs);
//				}
//			}
//			catch (RodinDBException exp)
//			{
//				
//			}
						
		}
		
		return leftHandNames;
	}

	private ArrayList<String> getPartitionTypes(String pred) {		
		ArrayList<String> types = new ArrayList<String>();
		//	Constants in enumerations will be in curly brackets
		//	Eg. {CONSTANT_NAME}
		for (int i = 0 ; i < pred.length();  i++)
		{
			char c = pred.charAt(i);
			
			if (c == '{')
			{
				i++;
				String type = "";
				for ( ; i < pred.length(); i++)
				{
					c = pred.charAt(i);
					if (c == '}')
					{
						break;
					}
					else
					{
						type += c;
					}						
				}
				
				
				if (!type.equals(""))
				{
					types.add(type);
				}
			}
		}
		
		return types;
	}

}
