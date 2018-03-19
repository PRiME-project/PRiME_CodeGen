package org.eventb.codegen.tasking.translation;

import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.tasking.AbstractTaskingTranslator;
import org.eventb.codegen.tasking.TaskingTranslationException;
import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.emf.core.EventBElement;

import compositeControl.EventWrapper;

public class SeqTaskingTranslator extends AbstractTaskingTranslator {

	@Override
	public IL1Element translate(EventBElement source, IL1Element target,
			TaskingTranslationManager translationManager)
			throws TaskingTranslationException {

		Seq out = Il1Factory.eINSTANCE.createSeq();
		compositeControl.Seq actualSource = (compositeControl.Seq) source;

		IL1Element leftTranslated = translationManager.translate(actualSource
				.getLeftBranch());
		IL1Element rightTranslated = translationManager.translate(actualSource
				.getRightBranch());

		if (leftTranslated instanceof Command) {
			out.setLeftBranch((Command) leftTranslated);
		} else if (leftTranslated instanceof Subroutine) {
			// Must have been an EventWrapper
			if (actualSource.getLeftBranch() instanceof EventWrapper) {
				Command body = ((Subroutine) leftTranslated).getBody();

				// If action, must create new action, as passing by
				// reference breaks things
				// and elements disappear
				if (body instanceof Action) {
					Action cpyAction = Il1Factory.eINSTANCE.createAction();
					cpyAction.setAction(((Action) body).getAction());
					cpyAction.setParentEventName(((Action) body).getParentEventName());
					out.setLeftBranch(cpyAction);
				} else {
					out.setLeftBranch(body);
				}
			}
		} else if (leftTranslated instanceof LocalRemote) {
			Subroutine localSubroutine = ((LocalRemote) leftTranslated)
					.getLocalSubroutine();
			Subroutine remoteSubroutine = ((LocalRemote) leftTranslated)
					.getRemoteSubroutine();

			// Add code local; remote
			out.setLeftBranch(translationManager.evaluateLocalRemote(
					localSubroutine, remoteSubroutine));
		}

		if (rightTranslated instanceof Command) {
			out.setRightBranch((Command) rightTranslated);
		} else if (rightTranslated instanceof Subroutine) {
			// Must have been an EventWrapper
			if (actualSource.getRightBranch() instanceof EventWrapper) {
				{
					Command body = ((Subroutine) rightTranslated).getBody();

					// If action, must create new action, as passing by
					// reference breaks things
					// and elements disappear
					if (body instanceof Action) {
						Action cpyAction = Il1Factory.eINSTANCE.createAction();
						cpyAction.setAction(((Action) body).getAction());
						cpyAction.setParentEventName(((Action) body).getParentEventName());
						out.setRightBranch(cpyAction);
					} else {
						out.setRightBranch(body);
					}
				}
			}
		} else if (rightTranslated instanceof LocalRemote) {
			Subroutine localSubroutine = ((LocalRemote) rightTranslated)
					.getLocalSubroutine();
			Subroutine remoteSubroutine = ((LocalRemote) rightTranslated)
					.getRemoteSubroutine();

			// Add code local; remote
			out.setRightBranch(translationManager.evaluateLocalRemote(
					localSubroutine, remoteSubroutine));
		}

		return out;
	}

//	protected boolean makeInline(Event e) {
//		if (e != null) {
//			if (MachineTaskingTranslator.isProcedureDefSynch(e)) {
//				return false;
//			}
//		}
//
//		return true;
//	}
}
