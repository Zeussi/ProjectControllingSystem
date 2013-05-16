package edu.hm.cs.team8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.Option;
import edu.hm.cs.team8.filter.impl.memberfilter.MemberFilter;
import edu.hm.cs.team8.filter.impl.timefilter.TimeEntry;
import edu.hm.cs.team8.filter.impl.timefilter.TimeFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		// final IMasterData masterdata = new MasterDataImpl();

		final ITimeTrackingMangement timetrackingManagment = new TimeTrackingManagmentImpl();

		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "", "");
		final Handle handle = dbi.open();

		print(timetrackingManagment.getTimeTrackingDAO(dbi.open()).findTimeTrackingsByMember(100));

		IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();

		Set<String> account = new HashSet<>();
		account.add("BERAT");

		final Map<Long, Option> members = new HashMap<>();
		members.put(new Long(100), Option.BIGGER);

		final Set<TimeEntry> timeEntries = new HashSet<>();
		timeEntries.add(new TimeEntry(1, 2012, 2013, 12));

		final IFilter memberFilter = new MemberFilter(handle, members);
		final IFilter timeFilter = new TimeFilter(handle, timeEntries);

		print(calc.calculateFigures(dbi.open(), memberFilter, timeFilter));

	}

	public static void print(Set<?> entries) {
		for (Object entry : entries) {
			System.out.println(entry);
			System.out.println("------");
		}

	}
}
