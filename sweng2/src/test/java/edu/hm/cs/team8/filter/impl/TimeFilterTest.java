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

public class TimeFilterTest {

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
	public void test01_2013() {

		timeFilter = FilterFactory.makeFilter("TimeFilter", "01-2013");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 17);

	}

	@Test
	public void test02_2013() {

		timeFilter = FilterFactory.makeFilter("TimeFilter", "02-2013");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 1);

	}
	
	@Test
	public void test03_2013() {

		timeFilter = FilterFactory.makeFilter("TimeFilter", "03-2013");

		final Set<TimeTrackingEntry> result = timeFilter.apply(tmangm
				.getTimeTrackings());

		Assert.assertEquals(result.size(), 1);

	}
}
