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

public class MemberFilterTest {

	private ITimeTrackingMangement tmangm;

	private IFilter memberFilter;

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
	public void testElviraSeidel() {

		memberFilter = FilterFactory
				.makeFilter("MemberFilter", "Elvira Seidel");

		final Set<TimeTrackingEntry> result = memberFilter.apply(tmangm
				.getTimeTrackings());

		for (TimeTrackingEntry entry : result) {
			Assert.assertEquals(entry.getMember().getName(), "Elvira Seidel");
			Assert.assertEquals(entry.getMember().getmId(), 1104);
			Assert.assertEquals(entry.getMember().getLevel(), 3);
		}
		
		Assert.assertEquals(result.size(), 4);

	}
	
	@Test
	public void testMaxMustermann() {

		memberFilter = FilterFactory
				.makeFilter("MemberFilter", "Max Mustermann");

		final Set<TimeTrackingEntry> result = memberFilter.apply(tmangm
				.getTimeTrackings());

		for (TimeTrackingEntry entry : result) {
			Assert.assertEquals(entry.getMember().getName(), "Max Mustermann");
			Assert.assertEquals(entry.getMember().getmId(), 100);
			Assert.assertEquals(entry.getMember().getLevel(), 5);
		}
		
		Assert.assertEquals(result.size(), 8);

	}

}
