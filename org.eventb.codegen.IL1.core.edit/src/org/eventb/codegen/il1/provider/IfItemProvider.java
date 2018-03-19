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
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.codegen.il1.If;
import org.eventb.codegen.il1.Il1Factory;
import org.eventb.codegen.il1.Il1Package;

/**
 * This is the item provider adapter for a {@link org.eventb.codegen.il1.If} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IfItemProvider
	extends CommandItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfItemProvider(AdapterFactory adapterFactory) {
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

			addRelatedEventPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Related Event feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelatedEventPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_If_relatedEvent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_If_relatedEvent_feature", "_UI_If_type"),
				 Il1Package.Literals.IF__RELATED_EVENT,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(Il1Package.Literals.IF__CONDITION);
			childrenFeatures.add(Il1Package.Literals.IF__BRANCH);
			childrenFeatures.add(Il1Package.Literals.IF__ELSE);
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
	 * This returns If.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/If"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((If)object).getParentEventName();
		return label == null || label.length() == 0 ?
			getString("_UI_If_type") :
			getString("_UI_If_type") + " " + label;
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

		switch (notification.getFeatureID(If.class)) {
			case Il1Package.IF__CONDITION:
			case Il1Package.IF__BRANCH:
			case Il1Package.IF__ELSE:
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
				(Il1Package.Literals.IF__CONDITION,
				 ""));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__BRANCH,
				 Il1Factory.eINSTANCE.createElseIf()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createPreconditionLoop()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createSeq()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createSwitch()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createCall()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createCase()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.IF__ELSE,
				 Il1Factory.eINSTANCE.createSkip()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == Il1Package.Literals.CODE_CONTAINER__BODY ||
			childFeature == Il1Package.Literals.IF__ELSE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
