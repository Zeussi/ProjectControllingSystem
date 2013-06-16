package edu.hm.cs.team8.filter.impl;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.FilterFactory;
import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.TimeTrackingManagementFactory;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class AccountFilterTest {

	private ITimeTrackingMangement tmangm;

	private IFilter timeFilter;

	@Before
	public void setUp() throws ClassNotFoundException {
		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "",
				"");
		final Handle handle = dbi.open();
		tmangm = TimeTrackingManagementFactory
				.makeTimeTrackingManagement(handle);

	}

	@Test
	public void testAusb() {

		timeFilter = FilterFactory.makeFilter("AccountFilter", "AUSB");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 3);

	}

	@Test
	public void testUrlaub() {

		timeFilter = FilterFactory.makeFilter("AccountFilter", "URLAUB");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 2);

	}
	
	@Test
	public void testMtg() {

		timeFilter = FilterFactory.makeFilter("AccountFilter", "MTG");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 3);

	}

}
