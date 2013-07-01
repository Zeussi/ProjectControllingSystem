package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.to.DiagramResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;

@Path("/project-behaviour-keyfigures/{keyfigure}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectBehaviourKeyFigureRessource {

	private IKeyFiguresCalculator calc;

	public ProjectBehaviourKeyFigureRessource(IKeyFiguresCalculator calc) {
		this.calc = calc;
	}

	@POST
	public DiagramResult calculateOnylFigures(
			@PathParam("keyfigure") String keyfigure,
			@Valid final Set<FilterTO> to) {

		return calc.calculateProjectBehaviourFigure(keyfigure,
				to.toArray(new FilterTO[0]));

	}
}
