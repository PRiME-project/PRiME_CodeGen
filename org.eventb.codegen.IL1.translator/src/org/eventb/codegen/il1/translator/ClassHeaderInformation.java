package org.eventb.codegen.il1.translator;

import java.util.ArrayList;

public class ClassHeaderInformation {
	private String className = "";;
	private ArrayList<String> headerEntries = new ArrayList<String>();
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<String> getHeaderEntries() {
		return headerEntries;
	}
	public void setFunctionDeclarations(ArrayList<String> headerEntries_) {
		this.headerEntries = headerEntries_;
	} 
}
