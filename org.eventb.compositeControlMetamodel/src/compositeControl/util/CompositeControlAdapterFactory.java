/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.util;

import compositeControl.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;

import compositeControl.Branch;
import compositeControl.CompositeControl;
import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;
import compositeControl.SubBranch;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see compositeControl.CompositeControlPackage
 * @generated
 */
public class CompositeControlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompositeControlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CompositeControlPackage.eINSTANCE;
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
	protected CompositeControlSwitch<Adapter> modelSwitch =
		new CompositeControlSwitch<Adapter>() {
			@Override
			public Adapter caseCompositeControl(CompositeControl object) {
				return createCompositeControlAdapter();
			}
			@Override
			public Adapter caseSeq(Seq object) {
				return createSeqAdapter();
			}
			@Override
			public Adapter caseDo(Do object) {
				return createDoAdapter();
			}
			@Override
			public Adapter caseBranch(Branch object) {
				return createBranchAdapter();
			}
			@Override
			public Adapter caseSubBranch(SubBranch object) {
				return createSubBranchAdapter();
			}
			@Override
			public Adapter caseEventWrapper(EventWrapper object) {
				return createEventWrapperAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
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
	 * Creates a new adapter for an object of class '{@link compositeControl.CompositeControl <em>Composite Control</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.CompositeControl
	 * @generated
	 */
	public Adapter createCompositeControlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.Seq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.Seq
	 * @generated
	 */
	public Adapter createSeqAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.Do <em>Do</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.Do
	 * @generated
	 */
	public Adapter createDoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.Branch
	 * @generated
	 */
	public Adapter createBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.SubBranch <em>Sub Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.SubBranch
	 * @generated
	 */
	public Adapter createSubBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.EventWrapper <em>Event Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.EventWrapper
	 * @generated
	 */
	public Adapter createEventWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link compositeControl.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see compositeControl.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
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

} //CompositeControlAdapterFactory
