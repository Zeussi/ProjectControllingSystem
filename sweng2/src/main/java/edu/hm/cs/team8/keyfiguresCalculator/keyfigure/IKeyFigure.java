package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureValue;
import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;

public interface IKeyFigure {

	public KeyFigureValue calculate(IMasterData masterdata, ITimeTrackingMangement timetrackingManagement);
}
