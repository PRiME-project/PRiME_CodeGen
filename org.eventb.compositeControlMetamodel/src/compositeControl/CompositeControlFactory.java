/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see compositeControl.CompositeControlPackage
 * @generated
 */
public interface CompositeControlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompositeControlFactory eINSTANCE = compositeControl.impl.CompositeControlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Seq</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seq</em>'.
	 * @generated
	 */
	Seq createSeq();

	/**
	 * Returns a new object of class '<em>Do</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do</em>'.
	 * @generated
	 */
	Do createDo();

	/**
	 * Returns a new object of class '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch</em>'.
	 * @generated
	 */
	Branch createBranch();

	/**
	 * Returns a new object of class '<em>Sub Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Branch</em>'.
	 * @generated
	 */
	SubBranch createSubBranch();

	/**
	 * Returns a new object of class '<em>Event Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Wrapper</em>'.
	 * @generated
	 */
	EventWrapper createEventWrapper();

	/**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
	Output createOutput();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompositeControlPackage getCompositeControlPackage();

} //CompositeControlFactory
