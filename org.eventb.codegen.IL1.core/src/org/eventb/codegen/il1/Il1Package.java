/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;

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
 * @see org.eventb.codegen.il1.Il1Factory
 * @model kind="package"
 * @generated
 */
public interface Il1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "il1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://il1/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "il1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Il1Package eINSTANCE = org.eventb.codegen.il1.impl.Il1PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.IL1ElementImpl <em>IL1 Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.IL1ElementImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getIL1Element()
	 * @generated
	 */
	int IL1_ELEMENT = 27;

	/**
	 * The number of structural features of the '<em>IL1 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL1_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.DeclarationImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__IDENTIFIER = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__TYPE = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__INITIAL_VALUE = IL1_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__PROJECT_NAME = IL1_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__COMPONENT_NAME = IL1_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.VariableDeclImpl <em>Variable Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.VariableDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getVariableDecl()
	 * @generated
	 */
	int VARIABLE_DECL = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__IDENTIFIER = DECLARATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__TYPE = DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__INITIAL_VALUE = DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__PROJECT_NAME = DECLARATION__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__COMPONENT_NAME = DECLARATION__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL__ADDRESS = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ConstantDeclImpl <em>Constant Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ConstantDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getConstantDecl()
	 * @generated
	 */
	int CONSTANT_DECL = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__IDENTIFIER = DECLARATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__TYPE = DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__INITIAL_VALUE = DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__PROJECT_NAME = DECLARATION__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL__COMPONENT_NAME = DECLARATION__COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Constant Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DECL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.FormalParamDeclImpl <em>Formal Param Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.FormalParamDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFormalParamDecl()
	 * @generated
	 */
	int FORMAL_PARAM_DECL = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__IDENTIFIER = DECLARATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__TYPE = DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__INITIAL_VALUE = DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__PROJECT_NAME = DECLARATION__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__COMPONENT_NAME = DECLARATION__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL__MODE = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Formal Param Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_PARAM_DECL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SignatureImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__NAME = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CallTargetImpl <em>Call Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CallTargetImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCallTarget()
	 * @generated
	 */
	int CALL_TARGET = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TARGET__NAME = SIGNATURE__NAME;

	/**
	 * The number of structural features of the '<em>Call Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TARGET_FEATURE_COUNT = SIGNATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ProtectedImpl <em>Protected</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ProtectedImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getProtected()
	 * @generated
	 */
	int PROTECTED = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__NAME = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subroutines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__SUBROUTINES = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__DECLS = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__PROJECT_NAME = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED__MACHINE_NAME = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Protected</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTECTED_FEATURE_COUNT = RequiredFormulaPackage.DATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CodeContainerImpl <em>Code Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CodeContainerImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCodeContainer()
	 * @generated
	 */
	int CODE_CONTAINER = 7;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_CONTAINER__BODY = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_CONTAINER_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.TaskImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTask()
	 * @generated
	 */
	int TASK = 6;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__BODY = CODE_CONTAINER__BODY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = CODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TASK_TYPE = CODE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PRIORITY = CODE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DECLS = CODE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Subroutines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SUBROUTINES = CODE_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PROJECT_NAME = CODE_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__MACHINE_NAME = CODE_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = CODE_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ProgramImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NAME = SIGNATURE__NAME;

	/**
	 * The feature id for the '<em><b>Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DECLS = SIGNATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Protected</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__PROTECTED = SIGNATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__ENTRY_POINT = SIGNATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Type Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__TASK_TYPE_TASKS = SIGNATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Subroutines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__SUBROUTINES = SIGNATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Environ Machines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__ENVIRON_MACHINES = SIGNATURE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__PROJECT_NAME = SIGNATURE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = SIGNATURE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.MainEntryImpl <em>Main Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.MainEntryImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getMainEntry()
	 * @generated
	 */
	int MAIN_ENTRY = 9;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_ENTRY__BODY = CODE_CONTAINER__BODY;

	/**
	 * The feature id for the '<em><b>Auto Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_ENTRY__AUTO_TASKS = CODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Main Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_ENTRY_FEATURE_COUNT = CODE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SubroutineImpl <em>Subroutine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SubroutineImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSubroutine()
	 * @generated
	 */
	int SUBROUTINE = 10;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__BODY = CODE_CONTAINER__BODY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__NAME = CODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Temporary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__TEMPORARY = CODE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Formal Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__FORMAL_PARAMETERS = CODE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__LOCAL_DECLARATIONS = CODE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__MACHINE_NAME = CODE_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__GUARDS = CODE_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__PROJECT_NAME = CODE_CONTAINER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Subroutine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_FEATURE_COUNT = CODE_CONTAINER_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CommandImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 11;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__BODY = CODE_CONTAINER__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__PARENT_EVENT_NAME = CODE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__ENVIR_STATE_MACHINE_CHILD = CODE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = CODE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.PreconditionLoopImpl <em>Precondition Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.PreconditionLoopImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPreconditionLoop()
	 * @generated
	 */
	int PRECONDITION_LOOP = 12;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP__COMMAND = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP__CONDITION = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Precondition Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_LOOP_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SeqImpl <em>Seq</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SeqImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSeq()
	 * @generated
	 */
	int SEQ = 13;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Left Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__LEFT_BRANCH = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ__RIGHT_BRANCH = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Seq</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQ_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ActionImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 14;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__COMMAND = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.AssignmentImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 15;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__UPDATED = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SwitchImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 16;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__CONDITION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Switch Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__SWITCH_BLOCKS = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CallImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCall()
	 * @generated
	 */
	int CALL = 17;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__TARGET = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__SUBROUTINE = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actual Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__ACTUAL_PARAMETERS = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__MACHINE_NAME = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL__PROJECT_NAME = COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.IfImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getIf()
	 * @generated
	 */
	int IF = 18;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONDITION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__BRANCH = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Related Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__RELATED_EVENT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ElseIfImpl <em>Else If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ElseIfImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getElseIf()
	 * @generated
	 */
	int ELSE_IF = 19;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF__CONDITION = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF__ACTION = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF__BRANCH = IL1_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Related Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF__RELATED_EVENT = IL1_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF__ENVIR_STATE_MACHINE_CHILD = IL1_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Else If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_IF_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SwitchBlockImpl <em>Switch Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SwitchBlockImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSwitchBlock()
	 * @generated
	 */
	int SWITCH_BLOCK = 20;

	/**
	 * The feature id for the '<em><b>Test</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_BLOCK__TEST = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_BLOCK__ACTION = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_BLOCK_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.TaskTypeImpl <em>Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.TaskTypeImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTaskType()
	 * @generated
	 */
	int TASK_TYPE = 22;

	/**
	 * The number of structural features of the '<em>Task Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TYPE_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SimpleTaskTypeImpl <em>Simple Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SimpleTaskTypeImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSimpleTaskType()
	 * @generated
	 */
	int SIMPLE_TASK_TYPE = 23;

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
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.EnvironTaskImpl <em>Environ Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.EnvironTaskImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getEnvironTask()
	 * @generated
	 */
	int ENVIRON_TASK = 24;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__BODY = TASK__BODY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__NAME = TASK__NAME;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__TASK_TYPE = TASK__TASK_TYPE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__PRIORITY = TASK__PRIORITY;

	/**
	 * The feature id for the '<em><b>Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__DECLS = TASK__DECLS;

	/**
	 * The feature id for the '<em><b>Subroutines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__SUBROUTINES = TASK__SUBROUTINES;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__PROJECT_NAME = TASK__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Machine Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK__MACHINE_NAME = TASK__MACHINE_NAME;

	/**
	 * The number of structural features of the '<em>Environ Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRON_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.PeriodicTaskTypeImpl <em>Periodic Task Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.PeriodicTaskTypeImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPeriodicTaskType()
	 * @generated
	 */
	int PERIODIC_TASK_TYPE = 25;

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
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.OutputImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 26;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__TEXT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ELEMENT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.FormulaSetImpl <em>Formula Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.FormulaSetImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFormulaSet()
	 * @generated
	 */
	int FORMULA_SET = 28;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_SET__CONDITIONS = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Formula Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_SET_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ConditionSetImpl <em>Condition Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ConditionSetImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getConditionSet()
	 * @generated
	 */
	int CONDITION_SET = 29;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_SET__CONDITIONS = FORMULA_SET__CONDITIONS;

	/**
	 * The number of structural features of the '<em>Condition Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_SET_FEATURE_COUNT = FORMULA_SET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CommandSetImpl <em>Command Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CommandSetImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCommandSet()
	 * @generated
	 */
	int COMMAND_SET = 30;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_SET__CONDITIONS = FORMULA_SET__CONDITIONS;

	/**
	 * The number of structural features of the '<em>Command Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_SET_FEATURE_COUNT = FORMULA_SET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.LocalRemoteImpl <em>Local Remote</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.LocalRemoteImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getLocalRemote()
	 * @generated
	 */
	int LOCAL_REMOTE = 31;

	/**
	 * The feature id for the '<em><b>Local Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REMOTE__LOCAL_SUBROUTINE = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Remote Subroutine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REMOTE__REMOTE_SUBROUTINE = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Local Remote</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REMOTE_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.ParameterImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 34;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IDENTIFIER = DECLARATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INITIAL_VALUE = DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PROJECT_NAME = DECLARATION__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMPONENT_NAME = DECLARATION__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ORDER_NUMBER = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.InParameterImpl <em>In Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.InParameterImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getInParameter()
	 * @generated
	 */
	int IN_PARAMETER = 32;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__IDENTIFIER = PARAMETER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__INITIAL_VALUE = PARAMETER__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__PROJECT_NAME = PARAMETER__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__COMPONENT_NAME = PARAMETER__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER__ORDER_NUMBER = PARAMETER__ORDER_NUMBER;

	/**
	 * The number of structural features of the '<em>In Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.OutParameterImpl <em>Out Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.OutParameterImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getOutParameter()
	 * @generated
	 */
	int OUT_PARAMETER = 33;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__IDENTIFIER = PARAMETER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__INITIAL_VALUE = PARAMETER__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__PROJECT_NAME = PARAMETER__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__COMPONENT_NAME = PARAMETER__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER__ORDER_NUMBER = PARAMETER__ORDER_NUMBER;

	/**
	 * The number of structural features of the '<em>Out Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.LocalVariableImpl <em>Local Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.LocalVariableImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getLocalVariable()
	 * @generated
	 */
	int LOCAL_VARIABLE = 35;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__IDENTIFIER = PARAMETER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__INITIAL_VALUE = PARAMETER__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__PROJECT_NAME = PARAMETER__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__COMPONENT_NAME = PARAMETER__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Order Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE__ORDER_NUMBER = PARAMETER__ORDER_NUMBER;

	/**
	 * The number of structural features of the '<em>Local Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.TranslatedDeclImpl <em>Translated Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.TranslatedDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTranslatedDecl()
	 * @generated
	 */
	int TRANSLATED_DECL = 36;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATED_DECL__TYPE = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Translated Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATED_DECL_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.PartiallyTranslatedDeclImpl <em>Partially Translated Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.PartiallyTranslatedDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPartiallyTranslatedDecl()
	 * @generated
	 */
	int PARTIALLY_TRANSLATED_DECL = 37;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_TRANSLATED_DECL__TYPE = TRANSLATED_DECL__TYPE;

	/**
	 * The feature id for the '<em><b>Partial Initialisation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION = TRANSLATED_DECL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partially Translated Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIALLY_TRANSLATED_DECL_FEATURE_COUNT = TRANSLATED_DECL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.FullyTranslatedDeclImpl <em>Fully Translated Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.FullyTranslatedDeclImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFullyTranslatedDecl()
	 * @generated
	 */
	int FULLY_TRANSLATED_DECL = 38;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULLY_TRANSLATED_DECL__TYPE = TRANSLATED_DECL__TYPE;

	/**
	 * The feature id for the '<em><b>Full Initialisation Expression</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION = TRANSLATED_DECL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fully Translated Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FULLY_TRANSLATED_DECL_FEATURE_COUNT = TRANSLATED_DECL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.EnumerationImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 39;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__IDENTIFIER = DECLARATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TYPE = DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__INITIAL_VALUE = DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PROJECT_NAME = DECLARATION__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__COMPONENT_NAME = DECLARATION__COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Literal Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERAL_VALUES = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CaseImpl <em>Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CaseImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCase()
	 * @generated
	 */
	int CASE = 40;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The feature id for the '<em><b>Case Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__CASE_EXPRESSION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Case Statement</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__CASE_STATEMENT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.CaseStatementImpl <em>Case Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.CaseStatementImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCaseStatement()
	 * @generated
	 */
	int CASE_STATEMENT = 41;

	/**
	 * The feature id for the '<em><b>Case Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT__CASE_VALUE = IL1_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT__COMMAND = IL1_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Case Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_STATEMENT_FEATURE_COUNT = IL1_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.impl.SkipImpl <em>Skip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.impl.SkipImpl
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSkip()
	 * @generated
	 */
	int SKIP = 42;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP__BODY = COMMAND__BODY;

	/**
	 * The feature id for the '<em><b>Parent Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP__PARENT_EVENT_NAME = COMMAND__PARENT_EVENT_NAME;

	/**
	 * The feature id for the '<em><b>Envir State Machine Child</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP__ENVIR_STATE_MACHINE_CHILD = COMMAND__ENVIR_STATE_MACHINE_CHILD;

	/**
	 * The number of structural features of the '<em>Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.TaskTypeEnum <em>Task Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.TaskTypeEnum
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTaskTypeEnum()
	 * @generated
	 */
	int TASK_TYPE_ENUM = 43;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.VariableTypeEnum <em>Variable Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.VariableTypeEnum
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getVariableTypeEnum()
	 * @generated
	 */
	int VARIABLE_TYPE_ENUM = 44;

	/**
	 * The meta object id for the '{@link org.eventb.codegen.il1.ParamModeEnum <em>Param Mode Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eventb.codegen.il1.ParamModeEnum
	 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getParamModeEnum()
	 * @generated
	 */
	int PARAM_MODE_ENUM = 45;


	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see org.eventb.codegen.il1.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Declaration#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eventb.codegen.il1.Declaration#getIdentifier()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Declaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eventb.codegen.il1.Declaration#getType()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Declaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Value</em>'.
	 * @see org.eventb.codegen.il1.Declaration#getInitialValue()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_InitialValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Declaration#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Declaration#getProjectName()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Declaration#getComponentName <em>Component Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Name</em>'.
	 * @see org.eventb.codegen.il1.Declaration#getComponentName()
	 * @see #getDeclaration()
	 * @generated
	 */
	EAttribute getDeclaration_ComponentName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.VariableDecl <em>Variable Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Decl</em>'.
	 * @see org.eventb.codegen.il1.VariableDecl
	 * @generated
	 */
	EClass getVariableDecl();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.VariableDecl#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.eventb.codegen.il1.VariableDecl#getAddress()
	 * @see #getVariableDecl()
	 * @generated
	 */
	EReference getVariableDecl_Address();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.ConstantDecl <em>Constant Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Decl</em>'.
	 * @see org.eventb.codegen.il1.ConstantDecl
	 * @generated
	 */
	EClass getConstantDecl();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.FormalParamDecl <em>Formal Param Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Param Decl</em>'.
	 * @see org.eventb.codegen.il1.FormalParamDecl
	 * @generated
	 */
	EClass getFormalParamDecl();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.FormalParamDecl#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eventb.codegen.il1.FormalParamDecl#getMode()
	 * @see #getFormalParamDecl()
	 * @generated
	 */
	EAttribute getFormalParamDecl_Mode();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.CallTarget <em>Call Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Target</em>'.
	 * @see org.eventb.codegen.il1.CallTarget
	 * @generated
	 */
	EClass getCallTarget();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Protected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protected</em>'.
	 * @see org.eventb.codegen.il1.Protected
	 * @generated
	 */
	EClass getProtected();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Protected#getSubroutines <em>Subroutines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subroutines</em>'.
	 * @see org.eventb.codegen.il1.Protected#getSubroutines()
	 * @see #getProtected()
	 * @generated
	 */
	EReference getProtected_Subroutines();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Protected#getDecls <em>Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decls</em>'.
	 * @see org.eventb.codegen.il1.Protected#getDecls()
	 * @see #getProtected()
	 * @generated
	 */
	EReference getProtected_Decls();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Protected#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Protected#getProjectName()
	 * @see #getProtected()
	 * @generated
	 */
	EAttribute getProtected_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Protected#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see org.eventb.codegen.il1.Protected#getMachineName()
	 * @see #getProtected()
	 * @generated
	 */
	EAttribute getProtected_MachineName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see org.eventb.codegen.il1.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Task#getTaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Type</em>'.
	 * @see org.eventb.codegen.il1.Task#getTaskType()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_TaskType();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Task#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eventb.codegen.il1.Task#getPriority()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Priority();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Task#getDecls <em>Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decls</em>'.
	 * @see org.eventb.codegen.il1.Task#getDecls()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Decls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Task#getSubroutines <em>Subroutines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subroutines</em>'.
	 * @see org.eventb.codegen.il1.Task#getSubroutines()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Subroutines();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Task#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Task#getProjectName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Task#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see org.eventb.codegen.il1.Task#getMachineName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_MachineName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.CodeContainer <em>Code Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Container</em>'.
	 * @see org.eventb.codegen.il1.CodeContainer
	 * @generated
	 */
	EClass getCodeContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.CodeContainer#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eventb.codegen.il1.CodeContainer#getBody()
	 * @see #getCodeContainer()
	 * @generated
	 */
	EReference getCodeContainer_Body();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.eventb.codegen.il1.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Program#getDecls <em>Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decls</em>'.
	 * @see org.eventb.codegen.il1.Program#getDecls()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Decls();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Program#getProtected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Protected</em>'.
	 * @see org.eventb.codegen.il1.Program#getProtected()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Protected();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Program#getEntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entry Point</em>'.
	 * @see org.eventb.codegen.il1.Program#getEntryPoint()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_EntryPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Program#getTaskTypeTasks <em>Task Type Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Type Tasks</em>'.
	 * @see org.eventb.codegen.il1.Program#getTaskTypeTasks()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_TaskTypeTasks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Program#getSubroutines <em>Subroutines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subroutines</em>'.
	 * @see org.eventb.codegen.il1.Program#getSubroutines()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Subroutines();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Program#getEnvironMachines <em>Environ Machines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Environ Machines</em>'.
	 * @see org.eventb.codegen.il1.Program#getEnvironMachines()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_EnvironMachines();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Program#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Program#getProjectName()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.MainEntry <em>Main Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Main Entry</em>'.
	 * @see org.eventb.codegen.il1.MainEntry
	 * @generated
	 */
	EClass getMainEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.MainEntry#getAutoTasks <em>Auto Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Auto Tasks</em>'.
	 * @see org.eventb.codegen.il1.MainEntry#getAutoTasks()
	 * @see #getMainEntry()
	 * @generated
	 */
	EReference getMainEntry_AutoTasks();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Subroutine <em>Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subroutine</em>'.
	 * @see org.eventb.codegen.il1.Subroutine
	 * @generated
	 */
	EClass getSubroutine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Subroutine#getFormalParameters <em>Formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Formal Parameters</em>'.
	 * @see org.eventb.codegen.il1.Subroutine#getFormalParameters()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_FormalParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Subroutine#getLocalDeclarations <em>Local Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Declarations</em>'.
	 * @see org.eventb.codegen.il1.Subroutine#getLocalDeclarations()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_LocalDeclarations();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.Subroutine#getGuards <em>Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Guards</em>'.
	 * @see org.eventb.codegen.il1.Subroutine#getGuards()
	 * @see #getSubroutine()
	 * @generated
	 */
	EAttribute getSubroutine_Guards();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Subroutine#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Subroutine#getProjectName()
	 * @see #getSubroutine()
	 * @generated
	 */
	EAttribute getSubroutine_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Subroutine#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see org.eventb.codegen.il1.Subroutine#getMachineName()
	 * @see #getSubroutine()
	 * @generated
	 */
	EAttribute getSubroutine_MachineName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.eventb.codegen.il1.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Command#getParentEventName <em>Parent Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Event Name</em>'.
	 * @see org.eventb.codegen.il1.Command#getParentEventName()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_ParentEventName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Command#isEnvirStateMachineChild <em>Envir State Machine Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Envir State Machine Child</em>'.
	 * @see org.eventb.codegen.il1.Command#isEnvirStateMachineChild()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_EnvirStateMachineChild();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.PreconditionLoop <em>Precondition Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precondition Loop</em>'.
	 * @see org.eventb.codegen.il1.PreconditionLoop
	 * @generated
	 */
	EClass getPreconditionLoop();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.PreconditionLoop#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Condition</em>'.
	 * @see org.eventb.codegen.il1.PreconditionLoop#getCondition()
	 * @see #getPreconditionLoop()
	 * @generated
	 */
	EAttribute getPreconditionLoop_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.PreconditionLoop#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eventb.codegen.il1.PreconditionLoop#getCommand()
	 * @see #getPreconditionLoop()
	 * @generated
	 */
	EReference getPreconditionLoop_Command();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Seq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seq</em>'.
	 * @see org.eventb.codegen.il1.Seq
	 * @generated
	 */
	EClass getSeq();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Seq#getLeftBranch <em>Left Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Branch</em>'.
	 * @see org.eventb.codegen.il1.Seq#getLeftBranch()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_LeftBranch();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Seq#getRightBranch <em>Right Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Branch</em>'.
	 * @see org.eventb.codegen.il1.Seq#getRightBranch()
	 * @see #getSeq()
	 * @generated
	 */
	EReference getSeq_RightBranch();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.eventb.codegen.il1.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Action#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eventb.codegen.il1.Action#getCommand()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Command();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Action#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.eventb.codegen.il1.Action#getAction()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Action();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eventb.codegen.il1.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Assignment#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.eventb.codegen.il1.Assignment#getUpdated()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_Updated();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eventb.codegen.il1.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_Value();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see org.eventb.codegen.il1.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Switch#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.eventb.codegen.il1.Switch#getCondition()
	 * @see #getSwitch()
	 * @generated
	 */
	EAttribute getSwitch_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Switch#getSwitchBlocks <em>Switch Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Switch Blocks</em>'.
	 * @see org.eventb.codegen.il1.Switch#getSwitchBlocks()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_SwitchBlocks();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call</em>'.
	 * @see org.eventb.codegen.il1.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the reference '{@link org.eventb.codegen.il1.Call#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eventb.codegen.il1.Call#getTarget()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.Call#getSubroutine <em>Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subroutine</em>'.
	 * @see org.eventb.codegen.il1.Call#getSubroutine()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Subroutine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Call#getActualParameters <em>Actual Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Parameters</em>'.
	 * @see org.eventb.codegen.il1.Call#getActualParameters()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_ActualParameters();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Call#getMachineName <em>Machine Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Name</em>'.
	 * @see org.eventb.codegen.il1.Call#getMachineName()
	 * @see #getCall()
	 * @generated
	 */
	EAttribute getCall_MachineName();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Call#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eventb.codegen.il1.Call#getProjectName()
	 * @see #getCall()
	 * @generated
	 */
	EAttribute getCall_ProjectName();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.eventb.codegen.il1.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.If#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Condition</em>'.
	 * @see org.eventb.codegen.il1.If#getCondition()
	 * @see #getIf()
	 * @generated
	 */
	EAttribute getIf_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.If#getBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Branch</em>'.
	 * @see org.eventb.codegen.il1.If#getBranch()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Branch();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.If#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eventb.codegen.il1.If#getElse()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Else();

	/**
	 * Returns the meta object for the reference '{@link org.eventb.codegen.il1.If#getRelatedEvent <em>Related Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Event</em>'.
	 * @see org.eventb.codegen.il1.If#getRelatedEvent()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_RelatedEvent();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.ElseIf <em>Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Else If</em>'.
	 * @see org.eventb.codegen.il1.ElseIf
	 * @generated
	 */
	EClass getElseIf();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.ElseIf#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Condition</em>'.
	 * @see org.eventb.codegen.il1.ElseIf#getCondition()
	 * @see #getElseIf()
	 * @generated
	 */
	EAttribute getElseIf_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.ElseIf#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see org.eventb.codegen.il1.ElseIf#getAction()
	 * @see #getElseIf()
	 * @generated
	 */
	EReference getElseIf_Action();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.ElseIf#getBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Branch</em>'.
	 * @see org.eventb.codegen.il1.ElseIf#getBranch()
	 * @see #getElseIf()
	 * @generated
	 */
	EReference getElseIf_Branch();

	/**
	 * Returns the meta object for the reference '{@link org.eventb.codegen.il1.ElseIf#getRelatedEvent <em>Related Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Event</em>'.
	 * @see org.eventb.codegen.il1.ElseIf#getRelatedEvent()
	 * @see #getElseIf()
	 * @generated
	 */
	EReference getElseIf_RelatedEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.ElseIf#isEnvirStateMachineChild <em>Envir State Machine Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Envir State Machine Child</em>'.
	 * @see org.eventb.codegen.il1.ElseIf#isEnvirStateMachineChild()
	 * @see #getElseIf()
	 * @generated
	 */
	EAttribute getElseIf_EnvirStateMachineChild();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.SwitchBlock <em>Switch Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Block</em>'.
	 * @see org.eventb.codegen.il1.SwitchBlock
	 * @generated
	 */
	EClass getSwitchBlock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.SwitchBlock#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Test</em>'.
	 * @see org.eventb.codegen.il1.SwitchBlock#getTest()
	 * @see #getSwitchBlock()
	 * @generated
	 */
	EReference getSwitchBlock_Test();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.SwitchBlock#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see org.eventb.codegen.il1.SwitchBlock#getAction()
	 * @see #getSwitchBlock()
	 * @generated
	 */
	EReference getSwitchBlock_Action();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature</em>'.
	 * @see org.eventb.codegen.il1.Signature
	 * @generated
	 */
	EClass getSignature();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Signature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eventb.codegen.il1.Signature#getName()
	 * @see #getSignature()
	 * @generated
	 */
	EAttribute getSignature_Name();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.TaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Type</em>'.
	 * @see org.eventb.codegen.il1.TaskType
	 * @generated
	 */
	EClass getTaskType();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.SimpleTaskType <em>Simple Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Task Type</em>'.
	 * @see org.eventb.codegen.il1.SimpleTaskType
	 * @generated
	 */
	EClass getSimpleTaskType();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.SimpleTaskType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eventb.codegen.il1.SimpleTaskType#getType()
	 * @see #getSimpleTaskType()
	 * @generated
	 */
	EAttribute getSimpleTaskType_Type();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.EnvironTask <em>Environ Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environ Task</em>'.
	 * @see org.eventb.codegen.il1.EnvironTask
	 * @generated
	 */
	EClass getEnvironTask();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.PeriodicTaskType <em>Periodic Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodic Task Type</em>'.
	 * @see org.eventb.codegen.il1.PeriodicTaskType
	 * @generated
	 */
	EClass getPeriodicTaskType();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.PeriodicTaskType#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.eventb.codegen.il1.PeriodicTaskType#getPeriod()
	 * @see #getPeriodicTaskType()
	 * @generated
	 */
	EAttribute getPeriodicTaskType_Period();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see org.eventb.codegen.il1.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Output#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eventb.codegen.il1.Output#getText()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Output#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.eventb.codegen.il1.Output#getElement()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Element();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.IL1Element <em>IL1 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IL1 Element</em>'.
	 * @see org.eventb.codegen.il1.IL1Element
	 * @generated
	 */
	EClass getIL1Element();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.FormulaSet <em>Formula Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula Set</em>'.
	 * @see org.eventb.codegen.il1.FormulaSet
	 * @generated
	 */
	EClass getFormulaSet();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.FormulaSet#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Conditions</em>'.
	 * @see org.eventb.codegen.il1.FormulaSet#getConditions()
	 * @see #getFormulaSet()
	 * @generated
	 */
	EAttribute getFormulaSet_Conditions();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.ConditionSet <em>Condition Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Set</em>'.
	 * @see org.eventb.codegen.il1.ConditionSet
	 * @generated
	 */
	EClass getConditionSet();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.CommandSet <em>Command Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Set</em>'.
	 * @see org.eventb.codegen.il1.CommandSet
	 * @generated
	 */
	EClass getCommandSet();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.LocalRemote <em>Local Remote</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Remote</em>'.
	 * @see org.eventb.codegen.il1.LocalRemote
	 * @generated
	 */
	EClass getLocalRemote();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.LocalRemote#getLocalSubroutine <em>Local Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Subroutine</em>'.
	 * @see org.eventb.codegen.il1.LocalRemote#getLocalSubroutine()
	 * @see #getLocalRemote()
	 * @generated
	 */
	EReference getLocalRemote_LocalSubroutine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.LocalRemote#getRemoteSubroutine <em>Remote Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Remote Subroutine</em>'.
	 * @see org.eventb.codegen.il1.LocalRemote#getRemoteSubroutine()
	 * @see #getLocalRemote()
	 * @generated
	 */
	EReference getLocalRemote_RemoteSubroutine();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.InParameter <em>In Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Parameter</em>'.
	 * @see org.eventb.codegen.il1.InParameter
	 * @generated
	 */
	EClass getInParameter();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.OutParameter <em>Out Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Parameter</em>'.
	 * @see org.eventb.codegen.il1.OutParameter
	 * @generated
	 */
	EClass getOutParameter();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eventb.codegen.il1.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Parameter#getOrderNumber <em>Order Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Number</em>'.
	 * @see org.eventb.codegen.il1.Parameter#getOrderNumber()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_OrderNumber();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.LocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable</em>'.
	 * @see org.eventb.codegen.il1.LocalVariable
	 * @generated
	 */
	EClass getLocalVariable();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.TranslatedDecl <em>Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Translated Decl</em>'.
	 * @see org.eventb.codegen.il1.TranslatedDecl
	 * @generated
	 */
	EClass getTranslatedDecl();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.TranslatedDecl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eventb.codegen.il1.TranslatedDecl#getType()
	 * @see #getTranslatedDecl()
	 * @generated
	 */
	EAttribute getTranslatedDecl_Type();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.PartiallyTranslatedDecl <em>Partially Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partially Translated Decl</em>'.
	 * @see org.eventb.codegen.il1.PartiallyTranslatedDecl
	 * @generated
	 */
	EClass getPartiallyTranslatedDecl();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.PartiallyTranslatedDecl#getPartialInitialisationExpression <em>Partial Initialisation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partial Initialisation Expression</em>'.
	 * @see org.eventb.codegen.il1.PartiallyTranslatedDecl#getPartialInitialisationExpression()
	 * @see #getPartiallyTranslatedDecl()
	 * @generated
	 */
	EAttribute getPartiallyTranslatedDecl_PartialInitialisationExpression();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.FullyTranslatedDecl <em>Fully Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fully Translated Decl</em>'.
	 * @see org.eventb.codegen.il1.FullyTranslatedDecl
	 * @generated
	 */
	EClass getFullyTranslatedDecl();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.FullyTranslatedDecl#getFullInitialisationExpression <em>Full Initialisation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Full Initialisation Expression</em>'.
	 * @see org.eventb.codegen.il1.FullyTranslatedDecl#getFullInitialisationExpression()
	 * @see #getFullyTranslatedDecl()
	 * @generated
	 */
	EAttribute getFullyTranslatedDecl_FullInitialisationExpression();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eventb.codegen.il1.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the attribute list '{@link org.eventb.codegen.il1.Enumeration#getLiteralValues <em>Literal Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Literal Values</em>'.
	 * @see org.eventb.codegen.il1.Enumeration#getLiteralValues()
	 * @see #getEnumeration()
	 * @generated
	 */
	EAttribute getEnumeration_LiteralValues();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case</em>'.
	 * @see org.eventb.codegen.il1.Case
	 * @generated
	 */
	EClass getCase();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.Case#getCaseExpression <em>Case Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Expression</em>'.
	 * @see org.eventb.codegen.il1.Case#getCaseExpression()
	 * @see #getCase()
	 * @generated
	 */
	EAttribute getCase_CaseExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eventb.codegen.il1.Case#getCaseStatement <em>Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Case Statement</em>'.
	 * @see org.eventb.codegen.il1.Case#getCaseStatement()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_CaseStatement();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.CaseStatement <em>Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Statement</em>'.
	 * @see org.eventb.codegen.il1.CaseStatement
	 * @generated
	 */
	EClass getCaseStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eventb.codegen.il1.CaseStatement#getCaseValue <em>Case Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Value</em>'.
	 * @see org.eventb.codegen.il1.CaseStatement#getCaseValue()
	 * @see #getCaseStatement()
	 * @generated
	 */
	EAttribute getCaseStatement_CaseValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eventb.codegen.il1.CaseStatement#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eventb.codegen.il1.CaseStatement#getCommand()
	 * @see #getCaseStatement()
	 * @generated
	 */
	EReference getCaseStatement_Command();

	/**
	 * Returns the meta object for class '{@link org.eventb.codegen.il1.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip</em>'.
	 * @see org.eventb.codegen.il1.Skip
	 * @generated
	 */
	EClass getSkip();

	/**
	 * Returns the meta object for enum '{@link org.eventb.codegen.il1.TaskTypeEnum <em>Task Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Task Type Enum</em>'.
	 * @see org.eventb.codegen.il1.TaskTypeEnum
	 * @generated
	 */
	EEnum getTaskTypeEnum();

	/**
	 * Returns the meta object for enum '{@link org.eventb.codegen.il1.VariableTypeEnum <em>Variable Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Type Enum</em>'.
	 * @see org.eventb.codegen.il1.VariableTypeEnum
	 * @generated
	 */
	EEnum getVariableTypeEnum();

	/**
	 * Returns the meta object for enum '{@link org.eventb.codegen.il1.ParamModeEnum <em>Param Mode Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Param Mode Enum</em>'.
	 * @see org.eventb.codegen.il1.ParamModeEnum
	 * @generated
	 */
	EEnum getParamModeEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Il1Factory getIl1Factory();

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
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.DeclarationImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__IDENTIFIER = eINSTANCE.getDeclaration_Identifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__TYPE = eINSTANCE.getDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__INITIAL_VALUE = eINSTANCE.getDeclaration_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__PROJECT_NAME = eINSTANCE.getDeclaration_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Component Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARATION__COMPONENT_NAME = eINSTANCE.getDeclaration_ComponentName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.VariableDeclImpl <em>Variable Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.VariableDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getVariableDecl()
		 * @generated
		 */
		EClass VARIABLE_DECL = eINSTANCE.getVariableDecl();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECL__ADDRESS = eINSTANCE.getVariableDecl_Address();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ConstantDeclImpl <em>Constant Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ConstantDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getConstantDecl()
		 * @generated
		 */
		EClass CONSTANT_DECL = eINSTANCE.getConstantDecl();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.FormalParamDeclImpl <em>Formal Param Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.FormalParamDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFormalParamDecl()
		 * @generated
		 */
		EClass FORMAL_PARAM_DECL = eINSTANCE.getFormalParamDecl();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAL_PARAM_DECL__MODE = eINSTANCE.getFormalParamDecl_Mode();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CallTargetImpl <em>Call Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CallTargetImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCallTarget()
		 * @generated
		 */
		EClass CALL_TARGET = eINSTANCE.getCallTarget();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ProtectedImpl <em>Protected</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ProtectedImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getProtected()
		 * @generated
		 */
		EClass PROTECTED = eINSTANCE.getProtected();

		/**
		 * The meta object literal for the '<em><b>Subroutines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTED__SUBROUTINES = eINSTANCE.getProtected_Subroutines();

		/**
		 * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTECTED__DECLS = eINSTANCE.getProtected_Decls();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTED__PROJECT_NAME = eINSTANCE.getProtected_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Machine Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTECTED__MACHINE_NAME = eINSTANCE.getProtected_MachineName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.TaskImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTask()
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
		 * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__DECLS = eINSTANCE.getTask_Decls();

		/**
		 * The meta object literal for the '<em><b>Subroutines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__SUBROUTINES = eINSTANCE.getTask_Subroutines();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__PROJECT_NAME = eINSTANCE.getTask_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Machine Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__MACHINE_NAME = eINSTANCE.getTask_MachineName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CodeContainerImpl <em>Code Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CodeContainerImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCodeContainer()
		 * @generated
		 */
		EClass CODE_CONTAINER = eINSTANCE.getCodeContainer();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_CONTAINER__BODY = eINSTANCE.getCodeContainer_Body();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ProgramImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__DECLS = eINSTANCE.getProgram_Decls();

		/**
		 * The meta object literal for the '<em><b>Protected</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__PROTECTED = eINSTANCE.getProgram_Protected();

		/**
		 * The meta object literal for the '<em><b>Entry Point</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__ENTRY_POINT = eINSTANCE.getProgram_EntryPoint();

		/**
		 * The meta object literal for the '<em><b>Task Type Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__TASK_TYPE_TASKS = eINSTANCE.getProgram_TaskTypeTasks();

		/**
		 * The meta object literal for the '<em><b>Subroutines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__SUBROUTINES = eINSTANCE.getProgram_Subroutines();

		/**
		 * The meta object literal for the '<em><b>Environ Machines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__ENVIRON_MACHINES = eINSTANCE.getProgram_EnvironMachines();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__PROJECT_NAME = eINSTANCE.getProgram_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.MainEntryImpl <em>Main Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.MainEntryImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getMainEntry()
		 * @generated
		 */
		EClass MAIN_ENTRY = eINSTANCE.getMainEntry();

		/**
		 * The meta object literal for the '<em><b>Auto Tasks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN_ENTRY__AUTO_TASKS = eINSTANCE.getMainEntry_AutoTasks();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SubroutineImpl <em>Subroutine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SubroutineImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSubroutine()
		 * @generated
		 */
		EClass SUBROUTINE = eINSTANCE.getSubroutine();

		/**
		 * The meta object literal for the '<em><b>Formal Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__FORMAL_PARAMETERS = eINSTANCE.getSubroutine_FormalParameters();

		/**
		 * The meta object literal for the '<em><b>Local Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__LOCAL_DECLARATIONS = eINSTANCE.getSubroutine_LocalDeclarations();

		/**
		 * The meta object literal for the '<em><b>Guards</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBROUTINE__GUARDS = eINSTANCE.getSubroutine_Guards();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBROUTINE__PROJECT_NAME = eINSTANCE.getSubroutine_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Machine Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBROUTINE__MACHINE_NAME = eINSTANCE.getSubroutine_MachineName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CommandImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Parent Event Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__PARENT_EVENT_NAME = eINSTANCE.getCommand_ParentEventName();

		/**
		 * The meta object literal for the '<em><b>Envir State Machine Child</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__ENVIR_STATE_MACHINE_CHILD = eINSTANCE.getCommand_EnvirStateMachineChild();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.PreconditionLoopImpl <em>Precondition Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.PreconditionLoopImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPreconditionLoop()
		 * @generated
		 */
		EClass PRECONDITION_LOOP = eINSTANCE.getPreconditionLoop();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRECONDITION_LOOP__CONDITION = eINSTANCE.getPreconditionLoop_Condition();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECONDITION_LOOP__COMMAND = eINSTANCE.getPreconditionLoop_Command();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SeqImpl <em>Seq</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SeqImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSeq()
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
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ActionImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__COMMAND = eINSTANCE.getAction_Command();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__ACTION = eINSTANCE.getAction_Action();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.AssignmentImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__UPDATED = eINSTANCE.getAssignment_Updated();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SwitchImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH__CONDITION = eINSTANCE.getSwitch_Condition();

		/**
		 * The meta object literal for the '<em><b>Switch Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__SWITCH_BLOCKS = eINSTANCE.getSwitch_SwitchBlocks();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CallImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__TARGET = eINSTANCE.getCall_Target();

		/**
		 * The meta object literal for the '<em><b>Subroutine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__SUBROUTINE = eINSTANCE.getCall_Subroutine();

		/**
		 * The meta object literal for the '<em><b>Actual Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL__ACTUAL_PARAMETERS = eINSTANCE.getCall_ActualParameters();

		/**
		 * The meta object literal for the '<em><b>Machine Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL__MACHINE_NAME = eINSTANCE.getCall_MachineName();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL__PROJECT_NAME = eINSTANCE.getCall_ProjectName();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.IfImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF__CONDITION = eINSTANCE.getIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__BRANCH = eINSTANCE.getIf_Branch();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE = eINSTANCE.getIf_Else();

		/**
		 * The meta object literal for the '<em><b>Related Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__RELATED_EVENT = eINSTANCE.getIf_RelatedEvent();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ElseIfImpl <em>Else If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ElseIfImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getElseIf()
		 * @generated
		 */
		EClass ELSE_IF = eINSTANCE.getElseIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELSE_IF__CONDITION = eINSTANCE.getElseIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_IF__ACTION = eINSTANCE.getElseIf_Action();

		/**
		 * The meta object literal for the '<em><b>Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_IF__BRANCH = eINSTANCE.getElseIf_Branch();

		/**
		 * The meta object literal for the '<em><b>Related Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_IF__RELATED_EVENT = eINSTANCE.getElseIf_RelatedEvent();

		/**
		 * The meta object literal for the '<em><b>Envir State Machine Child</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELSE_IF__ENVIR_STATE_MACHINE_CHILD = eINSTANCE.getElseIf_EnvirStateMachineChild();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SwitchBlockImpl <em>Switch Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SwitchBlockImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSwitchBlock()
		 * @generated
		 */
		EClass SWITCH_BLOCK = eINSTANCE.getSwitchBlock();

		/**
		 * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_BLOCK__TEST = eINSTANCE.getSwitchBlock_Test();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_BLOCK__ACTION = eINSTANCE.getSwitchBlock_Action();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SignatureImpl <em>Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SignatureImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSignature()
		 * @generated
		 */
		EClass SIGNATURE = eINSTANCE.getSignature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNATURE__NAME = eINSTANCE.getSignature_Name();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.TaskTypeImpl <em>Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.TaskTypeImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTaskType()
		 * @generated
		 */
		EClass TASK_TYPE = eINSTANCE.getTaskType();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SimpleTaskTypeImpl <em>Simple Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SimpleTaskTypeImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSimpleTaskType()
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
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.EnvironTaskImpl <em>Environ Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.EnvironTaskImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getEnvironTask()
		 * @generated
		 */
		EClass ENVIRON_TASK = eINSTANCE.getEnvironTask();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.PeriodicTaskTypeImpl <em>Periodic Task Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.PeriodicTaskTypeImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPeriodicTaskType()
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
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.OutputImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getOutput()
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
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__ELEMENT = eINSTANCE.getOutput_Element();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.IL1ElementImpl <em>IL1 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.IL1ElementImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getIL1Element()
		 * @generated
		 */
		EClass IL1_ELEMENT = eINSTANCE.getIL1Element();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.FormulaSetImpl <em>Formula Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.FormulaSetImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFormulaSet()
		 * @generated
		 */
		EClass FORMULA_SET = eINSTANCE.getFormulaSet();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULA_SET__CONDITIONS = eINSTANCE.getFormulaSet_Conditions();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ConditionSetImpl <em>Condition Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ConditionSetImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getConditionSet()
		 * @generated
		 */
		EClass CONDITION_SET = eINSTANCE.getConditionSet();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CommandSetImpl <em>Command Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CommandSetImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCommandSet()
		 * @generated
		 */
		EClass COMMAND_SET = eINSTANCE.getCommandSet();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.LocalRemoteImpl <em>Local Remote</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.LocalRemoteImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getLocalRemote()
		 * @generated
		 */
		EClass LOCAL_REMOTE = eINSTANCE.getLocalRemote();

		/**
		 * The meta object literal for the '<em><b>Local Subroutine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_REMOTE__LOCAL_SUBROUTINE = eINSTANCE.getLocalRemote_LocalSubroutine();

		/**
		 * The meta object literal for the '<em><b>Remote Subroutine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_REMOTE__REMOTE_SUBROUTINE = eINSTANCE.getLocalRemote_RemoteSubroutine();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.InParameterImpl <em>In Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.InParameterImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getInParameter()
		 * @generated
		 */
		EClass IN_PARAMETER = eINSTANCE.getInParameter();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.OutParameterImpl <em>Out Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.OutParameterImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getOutParameter()
		 * @generated
		 */
		EClass OUT_PARAMETER = eINSTANCE.getOutParameter();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.ParameterImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Order Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__ORDER_NUMBER = eINSTANCE.getParameter_OrderNumber();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.LocalVariableImpl <em>Local Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.LocalVariableImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getLocalVariable()
		 * @generated
		 */
		EClass LOCAL_VARIABLE = eINSTANCE.getLocalVariable();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.TranslatedDeclImpl <em>Translated Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.TranslatedDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTranslatedDecl()
		 * @generated
		 */
		EClass TRANSLATED_DECL = eINSTANCE.getTranslatedDecl();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATED_DECL__TYPE = eINSTANCE.getTranslatedDecl_Type();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.PartiallyTranslatedDeclImpl <em>Partially Translated Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.PartiallyTranslatedDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getPartiallyTranslatedDecl()
		 * @generated
		 */
		EClass PARTIALLY_TRANSLATED_DECL = eINSTANCE.getPartiallyTranslatedDecl();

		/**
		 * The meta object literal for the '<em><b>Partial Initialisation Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION = eINSTANCE.getPartiallyTranslatedDecl_PartialInitialisationExpression();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.FullyTranslatedDeclImpl <em>Fully Translated Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.FullyTranslatedDeclImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getFullyTranslatedDecl()
		 * @generated
		 */
		EClass FULLY_TRANSLATED_DECL = eINSTANCE.getFullyTranslatedDecl();

		/**
		 * The meta object literal for the '<em><b>Full Initialisation Expression</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION = eINSTANCE.getFullyTranslatedDecl_FullInitialisationExpression();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.EnumerationImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literal Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION__LITERAL_VALUES = eINSTANCE.getEnumeration_LiteralValues();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CaseImpl <em>Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CaseImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCase()
		 * @generated
		 */
		EClass CASE = eINSTANCE.getCase();

		/**
		 * The meta object literal for the '<em><b>Case Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE__CASE_EXPRESSION = eINSTANCE.getCase_CaseExpression();

		/**
		 * The meta object literal for the '<em><b>Case Statement</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__CASE_STATEMENT = eINSTANCE.getCase_CaseStatement();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.CaseStatementImpl <em>Case Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.CaseStatementImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getCaseStatement()
		 * @generated
		 */
		EClass CASE_STATEMENT = eINSTANCE.getCaseStatement();

		/**
		 * The meta object literal for the '<em><b>Case Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_STATEMENT__CASE_VALUE = eINSTANCE.getCaseStatement_CaseValue();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE_STATEMENT__COMMAND = eINSTANCE.getCaseStatement_Command();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.impl.SkipImpl <em>Skip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.impl.SkipImpl
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getSkip()
		 * @generated
		 */
		EClass SKIP = eINSTANCE.getSkip();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.TaskTypeEnum <em>Task Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.TaskTypeEnum
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getTaskTypeEnum()
		 * @generated
		 */
		EEnum TASK_TYPE_ENUM = eINSTANCE.getTaskTypeEnum();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.VariableTypeEnum <em>Variable Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.VariableTypeEnum
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getVariableTypeEnum()
		 * @generated
		 */
		EEnum VARIABLE_TYPE_ENUM = eINSTANCE.getVariableTypeEnum();

		/**
		 * The meta object literal for the '{@link org.eventb.codegen.il1.ParamModeEnum <em>Param Mode Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eventb.codegen.il1.ParamModeEnum
		 * @see org.eventb.codegen.il1.impl.Il1PackageImpl#getParamModeEnum()
		 * @generated
		 */
		EEnum PARAM_MODE_ENUM = eINSTANCE.getParamModeEnum();

	}

} //Il1Package
