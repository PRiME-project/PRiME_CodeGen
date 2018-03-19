/*******************************************************************************
 * Copyright (c) 2006,2007,2008 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.codegen.roseExtension;

import java.text.MessageFormat;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eventb.codegen.taskbodybuilder.utils.Messages;

import tasking.TaskTypeEnum;
import ac.soton.eventb.roseEditor.properties.TextChangeHelper;
import ac.soton.eventb.roseEditor.propertySections.abstracts.AbstractEventBPropertySection;

/**
 * An abstract implementation of a section with a text field.
 *
 * @author ae
 */

public abstract class AbstractTaskBodyPropertySection extends
		AbstractEventBPropertySection {

	/**
	 * A helper to listen for events that indicate that a text field has been
	 * changed.
	 */
	protected TextChangeHelper listener;
//	private final ModifyListener eventBListener = RodinKeyboardPlugin
//			.getDefault().createRodinModifyListener();
	protected StyledText textWidget;
	protected StyledText errorWidget;
//	protected Label errorLabel;
//	protected Label taskBodyLabel;
//	protected Label taskBodyTypeLabel;
//	protected Label taskBodyPriorityLabel;
	protected Text priorityValue;
	protected Combo taskBodyType;
	protected Combo taskBodySimpleOption;
	protected Text taskBodyTimePeriod;

	protected enum TaskTypeItem {
		SIMPLE("Simple"), PERIODIC("Periodic");

		 private String description;

		 private TaskTypeItem(String description) {
		   this.description = description;
		 }

		 public String getDescription() {
		   return description;
		 }
	}

	@Override
	public void createControls(final Composite parent,
			final TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		final Color lightGray = new Color(parent.getDisplay(),211,211,211);

		final Composite formComposite = getWidgetFactory().createFlatFormComposite(parent);

		FormData formData = new FormData();
		final int topNumerator = 0;
		final int topOffset = 5;
		final int leftNumerator = 7;
		final int leftOffset = 5;

		//Attributes: Priority (label and textField) and Type (2 ComboBox or 1 ComboBox and 1 TextField)
		//Priority (label and textField)
		widget = getWidgetFactory().createCLabel(formComposite,Messages.label_task_priority);
		CLabel priorityLabel = (CLabel) widget;
		formData = new FormData();
		formData.top = new FormAttachment(topNumerator,topOffset);
//		formData.bottom = new FormAttachment(0,5);
		formData.left = new FormAttachment(leftNumerator,leftOffset);
//		formData.right = new FormAttachment(15,0);
		priorityLabel.setLayoutData(formData);

		widget = getWidgetFactory().createText(formComposite,"110"); //SWT.SINGLE | SWT.BORDER
		priorityValue = (Text) widget;
		formData = new FormData();
		formData.top = new FormAttachment(topNumerator,topOffset);
//		formData.bottom = new FormAttachment(100,-5);
		formData.left = new FormAttachment(priorityLabel,-5);
		formData.right = new FormAttachment(11,16);
		priorityValue.setLayoutData(formData);

//		priorityValue.addModifyListener(new ModifyListener() {
//			@Override
//			public void modifyText(final ModifyEvent e) {
//				priorityModification(e);
//			}
//		});

		//Type (2 ComboBox or 1 ComboBox and 1 TextField)
		//widget = getWidgetFactory().createCCombo(formComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		taskBodyType = new Combo(formComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);//(CCombo) widget;
		for(TaskTypeItem taskTypeItem: TaskTypeItem.values()){
			taskBodyType.add(taskTypeItem.getDescription());
		}
		taskBodyType.select(0);
		formData = new FormData();
		formData.top = new FormAttachment(topNumerator,topOffset);
		formData.left = new FormAttachment(priorityValue,5);
//		formData.right = new FormAttachment(15,5);
		taskBodyType.setLayoutData(formData);

	    taskBodySimpleOption = new Combo(formComposite, SWT.VERTICAL | SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
	    for(TaskTypeEnum taskTypeItem: TaskTypeEnum.values()){
	    	taskBodySimpleOption.add(taskTypeItem.getName());
	    }
		formData = new FormData();
		formData.top = new FormAttachment(topNumerator,topOffset);
		formData.left = new FormAttachment(taskBodyType,5);
		taskBodySimpleOption.setLayoutData(formData);

		widget = getWidgetFactory().createText(formComposite,"100");
		taskBodyTimePeriod = (Text) widget;
		formData = new FormData();
		formData.top = new FormAttachment(topNumerator,topOffset);
		formData.left = new FormAttachment(taskBodyType,5);
		formData.right = new FormAttachment(17,30);
		taskBodyTimePeriod.setLayoutData(formData);
		taskBodyTimePeriod.setVisible(false);

		taskBodyType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateCombos();
			}
		});

		//TaskBody and Error Description
		textWidget = new StyledText(formComposite, SWT.MULTI | SWT.BORDER);
		formData = new FormData();
		formData.top = new FormAttachment(priorityLabel,5);
		formData.left = new FormAttachment(leftNumerator,leftOffset);
		formData.right = new FormAttachment(15,5);
		formData.bottom = new FormAttachment(20,5);
		formData.height = textWidget.getLineHeight()*textWidget.getLineCount()+10;//(textWidget.getLineCount())*10;
		textWidget.setLayoutData(formData);
		textWidget.setBackground(lightGray);
		textWidget.setForeground(textWidget.getDisplay().getSystemColor(SWT.COLOR_DARK_BLUE));

		errorWidget = new StyledText(formComposite, SWT.MULTI | SWT.BORDER | SWT.READ_ONLY);
		formData = new FormData();
		formData.top = new FormAttachment(priorityLabel,5);
		formData.left = new FormAttachment(textWidget,5);
		formData.right = new FormAttachment(30,5);
		formData.bottom = new FormAttachment(20,5);
		errorWidget.setLayoutData(formData);
		errorWidget.setBackground(lightGray);
		errorWidget.setForeground(errorWidget.getDisplay().getSystemColor(SWT.COLOR_RED));
	    errorWidget.setVisible(false);

		//SetButton
		widget = getWidgetFactory().createButton(formComposite,
				MessageFormat.format("{0}...",//$NON-NLS-1$
						new Object[] { getButtonLabelText() }), SWT.PUSH);
		formData = new FormData();
		formData.top = new FormAttachment(priorityLabel,topOffset);
		formData.left = new FormAttachment(0,-5);
		formData.right = new FormAttachment(textWidget,-10);
		Button taskBodyButton = ((Button) widget);
		taskBodyButton.setLayoutData(formData);
		taskBodyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				buttonAction(event);
			}
		});
	}

	// the default width may be overridden in extensions
	protected int getTextWidth() {
		return 100;
	}

	/**
	 * Handle the text modified event.
	 */
	protected void handleTextModified() {
		String newText = textWidget.getText();
		if (!isCurrent(newText)) {
			editingDomain.getCommandStack().execute(
					SetCommand.create(editingDomain, owner, getFeature(),
							getFeatureValue(newText)));
		}
	}

	@Override
	public void refresh() {
		if (textWidget == null)
			return;
		else {
			String featureAsText = getFeatureAsText();
			textWidget.setText(featureAsText);
			loadInitialValues();
		}
		super.refresh();

	}

	/**
	 * Determine if the provided string value is an equal representation of the
	 * current setting of the text property.
	 *
	 * @param newText
	 *            the new string value.
	 * @return <code>true</code> if the new string value is equal to the current
	 *         property setting.
	 */
	protected abstract boolean isCurrent(String newText);

	/**
	 * Get the feature for the text field for the section.
	 *
	 * @return the feature for the text.
	 */
	protected abstract EStructuralFeature getFeature();

	/**
	 * Get the value of the feature as text for the text field for the section.
	 *
	 * @return the value of the feature as text.
	 */
	protected abstract String getFeatureAsText();

	/**
	 * Get the new value of the feature for the text field for the section.
	 *
	 * @param newText
	 *            the new value of the feature as a string.
	 * @return the new value of the feature.
	 */
	protected abstract Object getFeatureValue(String newText);

	/**
	 * Get the label for the text field for the section.
	 *
	 * @return the label for the text field.
	 */
	protected abstract String getLabelText();

	/**
	 * Get the label for the error text field for the section.
	 *
	 * @return the label for the error text field.
	 */
	protected abstract String getErrorLabelText();

	/**
	 * Get the label for the button
	 *
	 * @return the string
	 */
	protected abstract String getButtonLabelText();

	protected abstract void buttonAction(SelectionEvent event);

	protected abstract void loadInitialValues();

	protected void updateCombos(){
		if (taskBodyType.getText().equals(TaskTypeItem.SIMPLE.description)) {
			taskBodySimpleOption.setVisible(true);
//			taskBodySimpleOption.select(0);			// reverts to repeating regardless of what is actually selected
			taskBodyTimePeriod.setVisible(false);
			parent.pack(true);
		}else if (taskBodyType.getText().equals(TaskTypeItem.PERIODIC.description)){
			taskBodyTimePeriod.setVisible(true);
			taskBodySimpleOption.setVisible(false);
			parent.pack(true);
		}
	}

}