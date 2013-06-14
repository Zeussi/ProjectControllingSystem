package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class ReturnKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure,
			Set<TimeTrackingEntry> timetrackings) {

		final double performanceReturn = (double) new PerformanceReturn()
				.calculate(keyfigure, timetrackings).getValue();

		final double cost = (double) new CostKeyFigure().calculate(keyfigure,
				timetrackings).getValue();

		final double result = performanceReturn - cost;

		return new KeyFigureResult(keyfigure, result);
	}

}
