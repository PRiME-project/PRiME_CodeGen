/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.util;

import compositeControl.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see compositeControl.CompositeControlPackage
 * @generated
 */
public class CompositeControlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CompositeControlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlSwitch() {
		if (modelPackage == null) {
			modelPackage = CompositeControlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CompositeControlPackage.COMPOSITE_CONTROL: {
				CompositeControl compositeControl = (CompositeControl)theEObject;
				T result = caseCompositeControl(compositeControl);
				if (result == null) result = caseAbstractExtension(compositeControl);
				if (result == null) result = caseEventBElement(compositeControl);
				if (result == null) result = caseEventBObject(compositeControl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.SEQ: {
				Seq seq = (Seq)theEObject;
				T result = caseSeq(seq);
				if (result == null) result = caseCompositeControl(seq);
				if (result == null) result = caseAbstractExtension(seq);
				if (result == null) result = caseEventBElement(seq);
				if (result == null) result = caseEventBObject(seq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.DO: {
				Do do_ = (Do)theEObject;
				T result = caseDo(do_);
				if (result == null) result = caseCompositeControl(do_);
				if (result == null) result = caseAbstractExtension(do_);
				if (result == null) result = caseEventBElement(do_);
				if (result == null) result = caseEventBObject(do_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.BRANCH: {
				Branch branch = (Branch)theEObject;
				T result = caseBranch(branch);
				if (result == null) result = caseCompositeControl(branch);
				if (result == null) result = caseAbstractExtension(branch);
				if (result == null) result = caseEventBElement(branch);
				if (result == null) result = caseEventBObject(branch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.SUB_BRANCH: {
				SubBranch subBranch = (SubBranch)theEObject;
				T result = caseSubBranch(subBranch);
				if (result == null) result = caseCompositeControl(subBranch);
				if (result == null) result = caseAbstractExtension(subBranch);
				if (result == null) result = caseEventBElement(subBranch);
				if (result == null) result = caseEventBObject(subBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.EVENT_WRAPPER: {
				EventWrapper eventWrapper = (EventWrapper)theEObject;
				T result = caseEventWrapper(eventWrapper);
				if (result == null) result = caseCompositeControl(eventWrapper);
				if (result == null) result = caseAbstractExtension(eventWrapper);
				if (result == null) result = caseEventBElement(eventWrapper);
				if (result == null) result = caseEventBObject(eventWrapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CompositeControlPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = caseCompositeControl(output);
				if (result == null) result = caseAbstractExtension(output);
				if (result == null) result = caseEventBElement(output);
				if (result == null) result = caseEventBObject(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeControl(CompositeControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeq(Seq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDo(Do object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranch(Branch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubBranch(SubBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventWrapper(EventWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CompositeControlSwitch
