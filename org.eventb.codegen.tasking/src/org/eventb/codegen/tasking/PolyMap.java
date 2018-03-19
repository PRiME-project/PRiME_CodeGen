package org.eventb.codegen.tasking;

import java.util.ArrayList;

/**
 * 
 * @author Chris
 * 
 * Mapping class to test problem with inheritance checks failing.
 * Class not used.
 * 
 *
 * @param <A>
 * @param <B>
 * @deprecated
 */
public class PolyMap<A,B> {
	
	protected ArrayList<Mapping<A,B>> maps = new ArrayList<Mapping<A,B>>();
	
	protected class Mapping<A,B>
	{
		public A a;
		public B b;
		
		Mapping(A a,B b)
		{
			this.a = a;
			this.b = b;
		}
	}
	
	public PolyMap()
	{
		
	}
	
	public void add(A a, B b)
	{
		maps.add(new Mapping<A,B>(a,b));
	}
	
	public B get(A element)
	{
		for (Mapping<A,B> m : maps)
		{
			Class c = ((Object)m.a).getClass();
			if (element.getClass().isInstance(c))
			{
				return m.b;
			}
			else if (c.isInstance(element))
			{
				return m.b;
			}
		}
		
		return null;
	}
}
