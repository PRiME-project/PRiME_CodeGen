/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tasking.TaskingPackage
 * @generated
 */
public interface TaskingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TaskingFactory eINSTANCE = tasking.impl.TaskingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Main</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Main</em>'.
	 * @generated
	 */
	Main createMain();

	/**
	 * Returns a new object of class '<em>Tasking Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tasking Machine</em>'.
	 * @generated
	 */
	Tasking_Machine createTasking_Machine();

	/**
	 * Returns a new object of class '<em>Shared Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shared Machine</em>'.
	 * @generated
	 */
	Shared_Machine createShared_Machine();

	/**
	 * Returns a new object of class '<em>Environ Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environ Machine</em>'.
	 * @generated
	 */
	Environ_Machine createEnviron_Machine();

	/**
	 * Returns a new object of class '<em>FMU Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU Machine</em>'.
	 * @generated
	 */
	FMU_Machine createFMU_Machine();

	/**
	 * Returns a new object of class '<em>Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation</em>'.
	 * @generated
	 */
	Implementation createImplementation();

	/**
	 * Returns a new object of class '<em>Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Type</em>'.
	 * @generated
	 */
	ParameterType createParameterType();

	/**
	 * Returns a new object of class '<em>Auto Task Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Auto Task Machine</em>'.
	 * @generated
	 */
	AutoTask_Machine createAutoTask_Machine();

	/**
	 * Returns a new object of class '<em>Simple Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Task Type</em>'.
	 * @generated
	 */
	SimpleTaskType createSimpleTaskType();

	/**
	 * Returns a new object of class '<em>Periodic Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Periodic Task Type</em>'.
	 * @generated
	 */
	PeriodicTaskType createPeriodicTaskType();

	/**
	 * Returns a new object of class '<em>Addressed Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addressed Variable</em>'.
	 * @generated
	 */
	AddressedVariable createAddressedVariable();

	/**
	 * Returns a new object of class '<em>Typing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typing</em>'.
	 * @generated
	 */
	Typing createTyping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TaskingPackage getTaskingPackage();

} //TaskingFactory
