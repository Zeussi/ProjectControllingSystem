package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.HashMap;
import java.util.Map;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.BillablePerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.IKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.PerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.WorkloadKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureValue;
import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.masterdata.impl.MasterDataImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.impl.TimeTrackingManagmentImpl;

public class KeyFiguresCalculatorImpl implements IKeyFiguresCalculator {

	private static final Map<KeyFigures, IKeyFigure> logic = new HashMap<>();

	static {
		logic.put(KeyFigures.PERFORMANCE, new PerformanceKeyFigure());
		logic.put(KeyFigures.BILLABLE_PERFORMANCE, new BillablePerformanceKeyFigure());
		logic.put(KeyFigures.WORKLOAD, new WorkloadKeyFigure());
	}

	@Override
	public Map<KeyFigures, KeyFigureValue> calculateFigures() throws ClassNotFoundException {

		final Map<KeyFigures, KeyFigureValue> result = new HashMap<>();

		final IMasterData masterdata = new MasterDataImpl();

		final ITimeTrackingMangement timetrackingManagement = new TimeTrackingManagmentImpl();

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet())
			result.put(entry.getKey(), entry.getValue().calculate(masterdata, timetrackingManagement));

		return result;
	}

}
