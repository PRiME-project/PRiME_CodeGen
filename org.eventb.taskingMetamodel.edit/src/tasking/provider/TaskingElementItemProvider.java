/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.provider.EventBElementItemProvider;

import tasking.TaskingElement;
import tasking.TaskingFactory;

import compositeControl.CompositeControlFactory;

/**
 * This is the item provider adapter for a {@link tasking.TaskingElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskingElementItemProvider
	extends EventBElementItemProvider
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
	public TaskingElementItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TaskingElement)object).getReference();
		return label == null || label.length() == 0 ?
			getString("_UI_TaskingElement_type") :
			getString("_UI_TaskingElement_type") + " " + label;
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
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createAutoTask_Machine()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createTasking_Machine()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createEnviron_Machine()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createFMU_Machine()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createShared_Machine()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createImplementation()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createParameterType()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createAddressedVariable()));

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 TaskingFactory.eINSTANCE.createTyping()));

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
				 CompositeControlFactory.eINSTANCE.createOutput()));
	}

}
