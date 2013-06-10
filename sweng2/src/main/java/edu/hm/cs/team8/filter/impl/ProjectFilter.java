package edu.hm.cs.team8.filter.impl;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class ProjectFilter implements IFilter {

	private String projectName;

	public ProjectFilter(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry entry : entries) {

			if (entry.getAccount().getProject().getName().equals(projectName))
				result.add(entry);
		}

		return result;
	}
}
