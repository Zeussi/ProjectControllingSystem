package edu.hm.cs.team8.persistence.datamodel.mock;

import java.util.ArrayList;
import java.util.List;

import edu.hm.cs.team8.persistence.DatamodelAccess;
import edu.hm.cs.team8.persistence.datamodel.Account;
import edu.hm.cs.team8.persistence.datamodel.Area;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.datamodel.Projekt;

public class DatamodelAccessMock implements DatamodelAccess {

	@Override
	public List<Member> getMembers() {
		
		final List<Member> members = new ArrayList<>();
		final Member member1 = new Member();
		member1.setName("Andi");
		member1.setLevel(100);
		member1.setmId(1);
		members.add(member1);
		
		return members;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> getAreas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projekt> getProjekts() {
		// TODO Auto-generated method stub
		return null;
	}

}
