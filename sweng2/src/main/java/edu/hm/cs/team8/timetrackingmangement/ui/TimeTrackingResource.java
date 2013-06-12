package edu.hm.cs.team8.timetrackingmangement.ui;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

@Path("/time-trackings")
@Produces(MediaType.APPLICATION_JSON)
public class TimeTrackingResource {

	private ITimeTrackingMangement timeTracking;

	public TimeTrackingResource(final ITimeTrackingMangement timeTracking) {
		this.timeTracking = timeTracking;

	}

	@GET
	public Set<TimeTrackingTO> getMasterData() {
		return parse(timeTracking.getTimeTrackings());
	}

	private Set<TimeTrackingTO> parse(Set<TimeTrackingEntry> timeTrackings) {

		final Set<TimeTrackingTO> result = new HashSet<>();

		for (TimeTrackingEntry timeTracking : timeTrackings)
			result.add(new TimeTrackingTO(timeTracking));

		return result;
	}

}
