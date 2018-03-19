package org.eventb.codegen.ui.attributes;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eventb.codegen.ui.EventBCodeGenerationUI;
import org.eventb.ui.manipulation.IAttributeManipulation;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElement;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.RodinCore;
import org.rodinp.core.RodinDBException;

public class TaskingContextAttribute implements IAttributeManipulation {

	public static IAttributeType.String TASKING_CONTEXT_ATTRIBUTE = RodinCore.getStringAttrType(EventBCodeGenerationUI.PLUGIN_ID + ".taskingContextAttribute");
	public static String NON_TASKING = "NonTasking";
	public static String TASKING = "Tasking";
	
	@Override
	public String[] getPossibleValues(IRodinElement arg0, IProgressMonitor arg1) {
		String [] values = {NON_TASKING, TASKING};
		return values;
	}

	@Override
	public String getValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
//	doesn't know what a context is
//		if (element instanceof Context)
//		{
//			return ((Context)element).getAttributeValue();
//		}
		
		return ((IInternalElement)element).getAttributeValue(TASKING_CONTEXT_ATTRIBUTE);
	}

	@Override
	public boolean hasValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		return ((IInternalElement)element).hasAttribute(TASKING_CONTEXT_ATTRIBUTE);
	}

	@Override
	public void removeAttribute(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		((IInternalElement)element).removeAttribute(TASKING_CONTEXT_ATTRIBUTE, monitor);
	}

	@Override
	public void setDefaultValue(IRodinElement element, IProgressMonitor monitor)
			throws RodinDBException {
		((IInternalElement)element).setAttributeValue(TASKING_CONTEXT_ATTRIBUTE, NON_TASKING, monitor);
	}

	@Override
	public void setValue(IRodinElement element, String value, IProgressMonitor monitor)
			throws RodinDBException {
		((IInternalElement)element).setAttributeValue(TASKING_CONTEXT_ATTRIBUTE, value, monitor);
	}

}
