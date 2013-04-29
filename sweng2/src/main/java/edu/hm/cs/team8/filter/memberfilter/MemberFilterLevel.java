package edu.hm.cs.team8.filter.memberfilter;

import java.util.List;

import edu.hm.cs.team8.filter.dto.Compare;
import edu.hm.cs.team8.filter.dto.Filter;
import edu.hm.cs.team8.filter.to.BookEntryResult;
import edu.hm.cs.team8.persistence.DatamodelAccess;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.impl.DatamodelAccessImpl;

public class MemberFilterLevel implements Filter {

	private int level;

	private final DatamodelAccess dataAccess = new DatamodelAccessImpl();

	private final Compare compare;

	public MemberFilterLevel(int level, final Compare compare) {
		this.level = level;
		this.compare = compare;

	}

	@Override
	public List<BookEntry> apply() {
		final List<BookEntry> entries = dataAccess.getBookEntries();

		for (int index = 0; index < entries.size(); index++) {

			final Member entry = entries.get(index).getMember();

			if (entry.getLevel() - level != compare.getState())
				entries.remove(index);
		}

		return entries;
	}

}
