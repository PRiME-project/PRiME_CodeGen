package ac.soton.compositionmodel.persistence.synchroniser;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eventb.core.EventBAttributes;
import org.eventb.core.IEventBProject;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.persistence.synchroniser.AbstractSynchroniser;
import org.rodinp.core.IAttributeType;
import org.rodinp.core.IInternalElementType;
import org.rodinp.core.IRodinElement;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

import ac.soton.composition.core.IComposedMachineRoot;
import ac.soton.composition.core.ISeesContext;
import ac.soton.compositionmodel.core.compositionmodel.ComposedMachine;
import ac.soton.compositionmodel.core.compositionmodel.CompositionmodelFactory;

public class ComposedMachineSynchroniser extends AbstractSynchroniser {

	private static final Set<IAttributeType> handledAttributes = new HashSet<IAttributeType>();


	static {
		handledAttributes.add(EventBAttributes.TARGET_ATTRIBUTE);
	}

	@Override
	protected ComposedMachine createEventBElement() {
		return CompositionmodelFactory.eINSTANCE.createComposedMachine();
	}

	@Override
	protected EStructuralFeature getFeature() {
		return CorePackage.eINSTANCE.getProject_Components();
	}

	@Override
	protected IInternalElementType<?> getRodinType() {
		return IComposedMachineRoot.ELEMENT_TYPE;
	}

	@Override
	protected Set<IAttributeType> getHandledAttributeTypes() {
		return handledAttributes;
	}


	@Override
	public EventBElement load(final IRodinElement rodinElement, final EventBElement emfParent, final IProgressMonitor monitor) throws CoreException {
		// create EMF node for machine

		final ComposedMachine eventBElement = (ComposedMachine) super.load(rodinElement, emfParent, monitor);

		if (rodinElement instanceof IComposedMachineRoot) {
			EList<String> refinesNames = eventBElement.getRefinesNames();
			IComposedMachineRoot machineRoot = (IComposedMachineRoot) rodinElement;

			for (ac.soton.composition.core.IRefinesMachine refinesMachine : machineRoot.getRefinesClauses()) {
				refinesNames.add(refinesMachine.getAbstractMachineName());
			}

			EList<String> seesNames = eventBElement.getSeesNames();
			for (ISeesContext seesContext : machineRoot.getSeesClauses()) {
				seesNames.add(seesContext.getSeenContextName());
			}


	//Does nothing	- as done elsewhere anyway (and probably correctly too)
/*
			EList<Invariant> invariants = eventBElement.getInvariants();
			for (IInvariant invariant : machineRoot.getInvariants())
			{
				InvariantSynchroniser sync = new InvariantSynchroniser();
				Invariant inv = (Invariant)sync.load(invariant, eventBElement, monitor);

				invariants.add(inv);
			}
*/
		}

		return eventBElement;
	}



	@Override
	public IRodinElement save(final EventBElement emfElement, final IRodinElement rodinParent, final IProgressMonitor monitor) throws CoreException {
		// get machine file if synchronised from project
		final IRodinElement parent = rodinParent instanceof IRodinProject ? ((IEventBProject) rodinParent.getAdapter(IEventBProject.class))
				.getMachineFile(((EventBNamed) emfElement).getName()) : rodinParent;

		// create Rodin element
		IRodinElement rodinElement = super.save(emfElement, parent, monitor);
		if (rodinElement instanceof IComposedMachineRoot && emfElement instanceof ComposedMachine) {
			EList<String> refinesNames = ((ComposedMachine) emfElement).getRefinesNames();
			for (String refinesName : refinesNames) {
				ac.soton.composition.core.IRefinesMachine refinesMachine = ((IComposedMachineRoot) rodinElement).getRefinesClause(getNewName());
				refinesMachine.create(null, monitor);
				refinesMachine.setAbstractMachineName(refinesName, monitor);
			}
			EList<String> seesNames = ((ComposedMachine) emfElement).getSeesNames();
			for (String seesName : seesNames) {
				ISeesContext seesContext = ((IComposedMachineRoot) rodinElement).getSeesClause(getNewName());
				seesContext.create(null, monitor);
				seesContext.setSeenContextName(seesName, monitor);
			}
		}

		return rodinElement;
	}


}
