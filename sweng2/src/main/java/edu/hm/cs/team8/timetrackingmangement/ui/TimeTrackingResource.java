package edu.hm.cs.team8.timetrackingmangement.ui;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

@Path("/time-trackings")
@Produces(MediaType.APPLICATION_JSON)
public class TimeTrackingResource {

	private final TimeTrackingDAO timeTrackingDAO;

	public TimeTrackingResource(final TimeTrackingDAO timeTrackingDAO) {
		this.timeTrackingDAO = timeTrackingDAO;

	}

	@GET
	public Set<TimeTrackingEntry> getMasterData() {
		return timeTrackingDAO.getTimeTrackings();
	}

}
