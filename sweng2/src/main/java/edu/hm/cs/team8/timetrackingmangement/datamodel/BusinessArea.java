package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class BusinessArea {

	private final String name;

	public BusinessArea(final String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		final BusinessArea that = (BusinessArea) obj;

		return that.getName().equals(getName());
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return String.format("Business Area Name: %s", name);
	}

}
