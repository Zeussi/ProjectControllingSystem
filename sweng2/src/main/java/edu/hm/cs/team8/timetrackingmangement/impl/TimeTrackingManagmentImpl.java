package edu.hm.cs.team8.timetrackingmangement.impl;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class TimeTrackingManagmentImpl implements ITimeTrackingMangement {

	private final TimeTrackingDAO timeTrackingDAO;

	public TimeTrackingManagmentImpl(Handle handle) {
		this.timeTrackingDAO = new TimeTrackingDAO(handle);
	}

	@Override
	public Set<TimeTrackingEntry> getTimeTrackings() {
		return timeTrackingDAO.getTimeTrackings();
	}

}
