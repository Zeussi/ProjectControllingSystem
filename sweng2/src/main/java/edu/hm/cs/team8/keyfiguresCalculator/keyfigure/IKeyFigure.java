package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public interface IKeyFigure {

	public KeyFigureResult calculate(KeyFigures keyfigure, TimeTrackingDAO dao);
}
