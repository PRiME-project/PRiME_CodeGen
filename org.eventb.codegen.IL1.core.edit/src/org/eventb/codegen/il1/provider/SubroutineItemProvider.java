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
import org.eventb.codegen.il1.Subroutine;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;

/**
 * This is the item provider adapter for a {@link org.eventb.codegen.il1.Subroutine} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubroutineItemProvider
	extends CodeContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubroutineItemProvider(AdapterFactory adapterFactory) {
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
			addTemporaryPropertyDescriptor(object);
			addMachineNamePropertyDescriptor(object);
			addProjectNamePropertyDescriptor(object);
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
	 * This adds a property descriptor for the Temporary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemporaryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SubroutineMetaData_temporary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SubroutineMetaData_temporary_feature", "_UI_SubroutineMetaData_type"),
				 RequiredMetadataPackage.Literals.SUBROUTINE_META_DATA__TEMPORARY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_Subroutine_machineName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subroutine_machineName_feature", "_UI_Subroutine_type"),
				 Il1Package.Literals.SUBROUTINE__MACHINE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_Subroutine_projectName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Subroutine_projectName_feature", "_UI_Subroutine_type"),
				 Il1Package.Literals.SUBROUTINE__PROJECT_NAME,
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
			childrenFeatures.add(Il1Package.Literals.SUBROUTINE__FORMAL_PARAMETERS);
			childrenFeatures.add(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS);
			childrenFeatures.add(Il1Package.Literals.SUBROUTINE__GUARDS);
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
	 * This returns Subroutine.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Subroutine"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Subroutine)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Subroutine_type") :
			getString("_UI_Subroutine_type") + " " + label;
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

		switch (notification.getFeatureID(Subroutine.class)) {
			case Il1Package.SUBROUTINE__NAME:
			case Il1Package.SUBROUTINE__TEMPORARY:
			case Il1Package.SUBROUTINE__MACHINE_NAME:
			case Il1Package.SUBROUTINE__PROJECT_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Il1Package.SUBROUTINE__FORMAL_PARAMETERS:
			case Il1Package.SUBROUTINE__LOCAL_DECLARATIONS:
			case Il1Package.SUBROUTINE__GUARDS:
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
				(Il1Package.Literals.SUBROUTINE__FORMAL_PARAMETERS,
				 Il1Factory.eINSTANCE.createInParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__FORMAL_PARAMETERS,
				 Il1Factory.eINSTANCE.createOutParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__FORMAL_PARAMETERS,
				 Il1Factory.eINSTANCE.createLocalVariable()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createVariableDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createConstantDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createFormalParamDecl()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createInParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createOutParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createLocalVariable()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS,
				 Il1Factory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(Il1Package.Literals.SUBROUTINE__GUARDS,
				 ""));
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
			childFeature == Il1Package.Literals.SUBROUTINE__FORMAL_PARAMETERS ||
			childFeature == Il1Package.Literals.SUBROUTINE__LOCAL_DECLARATIONS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
