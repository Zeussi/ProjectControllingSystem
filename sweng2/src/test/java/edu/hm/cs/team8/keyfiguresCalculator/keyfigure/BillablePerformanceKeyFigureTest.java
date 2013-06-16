package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.FilterFactory;
import edu.hm.cs.team8.timetrackingmangement.TimeTrackingManagementFactory;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class BillablePerformanceKeyFigureTest {

	private Set<TimeTrackingEntry> entries;

	private IKeyFigure performance;

	@Before
	public void setUp() throws ClassNotFoundException {
		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		final DBI dbi = new DBI("jdbc:hive://194.97.152.47:10000/default", "",
				"");
		final Handle handle = dbi.open();
		entries = FilterFactory.makeFilter("MemberFilter", "Max Mustermann")
				.apply(TimeTrackingManagementFactory
						.makeTimeTrackingManagement(handle).getTimeTrackings());

		performance = new BillablePerformanceKeyFigure();

	}

	@Test
	public void test() {

		KeyFigureResult result = performance.calculate(KeyFigures.BILLABLE_PERFORMANCE,
				entries);
		
		Assert.assertEquals(result.getValue(), new Double(35.5));
		
	}
}
