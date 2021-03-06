package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;
import edu.hm.cs.team8.keyfiguresCalculator.to.KeyFigureTableEntry;

@Path("/only-keyfigures")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OnlyKeyFiguresResource {

	private IKeyFiguresCalculator calc;

	public OnlyKeyFiguresResource(IKeyFiguresCalculator calc) {
		this.calc = calc;
	}

	@POST
	public Set<KeyFigureTableEntry> calculateOnylFigures(
			@Valid final Set<FilterTO> to) {

		return calc.calculateOnlyFigures(to.toArray(new FilterTO[0]));

	}
}
