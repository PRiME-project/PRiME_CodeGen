/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;

import ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine;
import ac.soton.compositionmodel.core.compositionmodel.ComposedEvent;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composed Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl#getCombinesEvents <em>Combines Events</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl#getConvergence <em>Convergence</em>}</li>
 *   <li>{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl#getRefinesNames <em>Refines Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComposedEventImpl extends EventBNamedCommentedElementImpl implements ComposedEvent {
	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> refines;

	/**
	 * The cached value of the '{@link #getCombinesEvents() <em>Combines Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCombinesEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<CombinedEventMachine> combinesEvents;

	/**
	 * The default value of the '{@link #getConvergence() <em>Convergence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvergence()
	 * @generated
	 * @ordered
	 */
	protected static final Convergence CONVERGENCE_EDEFAULT = Convergence.ORDINARY;

	/**
	 * The cached value of the '{@link #getConvergence() <em>Convergence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvergence()
	 * @generated
	 * @ordered
	 */
	protected Convergence convergence = CONVERGENCE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionmodelPackage.eINSTANCE.getComposedEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<Event>(Event.class, this, CompositionmodelPackage.COMPOSED_EVENT__REFINES);
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CombinedEventMachine> getCombinesEvents() {
		if (combinesEvents == null) {
			combinesEvents = new EObjectContainmentEList.Resolving<CombinedEventMachine>(CombinedEventMachine.class, this, CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS);
		}
		return combinesEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Convergence getConvergence() {
		return convergence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConvergence(Convergence newConvergence) {
		Convergence oldConvergence = convergence;
		convergence = newConvergence == null ? CONVERGENCE_EDEFAULT : newConvergence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionmodelPackage.COMPOSED_EVENT__CONVERGENCE, oldConvergence, convergence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRefinesNames() {
		if (refinesNames == null) {
			refinesNames = new EDataTypeUniqueEList<String>(String.class, this, CompositionmodelPackage.COMPOSED_EVENT__REFINES_NAMES);
		}
		return refinesNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS:
				return ((InternalEList<?>)getCombinesEvents()).basicRemove(otherEnd, msgs);
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
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES:
				return getRefines();
			case CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS:
				return getCombinesEvents();
			case CompositionmodelPackage.COMPOSED_EVENT__CONVERGENCE:
				return getConvergence();
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES_NAMES:
				return getRefinesNames();
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
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends Event>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS:
				getCombinesEvents().clear();
				getCombinesEvents().addAll((Collection<? extends CombinedEventMachine>)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__CONVERGENCE:
				setConvergence((Convergence)newValue);
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES_NAMES:
				getRefinesNames().clear();
				getRefinesNames().addAll((Collection<? extends String>)newValue);
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
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES:
				getRefines().clear();
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS:
				getCombinesEvents().clear();
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__CONVERGENCE:
				setConvergence(CONVERGENCE_EDEFAULT);
				return;
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES_NAMES:
				getRefinesNames().clear();
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
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES:
				return refines != null && !refines.isEmpty();
			case CompositionmodelPackage.COMPOSED_EVENT__COMBINES_EVENTS:
				return combinesEvents != null && !combinesEvents.isEmpty();
			case CompositionmodelPackage.COMPOSED_EVENT__CONVERGENCE:
				return convergence != CONVERGENCE_EDEFAULT;
			case CompositionmodelPackage.COMPOSED_EVENT__REFINES_NAMES:
				return refinesNames != null && !refinesNames.isEmpty();
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
		result.append(" (convergence: ");
		result.append(convergence);
		result.append(", refinesNames: ");
		result.append(refinesNames);
		result.append(')');
		return result.toString();
	}

} //ComposedEventImpl
