package edu.hm.cs.team8.filter.impl.timefilter;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class TimeFilter implements IFilter {

	private int month;
	private int year;

	public TimeFilter(String date) {
		String[] elements = date.split("-");
		month = Integer.parseInt(elements[0]);
		year = Integer.parseInt(elements[1]);
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry entry : entries)
			if (entry.getYear() == year && entry.getMonth() == month)
				result.add(entry);

		return result;
	}

}