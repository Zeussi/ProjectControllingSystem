package edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result;

import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.KeyFigures;

public class KeyFigureResult {

	private final KeyFigures keyFigureName;
	private final KeyFigureMeasure measure;
	private final Object value;

	public KeyFigureResult(final KeyFigures key, final KeyFigureMeasure measure, final Object value) {
		this.keyFigureName = key;
		this.measure = measure;
		this.value = value;

	}

	public KeyFigures getKey() {
		return keyFigureName;
	}

	public KeyFigureMeasure getMeasure() {
		return measure;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("KeyFigure: %s%nValue: %s %s", getKey().toString(), getValue().toString(), getMeasure()
				.toString());
	}
}
