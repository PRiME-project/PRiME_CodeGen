package org.eventb.codegen.ui.attributes;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.core.basis.Parameter;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class ParameterTypeAttribute implements IAttributeManipulation {
	
	public static IAttributeType.String PARAMETER_TYPE_ATTRIBUTE = RodinCore.getStringAttrType(EventBCodeGenerationUI.PLUGIN_ID + ".parameterTypeAttribute");
	public static String IN_PARAM = "In";
	public static String OUT_PARAM = "Out";
	public static String PARAMETER_NOT_SET = "--unset--";

	
	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Parameter)
		{
			((Parameter) element).setAttributeValue(PARAMETER_TYPE_ATTRIBUTE, "--unset--", monitor);
		}
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Parameter)
		{
			return ((Parameter) element).hasAttribute(PARAMETER_TYPE_ATTRIBUTE);
		}
		
		return false;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Parameter)
		{
			return ((Parameter) element).getAttributeValue(PARAMETER_TYPE_ATTRIBUTE);
		}
		
		return null;
	}

	@Override
	public void setValue(IRodinElement element, String value,
			IProgressMonitor monitor) throws RodinDBException {

		if (element instanceof Parameter)
		{
			((Parameter) element).setAttributeValue(PARAMETER_TYPE_ATTRIBUTE, value, monitor);
		}
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {

		if (element instanceof Parameter)
		{
			((Parameter) element).removeAttribute(PARAMETER_TYPE_ATTRIBUTE, monitor);
		}
	}

	@Override
	public String[] getPossibleValues(IRodinElement element,
			IProgressMonitor monitor) {

		String [] values = {IN_PARAM,OUT_PARAM};
		return values;
	}

}
