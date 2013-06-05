package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
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

		final Set<TimeTrackingEntry> andAndOr = and(or(filters, timeTracking.getTimeTrackings()));

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet()) {
			KeyFigureResult value = entry.getValue().calculate(entry.getKey(), andAndOr);
			result.add(value);
		}

		return result;
	}

	private Set<TimeTrackingEntry> and(final Set<Set<TimeTrackingEntry>> ord) {

		final Set<TimeTrackingEntry> result = new HashSet<>();

		for (Set<TimeTrackingEntry> entry : ord) {
			boolean add = true;

			for (TimeTrackingEntry tEntry : entry) {
				for (Set<TimeTrackingEntry> others : ord) {
					if (!others.contains(tEntry))
						add = false;
				}

				if (add)
					result.add(tEntry);

			}
		}
		return result;
	}

	private Set<Set<TimeTrackingEntry>> or(IFilter[] filters, Set<TimeTrackingEntry> entries) {

		final Map<Class<? extends IFilter>, Set<TimeTrackingEntry>> ord = new HashMap<>();

		for (final IFilter filter : filters) {

			Set<TimeTrackingEntry> f = ord.get(filter.getClass());
			if (f == null)
				f = new HashSet<>();

			f.addAll(filter.apply(entries));
			ord.put(filter.getClass(), f);

		}

		final Set<Set<TimeTrackingEntry>> result = new HashSet<>();

		for (Map.Entry<Class<? extends IFilter>, Set<TimeTrackingEntry>> entry : ord.entrySet()) {
			result.add(entry.getValue());
		}

		return result;

	}

}
