/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tasking.*;
import tasking.AddressedVariable;
import tasking.AutoTask_Machine;
import tasking.Environ_Machine;
import tasking.FMU_Machine;
import tasking.Implementation;
import tasking.ImplementationTypeEnum;
import tasking.Main;
import tasking.ParameterType;
import tasking.ParameterTypeEnum;
import tasking.PeriodicTaskType;
import tasking.Shared_Machine;
import tasking.SimpleTaskType;
import tasking.TaskTypeEnum;
import tasking.TaskingFactory;
import tasking.TaskingPackage;
import tasking.Tasking_Machine;
import tasking.Typing;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskingFactoryImpl extends EFactoryImpl implements TaskingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TaskingFactory init() {
		try {
			TaskingFactory theTaskingFactory = (TaskingFactory)EPackage.Registry.INSTANCE.getEFactory("http://tasking.ecore"); 
			if (theTaskingFactory != null) {
				return theTaskingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TaskingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TaskingPackage.MAIN: return createMain();
			case TaskingPackage.AUTO_TASK_MACHINE: return createAutoTask_Machine();
			case TaskingPackage.TASKING_MACHINE: return createTasking_Machine();
			case TaskingPackage.ENVIRON_MACHINE: return createEnviron_Machine();
			case TaskingPackage.FMU_MACHINE: return createFMU_Machine();
			case TaskingPackage.SHARED_MACHINE: return createShared_Machine();
			case TaskingPackage.IMPLEMENTATION: return createImplementation();
			case TaskingPackage.PARAMETER_TYPE: return createParameterType();
			case TaskingPackage.SIMPLE_TASK_TYPE: return createSimpleTaskType();
			case TaskingPackage.PERIODIC_TASK_TYPE: return createPeriodicTaskType();
			case TaskingPackage.ADDRESSED_VARIABLE: return createAddressedVariable();
			case TaskingPackage.TYPING: return createTyping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TaskingPackage.TASK_TYPE_ENUM:
				return createTaskTypeEnumFromString(eDataType, initialValue);
			case TaskingPackage.IMPLEMENTATION_TYPE_ENUM:
				return createImplementationTypeEnumFromString(eDataType, initialValue);
			case TaskingPackage.PARAMETER_TYPE_ENUM:
				return createParameterTypeEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TaskingPackage.TASK_TYPE_ENUM:
				return convertTaskTypeEnumToString(eDataType, instanceValue);
			case TaskingPackage.IMPLEMENTATION_TYPE_ENUM:
				return convertImplementationTypeEnumToString(eDataType, instanceValue);
			case TaskingPackage.PARAMETER_TYPE_ENUM:
				return convertParameterTypeEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Main createMain() {
		MainImpl main = new MainImpl();
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tasking_Machine createTasking_Machine() {
		Tasking_MachineImpl tasking_Machine = new Tasking_MachineImpl();
		return tasking_Machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shared_Machine createShared_Machine() {
		Shared_MachineImpl shared_Machine = new Shared_MachineImpl();
		return shared_Machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environ_Machine createEnviron_Machine() {
		Environ_MachineImpl environ_Machine = new Environ_MachineImpl();
		return environ_Machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMU_Machine createFMU_Machine() {
		FMU_MachineImpl fmU_Machine = new FMU_MachineImpl();
		return fmU_Machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation createImplementation() {
		ImplementationImpl implementation = new ImplementationImpl();
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType createParameterType() {
		ParameterTypeImpl parameterType = new ParameterTypeImpl();
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoTask_Machine createAutoTask_Machine() {
		AutoTask_MachineImpl autoTask_Machine = new AutoTask_MachineImpl();
		return autoTask_Machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleTaskType createSimpleTaskType() {
		SimpleTaskTypeImpl simpleTaskType = new SimpleTaskTypeImpl();
		return simpleTaskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicTaskType createPeriodicTaskType() {
		PeriodicTaskTypeImpl periodicTaskType = new PeriodicTaskTypeImpl();
		return periodicTaskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressedVariable createAddressedVariable() {
		AddressedVariableImpl addressedVariable = new AddressedVariableImpl();
		return addressedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Typing createTyping() {
		TypingImpl typing = new TypingImpl();
		return typing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskTypeEnum createTaskTypeEnumFromString(EDataType eDataType, String initialValue) {
		TaskTypeEnum result = TaskTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTaskTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationTypeEnum createImplementationTypeEnumFromString(EDataType eDataType, String initialValue) {
		ImplementationTypeEnum result = ImplementationTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImplementationTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTypeEnum createParameterTypeEnumFromString(EDataType eDataType, String initialValue) {
		ParameterTypeEnum result = ParameterTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParameterTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskingPackage getTaskingPackage() {
		return (TaskingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TaskingPackage getPackage() {
		return TaskingPackage.eINSTANCE;
	}

} //TaskingFactoryImpl
