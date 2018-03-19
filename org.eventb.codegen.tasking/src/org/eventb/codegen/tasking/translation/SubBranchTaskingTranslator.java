package org.eventb.codegen.tasking.translation;

import org.eclipse.emf.common.util.EList;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;

import compositeControl.SubBranch;

public class SubBranchTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		SubBranch actualSource = (SubBranch) source;
		ElseIf actualTarget = Il1Factory.eINSTANCE.createElseIf();

		// TODO the (negated) guards, derived from the parent, can be removed from
		// the current guard list
		//ArrayList<String> parentGuards = BranchTaskingTranslator
		//		.getNegatedParentGuards();

		Event evt = actualSource.getEventWrapper().getEvent();
		actualTarget.setRelatedEvent(evt);
		Subroutine existingEventTranslation = (Subroutine) translationManager
				.getStoredElements().get(evt.getReference());
		if(existingEventTranslation!=null){
			EList<String> currentFormulas = existingEventTranslation.getGuards();
			BranchTaskingTranslator.getParentGuards().addAll(currentFormulas);
		}
		IL1Element il1Branch = translationManager.translate(actualSource
				.getEventWrapper());
		if (il1Branch instanceof Subroutine) {
			Subroutine subroutine = (Subroutine) il1Branch;
			actualTarget.setAction((Command) translationManager.copy(subroutine
					.getBody()));
			actualTarget.getCondition().addAll(subroutine.getGuards());
		} else if (il1Branch instanceof LocalRemote) {
			Subroutine localSubroutine = ((LocalRemote) il1Branch)
					.getLocalSubroutine();
			Subroutine remoteSubroutine = ((LocalRemote) il1Branch)
					.getRemoteSubroutine();
			actualTarget.getCondition().addAll(localSubroutine.getGuards());
			// Add code local; remote
			actualTarget.setAction(translationManager.evaluateLocalRemote(
					localSubroutine, remoteSubroutine));
		}
		// Get any further branches
		actualTarget.setBranch((ElseIf) translationManager
				.translate(actualSource.getSubBranch()));
		return actualTarget;
	}
}
