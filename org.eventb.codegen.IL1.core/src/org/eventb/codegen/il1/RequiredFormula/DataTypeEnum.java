/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eventb.codegen.il1.RequiredFormula;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eventb.codegen.il1.RequiredFormula.RequiredFormulaPackage#getDataTypeEnum()
 * @model
 * @generated
 */
public enum DataTypeEnum implements Enumerator {
	/**
	 * The '<em><b>User Specified Data Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_SPECIFIED_DATA_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	USER_SPECIFIED_DATA_TYPE(0, "UserSpecifiedDataType", "UserSpecifiedDataType"),

	/**
	 * The '<em><b>Boolean Data Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_DATA_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN_DATA_TYPE(1, "BooleanDataType", "BooleanDataType"),

	/**
	 * The '<em><b>Integer Data Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_DATA_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER_DATA_TYPE(2, "IntegerDataType", "IntegerDataType");

	/**
	 * The '<em><b>User Specified Data Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>User Specified Data Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_SPECIFIED_DATA_TYPE
	 * @model name="UserSpecifiedDataType"
	 * @generated
	 * @ordered
	 */
	public static final int USER_SPECIFIED_DATA_TYPE_VALUE = 0;

	/**
	 * The '<em><b>Boolean Data Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean Data Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_DATA_TYPE
	 * @model name="BooleanDataType"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_DATA_TYPE_VALUE = 1;

	/**
	 * The '<em><b>Integer Data Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integer Data Type</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGER_DATA_TYPE
	 * @model name="IntegerDataType"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_DATA_TYPE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Data Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataTypeEnum[] VALUES_ARRAY =
		new DataTypeEnum[] {
			USER_SPECIFIED_DATA_TYPE,
			BOOLEAN_DATA_TYPE,
			INTEGER_DATA_TYPE,
		};

	/**
	 * A public read-only list of all the '<em><b>Data Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DataTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Data Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataTypeEnum get(int value) {
		switch (value) {
			case USER_SPECIFIED_DATA_TYPE_VALUE: return USER_SPECIFIED_DATA_TYPE;
			case BOOLEAN_DATA_TYPE_VALUE: return BOOLEAN_DATA_TYPE;
			case INTEGER_DATA_TYPE_VALUE: return INTEGER_DATA_TYPE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DataTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DataTypeEnum
