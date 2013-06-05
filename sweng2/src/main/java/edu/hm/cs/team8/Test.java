package edu.hm.cs.team8;

import java.util.Set;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.FilterFactory;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;

public class Test {

	public static void main(String[] args) throws Exception {

		// final IMasterData masterdata = new MasterDataImpl();

		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "", "");
		final Handle handle = dbi.open();

		IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();

		final IFilter memberFilter = FilterFactory.makeFilter("Memberfilter", "Johann Mayer", handle);
		// final IFilter timeFilter = FilterFactory.makeFilter("Timefilter",
		// "01-2012", handle);

		print(calc.calculateFigures(handle, memberFilter));

	}

	public static void print(Set<?> entries) {
		for (Object entry : entries) {
			System.out.println(entry);
			System.out.println("------");
		}

	}
}
