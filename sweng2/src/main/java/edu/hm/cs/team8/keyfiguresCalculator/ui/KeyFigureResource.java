package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.filter.impl.FilterFactory;
import edu.hm.cs.team8.filter.impl.mockfilter.MockFilter;
import edu.hm.cs.team8.keyfiguresCalculator.IKeyFiguresCalculator;
import edu.hm.cs.team8.keyfiguresCalculator.impl.KeyFiguresCalculatorImpl;
import edu.hm.cs.team8.keyfiguresCalculator.keyfigure.result.KeyFigureResult;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;

@Path("/keyfigure-calculator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KeyFigureResource {

	private final Handle handle;

	public KeyFigureResource(final Handle handle) {
		this.handle = handle;

	}

	@POST
	public Set<KeyFigureResult> calculateOnylFigures(@Valid final Set<FilterTO> to) {

		final IKeyFiguresCalculator calc = new KeyFiguresCalculatorImpl();

		final Map<Class<? extends IFilter>, Set<IFilter>> filters = new HashMap<>();

		for (final FilterTO fto : to) {
			final IFilter filter = FilterFactory.makeFilter(fto.getName(), fto.getValue(), handle);

			if (filter == null)
				continue;

			Set<IFilter> f = filters.get(filter.getClass());
			if (f == null)
				f = new HashSet<>();

			f.add(filter);
			filters.put(filter.getClass(), f);

		}

		// TODO Echter Filter
		return calc.calculateFigures(handle, new MockFilter(handle));

	}
}
