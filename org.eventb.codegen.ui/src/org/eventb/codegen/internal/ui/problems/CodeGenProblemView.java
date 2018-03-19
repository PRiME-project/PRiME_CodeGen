/**
 * 
 */
package org.eventb.codegen.internal.ui.problems;

import org.eclipse.ui.views.markers.MarkerSupportView;

/**
 * @author renatosilva
 *
 */
public class CodeGenProblemView extends MarkerSupportView {

	private final static String contentGeneratorId = "org.eventb.codegen.CodeGenMarkerGenerator";
	
	public CodeGenProblemView() {
		super(contentGeneratorId);
	}

}
