/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
import org.eventb.codegen.il1.SwitchBlock;
import org.eventb.codegen.il1.Task;
import org.eventb.codegen.il1.TaskType;
import org.eventb.codegen.il1.TranslatedDecl;
import org.eventb.codegen.il1.VariableDecl;
import org.eventb.codegen.il1.RequiredFormula.DataType;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.Il1Package
 * @generated
 */
public class Il1Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Il1Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Il1Switch() {
		if (modelPackage == null) {
			modelPackage = Il1Package.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Il1Package.DECLARATION: {
				Declaration declaration = (Declaration)theEObject;
				T result = caseDeclaration(declaration);
				if (result == null) result = caseIL1Element(declaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.VARIABLE_DECL: {
				VariableDecl variableDecl = (VariableDecl)theEObject;
				T result = caseVariableDecl(variableDecl);
				if (result == null) result = caseDeclaration(variableDecl);
				if (result == null) result = caseIL1Element(variableDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CONSTANT_DECL: {
				ConstantDecl constantDecl = (ConstantDecl)theEObject;
				T result = caseConstantDecl(constantDecl);
				if (result == null) result = caseDeclaration(constantDecl);
				if (result == null) result = caseIL1Element(constantDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.FORMAL_PARAM_DECL: {
				FormalParamDecl formalParamDecl = (FormalParamDecl)theEObject;
				T result = caseFormalParamDecl(formalParamDecl);
				if (result == null) result = caseDeclaration(formalParamDecl);
				if (result == null) result = caseIL1Element(formalParamDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CALL_TARGET: {
				CallTarget callTarget = (CallTarget)theEObject;
				T result = caseCallTarget(callTarget);
				if (result == null) result = caseSignature(callTarget);
				if (result == null) result = caseIL1Element(callTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PROTECTED: {
				Protected protected_ = (Protected)theEObject;
				T result = caseProtected(protected_);
				if (result == null) result = caseDataType(protected_);
				if (result == null) result = caseCallTarget(protected_);
				if (result == null) result = caseSignature(protected_);
				if (result == null) result = caseIL1Element(protected_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseCodeContainer(task);
				if (result == null) result = caseDataType(task);
				if (result == null) result = caseCallTarget(task);
				if (result == null) result = caseSignature(task);
				if (result == null) result = caseIL1Element(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CODE_CONTAINER: {
				CodeContainer codeContainer = (CodeContainer)theEObject;
				T result = caseCodeContainer(codeContainer);
				if (result == null) result = caseIL1Element(codeContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = caseSignature(program);
				if (result == null) result = caseIL1Element(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.MAIN_ENTRY: {
				MainEntry mainEntry = (MainEntry)theEObject;
				T result = caseMainEntry(mainEntry);
				if (result == null) result = caseCodeContainer(mainEntry);
				if (result == null) result = caseIL1Element(mainEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SUBROUTINE: {
				Subroutine subroutine = (Subroutine)theEObject;
				T result = caseSubroutine(subroutine);
				if (result == null) result = caseCodeContainer(subroutine);
				if (result == null) result = caseSignature(subroutine);
				if (result == null) result = caseSubroutineMetaData(subroutine);
				if (result == null) result = caseIL1Element(subroutine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.COMMAND: {
				Command command = (Command)theEObject;
				T result = caseCommand(command);
				if (result == null) result = caseCodeContainer(command);
				if (result == null) result = caseIL1Element(command);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PRECONDITION_LOOP: {
				PreconditionLoop preconditionLoop = (PreconditionLoop)theEObject;
				T result = casePreconditionLoop(preconditionLoop);
				if (result == null) result = caseCommand(preconditionLoop);
				if (result == null) result = caseCodeContainer(preconditionLoop);
				if (result == null) result = caseIL1Element(preconditionLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SEQ: {
				Seq seq = (Seq)theEObject;
				T result = caseSeq(seq);
				if (result == null) result = caseCommand(seq);
				if (result == null) result = caseCodeContainer(seq);
				if (result == null) result = caseIL1Element(seq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseCommand(action);
				if (result == null) result = caseCodeContainer(action);
				if (result == null) result = caseIL1Element(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseCommand(assignment);
				if (result == null) result = caseCodeContainer(assignment);
				if (result == null) result = caseIL1Element(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SWITCH: {
				org.eventb.codegen.il1.Switch switch_ = (org.eventb.codegen.il1.Switch)theEObject;
				T result = caseSwitch(switch_);
				if (result == null) result = caseCommand(switch_);
				if (result == null) result = caseCodeContainer(switch_);
				if (result == null) result = caseIL1Element(switch_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CALL: {
				Call call = (Call)theEObject;
				T result = caseCall(call);
				if (result == null) result = caseCommand(call);
				if (result == null) result = caseCodeContainer(call);
				if (result == null) result = caseIL1Element(call);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseCommand(if_);
				if (result == null) result = caseCodeContainer(if_);
				if (result == null) result = caseIL1Element(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.ELSE_IF: {
				ElseIf elseIf = (ElseIf)theEObject;
				T result = caseElseIf(elseIf);
				if (result == null) result = caseIL1Element(elseIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SWITCH_BLOCK: {
				SwitchBlock switchBlock = (SwitchBlock)theEObject;
				T result = caseSwitchBlock(switchBlock);
				if (result == null) result = caseIL1Element(switchBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SIGNATURE: {
				Signature signature = (Signature)theEObject;
				T result = caseSignature(signature);
				if (result == null) result = caseIL1Element(signature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.TASK_TYPE: {
				TaskType taskType = (TaskType)theEObject;
				T result = caseTaskType(taskType);
				if (result == null) result = caseIL1Element(taskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SIMPLE_TASK_TYPE: {
				SimpleTaskType simpleTaskType = (SimpleTaskType)theEObject;
				T result = caseSimpleTaskType(simpleTaskType);
				if (result == null) result = caseTaskType(simpleTaskType);
				if (result == null) result = caseIL1Element(simpleTaskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.ENVIRON_TASK: {
				EnvironTask environTask = (EnvironTask)theEObject;
				T result = caseEnvironTask(environTask);
				if (result == null) result = caseTask(environTask);
				if (result == null) result = caseCodeContainer(environTask);
				if (result == null) result = caseDataType(environTask);
				if (result == null) result = caseCallTarget(environTask);
				if (result == null) result = caseSignature(environTask);
				if (result == null) result = caseIL1Element(environTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PERIODIC_TASK_TYPE: {
				PeriodicTaskType periodicTaskType = (PeriodicTaskType)theEObject;
				T result = casePeriodicTaskType(periodicTaskType);
				if (result == null) result = caseTaskType(periodicTaskType);
				if (result == null) result = caseIL1Element(periodicTaskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = caseCommand(output);
				if (result == null) result = caseCodeContainer(output);
				if (result == null) result = caseIL1Element(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.IL1_ELEMENT: {
				IL1Element il1Element = (IL1Element)theEObject;
				T result = caseIL1Element(il1Element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.FORMULA_SET: {
				FormulaSet formulaSet = (FormulaSet)theEObject;
				T result = caseFormulaSet(formulaSet);
				if (result == null) result = caseIL1Element(formulaSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CONDITION_SET: {
				ConditionSet conditionSet = (ConditionSet)theEObject;
				T result = caseConditionSet(conditionSet);
				if (result == null) result = caseFormulaSet(conditionSet);
				if (result == null) result = caseIL1Element(conditionSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.COMMAND_SET: {
				CommandSet commandSet = (CommandSet)theEObject;
				T result = caseCommandSet(commandSet);
				if (result == null) result = caseFormulaSet(commandSet);
				if (result == null) result = caseIL1Element(commandSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.LOCAL_REMOTE: {
				LocalRemote localRemote = (LocalRemote)theEObject;
				T result = caseLocalRemote(localRemote);
				if (result == null) result = caseIL1Element(localRemote);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.IN_PARAMETER: {
				InParameter inParameter = (InParameter)theEObject;
				T result = caseInParameter(inParameter);
				if (result == null) result = caseParameter(inParameter);
				if (result == null) result = caseDeclaration(inParameter);
				if (result == null) result = caseIL1Element(inParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.OUT_PARAMETER: {
				OutParameter outParameter = (OutParameter)theEObject;
				T result = caseOutParameter(outParameter);
				if (result == null) result = caseParameter(outParameter);
				if (result == null) result = caseDeclaration(outParameter);
				if (result == null) result = caseIL1Element(outParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseDeclaration(parameter);
				if (result == null) result = caseIL1Element(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.LOCAL_VARIABLE: {
				LocalVariable localVariable = (LocalVariable)theEObject;
				T result = caseLocalVariable(localVariable);
				if (result == null) result = caseParameter(localVariable);
				if (result == null) result = caseDeclaration(localVariable);
				if (result == null) result = caseIL1Element(localVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.TRANSLATED_DECL: {
				TranslatedDecl translatedDecl = (TranslatedDecl)theEObject;
				T result = caseTranslatedDecl(translatedDecl);
				if (result == null) result = caseIL1Element(translatedDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.PARTIALLY_TRANSLATED_DECL: {
				PartiallyTranslatedDecl partiallyTranslatedDecl = (PartiallyTranslatedDecl)theEObject;
				T result = casePartiallyTranslatedDecl(partiallyTranslatedDecl);
				if (result == null) result = caseTranslatedDecl(partiallyTranslatedDecl);
				if (result == null) result = caseIL1Element(partiallyTranslatedDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.FULLY_TRANSLATED_DECL: {
				FullyTranslatedDecl fullyTranslatedDecl = (FullyTranslatedDecl)theEObject;
				T result = caseFullyTranslatedDecl(fullyTranslatedDecl);
				if (result == null) result = caseTranslatedDecl(fullyTranslatedDecl);
				if (result == null) result = caseIL1Element(fullyTranslatedDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseDeclaration(enumeration);
				if (result == null) result = caseIL1Element(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CASE: {
				Case case_ = (Case)theEObject;
				T result = caseCase(case_);
				if (result == null) result = caseCommand(case_);
				if (result == null) result = caseCodeContainer(case_);
				if (result == null) result = caseIL1Element(case_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.CASE_STATEMENT: {
				CaseStatement caseStatement = (CaseStatement)theEObject;
				T result = caseCaseStatement(caseStatement);
				if (result == null) result = caseIL1Element(caseStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Il1Package.SKIP: {
				Skip skip = (Skip)theEObject;
				T result = caseSkip(skip);
				if (result == null) result = caseCommand(skip);
				if (result == null) result = caseCodeContainer(skip);
				if (result == null) result = caseIL1Element(skip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDecl(VariableDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantDecl(ConstantDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Param Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Param Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParamDecl(FormalParamDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallTarget(CallTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protected</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protected</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtected(Protected object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeContainer(CodeContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Main Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Main Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMainEntry(MainEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subroutine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subroutine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubroutine(Subroutine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precondition Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precondition Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreconditionLoop(PreconditionLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Seq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Seq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeq(Seq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitch(org.eventb.codegen.il1.Switch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCall(Call object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseIf(ElseIf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchBlock(SwitchBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignature(Signature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskType(TaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleTaskType(SimpleTaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Environ Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Environ Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnvironTask(EnvironTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Periodic Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Periodic Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePeriodicTaskType(PeriodicTaskType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IL1 Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IL1 Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIL1Element(IL1Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formula Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formula Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormulaSet(FormulaSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionSet(ConditionSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandSet(CommandSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Remote</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Remote</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalRemote(LocalRemote object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInParameter(InParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutParameter(OutParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariable(LocalVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Translated Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Translated Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTranslatedDecl(TranslatedDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partially Translated Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partially Translated Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartiallyTranslatedDecl(PartiallyTranslatedDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fully Translated Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fully Translated Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFullyTranslatedDecl(FullyTranslatedDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCase(Case object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseStatement(CaseStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Skip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Skip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSkip(Skip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subroutine Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subroutine Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubroutineMetaData(SubroutineMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Il1Switch
