package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public interface IKeyFigure {

	public KeyFigureResult calculate(KeyFigures keyfigure,
			final Set<TimeTrackingEntry> timetrackings);
}
