package edu.hm.cs.team8.dropwizard;

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