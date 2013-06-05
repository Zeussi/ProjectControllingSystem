package edu.hm.cs.team8;

import java.util.Set;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.FilterFactory;
import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		// final IMasterData masterdata = new MasterDataImpl();

		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "", "");
		final Handle handle = dbi.open();

		ITimeTrackingMangement mng = new TimeTrackingManagmentImpl(handle);
		IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl(mng);
		
		final IFilter memberFilter = FilterFactory.makeFilter("MemberFilter", "Max Mustermann");
		final IFilter memberFilter2 = FilterFactory.makeFilter("BusinessareaFilter", "COMPANY");
		// final IFilter timeFilter = FilterFactory.makeFilter("Timefilter",
		// "01-2012", handle);

		print(calc.calculateFigures(memberFilter, memberFilter2));

	}

	public static void print(Set<?> entries) {
		for (Object entry : entries) {
			System.out.println(entry);
			System.out.println("------");
		}

	}
}
