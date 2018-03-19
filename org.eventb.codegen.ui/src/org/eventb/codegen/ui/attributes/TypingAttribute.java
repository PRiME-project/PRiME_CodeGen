package org.eventb.codegen.ui.attributes;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.basis.Axiom;
import org.eventb.core.basis.Guard;
import org.eventb.core.basis.Invariant;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class TypingAttribute implements IAttributeManipulation {
	
	//	IMPORTANT: These values should not be changed, as they are directly used in EventTaskingTranslator
	//	where the static objects cannot be loaded in due to cyclic dependencies.
	public static IAttributeType.String TYPING_ATTRIBUTE = RodinCore.getStringAttrType(EventBCodeGenerationUI.PLUGIN_ID + ".typingAttribute");
	public static String NON_TYPING = "NonTyping";
	public static String TYPING = "Typing";
	public static String TYPE_NOT_SET = "--unset--";

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Invariant)
		{
			((Invariant) element).setAttributeValue(TYPING_ATTRIBUTE, TYPE_NOT_SET, monitor);
		}
		else if (element instanceof Guard)
		{
			((Guard) element).setAttributeValue(TYPING_ATTRIBUTE, TYPE_NOT_SET, monitor);
		}
		else if (element instanceof Axiom)
		{
			((Axiom)element).setAttributeValue(TYPING_ATTRIBUTE, TYPE_NOT_SET, monitor);
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof Invariant)
		{
			return ((Invariant) element).hasAttribute(TYPING_ATTRIBUTE);
		}
		else if (element instanceof Guard)
		{
			return ((Guard) element).hasAttribute(TYPING_ATTRIBUTE);
		}
		else if (element instanceof Axiom)
		{
			return ((Axiom) element).hasAttribute(TYPING_ATTRIBUTE);
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		if (element instanceof Invariant && ((Invariant) element).hasAttribute((TYPING_ATTRIBUTE)))
		{
			return ((Invariant) element).getAttributeValue(TYPING_ATTRIBUTE);
		}
		else if (element instanceof Guard && ((Guard) element).hasAttribute((TYPING_ATTRIBUTE)))
		{
			return ((Guard) element).getAttributeValue(TYPING_ATTRIBUTE);
		}
		else if (element instanceof Axiom && ((Axiom) element).hasAttribute((TYPING_ATTRIBUTE)))
		{
			return ((Axiom) element).getAttributeValue(TYPING_ATTRIBUTE);
		}
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {

		if (element instanceof Invariant)
		{
			((Invariant) element).setAttributeValue(TYPING_ATTRIBUTE, value, monitor);
		}
		else if (element instanceof Guard)
		{
			((Guard) element).setAttributeValue(TYPING_ATTRIBUTE, value, monitor);
		}		
		else if (element instanceof Axiom)
		{
			((Axiom) element).setAttributeValue(TYPING_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof Invariant)
		{
			((Invariant) element).removeAttribute(TYPING_ATTRIBUTE, monitor);
		}
		else if (element instanceof Guard)
		{
			((Guard) element).removeAttribute(TYPING_ATTRIBUTE, monitor);
		}
		else if (element instanceof Axiom)
		{
			((Axiom) element).removeAttribute(TYPING_ATTRIBUTE, monitor);
		}		
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		String [] values = {NON_TYPING,TYPING};
		return values;
	}	

}
