package edu.hm.cs.team8;

import java.util.Set;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		// final IMasterData masterdata = new MasterDataImpl();

		final ITimeTrackingMangement timetrackingManagment = new TimeTrackingManagmentImpl();

		// print(masterdata.getMemberDAO().getMembers());
		// print(masterdata.getBusinessAreaDAO().getBusinessAreas());
		// print(masterdata.getProjectDAO().getProjects());
		// print(masterdata.getAccountDAO().getAccounts());
		//
		// print(timetrackingManagment.getTimeTrackingDAO().getTimeTrackings());
		print(timetrackingManagment.getTimeTrackingDAO().findTimeTrackingsByMember("Max Mustermann"));

		IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();
		System.out.println(calc.calculateFigures());

	}

	public static void print(Set<?> entries) {
		for (Object entry : entries) {
			System.out.println(entry);
			System.out.println("------");
		}

	}
}
