package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public class WorkloadKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, TimeTrackingDAO dao) {

		final double performance = (double) new PerformanceKeyFigure().calculate(keyfigure, dao).getValue();

		final double billablePerformance = (double) new BillablePerformanceKeyFigure().calculate(keyfigure, dao).getValue();

		final double result = billablePerformance / performance;

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.RATIO, result);

	}

}
