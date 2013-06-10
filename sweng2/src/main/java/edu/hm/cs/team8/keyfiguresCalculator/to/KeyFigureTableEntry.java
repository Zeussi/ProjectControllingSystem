package edu.hm.cs.team8.keyfiguresCalculator.to;

public class KeyFigureTableEntry {

	private String keyFigure;
	private String keyFigureValue;

	public String getKeyFigure() {
		return keyFigure;
	}

	public KeyFigureTableEntry() {
	}

	public void setKeyFigure(String keyFigure) {
		this.keyFigure = keyFigure;
	}

	public String getKeyFigureValue() {
		return keyFigureValue;
	}

	public void setKeyFigureValue(String keyFigureValue) {
		this.keyFigureValue = keyFigureValue;
	}

	@Override
	public String toString() {
		return "TableEntry [keyFigure=" + keyFigure + ", keyFigureValue="
				+ keyFigureValue + "]";
	}

	public KeyFigureTableEntry(String keyFigure, String keyFigureValue) {
		super();
		this.keyFigure = keyFigure;
		this.keyFigureValue = keyFigureValue;
	}

}
