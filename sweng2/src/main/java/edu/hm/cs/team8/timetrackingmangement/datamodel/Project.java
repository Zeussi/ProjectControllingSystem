package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class Project {

	private final String name;

	private final BusinessArea businessArea;

	public Project(final String name, final BusinessArea businessArea) {
		this.name = name;
		this.businessArea = businessArea;
	}

	public String getName() {
		return name;
	}

	public BusinessArea getBusinessArea() {
		return businessArea;
	}

	@Override
	public String toString() {
		return String.format("Project Name: %s%nBusiness Area Name: %s", name, businessArea.getName());
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || obj.getClass() != getClass())
			return false;

		final Project that = (Project) obj;

		return that.getBusinessArea().equals(getBusinessArea()) && that.getName().equals(getName());

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
