package org.eventb.codegen.tasking.translation.eventb;

import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ASSIGNMENT_SYMBOL;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.ELEMENT_OF;
import static org.eventb.codegen.tasking.utils.CodeGenTaskingUtils.OR_SYMBOL;

import java.util.ArrayList;

import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.impl.MachineFactoryImpl;
import org.eventb.emf.core.machine.impl.MachineImpl;

public class EventBTranslatorHelpers {

	/**
	 * Adds the variable, invariant and initialisation. Default, sets invariant to be false.
	 * @param name
	 * @param machine
	 */
	public static void addNewProgramCounter(String name, MachineImpl machine)
	{
		addNewProgramCounter(name,machine,"FALSE");
	}

	public static void addNewProgramCounter(String name, MachineImpl machine, String invariantInitialiser)
	{
		Action action = MachineFactoryImpl.eINSTANCE.createAction();
		action.setGenerated(true);
		action.setName("PCInit" + name);
		action.setAction(name + ASSIGNMENT_SYMBOL + invariantInitialiser);

		Event initialisation = null;
		for (Event e : machine.getEvents())
		{
			if (e.getName().equals("INITIALISATION"))
			{
				initialisation = e;
			}
		}

		if (initialisation != null)
		{
			initialisation.getActions().add(action);
		}

		Invariant iv = MachineFactoryImpl.eINSTANCE.createInvariant();
		iv.setGenerated(true);
		iv.setName("PCInvar" + name);
		iv.setPredicate(name + " "+ELEMENT_OF+" " + "BOOL");
		machine.getInvariants().add(iv);

		Variable v = MachineFactoryImpl.eINSTANCE.createVariable();
		v.setGenerated(true);
		v.setName(name);
		machine.getVariables().add(v);
	}

	public static void addNewGuard(Event e, String name)
	{
		Guard g = MachineFactoryImpl.eINSTANCE.createGuard();
		g.setGenerated(true);
		g.setName("PCGrd" + name);

		if (isCombinedWaitGuard(name))
		{
			String [] names = splitWaitGuards(name);

			String combinedGuard = names[0] + " = TRUE";
			for (int i = 1; i < names.length; i++)
			{
				combinedGuard += " "+OR_SYMBOL+" " + names[i] + " = TRUE";
			}

			g.setPredicate(combinedGuard);
		}
		else
		{
			g.setPredicate(name + " = TRUE");
		}

		e.getGuards().add(g);
	}

	/**
	 * Adds an action that will set the PC to be enabled
	 * @param e
	 * @param name This can be a combined set of program counters, built from combineWaitGuard
	 */
	public static void enableProgramCounter(Event e, String name)
	{
		String [] names = splitWaitGuards(name);

		for (String s : names)
		{
			enableProgramCounterSingle(e, s);
		}
	}

	private static void enableProgramCounterSingle(Event e, String name)
	{
		Action action = MachineFactoryImpl.eINSTANCE.createAction();
		action.setGenerated(true);
		action.setName("PCAct" + name);
		action.setAction(name + " "+ASSIGNMENT_SYMBOL+ " " + "TRUE");
		e.getActions().add(action);
	}

	/**
	 * Adds an action that will set the PC to be disabled
	 * @param e
	 * @param name This can be a combined set of program counters, built from combineWaitGuard
	 */
	public static void disableProgramCounter(Event e, String name)
	{
		String [] names = splitWaitGuards(name);

		for (String s : names)
		{
			disableProgramCounterSingle(e, s);
		}
	}

	private static void disableProgramCounterSingle(Event e, String name)
	{
		Action action = MachineFactoryImpl.eINSTANCE.createAction();
		action.setGenerated(true);
		action.setName("PCAct" + name);
		action.setAction(name + ASSIGNMENT_SYMBOL + "FALSE");
		e.getActions().add(action);
	}

	public static String combineWaitGuard(String g1, String g2)
	{
		if (g1 == null && g2 == null)
			return "";
		else if (g1 == null)
			return g2;
		else if (g2 == null)
			return g1;
		else
			return g1 + ":" + g2;
	}

