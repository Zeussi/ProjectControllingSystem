package edu.hm.cs.team8.persistence;

import java.util.List;

import edu.hm.cs.team8.persistence.datamodell.Account;
import edu.hm.cs.team8.persistence.datamodell.Area;
import edu.hm.cs.team8.persistence.datamodell.Member;
import edu.hm.cs.team8.persistence.datamodell.Projekt;

public interface DatamodellAccess {

	
	List<Member> getMembers();
	
	List<Account> getAccounts();
	
	List<Area> getAreas();
	
	List<Projekt> getProjekts();
}
