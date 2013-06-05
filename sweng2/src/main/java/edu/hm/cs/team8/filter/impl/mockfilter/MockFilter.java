package edu.hm.cs.team8.filter.impl.mockfilter;

import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class MockFilter implements IFilter {

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		return entries;
	}

}
