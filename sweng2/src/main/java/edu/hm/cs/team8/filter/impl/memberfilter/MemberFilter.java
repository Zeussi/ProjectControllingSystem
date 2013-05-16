package edu.hm.cs.team8.filter.impl.memberfilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.filter.impl.Option;
import edu.hm.cs.team8.timetrackingmangement.dao.MemberDAO;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class MemberFilter extends ABCFilter {

	private final Map<Long, Option> values;

	public MemberFilter(final Handle handle, final Map<Long, Option> values) {
		super(handle);
		this.values = values;

	}

	public MemberFilter(final Handle handle, final Set<String> names) {
		super(handle);

		final MemberDAO dao = new MemberDAO(handle);
		values = new HashMap<>();

		for (String name : names)
			values.put(dao.findMemberByName(name).getmId(), Option.EQUALS);

	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		for (final TimeTrackingEntry entry : dao.getTimeTrackings())
			for (Map.Entry<Long, Option> filterEntries : values.entrySet())
				if (MemberComparator.compare(entry.getMember(), filterEntries.getKey(), filterEntries.getValue()))
					result.add(entry);
		return result;
	}
}
