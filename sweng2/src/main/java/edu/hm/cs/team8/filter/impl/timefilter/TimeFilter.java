package edu.hm.cs.team8.filter.impl.timefilter;

import java.util.HashSet;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class TimeFilter extends ABCFilter {

	private int month;
	private int year;

	public TimeFilter(Handle handle, String date) {
		super(handle);
		String[] elements = date.split("-");
		month = Integer.parseInt(elements[0]);
		year = Integer.parseInt(elements[1]);
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		for (final TimeTrackingEntry entry : dao.getTimeTrackings())
			if (entry.getYear() == year && entry.getMonth() == month)
				result.add(entry);

		return result;
	}

}