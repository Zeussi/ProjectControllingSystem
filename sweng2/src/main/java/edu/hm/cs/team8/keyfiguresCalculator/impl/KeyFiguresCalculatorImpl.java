package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.AndOrFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.BillablePerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.IKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.PerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.WorkloadKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class KeyFiguresCalculatorImpl implements IKeyFiguresCalculator {

	private static final Map<KeyFigures, IKeyFigure> logic = new HashMap<>();
	private ITimeTrackingMangement timeTracking;

	static {
		logic.put(KeyFigures.PERFORMANCE, new PerformanceKeyFigure());
		logic.put(KeyFigures.BILLABLE_PERFORMANCE, new BillablePerformanceKeyFigure());
		logic.put(KeyFigures.WORKLOAD, new WorkloadKeyFigure());
	}

	public KeyFiguresCalculatorImpl(ITimeTrackingMangement timeTracking) {
		this.timeTracking = timeTracking;
	}

	@Override
	public Set<KeyFigureResult> calculateFigures(IFilter... filters) {

		final Set<KeyFigureResult> result = new HashSet<>();

		final Set<TimeTrackingEntry> andAndOr = new AndOrFilter(filters).apply(timeTracking.getTimeTrackingDAO()
				.getTimeTrackings());

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet()) {
			KeyFigureResult value = entry.getValue().calculate(entry.getKey(), andAndOr);
			result.add(value);
		}

		return result;
	}

}
