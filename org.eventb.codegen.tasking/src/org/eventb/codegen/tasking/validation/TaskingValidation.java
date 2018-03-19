/**
 * 
 */
package org.eventb.codegen.tasking.validation;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.RodinToEMFConverter;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.codegen.tasking.utils.CodeGenValidationUtil;
import org.eventb.core.basis.MachineRoot;
import org.eventb.emf.core.machine.impl.MachineImpl;
import org.rodinp.core.RodinDBException;

import tasking.MachineType;
import tasking.SimpleTaskType;
import tasking.Task;
import tasking.TaskType;
import tasking.TaskTypeEnum;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

import compositeControl.CompositeControl;

/**
 * @author renatosilva
 * 
 */
public class TaskingValidation {

	/**
	 * @param listValidate
	 */
	private TaskingValidation() {
		super();
	}

	public static void validateTasks(Object[] listMachines,
			List<ComposedMachine> composedMachines) throws RodinDBException {
		for (Object obj : listMachines) {
			if (obj instanceof MachineRoot || obj instanceof MachineImpl) {
				MachineImpl machine = null;

				if (obj instanceof MachineRoot) {
					validateTask((MachineRoot) obj);
				}
				// // Convert from RODIN database to EMF
				// machine = ((MachineRoot) obj);
				// } else {
				// machine = (MachineImpl) obj;
				// }

				// validateTask(machine);
			}
		}

		for (ComposedMachine mch : composedMachines) {
			validateTask(mch);
		}
	}

	private static MachineImpl loadMachineImpl(MachineRoot mch)
			throws RodinDBException {
		return (MachineImpl) RodinToEMFConverter.loadMachine(mch);
	}

	private static void validateTask(MachineRoot mch) throws RodinDBException {
		try {
			// delete all markers first
			CodeGenValidationUtil.deleteAllMarkers(
					CodeGenValidationUtil.CODE_GEN_MARKER, mch.getResource());

			// Validations:

			// All machines included in the low-level composed-machine must have
			// a Tasking Event-B attribute type: AutoTask, Shared or Environment
			MachineImpl machineImpl = loadMachineImpl(mch);
			MachineType taskMachine = CodeGenTaskingUtils
					.getTaskType(machineImpl);
			if (null == taskMachine) {
				CodeGenValidationUtil.createProblemMarker(mch,
						CodeGenProblem.NoTaskingMachineError,
						mch.getComponentName());
			} else {
				// All machines included in the low-level composed-machine must
				// have exactly one task type
				if (CodeGenValidationUtil.isMultipleTaskType(machineImpl)) {
					CodeGenValidationUtil.createProblemMarker(mch,
							CodeGenProblem.MultipleTaskingTypeError,
							mch.getComponentName());
				}
				Task task = ((Task) taskMachine);
				CompositeControl taskBody = task.getTaskBody();
				// Machine X should have a task body
				if (taskBody == null || taskBody.toString().isEmpty()) {
					CodeGenValidationUtil.createProblemMarker(mch,
							CodeGenProblem.NoTaskBodyError,
							mch.getComponentName());
				} else {
					TaskType taskType = task.getTaskType();
					if (!(taskType instanceof SimpleTaskType || taskType instanceof tasking.PeriodicTaskType)) {
						CodeGenValidationUtil.createProblemMarker(mch,
								CodeGenProblem.NoTaskTypeError,
								mch.getComponentName());
					} else if (taskType instanceof tasking.PeriodicTaskType) {
						tasking.PeriodicTaskType periodicTaskType = (tasking.PeriodicTaskType) taskType;
						int period = periodicTaskType.getPeriod();
						if (period <= 0)
							CodeGenValidationUtil.createProblemMarker(mch,
									CodeGenProblem.NoPeriodTaskTypeError,
									mch.getComponentName());
					} else if (taskType instanceof SimpleTaskType) {
						SimpleTaskType simpleTaskType = (SimpleTaskType) taskType;
						TaskTypeEnum type = simpleTaskType.getType();
						if (TaskTypeEnum.getByName(type.getName()) == null) {
							CodeGenValidationUtil.createProblemMarker(mch,
									CodeGenProblem.NoSimpleTaskTypeError,
									mch.getComponentName());
						}
					}
				}
			}

		} catch (CoreException e) {
			Status s = new Status(IStatus.ERROR, CodeGenTasking.PLUGIN_ID,
					"Failed Translation: CoreException: " + e.getMessage(), e);
			StatusManager.getManager().handle(s, StatusManager.SHOW);
		}
	}

	private static void validateTask(ComposedMachine mch) {

	}

}
