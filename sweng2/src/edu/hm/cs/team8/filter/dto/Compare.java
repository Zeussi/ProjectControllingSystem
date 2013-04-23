package edu.hm.cs.team8.filter.dto;

public enum Compare {

	EQUALS(0), LESS(-1), MORE(1);

	private final int state;

	private Compare(int state) {
		this.state = state;

	}

	public int getState() {
		return state;
	}

}
