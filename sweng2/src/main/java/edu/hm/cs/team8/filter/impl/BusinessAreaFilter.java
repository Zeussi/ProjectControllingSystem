package edu.hm.cs.team8.filter.impl;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class BusinessAreaFilter implements IFilter {

	private String businessArea;

	public BusinessAreaFilter(String businessArea) {
		this.businessArea = businessArea;
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry entry : entries) {

			if (entry.getAccount().getProject().getBusinessArea().getName().equals(businessArea))
				result.add(entry);
		}

		return result;
	}

}
