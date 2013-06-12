package edu.hm.cs.team8.timetrackingmangement.datamodel;

public class Project {

	private final BusinessArea businessArea;

	private final String name;

	public Project(final String name, final BusinessArea businessArea) {
		this.name = name;
		this.businessArea = businessArea;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || obj.getClass() != getClass())
			return false;

		final Project that = (Project) obj;

		return that.getBusinessArea().equals(getBusinessArea())
				&& that.getName().equals(getName());

	}

	public BusinessArea getBusinessArea() {
		return businessArea;
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
		return String.format("Project Name: %s%nBusiness Area Name: %s", name,
				businessArea.getName());
	}

}
