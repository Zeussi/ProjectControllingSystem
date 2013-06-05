package edu.hm.cs.team8.filter;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public interface IFilter {

	Set<TimeTrackingEntry> apply(final Set<TimeTrackingEntry> entries);

}
