package edu.hm.cs.team8.timetrackingmangement;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class TimeTrackingManagementFactory {

	private static ITimeTrackingMangement timeTrackingManagement;

	public static synchronized ITimeTrackingMangement makeTimeTrackingManagement(final Handle handle) {
		if (timeTrackingManagement == null)
			timeTrackingManagement = new TimeTrackingManagmentImpl(handle);

		return timeTrackingManagement;

	}
}
