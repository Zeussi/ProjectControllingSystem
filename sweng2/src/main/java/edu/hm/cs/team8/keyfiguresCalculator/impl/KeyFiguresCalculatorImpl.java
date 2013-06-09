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
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;
import edu.hm.cs.team8.keyfiguresCalculator.to.KeyFigureResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.TimeBehaviourKeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class KeyFiguresCalculatorImpl implements IKeyFiguresCalculator {

	private static final Map<KeyFigures, IKeyFigure> logic = new HashMap<>();
	static {
		logic.put(KeyFigures.PERFORMANCE, new PerformanceKeyFigure());
		logic.put(KeyFigures.BILLABLE_PERFORMANCE,
				new BillablePerformanceKeyFigure());
		logic.put(KeyFigures.WORKLOAD, new WorkloadKeyFigure());
	}

	private final ITimeTrackingMangement timeTracking;

	public KeyFiguresCalculatorImpl(ITimeTrackingMangement timeTracking) {
		this.timeTracking = timeTracking;
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

	@Override
	public Set<KeyFigureResult> calculateOnlyFigures(FilterTO... filters) {

		final Set<TimeTrackingEntry> andAndOr = and(or(
				FilterParser.parse(filters), timeTracking.getTimeTrackings()));

		return calculateFigures(andAndOr);
	}

	private Set<KeyFigureResult> calculateFigures(Set<TimeTrackingEntry> entries) {
		final Set<KeyFigureResult> result = new HashSet<>();

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet()) {
			KeyFigureResult value = entry.getValue().calculate(entry.getKey(),
					entries);
			result.add(value);
		}

		return result;

	}

	@Override
	public Set<TimeBehaviourKeyFigureResult> calculateTimeBehaviourFigures(
			FilterTO... filters) {

		final Map<String, Set<TimeTrackingEntry>> fiteredData = new HashMap<>();

		final Set<TimeTrackingEntry> entries = and(or(
				FilterParser.parse(filters), timeTracking.getTimeTrackings()));

		for (TimeTrackingEntry entry : entries) {

			Set<TimeTrackingEntry> temp = fiteredData.get(entry.getMonth()
					+ "-" + entry.getYear());
			if (temp == null)
				temp = new HashSet<>();

			temp.add(entry);

			fiteredData.put(entry.getMonth() + "-" + entry.getYear(), temp);
		}

		final Set<TimeBehaviourKeyFigureResult> result = new HashSet<>();

		for (Map.Entry<String, Set<TimeTrackingEntry>> entry : fiteredData
				.entrySet()) {
			result.add(new TimeBehaviourKeyFigureResult(entry.getKey(),
					calculateFigures(entry.getValue())));
		}

		return result;
	}

	private Set<Set<TimeTrackingEntry>> or(IFilter[] filters,
			Set<TimeTrackingEntry> entries) {

		final Map<Class<? extends IFilter>, Set<TimeTrackingEntry>> ord = new HashMap<>();

		for (final IFilter filter : filters) {

			Set<TimeTrackingEntry> f = ord.get(filter.getClass());
			if (f == null)
				f = new HashSet<>();

			f.addAll(filter.apply(entries));
			ord.put(filter.getClass(), f);

		}

		final Set<Set<TimeTrackingEntry>> result = new HashSet<>();

		if (filters.length == 0)
			result.add(entries);

		for (Map.Entry<Class<? extends IFilter>, Set<TimeTrackingEntry>> entry : ord
				.entrySet())
			result.add(entry.getValue());

		return result;

	}

}
