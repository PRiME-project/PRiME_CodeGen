/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.impl;

import ac.soton.compositionmodel.core.compositionmodel.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionmodelFactoryImpl extends EFactoryImpl implements CompositionmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositionmodelFactory init() {
		try {
			CompositionmodelFactory theCompositionmodelFactory = (CompositionmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://compositionmodel.soton.ac/models/core"); 
			if (theCompositionmodelFactory != null) {
				return theCompositionmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompositionmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionmodelFactoryImpl() {
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
			case CompositionmodelPackage.COMPOSED_MACHINE: return createComposedMachine();
			case CompositionmodelPackage.COMPOSED_EVENT: return createComposedEvent();
			case CompositionmodelPackage.INCLUDED_MACHINE: return createIncludedMachine();
			case CompositionmodelPackage.COMBINED_EVENT_MACHINE: return createCombinedEventMachine();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedMachine createComposedMachine() {
		ComposedMachineImpl composedMachine = new ComposedMachineImpl();
		return composedMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedEvent createComposedEvent() {
		ComposedEventImpl composedEvent = new ComposedEventImpl();
		return composedEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncludedMachine createIncludedMachine() {
		IncludedMachineImpl includedMachine = new IncludedMachineImpl();
		return includedMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CombinedEventMachine createCombinedEventMachine() {
		CombinedEventMachineImpl combinedEventMachine = new CombinedEventMachineImpl();
		return combinedEventMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionmodelPackage getCompositionmodelPackage() {
		return (CompositionmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompositionmodelPackage getPackage() {
		return CompositionmodelPackage.eINSTANCE;
	}

} //CompositionmodelFactoryImpl
