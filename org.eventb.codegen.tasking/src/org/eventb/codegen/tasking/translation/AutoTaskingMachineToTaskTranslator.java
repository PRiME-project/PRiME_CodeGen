package org.eventb.codegen.tasking.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;

import tasking.impl.AutoTask_MachineImpl;


public class AutoTaskingMachineToTaskTranslator extends AbstractTaskingTranslator{

	@Override
	public IL1Element translate(EventBElement source, IL1Element target, TaskingTranslationManager translationManager) throws TaskingTranslationException {

		AutoTask_MachineImpl actualSource = (AutoTask_MachineImpl)source;
		
		Task task = translationManager.getIL1Factory().createTask();		
		task.setPriority(actualSource.getPriority());
				
		for (EObject obj : source.eContents())
		{
			IL1Element actualTarget = translationManager.translate(obj,null);
			
			if (actualTarget instanceof TaskType)
			{
				task.setTaskType((TaskType)actualTarget);
			}
			else if (actualTarget instanceof Declaration)
			{
				task.getDecls().add((Declaration) actualTarget);
			}
			else if (actualTarget instanceof Subroutine)
			{
				task.setBody(EcoreUtil.copy(((Subroutine)actualTarget).getBody()));				
			}
			else if(actualTarget instanceof Command)
			{
				task.setBody((Command)actualTarget);
			}
			else if (actualTarget instanceof LocalRemote)
			{
				Subroutine localSubroutine = ((LocalRemote)actualTarget).getLocalSubroutine();
				Subroutine remoteSubroutine = ((LocalRemote)actualTarget).getRemoteSubroutine();
				task.setBody(translationManager.evaluateLocalRemote(localSubroutine, remoteSubroutine));
			}									
		}
		
		
		
		
		return task;
	}

}
