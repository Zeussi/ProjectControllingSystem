package edu.hm.cs.team8.ui;

import com.yammer.dropwizard.views.View;

public class PersonView extends View {
	private final Person person;

	public PersonView(Person person) {
		super("person.ftl");
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
}