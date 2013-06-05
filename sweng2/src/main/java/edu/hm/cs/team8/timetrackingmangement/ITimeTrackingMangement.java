package edu.hm.cs.team8.timetrackingmangement;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public interface ITimeTrackingMangement {

	public Set<TimeTrackingEntry> getTimeTrackings();

}
