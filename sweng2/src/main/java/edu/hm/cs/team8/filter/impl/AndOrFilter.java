package edu.hm.cs.team8.filter.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class AndOrFilter implements IFilter {

	private IFilter[] filters;

	public AndOrFilter(final IFilter... filters) {
		this.filters = filters;
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {
		
		final Set<Set<TimeTrackingEntry>> ord = or(filters, entries);

		return and(ord);
	}

	private Set<TimeTrackingEntry> and(final Set<Set<TimeTrackingEntry>> ord) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (Set<TimeTrackingEntry> entry : ord) {
			boolean add = true;

			for (TimeTrackingEntry tEntry : entry) {
				for (Set<TimeTrackingEntry> others : ord) {
					if (!others.contains(tEntry))
						add = false;
				}

				if (add)
					result.add(tEntry);

			}
		}
		return result;
	}

	private Set<Set<TimeTrackingEntry>> or(IFilter[] filters2, Set<TimeTrackingEntry> entries) {

		final Map<Class<? extends IFilter>, Set<TimeTrackingEntry>> ord = new HashMap<>();

		for (final IFilter filter : filters) {

			Set<TimeTrackingEntry> f = ord.get(filter.getClass());
			if (f == null)
				f = new HashSet<>();

			f.addAll(filter.apply(entries));
			ord.put(filter.getClass(), f);

		}

		final Set<Set<TimeTrackingEntry>> result = new HashSet<>();

		for (Map.Entry<Class<? extends IFilter>, Set<TimeTrackingEntry>> entry : ord.entrySet()) {
			result.add(entry.getValue());
		}

		return result;

	}

}
