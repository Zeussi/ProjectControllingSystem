package edu.hm.cs.team8.masterdata.impl;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.masterdata.config.DBConfig;
import edu.hm.cs.team8.masterdata.dao.AccountDAO;
import edu.hm.cs.team8.masterdata.dao.BusinessAreaDAO;
import edu.hm.cs.team8.masterdata.dao.MemberDAO;
import edu.hm.cs.team8.masterdata.dao.ProjectDAO;

public class MasterDataImpl implements IMasterData {

	// private static final String getMembersQuery =
	// "Select MID, mitarbeiter, entwicklungsstufe from BI group by MID, mitarbeiter, entwicklungsstufe";
	//
	// private static final String getAccountsQuery =
	// "select Konto from BI group by Konto";
	//
	// private static final String getAreasQuery =
	// "select Bereich from BI group by Bereich";
	//
	// private static final String getProjectsQuery =
	// "select Projekt from BI group by Projekt";
	//
	// private static final String getBookEntriesQuery =
	// "select MID, Stunden, Monat, Konto, fakturierbar, Grenzkosten, Verrechnungssatz from BI";

	private final Handle handle;

	public MasterDataImpl() throws ClassNotFoundException {

		Class.forName(DBConfig.driverClass);

		final DBI dbi = new DBI(DBConfig.url, DBConfig.user, DBConfig.password);

		this.handle = dbi.open();
	}

	@Override
	public MemberDAO getMemberDAO() {

		return new MemberDAO(handle);
	}

	@Override
	public AccountDAO getAccountDAO() {

		return new AccountDAO(handle);
	}

	@Override
	public BusinessAreaDAO getBusinessAreaDAO() {

		return new BusinessAreaDAO(handle);
	}

	@Override
	public ProjectDAO getProjectDAO() {
		return new ProjectDAO(handle);
	}

}
