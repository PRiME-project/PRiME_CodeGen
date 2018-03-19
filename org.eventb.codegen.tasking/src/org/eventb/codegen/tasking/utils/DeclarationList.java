package org.eventb.codegen.tasking.utils;

import java.util.ArrayList;

import org.eventb.codegen.il1.Declaration;
import org.eventb.codegen.il1.impl.IL1ElementImpl;


public class DeclarationList extends IL1ElementImpl {
	private ArrayList<Declaration> declarations = new ArrayList<Declaration>();
	
	public void addDeclaration(Declaration d)
	{
		declarations.add(d);
	}
	
	public void removeDeclaration(Declaration d)
	{
		declarations.remove(d);
	}
	
	public ArrayList<Declaration> getDeclarations()
	{
		return declarations;
	}
}
