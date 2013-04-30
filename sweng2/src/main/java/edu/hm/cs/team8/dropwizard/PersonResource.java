package edu.hm.cs.team8.dropwizard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/people/{id}")
@Produces(MediaType.TEXT_HTML)
public class PersonResource {

	public PersonResource() {
	}

	@GET
	public PersonView getPerson() {
		return new PersonView(new Person("abc")); 	
	}
}