package edu.hm.cs.team8.keyfiguresCalculator.ui;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.FilterFactory;
import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;

public class FilterParser {

	public static IFilter[] parse(Set<FilterTO> to) {
		final Set<IFilter> filters = new HashSet<>();
		for (final FilterTO fto : to) {
			final IFilter filter = FilterFactory.makeFilter(fto.getName(), fto.getValue());

			if (filter == null)
				continue;

			filters.add(filter);

		}
		return filters.toArray(new IFilter[0]);
	}

}
