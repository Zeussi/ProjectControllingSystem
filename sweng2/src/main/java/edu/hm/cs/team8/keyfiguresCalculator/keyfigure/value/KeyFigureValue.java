package edu.hm.cs.team8.keyfiguresCalculator.keyfigure.value;

public class KeyFigureValue {

	private final Object value;
	private final KeyFigureMeasure measure;

	public KeyFigureValue(final Object value, final KeyFigureMeasure measure) {
		this.value = value;
		this.measure = measure;
	}

	public Object getValue() {
		return value;
	}

	public KeyFigureMeasure getMeasure() {
		return measure;
	}

	@Override
	public String toString() {
		return String.format("%s %s", value, measure);
	}

}
