package edu.hm.cs.team8.timetrackingmangement.impl;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public class TimeTrackingManagmentImpl implements ITimeTrackingMangement {

	@Override
	public TimeTrackingDAO getTimeTrackingDAO(Handle handle) {
		return new TimeTrackingDAO(handle);
	}

}
