package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.BillablePerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.IKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.PerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.WorkloadKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

public class KeyFiguresCalculatorImpl implements IKeyFiguresCalculator {

	private static final Map<KeyFigures, IKeyFigure> logic = new HashMap<>();

	static {
		logic.put(KeyFigures.PERFORMANCE, new PerformanceKeyFigure());
		logic.put(KeyFigures.BILLABLE_PERFORMANCE, new BillablePerformanceKeyFigure());
		logic.put(KeyFigures.WORKLOAD, new WorkloadKeyFigure());
	}

	@Override
	public Set<KeyFigureResult> calculateFigures(Handle handle, final IFilter... filters) {

		final Set<KeyFigureResult> result = new HashSet<>();

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet()) {
			KeyFigureResult value = entry.getValue().calculate(entry.getKey(), handle, filters);

			result.add(value);
		}

		return result;
	}
}
