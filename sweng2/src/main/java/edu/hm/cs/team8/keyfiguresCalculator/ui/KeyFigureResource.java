package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.impl.mockfilter.MockFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;

@Path("/keyfigure-calculator")
@Produces(MediaType.APPLICATION_JSON)
public class KeyFigureResource {

	private final Handle handle;

	public KeyFigureResource(final Handle handle) {
		this.handle = handle;

	}

	@GET
	public Set<KeyFigureResult> getMasterData() {
		
		final IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();
		
		// TODO Echter Filter
		return calc.calculateFigures(handle, new MockFilter(handle));

	}

}
