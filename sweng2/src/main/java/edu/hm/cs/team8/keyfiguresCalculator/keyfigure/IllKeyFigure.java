package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class IllKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure,
			Set<TimeTrackingEntry> timetrackings) {

		double sum = 0;

		for (final TimeTrackingEntry timeTracking : timetrackings) {
			if (timeTracking.getAccount().getName().equals("KRANK"))
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureResult(keyfigure, sum);
	}

}
