package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class BillablePerformanceKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure,
			final Set<TimeTrackingEntry> timeTrackings) {

		double sum = 0;

		for (final TimeTrackingEntry timeTracking : timeTrackings) {

			if (timeTracking.isBillable())
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureResult(keyfigure, sum);
	}

}
