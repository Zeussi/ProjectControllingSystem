package edu.hm.cs.team8.filter.impl.memberfilter;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class MemberFilter implements IFilter {

	private String name;

	public MemberFilter(final String names) {
		this.name = names;
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry entry : entries)
			if (entry.getMember().getName().equals(name))
				result.add(entry);

		return result;
	}
}
