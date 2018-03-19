/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eventb.codegen.il1.RequiredFormula.*;
import org.eventb.codegen.il1.RequiredFormula.AddressedDeclaration;
import org.eventb.codegen.il1.RequiredFormula.DataTypeEnum;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaFactory;
import org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredFormulaFactoryImpl extends EFactoryImpl implements RequiredFormulaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequiredFormulaFactory init() {
		try {
			RequiredFormulaFactory theRequiredFormulaFactory = (RequiredFormulaFactory)EPackage.Registry.INSTANCE.getEFactory(RequiredFormulaPackage.eNS_URI);
			if (theRequiredFormulaFactory != null) {
				return theRequiredFormulaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequiredFormulaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredFormulaFactoryImpl() {
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
			case RequiredFormulaPackage.ADDRESSED_DECLARATION: return createAddressedDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RequiredFormulaPackage.DATA_TYPE_ENUM:
				return createDataTypeEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RequiredFormulaPackage.DATA_TYPE_ENUM:
				return convertDataTypeEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressedDeclaration createAddressedDeclaration() {
		AddressedDeclarationImpl addressedDeclaration = new AddressedDeclarationImpl();
		return addressedDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeEnum createDataTypeEnumFromString(EDataType eDataType, String initialValue) {
		DataTypeEnum result = DataTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredFormulaPackage getRequiredFormulaPackage() {
		return (RequiredFormulaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequiredFormulaPackage getPackage() {
		return RequiredFormulaPackage.eINSTANCE;
	}

} //RequiredFormulaFactoryImpl
