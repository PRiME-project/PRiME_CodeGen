/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;

import tasking.*;
import tasking.AbstractExtensionTaskingElement;
import tasking.AddressedVariable;
import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.EventBElementTaskingElement;
import tasking.FMU_Machine;
import tasking.Implementation;
import tasking.MachineType;
import tasking.Main;
import tasking.ParameterType;
import tasking.PeriodicTaskType;
import tasking.Sensor;
import tasking.Shared_Machine;
import tasking.SimpleTaskType;
import tasking.Task;
import tasking.TaskType;
import tasking.TaskingElement;
import tasking.TaskingPackage;
import tasking.Tasking_Machine;
import tasking.Typing;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tasking.TaskingPackage
 * @generated
 */
public class TaskingSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TaskingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskingSwitch() {
		if (modelPackage == null) {
			modelPackage = TaskingPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TaskingPackage.MAIN: {
				Main main = (Main)theEObject;
				T result = caseMain(main);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseAbstractExtensionTaskingElement(task);
				if (result == null) result = caseMachineType(task);
				if (result == null) result = caseAbstractExtension(task);
				if (result == null) result = caseTaskingElement(task);
				if (result == null) result = caseEventBElement(task);
				if (result == null) result = caseEventBObject(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.AUTO_TASK_MACHINE: {
				AutoTask_Machine autoTask_Machine = (AutoTask_Machine)theEObject;
				T result = caseAutoTask_Machine(autoTask_Machine);
				if (result == null) result = caseTask(autoTask_Machine);
				if (result == null) result = caseAbstractExtensionTaskingElement(autoTask_Machine);
				if (result == null) result = caseMachineType(autoTask_Machine);
				if (result == null) result = caseAbstractExtension(autoTask_Machine);
				if (result == null) result = caseTaskingElement(autoTask_Machine);
				if (result == null) result = caseEventBElement(autoTask_Machine);
				if (result == null) result = caseEventBObject(autoTask_Machine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.TASKING_MACHINE: {
				Tasking_Machine tasking_Machine = (Tasking_Machine)theEObject;
				T result = caseTasking_Machine(tasking_Machine);
				if (result == null) result = caseTask(tasking_Machine);
				if (result == null) result = caseAbstractExtensionTaskingElement(tasking_Machine);
				if (result == null) result = caseMachineType(tasking_Machine);
				if (result == null) result = caseAbstractExtension(tasking_Machine);
				if (result == null) result = caseTaskingElement(tasking_Machine);
				if (result == null) result = caseEventBElement(tasking_Machine);
				if (result == null) result = caseEventBObject(tasking_Machine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.ENVIRON_MACHINE: {
				Environ_Machine environ_Machine = (Environ_Machine)theEObject;
				T result = caseEnviron_Machine(environ_Machine);
				if (result == null) result = caseTask(environ_Machine);
				if (result == null) result = caseAbstractExtensionTaskingElement(environ_Machine);
				if (result == null) result = caseMachineType(environ_Machine);
				if (result == null) result = caseAbstractExtension(environ_Machine);
				if (result == null) result = caseTaskingElement(environ_Machine);
				if (result == null) result = caseEventBElement(environ_Machine);
				if (result == null) result = caseEventBObject(environ_Machine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.FMU_MACHINE: {
				FMU_Machine fmU_Machine = (FMU_Machine)theEObject;
				T result = caseFMU_Machine(fmU_Machine);
				if (result == null) result = caseTask(fmU_Machine);
				if (result == null) result = caseAbstractExtensionTaskingElement(fmU_Machine);
				if (result == null) result = caseMachineType(fmU_Machine);
				if (result == null) result = caseAbstractExtension(fmU_Machine);
				if (result == null) result = caseTaskingElement(fmU_Machine);
				if (result == null) result = caseEventBElement(fmU_Machine);
				if (result == null) result = caseEventBObject(fmU_Machine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.SHARED_MACHINE: {
				Shared_Machine shared_Machine = (Shared_Machine)theEObject;
				T result = caseShared_Machine(shared_Machine);
				if (result == null) result = caseAbstractExtensionTaskingElement(shared_Machine);
				if (result == null) result = caseMachineType(shared_Machine);
				if (result == null) result = caseAbstractExtension(shared_Machine);
				if (result == null) result = caseTaskingElement(shared_Machine);
				if (result == null) result = caseEventBElement(shared_Machine);
				if (result == null) result = caseEventBObject(shared_Machine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.IMPLEMENTATION: {
				Implementation implementation = (Implementation)theEObject;
				T result = caseImplementation(implementation);
				if (result == null) result = caseAbstractExtensionTaskingElement(implementation);
				if (result == null) result = caseAbstractExtension(implementation);
				if (result == null) result = caseTaskingElement(implementation);
				if (result == null) result = caseEventBElement(implementation);
				if (result == null) result = caseEventBObject(implementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.PARAMETER_TYPE: {
				ParameterType parameterType = (ParameterType)theEObject;
				T result = caseParameterType(parameterType);
				if (result == null) result = caseAbstractExtensionTaskingElement(parameterType);
				if (result == null) result = caseAbstractExtension(parameterType);
				if (result == null) result = caseTaskingElement(parameterType);
				if (result == null) result = caseEventBElement(parameterType);
				if (result == null) result = caseEventBObject(parameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.TASK_TYPE: {
				TaskType taskType = (TaskType)theEObject;
				T result = caseTaskType(taskType);
				if (result == null) result = caseEventBElementTaskingElement(taskType);
				if (result == null) result = caseTaskingElement(taskType);
				if (result == null) result = caseEventBElement(taskType);
				if (result == null) result = caseEventBObject(taskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.SIMPLE_TASK_TYPE: {
				SimpleTaskType simpleTaskType = (SimpleTaskType)theEObject;
				T result = caseSimpleTaskType(simpleTaskType);
				if (result == null) result = caseTaskType(simpleTaskType);
				if (result == null) result = caseEventBElementTaskingElement(simpleTaskType);
				if (result == null) result = caseTaskingElement(simpleTaskType);
				if (result == null) result = caseEventBElement(simpleTaskType);
				if (result == null) result = caseEventBObject(simpleTaskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.PERIODIC_TASK_TYPE: {
				PeriodicTaskType periodicTaskType = (PeriodicTaskType)theEObject;
				T result = casePeriodicTaskType(periodicTaskType);
				if (result == null) result = caseTaskType(periodicTaskType);
				if (result == null) result = caseEventBElementTaskingElement(periodicTaskType);
				if (result == null) result = caseTaskingElement(periodicTaskType);
				if (result == null) result = caseEventBElement(periodicTaskType);
				if (result == null) result = caseEventBObject(periodicTaskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.SENSOR: {
				Sensor sensor = (Sensor)theEObject;
				T result = caseSensor(sensor);
				if (result == null) result = caseAbstractExtensionTaskingElement(sensor);
				if (result == null) result = caseAbstractExtension(sensor);
				if (result == null) result = caseTaskingElement(sensor);
				if (result == null) result = caseEventBElement(sensor);
				if (result == null) result = caseEventBObject(sensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.ADDRESSED_VARIABLE: {
				AddressedVariable addressedVariable = (AddressedVariable)theEObject;
				T result = caseAddressedVariable(addressedVariable);
				if (result == null) result = caseSensor(addressedVariable);
				if (result == null) result = caseAbstractExtensionTaskingElement(addressedVariable);
				if (result == null) result = caseAbstractExtension(addressedVariable);
				if (result == null) result = caseTaskingElement(addressedVariable);
				if (result == null) result = caseEventBElement(addressedVariable);
				if (result == null) result = caseEventBObject(addressedVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.TASKING_ELEMENT: {
				TaskingElement taskingElement = (TaskingElement)theEObject;
				T result = caseTaskingElement(taskingElement);
				if (result == null) result = caseEventBElement(taskingElement);
				if (result == null) result = caseEventBObject(taskingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.ABSTRACT_EXTENSION_TASKING_ELEMENT: {
				AbstractExtensionTaskingElement abstractExtensionTaskingElement = (AbstractExtensionTaskingElement)theEObject;
				T result = caseAbstractExtensionTaskingElement(abstractExtensionTaskingElement);
				if (result == null) result = caseAbstractExtension(abstractExtensionTaskingElement);
				if (result == null) result = caseTaskingElement(abstractExtensionTaskingElement);
				if (result == null) result = caseEventBElement(abstractExtensionTaskingElement);
				if (result == null) result = caseEventBObject(abstractExtensionTaskingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.EVENT_BELEMENT_TASKING_ELEMENT: {
				EventBElementTaskingElement eventBElementTaskingElement = (EventBElementTaskingElement)theEObject;
				T result = caseEventBElementTaskingElement(eventBElementTaskingElement);
				if (result == null) result = caseTaskingElement(eventBElementTaskingElement);
				if (result == null) result = caseEventBElement(eventBElementTaskingElement);
				if (result == null) result = caseEventBObject(eventBElementTaskingElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.MACHINE_TYPE: {
				MachineType machineType = (MachineType)theEObject;
				T result = caseMachineType(machineType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TaskingPackage.TYPING: {
				Typing typing = (Typing)theEObject;
				T result = caseTyping(typing);
				if (result == null) result = caseAbstractExtensionTaskingElement(typing);
				if (result == null) result = caseAbstractExtension(typing);
				if (result == null) result = caseTaskingElement(typing);
				if (result == null) result = caseEventBElement(typing);
				if (result == null) result = caseEventBObject(typing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Main</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Main</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMain(Main object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Auto Task Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auto Task Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutoTask_Machine(AutoTask_Machine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tasking Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tasking Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTasking_Machine(Tasking_Machine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environ Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environ Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnviron_Machine(Environ_Machine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMU_Machine(FMU_Machine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShared_Machine(Shared_Machine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementation(Implementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterType(ParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskType(TaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleTaskType(SimpleTaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Periodic Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Periodic Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriodicTaskType(PeriodicTaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensor(Sensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addressed Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addressed Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressedVariable(AddressedVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskingElement(TaskingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Extension Tasking Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Extension Tasking Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractExtensionTaskingElement(AbstractExtensionTaskingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BElement Tasking Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BElement Tasking Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBElementTaskingElement(EventBElementTaskingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Machine Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Machine Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMachineType(MachineType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTyping(Typing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBObject(EventBObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event BElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBElement(EventBElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractExtension(AbstractExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //TaskingSwitch
