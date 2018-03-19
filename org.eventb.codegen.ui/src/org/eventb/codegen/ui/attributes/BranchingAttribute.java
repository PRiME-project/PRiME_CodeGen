package org.eventb.codegen.ui.attributes;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.basis.Axiom;
import org.eventb.core.basis.Guard;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class BranchingAttribute implements IAttributeManipulation {
	
	//	IMPORTANT: These values should not be changed, as they are directly used in EventTaskingTranslator
	//	where the static objects cannot be loaded in due to cyclic dependencies.
	public static IAttributeType.String BRANCHING_ATTRIBUTE = RodinCore.getStringAttrType(EventBCodeGenerationUI.PLUGIN_ID + ".branchingAttribute");
	public static String SIMPLE = "Simple";
	public static String BRANCHING = "Expanded";
	public static String BRANCHING_NOT_SET = "--unset--";

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Guard)
		{
			((Guard) element).setAttributeValue(BRANCHING_ATTRIBUTE, BRANCHING_NOT_SET, monitor);
		}
		else if (element instanceof Axiom)
		{
			((Axiom) element).setAttributeValue(BRANCHING_ATTRIBUTE, BRANCHING_NOT_SET, monitor);
		}

	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof Guard)
		{
			return ((Guard) element).hasAttribute(BRANCHING_ATTRIBUTE);
		}
		else if (element instanceof Axiom)
		{
			return ((Axiom) element).hasAttribute(BRANCHING_ATTRIBUTE);
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof Guard && ((Guard) element).hasAttribute((BRANCHING_ATTRIBUTE)))
		{
			return ((Guard) element).getAttributeValue(BRANCHING_ATTRIBUTE);
		}
		else if (element instanceof Axiom && ((Axiom) element).hasAttribute((BRANCHING_ATTRIBUTE)))
		{
			return ((Axiom) element).getAttributeValue(BRANCHING_ATTRIBUTE);
		}

		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {

		if (element instanceof Guard)
		{
			((Guard) element).setAttributeValue(BRANCHING_ATTRIBUTE, value, monitor);
		}	
		else if (element instanceof Axiom)
		{
			((Axiom) element).setAttributeValue(BRANCHING_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		
		if (element instanceof Guard)
		{
			((Guard) element).removeAttribute(BRANCHING_ATTRIBUTE, monitor);
		}		
		else if (element instanceof Axiom)
		{
			((Axiom) element).removeAttribute(BRANCHING_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {
		String [] values = {SIMPLE,BRANCHING};
		return values;
	}	

}
