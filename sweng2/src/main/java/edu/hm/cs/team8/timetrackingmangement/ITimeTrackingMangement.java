package edu.hm.cs.team8.timetrackingmangement;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public interface ITimeTrackingMangement {

	public TimeTrackingDAO getTimeTrackingDAO(Handle handle);

}
