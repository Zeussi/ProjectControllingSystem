package edu.hm.cs.team8.filter.dto;

import java.util.List;

import edu.hm.cs.team8.filter.to.BookEntryResult;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;

public interface Filter {

	List<BookEntry> apply();

}
