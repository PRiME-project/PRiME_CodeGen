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
import org.eventb.emf.core.CorePackage;

import tasking.Task;
import tasking.TaskingFactory;
import tasking.TaskingPackage;

import compositeControl.CompositeControlFactory;

/**
 * This is the item provider adapter for a {@link tasking.Task} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TaskItemProvider
	extends AbstractExtensionTaskingElementItemProvider
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

			addPriorityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 TaskingPackage.Literals.TASK__PRIORITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(TaskingPackage.Literals.TASK__TASK_TYPE);
			childrenFeatures.add(TaskingPackage.Literals.TASK__TASK_BODY);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Task)object).getReference();
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
			case TaskingPackage.TASK__PRIORITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TaskingPackage.TASK__TASK_TYPE:
			case TaskingPackage.TASK__TASK_BODY:
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
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

/*		
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

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_TYPE,
				 TaskingFactory.eINSTANCE.createSimpleTaskType()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_TYPE,
				 TaskingFactory.eINSTANCE.createPeriodicTaskType()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createSeq()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createDo()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createBranch()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createSubBranch()));
		
		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createEventWrapper()));

		newChildDescriptors.add
			(createChildParameter
				(TaskingPackage.Literals.TASK__TASK_BODY,
				 CompositeControlFactory.eINSTANCE.createOutput()));
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
			childFeature == CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS ||
			childFeature == TaskingPackage.Literals.TASK__TASK_BODY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
