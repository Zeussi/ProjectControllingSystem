package edu.hm.cs.team8.persistence.impl;

import java.util.List;

import edu.hm.cs.team8.persistence.DatamodelAccess;
import edu.hm.cs.team8.persistence.datamodel.Account;
import edu.hm.cs.team8.persistence.datamodel.Area;
import edu.hm.cs.team8.persistence.datamodel.BookEntry;
import edu.hm.cs.team8.persistence.datamodel.Member;
import edu.hm.cs.team8.persistence.datamodel.Projekt;

public class DatamodelAccessImpl implements DatamodelAccess {

	private static final String getMembersQuery = "Select MID, mitarbeiter, entwicklungsstufe from BI group by MID, mitarbeiter, entwicklungsstufe";

	private static final String getAccountsQuery = "select Konto from BI group by Konto";
	
	private static final String getAreasQuery = "select Bereich from BI group by Bereich";
	
	private static final String getProjectsQuery = "select Projekt from BI group by Projekt";
	
	private static final String getBookEntriesQuery = "select MID, Stunden, Monat, Konto, fakturierbar, Grenzkosten, Verrechnungssatz from BI";
	
	@Override
	public List<Member> getMembers() {

		
		return null;
	}

	@Override
	public List<Account> getAccounts() {
		
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

	@Override
	public List<BookEntry> getBookEntries() {
		// TODO Auto-generated method stub
		return null;
	}

}
