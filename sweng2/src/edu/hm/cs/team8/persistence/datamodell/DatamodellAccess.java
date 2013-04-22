package edu.hm.cs.team8.persistence.datamodell;

import java.util.List;

public interface DatamodellAccess {

	
	List<Member> getMembers();
	
	List<Account> getAccounts();
	
	List<Area> getAreas();
	
	List<Projekt> getProjekts();
}
