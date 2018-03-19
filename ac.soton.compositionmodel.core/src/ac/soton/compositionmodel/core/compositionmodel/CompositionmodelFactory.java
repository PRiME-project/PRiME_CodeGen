/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage
 * @generated
 */
public interface CompositionmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompositionmodelFactory eINSTANCE = ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Composed Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Machine</em>'.
	 * @generated
	 */
	ComposedMachine createComposedMachine();

	/**
	 * Returns a new object of class '<em>Composed Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composed Event</em>'.
	 * @generated
	 */
	ComposedEvent createComposedEvent();

	/**
	 * Returns a new object of class '<em>Included Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Included Machine</em>'.
	 * @generated
	 */
	IncludedMachine createIncludedMachine();

	/**
	 * Returns a new object of class '<em>Combined Event Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combined Event Machine</em>'.
	 * @generated
	 */
	CombinedEventMachine createCombinedEventMachine();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CompositionmodelPackage getCompositionmodelPackage();

} //CompositionmodelFactory
