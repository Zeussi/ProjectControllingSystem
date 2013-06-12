package edu.hm.cs.team8.keyfiguresCalculator.keyfigure;

public class KeyFigureResult {

	private final KeyFigures keyFigureName;
	private final Object value;

	public KeyFigureResult(final KeyFigures key, final Object value) {
		this.keyFigureName = key;
		this.value = value;

	}

	public KeyFigures getKey() {
		return keyFigureName;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "KeyFigureResult [keyFigureName=" + keyFigureName + ", value="
				+ value + "]";
	}

}
