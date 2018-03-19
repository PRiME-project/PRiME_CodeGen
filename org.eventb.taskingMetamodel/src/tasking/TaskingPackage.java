/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see tasking.TaskingFactory
 * @model kind="package"
 * @generated
 */
public interface TaskingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tasking";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://tasking.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tasking";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TaskingPackage eINSTANCE = tasking.impl.TaskingPackageImpl.init();

	/**
	 * The meta object id for the '{@link tasking.impl.MainImpl <em>Main</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.MainImpl
	 * @see tasking.impl.TaskingPackageImpl#getMain()
	 * @generated
	 */
	int MAIN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Main Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__MAIN_BODY = 1;

	/**
	 * The feature id for the '<em><b>Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__MACHINES = 2;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__CONTEXTS = 3;

	/**
	 * The number of structural features of the '<em>Main</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link tasking.impl.AbstractExtensionTaskingElementImpl <em>Abstract Extension Tasking Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.AbstractExtensionTaskingElementImpl
	 * @see tasking.impl.TaskingPackageImpl#getAbstractExtensionTaskingElement()
	 * @generated
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS = CorePackage.ABSTRACT_EXTENSION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS = CorePackage.ABSTRACT_EXTENSION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES = CorePackage.ABSTRACT_EXTENSION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE = CorePackage.ABSTRACT_EXTENSION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED = CorePackage.ABSTRACT_EXTENSION__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED = CorePackage.ABSTRACT_EXTENSION__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID = CorePackage.ABSTRACT_EXTENSION__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID = CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;

	/**
	 * The number of structural features of the '<em>Abstract Extension Tasking Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.TaskImpl
	 * @see tasking.impl.TaskingPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TASK_TYPE = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PRIORITY = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TASK_BODY = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link tasking.impl.AutoTask_MachineImpl <em>Auto Task Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.AutoTask_MachineImpl
	 * @see tasking.impl.TaskingPackageImpl#getAutoTask_Machine()
	 * @generated
	 */
	int AUTO_TASK_MACHINE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__ANNOTATIONS = TASK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__EXTENSIONS = TASK__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__ATTRIBUTES = TASK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__REFERENCE = TASK__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__GENERATED = TASK__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__LOCAL_GENERATED = TASK__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__INTERNAL_ID = TASK__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__EXTENSION_ID = TASK__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__TASK_TYPE = TASK__TASK_TYPE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__PRIORITY = TASK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE__TASK_BODY = TASK__TASK_BODY;

	/**
	 * The number of structural features of the '<em>Auto Task Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_TASK_MACHINE_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.Tasking_MachineImpl <em>Tasking Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.Tasking_MachineImpl
	 * @see tasking.impl.TaskingPackageImpl#getTasking_Machine()
	 * @generated
	 */
	int TASKING_MACHINE = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__ANNOTATIONS = TASK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__EXTENSIONS = TASK__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__ATTRIBUTES = TASK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__REFERENCE = TASK__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__GENERATED = TASK__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__LOCAL_GENERATED = TASK__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__INTERNAL_ID = TASK__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__EXTENSION_ID = TASK__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__TASK_TYPE = TASK__TASK_TYPE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__PRIORITY = TASK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE__TASK_BODY = TASK__TASK_BODY;

	/**
	 * The number of structural features of the '<em>Tasking Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_MACHINE_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.Environ_MachineImpl <em>Environ Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.Environ_MachineImpl
	 * @see tasking.impl.TaskingPackageImpl#getEnviron_Machine()
	 * @generated
	 */
	int ENVIRON_MACHINE = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__ANNOTATIONS = TASK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__EXTENSIONS = TASK__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__ATTRIBUTES = TASK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__REFERENCE = TASK__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__GENERATED = TASK__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__LOCAL_GENERATED = TASK__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__INTERNAL_ID = TASK__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__EXTENSION_ID = TASK__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__TASK_TYPE = TASK__TASK_TYPE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__PRIORITY = TASK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE__TASK_BODY = TASK__TASK_BODY;

	/**
	 * The number of structural features of the '<em>Environ Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_MACHINE_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.FMU_MachineImpl <em>FMU Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.FMU_MachineImpl
	 * @see tasking.impl.TaskingPackageImpl#getFMU_Machine()
	 * @generated
	 */
	int FMU_MACHINE = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__ANNOTATIONS = TASK__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__EXTENSIONS = TASK__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__ATTRIBUTES = TASK__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__REFERENCE = TASK__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__GENERATED = TASK__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__LOCAL_GENERATED = TASK__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__INTERNAL_ID = TASK__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__EXTENSION_ID = TASK__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__TASK_TYPE = TASK__TASK_TYPE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__PRIORITY = TASK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Task Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE__TASK_BODY = TASK__TASK_BODY;

	/**
	 * The number of structural features of the '<em>FMU Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_MACHINE_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.Shared_MachineImpl <em>Shared Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.Shared_MachineImpl
	 * @see tasking.impl.TaskingPackageImpl#getShared_Machine()
	 * @generated
	 */
	int SHARED_MACHINE = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The number of structural features of the '<em>Shared Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_MACHINE_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.ImplementationImpl
	 * @see tasking.impl.TaskingPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Implementation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__IMPLEMENTATION_TYPE = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tasking.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.ParameterTypeImpl
	 * @see tasking.impl.TaskingPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__PARAMETER_TYPE = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tasking.impl.EventBElementTaskingElementImpl <em>Event BElement Tasking Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.EventBElementTaskingElementImpl
	 * @see tasking.impl.TaskingPackageImpl#getEventBElementTaskingElement()
	 * @generated
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__ANNOTATIONS = CorePackage.EVENT_BELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__EXTENSIONS = CorePackage.EVENT_BELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__ATTRIBUTES = CorePackage.EVENT_BELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__REFERENCE = CorePackage.EVENT_BELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__GENERATED = CorePackage.EVENT_BELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__LOCAL_GENERATED = CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT__INTERNAL_ID = CorePackage.EVENT_BELEMENT__INTERNAL_ID;

	/**
	 * The number of structural features of the '<em>Event BElement Tasking Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BELEMENT_TASKING_ELEMENT_FEATURE_COUNT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.TaskTypeImpl <em>Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.TaskTypeImpl
	 * @see tasking.impl.TaskingPackageImpl#getTaskType()
	 * @generated
	 */
	int TASK_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__ANNOTATIONS = EVENT_BELEMENT_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__EXTENSIONS = EVENT_BELEMENT_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__ATTRIBUTES = EVENT_BELEMENT_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__REFERENCE = EVENT_BELEMENT_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__GENERATED = EVENT_BELEMENT_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__LOCAL_GENERATED = EVENT_BELEMENT_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE__INTERNAL_ID = EVENT_BELEMENT_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The number of structural features of the '<em>Task Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE_FEATURE_COUNT = EVENT_BELEMENT_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.SimpleTaskTypeImpl <em>Simple Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.SimpleTaskTypeImpl
	 * @see tasking.impl.TaskingPackageImpl#getSimpleTaskType()
	 * @generated
	 */
	int SIMPLE_TASK_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__ANNOTATIONS = TASK_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__EXTENSIONS = TASK_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__ATTRIBUTES = TASK_TYPE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__REFERENCE = TASK_TYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__GENERATED = TASK_TYPE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__LOCAL_GENERATED = TASK_TYPE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__INTERNAL_ID = TASK_TYPE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE__TYPE = TASK_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Task Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TASK_TYPE_FEATURE_COUNT = TASK_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tasking.impl.PeriodicTaskTypeImpl <em>Periodic Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.PeriodicTaskTypeImpl
	 * @see tasking.impl.TaskingPackageImpl#getPeriodicTaskType()
	 * @generated
	 */
	int PERIODIC_TASK_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__ANNOTATIONS = TASK_TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__EXTENSIONS = TASK_TYPE__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__ATTRIBUTES = TASK_TYPE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__REFERENCE = TASK_TYPE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__GENERATED = TASK_TYPE__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__LOCAL_GENERATED = TASK_TYPE__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__INTERNAL_ID = TASK_TYPE__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE__PERIOD = TASK_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Periodic Task Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_TASK_TYPE_FEATURE_COUNT = TASK_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tasking.impl.SensorImpl <em>Sensor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.SensorImpl
	 * @see tasking.impl.TaskingPackageImpl#getSensor()
	 * @generated
	 */
	int SENSOR = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The number of structural features of the '<em>Sensor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.AddressedVariableImpl <em>Addressed Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.AddressedVariableImpl
	 * @see tasking.impl.TaskingPackageImpl#getAddressedVariable()
	 * @generated
	 */
	int ADDRESSED_VARIABLE = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__ANNOTATIONS = SENSOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__EXTENSIONS = SENSOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__ATTRIBUTES = SENSOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__REFERENCE = SENSOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__GENERATED = SENSOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__LOCAL_GENERATED = SENSOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__INTERNAL_ID = SENSOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__EXTENSION_ID = SENSOR__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__BASE = SENSOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE__ADDRESS = SENSOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Addressed Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESSED_VARIABLE_FEATURE_COUNT = SENSOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link tasking.impl.TaskingElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.TaskingElementImpl
	 * @see tasking.impl.TaskingPackageImpl#getTaskingElement()
	 * @generated
	 */
	int TASKING_ELEMENT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__ANNOTATIONS = CorePackage.EVENT_BELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__EXTENSIONS = CorePackage.EVENT_BELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__ATTRIBUTES = CorePackage.EVENT_BELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__REFERENCE = CorePackage.EVENT_BELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__GENERATED = CorePackage.EVENT_BELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__LOCAL_GENERATED = CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT__INTERNAL_ID = CorePackage.EVENT_BELEMENT__INTERNAL_ID;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASKING_ELEMENT_FEATURE_COUNT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.impl.MachineTypeImpl <em>Machine Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.MachineTypeImpl
	 * @see tasking.impl.TaskingPackageImpl#getMachineType()
	 * @generated
	 */
	int MACHINE_TYPE = 17;

	/**
	 * The number of structural features of the '<em>Machine Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link tasking.impl.TypingImpl <em>Typing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.impl.TypingImpl
	 * @see tasking.impl.TaskingPackageImpl#getTyping()
	 * @generated
	 */
	int TYPING = 18;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__ANNOTATIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__EXTENSIONS = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__ATTRIBUTES = ABSTRACT_EXTENSION_TASKING_ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__REFERENCE = ABSTRACT_EXTENSION_TASKING_ELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__LOCAL_GENERATED = ABSTRACT_EXTENSION_TASKING_ELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__INTERNAL_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING__EXTENSION_ID = ABSTRACT_EXTENSION_TASKING_ELEMENT__EXTENSION_ID;

	/**
	 * The number of structural features of the '<em>Typing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING_FEATURE_COUNT = ABSTRACT_EXTENSION_TASKING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tasking.TaskTypeEnum <em>Task Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.TaskTypeEnum
	 * @see tasking.impl.TaskingPackageImpl#getTaskTypeEnum()
	 * @generated
	 */
	int TASK_TYPE_ENUM = 19;

	/**
	 * The meta object id for the '{@link tasking.ImplementationTypeEnum <em>Implementation Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.ImplementationTypeEnum
	 * @see tasking.impl.TaskingPackageImpl#getImplementationTypeEnum()
	 * @generated
	 */
	int IMPLEMENTATION_TYPE_ENUM = 20;

	/**
	 * The meta object id for the '{@link tasking.ParameterTypeEnum <em>Parameter Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tasking.ParameterTypeEnum
	 * @see tasking.impl.TaskingPackageImpl#getParameterTypeEnum()
	 * @generated
	 */
	int PARAMETER_TYPE_ENUM = 21;


	/**
	 * Returns the meta object for class '{@link tasking.Main <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Main</em>'.
	 * @see tasking.Main
	 * @generated
	 */
	EClass getMain();

	/**
	 * Returns the meta object for the attribute '{@link tasking.Main#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tasking.Main#getName()
	 * @see #getMain()
	 * @generated
	 */
	EAttribute getMain_Name();

	/**
	 * Returns the meta object for the containment reference '{@link tasking.Main#getMainBody <em>Main Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Body</em>'.
	 * @see tasking.Main#getMainBody()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_MainBody();

	/**
	 * Returns the meta object for the containment reference list '{@link tasking.Main#getMachines <em>Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machines</em>'.
	 * @see tasking.Main#getMachines()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Machines();

	/**
	 * Returns the meta object for the containment reference list '{@link tasking.Main#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see tasking.Main#getContexts()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Contexts();

	/**
	 * Returns the meta object for class '{@link tasking.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see tasking.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the containment reference '{@link tasking.Task#getTaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Type</em>'.
	 * @see tasking.Task#getTaskType()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_TaskType();

	/**
	 * Returns the meta object for the attribute '{@link tasking.Task#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see tasking.Task#getPriority()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link tasking.Task#getTaskBody <em>Task Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Body</em>'.
	 * @see tasking.Task#getTaskBody()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_TaskBody();

	/**
	 * Returns the meta object for class '{@link tasking.AutoTask_Machine <em>Auto Task Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auto Task Machine</em>'.
	 * @see tasking.AutoTask_Machine
	 * @generated
	 */
	EClass getAutoTask_Machine();

	/**
	 * Returns the meta object for class '{@link tasking.Tasking_Machine <em>Tasking Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tasking Machine</em>'.
	 * @see tasking.Tasking_Machine
	 * @generated
	 */
	EClass getTasking_Machine();

	/**
	 * Returns the meta object for class '{@link tasking.Environ_Machine <em>Environ Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environ Machine</em>'.
	 * @see tasking.Environ_Machine
	 * @generated
	 */
	EClass getEnviron_Machine();

	/**
	 * Returns the meta object for class '{@link tasking.FMU_Machine <em>FMU Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Machine</em>'.
	 * @see tasking.FMU_Machine
	 * @generated
	 */
	EClass getFMU_Machine();

	/**
	 * Returns the meta object for class '{@link tasking.Shared_Machine <em>Shared Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Machine</em>'.
	 * @see tasking.Shared_Machine
	 * @generated
	 */
	EClass getShared_Machine();

	/**
	 * Returns the meta object for class '{@link tasking.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see tasking.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for the attribute '{@link tasking.Implementation#getImplementationType <em>Implementation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Type</em>'.
	 * @see tasking.Implementation#getImplementationType()
	 * @see #getImplementation()
	 * @generated
	 */
	EAttribute getImplementation_ImplementationType();

	/**
	 * Returns the meta object for class '{@link tasking.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Type</em>'.
	 * @see tasking.ParameterType
	 * @generated
	 */
	EClass getParameterType();

	/**
	 * Returns the meta object for the attribute '{@link tasking.ParameterType#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Type</em>'.
	 * @see tasking.ParameterType#getParameterType()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_ParameterType();

	/**
	 * Returns the meta object for class '{@link tasking.TaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Type</em>'.
	 * @see tasking.TaskType
	 * @generated
	 */
	EClass getTaskType();

	/**
	 * Returns the meta object for class '{@link tasking.SimpleTaskType <em>Simple Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Task Type</em>'.
	 * @see tasking.SimpleTaskType
	 * @generated
	 */
	EClass getSimpleTaskType();

	/**
	 * Returns the meta object for the attribute '{@link tasking.SimpleTaskType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see tasking.SimpleTaskType#getType()
	 * @see #getSimpleTaskType()
	 * @generated
	 */
	EAttribute getSimpleTaskType_Type();

	/**
	 * Returns the meta object for class '{@link tasking.PeriodicTaskType <em>Periodic Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodic Task Type</em>'.
	 * @see tasking.PeriodicTaskType
	 * @generated
	 */
	EClass getPeriodicTaskType();

	/**
	 * Returns the meta object for the attribute '{@link tasking.PeriodicTaskType#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see tasking.PeriodicTaskType#getPeriod()
	 * @see #getPeriodicTaskType()
	 * @generated
	 */
	EAttribute getPeriodicTaskType_Period();

	/**
	 * Returns the meta object for class '{@link tasking.Sensor <em>Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor</em>'.
	 * @see tasking.Sensor
	 * @generated
	 */
	EClass getSensor();

	/**
	 * Returns the meta object for class '{@link tasking.AddressedVariable <em>Addressed Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addressed Variable</em>'.
	 * @see tasking.AddressedVariable
	 * @generated
	 */
	EClass getAddressedVariable();

	/**
	 * Returns the meta object for the attribute '{@link tasking.AddressedVariable#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base</em>'.
	 * @see tasking.AddressedVariable#getBase()
	 * @see #getAddressedVariable()
	 * @generated
	 */
	EAttribute getAddressedVariable_Base();

	/**
	 * Returns the meta object for the attribute '{@link tasking.AddressedVariable#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see tasking.AddressedVariable#getAddress()
	 * @see #getAddressedVariable()
	 * @generated
	 */
	EAttribute getAddressedVariable_Address();

	/**
	 * Returns the meta object for class '{@link tasking.TaskingElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see tasking.TaskingElement
	 * @generated
	 */
	EClass getTaskingElement();

	/**
	 * Returns the meta object for class '{@link tasking.AbstractExtensionTaskingElement <em>Abstract Extension Tasking Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Extension Tasking Element</em>'.
	 * @see tasking.AbstractExtensionTaskingElement
	 * @generated
	 */
	EClass getAbstractExtensionTaskingElement();

	/**
	 * Returns the meta object for class '{@link tasking.EventBElementTaskingElement <em>Event BElement Tasking Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event BElement Tasking Element</em>'.
	 * @see tasking.EventBElementTaskingElement
	 * @generated
	 */
	EClass getEventBElementTaskingElement();

	/**
	 * Returns the meta object for class '{@link tasking.MachineType <em>Machine Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Type</em>'.
	 * @see tasking.MachineType
	 * @generated
	 */
	EClass getMachineType();

	/**
	 * Returns the meta object for class '{@link tasking.Typing <em>Typing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typing</em>'.
	 * @see tasking.Typing
	 * @generated
	 */
	EClass getTyping();

	/**
	 * Returns the meta object for enum '{@link tasking.TaskTypeEnum <em>Task Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Task Type Enum</em>'.
	 * @see tasking.TaskTypeEnum
	 * @generated
	 */
	EEnum getTaskTypeEnum();

	/**
	 * Returns the meta object for enum '{@link tasking.ImplementationTypeEnum <em>Implementation Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Implementation Type Enum</em>'.
	 * @see tasking.ImplementationTypeEnum
	 * @generated
	 */
	EEnum getImplementationTypeEnum();

	/**
	 * Returns the meta object for enum '{@link tasking.ParameterTypeEnum <em>Parameter Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Type Enum</em>'.
	 * @see tasking.ParameterTypeEnum
	 * @generated
	 */
	EEnum getParameterTypeEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TaskingFactory getTaskingFactory();

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
		 * The meta object literal for the '{@link tasking.impl.MainImpl <em>Main</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.MainImpl
		 * @see tasking.impl.TaskingPackageImpl#getMain()
		 * @generated
		 */
		EClass MAIN = eINSTANCE.getMain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIN__NAME = eINSTANCE.getMain_Name();

		/**
		 * The meta object literal for the '<em><b>Main Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__MAIN_BODY = eINSTANCE.getMain_MainBody();

		/**
		 * The meta object literal for the '<em><b>Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__MACHINES = eINSTANCE.getMain_Machines();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__CONTEXTS = eINSTANCE.getMain_Contexts();

		/**
		 * The meta object literal for the '{@link tasking.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.TaskImpl
		 * @see tasking.impl.TaskingPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Task Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__TASK_TYPE = eINSTANCE.getTask_TaskType();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__PRIORITY = eINSTANCE.getTask_Priority();

		/**
		 * The meta object literal for the '<em><b>Task Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__TASK_BODY = eINSTANCE.getTask_TaskBody();

		/**
		 * The meta object literal for the '{@link tasking.impl.AutoTask_MachineImpl <em>Auto Task Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.AutoTask_MachineImpl
		 * @see tasking.impl.TaskingPackageImpl#getAutoTask_Machine()
		 * @generated
		 */
		EClass AUTO_TASK_MACHINE = eINSTANCE.getAutoTask_Machine();

		/**
		 * The meta object literal for the '{@link tasking.impl.Tasking_MachineImpl <em>Tasking Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.Tasking_MachineImpl
		 * @see tasking.impl.TaskingPackageImpl#getTasking_Machine()
		 * @generated
		 */
		EClass TASKING_MACHINE = eINSTANCE.getTasking_Machine();

		/**
		 * The meta object literal for the '{@link tasking.impl.Environ_MachineImpl <em>Environ Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.Environ_MachineImpl
		 * @see tasking.impl.TaskingPackageImpl#getEnviron_Machine()
		 * @generated
		 */
		EClass ENVIRON_MACHINE = eINSTANCE.getEnviron_Machine();

		/**
		 * The meta object literal for the '{@link tasking.impl.FMU_MachineImpl <em>FMU Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.FMU_MachineImpl
		 * @see tasking.impl.TaskingPackageImpl#getFMU_Machine()
		 * @generated
		 */
		EClass FMU_MACHINE = eINSTANCE.getFMU_Machine();

		/**
		 * The meta object literal for the '{@link tasking.impl.Shared_MachineImpl <em>Shared Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.Shared_MachineImpl
		 * @see tasking.impl.TaskingPackageImpl#getShared_Machine()
		 * @generated
		 */
		EClass SHARED_MACHINE = eINSTANCE.getShared_Machine();

		/**
		 * The meta object literal for the '{@link tasking.impl.ImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.ImplementationImpl
		 * @see tasking.impl.TaskingPackageImpl#getImplementation()
		 * @generated
		 */
		EClass IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '<em><b>Implementation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION__IMPLEMENTATION_TYPE = eINSTANCE.getImplementation_ImplementationType();

		/**
		 * The meta object literal for the '{@link tasking.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.ParameterTypeImpl
		 * @see tasking.impl.TaskingPackageImpl#getParameterType()
		 * @generated
		 */
		EClass PARAMETER_TYPE = eINSTANCE.getParameterType();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__PARAMETER_TYPE = eINSTANCE.getParameterType_ParameterType();

		/**
		 * The meta object literal for the '{@link tasking.impl.TaskTypeImpl <em>Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.TaskTypeImpl
		 * @see tasking.impl.TaskingPackageImpl#getTaskType()
		 * @generated
		 */
		EClass TASK_TYPE = eINSTANCE.getTaskType();

		/**
		 * The meta object literal for the '{@link tasking.impl.SimpleTaskTypeImpl <em>Simple Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.SimpleTaskTypeImpl
		 * @see tasking.impl.TaskingPackageImpl#getSimpleTaskType()
		 * @generated
		 */
		EClass SIMPLE_TASK_TYPE = eINSTANCE.getSimpleTaskType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TASK_TYPE__TYPE = eINSTANCE.getSimpleTaskType_Type();

		/**
		 * The meta object literal for the '{@link tasking.impl.PeriodicTaskTypeImpl <em>Periodic Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.PeriodicTaskTypeImpl
		 * @see tasking.impl.TaskingPackageImpl#getPeriodicTaskType()
		 * @generated
		 */
		EClass PERIODIC_TASK_TYPE = eINSTANCE.getPeriodicTaskType();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIODIC_TASK_TYPE__PERIOD = eINSTANCE.getPeriodicTaskType_Period();

		/**
		 * The meta object literal for the '{@link tasking.impl.SensorImpl <em>Sensor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.SensorImpl
		 * @see tasking.impl.TaskingPackageImpl#getSensor()
		 * @generated
		 */
		EClass SENSOR = eINSTANCE.getSensor();

		/**
		 * The meta object literal for the '{@link tasking.impl.AddressedVariableImpl <em>Addressed Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.AddressedVariableImpl
		 * @see tasking.impl.TaskingPackageImpl#getAddressedVariable()
		 * @generated
		 */
		EClass ADDRESSED_VARIABLE = eINSTANCE.getAddressedVariable();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESSED_VARIABLE__BASE = eINSTANCE.getAddressedVariable_Base();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESSED_VARIABLE__ADDRESS = eINSTANCE.getAddressedVariable_Address();

		/**
		 * The meta object literal for the '{@link tasking.impl.TaskingElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.TaskingElementImpl
		 * @see tasking.impl.TaskingPackageImpl#getTaskingElement()
		 * @generated
		 */
		EClass TASKING_ELEMENT = eINSTANCE.getTaskingElement();

		/**
		 * The meta object literal for the '{@link tasking.impl.AbstractExtensionTaskingElementImpl <em>Abstract Extension Tasking Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.AbstractExtensionTaskingElementImpl
		 * @see tasking.impl.TaskingPackageImpl#getAbstractExtensionTaskingElement()
		 * @generated
		 */
		EClass ABSTRACT_EXTENSION_TASKING_ELEMENT = eINSTANCE.getAbstractExtensionTaskingElement();

		/**
		 * The meta object literal for the '{@link tasking.impl.EventBElementTaskingElementImpl <em>Event BElement Tasking Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.EventBElementTaskingElementImpl
		 * @see tasking.impl.TaskingPackageImpl#getEventBElementTaskingElement()
		 * @generated
		 */
		EClass EVENT_BELEMENT_TASKING_ELEMENT = eINSTANCE.getEventBElementTaskingElement();

		/**
		 * The meta object literal for the '{@link tasking.impl.MachineTypeImpl <em>Machine Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.MachineTypeImpl
		 * @see tasking.impl.TaskingPackageImpl#getMachineType()
		 * @generated
		 */
		EClass MACHINE_TYPE = eINSTANCE.getMachineType();

		/**
		 * The meta object literal for the '{@link tasking.impl.TypingImpl <em>Typing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.impl.TypingImpl
		 * @see tasking.impl.TaskingPackageImpl#getTyping()
		 * @generated
		 */
		EClass TYPING = eINSTANCE.getTyping();

		/**
		 * The meta object literal for the '{@link tasking.TaskTypeEnum <em>Task Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.TaskTypeEnum
		 * @see tasking.impl.TaskingPackageImpl#getTaskTypeEnum()
		 * @generated
		 */
		EEnum TASK_TYPE_ENUM = eINSTANCE.getTaskTypeEnum();

		/**
		 * The meta object literal for the '{@link tasking.ImplementationTypeEnum <em>Implementation Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.ImplementationTypeEnum
		 * @see tasking.impl.TaskingPackageImpl#getImplementationTypeEnum()
		 * @generated
		 */
		EEnum IMPLEMENTATION_TYPE_ENUM = eINSTANCE.getImplementationTypeEnum();

		/**
		 * The meta object literal for the '{@link tasking.ParameterTypeEnum <em>Parameter Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tasking.ParameterTypeEnum
		 * @see tasking.impl.TaskingPackageImpl#getParameterTypeEnum()
		 * @generated
		 */
		EEnum PARAMETER_TYPE_ENUM = eINSTANCE.getParameterTypeEnum();

	}

} //TaskingPackage
