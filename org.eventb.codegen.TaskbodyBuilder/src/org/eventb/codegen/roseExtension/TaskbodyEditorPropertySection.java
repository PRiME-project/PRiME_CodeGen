/*******************************************************************************
 * Copyright (c) 2006,2007,2008 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.codegen.roseExtension;

import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eventb.codegen.taskbodybuilder.AbstractTextParser;
import org.eventb.codegen.taskbodybuilder.EMFToTextParser;
import org.eventb.codegen.taskbodybuilder.ParseException;
import org.eventb.codegen.taskbodybuilder.TextToEMFParser;
import org.eventb.codegen.taskbodybuilder.utils.Messages;
import org.eventb.codegen.taskbodybuilder.utils.TaskingGrammarUtils;
import org.eventb.emf.core.EventBCommented;
import org.eventb.emf.core.EventBObject;
import org.rodinp.core.RodinDBException;

import tasking.PeriodicTaskType;
import tasking.SimpleTaskType;
import tasking.Task;
import tasking.TaskType;
import tasking.TaskTypeEnum;
import tasking.TaskingFactory;

import compositeControl.CompositeControl;

/**
 * A section for the Body of a selected Task (Environ or Auto).
 *
 * @author ae
 */

public class TaskbodyEditorPropertySection extends
		AbstractTaskBodyStringPropertySection implements IFilter {

	private static Task selectedTask;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	@Override
	public boolean select(final Object selected) {
		try {
			EventBObject element = (EventBObject) selected;
			if (element instanceof Task){
				selectedTask = (Task)element;
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	protected String getLabelText() {
		return "Task Body:"; //$NON-NLS-1$
	}

	@Override
	protected EStructuralFeature getFeature() {
		return (selectedTask.getTaskBody()==null)? null : selectedTask.getTaskBody().eContainingFeature();//TaskingPackage.eINSTANCE.getTask_TaskBody();
	}

	// override to construct string from EMF task body
	@Override
	protected String getFeatureAsText() {
		String returnFeatureText = "ERROR - feature not string";
		Object feature = getFeature();
		if (feature == null) {
			returnFeatureText = "";
		}
		else if (feature instanceof EReference) {
			String outputText = textWidget.getText();
			EMFToTextParser emfParser = new EMFToTextParser(selectedTask);
			String newOutputText = emfParser.outputText();
//			if(!emfParser.existsParsingError())
				outputText = newOutputText;
			returnFeatureText = outputText;
			loadInitialValues();
		}
		updateViewDisplay();
		return returnFeatureText;
	}

	private void updateViewDisplay(){
		if(errorWidget!=null){
			if(errorWidget.getText().trim().isEmpty()){
				errorWidget.setVisible(false);
			}else{
				errorWidget.setVisible(true);
			}
		}

		int height = textWidget.getLineHeight()*textWidget.getLineCount();
		FormData layoutData = (FormData)textWidget.getLayoutData();
		layoutData.height = height;
		textWidget.setLayoutData(layoutData);
		textWidget.redraw();

		height = errorWidget.getLineHeight()*errorWidget.getLineCount();
		layoutData = (FormData)errorWidget.getLayoutData();
		layoutData.height = height;
		errorWidget.setLayoutData(layoutData);
		errorWidget.redraw();

		Composite parentComposite = errorWidget.getParent();
		parentComposite.pack(true);
	}

	/**
	 * Handle the text modified event.
	 */
	@Override
	protected void handleTextModified() {
		// Do nothing here, use the Generate Button to create EMF instead
	}

	@Override
	protected String getButtonLabelText() {
		return Messages.button_set_taskBody;
	}

	@Override
	protected void buttonAction(SelectionEvent event) {
		Command command;

		Object newValue = getNewTaskBody();
		if (newValue == null) {
			command = UnexecutableCommand.INSTANCE;
		}else{
			command = SetCommand.create(editingDomain, owner, getFeature(), newValue);
			if (newValue instanceof EventBCommented){
				((EventBCommented)newValue).setComment("");
			}
		}
		editingDomain.getCommandStack().execute(command);
		updateValues((CompositeControl) newValue);
		updateViewDisplay();
//		refresh();
	}

	private CompositeControl getNewTaskBody(){
		errorWidget.setText("");
		String taskBodyString = textWidget.getText();
		TextToEMFParser textParser = null;
		CompositeControl newValue = null;
		try {
			//update taskBody widget editor and possibly the error widget
			textParser = new TextToEMFParser(taskBodyString,selectedTask);
			if(textParser.validParsingGrammar()){
				textParser.validateInputAndGenerateEMF();
				if(textParser.isParseValid())
					newValue = textParser.getNewValue();
			}else{
				String error_description = textParser.getError_description();
				for(AbstractTextParser.ErrorLocation errorLocation: textParser.getErrorsLocations()){
					int lineNumber = errorLocation.getLineNumber();
					int columnNumber = errorLocation.getColumnNumber();
				}

			}
		} catch (UnsupportedEncodingException e) {
			Status myStatus = new Status(IStatus.ERROR,
					org.eventb.codegen.taskbodybuilder.Activator.PLUGIN_ID, "Failed Translation: UnsupportedEncodingException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (ParseException e) {
			Status myStatus = new Status(IStatus.ERROR,
					org.eventb.codegen.taskbodybuilder.Activator.PLUGIN_ID, "Failed Translation: ParseException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		} catch (RodinDBException e) {
			Status myStatus = new Status(IStatus.ERROR,
					org.eventb.codegen.taskbodybuilder.Activator.PLUGIN_ID, "Failed Translation: RodinDBException", e);
			StatusManager.getManager().handle(myStatus, StatusManager.SHOW);
			e.printStackTrace(System.err);
		}

//		loadInitialValues();

		if(!textParser.isParseValid()){
			errorWidget.setText(textParser.getError_description());
		}

		return newValue;
	}

	@Override
	protected String getErrorLabelText() {
		return "Error Description";
	}

	@Override
	protected void loadInitialValues(){
		if(selectedTask!=null && priorityValidation()){
			priorityValue.setText(String.valueOf(selectedTask.getPriority()));
		}
		if(errorWidget.getText().isEmpty()){
			if(selectedTask.getTaskType() instanceof SimpleTaskType){
				taskBodyType.select(TaskingGrammarUtils.getIndex(TaskTypeItem.SIMPLE.getDescription(),taskBodyType.getItems()));
				SimpleTaskType simpleTask = (SimpleTaskType) selectedTask.getTaskType();
				TaskTypeEnum type = simpleTask.getType();
				taskBodySimpleOption.select(TaskingGrammarUtils.getIndex(type.getName(),taskBodySimpleOption.getItems()));
			}
			else if(selectedTask.getTaskType() instanceof PeriodicTaskType){
				PeriodicTaskType periodicTask = (PeriodicTaskType) selectedTask.getTaskType();
				taskBodyType.select(TaskingGrammarUtils.getIndex(TaskTypeItem.PERIODIC.getDescription(),taskBodyType.getItems()));
				if(periodValidation())
					taskBodyTimePeriod.setText(String.valueOf(periodicTask.getPeriod()));
			}
			updateCombos();
		}
	}

	private TaskType updateTaskType(CompositeControl newComposite){
		TaskType taskType = null;
		if(newComposite!=null && newComposite.eContainer() instanceof Task){
			if(TaskingGrammarUtils.getIndex(TaskTypeItem.SIMPLE.getDescription(),taskBodyType.getItems()) == taskBodyType.getSelectionIndex()){
				SimpleTaskType simpleTaskType = TaskingFactory.eINSTANCE.createSimpleTaskType();
				simpleTaskType.setType(TaskTypeEnum.getByName(taskBodySimpleOption.getText()));
				taskType = simpleTaskType;
			}
			else if(TaskingGrammarUtils.getIndex(TaskTypeItem.PERIODIC.getDescription(),taskBodyType.getItems()) == taskBodyType.getSelectionIndex() && periodValidation()){
				PeriodicTaskType periodicTaskType = TaskingFactory.eINSTANCE.createPeriodicTaskType();
				periodicTaskType.setPeriod(new Integer(String.valueOf(taskBodyTimePeriod.getText())).intValue());
				taskType = periodicTaskType;
			}
		}

		return taskType;
	}

	private void updateValues(CompositeControl newComposite){
		Command command;
//		Object updatedTask = null;
		if(newComposite!=null && newComposite.eContainer() instanceof Task){
			Task task = (Task)newComposite.eContainer();
			if(priorityValidation()){
				task.setPriority(new Integer(String.valueOf(priorityValue.getText())).intValue());
			}
		}

		TaskType newValue = updateTaskType(newComposite);

		if (newValue == null) {
			command = UnexecutableCommand.INSTANCE;
		}
		else{
			if(selectedTask.getTaskType()!=null){
				command = SetCommand.create(editingDomain, owner, selectedTask.getTaskType().eContainingFeature(), newValue);
			}else{
				command = AddCommand.create(editingDomain, owner,null , newValue);
			}
			updateCombos();
		}
		editingDomain.getCommandStack().execute(command);
	}

	private boolean priorityValidation() {
		boolean valid = true;
		String input = priorityValue.getText();
		if(input.trim().isEmpty()){
			errorWidget.setText(errorWidget.getText()+"\n"+"Priority value is not defined");
			valid = false;
		}
		else if(!TaskingGrammarUtils.isNumeric(input)){
			errorWidget.setText("Priority value '"+ input +"' is not a number");
			valid = false;
		}

		return valid;
	}

	private boolean periodValidation() {
		boolean valid = true;
		String input = taskBodyTimePeriod.getText();
		if(input.trim().isEmpty()){
			errorWidget.setText("Periodic value is not defined");
			errorWidget.setEnabled(true);
			valid = false;
		}
		else if(!TaskingGrammarUtils.isNumeric(input)){
			errorWidget.setText("Periodic value '"+ input +"' is not a number");
			errorWidget.setEnabled(true);
			valid = false;
		}

		return valid;
	}
}