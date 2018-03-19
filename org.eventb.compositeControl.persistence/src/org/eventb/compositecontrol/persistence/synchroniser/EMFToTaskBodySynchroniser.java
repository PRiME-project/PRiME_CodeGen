package org.eventb.compositecontrol.persistence.synchroniser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.taskbodybuilder.EMFToTextParser;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.eventb.tasking.persistence.ITaskBody;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinDBException;

import tasking.Task;

import compositeControl.CompositeControl;

public abstract class EMFToTaskBodySynchroniser extends AbstractSynchroniser {


	@Override
	protected IInternalElementType<?> getRodinType() {
		return ITaskBody.ELEMENT_TYPE;
	}

	@Override
	/**
	 * Takes the EMF Do and produces a TaskBody rodin element with the proper contents.
	 * This also overwrites any old style information - which is great, so long as it is loaded in correctly!
	 */
	public IRodinElement save(EventBElement emfElement, IRodinElement rodinParent, IProgressMonitor monitor) throws CoreException 
	{
		
		if (emfElement.eContainer() != null && emfElement.eContainer() instanceof Task)
		{
			
			//	Get the TaskBody element
			IRodinElement rodinElement = super.save(emfElement, rodinParent, monitor);
						
			//	Convert the EMF to a string
			convertEMFToRodin((Task)emfElement.eContainer(), (ITaskBody)rodinElement);
			
			return rodinElement;
		}
		
		//	otherwise do nothing
		//	returning null may break things though...
		return null;
	}
	
	/**
	 * Takes emf tree and the rodin element to store the data task body attribute string in.
	 * @param emfElement
	 * @param rodinElement
	 * @throws RodinDBException 
	 */
	private void convertEMFToRodin(Task task, ITaskBody rodinElement) throws RodinDBException
	{
		EMFToTextParser parser = new EMFToTextParser(task);
		String taskBodyText = parser.outputText();
		rodinElement.setTaskBody(taskBodyText);
	}
	
	
	/**
	 * States whether the load method should be used or not.
	 * All extending synchronisers should call this before continuing with their load code.
	 * Then return an abstract extension if they do not require it - also make sure to return appropriate
	 * return type.
	 * @param emfParent
	 * @return
	 */
	protected boolean canLoad(EventBElement emfParent)
	{
		//	Get the parent Task		
		while(emfParent != null && !(emfParent instanceof Task))
		{
			emfParent = (EventBElement)emfParent.eContainer();
		}
		
		if (emfParent == null)
		{
			//	There is no Task at the top - shouldn't get here unless something has gone wrong elsewhere
			
			//	although this could be true if it hasn't fininshed loading everything...? check
			return false;
		}
		
		//	Get the first CompositeControl element
		if (emfParent instanceof Task)
		{
			CompositeControl cc = ((Task) emfParent).getTaskBody();
	//		Annotation taskBodyAnnotation = cc.getAnnotation("TaskBody");	//	flag to say that the elements have been loaded from a task body
			
			if (cc == null || cc.getAnnotation("TaskBody") == null)
			{
				//	Nothing loaded yet or has been loading from old EMF stlye synchronisers
				return true;
			}
			else
			{
				return false;
			}			
		}
		
		return false;
	}


}
