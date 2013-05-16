package edu.hm.cs.team8.filter.impl.organisationfilter;

import java.util.HashSet;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.ABCFilter;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class OrganisationFilter extends ABCFilter {

	private final Set<String> accounts;
	private final Set<String> projects;
	private final Set<String> businessAreas;

	public OrganisationFilter(final Handle handle, Set<String> businessAreas, Set<String> projects, Set<String> accounts) {
		super(handle);
		this.businessAreas = setList(businessAreas);
		this.projects = setList(projects);
		this.accounts = setList(accounts);
	}

	private Set<String> setList(Set<String> list) {
		if (list == null)
			return new HashSet<>();

		return list;
	}

	@Override
	public Set<TimeTrackingEntry> apply() {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		final TimeTrackingDAO dao = new TimeTrackingManagmentImpl().getTimeTrackingDAO(handle);

		for (final TimeTrackingEntry entry : dao.getTimeTrackings()) {

			boolean add = false;

			add = add || (accounts.contains(entry.getAccount().getName()));
			add = add || (projects.contains(entry.getAccount().getProject().getName()));
			add = add || (businessAreas.contains(entry.getAccount().getProject().getBusinessArea().getName()));

			if (add)
				result.add(entry);
		}

		return result;

	}

}
