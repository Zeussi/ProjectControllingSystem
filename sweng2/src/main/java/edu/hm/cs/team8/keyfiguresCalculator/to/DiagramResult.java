package edu.hm.cs.team8.keyfiguresCalculator.to;

import java.util.ArrayList;
import java.util.List;

public class DiagramResult {

	private String labelX;

	private String labelY;

	public String getLabelX() {
		return labelX;
	}

	public void setLabelX(String labelX) {
		this.labelX = labelX;
	}

	public String getLabelY() {
		return labelY;
	}

	public void setLabelY(String labelY) {
		this.labelY = labelY;
	}

	public List<String> getValuesX() {
		return valuesX;
	}

	public void setValuesX(List<String> valuesX) {
		this.valuesX = valuesX;
	}

	public List<String> getValuesY() {
		return valuesY;
	}

	public void setValuesY(List<String> valuesY) {
		this.valuesY = valuesY;
	}

	private List<String> valuesX = new ArrayList<>();
	private List<String> valuesY = new ArrayList<>();

	public DiagramResult() {
	}

	public void addXandYValue(String x, String y) {
		valuesX.add(x);
		valuesY.add(y);
	}

}
