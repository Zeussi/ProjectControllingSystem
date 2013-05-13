package edu.hm.cs.team8;

import java.util.Set;

import org.skife.jdbi.v2.DBI;

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
		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "", "");

		print(timetrackingManagment.getTimeTrackingDAO(dbi.open()).findTimeTrackingsByMember(100));

		IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();

		print(calc.calculateFigures(timetrackingManagment.getTimeTrackingDAO(dbi.open())));

	}

	public static void print(Set<?> entries) {
		for (Object entry : entries) {
			System.out.println(entry);
			System.out.println("------");
		}

	}
}
