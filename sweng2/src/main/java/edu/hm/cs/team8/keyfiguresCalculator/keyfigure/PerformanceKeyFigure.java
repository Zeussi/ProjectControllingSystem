package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.AndFilter;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class PerformanceKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, Handle handle, final IFilter... filters) {

		final Set<TimeTrackingEntry> timeTrackings = new AndFilter(handle, filters).apply();

		double sum = 0;

		for (final TimeTrackingEntry timeTracking : timeTrackings) {
			// if (!holidays.contains(timeTracking) &&
			// !ills.contains(timeTracking))
			final String accountName = timeTracking.getAccount().getName();

			if (!accountName.equals("KRANK") && !accountName.equals("URLAUB"))
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.HOUR, sum);
	}
}
