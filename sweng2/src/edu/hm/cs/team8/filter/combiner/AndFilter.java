package edu.hm.cs.team8.filter.combiner;

import java.util.ArrayList;
import java.util.List;

import edu.hm.cs.team8.filter.dto.Filter;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;

public class AndFilter implements Filter {

	private final Filter first;
	private final Filter second;

	public AndFilter(final Filter first, final Filter second) {
		this.first = first;
		this.second = second;

	}

	@Override
	public List<BookEntry> apply() {

		final List<BookEntry> entriesFirst = first.apply();
		final List<BookEntry> entriesSecond = second.apply();

		final List<BookEntry> result = new ArrayList<>();

		for (final BookEntry entry : entriesFirst)
			if (entriesSecond.contains(entry))
				result.add(entry);

		return result;
	}

}
