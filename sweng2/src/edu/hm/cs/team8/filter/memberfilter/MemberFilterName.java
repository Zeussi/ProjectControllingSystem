package edu.hm.cs.team8.filter.memberfilter;

import java.util.List;

import edu.hm.cs.team8.filter.dto.Compare;
import edu.hm.cs.team8.filter.dto.Filter;
import edu.hm.cs.team8.persistence.DatamodelAccess;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.impl.DatamodelAccessImpl;

public class MemberFilterName implements Filter {

	private final DatamodelAccess dataAccess = new DatamodelAccessImpl();

	private final String name;

	private final Compare compare;

	public MemberFilterName(String name, final Compare compare) {
		this.name = name;
		this.compare = compare;

	}

	@Override
	public List<BookEntry> apply() {
		final List<BookEntry> entries = dataAccess.getBookEntries();

		for (int index = 0; index < entries.size(); index++) {

			final Member entry = entries.get(index).getMember();

			if (entry.getName().compareTo(name) != compare.getState())
				entries.remove(index);
		}

		return entries;
	}

}
