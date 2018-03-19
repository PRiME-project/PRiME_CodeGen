package org.eventb.codegen.ui.validation;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;
import static org.eventb.codegen.ui.attributes.TypingAttribute.NON_TYPING;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPE_NOT_SET;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPING;
import static org.eventb.codegen.ui.attributes.TypingAttribute.TYPING_ATTRIBUTE;

import org.eventb.codegen.tasking.TaskingTranslationManager;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.IAxiom;
import org.eventb.core.IContextRoot;
import org.eventb.core.IGuard;
import org.eventb.core.IInvariant;
import org.eventb.core.IMachineRoot;
import org.eventb.core.basis.Axiom;
import org.eventb.core.basis.Guard;
import org.eventb.core.basis.Invariant;
import org.rodinp.core.ElementChangedEvent;
import org.rodinp.core.IElementChangedListener;
import org.rodinp.core.IElementType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinDB;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinElementDelta;
import org.rodinp.core.IRodinFile;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

public class TaskBodyValidatorListener implements IElementChangedListener {

	private static final String CODE_GENERATION_CONFIG = EventBCodeGenerationUI.PLUGIN_ID
			+ ".cgConfig";

	public void elementChanged(ElementChangedEvent event) {

		final IRodinElementDelta d = event.getDelta();

		try {
			processDelta(d);
		} catch (final RodinDBException e) {
			e.printStackTrace();
		}
	}

	private void processDelta(final IRodinElementDelta d)
			throws RodinDBException {
		final IRodinElement e = d.getElement();

		final IElementType<? extends IRodinElement> elementType = e
				.getElementType();
		if (elementType.equals(IRodinDB.ELEMENT_TYPE)
				|| elementType.equals(IRodinProject.ELEMENT_TYPE)) {
			for (final IRodinElementDelta de : d.getAffectedChildren()) {
				processDelta(de);
			}
		} else if (elementType.equals(IRodinFile.ELEMENT_TYPE)) {

			// tmp - see if we can see what child elements are being identified
			for (final IRodinElementDelta de : d.getChangedChildren()) {
				processDelta(de);
			}

			// does the rest of this actually do anything?
			final IInternalElement root = ((IRodinFile) e).getRoot();

			if (root.getElementType().equals(IMachineRoot.ELEMENT_TYPE)) {
				final IMachineRoot mch = (IMachineRoot) root;
				final String conf = mch.getConfiguration();
				if (!conf.contains(CODE_GENERATION_CONFIG)) {
					mch.setConfiguration(conf + ";" + CODE_GENERATION_CONFIG,
							null);
				}
			} else if (root.getElementType().equals(IContextRoot.ELEMENT_TYPE)) {
				final IContextRoot ctx = (IContextRoot) root;
				final String conf = ctx.getConfiguration();
				if (!conf.contains(CODE_GENERATION_CONFIG)) {
					ctx.setConfiguration(conf + ";" + CODE_GENERATION_CONFIG,
							null);
				}
			}
		} else if (elementType.equals(IInvariant.ELEMENT_TYPE)) {
			checkInvariant((Invariant) e);

			for (final IRodinElementDelta de : d.getChangedChildren()) {
				processDelta(de);
			}
		} else if (elementType.equals(IGuard.ELEMENT_TYPE)) {
			checkGuard((Guard) e);

			for (final IRodinElementDelta de : d.getChangedChildren()) {
				processDelta(de);
			}
		} else if (elementType.equals(IAxiom.ELEMENT_TYPE)) {
			checkAxiom((Axiom) e);

			for (final IRodinElementDelta de : d.getChangedChildren()) {
				processDelta(de);
			}
		} else {
			for (final IRodinElementDelta de : d.getChangedChildren()) {
				processDelta(de);
			}
		}
	}

	private void checkInvariant(Invariant i) throws RodinDBException {
		// Bale out if this is not strictly a tasking translation,
		// which is the case for Codin, for instance
		if(!TaskingTranslationManager.getTranslationType().equals(TaskingTranslationManager.DEFAULT_TRANSLATION_TYPE)) return;
		
		// If invariant has no typing set and predicate has element_of, then it
		// is typing
		
		if (i.hasAttribute(TYPING_ATTRIBUTE) &&
				i.getAttributeValue(TYPING_ATTRIBUTE).equals(TYPE_NOT_SET)) {
			if (i.getPredicateString().contains(ELEMENT_OF)) {
				i.setAttributeValue(TYPING_ATTRIBUTE, TYPING, null);
			} else {
				// if has two distinct tokens an no typing attribute, then auto
				// set to something else
				String p = i.getPredicateString().trim();
				String[] pArr = p.split(" ");

				if (pArr.length > 1) {
					i.setAttributeValue(TYPING_ATTRIBUTE, NON_TYPING, null);
				}
			}
		}
	}

	private void checkGuard(Guard g) throws RodinDBException {
		// Bale out if this is not strictly a tasking translation,
		// which is the case for Codin, for instance
		if(!TaskingTranslationManager.getTranslationType().equals(TaskingTranslationManager.DEFAULT_TRANSLATION_TYPE)) return;

		// If invariant has no typing set and predicate has element_of, then it
		// is typing
		if (g.hasAttribute(TYPING_ATTRIBUTE) &&
				g.getAttributeValue(TYPING_ATTRIBUTE).equals(TYPE_NOT_SET)) {
			if (g.getPredicateString().contains(ELEMENT_OF)) {
				g.setAttributeValue(TYPING_ATTRIBUTE, TYPING, null);
			} else {
				// if has two distinct tokens an no typing attribute, then auto
				// set to something else
				String p = g.getPredicateString().trim();
				String[] pArr = p.split(" ");

				if (pArr.length > 1) {
					g.setAttributeValue(TYPING_ATTRIBUTE, NON_TYPING, null);
				}
			}
		}
	}

	private void checkAxiom(Axiom a) throws RodinDBException {
		// Bale out if this is not strictly a tasking translation,
		// which is the case for Codin, for instance
		if(!TaskingTranslationManager.getTranslationType().equals(TaskingTranslationManager.DEFAULT_TRANSLATION_TYPE)) return;

		// If invariant has no typing set and predicate has element_of, then it
		// is typing
		if (a.hasAttribute(TYPING_ATTRIBUTE) &&
				a.getAttributeValue(TYPING_ATTRIBUTE).equals(TYPE_NOT_SET)) {
			if (a.getPredicateString().contains(ELEMENT_OF)) {
				a.setAttributeValue(TYPING_ATTRIBUTE, TYPING, null);
			} else {
				// if has two distinct tokens an no typing attribute, then auto
				// set to something else
				String p = a.getPredicateString().trim();
				String[] pArr = p.split(" ");

				if (pArr.length > 1) {
					a.setAttributeValue(TYPING_ATTRIBUTE, NON_TYPING, null);
				}
			}
		}
	}
}
