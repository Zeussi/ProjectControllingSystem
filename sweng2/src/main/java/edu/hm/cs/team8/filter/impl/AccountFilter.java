package edu.hm.cs.team8.filter.impl;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class AccountFilter implements IFilter {

	private String accountName;

	public AccountFilter(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry entry : entries) {

			if (entry.getAccount().getName().equals(accountName))
				result.add(entry);
		}

		return result;
	}
}
