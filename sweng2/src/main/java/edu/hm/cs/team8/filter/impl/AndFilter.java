package edu.hm.cs.team8.filter.impl;

import java.util.HashSet;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class AndFilter extends ABCFilter {

	private IFilter[] filters;

	public AndFilter(final Handle handle, final IFilter... filters) {
		super(handle);
		this.filters = filters;
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		final Set<TimeTrackingEntry> entries = dao.getTimeTrackings();

		for (final TimeTrackingEntry entry : entries) {
			boolean add = true;
			for (IFilter filter : filters) {
				final Set<TimeTrackingEntry> filteredEntries = filter.apply();
				if (!filteredEntries.contains(entry))
					add = false;

			}

			if (add)
				result.add(entry);
		}

		return result;
	}
}
