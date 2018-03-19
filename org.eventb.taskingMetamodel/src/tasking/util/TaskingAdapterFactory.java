/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tasking.TaskingPackage
 * @generated
 */
public class TaskingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TaskingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TaskingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskingSwitch<Adapter> modelSwitch =
		new TaskingSwitch<Adapter>() {
			@Override
			public Adapter caseMain(Main object) {
				return createMainAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseAutoTask_Machine(AutoTask_Machine object) {
				return createAutoTask_MachineAdapter();
			}
			@Override
			public Adapter caseTasking_Machine(Tasking_Machine object) {
				return createTasking_MachineAdapter();
			}
			@Override
			public Adapter caseEnviron_Machine(Environ_Machine object) {
				return createEnviron_MachineAdapter();
			}
			@Override
			public Adapter caseFMU_Machine(FMU_Machine object) {
				return createFMU_MachineAdapter();
			}
			@Override
			public Adapter caseShared_Machine(Shared_Machine object) {
				return createShared_MachineAdapter();
			}
			@Override
			public Adapter caseImplementation(Implementation object) {
				return createImplementationAdapter();
			}
			@Override
			public Adapter caseParameterType(ParameterType object) {
				return createParameterTypeAdapter();
			}
			@Override
			public Adapter caseTaskType(TaskType object) {
				return createTaskTypeAdapter();
			}
			@Override
			public Adapter caseSimpleTaskType(SimpleTaskType object) {
				return createSimpleTaskTypeAdapter();
			}
			@Override
			public Adapter casePeriodicTaskType(PeriodicTaskType object) {
				return createPeriodicTaskTypeAdapter();
			}
			@Override
			public Adapter caseSensor(Sensor object) {
				return createSensorAdapter();
			}
			@Override
			public Adapter caseAddressedVariable(AddressedVariable object) {
				return createAddressedVariableAdapter();
			}
			@Override
			public Adapter caseTaskingElement(TaskingElement object) {
				return createTaskingElementAdapter();
			}
			@Override
			public Adapter caseAbstractExtensionTaskingElement(AbstractExtensionTaskingElement object) {
				return createAbstractExtensionTaskingElementAdapter();
			}
			@Override
			public Adapter caseEventBElementTaskingElement(EventBElementTaskingElement object) {
				return createEventBElementTaskingElementAdapter();
			}
			@Override
			public Adapter caseMachineType(MachineType object) {
				return createMachineTypeAdapter();
			}
			@Override
			public Adapter caseTyping(Typing object) {
				return createTypingAdapter();
			}
			@Override
			public Adapter caseEventBObject(EventBObject object) {
				return createEventBObjectAdapter();
			}
			@Override
			public Adapter caseEventBElement(EventBElement object) {
				return createEventBElementAdapter();
			}
			@Override
			public Adapter caseAbstractExtension(AbstractExtension object) {
				return createAbstractExtensionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link tasking.Main <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Main
	 * @generated
	 */
	public Adapter createMainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Tasking_Machine <em>Tasking Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Tasking_Machine
	 * @generated
	 */
	public Adapter createTasking_MachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Shared_Machine <em>Shared Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Shared_Machine
	 * @generated
	 */
	public Adapter createShared_MachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Environ_Machine <em>Environ Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Environ_Machine
	 * @generated
	 */
	public Adapter createEnviron_MachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.FMU_Machine <em>FMU Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.FMU_Machine
	 * @generated
	 */
	public Adapter createFMU_MachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Implementation
	 * @generated
	 */
	public Adapter createImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.ParameterType
	 * @generated
	 */
	public Adapter createParameterTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.AutoTask_Machine <em>Auto Task Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.AutoTask_Machine
	 * @generated
	 */
	public Adapter createAutoTask_MachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.TaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.TaskType
	 * @generated
	 */
	public Adapter createTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.SimpleTaskType <em>Simple Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.SimpleTaskType
	 * @generated
	 */
	public Adapter createSimpleTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.PeriodicTaskType <em>Periodic Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.PeriodicTaskType
	 * @generated
	 */
	public Adapter createPeriodicTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Sensor
	 * @generated
	 */
	public Adapter createSensorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.AddressedVariable <em>Addressed Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.AddressedVariable
	 * @generated
	 */
	public Adapter createAddressedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.TaskingElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.TaskingElement
	 * @generated
	 */
	public Adapter createTaskingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.AbstractExtensionTaskingElement <em>Abstract Extension Tasking Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.AbstractExtensionTaskingElement
	 * @generated
	 */
	public Adapter createAbstractExtensionTaskingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.EventBElementTaskingElement <em>Event BElement Tasking Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.EventBElementTaskingElement
	 * @generated
	 */
	public Adapter createEventBElementTaskingElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.MachineType <em>Machine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.MachineType
	 * @generated
	 */
	public Adapter createMachineTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tasking.Typing <em>Typing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tasking.Typing
	 * @generated
	 */
	public Adapter createTypingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBObject <em>Event BObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBObject
	 * @generated
	 */
	public Adapter createEventBObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.EventBElement <em>Event BElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.EventBElement
	 * @generated
	 */
	public Adapter createEventBElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.emf.core.AbstractExtension <em>Abstract Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.emf.core.AbstractExtension
	 * @generated
	 */
	public Adapter createAbstractExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TaskingAdapterFactory
