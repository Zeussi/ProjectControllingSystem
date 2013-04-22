package edu.hm.cs.team8.persistence;

import java.util.List;

import edu.hm.cs.team8.persistence.datamodel.Account;
import edu.hm.cs.team8.persistence.datamodel.Area;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.datamodel.Projekt;

public interface DatamodelAccess {

	
	List<Member> getMembers();
	
	List<Account> getAccounts();
	
	List<Area> getAreas();
	
	List<Projekt> getProjekts();
	
	List<BookEntry> getBookEntries();
}
