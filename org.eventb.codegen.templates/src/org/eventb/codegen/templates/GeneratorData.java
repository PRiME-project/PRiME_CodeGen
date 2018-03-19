package org.eventb.codegen.templates;

import java.util.ArrayList;
import java.util.List;

// A Generator Data Object:
// This is a class holding information to be used for translation.
// The class can be extended to add fields for holding un-packed data.
// For example, in FMU translation the translation manager will usually 
// be needed, so we add a field for it. 
// The data list is more dynamic, and will contain different objects
// depending on the translation being undertaken.
public class GeneratorData implements IGeneratorData {
	
	private List<Object> dataList = new ArrayList<Object>();
	
	public List<Object> getDataList() {
		return dataList;
	}

}
