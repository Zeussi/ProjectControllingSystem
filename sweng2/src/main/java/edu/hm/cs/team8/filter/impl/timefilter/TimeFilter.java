package edu.hm.cs.team8.filter.impl.timefilter;

import java.util.HashSet;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class TimeFilter extends ABCFilter {

	private final Set<TimeEntry> timeEntries;

	public TimeFilter(Handle handle, Set<TimeEntry> timeEntries) {
		super(handle);
		this.timeEntries = timeEntries;
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		for (final TimeTrackingEntry entry : dao.getTimeTrackings()) {
			for (TimeEntry timeEntry : timeEntries)
				if (timeEntry.contains(entry.getMonth(), entry.getYear()))
					result.add(entry);
		}

		return result;
	}

}
