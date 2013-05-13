package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureValue;
import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;

public class WorkloadKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureValue calculate(IMasterData masterdata, ITimeTrackingMangement timetrackingManagement) {

		final int performance = (int) new PerformanceKeyFigure().calculate(masterdata, timetrackingManagement)
				.getValue();

		final int billablePerformance = (int) new BillablePerformanceKeyFigure().calculate(masterdata,
				timetrackingManagement).getValue();

		final double result = billablePerformance / (double) performance;

		return new KeyFigureValue(result, KeyFigureMeasure.NONE);

	}

}
