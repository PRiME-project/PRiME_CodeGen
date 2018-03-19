package org.eventb.tasking.persistence;

import org.rodinp.core.RodinDBException;

public interface ITask  extends IMachineType{
	
	//public static IAttributeType.Integer PRIORITY_ATTRIBUTE = RodinCore.getIntegerAttrType(TaskingPersistencePlugin.PLUGIN_ID + ".priority");
	
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @throws RodinDBException 
	 * @see #setPriority(int)
	 * @see tasking.TaskingPackage#getTask_Priority()
	 * @model default="5"
	 */
	int getPriority() throws RodinDBException;

	/**
	 * Sets the value of the '{@link tasking.Task#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @throws RodinDBException 
	 * @see #getPriority()
	 */
	void setPriority(int value) throws RodinDBException;
	
}
