package org.eventb.codegen.tasking.translation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.NOT_SYMBOL;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Skip;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;

import compositeControl.Branch;

public class BranchTaskingTranslator extends AbstractTaskingTranslator {

	private static ArrayList<String> parentGuards = new ArrayList<String>();

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		If actualTarget = Il1Factory.eINSTANCE.createIf();
		Branch actualSource = (Branch)source;
		Event evt = actualSource.getEventWrapper().getEvent();
		actualTarget.setRelatedEvent(evt);
		//	Translate the 'events'
		//Subroutine subEvent = (Subroutine)translationManager.translate(actualSource.getEventWrapper());
		IL1Element translatedEvent = translationManager.translate(actualSource.getEventWrapper());
		if (translatedEvent instanceof Subroutine)
		{
			Subroutine subEvent = (Subroutine) translatedEvent;
			//	Get the guards
			EList<String> guards = subEvent.getGuards();
			parentGuards.addAll(guards);
			if (guards != null)
			{
				actualTarget.getCondition().addAll(guards);
			}
			else
			{
				actualTarget.getCondition().add("TRUE");
			}
			//	Copy the actions
			actualTarget.setBody((Command)translationManager.copy(subEvent.getBody()));
		}
		else if (translatedEvent instanceof LocalRemote)
		{
			Subroutine localSubroutine = ((LocalRemote)translatedEvent).getLocalSubroutine();
			Subroutine remoteSubroutine = ((LocalRemote)translatedEvent).getRemoteSubroutine();
			//	Local guards
			EList<String> guards = localSubroutine.getGuards();
			parentGuards.addAll(guards);
			if (guards != null)
			{
				actualTarget.getCondition().addAll(guards);
			}
			else
			{
				actualTarget.getCondition().add("TRUE");
			}
			//	Add code local; remote
			actualTarget.setBody(translationManager.evaluateLocalRemote(localSubroutine, remoteSubroutine));
		}
		else
		{
			//	hopefully a null
		}
		//	Translate the 'alt'
		//Subroutine altEvent = (Subroutine)translationManager.translate(actualSource.getAlt());
		IL1Element altEvent = translationManager.translate(actualSource.getAlt());

		if (altEvent instanceof Subroutine)
		{
			//	Copy the actions
			actualTarget.setElse((Command)translationManager.copy(((Subroutine)altEvent).getBody()));
		}
		else if (altEvent instanceof LocalRemote)
		{
			Subroutine localSubroutine = ((LocalRemote)altEvent).getLocalSubroutine();
			Subroutine remoteSubroutine = ((LocalRemote)altEvent).getRemoteSubroutine();
			//	Add code local; remote
			actualTarget.setElse(translationManager.evaluateLocalRemote(localSubroutine, remoteSubroutine));
		}
		else if(altEvent ==  null){
			// if the alt event is null - and we have translated an environment state-machine,
			// then we add an else do-nothing branch, and set the target branch's attribute
			if(actualSource.isEnvirStateMachineChild()){
				actualTarget.setEnvirStateMachineChild(true);
				Skip skip = Il1Factory.eINSTANCE.createSkip();
				actualTarget.setElse(skip);
			}
		}
		
		//	Translate any sub branch
		ElseIf subBranch = (ElseIf)translationManager.translate(actualSource.getSubBranch());
		if (subBranch != null)
		{
			actualTarget.setBranch(subBranch);
			if(actualSource.isEnvirStateMachineChild()){
				subBranch.setEnvirStateMachineChild(true);
			}
		}
		return actualTarget;
	}

	public static ArrayList<String> getParentGuards() {
		return parentGuards;
	}

	public static ArrayList<String> getNegatedParentGuards() {
		ArrayList<String> newGrds = new ArrayList<String>();
		for(String g: parentGuards){
			newGrds.add(NOT_SYMBOL + "("+g+")");
		}
		return newGrds;
	}
}
