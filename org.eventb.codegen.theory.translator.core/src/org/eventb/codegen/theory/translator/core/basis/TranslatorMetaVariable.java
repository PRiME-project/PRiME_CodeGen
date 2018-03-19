/**
 * 
 */
package org.eventb.codegen.theory.translator.core.basis;

import org.rodinp.core.IInternalElement;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.basis.InternalElement;

/**
 * @author renatosilva
 *
 */
public class TranslatorMetaVariable extends InternalElement {

	/**
	 * @param name
	 * @param parent
	 */
	public TranslatorMetaVariable(String name, IRodinElement parent) {
		super(name, parent);
	}

	/* (non-Javadoc)
	 * @see org.rodinp.core.basis.InternalElement#getElementType()
	 */
	@Override
	public IInternalElementType<? extends IInternalElement> getElementType() {
		return null;
	}

}
