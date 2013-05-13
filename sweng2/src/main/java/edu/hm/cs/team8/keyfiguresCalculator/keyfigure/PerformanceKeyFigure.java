package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class PerformanceKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, TimeTrackingDAO dao) {

		final Set<TimeTrackingEntry> timeTrackings = dao.getTimeTrackings();

		final Set<TimeTrackingEntry> holidays = dao.findTimeTrackingsByAccount("URLAUB");
		final Set<TimeTrackingEntry> ills = dao.findTimeTrackingsByAccount("KRANK");

		double sum = 0;

		for (final TimeTrackingEntry timeTracking : timeTrackings) {
			if (!holidays.contains(timeTracking) && !ills.contains(timeTracking))
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.HOUR, sum);
	}
}
