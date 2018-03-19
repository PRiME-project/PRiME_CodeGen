package org.eventb.codegen.tasking;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.impl.Il1PackageImpl;
import org.rodinp.core.RodinDBException;

import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

public class TranslateToEventB implements IObjectActionDelegate {

	IStructuredSelection selection;
	
	//	As it is used in this class...
	@SuppressWarnings("unused")
	private Shell shell;
	
	public TranslateToEventB()
	{
		super();		
	}
	
	
	@Override
	public void run(IAction action) {
		
		try {
			translateTaskingEventBToEventB(selection);
		} catch (RodinDBException e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: RodinDBException:"
					+ e.getMessage(), e);
				StatusManager.getManager().handle(status,
					StatusManager.SHOW);
		} catch (TaskingTranslationUnhandledTypeException e) {
			Status status = new Status(IStatus.ERROR,
					CodeGenTasking.PLUGIN_ID,
					"Failed Translation: TaskingTranslationUnhandledTypeException:"
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
	
	public static void translateTaskingEventBToEventB(IStructuredSelection s) throws TaskingTranslationUnhandledTypeException, RodinDBException
	{
		Object[] list = s.toArray();
		RMLDataStruct relevantMachines = RelevantMachineLoader.getAllRelevantMachines(list);
		
		list = relevantMachines.machineArray;
		ArrayList<ComposedMachine> composedMachines = relevantMachines.composedMachineList;
		Map<String, String> composedEvents = relevantMachines.composedEventMap;
		ArrayList<String> composedMachineNames = relevantMachines.composedMachineNameList;
		
		Il1PackageImpl.init();
		Il1Factory factory = Il1Factory.eINSTANCE;
		
		TaskingTranslationManager translationManager = new TaskingTranslationManager(factory);
		translationManager.translateToEventB(list, composedMachines, composedEvents, composedMachineNames, relevantMachines.contextList);
		
	}
}
