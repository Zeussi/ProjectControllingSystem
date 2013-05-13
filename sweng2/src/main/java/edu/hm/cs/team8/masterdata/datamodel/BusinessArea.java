package edu.hm.cs.team8.masterdata.datamodel;

public class BusinessArea {

	private final String name;

	public BusinessArea(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Business Area Name: %s", name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		final BusinessArea that = (BusinessArea) obj;

		return that.getName().equals(getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
