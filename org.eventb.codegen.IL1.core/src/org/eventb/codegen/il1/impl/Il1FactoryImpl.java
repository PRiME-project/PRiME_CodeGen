/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eventb.codegen.il1.*;
import org.eventb.codegen.il1.Action;
import org.eventb.codegen.il1.Assignment;
import org.eventb.codegen.il1.Call;
import org.eventb.codegen.il1.CallTarget;
import org.eventb.codegen.il1.Case;
import org.eventb.codegen.il1.CaseStatement;
import org.eventb.codegen.il1.CommandSet;
import org.eventb.codegen.il1.ConditionSet;
import org.eventb.codegen.il1.ConstantDecl;
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
import org.eventb.codegen.il1.PartiallyTranslatedDecl;
import org.eventb.codegen.il1.PeriodicTaskType;
import org.eventb.codegen.il1.PreconditionLoop;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.Protected;
import org.eventb.codegen.il1.Seq;
import org.eventb.codegen.il1.SimpleTaskType;
import org.eventb.codegen.il1.Skip;
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.Switch;
import org.eventb.codegen.il1.SwitchBlock;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskTypeEnum;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.VariableTypeEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Il1FactoryImpl extends EFactoryImpl implements Il1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Il1Factory init() {
		try {
			Il1Factory theIl1Factory = (Il1Factory)EPackage.Registry.INSTANCE.getEFactory(Il1Package.eNS_URI);
			if (theIl1Factory != null) {
				return theIl1Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Il1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Il1FactoryImpl() {
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
			case Il1Package.VARIABLE_DECL: return createVariableDecl();
			case Il1Package.CONSTANT_DECL: return createConstantDecl();
			case Il1Package.FORMAL_PARAM_DECL: return createFormalParamDecl();
			case Il1Package.CALL_TARGET: return createCallTarget();
			case Il1Package.PROTECTED: return createProtected();
			case Il1Package.TASK: return createTask();
			case Il1Package.PROGRAM: return createProgram();
			case Il1Package.MAIN_ENTRY: return createMainEntry();
			case Il1Package.SUBROUTINE: return createSubroutine();
			case Il1Package.PRECONDITION_LOOP: return createPreconditionLoop();
			case Il1Package.SEQ: return createSeq();
			case Il1Package.ACTION: return createAction();
			case Il1Package.ASSIGNMENT: return createAssignment();
			case Il1Package.SWITCH: return createSwitch();
			case Il1Package.CALL: return createCall();
			case Il1Package.IF: return createIf();
			case Il1Package.ELSE_IF: return createElseIf();
			case Il1Package.SWITCH_BLOCK: return createSwitchBlock();
			case Il1Package.SIMPLE_TASK_TYPE: return createSimpleTaskType();
			case Il1Package.ENVIRON_TASK: return createEnvironTask();
			case Il1Package.PERIODIC_TASK_TYPE: return createPeriodicTaskType();
			case Il1Package.OUTPUT: return createOutput();
			case Il1Package.IL1_ELEMENT: return createIL1Element();
			case Il1Package.FORMULA_SET: return createFormulaSet();
			case Il1Package.CONDITION_SET: return createConditionSet();
			case Il1Package.COMMAND_SET: return createCommandSet();
			case Il1Package.LOCAL_REMOTE: return createLocalRemote();
			case Il1Package.IN_PARAMETER: return createInParameter();
			case Il1Package.OUT_PARAMETER: return createOutParameter();
			case Il1Package.LOCAL_VARIABLE: return createLocalVariable();
			case Il1Package.PARTIALLY_TRANSLATED_DECL: return createPartiallyTranslatedDecl();
			case Il1Package.FULLY_TRANSLATED_DECL: return createFullyTranslatedDecl();
			case Il1Package.ENUMERATION: return createEnumeration();
			case Il1Package.CASE: return createCase();
			case Il1Package.CASE_STATEMENT: return createCaseStatement();
			case Il1Package.SKIP: return createSkip();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Il1Package.TASK_TYPE_ENUM:
				return createTaskTypeEnumFromString(eDataType, initialValue);
			case Il1Package.VARIABLE_TYPE_ENUM:
				return createVariableTypeEnumFromString(eDataType, initialValue);
			case Il1Package.PARAM_MODE_ENUM:
				return createParamModeEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Il1Package.TASK_TYPE_ENUM:
				return convertTaskTypeEnumToString(eDataType, instanceValue);
			case Il1Package.VARIABLE_TYPE_ENUM:
				return convertVariableTypeEnumToString(eDataType, instanceValue);
			case Il1Package.PARAM_MODE_ENUM:
				return convertParamModeEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDecl createVariableDecl() {
		VariableDeclImpl variableDecl = new VariableDeclImpl();
		return variableDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantDecl createConstantDecl() {
		ConstantDeclImpl constantDecl = new ConstantDeclImpl();
		return constantDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParamDecl createFormalParamDecl() {
		FormalParamDeclImpl formalParamDecl = new FormalParamDeclImpl();
		return formalParamDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTarget createCallTarget() {
		CallTargetImpl callTarget = new CallTargetImpl();
		return callTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protected createProtected() {
		ProtectedImpl protected_ = new ProtectedImpl();
		return protected_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainEntry createMainEntry() {
		MainEntryImpl mainEntry = new MainEntryImpl();
		return mainEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine createSubroutine() {
		SubroutineImpl subroutine = new SubroutineImpl();
		return subroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreconditionLoop createPreconditionLoop() {
		PreconditionLoopImpl preconditionLoop = new PreconditionLoopImpl();
		return preconditionLoop;
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
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Switch createSwitch() {
		SwitchImpl switch_ = new SwitchImpl();
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Call createCall() {
		CallImpl call = new CallImpl();
		return call;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseIf createElseIf() {
		ElseIfImpl elseIf = new ElseIfImpl();
		return elseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchBlock createSwitchBlock() {
		SwitchBlockImpl switchBlock = new SwitchBlockImpl();
		return switchBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleTaskType createSimpleTaskType() {
		SimpleTaskTypeImpl simpleTaskType = new SimpleTaskTypeImpl();
		return simpleTaskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironTask createEnvironTask() {
		EnvironTaskImpl environTask = new EnvironTaskImpl();
		return environTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeriodicTaskType createPeriodicTaskType() {
		PeriodicTaskTypeImpl periodicTaskType = new PeriodicTaskTypeImpl();
		return periodicTaskType;
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
	public IL1Element createIL1Element() {
		IL1ElementImpl il1Element = new IL1ElementImpl();
		return il1Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaSet createFormulaSet() {
		FormulaSetImpl formulaSet = new FormulaSetImpl();
		return formulaSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionSet createConditionSet() {
		ConditionSetImpl conditionSet = new ConditionSetImpl();
		return conditionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandSet createCommandSet() {
		CommandSetImpl commandSet = new CommandSetImpl();
		return commandSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalRemote createLocalRemote() {
		LocalRemoteImpl localRemote = new LocalRemoteImpl();
		return localRemote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InParameter createInParameter() {
		InParameterImpl inParameter = new InParameterImpl();
		return inParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutParameter createOutParameter() {
		OutParameterImpl outParameter = new OutParameterImpl();
		return outParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariable createLocalVariable() {
		LocalVariableImpl localVariable = new LocalVariableImpl();
		return localVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartiallyTranslatedDecl createPartiallyTranslatedDecl() {
		PartiallyTranslatedDeclImpl partiallyTranslatedDecl = new PartiallyTranslatedDeclImpl();
		return partiallyTranslatedDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FullyTranslatedDecl createFullyTranslatedDecl() {
		FullyTranslatedDeclImpl fullyTranslatedDecl = new FullyTranslatedDeclImpl();
		return fullyTranslatedDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case createCase() {
		CaseImpl case_ = new CaseImpl();
		return case_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseStatement createCaseStatement() {
		CaseStatementImpl caseStatement = new CaseStatementImpl();
		return caseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Skip createSkip() {
		SkipImpl skip = new SkipImpl();
		return skip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskTypeEnum createTaskTypeEnumFromString(EDataType eDataType, String initialValue) {
		TaskTypeEnum result = TaskTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTaskTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableTypeEnum createVariableTypeEnumFromString(EDataType eDataType, String initialValue) {
		VariableTypeEnum result = VariableTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamModeEnum createParamModeEnumFromString(EDataType eDataType, String initialValue) {
		ParamModeEnum result = ParamModeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParamModeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Il1Package getIl1Package() {
		return (Il1Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Il1Package getPackage() {
		return Il1Package.eINSTANCE;
	}

} //Il1FactoryImpl
