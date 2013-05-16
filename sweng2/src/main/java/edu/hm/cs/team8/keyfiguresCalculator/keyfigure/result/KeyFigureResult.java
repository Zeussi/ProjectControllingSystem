package edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;

public class KeyFigureResult {

	private final Object value;
	private final KeyFigureMeasure measure;
	private final KeyFigures key;

	public KeyFigureResult(final KeyFigures key, final KeyFigureMeasure measure, final Object value) {
		this.key = key;
		this.measure = measure;
		this.value = value;

	}

	public Object getValue() {
		return value;
	}

	public KeyFigureMeasure getMeasure() {
		return measure;
	}

	public KeyFigures getKey() {
		return key;
	}

	@Override
	public String toString() {
		return String.format("KeyFigure: %s%nValue: %s %s", getKey().toString(), getValue().toString(), getMeasure()
				.toString());
	}
}
