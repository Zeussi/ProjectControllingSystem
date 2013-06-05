package edu.hm.cs.team8.filter.impl.memberfilter;

import java.util.HashSet;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class MemberFilter extends ABCFilter {

	private String name;

	public MemberFilter(final Handle handle, final String names) {
		super(handle);
		this.name = names;
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		for (final TimeTrackingEntry entry : dao.getTimeTrackings())
			if (entry.getMember().getName().equals(name))
				result.add(entry);

		return result;
	}
}
