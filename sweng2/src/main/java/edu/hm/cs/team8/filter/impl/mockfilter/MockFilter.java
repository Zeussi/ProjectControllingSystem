package edu.hm.cs.team8.filter.impl.mockfilter;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class MockFilter extends ABCFilter {

	public MockFilter(final Handle handle) {
		super(handle);
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		return dao.getTimeTrackings();
	}

}
