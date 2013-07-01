package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.BillablePerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.CostKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.IKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.IllKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigureResult;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.PerformanceKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.PerformanceReturn;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.ReturnKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.WorkloadKeyFigure;
import edu.hm.cs.team8.keyfiguresCalculator.to.DiagramResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;
import edu.hm.cs.team8.keyfiguresCalculator.to.KeyFigureTableEntry;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class KeyFiguresCalculatorImpl implements IKeyFiguresCalculator {

	private static final Map<KeyFigures, IKeyFigure> logic = new HashMap<>();
	static {
		logic.put(KeyFigures.PERFORMANCE, new PerformanceKeyFigure());
		logic.put(KeyFigures.BILLABLE_PERFORMANCE,
				new BillablePerformanceKeyFigure());
		logic.put(KeyFigures.WORKLOAD, new WorkloadKeyFigure());
		logic.put(KeyFigures.COST, new CostKeyFigure());
		logic.put(KeyFigures.ILL, new IllKeyFigure());
		logic.put(KeyFigures.PERFORMANCE_RETURN, new PerformanceReturn());
		logic.put(KeyFigures.RETURN, new ReturnKeyFigure());
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

	private Set<KeyFigureResult> calculateFigures(
			Set<TimeTrackingEntry> entries, KeyFigures... keyfigures) {

		return calculateFigures(entries,
				new HashSet<>(Arrays.asList(keyfigures)));

	}

	private Set<KeyFigureResult> calculateFigures(
			Set<TimeTrackingEntry> entries, Set<KeyFigures> keyfigures) {
		final Set<KeyFigureResult> result = new HashSet<>();

		for (Map.Entry<KeyFigures, IKeyFigure> entry : logic.entrySet()) {
			if (keyfigures.contains(entry.getKey())) {
				KeyFigureResult value = entry.getValue().calculate(
						entry.getKey(), entries);
				result.add(value);
			}
		}

		return result;

	}

	@Override
	public Set<KeyFigureTableEntry> calculateOnlyFigures(
			final FilterTO... filters) {

		final Set<TimeTrackingEntry> andAndOr = and(or(
				FilterParser.parse(filters), timeTracking.getTimeTrackings()));

		final Set<KeyFigureResult> keyFigures = calculateFigures(andAndOr,
				KeyFigures.values());

		final Set<KeyFigureTableEntry> result = new HashSet<>();

		for (final KeyFigureResult keyfigure : keyFigures)
			result.add(new KeyFigureTableEntry(keyfigure.getKey().toString(),
					keyfigure.getValue().toString()));

		return result;
	}

	@Override
	public DiagramResult calculateTimeBehaviourFigure(String keyfigureTo,
			FilterTO... filters) {

		final Map<String, Set<TimeTrackingEntry>> fiteredData = new HashMap<>();
		final KeyFigures keyFigureToCalculate = KeyFigures
				.parseKeyFigure(keyfigureTo);

		final Set<TimeTrackingEntry> entries = and(or(
				FilterParser.parse(filters), timeTracking.getTimeTrackings()));

		for (TimeTrackingEntry entry : entries) {

			String date = entry.getMonth() + "-" + entry.getYear();
			if (entry.getMonth() < 10)
				date = "0" + date;

			Set<TimeTrackingEntry> temp = fiteredData.get(date);
			if (temp == null)
				temp = new HashSet<>();

			temp.add(entry);

			fiteredData.put(date, temp);
		}

		final DiagramResult result = new DiagramResult();
		result.setLabelX(keyFigureToCalculate.toString());
		result.setLabelY(keyFigureToCalculate.getMeasure().toString());

		for (Map.Entry<String, Set<TimeTrackingEntry>> entry : fiteredData
				.entrySet()) {

			final KeyFigureResult keyFigures = calculateFigures(
					entry.getValue(), keyFigureToCalculate).iterator().next();

			result.addXandYValue(entry.getKey(), keyFigures.getValue()
					.toString());
		}

		return result;
	}

	private Set<Set<TimeTrackingEntry>> or(final IFilter[] filters,
			final Set<TimeTrackingEntry> entries) {

		final Set<Set<TimeTrackingEntry>> result = new HashSet<>();
		if (filters.length == 0)
			result.add(entries);

		final Map<Class<? extends IFilter>, Set<TimeTrackingEntry>> ord = new HashMap<>();

		for (final IFilter filter : filters) {

			Set<TimeTrackingEntry> f = ord.get(filter.getClass());
			if (f == null)
				f = new HashSet<>();

			f.addAll(filter.apply(entries));
			ord.put(filter.getClass(), f);

		}

		if (filters.length == 0)
			result.add(entries);

		for (Map.Entry<Class<? extends IFilter>, Set<TimeTrackingEntry>> entry : ord
				.entrySet())
			result.add(entry.getValue());

		return result;

	}

	@Override
	public DiagramResult calculateProjectBehaviourFigure(String keyfigureTo,
			FilterTO... filters) {

		final Map<String, Set<TimeTrackingEntry>> fiteredData = new HashMap<>();
		final KeyFigures keyFigureToCalculate = KeyFigures
				.parseKeyFigure(keyfigureTo);

		final Set<TimeTrackingEntry> entries = and(or(
				FilterParser.parse(filters), timeTracking.getTimeTrackings()));

		for (TimeTrackingEntry entry : entries) {

			String project = entry.getAccount().getProject().getName();
			Set<TimeTrackingEntry> temp = fiteredData.get(project);
			if (temp == null)
				temp = new HashSet<>();

			temp.add(entry);

			fiteredData.put(project, temp);
		}

		final DiagramResult result = new DiagramResult();
		result.setLabelX(keyFigureToCalculate.toString());
		result.setLabelY(keyFigureToCalculate.getMeasure().toString());

		for (Map.Entry<String, Set<TimeTrackingEntry>> entry : fiteredData
				.entrySet()) {

			final KeyFigureResult keyFigures = calculateFigures(
					entry.getValue(), keyFigureToCalculate).iterator().next();

			result.addXandYValue(entry.getKey(), keyFigures.getValue()
					.toString());
		}

		return result;
		
	}

}
