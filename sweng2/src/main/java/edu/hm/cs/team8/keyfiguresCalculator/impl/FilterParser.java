package edu.hm.cs.team8.keyfiguresCalculator.impl;

import java.util.HashSet;
import java.util.Set;

import edu.hm.cs.team8.filter.FilterFactory;
import edu.hm.cs.team8.filter.IFilter;
import edu.hm.cs.team8.keyfiguresCalculator.to.FilterTO;

public class FilterParser {

	public static IFilter[] parse(FilterTO[] filters) {
		final Set<IFilter> result = new HashSet<>();
		for (final FilterTO fto : filters) {
			final IFilter filter = FilterFactory.makeFilter(fto.getName(),
					fto.getValue());

			if (filter == null)
				continue;

			result.add(filter);

		}
		return result.toArray(new IFilter[0]);
	}

}
