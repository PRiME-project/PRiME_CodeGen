///**
// * <copyright>
// * </copyright>
// *
// * $Id$
// */
//package compositeControl.provider;
//
//
//import compositeControl.CompositeControlFactory;
//import compositeControl.CompositeControlPackage;
//
//import compositeControl.SynchEvents;
//import java.util.Collection;
//import java.util.List;
//
//import org.eclipse.emf.common.notify.AdapterFactory;
//import org.eclipse.emf.common.notify.Notification;
//
//import org.eclipse.emf.common.util.ResourceLocator;
//
//import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
//import org.eclipse.emf.edit.provider.IChildCreationExtender;
//import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
//import org.eclipse.emf.edit.provider.IItemLabelProvider;
//import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
//import org.eclipse.emf.edit.provider.IItemPropertySource;
//import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
//import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
//import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
//import org.eclipse.emf.edit.provider.ViewerNotification;
//import org.eventb.emf.core.CorePackage;
//import org.eventb.emf.core.provider.EventBElementItemProvider;
//import org.eventb.emf.core.provider.AbstractExtensionItemProvider;
//import org.eclipse.emf.edit.provider.ItemProviderAdapter;
//
///**
// * This is the item provider adapter for a {@link compositeControl.SynchEvents} object.
// * <!-- begin-user-doc -->
// * <!-- end-user-doc -->
// * @generated
// */
//public class SynchEventsItemProvider
//	extends EventBElementItemProvider
//	implements
//		IEditingDomainItemProvider,
//		IStructuredItemContentProvider,
//		ITreeItemContentProvider,
//		IItemLabelProvider,
//		IItemPropertySource {
//	/**
//	 * This constructs an instance from a factory and a notifier.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	public SynchEventsItemProvider(AdapterFactory adapterFactory) {
//		super(adapterFactory);
//	}
//
//	/**
//	 * This returns the property descriptors for the adapted class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
//		if (itemPropertyDescriptors == null) {
//			super.getPropertyDescriptors(object);
//
//			addLocalEventPropertyDescriptor(object);
//			addRemoteEventPropertyDescriptor(object);
//			addLocalEventNamePropertyDescriptor(object);
//			addRemoteEventNamePropertyDescriptor(object);
//		}
//		return itemPropertyDescriptors;
//	}
//
//	/**
//	 * This adds a property descriptor for the Local Event feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addLocalEventPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_SynchEvents_localEvent_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_SynchEvents_localEvent_feature", "_UI_SynchEvents_type"),
//				 CompositeControlPackage.Literals.SYNCH_EVENTS__LOCAL_EVENT,
//				 true,
//				 false,
//				 true,
//				 null,
//				 null,
//				 null));
//	}
//
//	/**
//	 * This adds a property descriptor for the Remote Event feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addRemoteEventPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_SynchEvents_remoteEvent_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_SynchEvents_remoteEvent_feature", "_UI_SynchEvents_type"),
//				 CompositeControlPackage.Literals.SYNCH_EVENTS__REMOTE_EVENT,
//				 true,
//				 false,
//				 true,
//				 null,
//				 null,
//				 null));
//	}
//
//	/**
//	 * This adds a property descriptor for the Local Event Name feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addLocalEventNamePropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_SynchEvents_localEventName_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_SynchEvents_localEventName_feature", "_UI_SynchEvents_type"),
//				 CompositeControlPackage.Literals.SYNCH_EVENTS__LOCAL_EVENT_NAME,
//				 true,
//				 false,
//				 false,
//				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
//				 null,
//				 null));
//	}
//
//	/**
//	 * This adds a property descriptor for the Remote Event Name feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addRemoteEventNamePropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_SynchEvents_remoteEventName_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_SynchEvents_remoteEventName_feature", "_UI_SynchEvents_type"),
//				 CompositeControlPackage.Literals.SYNCH_EVENTS__REMOTE_EVENT_NAME,
//				 true,
//				 false,
//				 false,
//				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
//				 null,
//				 null));
//	}
//
//	/**
//	 * This returns SynchEvents.gif.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public Object getImage(Object object) {
//		return overlayImage(object, getResourceLocator().getImage("full/obj16/SynchEvents"));
//	}
//
//	/**
//	 * This returns the label text for the adapted class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public String getText(Object object) {
//		String label = ((SynchEvents)object).getLocalEventName();
//		return label == null || label.length() == 0 ?
//			getString("_UI_SynchEvents_type") :
//			getString("_UI_SynchEvents_type") + " " + label;
//	}
//
//	/**
//	 * This handles model notifications by calling {@link #updateChildren} to update any cached
//	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public void notifyChanged(Notification notification) {
//		updateChildren(notification);
//
//		switch (notification.getFeatureID(SynchEvents.class)) {
//			case CompositeControlPackage.SYNCH_EVENTS__LOCAL_EVENT_NAME:
//			case CompositeControlPackage.SYNCH_EVENTS__REMOTE_EVENT_NAME:
//				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
//				return;
//		}
//		super.notifyChanged(notification);
//	}
//
//	/**
//	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
//	 * that can be created under this object.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
//		super.collectNewChildDescriptors(newChildDescriptors, object);
//
///*
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createSeq()));
//
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createDo()));
//
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createBranch()));
//
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createSubBranch()));
//
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createEventWrapper()));
//
//		newChildDescriptors.add
//			(createChildParameter
//				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
//				 CompositeControlFactory.eINSTANCE.createOutput()));
//*/				 
//	}
//
//}
