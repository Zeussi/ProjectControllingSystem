package edu.hm.cs.team8.keyfiguresCalculator.to;

import java.util.Set;

public class TimeBehaviourKeyFigureResult {

	private String date;
	private Set<KeyFigureResult> keyFigures;

	public TimeBehaviourKeyFigureResult(String date, Set<KeyFigureResult> keyFigures) {
		this.date = date;
		this.keyFigures = keyFigures;

	}

	@Override
	public String toString() {
		return "TimeBehaviourKeyFigureResult [date=" + date + ", keyFigures=" + keyFigures + "]";
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}

	public final Set<KeyFigureResult> getKeyFigures() {
		return keyFigures;
	}

	public final void setKeyFigures(Set<KeyFigureResult> keyFigures) {
		this.keyFigures = keyFigures;
	}


}
