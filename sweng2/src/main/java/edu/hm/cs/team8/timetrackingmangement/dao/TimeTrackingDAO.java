package edu.hm.cs.team8.timetrackingmangement.dao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.masterdata.datamodel.Account;
import edu.hm.cs.team8.masterdata.datamodel.Member;
import edu.hm.cs.team8.masterdata.datamodel.Project;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;
import edu.hm.cs.team8.timetrackingmangement.impl.Cache;

public class TimeTrackingDAO {

	private final Set<TimeTrackingEntry> timeTrackings = new HashSet<>();
	private final IMasterData masterdata;

	public TimeTrackingDAO(final Handle handle, final IMasterData masterdata) {

		this.masterdata = masterdata;
		for (final Map<String, Object> line : Cache.getCache(handle)) {

			timeTrackings.add(new TimeTrackingEntry(Long.parseLong(line.get("mid").toString()), line.get("konto")
					.toString(), Double.parseDouble(line.get("stunden").toString()), Boolean.parseBoolean(line.get(
					"fakturierbar").toString()), Double.parseDouble(line.get("grenzkosten").toString()), Double
					.parseDouble(line.get("verrechnungssatz").toString()), line.get("monat").toString()));

		}
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByMember(final String name) {

		final Member member = masterdata.getMemberDAO().findMemberByName(name);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (TimeTrackingEntry timetracking : timeTrackings)
			if (timetracking.getMid() == member.getmId())
				result.add(timetracking);

		return result;
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByAccount(final String accountName) {

		final Account account = masterdata.getAccountDAO().findAccountByName(accountName);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (TimeTrackingEntry timetracking : timeTrackings) {

			final Account accountTimeTracking = masterdata.getAccountDAO().findAccountByName(timetracking.getAccount());

			if (account.equals(accountTimeTracking))
				result.add(timetracking);
		}

		return result;
	}

	public Set<TimeTrackingEntry> findTimeTrackingsByProject(final String projectName) {

		final Project project = masterdata.getProjectDAO().findProjectByName(projectName);

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (final TimeTrackingEntry timetracking : timeTrackings) {

			final Project ProjectTimeTracking = masterdata.getAccountDAO().findAccountByName(timetracking.getAccount())
					.getProject();

			if (project.equals(ProjectTimeTracking))
				result.add(timetracking);
		}

		return result;
	}

	public Set<TimeTrackingEntry> getTimeTrackings() {
		return Collections.unmodifiableSet(timeTrackings);
	}

}
