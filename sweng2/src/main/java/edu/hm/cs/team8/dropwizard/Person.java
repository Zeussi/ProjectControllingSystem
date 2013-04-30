package edu.hm.cs.team8.dropwizard;

public class Person {

	private final String name;

	public Person(final String name) {
		this.name = name;
	}

	public String[] getName() {
		return new String[] { name, name} ;
	}
}