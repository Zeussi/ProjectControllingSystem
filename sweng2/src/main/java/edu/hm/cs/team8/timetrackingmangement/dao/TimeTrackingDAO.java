package edu.hm.cs.team8.timetrackingmangement.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.datamodel.Account;
import edu.hm.cs.team8.timetrackingmangement.datamodel.Member;
import edu.hm.cs.team8.timetrackingmangement.datamodel.Project;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class TimeTrackingDAO {

	private final Handle handle;
	private final Set<TimeTrackingEntry> timeTrackings = new HashSet<>();

	public TimeTrackingDAO(final Handle handle) {

		this.handle = handle;

		for (final Map<String, Object> line : Cache.getCache(handle)) {

			final MemberDAO memberDao = new MemberDAO(handle);
			final AccountDAO accountDao = new AccountDAO(handle);

			final TimeTrackingEntry entry = new TimeTrackingEntry(memberDao.findMemberByID(Long.parseLong(line.get(
					"mid").toString())), accountDao.findAccountByName(line.get("konto").toString()),
					Double.parseDouble(line.get("stunden").toString()), Boolean.parseBoolean(line.get("fakturierbar")
							.toString()), Double.parseDouble(line.get("grenzkosten").toString()),
					Double.parseDouble(line.get("verrechnungssatz").toString()), Integer.parseInt(line.get("monat")
							.toString().split("-")[0]), Integer.parseInt(line.get("monat").toString().split("-")[1]));

			timeTrackings.add(entry);

		}
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByAccount(final String accountName) {

		final Account account = new AccountDAO(handle).findAccountByName(accountName);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (TimeTrackingEntry timetracking : timeTrackings) {

			final Account accountTimeTracking = timetracking.getAccount();

			if (account.equals(accountTimeTracking))
				result.add(timetracking);
		}

		return result;
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByMember(final long id) {

		final Member member = new MemberDAO(handle).findMemberByID(id);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (TimeTrackingEntry timetracking : timeTrackings)
			if (timetracking.getMember().equals(member))
				result.add(timetracking);

		return result;
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByProject(final String projectName) {

		final Project project = new ProjectDAO(handle).findProjectByName(projectName);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry timetracking : timeTrackings) {

			final Project ProjectTimeTracking = timetracking.getAccount().getProject();

			if (project.equals(ProjectTimeTracking))
				result.add(timetracking);
		}

		return result;
	}

	public Set<TimeTrackingEntry> getTimeTrackings() {
		return new HashSet<>(timeTrackings);
	}

}
