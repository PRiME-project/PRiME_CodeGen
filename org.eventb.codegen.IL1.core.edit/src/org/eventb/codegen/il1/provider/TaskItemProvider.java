/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Il1Package;
import org.eventb.codegen.il1.Task;

/**
 * This is the item provider adapter for a {@link org.eventb.codegen.il1.Task} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskItemProvider
	extends CodeContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addPriorityPropertyDescriptor(object);
			addProjectNamePropertyDescriptor(object);
			addMachineNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Signature_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Signature_name_feature", "_UI_Signature_type"),
				 Il1Package.Literals.SIGNATURE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Priority feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPriorityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Task_priority_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Task_priority_feature", "_UI_Task_type"),
				 Il1Package.Literals.TASK__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Project Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProjectNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Task_projectName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Task_projectName_feature", "_UI_Task_type"),
				 Il1Package.Literals.TASK__PROJECT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Machine Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMachineNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Task_machineName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Task_machineName_feature", "_UI_Task_type"),
				 Il1Package.Literals.TASK__MACHINE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Il1Package.Literals.TASK__TASK_TYPE);
			childrenFeatures.add(Il1Package.Literals.TASK__DECLS);
			childrenFeatures.add(Il1Package.Literals.TASK__SUBROUTINES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Task.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Task"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Task)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Task_type") :
			getString("_UI_Task_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Task.class)) {
			case Il1Package.TASK__NAME:
			case Il1Package.TASK__PRIORITY:
			case Il1Package.TASK__PROJECT_NAME:
			case Il1Package.TASK__MACHINE_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Il1Package.TASK__TASK_TYPE:
			case Il1Package.TASK__DECLS:
			case Il1Package.TASK__SUBROUTINES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__TASK_TYPE,
				 Il1Factory.eINSTANCE.createSimpleTaskType()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__TASK_TYPE,
				 Il1Factory.eINSTANCE.createPeriodicTaskType()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createVariableDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createConstantDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createFormalParamDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createInParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createOutParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createLocalVariable()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__DECLS,
				 Il1Factory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.TASK__SUBROUTINES,
				 Il1Factory.eINSTANCE.createSubroutine()));
	}

}
