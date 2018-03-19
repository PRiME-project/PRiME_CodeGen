package org.eventb.codegen.templates;

import java.util.List;

// Implementers of this interface will contain data that 
// will be used to enable translation. The getDataList method
// is used to obtain a list of objects. That is all we know
// about the data at this stage, since any data type may be 
// required to facilitate the translation. Packing and unpacking
// from the list is the responsibility of the implementor.
public interface IGeneratorData {

	public List<Object> getDataList();
	
	
}