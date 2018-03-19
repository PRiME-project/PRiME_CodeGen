/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package compositeControl.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.provider.AbstractExtensionItemProvider;

import compositeControl.CompositeControl;
import compositeControl.CompositeControlFactory;
import compositeControl.CompositeControlPackage;

/**
 * This is the item provider adapter for a {@link compositeControl.CompositeControl} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeControlItemProvider
	extends AbstractExtensionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeControlItemProvider(AdapterFactory adapterFactory) {
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

			addEnvirStateMachineChildPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Envir State Machine Child feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnvirStateMachineChildPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompositeControl_envirStateMachineChild_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompositeControl_envirStateMachineChild_feature", "_UI_CompositeControl_type"),
				 CompositeControlPackage.Literals.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CompositeControl)object).getReference();
		return label == null || label.length() == 0 ?
			getString("_UI_CompositeControl_type") :
			getString("_UI_CompositeControl_type") + " " + label;
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

		switch (notification.getFeatureID(CompositeControl.class)) {
			case CompositeControlPackage.COMPOSITE_CONTROL__ENVIR_STATE_MACHINE_CHILD:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

	/* 
	 *	Bad EMF. Adding these will allow any of these elements to be added to any other 
	 *	element in this metamodel.
	 *
	 *
		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createSeq()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createDo()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createBranch()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createSubBranch()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createEventWrapper()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createSynchEvents()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 CompositeControlFactory.eINSTANCE.createOutput()));
				 
*/				 
	}

}
