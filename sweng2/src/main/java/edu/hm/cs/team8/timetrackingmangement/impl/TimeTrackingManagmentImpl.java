package edu.hm.cs.team8.timetrackingmangement.impl;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import edu.hm.cs.team8.masterdata.IMasterData;
import edu.hm.cs.team8.masterdata.config.DBConfig;
import edu.hm.cs.team8.masterdata.impl.MasterDataImpl;
import edu.hm.cs.team8.timetrackingmangement.ITimeTrackingMangement;
import edu.hm.cs.team8.timetrackingmangement.dao.TimeTrackingDAO;

public class TimeTrackingManagmentImpl implements ITimeTrackingMangement {

	private final Handle handle;

	private final IMasterData masterdata;

	public TimeTrackingManagmentImpl() throws ClassNotFoundException {

		this.masterdata = new MasterDataImpl();

		Class.forName(DBConfig.driverClass);

		final DBI dbi = new DBI(DBConfig.url, DBConfig.user, DBConfig.password);

		this.handle = dbi.open();

	}

	@Override
	public TimeTrackingDAO getTimeTrackingDAO() {
		return new TimeTrackingDAO(handle, masterdata);
	}

}
