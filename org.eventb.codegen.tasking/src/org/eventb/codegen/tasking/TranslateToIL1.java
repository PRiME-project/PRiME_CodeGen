package org.eventb.codegen.tasking;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.impl.Il1PackageImpl;
import org.eventb.core.basis.ContextRoot;
import org.eventb.core.basis.MachineRoot;
import org.osgi.service.prefs.BackingStoreException;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.basis.ComposedMachineRoot;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

public class TranslateToIL1 implements IObjectActionDelegate {

	IStructuredSelection selection;

	// As it is used in this class...
	@SuppressWarnings("unused")
	private Shell shell;

	public TranslateToIL1() {
		super();
	}

	public static Program translateEventBToIL1(IStructuredSelection s)
			throws TaskingTranslationException, BackingStoreException,
			CoreException {
		Object[] list = s.toArray();
		RMLDataStruct relevantMachines = RelevantMachineLoader
				.getAllRelevantMachines(list);

		list = relevantMachines.machineArray;
		ArrayList<ComposedMachine> composedMachines = relevantMachines.composedMachineList;
		Map<String, String> composedEvents = relevantMachines.composedEventMap;
		ArrayList<String> composedMachineNames = relevantMachines.composedMachineNameList;
		Il1PackageImpl.init();
		Il1Factory factory = Il1Factory.eINSTANCE;

		TaskingTranslationManager translationManager = new TaskingTranslationManager(
				factory);

		IFile target = null;
		// Get target location
		for (Object obj : list) {
			if (obj instanceof MachineRoot) {
				target = ((MachineRoot) obj).getResource();
				break;
			} else if (obj instanceof ContextRoot) {
				target = ((ContextRoot) obj).getResource();
				break;
			} else if (obj instanceof ComposedMachineRoot) {
				target = ((ComposedMachineRoot) obj).getResource();
				break;
			}
		}
		storeProject(target.getProject(), translationManager);

		Program program = translationManager.translateToIL1Entry(list,
				composedMachines, composedEvents, composedMachineNames,
				relevantMachines);

		try {
			saveBaseProgram(program, targetFile(target));
		} catch (IOException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: IOException:" + e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		} catch (URISyntaxException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: URISyntaxException:" + e.getMessage(),
					e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}

		return program;
	}

	private static void storeProject(IProject project,
			TaskingTranslationManager translationManager) {
		translationManager.setProject(project);
	}

	/**
	 * This is where the code enters after the user right clicks on a machine
	 * (etc) selects 'IL1 Translation' --> 'Perform IL1 Translation'
	 */
	@Override
	public void run(IAction action) {

		try {
			translateEventBToIL1(selection);
		} catch (RodinDBException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException:" + e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		} catch (TaskingTranslationException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: TaskingTranslationException:"
							+ e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		} catch (BackingStoreException e) {
			Status status = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: BackingStoreException:"
							+ e.getMessage(), e);
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		} catch (CoreException e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException:"
					+ e.getMessage(), e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	// Create the file associated with the output
	// The sourceRes is the container of the MainClass
	// element that we want to transform
	protected static String targetFile(IFile source) throws URISyntaxException {

		// The following code did not work on Ubuntu (but did on Windows).
		// String path =
		// source.getFullPath().removeFileExtension().toString()+".il1";
		// Changed to the following, which appears to work:
		java.net.URI location = source.getLocationURI();
		IPath p = new Path(location.getPath());

		IPath newPath = p.removeFileExtension();
		String path = newPath + ".il1";

		return path;
	}

	/*
	 * protected Program createBaseProgram() { Il1Factory factory =
	 * Il1Factory.eINSTANCE; Program program = factory.createProgram();
	 * program.setName("TmpDefaultName");
	 * 
	 * return program; }
	 */

	protected static void saveBaseProgram(Program program, String filename)
			throws IOException {
		URI uri = URI.createFileURI(filename);
		Resource outResource = new XMLResourceFactoryImpl().createResource(uri);
		outResource.getContents().add(program);
		outResource.save(null);
	}

}