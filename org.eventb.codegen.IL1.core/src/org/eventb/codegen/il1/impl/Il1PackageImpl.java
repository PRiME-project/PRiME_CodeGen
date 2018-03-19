/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Assignment;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.CallTarget;
import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.CodeContainer;
import org.eventb.codegen.il1.Command;
import org.eventb.codegen.il1.CommandSet;
import org.eventb.codegen.il1.ConditionSet;
import org.eventb.codegen.il1.ConstantDecl;
import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.ElseIf;
import org.eventb.codegen.il1.Enumeration;
import org.eventb.codegen.il1.EnvironTask;
import org.eventb.codegen.il1.FormalParamDecl;
import org.eventb.codegen.il1.FormulaSet;
import org.eventb.codegen.il1.FullyTranslatedDecl;
import org.eventb.codegen.il1.IL1Element;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.MainEntry;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Output;
import org.eventb.codegen.il1.ParamModeEnum;
import org.eventb.codegen.il1.Parameter;
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.Signature;
import org.eventb.codegen.il1.SimpleTaskType;
import org.eventb.codegen.il1.Skip;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Switch;
import org.eventb.codegen.il1.SwitchBlock;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.TaskTypeEnum;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.VariableTypeEnum;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;
import org.eventb.codegen.il1.RequiredFormula.impl.RequiredFormulaPackageImpl;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.impl.RequiredMetadataPackageImpl;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.MachinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Il1PackageImpl extends EPackageImpl implements Il1Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalParamDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protectedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mainEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subroutineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preconditionLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seqEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseIfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTaskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass periodicTaskTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass il1ElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formulaSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localRemoteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass translatedDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partiallyTranslatedDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fullyTranslatedDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum taskTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum paramModeEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eventb.codegen.il1.Il1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Il1PackageImpl() {
		super(eNS_URI, Il1Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Il1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Il1Package init() {
		if (isInited) return (Il1Package)EPackage.Registry.INSTANCE.getEPackage(Il1Package.eNS_URI);

		// Obtain or create and register package
		Il1PackageImpl theIl1Package = (Il1PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Il1PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Il1PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RequiredFormulaPackageImpl theRequiredFormulaPackage = (RequiredFormulaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI) instanceof RequiredFormulaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI) : RequiredFormulaPackage.eINSTANCE);
		RequiredMetadataPackageImpl theRequiredMetadataPackage = (RequiredMetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI) instanceof RequiredMetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI) : RequiredMetadataPackage.eINSTANCE);

		// Create package meta-data objects
		theIl1Package.createPackageContents();
		theRequiredFormulaPackage.createPackageContents();
		theRequiredMetadataPackage.createPackageContents();

		// Initialize created meta-data
		theIl1Package.initializePackageContents();
		theRequiredFormulaPackage.initializePackageContents();
		theRequiredMetadataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIl1Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Il1Package.eNS_URI, theIl1Package);
		return theIl1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaration() {
		return declarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_Identifier() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_Type() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_InitialValue() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_ProjectName() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_ComponentName() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDecl() {
		return variableDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDecl_Address() {
		return (EReference)variableDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantDecl() {
		return constantDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalParamDecl() {
		return formalParamDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormalParamDecl_Mode() {
		return (EAttribute)formalParamDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTarget() {
		return callTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtected() {
		return protectedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtected_Subroutines() {
		return (EReference)protectedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtected_Decls() {
		return (EReference)protectedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtected_ProjectName() {
		return (EAttribute)protectedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProtected_MachineName() {
		return (EAttribute)protectedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_TaskType() {
		return (EReference)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Priority() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_Decls() {
		return (EReference)taskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_Subroutines() {
		return (EReference)taskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_ProjectName() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_MachineName() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeContainer() {
		return codeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeContainer_Body() {
		return (EReference)codeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Decls() {
		return (EReference)programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Protected() {
		return (EReference)programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_EntryPoint() {
		return (EReference)programEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_TaskTypeTasks() {
		return (EReference)programEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Subroutines() {
		return (EReference)programEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_EnvironMachines() {
		return (EReference)programEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_ProjectName() {
		return (EAttribute)programEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMainEntry() {
		return mainEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMainEntry_AutoTasks() {
		return (EReference)mainEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubroutine() {
		return subroutineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubroutine_FormalParameters() {
		return (EReference)subroutineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubroutine_LocalDeclarations() {
		return (EReference)subroutineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubroutine_Guards() {
		return (EAttribute)subroutineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubroutine_ProjectName() {
		return (EAttribute)subroutineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubroutine_MachineName() {
		return (EAttribute)subroutineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_ParentEventName() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_EnvirStateMachineChild() {
		return (EAttribute)commandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreconditionLoop() {
		return preconditionLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreconditionLoop_Condition() {
		return (EAttribute)preconditionLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreconditionLoop_Command() {
		return (EReference)preconditionLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeq() {
		return seqEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeq_LeftBranch() {
		return (EReference)seqEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSeq_RightBranch() {
		return (EReference)seqEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Command() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Action() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_Updated() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_Value() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitch() {
		return switchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitch_Condition() {
		return (EAttribute)switchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitch_SwitchBlocks() {
		return (EReference)switchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCall() {
		return callEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCall_Target() {
		return (EReference)callEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCall_Subroutine() {
		return (EReference)callEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCall_ActualParameters() {
		return (EReference)callEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCall_MachineName() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCall_ProjectName() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIf() {
		return ifEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIf_Condition() {
		return (EAttribute)ifEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_Branch() {
		return (EReference)ifEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_Else() {
		return (EReference)ifEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_RelatedEvent() {
		return (EReference)ifEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElseIf() {
		return elseIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElseIf_Condition() {
		return (EAttribute)elseIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElseIf_Action() {
		return (EReference)elseIfEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElseIf_Branch() {
		return (EReference)elseIfEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElseIf_RelatedEvent() {
		return (EReference)elseIfEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElseIf_EnvirStateMachineChild() {
		return (EAttribute)elseIfEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchBlock() {
		return switchBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchBlock_Test() {
		return (EReference)switchBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchBlock_Action() {
		return (EReference)switchBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignature() {
		return signatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignature_Name() {
		return (EAttribute)signatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskType() {
		return taskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleTaskType() {
		return simpleTaskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleTaskType_Type() {
		return (EAttribute)simpleTaskTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironTask() {
		return environTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeriodicTaskType() {
		return periodicTaskTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeriodicTaskType_Period() {
		return (EAttribute)periodicTaskTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Text() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Element() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIL1Element() {
		return il1ElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormulaSet() {
		return formulaSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormulaSet_Conditions() {
		return (EAttribute)formulaSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionSet() {
		return conditionSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandSet() {
		return commandSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalRemote() {
		return localRemoteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalRemote_LocalSubroutine() {
		return (EReference)localRemoteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalRemote_RemoteSubroutine() {
		return (EReference)localRemoteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInParameter() {
		return inParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutParameter() {
		return outParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_OrderNumber() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariable() {
		return localVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTranslatedDecl() {
		return translatedDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTranslatedDecl_Type() {
		return (EAttribute)translatedDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartiallyTranslatedDecl() {
		return partiallyTranslatedDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartiallyTranslatedDecl_PartialInitialisationExpression() {
		return (EAttribute)partiallyTranslatedDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFullyTranslatedDecl() {
		return fullyTranslatedDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFullyTranslatedDecl_FullInitialisationExpression() {
		return (EAttribute)fullyTranslatedDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeration_LiteralValues() {
		return (EAttribute)enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCase() {
		return caseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCase_CaseExpression() {
		return (EAttribute)caseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCase_CaseStatement() {
		return (EReference)caseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseStatement() {
		return caseStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaseStatement_CaseValue() {
		return (EAttribute)caseStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseStatement_Command() {
		return (EReference)caseStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkip() {
		return skipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTaskTypeEnum() {
		return taskTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableTypeEnum() {
		return variableTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParamModeEnum() {
		return paramModeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Il1Factory getIl1Factory() {
		return (Il1Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		declarationEClass = createEClass(DECLARATION);
		createEAttribute(declarationEClass, DECLARATION__IDENTIFIER);
		createEAttribute(declarationEClass, DECLARATION__TYPE);
		createEAttribute(declarationEClass, DECLARATION__INITIAL_VALUE);
		createEAttribute(declarationEClass, DECLARATION__PROJECT_NAME);
		createEAttribute(declarationEClass, DECLARATION__COMPONENT_NAME);

		variableDeclEClass = createEClass(VARIABLE_DECL);
		createEReference(variableDeclEClass, VARIABLE_DECL__ADDRESS);

		constantDeclEClass = createEClass(CONSTANT_DECL);

		formalParamDeclEClass = createEClass(FORMAL_PARAM_DECL);
		createEAttribute(formalParamDeclEClass, FORMAL_PARAM_DECL__MODE);

		callTargetEClass = createEClass(CALL_TARGET);

		protectedEClass = createEClass(PROTECTED);
		createEReference(protectedEClass, PROTECTED__SUBROUTINES);
		createEReference(protectedEClass, PROTECTED__DECLS);
		createEAttribute(protectedEClass, PROTECTED__PROJECT_NAME);
		createEAttribute(protectedEClass, PROTECTED__MACHINE_NAME);

		taskEClass = createEClass(TASK);
		createEReference(taskEClass, TASK__TASK_TYPE);
		createEAttribute(taskEClass, TASK__PRIORITY);
		createEReference(taskEClass, TASK__DECLS);
		createEReference(taskEClass, TASK__SUBROUTINES);
		createEAttribute(taskEClass, TASK__PROJECT_NAME);
		createEAttribute(taskEClass, TASK__MACHINE_NAME);

		codeContainerEClass = createEClass(CODE_CONTAINER);
		createEReference(codeContainerEClass, CODE_CONTAINER__BODY);

		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__DECLS);
		createEReference(programEClass, PROGRAM__PROTECTED);
		createEReference(programEClass, PROGRAM__ENTRY_POINT);
		createEReference(programEClass, PROGRAM__TASK_TYPE_TASKS);
		createEReference(programEClass, PROGRAM__SUBROUTINES);
		createEReference(programEClass, PROGRAM__ENVIRON_MACHINES);
		createEAttribute(programEClass, PROGRAM__PROJECT_NAME);

		mainEntryEClass = createEClass(MAIN_ENTRY);
		createEReference(mainEntryEClass, MAIN_ENTRY__AUTO_TASKS);

		subroutineEClass = createEClass(SUBROUTINE);
		createEReference(subroutineEClass, SUBROUTINE__FORMAL_PARAMETERS);
		createEReference(subroutineEClass, SUBROUTINE__LOCAL_DECLARATIONS);
		createEAttribute(subroutineEClass, SUBROUTINE__MACHINE_NAME);
		createEAttribute(subroutineEClass, SUBROUTINE__GUARDS);
		createEAttribute(subroutineEClass, SUBROUTINE__PROJECT_NAME);

		commandEClass = createEClass(COMMAND);
		createEAttribute(commandEClass, COMMAND__PARENT_EVENT_NAME);
		createEAttribute(commandEClass, COMMAND__ENVIR_STATE_MACHINE_CHILD);

		preconditionLoopEClass = createEClass(PRECONDITION_LOOP);
		createEReference(preconditionLoopEClass, PRECONDITION_LOOP__COMMAND);
		createEAttribute(preconditionLoopEClass, PRECONDITION_LOOP__CONDITION);

		seqEClass = createEClass(SEQ);
		createEReference(seqEClass, SEQ__LEFT_BRANCH);
		createEReference(seqEClass, SEQ__RIGHT_BRANCH);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__COMMAND);
		createEAttribute(actionEClass, ACTION__ACTION);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEAttribute(assignmentEClass, ASSIGNMENT__UPDATED);
		createEAttribute(assignmentEClass, ASSIGNMENT__VALUE);

		switchEClass = createEClass(SWITCH);
		createEAttribute(switchEClass, SWITCH__CONDITION);
		createEReference(switchEClass, SWITCH__SWITCH_BLOCKS);

		callEClass = createEClass(CALL);
		createEReference(callEClass, CALL__TARGET);
		createEReference(callEClass, CALL__SUBROUTINE);
		createEReference(callEClass, CALL__ACTUAL_PARAMETERS);
		createEAttribute(callEClass, CALL__MACHINE_NAME);
		createEAttribute(callEClass, CALL__PROJECT_NAME);

		ifEClass = createEClass(IF);
		createEAttribute(ifEClass, IF__CONDITION);
		createEReference(ifEClass, IF__BRANCH);
		createEReference(ifEClass, IF__ELSE);
		createEReference(ifEClass, IF__RELATED_EVENT);

		elseIfEClass = createEClass(ELSE_IF);
		createEAttribute(elseIfEClass, ELSE_IF__CONDITION);
		createEReference(elseIfEClass, ELSE_IF__ACTION);
		createEReference(elseIfEClass, ELSE_IF__BRANCH);
		createEReference(elseIfEClass, ELSE_IF__RELATED_EVENT);
		createEAttribute(elseIfEClass, ELSE_IF__ENVIR_STATE_MACHINE_CHILD);

		switchBlockEClass = createEClass(SWITCH_BLOCK);
		createEReference(switchBlockEClass, SWITCH_BLOCK__TEST);
		createEReference(switchBlockEClass, SWITCH_BLOCK__ACTION);

		signatureEClass = createEClass(SIGNATURE);
		createEAttribute(signatureEClass, SIGNATURE__NAME);

		taskTypeEClass = createEClass(TASK_TYPE);

		simpleTaskTypeEClass = createEClass(SIMPLE_TASK_TYPE);
		createEAttribute(simpleTaskTypeEClass, SIMPLE_TASK_TYPE__TYPE);

		environTaskEClass = createEClass(ENVIRON_TASK);

		periodicTaskTypeEClass = createEClass(PERIODIC_TASK_TYPE);
		createEAttribute(periodicTaskTypeEClass, PERIODIC_TASK_TYPE__PERIOD);

		outputEClass = createEClass(OUTPUT);
		createEAttribute(outputEClass, OUTPUT__TEXT);
		createEAttribute(outputEClass, OUTPUT__ELEMENT);

		il1ElementEClass = createEClass(IL1_ELEMENT);

		formulaSetEClass = createEClass(FORMULA_SET);
		createEAttribute(formulaSetEClass, FORMULA_SET__CONDITIONS);

		conditionSetEClass = createEClass(CONDITION_SET);

		commandSetEClass = createEClass(COMMAND_SET);

		localRemoteEClass = createEClass(LOCAL_REMOTE);
		createEReference(localRemoteEClass, LOCAL_REMOTE__LOCAL_SUBROUTINE);
		createEReference(localRemoteEClass, LOCAL_REMOTE__REMOTE_SUBROUTINE);

		inParameterEClass = createEClass(IN_PARAMETER);

		outParameterEClass = createEClass(OUT_PARAMETER);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__ORDER_NUMBER);

		localVariableEClass = createEClass(LOCAL_VARIABLE);

		translatedDeclEClass = createEClass(TRANSLATED_DECL);
		createEAttribute(translatedDeclEClass, TRANSLATED_DECL__TYPE);

		partiallyTranslatedDeclEClass = createEClass(PARTIALLY_TRANSLATED_DECL);
		createEAttribute(partiallyTranslatedDeclEClass, PARTIALLY_TRANSLATED_DECL__PARTIAL_INITIALISATION_EXPRESSION);

		fullyTranslatedDeclEClass = createEClass(FULLY_TRANSLATED_DECL);
		createEAttribute(fullyTranslatedDeclEClass, FULLY_TRANSLATED_DECL__FULL_INITIALISATION_EXPRESSION);

		enumerationEClass = createEClass(ENUMERATION);
		createEAttribute(enumerationEClass, ENUMERATION__LITERAL_VALUES);

		caseEClass = createEClass(CASE);
		createEAttribute(caseEClass, CASE__CASE_EXPRESSION);
		createEReference(caseEClass, CASE__CASE_STATEMENT);

		caseStatementEClass = createEClass(CASE_STATEMENT);
		createEAttribute(caseStatementEClass, CASE_STATEMENT__CASE_VALUE);
		createEReference(caseStatementEClass, CASE_STATEMENT__COMMAND);

		skipEClass = createEClass(SKIP);

		// Create enums
		taskTypeEnumEEnum = createEEnum(TASK_TYPE_ENUM);
		variableTypeEnumEEnum = createEEnum(VARIABLE_TYPE_ENUM);
		paramModeEnumEEnum = createEEnum(PARAM_MODE_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RequiredFormulaPackage theRequiredFormulaPackage = (RequiredFormulaPackage)EPackage.Registry.INSTANCE.getEPackage(RequiredFormulaPackage.eNS_URI);
		RequiredMetadataPackage theRequiredMetadataPackage = (RequiredMetadataPackage)EPackage.Registry.INSTANCE.getEPackage(RequiredMetadataPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		MachinePackage theMachinePackage = (MachinePackage)EPackage.Registry.INSTANCE.getEPackage(MachinePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRequiredFormulaPackage);
		getESubpackages().add(theRequiredMetadataPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		declarationEClass.getESuperTypes().add(this.getIL1Element());
		variableDeclEClass.getESuperTypes().add(this.getDeclaration());
		constantDeclEClass.getESuperTypes().add(this.getDeclaration());
		formalParamDeclEClass.getESuperTypes().add(this.getDeclaration());
		callTargetEClass.getESuperTypes().add(this.getSignature());
		protectedEClass.getESuperTypes().add(theRequiredFormulaPackage.getDataType());
		protectedEClass.getESuperTypes().add(this.getCallTarget());
		taskEClass.getESuperTypes().add(this.getCodeContainer());
		taskEClass.getESuperTypes().add(theRequiredFormulaPackage.getDataType());
		taskEClass.getESuperTypes().add(this.getCallTarget());
		codeContainerEClass.getESuperTypes().add(this.getIL1Element());
		programEClass.getESuperTypes().add(this.getSignature());
		mainEntryEClass.getESuperTypes().add(this.getCodeContainer());
		subroutineEClass.getESuperTypes().add(this.getCodeContainer());
		subroutineEClass.getESuperTypes().add(this.getSignature());
		subroutineEClass.getESuperTypes().add(theRequiredMetadataPackage.getSubroutineMetaData());
		commandEClass.getESuperTypes().add(this.getCodeContainer());
		preconditionLoopEClass.getESuperTypes().add(this.getCommand());
		seqEClass.getESuperTypes().add(this.getCommand());
		actionEClass.getESuperTypes().add(this.getCommand());
		assignmentEClass.getESuperTypes().add(this.getCommand());
		switchEClass.getESuperTypes().add(this.getCommand());
		callEClass.getESuperTypes().add(this.getCommand());
		ifEClass.getESuperTypes().add(this.getCommand());
		elseIfEClass.getESuperTypes().add(this.getIL1Element());
		switchBlockEClass.getESuperTypes().add(this.getIL1Element());
		signatureEClass.getESuperTypes().add(this.getIL1Element());
		taskTypeEClass.getESuperTypes().add(this.getIL1Element());
		simpleTaskTypeEClass.getESuperTypes().add(this.getTaskType());
		environTaskEClass.getESuperTypes().add(this.getTask());
		periodicTaskTypeEClass.getESuperTypes().add(this.getTaskType());
		outputEClass.getESuperTypes().add(this.getCommand());
		formulaSetEClass.getESuperTypes().add(this.getIL1Element());
		conditionSetEClass.getESuperTypes().add(this.getFormulaSet());
		commandSetEClass.getESuperTypes().add(this.getFormulaSet());
		localRemoteEClass.getESuperTypes().add(this.getIL1Element());
		inParameterEClass.getESuperTypes().add(this.getParameter());
		outParameterEClass.getESuperTypes().add(this.getParameter());
		parameterEClass.getESuperTypes().add(this.getDeclaration());
		localVariableEClass.getESuperTypes().add(this.getParameter());
		translatedDeclEClass.getESuperTypes().add(this.getIL1Element());
		partiallyTranslatedDeclEClass.getESuperTypes().add(this.getTranslatedDecl());
		fullyTranslatedDeclEClass.getESuperTypes().add(this.getTranslatedDecl());
		enumerationEClass.getESuperTypes().add(this.getDeclaration());
		caseEClass.getESuperTypes().add(this.getCommand());
		caseStatementEClass.getESuperTypes().add(this.getIL1Element());
		skipEClass.getESuperTypes().add(this.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(declarationEClass, Declaration.class, "Declaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeclaration_Identifier(), theEcorePackage.getEString(), "identifier", "", 1, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeclaration_Type(), theEcorePackage.getEString(), "type", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeclaration_InitialValue(), theEcorePackage.getEString(), "initialValue", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeclaration_ProjectName(), theEcorePackage.getEString(), "ProjectName", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeclaration_ComponentName(), theEcorePackage.getEString(), "ComponentName", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclEClass, VariableDecl.class, "VariableDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDecl_Address(), theRequiredFormulaPackage.getAddressedDeclaration(), null, "address", null, 0, 1, VariableDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantDeclEClass, ConstantDecl.class, "ConstantDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(formalParamDeclEClass, FormalParamDecl.class, "FormalParamDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormalParamDecl_Mode(), this.getParamModeEnum(), "mode", null, 1, 1, FormalParamDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callTargetEClass, CallTarget.class, "CallTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(protectedEClass, Protected.class, "Protected", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtected_Subroutines(), this.getSubroutine(), null, "subroutines", null, 0, -1, Protected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProtected_Decls(), this.getDeclaration(), null, "decls", null, 0, -1, Protected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtected_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, Protected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProtected_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, Protected.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTask_TaskType(), this.getTaskType(), null, "taskType", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Priority(), ecorePackage.getEInt(), "priority", "5", 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_Decls(), this.getDeclaration(), null, "decls", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_Subroutines(), this.getSubroutine(), null, "subroutines", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeContainerEClass, CodeContainer.class, "CodeContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeContainer_Body(), this.getCommand(), null, "body", null, 0, 1, CodeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgram_Decls(), this.getDeclaration(), null, "decls", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Protected(), this.getProtected(), null, "protected", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_EntryPoint(), this.getMainEntry(), null, "entryPoint", null, 0, 1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_TaskTypeTasks(), this.getTask(), null, "taskTypeTasks", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Subroutines(), this.getSubroutine(), null, "subroutines", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_EnvironMachines(), this.getEnvironTask(), null, "environMachines", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgram_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mainEntryEClass, MainEntry.class, "MainEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMainEntry_AutoTasks(), this.getTask(), null, "autoTasks", null, 0, -1, MainEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subroutineEClass, Subroutine.class, "Subroutine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubroutine_FormalParameters(), this.getParameter(), null, "formalParameters", null, 0, -1, Subroutine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubroutine_LocalDeclarations(), this.getDeclaration(), null, "localDeclarations", null, 0, -1, Subroutine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubroutine_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, Subroutine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubroutine_Guards(), theEcorePackage.getEString(), "guards", null, 0, -1, Subroutine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubroutine_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, Subroutine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommand_ParentEventName(), theEcorePackage.getEString(), "ParentEventName", null, 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommand_EnvirStateMachineChild(), theEcorePackage.getEBoolean(), "envirStateMachineChild", "false", 0, 1, Command.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preconditionLoopEClass, PreconditionLoop.class, "PreconditionLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreconditionLoop_Command(), this.getCommand(), null, "command", null, 1, 1, PreconditionLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreconditionLoop_Condition(), theEcorePackage.getEString(), "condition", null, 0, -1, PreconditionLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seqEClass, Seq.class, "Seq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeq_LeftBranch(), this.getCommand(), null, "leftBranch", null, 1, 1, Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSeq_RightBranch(), this.getCommand(), null, "rightBranch", null, 1, 1, Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Command(), this.getCommand(), null, "command", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Action(), ecorePackage.getEString(), "action", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignment_Updated(), theEcorePackage.getEString(), "updated", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchEClass, Switch.class, "Switch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitch_Condition(), theEcorePackage.getEString(), "condition", null, 0, 1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitch_SwitchBlocks(), this.getSwitchBlock(), null, "switchBlocks", null, 1, -1, Switch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCall_Target(), this.getCallTarget(), null, "target", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCall_Subroutine(), this.getSubroutine(), null, "subroutine", null, 1, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCall_ActualParameters(), this.getParameter(), null, "actualParameters", null, 0, -1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_MachineName(), theEcorePackage.getEString(), "machineName", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_ProjectName(), theEcorePackage.getEString(), "projectName", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIf_Condition(), ecorePackage.getEString(), "condition", null, 0, -1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_Branch(), this.getElseIf(), null, "branch", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_Else(), this.getCommand(), null, "else", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_RelatedEvent(), theMachinePackage.getEvent(), null, "relatedEvent", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elseIfEClass, ElseIf.class, "ElseIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElseIf_Condition(), theEcorePackage.getEString(), "condition", null, 0, -1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseIf_Action(), this.getCommand(), null, "action", null, 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseIf_Branch(), this.getElseIf(), null, "branch", null, 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseIf_RelatedEvent(), theMachinePackage.getEvent(), null, "relatedEvent", null, 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElseIf_EnvirStateMachineChild(), theEcorePackage.getEBoolean(), "envirStateMachineChild", "false", 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchBlockEClass, SwitchBlock.class, "SwitchBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchBlock_Test(), this.getConstantDecl(), null, "test", null, 1, 1, SwitchBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchBlock_Action(), this.getCommand(), null, "action", null, 1, 1, SwitchBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signatureEClass, Signature.class, "Signature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignature_Name(), ecorePackage.getEString(), "name", null, 1, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskTypeEClass, TaskType.class, "TaskType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleTaskTypeEClass, SimpleTaskType.class, "SimpleTaskType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleTaskType_Type(), this.getTaskTypeEnum(), "type", null, 1, 1, SimpleTaskType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(environTaskEClass, EnvironTask.class, "EnvironTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(periodicTaskTypeEClass, PeriodicTaskType.class, "PeriodicTaskType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPeriodicTaskType_Period(), ecorePackage.getEInt(), "period", null, 1, 1, PeriodicTaskType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutput_Text(), ecorePackage.getEString(), "text", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_Element(), ecorePackage.getEString(), "element", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(il1ElementEClass, IL1Element.class, "IL1Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(formulaSetEClass, FormulaSet.class, "FormulaSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormulaSet_Conditions(), theEcorePackage.getEString(), "conditions", null, 0, -1, FormulaSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionSetEClass, ConditionSet.class, "ConditionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commandSetEClass, CommandSet.class, "CommandSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localRemoteEClass, LocalRemote.class, "LocalRemote", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalRemote_LocalSubroutine(), this.getSubroutine(), null, "localSubroutine", null, 0, 1, LocalRemote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalRemote_RemoteSubroutine(), this.getSubroutine(), null, "remoteSubroutine", null, 0, 1, LocalRemote.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inParameterEClass, InParameter.class, "InParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outParameterEClass, OutParameter.class, "OutParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_OrderNumber(), theEcorePackage.getEInt(), "orderNumber", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localVariableEClass, LocalVariable.class, "LocalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(translatedDeclEClass, TranslatedDecl.class, "TranslatedDecl", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTranslatedDecl_Type(), theEcorePackage.getEString(), "type", null, 0, 1, TranslatedDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partiallyTranslatedDeclEClass, PartiallyTranslatedDecl.class, "PartiallyTranslatedDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartiallyTranslatedDecl_PartialInitialisationExpression(), theEcorePackage.getEString(), "partialInitialisationExpression", null, 0, 1, PartiallyTranslatedDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fullyTranslatedDeclEClass, FullyTranslatedDecl.class, "FullyTranslatedDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFullyTranslatedDecl_FullInitialisationExpression(), theEcorePackage.getEString(), "fullInitialisationExpression", null, 0, -1, FullyTranslatedDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeration_LiteralValues(), theEcorePackage.getEString(), "literalValues", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseEClass, Case.class, "Case", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCase_CaseExpression(), theEcorePackage.getEString(), "caseExpression", null, 1, 1, Case.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCase_CaseStatement(), this.getCaseStatement(), null, "caseStatement", null, 0, -1, Case.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseStatementEClass, CaseStatement.class, "CaseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseStatement_CaseValue(), theEcorePackage.getEString(), "caseValue", null, 0, 1, CaseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCaseStatement_Command(), this.getCommand(), null, "command", null, 0, 1, CaseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipEClass, Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(taskTypeEnumEEnum, TaskTypeEnum.class, "TaskTypeEnum");
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.REPEATING);
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.TRIGGERED);
		addEEnumLiteral(taskTypeEnumEEnum, TaskTypeEnum.ONE_SHOT);

		initEEnum(variableTypeEnumEEnum, VariableTypeEnum.class, "VariableTypeEnum");
		addEEnumLiteral(variableTypeEnumEEnum, VariableTypeEnum.VARIABLE);
		addEEnumLiteral(variableTypeEnumEEnum, VariableTypeEnum.PARAMETER);

		initEEnum(paramModeEnumEEnum, ParamModeEnum.class, "ParamModeEnum");
		addEEnumLiteral(paramModeEnumEEnum, ParamModeEnum.IN);
		addEEnumLiteral(paramModeEnumEEnum, ParamModeEnum.OUT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// null
		createNullAnnotations();
	}

	/**
	 * Initializes the annotations for <b>null</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNullAnnotations() {
		String source = null;	
		addAnnotation
		  (getPartiallyTranslatedDecl_PartialInitialisationExpression(), 
		   source, 
		   new String[] {
		   });
	}

} //Il1PackageImpl
