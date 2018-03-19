package compositeControl;


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
 * @see compositeControl.CompositeControlFactory
 * @model kind="package"
 * @generated
 */
public interface CompositeControlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "compositeControl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://compositeControl.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "compositeControl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompositeControlPackage eINSTANCE = compositeControl.impl.CompositeControlPackageImpl.init();

	/**
	 * The meta object id for the '{@link compositeControl.impl.CompositeControlImpl <em>Composite Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.CompositeControlImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getCompositeControl()
	 * @generated
	 */
	int COMPOSITE_CONTROL = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__ANNOTATIONS = CorePackage.ABSTRACT_EXTENSION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__EXTENSIONS = CorePackage.ABSTRACT_EXTENSION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__ATTRIBUTES = CorePackage.ABSTRACT_EXTENSION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__REFERENCE = CorePackage.ABSTRACT_EXTENSION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__GENERATED = CorePackage.ABSTRACT_EXTENSION__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__LOCAL_GENERATED = CorePackage.ABSTRACT_EXTENSION__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__INTERNAL_ID = CorePackage.ABSTRACT_EXTENSION__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__EXTENSION_ID = CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONTROL_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link compositeControl.impl.SeqImpl <em>Seq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.SeqImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getSeq()
	 * @generated
	 */
	int SEQ = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Left Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__LEFT_BRANCH = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__RIGHT_BRANCH = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Seq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link compositeControl.impl.DoImpl <em>Do</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.DoImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getDo()
	 * @generated
	 */
	int DO = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__LABEL = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__TASK_BODY = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO__FINALLY = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Do</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link compositeControl.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.BranchImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__LABEL = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__EVENT_WRAPPER = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__SUB_BRANCH = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alt</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ALT = COMPOSITE_CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link compositeControl.impl.SubBranchImpl <em>Sub Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.SubBranchImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getSubBranch()
	 * @generated
	 */
	int SUB_BRANCH = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Event Wrapper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__EVENT_WRAPPER = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH__SUB_BRANCH = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sub Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_BRANCH_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link compositeControl.impl.EventWrapperImpl <em>Event Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.EventWrapperImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getEventWrapper()
	 * @generated
	 */
	int EVENT_WRAPPER = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__LABEL = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__EVENT = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER__EVENT_NAME = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_WRAPPER_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link compositeControl.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see compositeControl.impl.OutputImpl
	 * @see compositeControl.impl.CompositeControlPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ANNOTATIONS = COMPOSITE_CONTROL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__EXTENSIONS = COMPOSITE_CONTROL__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ATTRIBUTES = COMPOSITE_CONTROL__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__REFERENCE = COMPOSITE_CONTROL__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__GENERATED = COMPOSITE_CONTROL__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__LOCAL_GENERATED = COMPOSITE_CONTROL__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__INTERNAL_ID = COMPOSITE_CONTROL__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__EXTENSION_ID = COMPOSITE_CONTROL__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ENVIR_STATE_MACHINE_CHILD = COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__TEXT = COMPOSITE_CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ELEMENT = COMPOSITE_CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__VARIABLE_NAME = COMPOSITE_CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = COMPOSITE_CONTROL_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link compositeControl.CompositeControl <em>Composite Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Control</em>'.
	 * @see compositeControl.CompositeControl
	 * @generated
	 */
	EClass getCompositeControl();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.CompositeControl#isEnvirStateMachineChild <em>Envir State Machine Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Envir State Machine Child</em>'.
	 * @see compositeControl.CompositeControl#isEnvirStateMachineChild()
	 * @see #getCompositeControl()
	 * @generated
	 */
	EAttribute getCompositeControl_EnvirStateMachineChild();

	/**
	 * Returns the meta object for class '{@link compositeControl.Seq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seq</em>'.
	 * @see compositeControl.Seq
	 * @generated
	 */
	EClass getSeq();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Seq#getLeftBranch <em>Left Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Branch</em>'.
	 * @see compositeControl.Seq#getLeftBranch()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_LeftBranch();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Seq#getRightBranch <em>Right Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Branch</em>'.
	 * @see compositeControl.Seq#getRightBranch()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_RightBranch();

	/**
	 * Returns the meta object for class '{@link compositeControl.Do <em>Do</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Do</em>'.
	 * @see compositeControl.Do
	 * @generated
	 */
	EClass getDo();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.Do#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see compositeControl.Do#getLabel()
	 * @see #getDo()
	 * @generated
	 */
	EAttribute getDo_Label();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Do#getTaskBody <em>Task Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Body</em>'.
	 * @see compositeControl.Do#getTaskBody()
	 * @see #getDo()
	 * @generated
	 */
	EReference getDo_TaskBody();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Do#getFinally <em>Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally</em>'.
	 * @see compositeControl.Do#getFinally()
	 * @see #getDo()
	 * @generated
	 */
	EReference getDo_Finally();

	/**
	 * Returns the meta object for class '{@link compositeControl.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see compositeControl.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.Branch#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see compositeControl.Branch#getLabel()
	 * @see #getBranch()
	 * @generated
	 */
	EAttribute getBranch_Label();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Branch#getEventWrapper <em>Event Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Wrapper</em>'.
	 * @see compositeControl.Branch#getEventWrapper()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_EventWrapper();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Branch#getSubBranch <em>Sub Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Branch</em>'.
	 * @see compositeControl.Branch#getSubBranch()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_SubBranch();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.Branch#getAlt <em>Alt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Alt</em>'.
	 * @see compositeControl.Branch#getAlt()
	 * @see #getBranch()
	 * @generated
	 */
	EReference getBranch_Alt();

	/**
	 * Returns the meta object for class '{@link compositeControl.SubBranch <em>Sub Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Branch</em>'.
	 * @see compositeControl.SubBranch
	 * @generated
	 */
	EClass getSubBranch();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.SubBranch#getEventWrapper <em>Event Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Wrapper</em>'.
	 * @see compositeControl.SubBranch#getEventWrapper()
	 * @see #getSubBranch()
	 * @generated
	 */
	EReference getSubBranch_EventWrapper();

	/**
	 * Returns the meta object for the containment reference '{@link compositeControl.SubBranch#getSubBranch <em>Sub Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Branch</em>'.
	 * @see compositeControl.SubBranch#getSubBranch()
	 * @see #getSubBranch()
	 * @generated
	 */
	EReference getSubBranch_SubBranch();

	/**
	 * Returns the meta object for class '{@link compositeControl.EventWrapper <em>Event Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Wrapper</em>'.
	 * @see compositeControl.EventWrapper
	 * @generated
	 */
	EClass getEventWrapper();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.EventWrapper#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see compositeControl.EventWrapper#getLabel()
	 * @see #getEventWrapper()
	 * @generated
	 */
	EAttribute getEventWrapper_Label();

	/**
	 * Returns the meta object for the reference '{@link compositeControl.EventWrapper#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see compositeControl.EventWrapper#getEvent()
	 * @see #getEventWrapper()
	 * @generated
	 */
	EReference getEventWrapper_Event();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.EventWrapper#getEventName <em>Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Name</em>'.
	 * @see compositeControl.EventWrapper#getEventName()
	 * @see #getEventWrapper()
	 * @generated
	 */
	EAttribute getEventWrapper_EventName();

	/**
	 * Returns the meta object for class '{@link compositeControl.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see compositeControl.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.Output#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see compositeControl.Output#getText()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Text();

	/**
	 * Returns the meta object for the reference '{@link compositeControl.Output#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see compositeControl.Output#getElement()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Element();

	/**
	 * Returns the meta object for the attribute '{@link compositeControl.Output#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see compositeControl.Output#getVariableName()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_VariableName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompositeControlFactory getCompositeControlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link compositeControl.impl.CompositeControlImpl <em>Composite Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.CompositeControlImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getCompositeControl()
		 * @generated
		 */
		EClass COMPOSITE_CONTROL = eINSTANCE.getCompositeControl();

		/**
		 * The meta object literal for the '<em><b>Envir State Machine Child</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD = eINSTANCE.getCompositeControl_EnvirStateMachineChild();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.SeqImpl <em>Seq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.SeqImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getSeq()
		 * @generated
		 */
		EClass SEQ = eINSTANCE.getSeq();

		/**
		 * The meta object literal for the '<em><b>Left Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQ__LEFT_BRANCH = eINSTANCE.getSeq_LeftBranch();

		/**
		 * The meta object literal for the '<em><b>Right Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQ__RIGHT_BRANCH = eINSTANCE.getSeq_RightBranch();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.DoImpl <em>Do</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.DoImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getDo()
		 * @generated
		 */
		EClass DO = eINSTANCE.getDo();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DO__LABEL = eINSTANCE.getDo_Label();

		/**
		 * The meta object literal for the '<em><b>Task Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO__TASK_BODY = eINSTANCE.getDo_TaskBody();

		/**
		 * The meta object literal for the '<em><b>Finally</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO__FINALLY = eINSTANCE.getDo_Finally();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.BranchImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRANCH__LABEL = eINSTANCE.getBranch_Label();

		/**
		 * The meta object literal for the '<em><b>Event Wrapper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__EVENT_WRAPPER = eINSTANCE.getBranch_EventWrapper();

		/**
		 * The meta object literal for the '<em><b>Sub Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__SUB_BRANCH = eINSTANCE.getBranch_SubBranch();

		/**
		 * The meta object literal for the '<em><b>Alt</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH__ALT = eINSTANCE.getBranch_Alt();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.SubBranchImpl <em>Sub Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.SubBranchImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getSubBranch()
		 * @generated
		 */
		EClass SUB_BRANCH = eINSTANCE.getSubBranch();

		/**
		 * The meta object literal for the '<em><b>Event Wrapper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_BRANCH__EVENT_WRAPPER = eINSTANCE.getSubBranch_EventWrapper();

		/**
		 * The meta object literal for the '<em><b>Sub Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_BRANCH__SUB_BRANCH = eINSTANCE.getSubBranch_SubBranch();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.EventWrapperImpl <em>Event Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.EventWrapperImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getEventWrapper()
		 * @generated
		 */
		EClass EVENT_WRAPPER = eINSTANCE.getEventWrapper();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_WRAPPER__LABEL = eINSTANCE.getEventWrapper_Label();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_WRAPPER__EVENT = eINSTANCE.getEventWrapper_Event();

		/**
		 * The meta object literal for the '<em><b>Event Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_WRAPPER__EVENT_NAME = eINSTANCE.getEventWrapper_EventName();

		/**
		 * The meta object literal for the '{@link compositeControl.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see compositeControl.impl.OutputImpl
		 * @see compositeControl.impl.CompositeControlPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__TEXT = eINSTANCE.getOutput_Text();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__ELEMENT = eINSTANCE.getOutput_Element();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__VARIABLE_NAME = eINSTANCE.getOutput_VariableName();

	}

} //CompositeControlPackage