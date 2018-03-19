/*******************************************************************************
 * Copyright (c) 2006,2007,2008 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eventb.codegen.roseExtension;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.swt.widgets.Text;

/**
 * An abstract implementation of a section for a field with a String property
 * value.
 *
 */

public abstract class AbstractTaskBodyStringPropertySection extends AbstractTaskBodyPropertySection {

	@Override
	protected boolean isCurrent(final String newText) {
		return getFeatureAsText().equals(newText);
	}

	@Override
	protected String getFeatureAsText() {
		Object feature = null;
		if (getFeature() instanceof EAttribute){
			feature = owner.eGet(getFeature());
			if (feature instanceof String) {
				return (String)feature;
			}else if (feature==null){
				return "";
			}
		}
		return "ERROR - feature not string";
	}

	@Override
	protected Object getFeatureValue(final String newText) {
		return newText;
	}
	
	protected Text getTextWidget() {
		return (Text)widget;
	}
}