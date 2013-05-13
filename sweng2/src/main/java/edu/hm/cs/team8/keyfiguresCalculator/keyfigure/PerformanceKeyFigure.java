package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

import java.util.Set;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureMeasure;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value.KeyFigureValue;
import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.masterdata.datamodel.Account;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.datamodel.TimeTrackingEntry;

public class PerformanceKeyFigure implements IKeyFigure {

	@Override
	public KeyFigureValue calculate(IMasterData masterdata, ITimeTrackingMangement timetrackingManagement) {

		final Set<TimeTrackingEntry> timeTrackings = timetrackingManagement.getTimeTrackingDAO().getTimeTrackings();

		final Account holiday = masterdata.getAccountDAO().findAccountByName("urlaub");
		final Account ill = masterdata.getAccountDAO().findAccountByName("krank");

		int sum = 0;

		for (final TimeTrackingEntry timeTracking : timeTrackings) {
			final Account other = masterdata.getAccountDAO().findAccountByName(timeTracking.getAccount());

			if (!other.equals(holiday) && !other.equals(ill))
				sum += timeTracking.getWorkedHours();
		}

		return new KeyFigureValue(sum, KeyFigureMeasure.HOUR);
	}

}
