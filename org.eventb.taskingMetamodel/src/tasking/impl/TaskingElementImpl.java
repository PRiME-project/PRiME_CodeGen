/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.impl;

import org.eclipse.emf.ecore.EClass;
import org.eventb.emf.core.impl.EventBElementImpl;

import tasking.TaskingElement;
import tasking.TaskingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TaskingElementImpl extends EventBElementImpl implements TaskingElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskingElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskingPackage.Literals.TASKING_ELEMENT;
	}

} //TaskingElementImpl
