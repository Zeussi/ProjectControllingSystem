package edu.hm.cs.team8.keyfiguresCalculator.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagramResult {

	private String labelX;

	private String labelY;

	private Map<String, Double> valuesX = new TreeMap<>();

	public DiagramResult() {
	}

	public void addXandYValue(String x, String y) {
		valuesX.put(x, Double.parseDouble(y));
	}

	public String getLabelX() {
		return labelX;
	}

	public String getLabelY() {
		return labelY;
	}

	public List<String> getValuesX() {
		return new ArrayList<>(valuesX.keySet());
	}

	public List<Double> getValuesY() {
		return new ArrayList<>(valuesX.values());
	}

	public void setLabelX(String labelX) {
		this.labelX = labelX;
	}

	public void setLabelY(String labelY) {
		this.labelY = labelY;
	}

	@Override
	public String toString() {
		return "DiagramResult [labelX=" + labelX + ", labelY=" + labelY
				+ ", valuesX=" + valuesX + "]";
	}

}
