package edu.hm.cs.team8.filter;

import java.util.List;

import edu.hm.cs.team8.filter.dto.Filter;
import edu.hm.cs.team8.filter.to.BookEntryResult;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;

public interface Filterlogic {

	public List<BookEntryResult> filter(final Filter filter);
}
