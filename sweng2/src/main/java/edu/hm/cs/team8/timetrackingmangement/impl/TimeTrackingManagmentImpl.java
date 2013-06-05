package edu.hm.cs.team8.timetrackingmangement.impl;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public class TimeTrackingManagmentImpl implements ITimeTrackingMangement {

	private Handle handle;

	public TimeTrackingManagmentImpl(Handle handle) {
		this.handle = handle;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TimeTrackingDAO getTimeTrackingDAO() {
		return new TimeTrackingDAO(handle);
	}

}
