package org.eventb.codegen.tasking;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.core.IMachineRoot;
import org.eventb.core.basis.ContextRoot;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.Project;
import org.eventb.emf.core.context.impl.ContextImpl;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.eventb.emf.persistence.factory.RodinResource;
import org.eventb.emf.persistence.synchroniser.SyncManager;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.basis.ComposedMachineRoot;
import ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl;

//	Assumes it is given a Machine File
public class RodinToEMFConverter {
	
	//	something to store the output
	public static ResourceSet ctxResSet = new ResourceSetImpl();
	public static ResourceSet machineResSet = new ResourceSetImpl();
	
	public static ComposedMachineImpl loadComposedMachine(ComposedMachineRoot m) throws RodinDBException
	{
		SyncManager syncManager = new SyncManager();	
		
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		EventBElement element = null;
		try {
			element = syncManager.loadRodinElement(m, null, map, null);			
		} catch (Exception e) {
			Status myStatus = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID, "Failed Translation: Exception", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		}	
		
		return (ComposedMachineImpl) element;
		
	}
	
	public static Project loadProject(IRodinProject p) throws RodinDBException
	{
		SyncManager syncManager = new SyncManager();	
		
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		EventBElement element = null;
		try {
			element = syncManager.loadRodinElement(p, null, map, null);			
		} catch (Exception e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: General Exception??:"
					+ e.getMessage(), e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);
		}	
		
		return (Project) element;
	}
	
	public static ContextImpl loadContext(ContextRoot contextRoot) throws RodinDBException
	{
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		// lets get file from the contextRoot
		IFile contextFile = contextRoot.getResource();
		// create the path
		IPath path = new Path("platform:/resource");
		IPath filePath = contextFile.getFullPath();
		path = path.append(filePath);
		// Create a resource with the path
		Resource resource = ctxResSet.createResource(URI
				.createURI(path.toString()));
		 ContextImpl context = null;
		try {
			 // load the resource
			resource.load(null);
			EList<Resource> resList = ctxResSet.getResources();
			Map<IRodinElement, EventBObject> resourceMap = ((RodinResource) resource).getMap();
			context = (ContextImpl) resourceMap.get(contextRoot);
		 } catch (IOException e1) {
			e1.printStackTrace();
		}
		return (ContextImpl) context;
	}

	public static MachineImpl loadMachine(IMachineRoot machineRoot) throws RodinDBException
	{
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		// lets get file from the machine root
		IFile machineFile = machineRoot.getResource();
		//machineRoot.createChild(arg0, arg1, arg2)
		// create the path
		IPath path = new Path("platform:/resource");
		IPath filePath = machineFile.getFullPath();
		path = path.append(filePath);
		// Create a resource with the path
		Resource resource = machineResSet.createResource(URI
				.createURI(path.toString()));
		 MachineImpl machine = null;
		try {
			 // load the resource
			resource.load(null);
			EList<Resource> resList = machineResSet.getResources();
			Map<IRodinElement, EventBObject> resourceMap = ((RodinResource) resource).getMap();
			machine = (MachineImpl) resourceMap.get(machineRoot);
		 } catch (IOException e1) {
			e1.printStackTrace();
		}
		return (MachineImpl) machine;
	}
	
	public static void saveMachine(MachineImpl m, String projectName) throws RodinDBException, IOException
	{
		Map<IRodinElement,EventBObject> map = new HashMap<IRodinElement, EventBObject>();
		map.clear();
		// lets get file from the machine root
		String filePath = "platform:/resource/" + projectName + "/" + m.getName() + ".bum";

		//	New saver
		Resource resource = machineResSet.createResource(URI
				.createURI(filePath));

		resource.getContents().add(0, m);
		resource.save(null);
		

	}
}
