/**
 * 
 */
package org.eventb.codegen.tasking.utils;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.validation.ICodeGenerationProblem;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.rodinp.core.IRodinElement;

/**
 * @author renatosilva
 *
 */
public final class CodeGenValidationUtil {
	
	public static final String CODE_GEN_MARKER = CodeGenTasking.PLUGIN_ID + ".problem";

	public static void createProblemMarker(
			IRodinElement element, 
			ICodeGenerationProblem problem, 
			Object... args)
					throws CoreException {
		IMarker marker = element.getResource().createMarker(CODE_GEN_MARKER);

		//Once we have a marker object, we can set its attributes
		marker.setAttribute(IMarker.SEVERITY, problem.getSeverity());
		marker.setAttribute(IMarker.MESSAGE, problem.getLocalizedMessage(args));
		marker.setAttribute(IMarker.LOCATION, element.getPath().toString());
	}
	
	public static void deleteAllMarkers(String markerType, IResource target) throws CoreException{
		target.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE); 
	}
	
	public static IMarker[] findAllMarkers(String markerType, IResource target) throws CoreException{
		 return target.findMarkers(markerType, true, IResource.DEPTH_INFINITE); 
	}
	
	public static boolean isMultipleTaskType(final MachineImpl machine) {
		int count = 0;
		for (AbstractExtension eObj : machine.getExtensions()) {
			if (eObj instanceof tasking.AutoTask_Machine
					|| eObj instanceof tasking.Shared_Machine
					|| eObj instanceof tasking.Environ_Machine
					|| eObj instanceof tasking.FMU_Machine) {
				if((++count)>1)
					break;
			}
		}

		return (count>1);
	}

}
