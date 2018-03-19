package org.eventb.tasking.persistence.synchroniser;

import static org.eventb.tasking.persistence.TaskingAttributes.TASK_BODY_ATTRIBUTE;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.codegen.taskbodybuilder.ParseException;
import org.eventb.codegen.taskbodybuilder.TextToEMFParser;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CoreFactory;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.ITaskBody;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Task;
import tasking.TaskingPackage;
import tasking.impl.TaskImpl;
import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.CompositeControlFactory;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;

/**
 * This will take the task body string from the Rodin database and produce a tree of Task body elements that are 
 * put in the Task body
 * @author Chris
 *
 */
public class TaskBodySynchroniser extends AbstractSynchroniser {
	
	//	The elements that this thing can return as the top level EMF element
	private enum TopLevelType
	{
		SEQ,
		DO,
		BRANCH,
		EVENT_WRAPPER,
		OUTPUT,
		NONE_SET
	};
	
	private TopLevelType top;
	private IInternalElementType<?> rodinType = ITaskBody.ELEMENT_TYPE;
	private Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();
	
	public TaskBodySynchroniser() {
		handledAttributes.add(TASK_BODY_ATTRIBUTE);
	}
	

	@Override
	protected EventBElement createEventBElement() {
		switch(top)
		{
			case SEQ:
				return CompositeControlFactory.eINSTANCE.createSeq();
			case DO:
				return CompositeControlFactory.eINSTANCE.createDo();
			case BRANCH:
				return CompositeControlFactory.eINSTANCE.createBranch();
			case EVENT_WRAPPER:
				return CompositeControlFactory.eINSTANCE.createEventWrapper();
			case OUTPUT:
				return CompositeControlFactory.eINSTANCE.createOutput();
			case NONE_SET:
				return CompositeControlFactory.eINSTANCE.createSeq();	//	Can't return null, as it kills everything. So an empty Seq is just as good.
		}
		
		//	Everything is going to have a Seq at the top now - temporarily not the case...
		return CompositeControlFactory.eINSTANCE.createSeq();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return TaskingPackage.eINSTANCE.getTask_TaskBody();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return rodinType;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {		
		return handledAttributes;
	}
	
	@Override
	/**
	 * Only load if the parent is a Task machine (i.e. not a shared machine)
	 */
	public <T extends EventBElement> EventBElement load(
			IRodinElement rodinElement, EventBElement emfParent,
			IProgressMonitor monitor) throws CoreException 
	{
		if (rodinElement instanceof ITaskBody && emfParent instanceof TaskImpl)
		{
			//	Define the top level element
			String taskBody = ((ITaskBody)rodinElement).getTaskBody();
			
			//	Expand the element
			try {
				//	Generate the EMF task body tree
				String projectName = rodinElement.getRodinProject().getElementName();
				CompositeControl generated = convertRodinToEMF((Task)emfParent, taskBody, projectName);
				
				//	Determine the top level type
				if (generated instanceof EventWrapper)
				{
					top = TopLevelType.EVENT_WRAPPER;
				}
				else if (generated instanceof Seq)
				{
					top = TopLevelType.SEQ;
				}
				else if (generated instanceof Do)
				{
					top = TopLevelType.DO;					
				}
				else if (generated instanceof Branch)
				{
					top = TopLevelType.BRANCH;
				}
				else if (generated instanceof Output)
				{
					top = TopLevelType.OUTPUT;
				}
				else if (generated == null)
				{
					top = TopLevelType.NONE_SET;
				}
				
				//	Load the element
				EventBElement eventBElement = super.load(rodinElement, emfParent, monitor);
				
				//	Update the element so it contains the generated block
				//((Seq)eventBElement).setLeftBranch(generated);
				
				//	Also need to copy elements from the Rodin object!
				
				if (eventBElement instanceof Seq && generated instanceof Seq)
				{
					((Seq)eventBElement).setLeftBranch(((Seq)generated).getLeftBranch());
					((Seq)eventBElement).setRightBranch(((Seq)generated).getRightBranch());
				}
				else if (eventBElement instanceof EventWrapper && generated instanceof EventWrapper)
				{
					((EventWrapper)eventBElement).setEventName(((EventWrapper)generated).getEventName());
				}
				else if (eventBElement instanceof Do && generated instanceof Do)
				{
					((Do)eventBElement).setFinally(((Do)generated).getFinally());
					((Do)eventBElement).setTaskBody(((Do)generated).getTaskBody());
					
				}
				else if (eventBElement instanceof Branch && generated instanceof Branch)
				{
					((Branch)eventBElement).setAlt(((Branch)generated).getAlt());
					((Branch)eventBElement).setEventWrapper(((Branch)generated).getEventWrapper());
					((Branch)eventBElement).setSubBranch(((Branch)generated).getSubBranch());					
				}
				else if (eventBElement instanceof Output && generated instanceof Output)
				{
					((Output)eventBElement).setVariableName(((Output)generated).getVariableName());
					((Output)eventBElement).setText(((Output)generated).getText());
				}
				
				
				//	Update the parent task to say that it was generated from a TaskBody
				Annotation taskBodyAnnotation = CoreFactory.eINSTANCE.createAnnotation();
				taskBodyAnnotation.setSource("TaskBody");
				emfParent.getAnnotations().add(taskBodyAnnotation);
				
				return eventBElement;
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}				
		}
		
		return null;
	}
	
	@Override
	/**
	 * Will never be called as we do not have a TaskBody EMF element.
	 */
	public IRodinElement save(EventBElement emfElement,
			IRodinElement rodinParent, IProgressMonitor monitor)
			throws RodinDBException
	{
		return null;
		
	}
	
	
	/**
	 * Takes the parent EMF element and the given task body and generates the 
	 * EMF for the task body.
	 * 
	 * This should be run before super.load, to get the top level EMF type that this thing should generate.
	 * 
	 * @param topElement Generated by load
	 * @param taskBody Obtained from the TaskBody taskBody attribute.
	 * @param projectName 
	 * @throws ParseException 
	 */
	private CompositeControl convertRodinToEMF(Task emfParent, String taskBody, String projectName) throws UnsupportedEncodingException, RodinDBException, ParseException
	{
		//	Use Renato's TextToEMFParser to do this
		TextToEMFParser parser = new TextToEMFParser(taskBody, emfParent, projectName);

		if (parser.validParsingGrammar())
			return parser.validateInputAndGenerateEMF();
		return null;
	}
	

	
	

}
