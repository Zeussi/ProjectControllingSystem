package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

public class WorkloadKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureResult calculate(KeyFigures keyfigure, Handle handle, final IFilter... filters) {

		final double performance = (double) new PerformanceKeyFigure().calculate(keyfigure, handle, filters).getValue();

		final double billablePerformance = (double) new BillablePerformanceKeyFigure().calculate(keyfigure, handle,
				filters).getValue();

		final double result = billablePerformance / performance;

		return new KeyFigureResult(keyfigure, KeyFigureMeasure.RATIO, result);

	}

}
