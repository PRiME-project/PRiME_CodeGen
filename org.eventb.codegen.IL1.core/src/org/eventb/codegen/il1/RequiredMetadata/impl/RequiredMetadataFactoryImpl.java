/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredMetadata.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eventb.codegen.il1.RequiredMetadata.*;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataFactory;
import org.eventb.codegen.il1.RequiredMetadata.RequiredMetadataPackage;
import org.eventb.codegen.il1.RequiredMetadata.SubroutineMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredMetadataFactoryImpl extends EFactoryImpl implements RequiredMetadataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequiredMetadataFactory init() {
		try {
			RequiredMetadataFactory theRequiredMetadataFactory = (RequiredMetadataFactory)EPackage.Registry.INSTANCE.getEFactory(RequiredMetadataPackage.eNS_URI);
			if (theRequiredMetadataFactory != null) {
				return theRequiredMetadataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequiredMetadataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredMetadataFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RequiredMetadataPackage.SUBROUTINE_META_DATA: return createSubroutineMetaData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubroutineMetaData createSubroutineMetaData() {
		SubroutineMetaDataImpl subroutineMetaData = new SubroutineMetaDataImpl();
		return subroutineMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredMetadataPackage getRequiredMetadataPackage() {
		return (RequiredMetadataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequiredMetadataPackage getPackage() {
		return RequiredMetadataPackage.eINSTANCE;
	}

} //RequiredMetadataFactoryImpl
