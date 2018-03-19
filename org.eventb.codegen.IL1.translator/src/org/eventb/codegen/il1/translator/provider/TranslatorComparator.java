/**
 * 
 */
package org.eventb.codegen.il1.translator.provider;

import java.util.Comparator;

import org.eventb.core.ast.Formula;

/**
 * @author renatosilva
 *
 */
public class TranslatorComparator implements Comparator<Formula<?>> {

	@Override
	public int compare(Formula<?> o1, Formula<?> o2) {
		StringBuffer sb = new StringBuffer(o2.toString().trim());
//		CharSequence subSequence = sb.subSequence(0, o2.toString().length());
		if(o1.toString().trim().contains(sb)){
			return -1;
		}
		
		sb.replace(0, sb.capacity(), o1.toString().trim());
//		subSequence = sb.subSequence(0, o1.toString().trim().length());;
		if(o2.toString().trim().contains(sb))
			return 1;
		
		if(o1.toString().trim().equals(o2.toString().trim()))
			return 0;
		
		return o1.toString().compareToIgnoreCase(o2.toString());
	}


}
