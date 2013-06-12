package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

public enum KeyFigures {

	BILLABLE_PERFORMANCE(KeyFigureMeasure.COSTS), PERFORMANCE(
			KeyFigureMeasure.COSTS), WORKLOAD(KeyFigureMeasure.COSTS), RETURN(
			KeyFigureMeasure.COSTS), PERFORMANCE_RETURN(KeyFigureMeasure.COSTS), ILL(
			KeyFigureMeasure.COSTS), COST(KeyFigureMeasure.COSTS);

	public static KeyFigures parseKeyFigure(String name) {
		return KeyFigures.valueOf(name);
	}

	private final KeyFigureMeasure measure;

	private KeyFigures(KeyFigureMeasure measure) {
		this.measure = measure;
	}

	public KeyFigureMeasure getMeasure() {
		return measure;
	}
}
