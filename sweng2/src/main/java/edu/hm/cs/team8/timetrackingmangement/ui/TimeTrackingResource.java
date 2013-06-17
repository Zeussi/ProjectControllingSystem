package edu.hm.cs.team8.timetrackingmangement.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	public List<TimeTrackingTO> getMasterData() {
		return parse(timeTracking.getTimeTrackings());
	}

	private List<TimeTrackingTO> parse(Set<TimeTrackingEntry> timeTrackings) {

		final List<TimeTrackingTO> result = new ArrayList<>();

		for (TimeTrackingEntry timeTracking : timeTrackings)
			result.add(new TimeTrackingTO(timeTracking));

		Collections.sort(result, new Comparator<TimeTrackingTO>() {

			@Override
			public int compare(TimeTrackingTO o1, TimeTrackingTO o2) {
				return (int) (o1.getMid() - o2.getMid());

			}
		});

		return result;
	}
}
