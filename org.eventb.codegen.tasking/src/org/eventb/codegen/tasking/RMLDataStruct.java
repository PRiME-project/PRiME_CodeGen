package org.eventb.codegen.tasking;

import java.util.ArrayList;
import java.util.Map;

import org.eventb.emf.core.context.impl.ContextImpl;

import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;

public class RMLDataStruct
{
	public Object [] machineArray;
	public ArrayList<ComposedMachine> composedMachineList;
	public Map<String, String> composedEventMap;
	public ArrayList<String> composedMachineNameList;
	public ArrayList<ContextImpl> contextList;
	public Map<String, String> contextContainerMap;
}