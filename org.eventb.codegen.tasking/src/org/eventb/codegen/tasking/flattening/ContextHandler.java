package org.eventb.codegen.tasking.flattening;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eventb.codegen.tasking.CodeGenTasking;
import org.eventb.codegen.tasking.utils.CodeGenTaskingUtils;
import org.eventb.core.IAxiom;
import org.eventb.core.IContextRoot;
import org.eventb.core.IExtendsContext;
import org.eventb.core.ISeesContext;
import org.eventb.core.basis.MachineRoot;
import org.rodinp.core.IRodinFile;

public class ContextHandler {

	public void handle(MachineRoot machineRoot) throws CoreException {
		List<ISeesContext> seesList = Arrays.asList(machineRoot
				.getSeesClauses());

		// for each context in the machine
		for (ISeesContext sees : seesList) {
			IContextRoot contextRoot = sees.getSeenContextRoot();
			// process the context
			processContext(contextRoot);
			IRodinFile rf = contextRoot.getRodinFile();
			rf.save(null, true);
			contextRoot.getResource().refreshLocal(IResource.DEPTH_INFINITE, null);
		}
	}

	// make changes to the context here, and also navigate
	// extended contexts
	private void processContext(IContextRoot contextRoot)
			throws CoreException {

		// for each extended context
		List<IExtendsContext> extendsClauses = Arrays.asList(contextRoot
				.getExtendsClauses());
		for (IExtendsContext e : extendsClauses) {
			IContextRoot extendsRoot = e.getAbstractContextRoot();
			// process the extended context
			processContext(extendsRoot);
		}

		// get the axioms
		List<IAxiom> axiomList = Arrays.asList(contextRoot
				.getChildrenOfType(IAxiom.ELEMENT_TYPE));
		for (IAxiom axiom : axiomList) {
			String axiomString = axiom.getPredicateString();
			// if the axiom is a partition then we assume that it
			// is an enumeration in an implementation, so we type it
			if (axiomString.contains("partition")) {
				axiom.setAttributeValue(CodeGenTasking.TYPING_ATTRIBUTE,
						"Typing", null);
			}
			else if(axiomString.contains(CodeGenTaskingUtils.ELEMENT_OF)){
				axiom.setAttributeValue(CodeGenTasking.TYPING_ATTRIBUTE,
						"Typing", null);
			}
		}
		// Set the tasking type attribute of the context
		contextRoot.setAttributeValue(CodeGenTasking.TASKING_CONTEXT_ATTRIBUTE, "Tasking", null );
		
		
		
		// save the file and refresh the workspace
		IRodinFile rf = contextRoot.getRodinFile();
		rf.save(null, true);
		contextRoot.getResource().refreshLocal(IResource.DEPTH_INFINITE, null);
	}
}
