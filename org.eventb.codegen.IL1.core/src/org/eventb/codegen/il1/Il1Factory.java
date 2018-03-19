/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1;

import org.eclipse.emf.ecore.EFactory;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.Il1Package
 * @generated
 */
public interface Il1Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Il1Factory eINSTANCE = org.eventb.codegen.il1.impl.Il1FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Variable Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Decl</em>'.
	 * @generated
	 */
	VariableDecl createVariableDecl();

	/**
	 * Returns a new object of class '<em>Constant Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Decl</em>'.
	 * @generated
	 */
	ConstantDecl createConstantDecl();

	/**
	 * Returns a new object of class '<em>Formal Param Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Formal Param Decl</em>'.
	 * @generated
	 */
	FormalParamDecl createFormalParamDecl();

	/**
	 * Returns a new object of class '<em>Call Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Target</em>'.
	 * @generated
	 */
	CallTarget createCallTarget();

	/**
	 * Returns a new object of class '<em>Protected</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Protected</em>'.
	 * @generated
	 */
	Protected createProtected();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>Main Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Main Entry</em>'.
	 * @generated
	 */
	MainEntry createMainEntry();

	/**
	 * Returns a new object of class '<em>Subroutine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subroutine</em>'.
	 * @generated
	 */
	Subroutine createSubroutine();

	/**
	 * Returns a new object of class '<em>Precondition Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precondition Loop</em>'.
	 * @generated
	 */
	PreconditionLoop createPreconditionLoop();

	/**
	 * Returns a new object of class '<em>Seq</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Seq</em>'.
	 * @generated
	 */
	Seq createSeq();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch</em>'.
	 * @generated
	 */
	Switch createSwitch();

	/**
	 * Returns a new object of class '<em>Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call</em>'.
	 * @generated
	 */
	Call createCall();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Else If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else If</em>'.
	 * @generated
	 */
	ElseIf createElseIf();

	/**
	 * Returns a new object of class '<em>Switch Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Block</em>'.
	 * @generated
	 */
	SwitchBlock createSwitchBlock();

	/**
	 * Returns a new object of class '<em>Simple Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Task Type</em>'.
	 * @generated
	 */
	SimpleTaskType createSimpleTaskType();

	/**
	 * Returns a new object of class '<em>Environ Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environ Task</em>'.
	 * @generated
	 */
	EnvironTask createEnvironTask();

	/**
	 * Returns a new object of class '<em>Periodic Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Periodic Task Type</em>'.
	 * @generated
	 */
	PeriodicTaskType createPeriodicTaskType();

	/**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
	Output createOutput();

	/**
	 * Returns a new object of class '<em>IL1 Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IL1 Element</em>'.
	 * @generated
	 */
	IL1Element createIL1Element();

	/**
	 * Returns a new object of class '<em>Formula Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Formula Set</em>'.
	 * @generated
	 */
	FormulaSet createFormulaSet();

	/**
	 * Returns a new object of class '<em>Condition Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Set</em>'.
	 * @generated
	 */
	ConditionSet createConditionSet();

	/**
	 * Returns a new object of class '<em>Command Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Set</em>'.
	 * @generated
	 */
	CommandSet createCommandSet();

	/**
	 * Returns a new object of class '<em>Local Remote</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Remote</em>'.
	 * @generated
	 */
	LocalRemote createLocalRemote();

	/**
	 * Returns a new object of class '<em>In Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Parameter</em>'.
	 * @generated
	 */
	InParameter createInParameter();

	/**
	 * Returns a new object of class '<em>Out Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out Parameter</em>'.
	 * @generated
	 */
	OutParameter createOutParameter();

	/**
	 * Returns a new object of class '<em>Local Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Variable</em>'.
	 * @generated
	 */
	LocalVariable createLocalVariable();

	/**
	 * Returns a new object of class '<em>Partially Translated Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partially Translated Decl</em>'.
	 * @generated
	 */
	PartiallyTranslatedDecl createPartiallyTranslatedDecl();

	/**
	 * Returns a new object of class '<em>Fully Translated Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fully Translated Decl</em>'.
	 * @generated
	 */
	FullyTranslatedDecl createFullyTranslatedDecl();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case</em>'.
	 * @generated
	 */
	Case createCase();

	/**
	 * Returns a new object of class '<em>Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case Statement</em>'.
	 * @generated
	 */
	CaseStatement createCaseStatement();

	/**
	 * Returns a new object of class '<em>Skip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip</em>'.
	 * @generated
	 */
	Skip createSkip();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Il1Package getIl1Package();

} //Il1Factory
