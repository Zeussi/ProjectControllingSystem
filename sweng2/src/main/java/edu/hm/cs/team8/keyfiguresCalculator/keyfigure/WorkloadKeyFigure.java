package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class WorkloadKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, Handle handle, final Set<TimeTrackingEntry> timeTrackings) {

		final double performance = (double) new PerformanceKeyFigure().calculate(keyfigure, handle, timeTrackings)
				.getValue();

		final double billablePerformance = (double) new BillablePerformanceKeyFigure().calculate(keyfigure, handle,
				timeTrackings).getValue();

		final double result = billablePerformance / performance;

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.RATIO, result);

	}

}
