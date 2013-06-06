package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;

@Path("/time-behaviour-keyfiugres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeBehaviourKeyFiguresResource {

	private IKeyFiguresCalculator calc;

	public TimeBehaviourKeyFiguresResource(IKeyFiguresCalculator calc) {
		this.calc = calc;
	}

	@POST
	public Set<KeyFigureResult> calculateOnylFigures(@Valid final Set<FilterTO> to) {

		return calc.calculateTimeBehaviourFigures(FilterParser.parse(to));

	}
}
