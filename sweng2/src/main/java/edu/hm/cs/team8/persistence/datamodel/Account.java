package edu.hm.cs.team8.persistence.datamodel;

public class Account {

	private String name;
	
	private Projekt project;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Projekt getProject() {
		return project;
	}

	public void setProject(Projekt project) {
		this.project = project;
	}
}
