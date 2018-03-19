/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory
 * @model kind="package"
 * @generated
 */
public interface CompositionmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "compositionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://compositionmodel.soton.ac/models/core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "compositionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompositionmodelPackage eINSTANCE = ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl <em>Composed Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.ComposedMachineImpl
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelPackageImpl#getComposedMachine()
	 * @generated
	 */
	int COMPOSED_MACHINE = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__ANNOTATIONS = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__EXTENSIONS = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__ATTRIBUTES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__REFERENCE = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__LOCAL_GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__INTERNAL_ID = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__COMMENT = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__NAME = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__INVARIANTS = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sees</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__SEES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__REFINES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__INCLUDES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Composes Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__COMPOSES_EVENTS = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Refines Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__REFINES_NAMES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sees Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE__SEES_NAMES = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Composed Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_MACHINE_FEATURE_COUNT = CorePackage.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl <em>Composed Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.ComposedEventImpl
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelPackageImpl#getComposedEvent()
	 * @generated
	 */
	int COMPOSED_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__ANNOTATIONS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__EXTENSIONS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__ATTRIBUTES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__REFERENCE = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__LOCAL_GENERATED = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__INTERNAL_ID = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__COMMENT = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__NAME = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__REFINES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Combines Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__COMBINES_EVENTS = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Convergence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__CONVERGENCE = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refines Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT__REFINES_NAMES = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Composed Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_EVENT_FEATURE_COUNT = CorePackage.EVENT_BNAMED_COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ac.soton.compositionmodel.core.compositionmodel.impl.IncludedMachineImpl <em>Included Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.IncludedMachineImpl
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelPackageImpl#getIncludedMachine()
	 * @generated
	 */
	int INCLUDED_MACHINE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__ANNOTATIONS = CorePackage.EVENT_BCOMMENTED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__EXTENSIONS = CorePackage.EVENT_BCOMMENTED_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__ATTRIBUTES = CorePackage.EVENT_BCOMMENTED_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__REFERENCE = CorePackage.EVENT_BCOMMENTED_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__GENERATED = CorePackage.EVENT_BCOMMENTED_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__LOCAL_GENERATED = CorePackage.EVENT_BCOMMENTED_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__INTERNAL_ID = CorePackage.EVENT_BCOMMENTED_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__COMMENT = CorePackage.EVENT_BCOMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__MACHINE = CorePackage.EVENT_BCOMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__MACHINE_NAME = CorePackage.EVENT_BCOMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE__PROJECT_NAME = CorePackage.EVENT_BCOMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Included Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDED_MACHINE_FEATURE_COUNT = CorePackage.EVENT_BCOMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl <em>Combined Event Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.CombinedEventMachineImpl
	 * @see ac.soton.compositionmodel.core.compositionmodel.impl.CompositionmodelPackageImpl#getCombinedEventMachine()
	 * @generated
	 */
	int COMBINED_EVENT_MACHINE = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__ANNOTATIONS = CorePackage.EVENT_BELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__EXTENSIONS = CorePackage.EVENT_BELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__ATTRIBUTES = CorePackage.EVENT_BELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__REFERENCE = CorePackage.EVENT_BELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__GENERATED = CorePackage.EVENT_BELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__LOCAL_GENERATED = CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__INTERNAL_ID = CorePackage.EVENT_BELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__MACHINE = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__EVENT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__MACHINE_NAME = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__EVENT_NAME = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE__PROJECT_NAME = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Combined Event Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINED_EVENT_MACHINE_FEATURE_COUNT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine <em>Composed Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Machine</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine
	 * @generated
	 */
	EClass getComposedMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getInvariants()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EReference getComposedMachine_Invariants();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSees <em>Sees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sees</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSees()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EReference getComposedMachine_Sees();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefines()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EReference getComposedMachine_Refines();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Includes</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getIncludes()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EReference getComposedMachine_Includes();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getComposesEvents <em>Composes Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composes Events</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getComposesEvents()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EReference getComposedMachine_ComposesEvents();

	/**
	 * Returns the meta object for the attribute list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefinesNames <em>Refines Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Refines Names</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getRefinesNames()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EAttribute getComposedMachine_RefinesNames();

	/**
	 * Returns the meta object for the attribute list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSeesNames <em>Sees Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sees Names</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedMachine#getSeesNames()
	 * @see #getComposedMachine()
	 * @generated
	 */
	EAttribute getComposedMachine_SeesNames();

	/**
	 * Returns the meta object for class '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent <em>Composed Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Event</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedEvent
	 * @generated
	 */
	EClass getComposedEvent();

	/**
	 * Returns the meta object for the reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefines()
	 * @see #getComposedEvent()
	 * @generated
	 */
	EReference getComposedEvent_Refines();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getCombinesEvents <em>Combines Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Combines Events</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getCombinesEvents()
	 * @see #getComposedEvent()
	 * @generated
	 */
	EReference getComposedEvent_CombinesEvents();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getConvergence <em>Convergence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Convergence</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getConvergence()
	 * @see #getComposedEvent()
	 * @generated
	 */
	EAttribute getComposedEvent_Convergence();

	/**
	 * Returns the meta object for the attribute list '{@link ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefinesNames <em>Refines Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Refines Names</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.ComposedEvent#getRefinesNames()
	 * @see #getComposedEvent()
	 * @generated
	 */
	EAttribute getComposedEvent_RefinesNames();

	/**
	 * Returns the meta object for class '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine <em>Included Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Included Machine</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.IncludedMachine
	 * @generated
	 */
	EClass getIncludedMachine();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachine()
	 * @see #getIncludedMachine()
	 * @generated
	 */
	EReference getIncludedMachine_Machine();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getMachineName()
	 * @see #getIncludedMachine()
	 * @generated
	 */
	EAttribute getIncludedMachine_MachineName();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.IncludedMachine#getProjectName()
	 * @see #getIncludedMachine()
	 * @generated
	 */
	EAttribute getIncludedMachine_ProjectName();

	/**
	 * Returns the meta object for class '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine <em>Combined Event Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combined Event Machine</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine
	 * @generated
	 */
	EClass getCombinedEventMachine();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getMachine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getMachine()
	 * @see #getCombinedEventMachine()
	 * @generated
	 */
	EReference getCombinedEventMachine_Machine();

	/**
	 * Returns the meta object for the reference '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getEvent()
	 * @see #getCombinedEventMachine()
	 * @generated
	 */
	EReference getCombinedEventMachine_Event();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getMachineName()
	 * @see #getCombinedEventMachine()
	 * @generated
	 */
	EAttribute getCombinedEventMachine_MachineName();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getEventName <em>Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Name</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getEventName()
	 * @see #getCombinedEventMachine()
	 * @generated
	 */
	EAttribute getCombinedEventMachine_EventName();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see ac.soton.compositionmodel.core.compositionmodel.CombinedEventMachine#getProjectName()
	 * @see #getCombinedEventMachine()
	 * @generated
	 */
	EAttribute getCombinedEventMachine_ProjectName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompositionmodelFactory getCompositionmodelFactory();

} //CompositionmodelPackage
