/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eventb.codegen.il1.*;
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
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.InParameter;
import org.eventb.codegen.il1.LocalRemote;
import org.eventb.codegen.il1.LocalVariable;
import org.eventb.codegen.il1.MainEntry;
import org.eventb.codegen.il1.OutParameter;
import org.eventb.codegen.il1.Output;
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
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.RequiredFormula.DataType;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.Il1Package
 * @generated
 */
public class Il1AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Il1Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Il1AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Il1Package.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Il1Switch<Adapter> modelSwitch =
		new Il1Switch<Adapter>() {
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseVariableDecl(VariableDecl object) {
				return createVariableDeclAdapter();
			}
			@Override
			public Adapter caseConstantDecl(ConstantDecl object) {
				return createConstantDeclAdapter();
			}
			@Override
			public Adapter caseFormalParamDecl(FormalParamDecl object) {
				return createFormalParamDeclAdapter();
			}
			@Override
			public Adapter caseCallTarget(CallTarget object) {
				return createCallTargetAdapter();
			}
			@Override
			public Adapter caseProtected(Protected object) {
				return createProtectedAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseCodeContainer(CodeContainer object) {
				return createCodeContainerAdapter();
			}
			@Override
			public Adapter caseProgram(Program object) {
				return createProgramAdapter();
			}
			@Override
			public Adapter caseMainEntry(MainEntry object) {
				return createMainEntryAdapter();
			}
			@Override
			public Adapter caseSubroutine(Subroutine object) {
				return createSubroutineAdapter();
			}
			@Override
			public Adapter caseCommand(Command object) {
				return createCommandAdapter();
			}
			@Override
			public Adapter casePreconditionLoop(PreconditionLoop object) {
				return createPreconditionLoopAdapter();
			}
			@Override
			public Adapter caseSeq(Seq object) {
				return createSeqAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseSwitch(Switch object) {
				return createSwitchAdapter();
			}
			@Override
			public Adapter caseCall(Call object) {
				return createCallAdapter();
			}
			@Override
			public Adapter caseIf(If object) {
				return createIfAdapter();
			}
			@Override
			public Adapter caseElseIf(ElseIf object) {
				return createElseIfAdapter();
			}
			@Override
			public Adapter caseSwitchBlock(SwitchBlock object) {
				return createSwitchBlockAdapter();
			}
			@Override
			public Adapter caseSignature(Signature object) {
				return createSignatureAdapter();
			}
			@Override
			public Adapter caseTaskType(TaskType object) {
				return createTaskTypeAdapter();
			}
			@Override
			public Adapter caseSimpleTaskType(SimpleTaskType object) {
				return createSimpleTaskTypeAdapter();
			}
			@Override
			public Adapter caseEnvironTask(EnvironTask object) {
				return createEnvironTaskAdapter();
			}
			@Override
			public Adapter casePeriodicTaskType(PeriodicTaskType object) {
				return createPeriodicTaskTypeAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseIL1Element(IL1Element object) {
				return createIL1ElementAdapter();
			}
			@Override
			public Adapter caseFormulaSet(FormulaSet object) {
				return createFormulaSetAdapter();
			}
			@Override
			public Adapter caseConditionSet(ConditionSet object) {
				return createConditionSetAdapter();
			}
			@Override
			public Adapter caseCommandSet(CommandSet object) {
				return createCommandSetAdapter();
			}
			@Override
			public Adapter caseLocalRemote(LocalRemote object) {
				return createLocalRemoteAdapter();
			}
			@Override
			public Adapter caseInParameter(InParameter object) {
				return createInParameterAdapter();
			}
			@Override
			public Adapter caseOutParameter(OutParameter object) {
				return createOutParameterAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseLocalVariable(LocalVariable object) {
				return createLocalVariableAdapter();
			}
			@Override
			public Adapter caseTranslatedDecl(TranslatedDecl object) {
				return createTranslatedDeclAdapter();
			}
			@Override
			public Adapter casePartiallyTranslatedDecl(PartiallyTranslatedDecl object) {
				return createPartiallyTranslatedDeclAdapter();
			}
			@Override
			public Adapter caseFullyTranslatedDecl(FullyTranslatedDecl object) {
				return createFullyTranslatedDeclAdapter();
			}
			@Override
			public Adapter caseEnumeration(Enumeration object) {
				return createEnumerationAdapter();
			}
			@Override
			public Adapter caseCase(Case object) {
				return createCaseAdapter();
			}
			@Override
			public Adapter caseCaseStatement(CaseStatement object) {
				return createCaseStatementAdapter();
			}
			@Override
			public Adapter caseSkip(Skip object) {
				return createSkipAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseSubroutineMetaData(SubroutineMetaData object) {
				return createSubroutineMetaDataAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.VariableDecl <em>Variable Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.VariableDecl
	 * @generated
	 */
	public Adapter createVariableDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.ConstantDecl <em>Constant Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.ConstantDecl
	 * @generated
	 */
	public Adapter createConstantDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.FormalParamDecl <em>Formal Param Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.FormalParamDecl
	 * @generated
	 */
	public Adapter createFormalParamDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.CallTarget <em>Call Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.CallTarget
	 * @generated
	 */
	public Adapter createCallTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Protected <em>Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Protected
	 * @generated
	 */
	public Adapter createProtectedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.CodeContainer <em>Code Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.CodeContainer
	 * @generated
	 */
	public Adapter createCodeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.MainEntry <em>Main Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.MainEntry
	 * @generated
	 */
	public Adapter createMainEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Subroutine <em>Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Subroutine
	 * @generated
	 */
	public Adapter createSubroutineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.PreconditionLoop <em>Precondition Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.PreconditionLoop
	 * @generated
	 */
	public Adapter createPreconditionLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Seq <em>Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Seq
	 * @generated
	 */
	public Adapter createSeqAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Switch
	 * @generated
	 */
	public Adapter createSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Call
	 * @generated
	 */
	public Adapter createCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.ElseIf <em>Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.ElseIf
	 * @generated
	 */
	public Adapter createElseIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.SwitchBlock <em>Switch Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.SwitchBlock
	 * @generated
	 */
	public Adapter createSwitchBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Signature
	 * @generated
	 */
	public Adapter createSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.TaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.TaskType
	 * @generated
	 */
	public Adapter createTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.SimpleTaskType <em>Simple Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.SimpleTaskType
	 * @generated
	 */
	public Adapter createSimpleTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.EnvironTask <em>Environ Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.EnvironTask
	 * @generated
	 */
	public Adapter createEnvironTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.PeriodicTaskType <em>Periodic Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.PeriodicTaskType
	 * @generated
	 */
	public Adapter createPeriodicTaskTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.IL1Element <em>IL1 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.IL1Element
	 * @generated
	 */
	public Adapter createIL1ElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.FormulaSet <em>Formula Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.FormulaSet
	 * @generated
	 */
	public Adapter createFormulaSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.ConditionSet <em>Condition Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.ConditionSet
	 * @generated
	 */
	public Adapter createConditionSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.CommandSet <em>Command Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.CommandSet
	 * @generated
	 */
	public Adapter createCommandSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.LocalRemote <em>Local Remote</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.LocalRemote
	 * @generated
	 */
	public Adapter createLocalRemoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.InParameter <em>In Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.InParameter
	 * @generated
	 */
	public Adapter createInParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.OutParameter <em>Out Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.OutParameter
	 * @generated
	 */
	public Adapter createOutParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.LocalVariable <em>Local Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.LocalVariable
	 * @generated
	 */
	public Adapter createLocalVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.TranslatedDecl <em>Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.TranslatedDecl
	 * @generated
	 */
	public Adapter createTranslatedDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.PartiallyTranslatedDecl <em>Partially Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.PartiallyTranslatedDecl
	 * @generated
	 */
	public Adapter createPartiallyTranslatedDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.FullyTranslatedDecl <em>Fully Translated Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.FullyTranslatedDecl
	 * @generated
	 */
	public Adapter createFullyTranslatedDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Enumeration
	 * @generated
	 */
	public Adapter createEnumerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Case
	 * @generated
	 */
	public Adapter createCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.CaseStatement <em>Case Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.CaseStatement
	 * @generated
	 */
	public Adapter createCaseStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.Skip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.Skip
	 * @generated
	 */
	public Adapter createSkipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.RequiredFormula.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.RequiredFormula.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData <em>Subroutine Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData
	 * @generated
	 */
	public Adapter createSubroutineMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Il1AdapterFactory
