package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class BillablePerformanceKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, final Set<TimeTrackingEntry> timeTrackings) {

		double sum = 0;

		for (final TimeTrackingEntry timeTracking : timeTrackings) {

			if (timeTracking.isBillable())
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.HOUR, sum);
	}

}
