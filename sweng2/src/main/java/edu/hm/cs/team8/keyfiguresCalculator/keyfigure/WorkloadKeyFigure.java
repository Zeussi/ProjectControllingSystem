package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class WorkloadKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure,
			final Set<TimeTrackingEntry> timeTrackings) {

		final double performance = (double) new PerformanceKeyFigure()
				.calculate(keyfigure, timeTrackings).getValue();

		final double billablePerformance = (double) new BillablePerformanceKeyFigure()
				.calculate(keyfigure, timeTrackings).getValue();

		final double result = billablePerformance / performance;

		return new KeyFigureResult(keyfigure, result);

	}

}