	public static String combineWaitGuard(String g1, String g2, String g3)
	{
		return combineWaitGuard(g1, combineWaitGuard(g2,g3));
	}

	public static boolean isCombinedWaitGuard(String g)
	{
		return g.contains(":");
	}

	public static String [] splitWaitGuards(String g)
	{
		return g.split(":");
	}

	public static void replaceWithInitTrue(String finalWaitGuard, String init, Machine machine)
	{
//		if (isCombinedWaitGuard(finalWaitGuard))
//		{
//			String [] waitGuards = splitWaitGuards(finalWaitGuard);
//			for (String wg : waitGuards)
//			{
//				replaceWithInitTrueSingle(wg, init, machine);
//			}
//		}

		replaceWithInitTrueSingle(finalWaitGuard, init, machine);
	}



	private static void replaceWithInitTrueSingle(String finalWaitGuard, String init, Machine machine)
	{
		//	Removes the program counter associated with this wait guard
		//	Updates the event this wait guard is set to true in, and replaces it with init:=true

		//	Get the events that set this guard to be true
		ArrayList<Event> events = getEventsWithActionPC(finalWaitGuard,machine);
		for (Event e : events)
		{
			if (!e.getName().equals("INITIALISATION"))
			{
				//	Check to see if init is already here
				Action initAOld = getAssignmentAction("init", e);
				if (initAOld != null)
					e.getActions().remove(initAOld);

				//	Update the wait action
				Action a = getAssignmentAction(finalWaitGuard, e);
				a.setAction(init + " "+ ASSIGNMENT_SYMBOL +" " + "TRUE");
			}
		}

		//	Get the initialisation event and remove it for the given wait guard
		Event iE = getEvent("INITIALISATION", machine);
		Action a2 = getAssignmentAction(finalWaitGuard, iE);
		iE.getActions().remove(a2);

		//	Get the invariant for the wait guard and remove it
		Invariant i = getWaitGuardInvariant(finalWaitGuard, machine);
		machine.getInvariants().remove(i);

		//	Get the variable for the wait guard and remove it
		Variable v = getWaitGuardVariable(finalWaitGuard, machine);
		machine.getVariables().remove(v);
	}

	private static Variable getWaitGuardVariable(String waitGuard, Machine machine) {

		for (Variable v : machine.getVariables())
		{
			String vName = v.getName().trim();

			if (v.isGenerated() && vName.equals(waitGuard))
			{
				return v;
			}
		}

		return null;
	}

	private static Event getEvent(String eventName, Machine machine)
	{
		for (Event e : machine.getEvents())
		{
			if (e.getName().equals(eventName))
				return e;
		}

		return null;
	}

	private static ArrayList<Event> getEventsWithActionPC(String finalWaitGuard, Machine machine)
	{
		ArrayList<Event> events = new ArrayList<Event>();

		for (Event e : machine.getEvents())
		{
			for (Action a : e.getActions())
			{
				String actionString = a.getAction().trim();
				if (actionString.startsWith(finalWaitGuard + " ") || actionString.startsWith(finalWaitGuard + ASSIGNMENT_SYMBOL))
				{
					events.add(e);
				}
			}
		}

		return events;
	}

	private static Action getAssignmentAction(String lhsAssignment, Event e)
	{
		for (Action a : e.getActions())
		{
			String[] act = a.getAction().split(ASSIGNMENT_SYMBOL);
			if (act.length == 2)
			{
				if (a.isGenerated() && act[0].trim().equals(lhsAssignment))
				{
					return a;
				}
			}
		}

		return null;
	}

	private static Invariant getWaitGuardInvariant(String waitGuard, Machine machine)
	{
		for (Invariant i : machine.getInvariants())
		{
			String [] inv = i.getPredicate().split(ELEMENT_OF);

			if (inv.length == 2)
			{
				if (i.isGenerated() && inv[0].trim().equals(waitGuard))
				{
					return i;
				}
			}
		}

		return null;
	}



//	public static String convertToOrGuard(String g)
//	{
//
//	}
}
