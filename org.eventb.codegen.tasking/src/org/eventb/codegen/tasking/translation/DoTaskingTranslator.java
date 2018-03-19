package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;

import compositeControl.Do;


//	Will return a PreconditionLoop if no Finally
//	Will return a Seq if Finally is declared	
public class DoTaskingTranslator extends AbstractTaskingTranslator{
	
	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {
				
		Do actualSource = (Do)source;
		Command actualOut = null ;
		PreconditionLoop loop = null;
		
		if (actualSource.getFinally() == null)
		{
			actualOut = Il1Factory.eINSTANCE.createPreconditionLoop();		
			loop = (PreconditionLoop)actualOut;
		}
		else
		{
			actualOut = Il1Factory.eINSTANCE.createSeq();
			loop = Il1Factory.eINSTANCE.createPreconditionLoop();
			((Seq)actualOut).setLeftBranch(loop);
			
			//	Translate the finally
			IL1Element finallyRoutine = translationManager.translate(actualSource.getFinally());
			
			if (finallyRoutine instanceof Subroutine)
			{
				((Seq)actualOut).setRightBranch((Command)translationManager.copy(((Subroutine)finallyRoutine).getBody()));
			}
			else if (finallyRoutine instanceof LocalRemote)
			{
				Subroutine localSubroutine = ((LocalRemote)finallyRoutine).getLocalSubroutine();
				Subroutine remoteSubroutine = ((LocalRemote)finallyRoutine).getRemoteSubroutine();
				
				//	Add code local; remote
				((Seq)actualOut).setRightBranch(translationManager.evaluateLocalRemote(localSubroutine, remoteSubroutine));
			}
			
		}
		if (actualSource.getTaskBody() != null)
		{
	//		Subroutine routine = (Subroutine)translationManager.translate(actualSource.getTaskBody());
			IL1Element taskBody = translationManager.translate(actualSource.getTaskBody());
			
			if (taskBody instanceof Subroutine)
			{
				Subroutine routine = (Subroutine) taskBody;
				//	Add the guards
				if (routine.getGuards().size() == 0)
				{
					loop.getCondition().add("TRUE");
				}
				else
				{
					loop.getCondition().addAll(routine.getGuards());
				}
				
				//	Add the code
				//	Actions get upset if they are passed by reference and break things
				//	(they disappear elsewhere in the IL1)
				//	so copy everything, as they will probably all get upset in the same way
				loop.setBody((Command)translationManager.copy(routine.getBody()));

			}
			else if (taskBody instanceof LocalRemote)
			{		
				//	while(local_guard)
				//	local_action; call remote
				Subroutine localSubroutine = ((LocalRemote)taskBody).getLocalSubroutine();
				Subroutine remoteSubroutine = ((LocalRemote)taskBody).getRemoteSubroutine();
				
				if (localSubroutine.getGuards().size() == 0)
				{
					loop.getCondition().add("TRUE");
				}
				else
				{
					loop.getCondition().addAll(localSubroutine.getGuards());
				}
				
				//	Add code local; remote
				loop.setBody(translationManager.evaluateLocalRemote(localSubroutine, remoteSubroutine));
			}
			else
			{
				//	probably a null
			}
			
			//	Add the condition
		}
		
		return actualOut;
	}	
}
