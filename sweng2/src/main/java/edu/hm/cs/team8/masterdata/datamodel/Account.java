package edu.hm.cs.team8.masterdata.datamodel;

public class Account {

	private final String name;

	private final Project project;

	public Account(final String name, final Project project) {
		this.name = name;
		this.project = project;

	}

	public String getName() {
		return name;
	}

	public Project getProject() {
		return project;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;

		final Account that = (Account) obj;

		return that.getName().equals(getName()) && that.getProject().equals(getProject());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return String.format("Account Name: %s%nProjekt Name: %s", getName(), getProject().getName());
	}
}
