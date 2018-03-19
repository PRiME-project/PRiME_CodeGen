/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tasking;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Implementation Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see tasking.TaskingPackage#getImplementationTypeEnum()
 * @model
 * @generated
 */
public enum ImplementationTypeEnum implements Enumerator {
	/**
	 * The '<em><b>Procedure Def</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE_DEF_VALUE
	 * @generated
	 * @ordered
	 */
	PROCEDURE_DEF(1, "ProcedureDef", "ProcedureDef"),

	/**
	 * The '<em><b>Procedure Synch</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE_SYNCH_VALUE
	 * @generated
	 * @ordered
	 */
	PROCEDURE_SYNCH(2, "ProcedureSynch", "ProcedureSynch"),

	/**
	 * The '<em><b>Loop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOOP_VALUE
	 * @generated
	 * @ordered
	 */
	LOOP(3, "Loop", "Loop"),

	/**
	 * The '<em><b>Branch</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRANCH_VALUE
	 * @generated
	 * @ordered
	 */
	BRANCH(4, "Branch", "Branch"), /**
	 * The '<em><b>Sensing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SENSING_VALUE
	 * @generated
	 * @ordered
	 */
	SENSING(5, "Sensing", "Sensing"), /**
	 * The '<em><b>Actuating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTUATING_VALUE
	 * @generated
	 * @ordered
	 */
	ACTUATING(6, "Actuating", "Actuating");

	/**
	 * The '<em><b>Procedure Def</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Procedure Def</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE_DEF
	 * @model name="ProcedureDef"
	 * @generated
	 * @ordered
	 */
	public static final int PROCEDURE_DEF_VALUE = 1;

	/**
	 * The '<em><b>Procedure Synch</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Procedure Synch</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROCEDURE_SYNCH
	 * @model name="ProcedureSynch"
	 * @generated
	 * @ordered
	 */
	public static final int PROCEDURE_SYNCH_VALUE = 2;

	/**
	 * The '<em><b>Loop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Loop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOOP
	 * @model name="Loop"
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_VALUE = 3;

	/**
	 * The '<em><b>Branch</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Branch</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRANCH
	 * @model name="Branch"
	 * @generated
	 * @ordered
	 */
	public static final int BRANCH_VALUE = 4;

	/**
	 * The '<em><b>Sensing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sensing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SENSING
	 * @model name="Sensing"
	 * @generated
	 * @ordered
	 */
	public static final int SENSING_VALUE = 5;

	/**
	 * The '<em><b>Actuating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Actuating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTUATING
	 * @model name="Actuating"
	 * @generated
	 * @ordered
	 */
	public static final int ACTUATING_VALUE = 6;

	/**
	 * An array of all the '<em><b>Implementation Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImplementationTypeEnum[] VALUES_ARRAY =
		new ImplementationTypeEnum[] {
			PROCEDURE_DEF,
			PROCEDURE_SYNCH,
			LOOP,
			BRANCH,
			SENSING,
			ACTUATING,
		};

	/**
	 * A public read-only list of all the '<em><b>Implementation Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImplementationTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Implementation Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImplementationTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Implementation Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImplementationTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Implementation Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationTypeEnum get(int value) {
		switch (value) {
			case PROCEDURE_DEF_VALUE: return PROCEDURE_DEF;
			case PROCEDURE_SYNCH_VALUE: return PROCEDURE_SYNCH;
			case LOOP_VALUE: return LOOP;
			case BRANCH_VALUE: return BRANCH;
			case SENSING_VALUE: return SENSING;
			case ACTUATING_VALUE: return ACTUATING;
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
	private ImplementationTypeEnum(int value, String name, String literal) {
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
	
} //ImplementationTypeEnum
