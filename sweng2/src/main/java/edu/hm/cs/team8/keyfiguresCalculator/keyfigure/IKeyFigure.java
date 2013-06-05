package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public interface IKeyFigure {

	public KeyFigureResult calculate(KeyFigures keyfigure, final Set<TimeTrackingEntry> timetrackings);
}
