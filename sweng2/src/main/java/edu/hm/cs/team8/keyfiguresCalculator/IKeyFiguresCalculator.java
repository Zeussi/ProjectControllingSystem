package edu.hm.cs.team8.keyfiguresCalculator;

import java.util.Set;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public interface IKeyFiguresCalculator {

	Set<KeyFigureResult> calculateFigures(TimeTrackingDAO dao);
}
