/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.impl.EventBNamedCommentedComponentElementImpl;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;

import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;
import ac.soton.compositionmodel.core.compositionmodel.IncludedMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getSees <em>Sees</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getComposesEvents <em>Composes Events</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getRefinesNames <em>Refines Names</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl#getSeesNames <em>Sees Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComposedMachineImpl extends EventBNamedCommentedComponentElementImpl implements ComposedMachine {
	/**
	 * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Invariant> invariants;

	/**
	 * The cached value of the '{@link #getSees() <em>Sees</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSees()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> sees;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Machine> refines;

	/**
	 * The cached value of the '{@link #getIncludes() <em>Includes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludes()
	 * @generated
	 * @ordered
	 */
	protected EList<IncludedMachine> includes;

	/**
	 * The cached value of the '{@link #getComposesEvents() <em>Composes Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposesEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ComposedEvent> composesEvents;

	/**
	 * The cached value of the '{@link #getRefinesNames() <em>Refines Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinesNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> refinesNames;

	/**
	 * The cached value of the '{@link #getSeesNames() <em>Sees Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeesNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> seesNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionmodelPackage.eINSTANCE.getComposedMachine();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Invariant> getInvariants() {
		if (invariants == null) {
			invariants = new EObjectContainmentEList<Invariant>(Invariant.class, this, CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS);
		}
		return invariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getSees() {
		if (sees == null) {
			sees = new EObjectResolvingEList<Context>(Context.class, this, CompositionmodelPackage.COMPOSED_MACHINE__SEES);
		}
		return sees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Machine> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<Machine>(Machine.class, this, CompositionmodelPackage.COMPOSED_MACHINE__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IncludedMachine> getIncludes() {
		if (includes == null) {
			includes = new EObjectContainmentEList.Resolving<IncludedMachine>(IncludedMachine.class, this, CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES);
		}
		return includes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComposedEvent> getComposesEvents() {
		if (composesEvents == null) {
			composesEvents = new EObjectContainmentEList.Resolving<ComposedEvent>(ComposedEvent.class, this, CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS);
		}
		return composesEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRefinesNames() {
		if (refinesNames == null) {
			refinesNames = new EDataTypeUniqueEList<String>(String.class, this, CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES);
		}
		return refinesNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSeesNames() {
		if (seesNames == null) {
			seesNames = new EDataTypeUniqueEList<String>(String.class, this, CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES);
		}
		return seesNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
				return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
				return ((InternalEList<?>)getIncludes()).basicRemove(otherEnd, msgs);
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
				return ((InternalEList<?>)getComposesEvents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
				return getInvariants();
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES:
				return getSees();
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES:
				return getRefines();
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
				return getIncludes();
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
				return getComposesEvents();
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES:
				return getRefinesNames();
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES:
				return getSeesNames();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
				getInvariants().clear();
				getInvariants().addAll((Collection<? extends Invariant>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES:
				getSees().clear();
				getSees().addAll((Collection<? extends Context>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends Machine>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
				getIncludes().clear();
				getIncludes().addAll((Collection<? extends IncludedMachine>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
				getComposesEvents().clear();
				getComposesEvents().addAll((Collection<? extends ComposedEvent>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES:
				getRefinesNames().clear();
				getRefinesNames().addAll((Collection<? extends String>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES:
				getSeesNames().clear();
				getSeesNames().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
				getInvariants().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES:
				getSees().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES:
				getRefines().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
				getIncludes().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
				getComposesEvents().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES:
				getRefinesNames().clear();
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES:
				getSeesNames().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES:
				return sees != null && !sees.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES:
				return refines != null && !refines.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
				return includes != null && !includes.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
				return composesEvents != null && !composesEvents.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES:
				return refinesNames != null && !refinesNames.isEmpty();
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES:
				return seesNames != null && !seesNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (refinesNames: ");
		result.append(refinesNames);
		result.append(", seesNames: ");
		result.append(seesNames);
		result.append(')');
		return result.toString();
	}

} //ComposedMachineImpl
