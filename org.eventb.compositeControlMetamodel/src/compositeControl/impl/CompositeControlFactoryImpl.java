/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.impl;

import compositeControl.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import compositeControl.Branch;
import compositeControl.CompositeControlFactory;
import compositeControl.CompositeControlPackage;
import compositeControl.Do;
import compositeControl.EventWrapper;
import compositeControl.Output;
import compositeControl.Seq;
import compositeControl.SubBranch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeControlFactoryImpl extends EFactoryImpl implements CompositeControlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompositeControlFactory init() {
		try {
			CompositeControlFactory theCompositeControlFactory = (CompositeControlFactory)EPackage.Registry.INSTANCE.getEFactory(CompositeControlPackage.eNS_URI);
			if (theCompositeControlFactory != null) {
				return theCompositeControlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompositeControlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlFactoryImpl() {
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
			case CompositeControlPackage.SEQ: return createSeq();
			case CompositeControlPackage.DO: return createDo();
			case CompositeControlPackage.BRANCH: return createBranch();
			case CompositeControlPackage.SUB_BRANCH: return createSubBranch();
			case CompositeControlPackage.EVENT_WRAPPER: return createEventWrapper();
			case CompositeControlPackage.OUTPUT: return createOutput();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Seq createSeq() {
		SeqImpl seq = new SeqImpl();
		return seq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Do createDo() {
		DoImpl do_ = new DoImpl();
		return do_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubBranch createSubBranch() {
		SubBranchImpl subBranch = new SubBranchImpl();
		return subBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventWrapper createEventWrapper() {
		EventWrapperImpl eventWrapper = new EventWrapperImpl();
		return eventWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlPackage getCompositeControlPackage() {
		return (CompositeControlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompositeControlPackage getPackage() {
		return CompositeControlPackage.eINSTANCE;
	}

} //CompositeControlFactoryImpl
