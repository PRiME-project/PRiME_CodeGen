/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.compositionmodel.core.compositionmodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.provider.EventBNamedCommentedComponentElementItemProvider;

import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelPackage;

/**
 * This is the item provider adapter for a {@link ac.soton.compositionmodel.core.compositionmodel.ComposedMachine} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComposedMachineItemProvider
	extends EventBNamedCommentedComponentElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedMachineItemProvider(AdapterFactory adapterFactory) {
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

			addSeesPropertyDescriptor(object);
			addRefinesPropertyDescriptor(object);
			addComposesEventsPropertyDescriptor(object);
			addRefinesNamesPropertyDescriptor(object);
			addSeesNamesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Sees feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComposedMachine_sees_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComposedMachine_sees_feature", "_UI_ComposedMachine_type"),
				 CompositionmodelPackage.eINSTANCE.getComposedMachine_Sees(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Refines feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComposedMachine_refines_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComposedMachine_refines_feature", "_UI_ComposedMachine_type"),
				 CompositionmodelPackage.eINSTANCE.getComposedMachine_Refines(),
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composes Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComposesEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComposedMachine_composesEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComposedMachine_composesEvents_feature", "_UI_ComposedMachine_type"),
				 CompositionmodelPackage.eINSTANCE.getComposedMachine_ComposesEvents(),
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Refines Names feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefinesNamesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComposedMachine_refinesNames_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComposedMachine_refinesNames_feature", "_UI_ComposedMachine_type"),
				 CompositionmodelPackage.eINSTANCE.getComposedMachine_RefinesNames(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sees Names feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeesNamesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ComposedMachine_seesNames_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ComposedMachine_seesNames_feature", "_UI_ComposedMachine_type"),
				 CompositionmodelPackage.eINSTANCE.getComposedMachine_SeesNames(),
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
			childrenFeatures.add(CompositionmodelPackage.eINSTANCE.getComposedMachine_Invariants());
			childrenFeatures.add(CompositionmodelPackage.eINSTANCE.getComposedMachine_Includes());
			childrenFeatures.add(CompositionmodelPackage.eINSTANCE.getComposedMachine_ComposesEvents());
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
	 * This returns ComposedMachine.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ComposedMachine"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ComposedMachine)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ComposedMachine_type") :
			getString("_UI_ComposedMachine_type") + " " + label;
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

		switch (notification.getFeatureID(ComposedMachine.class)) {
			case CompositionmodelPackage.COMPOSED_MACHINE__REFINES_NAMES:
			case CompositionmodelPackage.COMPOSED_MACHINE__SEES_NAMES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CompositionmodelPackage.COMPOSED_MACHINE__INVARIANTS:
			case CompositionmodelPackage.COMPOSED_MACHINE__INCLUDES:
			case CompositionmodelPackage.COMPOSED_MACHINE__COMPOSES_EVENTS:
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
				(CompositionmodelPackage.eINSTANCE.getComposedMachine_Invariants(),
				 MachineFactory.eINSTANCE.createInvariant()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionmodelPackage.eINSTANCE.getComposedMachine_Includes(),
				 CompositionmodelFactory.eINSTANCE.createIncludedMachine()));

		newChildDescriptors.add
			(createChildParameter
				(CompositionmodelPackage.eINSTANCE.getComposedMachine_ComposesEvents(),
				 CompositionmodelFactory.eINSTANCE.createComposedEvent()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CompositionmodelcoreEditPlugin.INSTANCE;
	}

}
