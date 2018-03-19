package org.eventb.codegen.tasking;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.tasking.translation.eventb.MachineEventBTranslator;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.rodinp.core.RodinDBException;

public class RemoveGenerated implements IObjectActionDelegate {

	IStructuredSelection selection;

	// As it is used in this class...
	@SuppressWarnings("unused")
	private Shell shell;

	public RemoveGenerated() {
		super();
	}

	@Override
	public void run(IAction action) {

		try {
			removeGenerated(selection);
		} catch (RodinDBException e) {
			Status s = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"RodinDB Exception: Failed to load ComposedMachine: "
							+ e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		} catch (TaskingTranslationUnhandledTypeException e) {
			Status s = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"TaskingTranslationUnhandledTypeException: Failed to translate type: "
							+ e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
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

	public static void removeGenerated(IStructuredSelection s)
			throws TaskingTranslationUnhandledTypeException, RodinDBException {
		Object[] list = s.toArray();

		for (Object o : list) {
			if (o instanceof MachineRoot) {
				MachineRoot mR = (MachineRoot) o;
				MachineImpl mI = (MachineImpl) RodinToEMFConverter
						.loadMachine(mR);
				TaskingTranslationManager.clearAllGeneratedElements(mI);
				MachineEventBTranslator.saveMachine(mI, mR.getRodinProject()
						.getElementName());
			}
		}
	}

}
