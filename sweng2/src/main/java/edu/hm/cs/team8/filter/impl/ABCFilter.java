package edu.hm.cs.team8.filter.impl;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public abstract class ABCFilter implements IFilter {

	protected final Handle handle;

	public ABCFilter(final Handle handle) {
		this.handle = handle;
	}

	@Override
	public abstract Set<TimeTrackingEntry> apply();
}
